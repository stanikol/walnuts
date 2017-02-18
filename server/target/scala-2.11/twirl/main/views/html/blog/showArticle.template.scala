
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object showArticle_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class showArticle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], models.nuts.Data.Article, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*2.2*/ (user: Option[models.User], article: models.nuts.Data.Article)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*2.145*/ ("""

"""), format.raw /*5.1*/ ("""
"""), _display_( /*6.2*/ main(article.title, user, article.keywords, article.description) /*6.66*/ {
            _display_(Seq[Any](format.raw /*6.67*/ ("""
    """), format.raw /*7.5*/ ("""<a href=""""), _display_( /*7.15*/ controllers /*7.26*/ .nuts.routes.Blog.showAllArticles), format.raw /*7.59*/ ("""">
        <h1>"""), _display_( /*8.14*/ Messages("Blog")), format.raw /*8.30*/ ("""</h1>
    </a>
    """), format.raw /*15.8*/ ("""
    """), format.raw /*16.5*/ ("""<div class="article">
        <strong>ID #"""), _display_( /*17.22*/ { article.id.getOrElse("") }), format.raw /*17.48*/ ("""</strong>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*19.61*/ Messages("editArticle.title")), format.raw /*19.90*/ ("""</label>
            <textarea type="text" id="article-title" name="article-title" class="form-control" disabled>"""), _display_( /*20.106*/ { article.title }), format.raw /*20.121*/ ("""</textarea>
        </div>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*23.61*/ Messages("editArticle.description")), format.raw /*23.96*/ ("""</label>
            <textarea type="text" id="description" name="description" class="form-control" disabled>"""), _display_( /*24.102*/ { article.description }), format.raw /*24.123*/ ("""</textarea>
        </div>
        <div class="blog-text" disabled>"""), _display_( /*26.42*/ Html(article.text)), format.raw /*26.60*/ ("""</div>
        <div class="form-group">
            <label for="keywords" class="control-label">"""), _display_( /*28.58*/ Messages("editArticle.keywords")), format.raw /*28.90*/ ("""</label>
            <input type="text" id="keywords" name="keywords" value='"""), _display_( /*29.70*/ { article.keywords }), format.raw /*29.88*/ ("""'
                   class="form-control" disabled/>
        </div>
        <div class="form-group">
            <label for="sort-order" class="control-label">"""), _display_( /*33.60*/ Messages("editArticle.sort-order")), format.raw /*33.94*/ ("""</label>
            <input type="text" id="sort-order" name="sort-order" value='"""), _display_( /*34.74*/ { article.sort_order }), format.raw /*34.94*/ ("""'
                   class="form-control" disabled/>
        </div>
    </div>
""")))
          }), format.raw /*38.2*/ ("""



"""))
        }
      }
    }

    def render(user: Option[models.User], article: models.nuts.Data.Article, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, article)(request, messages, webJarAssets)

    def f: ((Option[models.User], models.nuts.Data.Article) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, article) => (request, messages, webJarAssets) => apply(user, article)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object showArticle extends showArticle_Scope0.showArticle
/*
                  -- GENERATED --
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/showArticle.scala.html
                  HASH: 342e2b654babc0f8ffb8b08b425d34fdd6e1d2cf
                  MATRIX: 675->2|932->145|960->167|987->169|1059->233|1097->234|1128->239|1164->249|1183->260|1236->293|1278->309|1314->325|1360->593|1392->598|1462->641|1509->667|1639->770|1689->799|1831->913|1868->928|2015->1048|2071->1083|2209->1193|2252->1214|2347->1282|2386->1300|2510->1397|2563->1429|2668->1507|2707->1525|2894->1685|2949->1719|3058->1801|3099->1821|3209->1901
                  LINES: 22->2|27->2|29->5|30->6|30->6|30->6|31->7|31->7|31->7|31->7|32->8|32->8|34->15|35->16|36->17|36->17|38->19|38->19|39->20|39->20|42->23|42->23|43->24|43->24|45->26|45->26|47->28|47->28|48->29|48->29|52->33|52->33|53->34|53->34|57->38
                  -- GENERATED --
              */
