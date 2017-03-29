
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
  import models.nuts.Data._
  import models.nuts.FormsData._

  class listAll extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], Seq[models.nuts.Data.GoodsItem], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (userOption: Option[models.User], goodsItems: Seq[models.nuts.Data.GoodsItem])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.161*/ ("""
"""), format.raw /*2.26*/ ("""

"""), _display_( /*4.2*/ main(Messages("blog.title"), userOption) /*4.42*/ {
            _display_(Seq[Any](format.raw /*4.43*/ ("""
    """), _display_( /*5.6*/ {
              if (goodsItems.length <= 0) {
                <div class="col-md-10 col-md-offset-2 alert alert-danger">
                  <a href="#" class="close" data-dismiss="alert">&times;</a>
                  <strong>Messages("There is no goods in the shop !")</strong>
                </div>
              }
            }), format.raw /*10.7*/ ("""
    """), format.raw /*11.5*/ ("""<div class="row">
    """), _display_( /*12.6*/ for ((category, items) <- goodsItems.groupBy(_.category)) yield /*12.60*/ {
              _display_(Seq[Any](format.raw /*12.61*/ ("""
        """), format.raw /*13.9*/ ("""<h2 class="col col-sx-12 col-sm-12 col-md-12 col-ld-12">"""), _display_( /*13.66*/ category), format.raw /*13.74*/ ("""</h2>
        """), _display_( /*14.10*/ for (item <- items) yield /*14.26*/ {
                _display_(Seq[Any](format.raw /*14.27*/ ("""
            """), format.raw /*15.13*/ ("""<article class="col col-sx-3 col-sm-3 col-md-3 col-ld-3">
                <a href=""""), _display_( /*16.27*/ controllers /*16.38*/ .nuts.routes.Goods.get(item.id.get)), format.raw /*16.73*/ ("""">
                    """), _display_( /*17.22*/ if (item.image.isDefined) /*17.46*/ {
                  _display_(Seq[Any](format.raw /*17.47*/ ("""
                        """), format.raw /*18.25*/ ("""<!--<img class="img-responsive" src=""""), _display_( /*18.63*/ controllers /*18.74*/ .nuts.routes.Images.get(item.image.get)), format.raw /*18.113*/ (""""/>-->
                        <div style="background: url("""), _display_( /*19.54*/ controllers /*19.65*/ .nuts.routes.Images.get(item.image.get)), format.raw /*19.104*/ (""") center no-repeat; background-size:162px 162px;" class="cat_img">
                            <img width="162px" src="/assets/images/imgmaskt.png" alt="">
                        </div>
                        <div class="title">"""), _display_( /*22.45*/ item /*22.49*/ .title), format.raw /*22.55*/ ("""</div>
                    """)))
                }), format.raw /*23.22*/ ("""
                    """), format.raw /*24.21*/ ("""<!--<div class="image">-->
                        <!--<img src=""""), _display_( /*25.40*/ controllers /*25.51*/ .nuts.routes.Images.get(item.image.get)), format.raw /*25.90*/ (""""/>-->
                        <!--<div class="text">-->
                            <!--"""), _display_( /*27.34*/ item /*27.38*/ .title), format.raw /*27.44*/ ("""-->
                        <!--</div>-->
                    <!--</div>-->
                </a>
            </article>
        """)))
              }), format.raw /*32.10*/ ("""
        """), format.raw /*47.23*/ ("""
    """)))
            }), format.raw /*48.6*/ ("""
    """), format.raw /*49.5*/ ("""</div>

<!-- Include the Quill library -->
<!--<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>-->
<!--<link href="/assets/styles/blogEdit.css" rel="stylesheet"/>-->
<!--<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>-->
""")))
          }), format.raw /*55.2*/ ("""
"""))
        }
      }
    }

    def render(userOption: Option[models.User], goodsItems: Seq[models.nuts.Data.GoodsItem], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(userOption, goodsItems)(request, messages, webJarAssets)

    def f: ((Option[models.User], Seq[models.nuts.Data.GoodsItem]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (userOption, goodsItems) => (request, messages, webJarAssets) => apply(userOption, goodsItems)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object listAll extends listAll_Scope0.listAll
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:58 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/listAll.scala.html
                  HASH: e20731b0b9673d9c26cf83a8b82763c57beafda9
                  MATRIX: 675->1|930->160|958->186|986->189|1034->229|1072->230|1103->236|1382->495|1414->500|1463->523|1533->577|1572->578|1608->587|1692->644|1721->652|1763->667|1795->683|1834->684|1875->697|1986->781|2006->792|2062->827|2113->851|2146->875|2185->876|2238->901|2303->939|2323->950|2384->989|2471->1049|2491->1060|2552->1099|2810->1330|2823->1334|2850->1340|2909->1368|2958->1389|3051->1455|3071->1466|3131->1505|3248->1595|3261->1599|3288->1605|3448->1734|3485->2380|3521->2386|3553->2391|3848->2656
                  LINES: 22->1|27->1|28->2|30->4|30->4|30->4|31->5|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|40->14|40->14|41->15|42->16|42->16|42->16|43->17|43->17|43->17|44->18|44->18|44->18|44->18|45->19|45->19|45->19|48->22|48->22|48->22|49->23|50->24|51->25|51->25|51->25|53->27|53->27|53->27|58->32|59->47|60->48|61->49|67->55
                  -- GENERATED --
              */
