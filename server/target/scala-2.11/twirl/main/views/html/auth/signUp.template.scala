
package views.html.auth

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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

  object signUp_Scope1 {
    import forms.auth.SignUpForm

    class signUp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Form[SignUpForm.Data], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

      /**/
      def apply /*2.2*/ (signUpForm: Form[SignUpForm.Data])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
        _display_ {
          {
            import b3.inline.fieldConstructor

            Seq[Any](format.raw /*2.118*/ ("""

"""), format.raw /*5.1*/ ("""
"""), _display_( /*6.2*/ main(Messages("sign.up.title")) /*6.33*/ {
              _display_(Seq[Any](format.raw /*6.35*/ ("""
    """), format.raw /*7.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*8.18*/ Messages("sign.up.account")), format.raw /*8.45*/ ("""</legend>
        """), _display_( /*9.10*/ helper /*9.16*/ .form(action = controllers.auth.routes.SignUpController.submit()) /*9.81*/ {
                _display_(Seq[Any](format.raw /*9.83*/ ("""
            """), _display_( /*10.14*/ helper /*10.20*/ .CSRF.formField), format.raw /*10.35*/ ("""
            """), _display_( /*11.14*/ b3 /*11.16*/ .text(signUpForm("firstName"), '_hiddenLabel -> Messages("first.name"), 'placeholder -> Messages("first.name"), 'class -> "form-control input-lg")), format.raw /*11.162*/ ("""
            """), _display_( /*12.14*/ b3 /*12.16*/ .text(signUpForm("lastName"), '_hiddenLabel -> Messages("last.name"), 'placeholder -> Messages("last.name"), 'class -> "form-control input-lg")), format.raw /*12.159*/ ("""
            """), _display_( /*13.14*/ b3 /*13.16*/ .text(signUpForm("email"), '_hiddenLabel -> Messages("email"), 'placeholder -> Messages("email"), 'class -> "form-control input-lg")), format.raw /*13.148*/ ("""
            """), _display_( /*14.14*/ passwordStrength(signUpForm("password"), '_hiddenLabel -> Messages("password"), 'placeholder -> Messages("password"), 'class -> "form-control input-lg")), format.raw /*14.166*/ ("""
            """), format.raw /*15.13*/ ("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""), _display_( /*17.112*/ Messages("sign.up")), format.raw /*17.131*/ ("""</button>
                </div>
            </div>
            <div class="sign-in-now">
                <p>"""), _display_( /*21.21*/ Messages("already.a.member")), format.raw /*21.49*/ (""" """), format.raw /*21.50*/ ("""<a href=""""), _display_( /*21.60*/ controllers /*21.71*/ .auth.routes.SignInController.view), format.raw /*21.105*/ ("""">"""), _display_( /*21.108*/ Messages("sign.in.now")), format.raw /*21.131*/ ("""</a></p>
            </div>
        """)))
              }), format.raw /*23.10*/ ("""
    """), format.raw /*24.5*/ ("""</fieldset>
""")))
            }), format.raw /*25.2*/ ("""
"""))
          }
        }
      }

      def render(signUpForm: Form[SignUpForm.Data], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(signUpForm)(request, messages, webJarAssets)

      def f: ((Form[SignUpForm.Data]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (signUpForm) => (request, messages, webJarAssets) => apply(signUpForm)(request, messages, webJarAssets)

      def ref: this.type = this

    }

  }
}

/**/
object signUp extends signUp_Scope0.signUp_Scope1.signUp
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/signUp.scala.html
                  HASH: e5dce640c31018aa6d4185da0ba745b35e11331e
                  MATRIX: 820->31|1065->147|1093->184|1120->186|1159->217|1198->219|1229->224|1316->285|1363->312|1408->331|1422->337|1495->402|1534->404|1575->418|1590->424|1626->439|1667->453|1678->455|1846->601|1887->615|1898->617|2063->760|2104->774|2115->776|2269->908|2310->922|2484->1074|2525->1087|2711->1245|2752->1264|2889->1374|2938->1402|2967->1403|3004->1413|3024->1424|3080->1458|3111->1461|3156->1484|3224->1521|3256->1526|3299->1539
                  LINES: 29->2|34->2|36->5|37->6|37->6|37->6|38->7|39->8|39->8|40->9|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|46->15|48->17|48->17|52->21|52->21|52->21|52->21|52->21|52->21|52->21|52->21|54->23|55->24|56->25
                  -- GENERATED --
              */
