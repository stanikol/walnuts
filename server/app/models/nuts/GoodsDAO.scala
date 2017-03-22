package models.nuts

import javax.inject.Inject

import models.nuts.Data.{ GoodsItem }
import models.nuts.Tables.{ goods, goodsReturning }
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class GoodsDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def listAllGoods: Future[Seq[GoodsItem]] = db.run(goods.sortBy(_.showOrder).result)

  def get(goodsItemID: Long): Future[Option[GoodsItem]] = db.run(goods.filter(_.id === goodsItemID).result.headOption)

  def createNew(goodsItem: GoodsItem): Future[GoodsItem] = {
    db.run(goodsReturning += goodsItem)
  }

  def update(goodsItem: GoodsItem): Future[GoodsItem] = {
    val id = goodsItem.id.get
    db.run(goods.filter(_.id === id).update(goodsItem)).flatMap(_ =>
      db.run(goods.filter(_.id === id).result.head))
  }

  def delete(itemID: Long): Future[Int] = db.run(goods.filter(_.id === itemID).delete)

  //  def getArticle(id: Long): Future[Option[Article]] = db.run(articles.filter(_.id === id).result.headOption)
  //
  //  def addNewArticle(article: Article): Future[Article] = db.run(insertArticle += article)
  //
  //  def updateArticle(article: Article) = db.run(articles.filter(_.id === article.id).update(article))
  //
  //  def deleteArticle(id: Long): Future[Int] = db.run(articles.filter(_.id === id).delete)

}
