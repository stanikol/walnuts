package models.goods

import javax.inject.Inject

//import models.blog.Data.{GoodsItem, GoodsItemView}
import models.goods.GoodsTableDef._
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class GoodsDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def listAllGoods: Future[Seq[GoodsItemView]] = db.run(goodsView.result)

  def getGoodsItem(goodsItemID: Long): Future[Option[GoodsItemView]] = db.run(
    goodsView.filter(_.id === goodsItemID).result.headOption
  )

  def createNewGoodsItem(goodsItem: GoodsItem): Future[GoodsItem] = {
    db.run(goodsReturning += goodsItem)
  }

  def updateGoodsItem(goodsItem: GoodsItem): Future[GoodsItem] = {
    val id = goodsItem.id.get
    db.run(goods.filter(_.id === id).update(goodsItem)).flatMap(_ =>
      db.run(goods.filter(_.id === id).result.head))
  }

  def deleteGoodsItem(itemID: Long): Future[Int] = db.run(goods.filter(_.id === itemID).delete)

  //  def listCategories = db.run(categories.sortBy(_.sortOrder).result)
  //
  //  def deleteCategory(id: Int) = db.run(categories.filter(_.id === id).delete).map(rowsDeleted =>
  //    Logger.info(s"Из БД удалено $rowsDeleted запись. Категория id=$id."))
  //
  //  def addCategory(category: Category): Future[Category] = db.run(categories.returning(categories.map(_.id))
  //    .into((cat, id) => cat.copy(id = Some(id))) += category)
  //
  //  def upsertGoodsCategory(category: Category) =
  //    db.run(categories.filter(_.name === category.name).update(category))
  //      .map(rowsUpdated => Logger.info(s"В БД обновлена $rowsUpdated запись. $category"))

  //  def getArticle(id: Long): Future[Option[Article]] = db.run(articles.filter(_.id === id).result.headOption)
  //
  //  def addNewArticle(article: Article): Future[Article] = db.run(insertArticle += article)
  //
  //  def updateArticle(article: Article) = db.run(articles.filter(_.id === article.id).updateGoodsItem(article))
  //
  //  def deleteArticle(id: Long): Future[Int] = db.run(articles.filter(_.id === id).deleteGoodsItem)

}
