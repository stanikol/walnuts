
package views.html.goods

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object showItem_Scope0 {
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

class showItem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User],GoodsItemView,RequestHeader,Messages,WebJarAssets,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: Option[models.User], goodsItem: GoodsItemView)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper.CSRF

Seq[Any](format.raw/*2.136*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main(goodsItem.title, user)/*6.29*/{_display_(Seq[Any](format.raw/*6.30*/("""
    """),format.raw/*7.5*/("""<div class="row">
        """),_display_(/*8.10*/if(goodsItem.image.isDefined)/*8.39*/{_display_(Seq[Any](format.raw/*8.40*/("""
            """),format.raw/*9.13*/("""<div id="item_img" class="col col-xm-6 col-sm-6 col-md-6 col-ld-6">
                <img class="someitem" src=""""),_display_(/*10.45*/controllers/*10.56*/.images.routes.Images.getImage(goodsItem.image.get)),format.raw/*10.107*/("""" alt=""""),_display_(/*10.115*/goodsItem/*10.124*/.title),format.raw/*10.130*/("""">
            </div>
        """)))}),format.raw/*12.10*/("""
        """),format.raw/*13.9*/("""<div class="col col-xm-6 col-sm-6 col-md-6 col-ld-6">
            <h1>"""),_display_(/*14.18*/{goodsItem.title}),format.raw/*14.35*/("""</h1>
            <h2>"""),_display_(/*15.18*/{goodsItem.category}),format.raw/*15.38*/("""</h2>
        </div>

    </div>
    <div class="goodsItem">
        <div class="goodsItem-text" disabled>"""),_display_(/*20.47*/Html(goodsItem.description)),format.raw/*20.74*/("""</div>
    </div>
    <br>
    """),_display_(/*23.6*/user/*23.10*/.map/*23.14*/{ usr =>_display_(Seq[Any](format.raw/*23.22*/("""
        """),_display_(/*24.10*/if(usr.isAdmin)/*24.25*/{_display_(Seq[Any](format.raw/*24.26*/("""
            """),format.raw/*25.13*/("""<a href=""""),_display_(/*25.23*/CSRF(controllers.goods.routes.Goods.showItemEditForm(goodsItem.id))),format.raw/*25.90*/("""" class="btn btn-danger">"""),_display_(/*25.116*/Messages("Edit")),format.raw/*25.132*/("""</a>
        """)))}),format.raw/*26.10*/("""
    """)))}),format.raw/*27.6*/("""
""")))}),format.raw/*28.2*/("""



"""))
      }
    }
  }

  def render(user:Option[models.User],goodsItem:GoodsItemView,request:RequestHeader,messages:Messages,webJarAssets:WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user,goodsItem)(request,messages,webJarAssets)

  def f:((Option[models.User],GoodsItemView) => (RequestHeader,Messages,WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user,goodsItem) => (request,messages,webJarAssets) => apply(user,goodsItem)(request,messages,webJarAssets)

  def ref: this.type = this

}


}

/**/
object showItem extends showItem_Scope0.showItem
              /*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/showItem.scala.html
                  HASH: 1fb3a81511fcb5b85397a8bdde44dd8630a87932
                  MATRIX: 779->2|1027->136|1055->158|1082->160|1117->187|1155->188|1186->193|1239->220|1276->249|1314->250|1354->263|1493->375|1513->386|1586->437|1622->445|1641->454|1669->460|1731->491|1767->500|1865->571|1903->588|1953->611|1994->631|2128->738|2176->765|2234->797|2247->801|2260->805|2306->813|2343->823|2367->838|2406->839|2447->852|2484->862|2572->929|2626->955|2664->971|2709->985|2745->991|2777->993
                  LINES: 26->2|31->2|33->5|34->6|34->6|34->6|35->7|36->8|36->8|36->8|37->9|38->10|38->10|38->10|38->10|38->10|38->10|40->12|41->13|42->14|42->14|43->15|43->15|48->20|48->20|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|54->26|55->27|56->28
                  -- GENERATED --
              */
          