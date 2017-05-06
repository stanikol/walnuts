
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/changePassword.scala.html
                  HASH: aa2134a5936fd9a5583460bd75247f3984f37958
                  MATRIX: 803->1|1076->145|1104->182|1131->184|1190->235|1229->237|1260->242|1347->303|1394->330|1439->349|1453->355|1557->450|1597->452|1637->465|1680->482|1732->514|1777->532|1792->538|1828->553|1869->567|1880->569|2079->746|2120->760|2314->932|2355->945|2541->1103|2581->1121|2673->1182|2705->1187|2748->1200
                  LINES: 26->1|31->1|33->4|34->5|34->5|34->5|35->6|36->7|36->7|37->8|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|42->13|44->15|44->15|47->18|48->19|49->20
                  -- GENERATED --
              */
