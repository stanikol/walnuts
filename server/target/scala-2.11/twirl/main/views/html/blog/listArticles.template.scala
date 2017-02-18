
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
                    """), format.raw /*16.21*/ ("""#"""), _display_( /*16.23*/ article /*16.30*/ .id.get), format.raw /*16.37*/ (""" """), _display_( /*16.39*/ article /*16.46*/ .title), format.raw /*16.52*/ (""" """), format.raw /*16.53*/ ("""<br> """), _display_( /*16.59*/ article /*16.66*/ .sort_order), format.raw /*16.77*/ ("""
                """)))
              } /*17.19*/ else /*17.24*/ {
                _display_(Seq[Any](format.raw /*17.25*/ ("""
                    """), _display_( /*18.22*/ article /*18.29*/ .title), format.raw /*18.35*/ ("""
                """)))
              }), format.raw /*19.18*/ ("""
            """), format.raw /*20.13*/ ("""</h2>
        </a><br>
        """), _display_( /*22.10*/ article /*22.17*/ .description), format.raw /*22.29*/ ("""
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
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/listArticles.scala.html
                  HASH: b74d9a29548c9f4356cd67b5aaf7cdeee0ad981e
                  MATRIX: 682->1|933->156|961->182|989->185|1037->225|1075->226|1106->232|1421->527|1453->533|1491->555|1530->556|1566->565|1616->588|1754->704|1818->741|1877->791|1916->792|1965->813|1994->815|2010->822|2038->829|2067->831|2083->838|2110->844|2139->845|2172->851|2188->858|2220->869|2257->888|2270->893|2309->894|2358->916|2374->923|2401->929|2450->947|2491->960|2550->992|2566->999|2599->1011|2635->1020|2675->1030|2704->1032|2987->1285
                  LINES: 22->1|27->1|28->2|30->4|30->4|30->4|31->5|36->10|37->11|37->11|37->11|38->12|39->13|39->13|41->15|41->15|41->15|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|42->16|43->17|43->17|43->17|44->18|44->18|44->18|45->19|46->20|48->22|48->22|48->22|49->23|50->24|52->26|56->30
                  -- GENERATED --
              */
