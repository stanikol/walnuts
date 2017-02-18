package models.nuts

import java.util.Calendar

import models.nuts.Data.Article
import play.api.data.Form
import play.api.data.Forms.{ mapping, _ }

/**
 * Created by stanikol on 2/1/17.
 */

object FormsData {

  case class SaveImage(name: String, content: String, height: Option[Int], width: Option[Int])
  object SaveImage {
    def empty = SaveImage("", "", None, None)
  }

  val saveImageForm: Form[SaveImage] = Form(
    mapping(
      "name" -> nonEmptyText,
      "content" -> nonEmptyText,
      "height" -> optional(number),
      "width" -> optional(number)
    )(SaveImage.apply)(SaveImage.unapply)
  )

  case class FindImages(search: String, what: String)
  object FindImages {
    def empty = FindImages("%", "name")
  }

  val validWhatValues = Seq("name", "content")

  val findImagesForm = Form(
    mapping(
      "search" -> nonEmptyText,
      "what" -> nonEmptyText.verifying(
        s"Value should be either '${validWhatValues.mkString("' or '")}'!",
        what => validWhatValues.contains(what.toLowerCase)
      )
    )(FindImages.apply)(FindImages.unapply)
  )

  //  case class RenameImage(oldName: String, newName: String)
  //
  //  //  val renameImageForm: Form[RenameImage] = Form(
  //  //    mapping(
  //  //      "oldName" -> nonEmptyText,
  //  //      "newName" -> nonEmptyText
  //  //    )(RenameImage.apply)(RenameImage.unapply)
  //  //  )
  //  //
  //  //  val deleteImageForm = Form(single("deleteImage" -> nonEmptyText))

  case class ImageEdit(rename: String, what: String, imageChecked: String, action: String)

  val imageEditForm = Form(mapping(
    "rename" -> nonEmptyText,
    "what" -> nonEmptyText,
    "imageChecked" -> nonEmptyText,
    "action" -> nonEmptyText
  )(ImageEdit.apply)(ImageEdit.unapply))

  val timeFormatForSortOrder = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  val now = Calendar.getInstance().getTime()

  val articleForm = Form(mapping(
    "id" -> optional(longNumber),
    "sort-order" -> default(text, timeFormatForSortOrder.format(now)),
    "keywords" -> nonEmptyText,
    "title" -> nonEmptyText,
    "blog-text" -> nonEmptyText,
    "description" -> nonEmptyText
  )(Article.apply)(Article.unapply))
}
