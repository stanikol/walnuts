
package views.html.auth

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object changePassword_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class changePassword extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[scala.Tuple2[String, String]], models.User, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (changePasswordForm: Form[(String, String)], user: models.User)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import b3.inline.fieldConstructor

          Seq[Any](format.raw /*1.146*/ ("""

"""), format.raw /*4.1*/ ("""
"""), _display_( /*5.2*/ main(Messages("change.password.title"), Some(user)) /*5.53*/ {
            _display_(Seq[Any](format.raw /*5.55*/ ("""
    """), format.raw /*6.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*7.18*/ Messages("change.password")), format.raw /*7.45*/ ("""</legend>
        """), _display_( /*8.10*/ helper /*8.16*/ .form(action = controllers.auth.routes.ChangePasswordController.submit, 'autocomplete -> "off") /*8.111*/ {
              _display_(Seq[Any](format.raw /*8.113*/ ("""
            """), format.raw /*9.13*/ ("""<p class="info">"""), _display_( /*9.30*/ Messages("strong.password.info")), format.raw /*9.62*/ ("""</p>
            """), _display_( /*10.14*/ helper /*10.20*/ .CSRF.formField), format.raw /*10.35*/ ("""
            """), _display_( /*11.14*/ b3 /*11.16*/ .password(changePasswordForm("current-password"), '_hiddenLabel -> Messages("current.password"), 'placeholder -> Messages("current.password"), 'class -> "form-control input-lg")), format.raw /*11.193*/ ("""
            """), _display_( /*12.14*/ passwordStrength(changePasswordForm("new-password"), '_hiddenLabel -> Messages("new.password"), 'placeholder -> Messages("new.password"), 'class -> "form-control input-lg")), format.raw /*12.186*/ ("""
            """), format.raw /*13.13*/ ("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""), _display_( /*15.112*/ Messages("change")), format.raw /*15.130*/ ("""</button>
                </div>
            </div>
        """)))
            }), format.raw /*18.10*/ ("""
    """), format.raw /*19.5*/ ("""</fieldset>
""")))
          }), format.raw /*20.2*/ ("""
"""))
        }
      }
    }

    def render(changePasswordForm: Form[scala.Tuple2[String, String]], user: models.User, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(changePasswordForm, user)(request, messages, webJarAssets)

    def f: ((Form[scala.Tuple2[String, String]], models.User) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (changePasswordForm, user) => (request, messages, webJarAssets) => apply(changePasswordForm, user)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object changePassword extends changePassword_Scope0.changePassword
/*
                  -- GENERATED --
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/changePassword.scala.html
                  HASH: f3743f0279d3fcb5b2d799e9c5a153e84b8ce3e3
                  MATRIX: 683->1|956->145|984->182|1011->184|1070->235|1109->237|1140->242|1227->303|1274->330|1319->349|1333->355|1437->450|1477->452|1517->465|1560->482|1612->514|1657->532|1672->538|1708->553|1749->567|1760->569|1959->746|2000->760|2194->932|2235->945|2421->1103|2461->1121|2553->1182|2585->1187|2628->1200
                  LINES: 22->1|27->1|29->4|30->5|30->5|30->5|31->6|32->7|32->7|33->8|33->8|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|38->13|40->15|40->15|43->18|44->19|45->20
                  -- GENERATED --
              */
