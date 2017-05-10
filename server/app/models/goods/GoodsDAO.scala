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

}
