package models.images

import javax.inject.Inject

import com.google.inject.Singleton
import models.goods.BindingImageCategory
import models.images.ImageTableDef._
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.{ JsValue, Json }
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future
/**
 * Created by snc on 2/25/17.
 */
@Singleton
class ImagesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider, imageCategoriesDAO: ImageCategoriesDAO) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db

  import dbConfig.driver.api._

  def upsertImage(image: Image, imageCategoryIDs: Option[Seq[Int]]): Future[Unit] = {
    db.run(images.filter(_.name === image.name).result.headOption).map {
      case Some(foundImage) if image.bytes.isEmpty =>
        Logger.info(s"ImagesDAO.upsertImage=> updating image info. Image size in DB = ${foundImage.bytes.map(_.length).getOrElse(0)}")
        val bytes = if (image.bytes.isEmpty) foundImage.bytes else image.bytes
        val thumbnailBytes = if (image.bytes.isEmpty) foundImage.bytes150x150 else image.bytes150x150
        images.insertOrUpdate(image.copy(bytes = bytes, bytes150x150 = thumbnailBytes))
      case _ =>
        Logger.info(s"ImagesDAO.upsertImage=> updating image info. Image size in DB = 0")
        images.insertOrUpdate(image)
    }.map { query =>
      db.run((query.flatMap { _ =>
        bindingImageCategory.filter(_.imageName === image.name).delete.flatMap { _ =>
          val bindings: Seq[BindingImageCategory] =
            imageCategoryIDs.getOrElse(Seq.empty).map(BindingImageCategory(image.name, _))
          bindingImageCategory ++= bindings
        }
      }).transactionally)
    }
  }

  def getImage(name: String): Future[Option[Image]] = {
    Logger.info(s"ImagesDAO.getImage => Getting from DB image `$name` ...")
    if (name.nonEmpty)
      db.run(images.filter(_.name === name).result.headOption).recover {
        case exception =>
          Logger.error(s"ImagesDAO.getImage => Ошибка БД при получении изображения `$name`! ${exception.getMessage}")
          None
      }
    else
      Future(None)
  }

  def findImages(search: String, what: String): Future[Seq[ImageInfo]] = {
    Logger.info(s"ImagesDAO.findImages => Searching images '$what' for '$search'...")
    listAllImageInfo.map(_.filter(ii =>
      ii.name.contains(search) || ii.categories.contains(search) || search.isEmpty || search.equals("%")))
  }

  def listAllImageInfoJSON: Future[JsValue] = {
    listAllImageInfo.map(Json.toJson(_))
  }

  def listAllImageInfo: Future[Seq[ImageInfo]] = {
    val allBindingsImageCategoryF = imageCategoriesDAO.listAllBindingImageCategory
    db.run(images.map(i => i.name -> i.content).result).flatMap { allImagesNameAndContent =>
      allBindingsImageCategoryF.map { bindings =>
        allImagesNameAndContent.map {
          case (imageName, imageContent) =>
            val imageCategoryIDs: Seq[Int] = bindings.filter(_.imageName == imageName).map(_.categoryID)
            ImageInfo(
              imageName,
              imageContent,
              if (imageCategoryIDs.nonEmpty) Some(imageCategoryIDs) else None
            )
        }
      }
    }
  }

  def deleteImage(name: String) =
    db.run(images.filter(img => img.name === name).delete)

}
