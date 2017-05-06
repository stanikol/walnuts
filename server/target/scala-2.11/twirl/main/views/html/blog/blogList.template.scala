
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object blogList_Scope0 {
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

  class blogList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], Seq[models.blog.Data.Article], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (userOption: Option[models.User], articles: Seq[models.blog.Data.Article])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.157*/ ("""
"""), format.raw /*2.26*/ ("""

"""), _display_( /*4.2*/ main(Messages("blog.title"), userOption) /*4.42*/ {
            _display_(Seq[Any](format.raw /*4.43*/ ("""
    """), _display_( /*5.6*/ {
              if (articles.length <= 0) {
                <div class="col-md-10 col-md-offset-2 alert alert-danger">
                  <a href="#" class="close" data-dismiss="alert">&times;</a>
                  <strong>No blog is found in DB, so it's nothing to display. Please contact administrator!</strong>
                </div>
              }
            }), format.raw /*10.7*/ ("""
    """), _display_( /*11.6*/ for (article <- articles) yield /*11.28*/ {
              _display_(Seq[Any](format.raw /*11.29*/ ("""
        """), format.raw /*12.9*/ ("""<br>
        """), format.raw /*26.19*/ ("""
        """), format.raw /*27.9*/ ("""<a href='"""), _display_( /*27.19*/ controllers /*27.30*/ .nuts.routes.Blog.article(article.id.get)), format.raw /*27.71*/ ("""' class="article-title-href">
            """), _display_( /*28.14*/ if (userOption.isDefined && userOption.get.isAdmin) /*28.64*/ {
                _display_(Seq[Any](format.raw /*28.65*/ ("""
                """), _display_( /*29.18*/ article /*29.25*/ .title), format.raw /*29.31*/ (""" """), format.raw /*29.32*/ ("""<br> #"""), _display_( /*29.39*/ article /*29.46*/ .id.get), format.raw /*29.53*/ (""" """), _display_( /*29.55*/ article /*29.62*/ .sort_order), format.raw /*29.73*/ ("""
            """)))
              } /*30.15*/ else /*30.20*/ {
                _display_(Seq[Any](format.raw /*30.21*/ ("""
                """), _display_( /*31.18*/ article /*31.25*/ .title), format.raw /*31.31*/ ("""
            """)))
              }), format.raw /*32.14*/ ("""
        """), format.raw /*33.9*/ ("""</a>
        <div class="article-short-text">"""), _display_( /*34.42*/ { article.short_text }), format.raw /*34.62*/ ("""</div>
    """)))
            }), format.raw /*35.6*/ ("""

"""), format.raw /*37.1*/ ("""<!-- Include the Quill library -->
<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
<!--<link href="/assets/styles/blogEdit.css" rel="stylesheet"/>-->
<!--<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>-->
""")))
          }), format.raw /*41.2*/ ("""
"""))
        }
      }
    }

    def render(userOption: Option[models.User], articles: Seq[models.blog.Data.Article], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(userOption, articles)(request, messages, webJarAssets)

    def f: ((Option[models.User], Seq[models.blog.Data.Article]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (userOption, articles) => (request, messages, webJarAssets) => apply(userOption, articles)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object blogList extends blogList_Scope0.blogList
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogList.scala.html
                  HASH: bee8efcecca8611d55b004f16bb1acb410c89015
                  MATRIX: 794->1|1045->156|1073->182|1101->185|1149->225|1187->226|1218->232|1533->527|1565->533|1603->555|1642->556|1678->565|1719->1143|1755->1152|1792->1162|1812->1173|1874->1214|1944->1257|2003->1307|2042->1308|2087->1326|2103->1333|2130->1339|2159->1340|2193->1347|2209->1354|2237->1361|2266->1363|2282->1370|2314->1381|2347->1396|2360->1401|2399->1402|2444->1420|2460->1427|2487->1433|2532->1447|2568->1456|2641->1502|2682->1522|2724->1534|2753->1536|3033->1786
                  LINES: 26->1|31->1|32->2|34->4|34->4|34->4|35->5|40->10|41->11|41->11|41->11|42->12|43->26|44->27|44->27|44->27|44->27|45->28|45->28|45->28|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|46->29|47->30|47->30|47->30|48->31|48->31|48->31|49->32|50->33|51->34|51->34|52->35|54->37|58->41
                  -- GENERATED --
              */
