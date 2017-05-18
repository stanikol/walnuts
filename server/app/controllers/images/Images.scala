package controllers.images

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.images.{ ImageCategoriesDAO, ImageInfo, ImagesDAO }
import play.api.Logger
import play.api.cache.CacheApi
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.DefaultEnv

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

  private def getImageCacheKey(name: String) = s"/img/${name}"

  private def getThumbnailCacheKey(name: String) = s"/150x150/${name}"

  /**
   * Download file from DB.
   * @param name - name of an image to download
   * @return Image bytes as `BINARY`
   */
  def getImage(name: String) = Action.async { _ =>
    val getImageBytesF = imagesDAO.getImage(name).map(_.map(_.bytes).getOrElse(Array.empty))
    getImageBytesFromCache(name, getImageCacheKey _, getImageBytesF)
      .map { bytes =>
        Ok(bytes).as(BINARY)
      }
  }

  def getThumbnail(name: String) = Action.async { _ =>
    val getImageBytesF = imagesDAO.getThumb(name).map(_.map(_.bytes).getOrElse(Array.empty))
    getImageBytesFromCache(name, getThumbnailCacheKey _, getImageBytesF)
      .map(bytes => Ok(bytes).as(BINARY))
  }

  private def getImageBytesFromCache(
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

  def showGallery(name: String) = silhouette.UserAwareAction.async { implicit request =>
    imagesDAO.listAllGalleries.map { galleries: Map[String, Seq[ImageInfo]] =>
      Ok(views.html.images.showGallery(request.identity, name, galleries))
      //      Ok(views.html.images.showGallery2(request.identity, images))
    }
  }

}
