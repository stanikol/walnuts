
package views.html.auth

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object resetPassword_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class resetPassword extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[String], java.util.UUID, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (form: Form[String], token: java.util.UUID)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import b3.inline.fieldConstructor

          Seq[Any](format.raw /*1.126*/ ("""

"""), format.raw /*4.1*/ ("""
"""), _display_( /*5.2*/ main(Messages("reset.password.title")) /*5.40*/ {
            _display_(Seq[Any](format.raw /*5.42*/ ("""
    """), format.raw /*6.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*7.18*/ Messages("reset.password")), format.raw /*7.44*/ ("""</legend>
        """), _display_( /*8.10*/ helper /*8.16*/ .form(action = controllers.auth.routes.ResetPasswordController.submit(token), 'autocomplete -> "off") /*8.117*/ {
              _display_(Seq[Any](format.raw /*8.119*/ ("""
            """), format.raw /*9.13*/ ("""<p class="info">"""), _display_( /*9.30*/ Messages("strong.password.info")), format.raw /*9.62*/ ("""</p>
            """), _display_( /*10.14*/ helper /*10.20*/ .CSRF.formField), format.raw /*10.35*/ ("""
            """), _display_( /*11.14*/ passwordStrength(form("password"), '_hiddenLabel -> Messages("password"), 'placeholder -> Messages("password"), 'class -> "form-control input-lg")), format.raw /*11.160*/ ("""
            """), format.raw /*12.13*/ ("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""), _display_( /*14.112*/ Messages("reset")), format.raw /*14.129*/ ("""</button>
                </div>
            </div>
        """)))
            }), format.raw /*17.10*/ ("""
    """), format.raw /*18.5*/ ("""</fieldset>
""")))
          }), format.raw /*19.2*/ ("""
"""))
        }
      }
    }

    def render(form: Form[String], token: java.util.UUID, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(form, token)(request, messages, webJarAssets)

    def f: ((Form[String], java.util.UUID) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (form, token) => (request, messages, webJarAssets) => apply(form, token)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object resetPassword extends resetPassword_Scope0.resetPassword
/*
                  -- GENERATED --
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/resetPassword.scala.html
                  HASH: 2e89eb6cd76b2fcb7336cd26afc7f12efaa11e56
                  MATRIX: 662->1|915->125|943->162|970->164|1016->202|1055->204|1086->209|1173->270|1219->296|1264->315|1278->321|1388->422|1428->424|1468->437|1511->454|1563->486|1608->504|1623->510|1659->525|1700->539|1868->685|1909->698|2095->856|2134->873|2226->934|2258->939|2301->952
                  LINES: 22->1|27->1|29->4|30->5|30->5|30->5|31->6|32->7|32->7|33->8|33->8|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|37->12|39->14|39->14|42->17|43->18|44->19
                  -- GENERATED --
              */
