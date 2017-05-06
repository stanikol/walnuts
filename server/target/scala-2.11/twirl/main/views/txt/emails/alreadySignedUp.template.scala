
package views.txt.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object alreadySignedUp_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.txt._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

  class alreadySignedUp extends BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable, Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.TxtFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.TxtFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""
"""), _display_( /*2.2*/ messages("email.already.signed.up.hello", user.name.getOrElse("user"))), format.raw /*2.72*/ ("""

"""), _display_( /*4.2*/ messages("email.already.signed.up.txt.text", url)), format.raw /*4.51*/ ("""
"""))
        }
      }
    }

    def render(user: User, url: String, messages: Messages): play.twirl.api.TxtFormat.Appendable = apply(user, url)(messages)

    def f: ((User, String) => (Messages) => play.twirl.api.TxtFormat.Appendable) = (user, url) => (messages) => apply(user, url)(messages)

    def ref: this.type = this

  }

}

/**/
object alreadySignedUp extends alreadySignedUp_Scope0.alreadySignedUp
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/alreadySignedUp.scala.txt
                  HASH: 4f8a3d7071509630b79950847b884516e4912e7b
                  MATRIX: 739->1|887->55|914->57|1004->127|1032->130|1101->179
                  LINES: 26->1|31->1|32->2|32->2|34->4|34->4
                  -- GENERATED --
              */
