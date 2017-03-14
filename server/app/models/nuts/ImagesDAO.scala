package models.nuts

import javax.inject.Inject

import com.google.inject.Singleton
import models.nuts.Data.{ Image, ImageInfo }
import models.nuts.Tables.images
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
class ImagesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  //  private val db = dbConfigProvider.get[JdbcProfile].db
  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db

  import dbConfig.driver.api._

  def addNewImage(newImage: Image): Future[Int] =
    db.run(images += newImage)

  def getImage(name: String): Future[Option[Image]] =
    db.run(images.filter(_.name === name).result.headOption)

  def findImages(search: String, what: String): Future[Seq[Image]] = {
    val qry = images.filter { img =>
      if (search.nonEmpty && what == "name")
        img.name.like(search)
      else if (search.nonEmpty && what == "content")
        img.content.like(search)
      else
        LiteralColumn(false)
    }.sortBy(img => if (what == "name") img.name else img.content).result
    Logger.info(s"Searching images with '$what' == '$search'. SQL: '${qry.statements.mkString("; ")}' ...")
    db.run(qry)
  }

  def listAllImageInfo: Future[JsValue] = {
    import ImageInfo.imageInfoJson
    db.run(images.sortBy(_.name).result).map { images =>
      Json.toJson(images.map(i => ImageInfo(i.name, i.content)))
    }
  }

  def updateImage(name: String, rename: String, what: String) =
    db.run {
      val shouldChangeName = what.equals("name")
      images.filter(_.name === name)
        .map(img => if (shouldChangeName) img.name else img.content)
        .update(rename)
    }

  def deleteImage(name: String) =
    db.run(images.filter(img => img.name === name).delete)

}
