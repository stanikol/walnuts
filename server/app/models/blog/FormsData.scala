package models.blog

import java.util.Calendar

import models.goods.{ Category, GoodsItem }
import models.blog.Data.{ Article, CommentsShow }
import play.api.data.Form
import play.api.data.Forms.{ mapping, text, _ }

/**
 * Created by stanikol on 2/1/17.
 */

object FormsData {

  //  case class AdminImage(
  //      action: String,
  //      name: String,
  //      content: String,
  //      resizeTo: Option[(Int, Int)],
  //      albums: Option[Seq[Int]],
  //      find: (String, String)
  //  ) {
  //    override def toString: String =
  //      s"""AdminImage(action = $action, name = $name, content = $content, resizeTo = $resizeTo, albums = $albums, find = $find)"""
  //  }
  //
  //  object AdminImage {
  //    def empty = AdminImage("", "", "", None, None, ("", "name"))
  //  }
  //
  //  val adminImageForm: Form[AdminImage] = Form(mapping(
  //    "action" -> nonEmptyText.verifying(
  //      s"Нераспознанная комманда",
  //      value => Seq("save", "delete", "updateGoodsItem", "search", "new-tag").contains(value: String)
  //    ),
  //    "name" -> text,
  //    "content" -> text,
  //    "resizeTo" -> optional(tuple(
  //      "height" -> number,
  //      "width" -> number
  //    )),
  //    "albums" -> optional(seq(number)),
  //    "find" -> tuple(
  //      "search" -> default(text, "%"),
  //      "what" -> default(text, "name")
  //    )
  //  )(AdminImage.apply)(AdminImage.unapply))
  //
  //  case class SaveImage(name: String, content: String, height: Option[Int], width: Option[Int], tags: Option[List[String]])
  //  object SaveImage {
  //    def empty = SaveImage("", "", None, None, None)
  //  }
  //
  //  val saveImageForm: Form[SaveImage] = Form(
  //    mapping(
  //      "name" -> nonEmptyText,
  //      "content" -> nonEmptyText,
  //      "height" -> optional(number),
  //      "width" -> optional(number),
  //      "albums" -> optional(list(nonEmptyText))
  //    )(SaveImage.apply)(SaveImage.unapply)
  //  )
  //
  //  case class FindImages(search: String, what: String)
  //  object FindImages {
  //    def empty = FindImages("%", "name")
  //  }
  //
  //  val validWhatValues = Seq("name", "content")
  //
  //  val findImagesForm = Form(
  //    mapping(
  //      "search" -> nonEmptyText,
  //      "what" -> nonEmptyText.verifying(
  //        s"Value should be either '${validWhatValues.mkString("' or '")}'!",
  //        what => validWhatValues.contains(what.toLowerCase)
  //      )
  //    )(FindImages.apply)(FindImages.unapply)
  //  )
  //
  //  case class ImageEdit(rename: String, what: String, imageChecked: String, action: String)
  //
  //  val imageEditForm = Form(mapping(
  //    "rename" -> nonEmptyText,
  //    "what" -> nonEmptyText,
  //    "imageChecked" -> nonEmptyText,
  //    "action" -> nonEmptyText
  //  )(ImageEdit.apply)(ImageEdit.unapply))

  val timeFormatForSortOrder = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  val now = Calendar.getInstance().getTime()

  val articleForm = Form(mapping(
    "id" -> optional(longNumber),
    "sort-order" -> default(text, timeFormatForSortOrder.format(now)),
    "keywords" -> nonEmptyText,
    "title" -> nonEmptyText,
    "blog-text" -> nonEmptyText,
    "description" -> nonEmptyText,
    "blog-short-text" -> nonEmptyText
  )(Article.apply)(Article.unapply))

  val actionForm = Form(single("action" -> optional(text)))

  case class AddComment(articleID: Long, comment: Option[String])
  val addCommentForm = Form(mapping(
    "article-id" -> longNumber,
    "article-comment" -> optional(text)
  )(AddComment.apply)(AddComment.unapply))

  case class EditComment(commentID: Long, commentText: String, action: String)
  val editCommentForm = Form(mapping(
    "comment-id" -> longNumber,
    "comment-text" -> text,
    "action" -> text
  )(EditComment.apply)(EditComment.unapply))

  //  case class CommentsShow(order: Option[String], articleID: Option[String])
  val commentsShowForm = Form(mapping(
    "comments-order" -> optional(text),
    "article-id" -> optional(text)
  )(CommentsShow.apply)(CommentsShow.unapply))

  //  val goodsItemForm = Form(mapping(
  //    "id" -> optional(longNumber),
  //    "category" -> number,
  //    "title" -> nonEmptyText,
  //    "description" -> nonEmptyText,
  //    "qnt" -> ignored(0),
  //    "price" -> ignored(0: BigDecimal),
  //    "show-order" -> nonEmptyText,
  //    "image" -> optional(nonEmptyText)
  //  )(GoodsItem.apply)(GoodsItem.unapply))

  case class CategoryEdit(category: Category, action: String)
  val categoryForm: Form[CategoryEdit] = Form(mapping(
    "category" -> mapping(
      "id" -> optional(number),
      "name" -> nonEmptyText,
      "sort-order" -> nonEmptyText
    )(Category.apply)(Category.unapply),
    "action" -> nonEmptyText
  )(CategoryEdit.apply)(CategoryEdit.unapply))
}
