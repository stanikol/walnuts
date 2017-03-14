
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

  class showArticle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Option[models.User], Article, Seq[Comment], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*2.2*/ (user: Option[models.User], article: Article, comments: Seq[Comment])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*2.152*/ ("""

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
    """), _display_( /*38.6*/ for (comment <- comments) yield /*38.28*/ {
              _display_(Seq[Any](format.raw /*38.29*/ ("""
        """), format.raw /*39.9*/ ("""<hr>
        """), _display_( /*40.10*/ comment /*40.17*/ .userID), format.raw /*40.24*/ (""" """), _display_( /*40.26*/ comment /*40.33*/ .added), format.raw /*40.39*/ ("""<br>
        """), _display_( /*41.10*/ comment /*41.17*/ .text), format.raw /*41.22*/ ("""
        """), format.raw /*42.9*/ ("""<hr>
    """)))
            }), format.raw /*43.6*/ ("""
""")))
          }), format.raw /*44.2*/ ("""



"""))
        }
      }
    }

    def render(user: Option[models.User], article: Article, comments: Seq[Comment], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, article, comments)(request, messages, webJarAssets)

    def f: ((Option[models.User], Article, Seq[Comment]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, article, comments) => (request, messages, webJarAssets) => apply(user, article, comments)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object showArticle extends showArticle_Scope0.showArticle
/*
                  -- GENERATED --
                  DATE: Sat Mar 11 02:26:19 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/showArticle.scala.html
                  HASH: 04ed7fa1bcfdd4802dd0c1b10d507db07d88920a
                  MATRIX: 671->2|935->152|963->174|990->176|1062->240|1100->241|1131->246|1167->256|1186->267|1239->300|1281->316|1317->332|1363->600|1395->605|1465->648|1512->674|1642->777|1692->806|1834->920|1871->935|2018->1055|2074->1090|2212->1200|2255->1221|2350->1289|2389->1307|2513->1404|2566->1436|2671->1514|2710->1532|2897->1692|2952->1726|3061->1808|3102->1828|3212->1912|3250->1934|3289->1935|3325->1944|3366->1958|3382->1965|3410->1972|3439->1974|3455->1981|3482->1987|3523->2001|3539->2008|3565->2013|3601->2022|3641->2032|3673->2034
                  LINES: 22->2|27->2|29->5|30->6|30->6|30->6|31->7|31->7|31->7|31->7|32->8|32->8|34->15|35->16|36->17|36->17|38->19|38->19|39->20|39->20|42->23|42->23|43->24|43->24|45->26|45->26|47->28|47->28|48->29|48->29|52->33|52->33|53->34|53->34|57->38|57->38|57->38|58->39|59->40|59->40|59->40|59->40|59->40|59->40|60->41|60->41|60->41|61->42|62->43|63->44
                  -- GENERATED --
              */
