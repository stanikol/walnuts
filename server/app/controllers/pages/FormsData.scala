package controllers.pages

import models.pages.Page
import play.api.data.Form
import play.api.data.Forms.{ mapping, text, _ }

/**
 * Created by stanikol on 2/1/17.
 */

object FormsData {

  case class PageFormData(page: Page, action: Option[String])

  val pageForm = Form(mapping(
    "page" -> mapping(
      "url" -> nonEmptyText,
      "lang" -> nonEmptyText,
      "title" -> nonEmptyText,
      "html" -> nonEmptyText,
      "keywords" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Page.apply)(Page.unapply),
    "action" -> optional(text)
  )(PageFormData.apply)(PageFormData.unapply))

}
