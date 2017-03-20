
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object blogShow_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class blogShow extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[Option[models.User], Article, Seq[CommentInfo], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*2.2*/ (user: Option[models.User], article: Article, comments: Seq[CommentInfo])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*2.156*/ ("""

"""), format.raw /*5.1*/ ("""
"""), _display_( /*6.2*/ main(article.title, user, article.keywords, article.description) /*6.66*/ {
            _display_(Seq[Any](format.raw /*6.67*/ ("""
    """), format.raw /*7.5*/ ("""<a href=""""), _display_( /*7.15*/ controllers /*7.26*/ .nuts.routes.Blog.showAllArticles), format.raw /*7.59*/ ("""">
        <h1>"""), _display_( /*8.14*/ Messages("Blog")), format.raw /*8.30*/ ("""</h1>
    </a>
    <div class="article">
        <h1>"""), _display_( /*11.14*/ { article.title }), format.raw /*11.29*/ ("""</h1>
        <div class="article-text" disabled>"""), _display_( /*12.45*/ Html(article.text)), format.raw /*12.63*/ ("""</div>
    </div>
    """), _display_( /*14.6*/ for (comment <- comments) yield /*14.28*/ {
              _display_(Seq[Any](format.raw /*14.29*/ ("""
        """), format.raw /*15.9*/ ("""<hr>
        <div class="row">
            <h5 class="col col-xs-3">"""), _display_( /*17.39*/ comment /*17.46*/ .fullName), format.raw /*17.55*/ (""" """), format.raw /*17.56*/ ("""</h5> <h6 class="col col-xs-3 col-xs-offset-6">"""), _display_( /*17.104*/ comment /*17.111*/ .added), format.raw /*17.117*/ ("""</h6>
        </div>
        <div class="feedtext">
            """), _display_( /*20.14*/ comment /*20.21*/ .text), format.raw /*20.26*/ ("""
        """), format.raw /*21.9*/ ("""</div>
    """)))
            }), format.raw /*22.6*/ ("""
    """), format.raw /*23.5*/ ("""<br>
    """), _display_( /*24.6*/ user /*24.10*/ .map /*24.14*/ { usr =>
              _display_(Seq[Any](format.raw /*24.22*/ ("""
        """), _display_( /*25.10*/ if (usr.isAdmin) /*25.25*/ {
                _display_(Seq[Any](format.raw /*25.26*/ ("""
            """), format.raw /*26.13*/ ("""<form action=""""), _display_( /*26.28*/ controllers /*26.39*/ .nuts.routes.Blog.edit(article.id.get)), format.raw /*26.77*/ ("""" method="get">
                """), _display_( /*27.18*/ helper /*27.24*/ .CSRF.formField), format.raw /*27.39*/ ("""
                """), format.raw /*28.17*/ ("""<button type="submit" class="btn btn-danger">"""), _display_( /*28.63*/ Messages("Edit")), format.raw /*28.79*/ ("""</button>
            </form>
        """)))
              }), format.raw /*30.10*/ ("""
    """)))
            }), format.raw /*31.6*/ ("""
    """), format.raw /*32.5*/ ("""<form action=""""), _display_( /*32.20*/ controllers /*32.31*/ .nuts.routes.Comments.addComment), format.raw /*32.63*/ ("""" method="post" id="addCommentForm">
        <button type="submit" class="btn btn-warning">"""), _display_( /*33.56*/ Messages("Add comment")), format.raw /*33.79*/ ("""</button>
        """), _display_( /*34.10*/ helper /*34.16*/ .CSRF.formField), format.raw /*34.31*/ ("""
        """), format.raw /*35.9*/ ("""<input type="hidden" value=""""), _display_( /*35.38*/ { article.id }), format.raw /*35.50*/ ("""" name="article-id"/>
        """), _display_( /*36.10*/ user /*36.14*/ .map /*36.18*/ { usr =>
              _display_(Seq[Any](format.raw /*36.26*/ ("""
            """), format.raw /*37.13*/ ("""<textarea name="article-comment" id="article-comment" placeholder=""""), _display_( /*37.81*/ Messages("Add your comment here ...")), format.raw /*37.118*/ ("""" rows="10"></textarea>
        """)))
            }), format.raw /*38.10*/ ("""
    """), format.raw /*39.5*/ ("""</form>

    <script>
        let dlg = $('<div class="dialog" title=""""), _display_( /*42.50*/ Messages("Registration or login required!")), format.raw /*42.93*/ ("""">\
            <p class="bg-danger">"""), _display_( /*43.35*/ Messages("Please signin or signup to leave yor comment. Thank you.")), format.raw /*43.103*/ ("""</p> \
            </div>').dialog("""), format.raw /*44.29*/ ("""{"""), format.raw /*44.30*/ ("""
                """), format.raw /*45.17*/ ("""resizable: false,
                autoOpen: false,
                //height:140,
                modal: true,
                buttons: ["""), format.raw /*49.27*/ ("""{"""), format.raw /*49.28*/ ("""
                    """), format.raw /*50.21*/ ("""text: """"), _display_( /*50.29*/ Messages("Login")), format.raw /*50.46*/ ("""",
                    click: function() """), format.raw /*51.39*/ ("""{"""), format.raw /*51.40*/ ("""
                        """), format.raw /*52.25*/ ("""//$( this ).dialog( "close" );
                        window.location.href = '"""), _display_( /*53.50*/ controllers /*53.61*/ .auth.routes.SignInController.view), format.raw /*53.95*/ ("""';
                    """), format.raw /*54.21*/ ("""}"""), format.raw /*54.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*56.17*/ ("""}"""), format.raw /*56.18*/ (""", """), format.raw /*56.20*/ ("""{"""), format.raw /*56.21*/ ("""
                    """), format.raw /*57.21*/ ("""text: """"), _display_( /*57.29*/ Messages("SignUp")), format.raw /*57.47*/ ("""",
                    click : function() """), format.raw /*58.40*/ ("""{"""), format.raw /*58.41*/ ("""
                        """), format.raw /*59.25*/ ("""window.location.href = '"""), _display_( /*59.50*/ controllers /*59.61*/ .auth.routes.SignUpController.view), format.raw /*59.95*/ ("""';
                    """), format.raw /*60.21*/ ("""}"""), format.raw /*60.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*62.17*/ ("""}"""), format.raw /*62.18*/ (""", """), format.raw /*62.20*/ ("""{"""), format.raw /*62.21*/ ("""
                    """), format.raw /*63.21*/ ("""text: """"), _display_( /*63.29*/ Messages("Cancel")), format.raw /*63.47*/ ("""",
                    click: function() """), format.raw /*64.39*/ ("""{"""), format.raw /*64.40*/ ("""
                        """), format.raw /*65.25*/ ("""$( this ).dialog( "close" );
                    """), format.raw /*66.21*/ ("""}"""), format.raw /*66.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*68.17*/ ("""}"""), format.raw /*68.18*/ ("""]
            """), format.raw /*69.13*/ ("""}"""), format.raw /*69.14*/ (""");

        function onAddCommentFormSubmit()"""), format.raw /*71.42*/ ("""{"""), format.raw /*71.43*/ ("""
            """), _display_( /*72.14*/ if (user.isDefined) /*72.32*/ {
              _display_(Seq[Any](format.raw /*72.33*/ ("""
                """), format.raw /*73.17*/ ("""return true;
            """)))
            } /*74.15*/ else /*74.20*/ {
              _display_(Seq[Any](format.raw /*74.21*/ ("""
                """), format.raw /*75.17*/ ("""dlg.dialog('open');
                return false;
            """)))
            }), format.raw /*77.14*/ ("""
        """), format.raw /*78.9*/ ("""}"""), format.raw /*78.10*/ (""";
        $(document).ready(function()"""), format.raw /*79.37*/ ("""{"""), format.raw /*79.38*/ ("""
            """), format.raw /*80.13*/ ("""//$('#addCommentForm').on('submit', onAddCommentFormSubmit);
        """), format.raw /*81.9*/ ("""}"""), format.raw /*81.10*/ (""");
    </script>
""")))
          }), format.raw /*83.2*/ ("""



"""))
        }
      }
    }

    def render(user: Option[models.User], article: Article, comments: Seq[CommentInfo], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, article, comments)(request, messages, webJarAssets)

    def f: ((Option[models.User], Article, Seq[CommentInfo]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, article, comments) => (request, messages, webJarAssets) => apply(user, article, comments)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object blogShow extends blogShow_Scope0.blogShow
/*
                  -- GENERATED --
                  DATE: Mon Mar 20 14:41:02 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogShow.scala.html
                  HASH: 2febb8e8e92be0559865cfc3a3e4c28dbf831e4c
                  MATRIX: 669->2|937->156|965->178|992->180|1064->244|1102->245|1133->250|1169->260|1188->271|1241->304|1283->320|1319->336|1400->390|1436->405|1513->455|1552->473|1601->496|1639->518|1678->519|1714->528|1810->597|1826->604|1856->613|1885->614|1961->662|1978->669|2006->675|2098->740|2114->747|2140->752|2176->761|2218->773|2250->778|2286->788|2299->792|2312->796|2358->804|2395->814|2419->829|2458->830|2499->843|2541->858|2561->869|2620->907|2680->940|2695->946|2731->961|2776->978|2849->1024|2886->1040|2956->1079|2992->1085|3024->1090|3066->1105|3086->1116|3139->1148|3258->1240|3302->1263|3348->1282|3363->1288|3399->1303|3435->1312|3491->1341|3524->1353|3582->1384|3595->1388|3608->1392|3654->1400|3695->1413|3790->1481|3849->1518|3913->1551|3945->1556|4043->1627|4107->1670|4172->1708|4262->1776|4325->1811|4354->1812|4399->1829|4563->1965|4592->1966|4641->1987|4676->1995|4714->2012|4783->2053|4812->2054|4865->2079|4972->2159|4992->2170|5047->2204|5098->2227|5127->2228|5216->2289|5245->2290|5275->2292|5304->2293|5353->2314|5388->2322|5427->2340|5497->2382|5526->2383|5579->2408|5631->2433|5651->2444|5706->2478|5757->2501|5786->2502|5875->2563|5904->2564|5934->2566|5963->2567|6012->2588|6047->2596|6086->2614|6155->2655|6184->2656|6237->2681|6314->2730|6343->2731|6432->2792|6461->2793|6503->2807|6532->2808|6605->2853|6634->2854|6675->2868|6702->2886|6741->2887|6786->2904|6831->2931|6844->2936|6883->2937|6928->2954|7022->3017|7058->3026|7087->3027|7153->3065|7182->3066|7223->3079|7319->3148|7348->3149|7396->3167
                  LINES: 22->2|27->2|29->5|30->6|30->6|30->6|31->7|31->7|31->7|31->7|32->8|32->8|35->11|35->11|36->12|36->12|38->14|38->14|38->14|39->15|41->17|41->17|41->17|41->17|41->17|41->17|41->17|44->20|44->20|44->20|45->21|46->22|47->23|48->24|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|50->26|51->27|51->27|51->27|52->28|52->28|52->28|54->30|55->31|56->32|56->32|56->32|56->32|57->33|57->33|58->34|58->34|58->34|59->35|59->35|59->35|60->36|60->36|60->36|60->36|61->37|61->37|61->37|62->38|63->39|66->42|66->42|67->43|67->43|68->44|68->44|69->45|73->49|73->49|74->50|74->50|74->50|75->51|75->51|76->52|77->53|77->53|77->53|78->54|78->54|80->56|80->56|80->56|80->56|81->57|81->57|81->57|82->58|82->58|83->59|83->59|83->59|83->59|84->60|84->60|86->62|86->62|86->62|86->62|87->63|87->63|87->63|88->64|88->64|89->65|90->66|90->66|92->68|92->68|93->69|93->69|95->71|95->71|96->72|96->72|96->72|97->73|98->74|98->74|98->74|99->75|101->77|102->78|102->78|103->79|103->79|104->80|105->81|105->81|107->83
                  -- GENERATED --
              */
