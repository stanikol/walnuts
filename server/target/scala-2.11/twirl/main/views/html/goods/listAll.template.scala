
package views.html.goods

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object listAll_Scope0 {
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

class listAll extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User],Seq[GoodsItemView],RequestHeader,Messages,WebJarAssets,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userOption: Option[models.User], goodsItems: Seq[GoodsItemView])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*2.26*/("""

"""),_display_(/*4.2*/main(Messages("blog.title"), userOption)/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""
    """),_display_(/*5.6*/{if(goodsItems.length<=0){
        <div class="col-md-10 col-md-offset-2 alert alert-danger">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>Messages("There is no goods in the shop !")</strong>
        </div>
    }}),format.raw/*10.7*/("""
    """),format.raw/*11.5*/("""<div class="row">
        """),_display_(/*12.10*/goodsItems/*12.20*/.map(gi => (gi.categorySortOrder, gi.category)).toSet[(String, String)].toList.sortBy(_._1).map/*12.115*/{ case (_: String, category: String) =>_display_(Seq[Any](format.raw/*12.154*/("""
            """),format.raw/*13.13*/("""<h2 class="col col-sx-12 col-sm-12 col-md-12 col-ld-12">"""),_display_(/*13.70*/category),format.raw/*13.78*/("""</h2>
            """),_display_(/*14.14*/goodsItems/*14.24*/.filter(_.category == category).sortBy(_.sortOrder).map/*14.79*/ { item =>_display_(Seq[Any](format.raw/*14.89*/("""
                """),format.raw/*15.17*/("""<article class="col col-sx-3 col-sm-3 col-md-3 col-ld-3">
                    <a href=""""),_display_(/*16.31*/controllers/*16.42*/.goods.routes.Goods.getGoodsItem(item.id.get)),format.raw/*16.87*/("""">
                        """),_display_(/*17.26*/if(item.image.isDefined)/*17.50*/{_display_(Seq[Any](format.raw/*17.51*/("""
                            """),format.raw/*18.29*/("""<div style="background: url("""),_display_(/*18.58*/controllers/*18.69*/.images.routes.Images.getImage(item.image.get)),format.raw/*18.115*/(""") center no-repeat; background-size:162px 162px;" class="cat_img">
                                <img width="162px" src="/assets/images/imgmaskt.png" alt="">
                            </div>
                            <div class="title">"""),_display_(/*21.49*/item/*21.53*/.title),format.raw/*21.59*/("""</div>
                        """)))}),format.raw/*22.26*/("""
                    """),format.raw/*23.21*/("""</a>
                </article>
            """)))}),format.raw/*25.14*/("""
        """)))}),format.raw/*26.10*/("""
        """),format.raw/*48.18*/("""
        """),format.raw/*64.23*/("""
    """),format.raw/*65.5*/("""</div>

<!-- Include the Quill library -->
<!--<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>-->
<!--<link href="/assets/styles/blogEdit.css" rel="stylesheet"/>-->
<!--<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>-->
""")))}),format.raw/*71.2*/("""
"""))
      }
    }
  }

  def render(userOption:Option[models.User],goodsItems:Seq[GoodsItemView],request:RequestHeader,messages:Messages,webJarAssets:WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(userOption,goodsItems)(request,messages,webJarAssets)

  def f:((Option[models.User],Seq[GoodsItemView]) => (RequestHeader,Messages,WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (userOption,goodsItems) => (request,messages,webJarAssets) => apply(userOption,goodsItems)(request,messages,webJarAssets)

  def ref: this.type = this

}


}

/**/
object listAll extends listAll_Scope0.listAll
              /*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/listAll.scala.html
                  HASH: 42eb96c410e7bedb029be9d3a920218bf0e59e09
                  MATRIX: 782->1|1024->147|1052->173|1080->176|1128->216|1166->217|1197->223|1476->482|1508->487|1562->514|1581->524|1686->619|1764->658|1805->671|1889->728|1918->736|1964->755|1983->765|2047->820|2095->830|2140->847|2255->935|2275->946|2341->991|2396->1019|2429->1043|2468->1044|2525->1073|2581->1102|2601->1113|2669->1159|2939->1402|2952->1406|2979->1412|3042->1444|3091->1465|3167->1510|3208->1520|3245->2696|3282->3348|3314->3353|3609->3618
                  LINES: 26->1|31->1|32->2|34->4|34->4|34->4|35->5|40->10|41->11|42->12|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|44->14|45->15|46->16|46->16|46->16|47->17|47->17|47->17|48->18|48->18|48->18|48->18|51->21|51->21|51->21|52->22|53->23|55->25|56->26|57->48|58->64|59->65|65->71
                  -- GENERATED --
              */
          