
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
  import models.nuts.Data._
  import models.nuts.FormsData._

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
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/signUp.scala.html
                  HASH: e1df71099a3238c26ff623e552b3e1c8807697a6
                  MATRIX: 700->31|945->147|973->184|1000->186|1039->217|1078->219|1109->224|1196->285|1243->312|1288->331|1302->337|1375->402|1414->404|1455->418|1470->424|1506->439|1547->453|1558->455|1726->601|1767->615|1778->617|1943->760|1984->774|1995->776|2149->908|2190->922|2364->1074|2405->1087|2591->1245|2632->1264|2769->1374|2818->1402|2847->1403|2884->1413|2904->1424|2960->1458|2991->1461|3036->1484|3104->1521|3136->1526|3179->1539
                  LINES: 25->2|30->2|32->5|33->6|33->6|33->6|34->7|35->8|35->8|36->9|36->9|36->9|36->9|37->10|37->10|37->10|38->11|38->11|38->11|39->12|39->12|39->12|40->13|40->13|40->13|41->14|41->14|42->15|44->17|44->17|48->21|48->21|48->21|48->21|48->21|48->21|48->21|48->21|50->23|51->24|52->25
                  -- GENERATED --
              */
