package controllers.images

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.goods.Category
import FormsData._
import models.images.ImageCategoriesDAO
//import models.images.ImageCategoriesDAO
import models.images.{ Image, ImageInfo, ImagesDAO }
import play.api.Logger
import play.api.cache.CacheApi
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.libs.Files
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration.Duration

class Images @Inject() (
  //  db: models.blog.DBService,
  imagesDAO: ImagesDAO,
  imageCategoriesDAO: ImageCategoriesDAO,
  //  cached: Cached,
  //  cacheMan: CacheManager,
  cacheApi: CacheApi,
  silhouette: Silhouette[DefaultEnv],
  val messagesApi: MessagesApi,
  implicit val webJarAssets: WebJarAssets
)
    extends Controller with I18nSupport {
  //  import imagesDAO._

  /**
   * Shows AdminImageForm.
   * @return
   */
  def showAdminImageForm(name: String = "") = silhouette.SecuredAction(Roles.Admin).async { implicit request =>

    imagesDAO.getImage(name).flatMap { imageOpt: Option[Image] =>
      imageCategoriesDAO.listCategories.flatMap { allCategories: Seq[Category] =>
        imageCategoriesDAO.getImageCategoryIDs(name).map { imageCategoryIDs: Seq[Int] =>
          Ok(views.html.images.adminImages(
            request.identity,
            Seq.empty,
            adminImageForm.fill(
              if (imageOpt.isEmpty) AdminImage.empty.copy(name = name)
              else AdminImage.empty.copy(
                name = imageOpt.get.name,
                content = imageOpt.get.content,
                albums = if (imageCategoryIDs.nonEmpty) Some(imageCategoryIDs) else None
              )
            ),
            allCategories
          ))
        }
      }
    }
  }

  def handleAdminImageForm = silhouette.SecuredAction(Roles.Admin).async(parse.multipartFormData) { implicit request =>
    adminImageForm.bindFromRequest().fold(
      { withErrors =>
        Logger.error(s"handleAdminImageForm=> Bad form data ${withErrors.errors.mkString("; ")}")
        Future(Redirect(controllers.images.routes.Images.showAdminImageForm(withErrors.data.getOrElse("name", "")))
          .flashing("error" -> s"Инвалидные данные $withErrors"))
      },
      { ok =>
        ok.action match {
          case "save" =>
            val image: Image = request.body.file("new-image") match {
              case Some(pic: MultipartFormData.FilePart[Files.TemporaryFile]) =>
                Image.readImageFromFile(pic.ref.file, ok.name, ok.content, ok.resizeTo)
              case None =>
                Image(ok.name, ok.content, None, None)
            }
            imagesDAO.upsertImage(image, ok.albums).map { res =>
              val msg: String = s"Сохранено в БД: $image. Альбомы: ${ok.albums}"
              Logger.info(msg)
              cacheApi.remove(imageCacheKey(ok.name))
              cacheApi.remove(thumbnailCacheKey(ok.name))
              Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("success" -> msg)
            }
          case "search" if ok.find._1.nonEmpty && ok.find._2.nonEmpty =>
            imagesDAO.getImage(ok.name).flatMap { imageOpt: Option[Image] =>
              (imagesDAO.findImages _).tupled(ok.find).flatMap { foundImages: Seq[ImageInfo] =>
                imageCategoriesDAO.listCategories.map { imagesCategories: Seq[Category] =>
                  val form = adminImageForm.fill(ok)
                  Ok(views.html.images.adminImages(
                    request.identity,
                    foundImages,
                    form,
                    imagesCategories
                  ))
                }
              }
            }
          case "delete" =>
            imagesDAO.deleteImage(ok.name).map { _ =>
              cacheApi.remove(s"img/${ok.name}")
              Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("success" -> s"${ok.name} удален !")
            }
          case unknownAction =>
            Logger.error(s"handleAdminImageForm=> unknownAction. Submitted form is " + ok)
            Future(Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("error" -> s"Неизвестная комманда $unknownAction"))
        }
      }
    )
  }

  private def imageCacheKey(name: String) = s"/img/${name}"

  private def thumbnailCacheKey(name: String) = s"/150x150/${name}"
  /**
   * Download file from DB.
   * @param name - name of an image to download
   * @return Image bytes as `BINARY`
   */
  def getImage(name: String) = Action.async { _ =>
    getImageBytes(name, imageCacheKey _, i => i.bytes.getOrElse(Array.empty))
      .map(Ok(_).as(BINARY))

  }

  def getThumbnail(name: String) = Action.async { _ =>
    getImageBytes(name, thumbnailCacheKey _, i => i.bytes150x150.getOrElse(Array.empty))
      .map(Ok(_).as(BINARY))
  }

  private def getImageBytes(
    name: String,
    getCacheKey: String => String,
    getBytesArrayFromImage: Image => Array[Byte]
  ): Future[Array[Byte]] = {
    val cacheKey: String = getCacheKey(name)
    cacheApi.get[Array[Byte]](cacheKey) match {
      case Some(imageBytes) => Future.successful(imageBytes)
      case None => imagesDAO.getImage(name).map {
        case Some(image) if image.bytes.isDefined =>
          Logger.warn(s"Adding to cache key: $cacheKey")
          val bytes = image.bytes.get
          cacheApi.set(cacheKey, bytes)
          getBytesArrayFromImage(image)
        case _ => Array.empty[Byte]
      }
    }
  }

  def jsonAllImageInfo = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    imagesDAO.listAllImageInfoJSON.map { imagesAsJson =>
      Ok(imagesAsJson)
    }
  }

  def showGallery = silhouette.UserAwareAction.async { implicit request =>
    imagesDAO.listAllImageInfo.map { images =>
      Ok(views.html.images.showGallery(request.identity, images))
      //      Ok(views.html.images.showGallery2(request.identity, images))
    }
  }

}
