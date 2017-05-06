package controllers.goods

import models.goods._
import play.api.data.Form
import play.api.data.Forms.{ mapping, text, _ }

/**
 * Created by stanikol on 2/1/17.
 */

object FormsData {

  val goodsItemForm = Form(mapping(
    "id" -> optional(longNumber),
    "category" -> number,
    "title" -> nonEmptyText,
    "description" -> nonEmptyText,
    "qnt" -> ignored(0),
    "price" -> ignored(0: BigDecimal),
    "show-order" -> nonEmptyText,
    "image" -> optional(nonEmptyText)
  )(GoodsItem.apply)(GoodsItem.unapply))

  val actionForm = Form(single("action" -> optional(text)))

}
