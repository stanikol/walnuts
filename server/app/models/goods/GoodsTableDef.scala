package models.goods

/**
 * Created by snc on 5/6/17.
 */

import slick.lifted.TableQuery
import slick.driver.PostgresDriver.api._
/**
 * Created by stanikol on 10/21/16.
 */
object GoodsTableDef {

  class Categories(tag: Tag) extends Table[Category](tag, "categories") {
    def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def name = column[String]("name")
    def sortOrder = column[String]("sort_order")
    def * = (id.?, name, sortOrder) <> ((Category.apply(_, _, _)).tupled, Category.unapply)
    def idx_name = index("idx_name", name, unique = true)
  }
  val categories = TableQuery[Categories]

  class Goods(tag: Tag) extends Table[GoodsItem](tag, "goods") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def category = column[Int]("category")
    def title = column[String]("title")
    def description = column[String]("description")
    def qnt = column[Int]("qnt", O.Default(0))
    def price = column[BigDecimal]("price", O.Default(0))
    def sortOrder = column[String]("sort_order")
    def image = column[Option[String]]("image")
    def * = (id.?, category, title, description, qnt, price, sortOrder, image) <> ((GoodsItem.apply _).tupled, GoodsItem.unapply)
    def categoryFK = foreignKey("goods_category_fkey", category, categories)(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)
    def imageConstrain = foreignKey("goods_image_fkey", image, models.images.ImageTableDef.images)(_.name.?)
  }
  val goods = TableQuery[Goods]
  val goodsReturning = goods returning (goods.map(_.id)) into ((goodsItem, newID) => goodsItem.copy(id = Some(newID)))

  class GoodsView(tag: Tag) extends Table[GoodsItemView](tag, "goods_view") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def category = column[String]("category")
    def categoryID = column[Int]("category_id")
    def title = column[String]("title")
    def description = column[String]("description")
    def qnt = column[Int]("qnt", O.Default(0))
    def price = column[BigDecimal]("price", O.Default(0))
    def categorySortOrder = column[String]("category_sort_order")
    def sortOrder = column[String]("sort_order")
    def image = column[Option[String]]("image")
    def * = (id.?, category, categoryID, title, description, qnt, price, categorySortOrder, sortOrder, image) <>
      ((GoodsItemView.apply _).tupled, GoodsItemView.unapply)
  }
  val goodsView = TableQuery[GoodsView]

}
