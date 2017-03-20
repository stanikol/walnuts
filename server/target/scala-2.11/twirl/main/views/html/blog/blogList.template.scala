
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
        <a href='"""), _display_( /*13.19*/ if (userOption.isDefined && userOption.get.isAdmin) /*13.69*/ {
                _display_(Seq[Any](format.raw /*13.70*/ ("""
                    """), _display_( /*14.22*/ controllers /*14.33*/ .nuts.routes.Blog.edit(article.id.get)), format.raw /*14.71*/ ("""
                """)))
              } /*15.19*/ else /*15.24*/ {
                _display_(Seq[Any](format.raw /*15.25*/ ("""
                    """), _display_( /*16.22*/ controllers /*16.33*/ .nuts.routes.Blog.article(article.id.get)), format.raw /*16.74*/ ("""
                """)))
              }), format.raw /*17.18*/ ("""'
            class="article-title-href">
                """), _display_( /*19.18*/ if (userOption.isDefined && userOption.get.isAdmin) /*19.68*/ {
                _display_(Seq[Any](format.raw /*19.69*/ ("""
                    """), _display_( /*20.22*/ article /*20.29*/ .title), format.raw /*20.35*/ (""" """), format.raw /*20.36*/ ("""<br> #"""), _display_( /*20.43*/ article /*20.50*/ .id.get), format.raw /*20.57*/ (""" """), _display_( /*20.59*/ article /*20.66*/ .sort_order), format.raw /*20.77*/ ("""
                """)))
              } /*21.19*/ else /*21.24*/ {
                _display_(Seq[Any](format.raw /*21.25*/ ("""
                    """), _display_( /*22.22*/ article /*22.29*/ .title), format.raw /*22.35*/ ("""
                """)))
              }), format.raw /*23.18*/ ("""
        """), format.raw /*24.9*/ ("""</a>
        <div class="article-short-text">"""), _display_( /*25.42*/ { article.short_text }), format.raw /*25.62*/ ("""</div>
    """)))
            }), format.raw /*26.6*/ ("""

"""), format.raw /*28.1*/ ("""<!-- Include the Quill library -->
<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
<!--<link href="/assets/styles/blogEdit.css" rel="stylesheet"/>-->
<!--<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>-->
""")))
          }), format.raw /*32.2*/ ("""
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
                  DATE: Mon Mar 20 14:42:52 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogList.scala.html
                  HASH: 07c4d86382267830602b90855f6a19f605f65173
                  MATRIX: 674->1|925->156|953->182|981->185|1029->225|1067->226|1098->232|1413->527|1445->533|1483->555|1522->556|1558->565|1608->588|1667->638|1706->639|1755->661|1775->672|1834->710|1871->729|1884->734|1923->735|1972->757|1992->768|2054->809|2103->827|2189->886|2248->936|2287->937|2336->959|2352->966|2379->972|2408->973|2442->980|2458->987|2486->994|2515->996|2531->1003|2563->1014|2600->1033|2613->1038|2652->1039|2701->1061|2717->1068|2744->1074|2793->1092|2829->1101|2902->1147|2943->1167|2985->1179|3014->1181|3294->1431
                  LINES: 22->1|27->1|28->2|30->4|30->4|30->4|31->5|36->10|37->11|37->11|37->11|38->12|39->13|39->13|39->13|40->14|40->14|40->14|41->15|41->15|41->15|42->16|42->16|42->16|43->17|45->19|45->19|45->19|46->20|46->20|46->20|46->20|46->20|46->20|46->20|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|49->23|50->24|51->25|51->25|52->26|54->28|58->32
                  -- GENERATED --
              */
