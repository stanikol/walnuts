
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
  import models.nuts.Data._
  import models.nuts.FormsData._

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
                  DATE: Mon Mar 20 14:32:37 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/home.scala.html
                  HASH: 51d3020496933581e5f0f5bb9f5051e673506f9f
                  MATRIX: 623->1|819->101|847->104|895->144|934->146|965->151|1132->292|1181->321|1286->400|1298->404|1381->467|1648->707|1691->729|1754->764|1768->768|1818->796|1956->907|1998->928|2061->963|2075->967|2124->994|2262->1105|2304->1126|2367->1161|2381->1165|2430->1192|2568->1303|2606->1320|2669->1355|2683->1359|2729->1383|2905->1532|2918->1536|2963->1559|3067->1633
                  LINES: 22->1|27->1|29->3|29->3|29->3|30->4|33->7|33->7|35->9|35->9|35->9|42->16|42->16|42->16|42->16|42->16|45->19|45->19|45->19|45->19|45->19|48->22|48->22|48->22|48->22|48->22|51->25|51->25|51->25|51->25|51->25|54->28|54->28|54->28|59->33
                  -- GENERATED --
              */
