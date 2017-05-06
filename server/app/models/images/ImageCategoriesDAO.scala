package models.images

import javax.inject.Inject

import models.goods.{ BindingImageCategory, Category }
import models.images.ImageTableDef.{ albums, bindingImageCategory }
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future

/**
 * Created by snc on 5/7/17.
 */
class ImageCategoriesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db

  import dbConfig.driver.api._

  def listCategories: Future[Seq[Category]] = db.run(albums.sortBy(_.sortOrder).result)

  def deleteCategory(id: Int): Future[Unit] = db.run(albums.filter(_.id === id).delete).map(rowsDeleted =>
    Logger.info(s"Из БД удалено $rowsDeleted запись. Категория id=$id."))

  def addCategory(category: Category): Future[Category] = db.run(albums.returning(albums.map(_.id))
    .into((cat, id) => cat.copy(id = Some(id))) += category)

  def upsertCategory(category: Category): Future[Unit] =
    db.run(albums.filter(_.id === category.id).update(category))
      .map(rowsUpdated => Logger.info(s"В БД обновлена $rowsUpdated запись. $category"))

  def listAllBindingImageCategory: Future[Seq[BindingImageCategory]] =
    db.run(bindingImageCategory.result)

  def getImageCategoryIDs(imageName: String): Future[Seq[Int]] =
    db.run(bindingImageCategory.filter(_.imageName === imageName).map(_.categoryID).result)

  def setBindingsImageCategory(imageName: String, bindings: Seq[BindingImageCategory]) = {
    val name = bindings.map(_.imageName).toSet.toList.head
    assert(bindings.map(_.imageName).toSet.toList.length == 1 && name == imageName)
    val query = bindingImageCategory.filter(_.imageName === imageName).delete.flatMap { _ =>
      bindingImageCategory ++= bindings
    }.transactionally
    db.run(query)
  }
}