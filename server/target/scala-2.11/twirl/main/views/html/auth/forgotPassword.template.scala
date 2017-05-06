
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/forgotPassword.scala.html
                  HASH: 27ec5e7ec35c899344123358b317deb05ec7b3f9
                  MATRIX: 769->1|1013->116|1041->153|1068->155|1115->194|1154->196|1185->201|1272->262|1319->289|1364->308|1378->314|1484->411|1524->413|1564->426|1607->443|1659->475|1704->493|1719->499|1755->514|1796->528|1807->530|1969->670|2010->683|2196->841|2234->857|2326->918|2358->923|2401->936
                  LINES: 26->1|31->1|33->4|34->5|34->5|34->5|35->6|36->7|36->7|37->8|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|41->12|43->14|43->14|46->17|47->18|48->19
                  -- GENERATED --
              */
