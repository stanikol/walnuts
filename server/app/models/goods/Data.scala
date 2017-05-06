package models.goods

import java.sql.Timestamp

import com.sksamuel.scrimage.{ Image => ScrImage }
import play.api.libs.json.{ Format, Json }

/**
 * Created by stanikol on 1/27/17.
 */
//object Data {

// Category
case class Category(id: Option[Int], name: String, sortOrder: String)

case class BindingImageCategory(imageName: String, categoryID: Int)

// GoodsItem
case class GoodsItem(id: Option[Long], category: Int, title: String, description: String,
  qnt: Int, price: BigDecimal, sortOrder: String, image: Option[String])

object GoodsItem {
  def empty = GoodsItem(None, 0, "", "", 0, 0, "", None)

  def fromGoodsItemView(goodsItemView: GoodsItemView): GoodsItem =
    new GoodsItem(goodsItemView.id, goodsItemView.categoryID, goodsItemView.title, goodsItemView.description,
      goodsItemView.qnt, goodsItemView.price, goodsItemView.sortOrder, goodsItemView.image)

  implicit val goodsItemJson: Format[GoodsItem] = Json.format[GoodsItem]
  //    implicit val goodsItemJson: Format[GoodsItem] = (
  //      (JsPath \ "id").format[Option[Long]] and
  //      (JsPath \ "category").format[String] and
  //      (JsPath \ "title").format[String] and
  //      (JsPath \ "description").format[String] and
  //      (JsPath \ "qnt").format[Int] and
  //      (JsPath \ "price").format[BigDecimal] and
  //      (JsPath \ "showAdminImageForm").format[Int] and
  //      (JsPath \ "image").format[String]
  //    )(GoodsItem.apply _, unlift(GoodsItem.unapply))
  //  }
}

case class GoodsItemView(id: Option[Long], category: String, categoryID: Int, title: String, description: String,
  qnt: Int, price: BigDecimal, categorySortOrder: String, sortOrder: String, image: Option[String])

