
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/signIn.scala.html
                  HASH: cd059db374bc7c1e851492d03e781fed17bd5698
                  MATRIX: 885->31|1282->230|1310->337|1337->339|1376->370|1415->372|1446->377|1533->438|1584->469|1630->488|1645->494|1719->559|1759->561|1800->575|1815->581|1851->596|1892->610|1903->612|2058->745|2099->759|2110->761|2277->906|2318->920|2329->922|2439->1010|2480->1023|2666->1181|2707->1200|2799->1261|2836->1271|2906->1314|2951->1338|2980->1339|3017->1349|3037->1360|3093->1394|3124->1397|3169->1420|3214->1437|3235->1448|3301->1492|3339->1502|3393->1534|3424->1537|3478->1569|3539->1603|3586->1641|3626->1643|3667->1656|3745->1707|3791->1732|3862->1776|3931->1829|3971->1831|4020->1852|4057->1862|4077->1873|4150->1925|4197->1944|4208->1945|4233->1948|4271->1958|4307->1972|4348->1985|4364->1991|4429->2034|4492->2069|4528->2083|4583->2107|4628->2124|4679->2148|4731->2191|4779->2201|4828->2223|4855->2241|4895->2243|4948->2268|5074->2366|5088->2370|5132->2392|5218->2450|5232->2454|5279->2479|5361->2530|5410->2548|5451->2561|5498->2577|5531->2583|5574->2596
                  LINES: 29->2|35->2|37->6|38->7|38->7|38->7|39->8|40->9|40->9|41->10|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|48->17|48->17|51->20|53->22|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|54->23|57->26|57->26|57->26|58->27|59->28|59->28|61->30|61->30|61->30|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|62->31|63->32|64->33|65->34|65->34|65->34|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|67->36|67->36|68->37|69->38|70->39|71->40|73->42|74->43
                  -- GENERATED --
              */
