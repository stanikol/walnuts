
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object home_Scope0 {
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

  class home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[models.User, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.102*/ ("""

"""), _display_( /*3.2*/ main(Messages("home.title"), Some(user)) /*3.42*/ {
            _display_(Seq[Any](format.raw /*3.44*/ ("""
    """), format.raw /*4.5*/ ("""<div class="user col-md-6 col-md-offset-3">
        <div class="row">
            <hr class="col-md-12" />
            <h4 class="col-md-8">"""), _display_( /*7.35*/ Messages("welcome.signed.in")), format.raw /*7.64*/ ("""</h4>
            <div class="col-md-4 text-right">
                <img src=""""), _display_( /*9.28*/ user /*9.32*/ .avatarURL.getOrElse(routes.Assets.at("images/silhouette.png"))), format.raw /*9.95*/ ("""" height="40px" />
            </div>
            <hr class="col-md-12" />
        </div>
        <div class="row data">
            <div class="col-md-12">
                <div class="row">
                    <p class="col-md-6"><strong>"""), _display_( /*16.50*/ Messages("first.name")), format.raw /*16.72*/ (""":</strong></p><p class="col-md-6">"""), _display_( /*16.107*/ user /*16.111*/ .firstName.getOrElse("None")), format.raw /*16.139*/ ("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""), _display_( /*19.50*/ Messages("last.name")), format.raw /*19.71*/ (""":</strong></p><p class="col-md-6">"""), _display_( /*19.106*/ user /*19.110*/ .lastName.getOrElse("None")), format.raw /*19.137*/ ("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""), _display_( /*22.50*/ Messages("full.name")), format.raw /*22.71*/ (""":</strong></p><p class="col-md-6">"""), _display_( /*22.106*/ user /*22.110*/ .fullName.getOrElse("None")), format.raw /*22.137*/ ("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>"""), _display_( /*25.50*/ Messages("email")), format.raw /*25.67*/ (""":</strong></p><p class="col-md-6">"""), _display_( /*25.102*/ user /*25.106*/ .email.getOrElse("None")), format.raw /*25.130*/ ("""</p>
                </div>
                <div class="row">
                    <p class="col-md-6"><strong>Role:</strong></p><p class="col-md-6">"""), _display_( /*28.88*/ user /*28.92*/ .role.getOrElse("None")), format.raw /*28.115*/ ("""</p>
                </div>
            </div>
        </div>
    </div>
""")))
          }), format.raw /*33.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user)(request, messages, webJarAssets)

    def f: ((models.User) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request, messages, webJarAssets) => apply(user)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object home extends home_Scope0.home
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/home.scala.html
                  HASH: 75d77db2fec4a6506e60715a88de5053cfdc730d
                  MATRIX: 743->1|939->101|967->104|1015->144|1054->146|1085->151|1252->292|1301->321|1406->400|1418->404|1501->467|1768->707|1811->729|1874->764|1888->768|1938->796|2076->907|2118->928|2181->963|2195->967|2244->994|2382->1105|2424->1126|2487->1161|2501->1165|2550->1192|2688->1303|2726->1320|2789->1355|2803->1359|2849->1383|3025->1532|3038->1536|3083->1559|3187->1633
                  LINES: 26->1|31->1|33->3|33->3|33->3|34->4|37->7|37->7|39->9|39->9|39->9|46->16|46->16|46->16|46->16|46->16|49->19|49->19|49->19|49->19|49->19|52->22|52->22|52->22|52->22|52->22|55->25|55->25|55->25|55->25|55->25|58->28|58->28|58->28|63->33
                  -- GENERATED --
              */
