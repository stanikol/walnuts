
package views.txt.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object resetPassword_Scope0 {
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

  class resetPassword extends BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable, Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.TxtFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.TxtFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""
"""), _display_( /*2.2*/ messages("email.reset.password.hello", user.name.getOrElse("user"))), format.raw /*2.69*/ ("""

"""), _display_( /*4.2*/ messages("email.reset.password.txt.text", url)), format.raw /*4.48*/ ("""
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
object resetPassword extends resetPassword_Scope0.resetPassword
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/resetPassword.scala.txt
                  HASH: 2ad4564acac7062c60a3f318c0ccc7b0fb886f2a
                  MATRIX: 735->1|883->55|910->57|997->124|1025->127|1091->173
                  LINES: 26->1|31->1|32->2|32->2|34->4|34->4
                  -- GENERATED --
              */
