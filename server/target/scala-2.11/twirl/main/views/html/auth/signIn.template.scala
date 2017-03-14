
package views.html.auth

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object signIn_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  object signIn_Scope1 {
    import forms.auth.SignInForm

    class signIn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Form[SignInForm.Data], com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

      /**/
      def apply /*2.2*/ (signInForm: Form[SignInForm.Data], socialProviders: com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
        _display_ {
          {
            import com.mohiva.play.silhouette.impl.providers.oauth2.ClefProvider
            import b3.inline.fieldConstructor

            Seq[Any](format.raw /*2.201*/ ("""

"""), format.raw /*6.1*/ ("""
"""), _display_( /*7.2*/ main(Messages("sign.in.title")) /*7.33*/ {
              _display_(Seq[Any](format.raw /*7.35*/ ("""
    """), format.raw /*8.5*/ ("""<fieldset class="col-md-6 col-md-offset-3">
        <legend>"""), _display_( /*9.18*/ Messages("sign.in.credentials")), format.raw /*9.49*/ ("""</legend>
        """), _display_( /*10.10*/ helper /*10.16*/ .form(action = controllers.auth.routes.SignInController.submit()) /*10.81*/ {
                _display_(Seq[Any](format.raw /*10.83*/ ("""
            """), _display_( /*11.14*/ helper /*11.20*/ .CSRF.formField), format.raw /*11.35*/ ("""
            """), _display_( /*12.14*/ b3 /*12.16*/ .email(signInForm("email"), '_hiddenLabel -> Messages("email"), 'placeholder -> Messages("email"), 'class -> "form-control input-lg")), format.raw /*12.149*/ ("""
            """), _display_( /*13.14*/ b3 /*13.16*/ .password(signInForm("password"), '_hiddenLabel -> Messages("password"), 'placeholder -> Messages("password"), 'class -> "form-control input-lg")), format.raw /*13.161*/ ("""
            """), _display_( /*14.14*/ b3 /*14.16*/ .checkbox(signInForm("rememberMe"), '_text -> Messages("remember.me"), 'checked -> true)), format.raw /*14.104*/ ("""
            """), format.raw /*15.13*/ ("""<div class="form-group">
                <div>
                    <button id="submit" type="submit" value="submit" class="btn btn-lg btn-primary btn-block">"""), _display_( /*17.112*/ Messages("sign.in")), format.raw /*17.131*/ ("""</button>
                </div>
            </div>
        """)))
              }), format.raw /*20.10*/ ("""

        """), format.raw /*22.9*/ ("""<div>
            <p class="not-a-member">"""), _display_( /*23.38*/ Messages("not.a.member")), format.raw /*23.62*/ (""" """), format.raw /*23.63*/ ("""<a href=""""), _display_( /*23.73*/ controllers /*23.84*/ .auth.routes.SignUpController.view), format.raw /*23.118*/ ("""">"""), _display_( /*23.121*/ Messages("sign.up.now")), format.raw /*23.144*/ ("""</a> | <a href=""""), _display_( /*23.161*/ controllers /*23.172*/ .auth.routes.ForgotPasswordController.view()), format.raw /*23.216*/ ("""" title=""""), _display_( /*23.226*/ Messages("forgot.your.password")), format.raw /*23.258*/ ("""">"""), _display_( /*23.261*/ Messages("forgot.your.password")), format.raw /*23.293*/ ("""</a></p>
        </div>

        """), _display_( /*26.10*/ if (socialProviders.providers.nonEmpty) /*26.48*/ {
                _display_(Seq[Any](format.raw /*26.50*/ ("""
            """), format.raw /*27.13*/ ("""<div class="social-providers">
                <p>"""), _display_( /*28.21*/ Messages("or.use.social")), format.raw /*28.46*/ ("""</p>
                <div>
                """), _display_( /*30.18*/ for (p <- socialProviders.providers if p.id != "clef") yield /*30.71*/ {
                  _display_(Seq[Any](format.raw /*30.73*/ ("""
                    """), format.raw /*31.21*/ ("""<a href=""""), _display_( /*31.31*/ controllers /*31.42*/ .auth.routes.SocialAuthController.authenticate(p.id)), format.raw /*31.94*/ ("""" class="provider """), _display_( /*31.113*/ p /*31.114*/ .id), format.raw /*31.117*/ ("""" title=""""), _display_( /*31.127*/ Messages(p.id)), format.raw /*31.141*/ (""""><img src=""""), _display_( /*31.154*/ routes /*31.160*/ .Assets.at(s"images/providers/${p.id}.png")), format.raw /*31.203*/ ("""" width="64px" height="64px" alt=""""), _display_( /*31.238*/ Messages(p.id)), format.raw /*31.252*/ (""""></a>
                """)))
                }), format.raw /*32.18*/ ("""
                """), format.raw /*33.17*/ ("""</div>
                """), _display_( /*34.18*/ defining(socialProviders.get[ClefProvider]) /*34.61*/ { clef =>
                  _display_(Seq[Any](format.raw /*34.71*/ ("""
                    """), _display_( /*35.22*/ if (clef.isDefined) /*35.40*/ {
                    _display_(Seq[Any](format.raw /*35.42*/ ("""
                        """), format.raw /*36.25*/ ("""<script type="text/javascript" src="https://clef.io/v3/clef.js" class="clef-button" data-app-id=""""), _display_( /*36.123*/ clef /*36.127*/ .get.settings.clientID), format.raw /*36.149*/ ("""" data-color="blue" data-style="flat" data-redirect-url=""""), _display_( /*36.207*/ clef /*36.211*/ .get.settings.redirectURL), format.raw /*36.236*/ ("""" data-type="login"></script>
                    """)))
                  }), format.raw /*37.22*/ ("""
                """)))
                }), format.raw /*38.18*/ ("""
            """), format.raw /*39.13*/ ("""</div>
        """)))
              }), format.raw /*40.10*/ ("""

    """), format.raw /*42.5*/ ("""</fieldset>
""")))
            }), format.raw /*43.2*/ ("""
"""))
          }
        }
      }

      def render(signInForm: Form[SignInForm.Data], socialProviders: com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(signInForm, socialProviders)(request, messages, webJarAssets)

      def f: ((Form[SignInForm.Data], com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (signInForm, socialProviders) => (request, messages, webJarAssets) => apply(signInForm, socialProviders)(request, messages, webJarAssets)

      def ref: this.type = this

    }

  }
}

/**/
object signIn extends signIn_Scope0.signIn_Scope1.signIn
/*
                  -- GENERATED --
                  DATE: Sat Mar 11 02:26:18 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/signIn.scala.html
                  HASH: 668b5165940341627a4293238959fa85488fd30c
                  MATRIX: 765->31|1162->230|1190->337|1217->339|1256->370|1295->372|1326->377|1413->438|1464->469|1510->488|1525->494|1599->559|1639->561|1680->575|1695->581|1731->596|1772->610|1783->612|1938->745|1979->759|1990->761|2157->906|2198->920|2209->922|2319->1010|2360->1023|2546->1181|2587->1200|2679->1261|2716->1271|2786->1314|2831->1338|2860->1339|2897->1349|2917->1360|2973->1394|3004->1397|3049->1420|3094->1437|3115->1448|3181->1492|3219->1502|3273->1534|3304->1537|3358->1569|3419->1603|3466->1641|3506->1643|3547->1656|3625->1707|3671->1732|3742->1776|3811->1829|3851->1831|3900->1852|3937->1862|3957->1873|4030->1925|4077->1944|4088->1945|4113->1948|4151->1958|4187->1972|4228->1985|4244->1991|4309->2034|4372->2069|4408->2083|4463->2107|4508->2124|4559->2148|4611->2191|4659->2201|4708->2223|4735->2241|4775->2243|4828->2268|4954->2366|4968->2370|5012->2392|5098->2450|5112->2454|5159->2479|5241->2530|5290->2548|5331->2561|5378->2577|5411->2583|5454->2596
                  LINES: 25->2|31->2|33->6|34->7|34->7|34->7|35->8|36->9|36->9|37->10|37->10|37->10|37->10|38->11|38->11|38->11|39->12|39->12|39->12|40->13|40->13|40->13|41->14|41->14|41->14|42->15|44->17|44->17|47->20|49->22|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|50->23|53->26|53->26|53->26|54->27|55->28|55->28|57->30|57->30|57->30|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|58->31|59->32|60->33|61->34|61->34|61->34|62->35|62->35|62->35|63->36|63->36|63->36|63->36|63->36|63->36|63->36|64->37|65->38|66->39|67->40|69->42|70->43
                  -- GENERATED --
              */
