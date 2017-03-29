
package views.html.auth

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object forgotPassword_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class forgotPassword extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (forgotPasswordForm: Form[String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import b3.inline.fieldConstructor

          Seq[Any](format.raw /*1.117*/ ("""

"""), format.raw /*4.1*/ ("""
"""), _display_( /*5.2*/ main(Messages("forgot.password.title")) /*5.41*/ {
            _display_(Seq[Any](format.raw /*5.43*/ ("""
    """), format.raw /*6.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*7.18*/ Messages("forgot.password")), format.raw /*7.45*/ ("""</legend>
        """), _display_( /*8.10*/ helper /*8.16*/ .form(action = controllers.auth.routes.ForgotPasswordController.submit(), 'autocomplete -> "off") /*8.113*/ {
              _display_(Seq[Any](format.raw /*8.115*/ ("""
            """), format.raw /*9.13*/ ("""<p class="info">"""), _display_( /*9.30*/ Messages("forgot.password.info")), format.raw /*9.62*/ ("""</p>
            """), _display_( /*10.14*/ helper /*10.20*/ .CSRF.formField), format.raw /*10.35*/ ("""
            """), _display_( /*11.14*/ b3 /*11.16*/ .text(forgotPasswordForm("email"), '_hiddenLabel -> Messages("email"), 'placeholder -> Messages("email"), 'class -> "form-control input-lg")), format.raw /*11.156*/ ("""
            """), format.raw /*12.13*/ ("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""), _display_( /*14.112*/ Messages("send")), format.raw /*14.128*/ ("""</button>
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

    def render(forgotPasswordForm: Form[String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(forgotPasswordForm)(request, messages, webJarAssets)

    def f: ((Form[String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (forgotPasswordForm) => (request, messages, webJarAssets) => apply(forgotPasswordForm)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object forgotPassword extends forgotPassword_Scope0.forgotPassword
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/forgotPassword.scala.html
                  HASH: f0de6dca42988338e793cf5c715ca85c19862c1a
                  MATRIX: 649->1|893->116|921->153|948->155|995->194|1034->196|1065->201|1152->262|1199->289|1244->308|1258->314|1364->411|1404->413|1444->426|1487->443|1539->475|1584->493|1599->499|1635->514|1676->528|1687->530|1849->670|1890->683|2076->841|2114->857|2206->918|2238->923|2281->936
                  LINES: 22->1|27->1|29->4|30->5|30->5|30->5|31->6|32->7|32->7|33->8|33->8|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|36->11|37->12|39->14|39->14|42->17|43->18|44->19
                  -- GENERATED --
              */
