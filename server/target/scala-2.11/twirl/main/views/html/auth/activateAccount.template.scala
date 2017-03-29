
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
  import models.nuts.Data._
  import models.nuts.FormsData._

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
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/activateAccount.scala.html
                  HASH: c09bedb8370a6a3ccb5f70fa525d80f90232e2be
                  MATRIX: 645->1|836->97|864->100|912->140|951->142|982->147|1069->208|1117->236|1196->289|1250->323|1300->347|1325->352|1376->377|1430->411|1478->432|1621->553|1688->590
                  LINES: 22->1|27->1|29->3|29->3|29->3|30->4|31->5|31->5|33->7|33->7|34->8|34->8|35->9|35->9|36->10|36->10|39->13
                  -- GENERATED --
              */
