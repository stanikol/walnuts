package models.images

import java.io.ByteArrayInputStream
import javax.inject.Inject

import com.google.inject.Singleton
import models.goods.{ BindingImageCategory, Category }
import models.images.ImageTableDef._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.{ JsValue, Json }
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future
import com.sksamuel.scrimage.{ Image => ScrImage }
import slick.dbio.DBIOAction
/**
 * Created by snc on 2/25/17.
 */
@Singleton
class ImagesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider, imageCategoriesDAO: ImageCategoriesDAO) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db

  import dbConfig.driver.api._

  def insertOrUpdateImage(image: Image, albumIDsOpt: Option[Seq[Int]], bytes: Option[Array[Byte]]) = {
    val upsertImage = images.insertOrUpdate(image)
    val upsertAlbums = albumIDsOpt.map { albumIDs =>
      bindingImageCategory.filter(_.imageName === image.name).delete.flatMap { _ =>
        bindingImageCategory ++= albumIDs.map(albumID => BindingImageCategory(image.name, albumID))
      }
    }
    val upsertBytes = bytes.map { bytes =>
      imageBytes.insertOrUpdate(ImageBytes(image.name, bytes)).flatMap { _ =>
        val thumbnails = ScrImage.fromStream(new ByteArrayInputStream(bytes)).scaleTo(150, 150).bytes
        thumbnailBytes.insertOrUpdate(ImageBytes(image.name, thumbnails))
      }
    }
    val allQueries = upsertImage :: (List(upsertAlbums, upsertBytes).flatten)
    db.run(DBIOAction.seq(allQueries: _*).transactionally)

  }

  def getImage(name: String): Future[Option[ImageBytes]] = {
    Logger.debug(s"ImagesDAO.getImage => Getting from DB image `$name` ...")
    if (name.nonEmpty)
      db.run(imageBytes.filter(_.imageName === name).result.headOption).recover {
        case exception =>
          Logger.error(s"ImagesDAO.getImage => Ошибка БД при получении изображения `$name`! ${exception.getMessage}")
          None
      }
    else
      Future(None)
  }

  def getImageInfo(name: String): Future[Option[ImageInfo]] = {
    Logger.debug(s"ImagesDAO.getImageInfo => Getting from DB image `$name` ...")
    if (name.nonEmpty)
      db.run(imageInfos.filter(_.name === name).result.headOption).recover {
        case exception =>
          Logger.error(s"ImagesDAO.getImageInfo => Ошибка БД при получении изображения `$name`! ${exception.getMessage}")
          None
      }
    else
      Future(None)
  }

  def getThumb(name: String): Future[Option[ImageBytes]] = {
    Logger.debug(s"ImagesDAO.getThumb => Getting from DB image `$name` ...")
    if (name.nonEmpty)
      db.run(thumbnailBytes.filter(_.imageName === name).result.headOption).recover {
        case exception =>
          Logger.error(s"ImagesDAO.getThumb => Ошибка БД при получении изображения `$name`! ${exception.getMessage}")
          None
      }
    else
      Future(None)
  }

  def findImages(search: String, what: String): Future[Seq[ImageInfo]] = {
    Logger.debug(s"ImagesDAO.findImages => Searching images '$what' for '$search'...")
    listAllImageInfo.map(_.filter(ii =>
      ii.name.contains(search) || ii.categories.contains(search) || search.isEmpty || search.equals("%")))
  }

  def listAllImageInfoJSON: Future[JsValue] = {
    listAllImageInfo.map(Json.toJson(_))
  }

  def listAllImageInfo: Future[Seq[ImageInfo]] = {
    db.run(imageInfos.result)
  }

  def listAllGalleries: Future[Map[String, Seq[ImageInfo]]] = {
    db.run(imageInfos.filter(_.categories.nonEmpty).result).flatMap { imageInfoSeq: Seq[ImageInfo] =>
      val imagesWithAlbums: Seq[ImageInfoWithAlbums] =
        imageInfoSeq.filter(_.categories.isDefined).map(ImageInfoWithAlbums(_))
      val albumIDs: Set[Int] = imagesWithAlbums.map(_.categories.map(_._1)).flatten.toSet
      db.run(albums.sortBy(_.sortOrder).result).map { albumSeq: Seq[Category] =>
        albumSeq.filter(a => albumIDs.contains(a.id.get)).map { a: Category =>
          a.name -> imagesWithAlbums.filter(_.categories.map(_._1).contains(a.id.get)).map(ia => ImageInfo.apply(ia))
        }.toMap
      }
    }
  }

  def deleteImage(name: String) =
    db.run(images.filter(img => img.name === name).delete)

}
