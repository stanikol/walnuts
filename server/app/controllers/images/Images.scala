package controllers.images

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import controllers.images.FormsData._
import models.blog.FormsData.categoryForm
import models.goods.Category
import models.images.{ Image, ImageCategoriesDAO, ImageInfo, ImagesDAO }
import play.api.Logger
import play.api.cache.CacheApi
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future

class Images @Inject() (
  imagesDAO: ImagesDAO,
  imageCategoriesDAO: ImageCategoriesDAO,
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

    imagesDAO.getImageInfo(name).flatMap { imageInfoO: Option[ImageInfo] =>
      imageCategoriesDAO.listCategories.flatMap { allCategories: Seq[Category] =>
        imageCategoriesDAO.getImageCategoryIDs(name).map { imageCategoryIDs: Seq[Int] =>
          Ok(views.html.images.adminImages(
            request.identity,
            Seq.empty,
            adminImageForm.fill(
              if (imageInfoO.isEmpty) AdminImage.empty.copy(name = name)
              else AdminImage.empty.copy(
                name = imageInfoO.get.name,
                content = imageInfoO.get.content,
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
            val imageAndBytesO: Option[(Image, Array[Byte])] = request.body.file("new-image").flatMap { pic =>
              Image.readImageFromFile(pic.ref.file, ok.name, ok.content, ok.resizeTo) match {
                case Right(ok) => Some(ok)
                case Left(error) => None
              }
            }
            imagesDAO.insertOrUpdateImage(Image(ok.name, ok.content), ok.albums, imageAndBytesO.map(_._2)).map { _ =>
              removeFromCache(ok.name)
              Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("success" -> s"${ok.name} изменен !")
            }.recover {
              case error =>
                Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name))
                  .flashing("error" -> s"Ошибка при попытке изменения ${ok.name}! ${error.getMessage}")
            }

          case "search" if ok.find._1.nonEmpty && ok.find._2.nonEmpty =>
            imagesDAO.getImageInfo(ok.name).flatMap { imageOpt: Option[ImageInfo] =>
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
              removeFromCache(ok.name)
              Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("success" -> s"${ok.name} удален !")
            }
          case unknownAction =>
            Logger.error(s"handleAdminImageForm=> unknownAction. Submitted form is " + ok)
            Future(Redirect(controllers.images.routes.Images.showAdminImageForm(ok.name)).flashing("error" -> s"Неизвестная комманда $unknownAction"))
        }
      }
    )
  }

  private def getImageCacheKey(name: String) = s"/img/${name}"

  private def getThumbnailCacheKey(name: String) = s"/150x150/${name}"

  private def removeFromCache(name: String) = {
    cacheApi.remove(getImageCacheKey(name))
    cacheApi.remove(getThumbnailCacheKey(name))
  }
  /**
   * Download file from DB.
   * @param name - name of an image to download
   * @return Image bytes as `BINARY`
   */
  def getImage(name: String) = Action.async { _ =>
    val getImageBytesF = imagesDAO.getImage(name).map(_.map(_.bytes).getOrElse(Array.empty))
    getImageBytes(name, getImageCacheKey _, getImageBytesF)
      .map { bytes =>
        Ok(bytes).as(BINARY)
      }
  }

  def getThumbnail(name: String) = Action.async { _ =>
    val getImageBytesF = imagesDAO.getThumb(name).map(_.map(_.bytes).getOrElse(Array.empty))
    getImageBytes(name, getThumbnailCacheKey _, getImageBytesF)
      .map(bytes => Ok(bytes).as(BINARY))
  }

  private def getImageBytes(
    name: String,
    getCacheKey: String => String,
    imageBytesF: Future[Array[Byte]]
  ): Future[Array[Byte]] = {
    val cacheKey: String = getCacheKey(name)
    cacheApi.get[Array[Byte]](cacheKey) match {
      case Some(imageBytes) => Future.successful(imageBytes)
      case None =>
        imageBytesF.map { bytes: Array[Byte] =>
          if (bytes.nonEmpty) {
            Logger.info(s"Saving to cache ${bytes.length} bytes for key $cacheKey ...")
            cacheApi.set(cacheKey, bytes)
          }
          bytes
        }
    }
  }

  def jsonAllImageInfo = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    imagesDAO.listAllImageInfoJSON.map { imagesAsJson =>
      Ok(imagesAsJson)
    }
  }

  def showGallery(name: String) = silhouette.UserAwareAction.async { implicit request =>
    imagesDAO.listAllGalleries.map { galleries: Map[String, Seq[ImageInfo]] =>
      lazy val allImages = galleries.values.flatten.toSeq
      Ok(views.html.images.showGallery(request.identity, name, galleries))
      //      Ok(views.html.images.showGallery2(request.identity, images))
    }
  }

  // PHOTO ALBUMS CATEGORIES

  def adminAlbumsCategories = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    imageCategoriesDAO.listCategories.map { categories =>
      val submitTo = controllers.images.routes.Images.adminAlbumsCategoriesHandle
      Ok(views.html.adminCategories(request.identity, categories, submitTo))
    }
  }

  def adminAlbumsCategoriesHandle = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    categoryForm.bindFromRequest().fold(
      error => Future(Redirect(controllers.images.routes.Images.adminAlbumsCategories)
        .flashing("error" -> ("Инвалидные данные: " + error.errors.mkString("\n")))),
      categoryEdit => {
        val category = categoryEdit.category
        (categoryEdit.action match {
          case "save" =>
            category.id match {
              case Some(id) =>
                imageCategoriesDAO.upsertCategory(category).map(_ => "ok" -> s"Внесены изменения в БД, категория: $category")
              case None =>
                imageCategoriesDAO.addCategory(category).map(_ => "ok" -> s"Новая категория добавлена в БД: $category")
            }
          case "del" =>
            if (category.id.isDefined)
              imageCategoriesDAO.deleteCategory(category.id.get).map(_ => "ok" -> s"Из БД удалена категория: $category")
            else
              Future("error" -> s"ID катерогии не указан, удаление не возможно !")
        }).map {
          case (status, msg) =>
            Redirect(controllers.images.routes.Images.adminAlbumsCategories).flashing(status -> msg)
        }
      }
    )
  }

}
