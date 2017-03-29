package controllers.nuts

import java.io.{ BufferedInputStream, FileInputStream }
import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import com.sksamuel.scrimage.{ Image => Img }
import controllers.WebJarAssets
import models.nuts.Data.{ Image, ImageInfo }
import models.nuts.FormsData._
//import models.nuts.Tables._
import net.sf.ehcache.CacheManager
import play.api.Logger
import play.api.cache.Cached
import play.api.data._
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
//import play.api.libs.json._
//import play.api.libs.functional.syntax._
//import slick.driver.PostgresDriver.api._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future
import scala.util.Try

class Images @Inject() (
  //  db: models.nuts.DBService,
  imagesDAO: models.nuts.ImagesDAO,
  cached: Cached,
  cacheMan: CacheManager,
  silhouette: Silhouette[DefaultEnv],
  val messagesApi: MessagesApi,
  implicit val webJarAssets: WebJarAssets
)
    extends Controller with I18nSupport {
  import imagesDAO._

  /**
   * Save and resize image name. Uses `saveImageForm` as input params.
   * @return Redirect with result message
   */
  def save() = silhouette.SecuredAction(Roles.Admin).async(parse.multipartFormData) { implicit request =>
    val saveImageFormData: Form[SaveImage] = saveImageForm.bindFromRequest().fold(
      withErrors => withErrors,
      ok => saveImageForm.fill(ok)
    )
    val resizeTo: Option[(Int, Int)] = Try((
      saveImageFormData("height").value.get.toInt,
      saveImageFormData("width").value.get.toInt
    )).toOption
    Logger.info(s"Received request to save image to DB with params: ${request.body.asFormUrlEncoded}")
    Try {
      if (saveImageFormData.hasErrors) throw new Exception(Messages("images.errors-in-form"))
      val result: Future[Result] =
        request.body.file("new-image").map { picture =>
          //        val filename = if (saveImageFormData("name").value.isDefined) saveImageFormData("name").value.get else picture.filename
          val filename = saveImageFormData("name").value.get
          val contentType = picture.contentType.getOrElse(BINARY)
          val newImage = Image(
            filename,
            saveImageFormData("content").value.get,
            resizeTo match {
              case Some((height, width)) =>
                val uploadedImage = Img.fromFile(picture.ref.file)
                val resizedImage = uploadedImage.scaleTo(height, width)
                Logger.info(s"Image was resized. New metadata is ${resizedImage.metadata.directories.mkString("; ")}")
                resizedImage.bytes
              case _ =>
                val bis = new BufferedInputStream(new FileInputStream(picture.ref.file))
                Stream.continually(bis.read).takeWhile(_ != -1).map(_.toByte).toArray
            }
          )
          addNewImage(newImage).map { res =>
            val msg: String =
              "%s (%s) was saved to DB%s".format(filename, contentType, resizeTo.map { case (h, w) => s" and resized to $h x $w." }.getOrElse("."))
            Logger.info(msg)
            cacheMan.clearAll()
            Redirect(controllers.nuts.routes.Images.show()).flashing("success" -> msg)
          }
        }.get
      result
    }.recover {
      case error: Throwable =>
        val errorResult: Future[Result] = Future(Redirect(controllers.nuts.routes.Images.show()).flashing("error" -> error.getMessage))
        errorResult
    }.get
  }

  /**
   * Download file from DB.
   * @param name - name of an image to download
   * @return Image bytes as `BINARY`
   */
  def get(name: String) = cached(s"img/$name") {
    Action.async { _ =>
      //      db.runAsync(images.filter(_.name === name).result.headOption).map {
      getImage(name).map {
        case Some(Image(_, _, bytes)) =>
          Ok(bytes).as(BINARY)
        case _ =>
          val msq = s"\nError while getting image `$name`.\n"
          Logger.error(msq)
          BadRequest(Array.empty[Byte]).as("image/jpg")
      }
    }
  }

  private val badEditImageResult = { badData: String =>
    Future(Redirect(controllers.nuts.routes.Images.show()).flashing("error" -> Messages("images.invalidForm", badData)))
  }

  /**
   * Edit image in DB. What image to change is defined in `imageEditForm`
   * @return Redirect to `Images.show`
   */
  def edit() = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    imageEditForm.bindFromRequest().fold(
      errorForm => {
        Logger.error(Messages("images.invalidForm", errorForm))
        badEditImageResult(errorForm.data.toString)
      },
      imageEditForm => {
        if (imageEditForm.action == Messages("images.rename") && imageEditForm.rename.nonEmpty) {
          Logger.info(s"Renaming image from ${imageEditForm.imageChecked} to ${imageEditForm.rename} ...")
          updateImage(
            imageEditForm.imageChecked,
            imageEditForm.rename,
            imageEditForm.rename
          ).map(result => Redirect(controllers.nuts.routes.Images.show())
            .flashing("success" -> s"Image '${imageEditForm.what}' of '${imageEditForm.imageChecked}' was renamed to '${imageEditForm.rename}'."))
        } else if (imageEditForm.action == Messages("images.delete")) {
          cacheMan.clearAll()
          //          db.runAsync(images.filter(img => img.name === imageEditForm.imageChecked).delete)
          deleteImage(imageEditForm.imageChecked).map { result =>
            val msg = Messages("images.deleteMsg", imageEditForm.imageChecked)
            Logger.info(msg)
            Redirect(controllers.nuts.routes.Images.show()).flashing("success" -> msg)
          }
        } else
          badEditImageResult("")
      }
    )
  }

  /**
   * Shows form for image downloading `saveImageForm` along with search images form `findImagesForm`
   * and form for altering images `imageEditForm`. Shortly displays `views.html.images.editImages`.
   * @param search  Search string.
   * @param what Criteria for search. Must be either `name` or `content`.
   * @return displays `views.html.images.editImages`
   */
  def show(search: String = "", what: String = "") = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    if (search.isEmpty && what.isEmpty) {
      Future(Ok(views.html.images.editImages(
        request.identity,
        Seq.empty,
        saveImageForm.fill(SaveImage.empty),
        findImagesForm.fill(FindImages.empty)
      )))
    } else {
      findImages(search, what).map { images =>
        val findImages =
          if (search.nonEmpty && what.nonEmpty) FindImages(search, what)
          else FindImages.empty
        Ok(views.html.images.editImages(
          request.identity,
          images.map(ImageInfo.apply _),
          saveImageForm.fill(SaveImage.empty),
          findImagesForm.fill(findImages)
        ))
      }
    }
  }

  /**
   * Binds `findImagesForm` from request and redirects to `show`.
   * Used as action handler for `findImagesForm` which displayed by `show`.
   * @return Redirect to `show` or displays `views.html.images.editImages` with errors.
   */
  def find = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    findImagesForm.bindFromRequest().fold(
      error => Future(BadRequest(views.html.images.editImages(
        request.identity,
        Seq.empty,
        saveImageForm.fill(SaveImage.empty),
        error
      ))),
      ok => Future(Redirect(routes.Images.show(ok.search, ok.what)))
    )
  }

  def list = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    listAllImageInfo.map { imagesAsJson =>
      Ok(imagesAsJson)
    }
  }

}
