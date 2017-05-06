package models.goods

import javax.inject.Inject

import models.goods.GoodsTableDef.categories
import models.CategoriesDAO
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.{ ExecutionContext, Future }

/**
 * Created by snc on 5/7/17.
 */
class GoodsCategoriesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def listCategories: Future[Seq[Category]] = db.run(categories.sortBy(_.sortOrder).result)

  def deleteCategory(id: Int)(implicit ec: ExecutionContext): Future[Unit] = db.run(categories.filter(_.id === id).delete).map(rowsDeleted =>
    Logger.info(s"Из БД удалено $rowsDeleted запись. Категория id=$id."))

  def addCategory(category: Category): Future[Category] = db.run(categories.returning(categories.map(_.id))
    .into((cat, id) => cat.copy(id = Some(id))) += category)

  def upsertCategory(category: Category)(implicit ec: ExecutionContext): Future[Unit] =
    db.run(categories.filter(_.name === category.name).update(category))
      .map(rowsUpdated => Logger.info(s"В БД обновлена $rowsUpdated запись. $category"))

}
