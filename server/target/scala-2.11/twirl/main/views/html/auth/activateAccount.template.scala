
package views.html.auth

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

  class activateAccount extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (email: String)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.98*/ ("""

"""), _display_( /*3.2*/ main(Messages("activate.account.title")) /*3.42*/ {
            _display_(Seq[Any](format.raw /*3.44*/ ("""
    """), format.raw /*4.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*5.18*/ Messages("activate.account")), format.raw /*5.46*/ ("""</legend>
        <div class="info">
            <p>"""), _display_( /*7.17*/ Messages("activate.account.text1")), format.raw /*7.51*/ ("""</p>
            <p><b>"""), _display_( /*8.20*/ email), format.raw /*8.25*/ ("""</b></p>
            <p>"""), _display_( /*9.17*/ Messages("activate.account.text2")), format.raw /*9.51*/ ("""</p>
            <p>"""), _display_( /*10.17*/ Html(Messages("activate.account.text3", controllers.auth.routes.ActivateAccountController.send(helper.urlEncode(email))))), format.raw /*10.138*/ ("""</p>
        </div>
    </fieldset>
""")))
          }), format.raw /*13.2*/ ("""
"""))
        }
      }
    }

    def render(email: String, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(email)(request, messages, webJarAssets)

    def f: ((String) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (email) => (request, messages, webJarAssets) => apply(email)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object activateAccount extends activateAccount_Scope0.activateAccount
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/activateAccount.scala.html
                  HASH: 9195aa64f415a690e85fe7aa179376c528a8dfe6
                  MATRIX: 765->1|956->97|984->100|1032->140|1071->142|1102->147|1189->208|1237->236|1316->289|1370->323|1420->347|1445->352|1496->377|1550->411|1598->432|1741->553|1808->590
                  LINES: 26->1|31->1|33->3|33->3|33->3|34->4|35->5|35->5|37->7|37->7|38->8|38->8|39->9|39->9|40->10|40->10|43->13
                  -- GENERATED --
              */
