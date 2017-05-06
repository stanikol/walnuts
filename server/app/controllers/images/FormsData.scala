package controllers.images

import play.api.data.Form
import play.api.data.Forms._

/**
 * Created by snc on 5/6/17.
 */
object FormsData {
  case class AdminImage(
      action: String,
      name: String,
      content: String,
      resizeTo: Option[(Int, Int)],
      albums: Option[Seq[Int]],
      find: (String, String)
  ) {
    override def toString: String =
      s"""AdminImage(action = $action, name = $name, content = $content, resizeTo = $resizeTo, albums = $albums, find = $find)"""
  }

  object AdminImage {
    def empty = AdminImage("", "", "", None, None, ("", "name"))
  }

  val adminImageForm: Form[AdminImage] = Form(mapping(
    "action" -> nonEmptyText.verifying(
      s"Нераспознанная комманда",
      value => Seq("save", "delete", "updateGoodsItem", "search", "new-tag").contains(value: String)
    ),
    "name" -> text,
    "content" -> text,
    "resizeTo" -> optional(tuple(
      "height" -> number,
      "width" -> number
    )),
    "albums" -> optional(seq(number)),
    "find" -> tuple(
      "search" -> default(text, "%"),
      "what" -> default(text, "name")
    )
  )(AdminImage.apply)(AdminImage.unapply))

  case class SaveImage(name: String, content: String, height: Option[Int], width: Option[Int], tags: Option[List[String]])
  object SaveImage {
    def empty = SaveImage("", "", None, None, None)
  }

  val saveImageForm: Form[SaveImage] = Form(
    mapping(
      "name" -> nonEmptyText,
      "content" -> nonEmptyText,
      "height" -> optional(number),
      "width" -> optional(number),
      "albums" -> optional(list(nonEmptyText))
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

  case class ImageEdit(rename: String, what: String, imageChecked: String, action: String)

  val imageEditForm = Form(mapping(
    "rename" -> nonEmptyText,
    "what" -> nonEmptyText,
    "imageChecked" -> nonEmptyText,
    "action" -> nonEmptyText
  )(ImageEdit.apply)(ImageEdit.unapply))

}
