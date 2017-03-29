
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
  import models.nuts.Data._
  import models.nuts.FormsData._

  class blogList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], Seq[models.nuts.Data.Article], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (userOption: Option[models.User], articles: Seq[models.nuts.Data.Article])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
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

    def render(userOption: Option[models.User], articles: Seq[models.nuts.Data.Article], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(userOption, articles)(request, messages, webJarAssets)

    def f: ((Option[models.User], Seq[models.nuts.Data.Article]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (userOption, articles) => (request, messages, webJarAssets) => apply(userOption, articles)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object blogList extends blogList_Scope0.blogList
/*
                  -- GENERATED --
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogList.scala.html
                  HASH: 6eb8b3690b3dd39095c41c223351f9ca9beafc12
                  MATRIX: 674->1|925->156|953->182|981->185|1029->225|1067->226|1098->232|1413->527|1445->533|1483->555|1522->556|1558->565|1599->1143|1635->1152|1672->1162|1692->1173|1754->1214|1824->1257|1883->1307|1922->1308|1967->1326|1983->1333|2010->1339|2039->1340|2073->1347|2089->1354|2117->1361|2146->1363|2162->1370|2194->1381|2227->1396|2240->1401|2279->1402|2324->1420|2340->1427|2367->1433|2412->1447|2448->1456|2521->1502|2562->1522|2604->1534|2633->1536|2913->1786
                  LINES: 22->1|27->1|28->2|30->4|30->4|30->4|31->5|36->10|37->11|37->11|37->11|38->12|39->26|40->27|40->27|40->27|40->27|41->28|41->28|41->28|42->29|42->29|42->29|42->29|42->29|42->29|42->29|42->29|42->29|42->29|43->30|43->30|43->30|44->31|44->31|44->31|45->32|46->33|47->34|47->34|48->35|50->37|54->41
                  -- GENERATED --
              */
