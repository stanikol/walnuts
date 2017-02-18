
package views.txt.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object signUp_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.txt._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class signUp extends BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable, Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.TxtFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.TxtFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""
"""), _display_( /*2.2*/ messages("email.sign.up.hello", user.name.getOrElse("user"))), format.raw /*2.62*/ ("""

"""), _display_( /*4.2*/ messages("email.sign.up.txt.text", url)), format.raw /*4.41*/ ("""
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
object signUp extends signUp_Scope0.signUp
/*
                  -- GENERATED --
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/signUp.scala.txt
                  HASH: f2e6db8a67f84b0db6f5742fa97d9a5e48c0480b
                  MATRIX: 601->1|749->55|776->57|856->117|884->120|943->159
                  LINES: 22->1|27->1|28->2|28->2|30->4|30->4
                  -- GENERATED --
              */
