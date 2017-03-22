package models.nuts

import java.sql.{ Date, Time, Timestamp }
import java.time.LocalDateTime
import java.util.UUID

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.{ Format, JsPath, Json }
import play.api.libs.functional.syntax._
/**
 * Created by stanikol on 1/27/17.
 */
object Data {
  // Image
  case class Image(
    name: String,
    content: String,
    bytes: Array[Byte]
  )

  implicit val imageJosn: Format[Image] = (
    (JsPath \ "name").format[String] and
    (JsPath \ "content").format[String] and
    (JsPath \ "bytes").format[Array[Byte]]
  )(Image.apply _, unlift(Image.unapply(_)))

  // ImageInfo
  case class ImageInfo(name: String, content: String)

  object ImageInfo {
    def apply(image: Image): ImageInfo = new ImageInfo(image.name, image.content)

    implicit val imageInfoJson: Format[ImageInfo] = (
      (JsPath \ "name").format[String] and
      (JsPath \ "content").format[String]
    )(ImageInfo.apply _, unlift(ImageInfo.unapply(_)))
  }

  // Article
  case class Article(
    id: Option[Long],
    sort_order: String,
    keywords: String,
    title: String,
    text: String,
    description: String,
    short_text: String
  )

  object Article {
    def empty: Article = Article(None, "", "", "", "", "", "")
  }

  // Category
  case class Category(name: String)

  // GoodsItem
  case class GoodsItem(id: Option[Long], category: String, title: String, description: String,
    qnt: Int, price: BigDecimal, showOrder: Int, image: Option[String])

  object GoodsItem {
    def empty = GoodsItem(None, "", "", "", 0, 0, 1, None)
  }
  //  object GoodsItem {

  implicit val goodsItemJson: Format[GoodsItem] = Json.format[GoodsItem]
  //    implicit val goodsItemJson: Format[GoodsItem] = (
  //      (JsPath \ "id").format[Option[Long]] and
  //      (JsPath \ "category").format[String] and
  //      (JsPath \ "title").format[String] and
  //      (JsPath \ "description").format[String] and
  //      (JsPath \ "qnt").format[Int] and
  //      (JsPath \ "price").format[BigDecimal] and
  //      (JsPath \ "show").format[Int] and
  //      (JsPath \ "image").format[String]
  //    )(GoodsItem.apply _, unlift(GoodsItem.unapply))
  //  }

  case class Comment(id: Option[Long], userID: String, articleID: Long, text: String, added: Timestamp)
  case class CommentInfo(id: Option[Long], userID: String, userEmail: Option[String], articleID: Long, articleTitle: String, text: String, added: Timestamp, fullName: String)

}
