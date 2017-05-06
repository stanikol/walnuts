
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/alreadySignedUp.scala.html
                  HASH: e7190e7f5b91d471e906d2766a7141e12d3d4165
                  MATRIX: 745->1|894->55|922->57|978->87|1068->157|1111->174|1187->230
                  LINES: 26->1|31->1|33->3|35->5|35->5|36->6|36->6
                  -- GENERATED --
              */
