
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
  import models.nuts.Data._
  import models.nuts.FormsData._

  class showItem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], GoodsItem, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*2.2*/ (user: Option[models.User], goodsItem: GoodsItem)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*2.132*/ ("""

"""), format.raw /*5.1*/ ("""
"""), _display_( /*6.2*/ main(goodsItem.title, user) /*6.29*/ {
            _display_(Seq[Any](format.raw /*6.30*/ ("""
    """), format.raw /*7.5*/ ("""<div class="row">
        """), _display_( /*8.10*/ if (goodsItem.image.isDefined) /*8.39*/ {
              _display_(Seq[Any](format.raw /*8.40*/ ("""
            """), format.raw /*9.13*/ ("""<div id="item_img" class="col col-xm-6 col-sm-6 col-md-6 col-ld-6">
                <img class="someitem" src=""""), _display_( /*10.45*/ controllers /*10.56*/ .nuts.routes.Images.get(goodsItem.image.get)), format.raw /*10.100*/ ("""" alt=""""), _display_( /*10.108*/ goodsItem /*10.117*/ .title), format.raw /*10.123*/ ("""">
            </div>
        """)))
            }), format.raw /*12.10*/ ("""
        """), format.raw /*13.9*/ ("""<div class="col col-xm-6 col-sm-6 col-md-6 col-ld-6">
            <h1>"""), _display_( /*14.18*/ { goodsItem.title }), format.raw /*14.35*/ ("""</h1>
            <h2>"""), _display_( /*15.18*/ { goodsItem.category }), format.raw /*15.38*/ ("""</h2>
        </div>

    </div>
    <div class="goodsItem">
        <div class="goodsItem-text" disabled>"""), _display_( /*20.47*/ Html(goodsItem.description)), format.raw /*20.74*/ ("""</div>
    </div>
    <br>
    """), _display_( /*23.6*/ user /*23.10*/ .map /*23.14*/ { usr =>
              _display_(Seq[Any](format.raw /*23.22*/ ("""
        """), _display_( /*24.10*/ if (usr.isAdmin) /*24.25*/ {
                _display_(Seq[Any](format.raw /*24.26*/ ("""
            """), format.raw /*25.13*/ ("""<form action="#" method="get">
                """), _display_( /*26.18*/ helper /*26.24*/ .CSRF.formField), format.raw /*26.39*/ ("""
                """), format.raw /*27.17*/ ("""<button type="submit" class="btn btn-danger">"""), _display_( /*27.63*/ Messages("Edit")), format.raw /*27.79*/ ("""</button>
            </form>
        """)))
              }), format.raw /*29.10*/ ("""
    """)))
            }), format.raw /*30.6*/ ("""
""")))
          }), format.raw /*31.2*/ ("""



"""))
        }
      }
    }

    def render(user: Option[models.User], goodsItem: GoodsItem, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, goodsItem)(request, messages, webJarAssets)

    def f: ((Option[models.User], GoodsItem) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, goodsItem) => (request, messages, webJarAssets) => apply(user, goodsItem)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object showItem extends showItem_Scope0.showItem
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:58 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/showItem.scala.html
                  HASH: 93f4c47c724e35d059b8e166f4477e1235e86c32
                  MATRIX: 655->2|899->132|927->154|954->156|989->183|1027->184|1058->189|1111->216|1148->245|1186->246|1226->259|1365->371|1385->382|1451->426|1487->434|1506->443|1534->449|1596->480|1632->489|1730->560|1768->577|1818->600|1859->620|1993->727|2041->754|2099->786|2112->790|2125->794|2171->802|2208->812|2232->827|2271->828|2312->841|2387->889|2402->895|2438->910|2483->927|2556->973|2593->989|2663->1028|2699->1034|2731->1036
                  LINES: 22->2|27->2|29->5|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|34->10|34->10|34->10|34->10|36->12|37->13|38->14|38->14|39->15|39->15|44->20|44->20|47->23|47->23|47->23|47->23|48->24|48->24|48->24|49->25|50->26|50->26|50->26|51->27|51->27|51->27|53->29|54->30|55->31
                  -- GENERATED --
              */
