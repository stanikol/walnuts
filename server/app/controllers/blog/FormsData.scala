package controllers.blog

import java.util.Calendar

import models.blog.{ Article, CommentsShow }
import models.goods.Category
import play.api.data.Form
import play.api.data.Forms.{ mapping, text, _ }

/**
 * Created by stanikol on 2/1/17.
 */

object FormsData {

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

  val commentsShowForm = Form(mapping(
    "comments-order" -> optional(text),
    "article-id" -> optional(text)
  )(CommentsShow.apply)(CommentsShow.unapply))

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
