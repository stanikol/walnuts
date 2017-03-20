
package views.html.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object signUp_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class signUp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""

"""), format.raw /*3.1*/ ("""<html>
    <body>
        <p>"""), _display_( /*5.13*/ messages("email.sign.up.hello", user.name.getOrElse("user"))), format.raw /*5.73*/ ("""</p>
        <p>"""), _display_( /*6.13*/ Html(messages("email.sign.up.html.text", url))), format.raw /*6.59*/ ("""</p>
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
object signUp extends signUp_Scope0.signUp
/*
                  -- GENERATED --
                  DATE: Mon Mar 20 14:32:37 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/signUp.scala.html
                  HASH: ffa8f649f8e9e012dd2cf5dccd9e8dab0fc906af
                  MATRIX: 607->1|756->55|784->57|840->87|920->147|963->164|1029->210
                  LINES: 22->1|27->1|29->3|31->5|31->5|32->6|32->6
                  -- GENERATED --
              */
