
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object listArticles_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class listArticles extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Option[models.User], Seq[models.nuts.Data.Article], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

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
        <a href='"""), _display_( /*13.19*/ { if (userOption.isDefined && userOption.get.isAdmin) s"/blog/${article.id.get}/edit" else s"/blog/${article.id.get}" }), format.raw /*13.135*/ ("""'>
            <h2>
                """), _display_( /*15.18*/ if (userOption.isDefined && userOption.get.isAdmin) /*15.68*/ {
                _display_(Seq[Any](format.raw /*15.69*/ ("""
                    """), _display_( /*16.22*/ article /*16.29*/ .title), format.raw /*16.35*/ (""" """), format.raw /*16.36*/ ("""<br> #"""), _display_( /*16.43*/ article /*16.50*/ .id.get), format.raw /*16.57*/ (""" """), _display_( /*16.59*/ article /*16.66*/ .sort_order), format.raw /*16.77*/ ("""
                """)))
              } /*17.19*/ else /*17.24*/ {
                _display_(Seq[Any](format.raw /*17.25*/ ("""
                    """), _display_( /*18.22*/ article /*18.29*/ .title), format.raw /*18.35*/ ("""
                """)))
              }), format.raw /*19.18*/ ("""
            """), format.raw /*20.13*/ ("""</h2>
        </a><br>
        """), _display_( /*22.10*/ { article.short_text }), format.raw /*22.30*/ ("""
        """), format.raw /*23.9*/ ("""<br>
    """)))
            }), format.raw /*24.6*/ ("""

"""), format.raw /*26.1*/ ("""<!-- Include the Quill library -->
<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
<!--<link href="/assets/styles/editArticle.css" rel="stylesheet"/>-->
<!--<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>-->
""")))
          }), format.raw /*30.2*/ ("""
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
object listArticles extends listArticles_Scope0.listArticles
/*
                  -- GENERATED --
                  DATE: Tue Mar 14 20:58:39 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/listArticles.scala.html
                  HASH: 577b78bbcb418e9e81b466e9797947276b732a8e
                  MATRIX: 682->1|933->156|961->182|989->185|1037->225|1075->226|1106->232|1421->527|1453->533|1491->555|1530->556|1566->565|1616->588|1754->704|1818->741|1877->791|1916->792|1965->814|1981->821|2008->827|2037->828|2071->835|2087->842|2115->849|2144->851|2160->858|2192->869|2229->888|2242->893|2281->894|2330->916|2346->923|2373->929|2422->947|2463->960|2522->992|2563->1012|2599->1021|2639->1031|2668->1033|2951->1286
                  LINES: 22->1|27->1|28->2|30->4|30->4|30->4|31->5|36->10|37->11|37->11|37->11|38->12|39->13|39->13|41->15|41->15|41->15|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|43->17|43->17|43->17|44->18|44->18|44->18|45->19|46->20|48->22|48->22|49->23|50->24|52->26|56->30
                  -- GENERATED --
              */
