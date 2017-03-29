
package views.html.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object alreadySignedUp_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class alreadySignedUp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""

"""), format.raw /*3.1*/ ("""<html>
    <body>
        <p>"""), _display_( /*5.13*/ messages("email.already.signed.up.hello", user.name.getOrElse("user"))), format.raw /*5.83*/ ("""</p>
        <p>"""), _display_( /*6.13*/ Html(messages("email.already.signed.up.html.text", url))), format.raw /*6.69*/ ("""</p>
    </body>
</html>
"""))
        }
      }
    }

    def render(user: User, url: String, messages: Messages): play.twirl.api.HtmlFormat.Appendable = apply(user, url)(messages)

    def f: ((User, String) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (user, url) => (messages) => apply(user, url)(messages)

    def ref: this.type = this

  }

}

/**/
object alreadySignedUp extends alreadySignedUp_Scope0.alreadySignedUp
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/alreadySignedUp.scala.html
                  HASH: 8d984a58997a95c2b5639e48e419f5fa5e2e672a
                  MATRIX: 625->1|774->55|802->57|858->87|948->157|991->174|1067->230
                  LINES: 22->1|27->1|29->3|31->5|31->5|32->6|32->6
                  -- GENERATED --
              */
