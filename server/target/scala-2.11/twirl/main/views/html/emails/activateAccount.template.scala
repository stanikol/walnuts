
package views.html.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object activateAccount_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

  class activateAccount extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""

"""), format.raw /*3.1*/ ("""<html>
    <body>
        <p>"""), _display_( /*5.13*/ messages("email.activate.account.hello", user.name.getOrElse("user"))), format.raw /*5.82*/ ("""</p>
        <p>"""), _display_( /*6.13*/ Html(messages("email.activate.account.html.text", url))), format.raw /*6.68*/ ("""</p>
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
object activateAccount extends activateAccount_Scope0.activateAccount
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/activateAccount.scala.html
                  HASH: 2e5a148df1e3541a73b219e0b540ea5c982f7e04
                  MATRIX: 745->1|894->55|922->57|978->87|1067->156|1110->173|1185->228
                  LINES: 26->1|31->1|33->3|35->5|35->5|36->6|36->6
                  -- GENERATED --
              */
