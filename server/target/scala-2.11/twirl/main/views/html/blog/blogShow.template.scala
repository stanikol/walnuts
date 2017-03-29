
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
    """), format.raw /*7.5*/ ("""<div class="article">
        <h1>"""), _display_( /*8.14*/ { article.title }), format.raw /*8.29*/ ("""</h1>
        <div class="article-text" disabled>"""), _display_( /*9.45*/ Html(article.text)), format.raw /*9.63*/ ("""</div>
    </div>
    """), _display_( /*11.6*/ for (comment <- comments) yield /*11.28*/ {
              _display_(Seq[Any](format.raw /*11.29*/ ("""
        """), format.raw /*12.9*/ ("""<hr>
        <div class="row">
            <h5 class="col col-xs-3">"""), _display_( /*14.39*/ comment /*14.46*/ .fullName), format.raw /*14.55*/ (""" """), format.raw /*14.56*/ ("""</h5> <h6 class="col col-xs-3 col-xs-offset-6">"""), _display_( /*14.104*/ comment /*14.111*/ .added), format.raw /*14.117*/ ("""</h6>
        </div>
        <div class="feedtext">
            """), _display_( /*17.14*/ comment /*17.21*/ .text), format.raw /*17.26*/ ("""
        """), format.raw /*18.9*/ ("""</div>
    """)))
            }), format.raw /*19.6*/ ("""
    """), format.raw /*20.5*/ ("""<br>
    """), _display_( /*21.6*/ user /*21.10*/ .map /*21.14*/ { usr =>
              _display_(Seq[Any](format.raw /*21.22*/ ("""
        """), _display_( /*22.10*/ if (usr.isAdmin) /*22.25*/ {
                _display_(Seq[Any](format.raw /*22.26*/ ("""
            """), format.raw /*23.13*/ ("""<form action=""""), _display_( /*23.28*/ controllers /*23.39*/ .nuts.routes.Blog.edit(article.id.get)), format.raw /*23.77*/ ("""" method="get" class="form-inline">
                """), _display_( /*24.18*/ helper /*24.24*/ .CSRF.formField), format.raw /*24.39*/ ("""
                """), format.raw /*25.17*/ ("""<button type="submit" class="btn btn-danger">"""), _display_( /*25.63*/ Messages("Edit")), format.raw /*25.79*/ ("""</button>
                <a href=""""), _display_( /*26.27*/ controllers /*26.38*/ .nuts.routes.Comments.commentsAdmin), format.raw /*26.73*/ ("""" class="btn btn-primary">Редактировать комментарии</a>
            </form>
        """)))
              }), format.raw /*28.10*/ ("""
    """)))
            }), format.raw /*29.6*/ ("""
    """), format.raw /*30.5*/ ("""<form action=""""), _display_( /*30.20*/ controllers /*30.31*/ .nuts.routes.Comments.addComment), format.raw /*30.63*/ ("""" method="post" id="addCommentForm">
        <button type="submit" class="btn btn-warning">"""), _display_( /*31.56*/ Messages("Add comment")), format.raw /*31.79*/ ("""</button>
        """), _display_( /*32.10*/ helper /*32.16*/ .CSRF.formField), format.raw /*32.31*/ ("""
        """), format.raw /*33.9*/ ("""<input type="hidden" value=""""), _display_( /*33.38*/ { article.id }), format.raw /*33.50*/ ("""" name="article-id"/>
        """), _display_( /*34.10*/ user /*34.14*/ .map /*34.18*/ { usr =>
              _display_(Seq[Any](format.raw /*34.26*/ ("""
            """), format.raw /*35.13*/ ("""<textarea name="article-comment" id="article-comment" placeholder=""""), _display_( /*35.81*/ Messages("Add your comment here ...")), format.raw /*35.118*/ ("""" rows="10"></textarea>
        """)))
            }), format.raw /*36.10*/ ("""
    """), format.raw /*37.5*/ ("""</form>

    <script>
        let dlg = $('<div class="dialog" title=""""), _display_( /*40.50*/ Messages("Registration or login required!")), format.raw /*40.93*/ ("""">\
            <p class="bg-danger">"""), _display_( /*41.35*/ Messages("Please signin or signup to leave yor comment. Thank you.")), format.raw /*41.103*/ ("""</p> \
            </div>').dialog("""), format.raw /*42.29*/ ("""{"""), format.raw /*42.30*/ ("""
                """), format.raw /*43.17*/ ("""resizable: false,
                autoOpen: false,
                //height:140,
                modal: true,
                buttons: ["""), format.raw /*47.27*/ ("""{"""), format.raw /*47.28*/ ("""
                    """), format.raw /*48.21*/ ("""text: """"), _display_( /*48.29*/ Messages("Login")), format.raw /*48.46*/ ("""",
                    click: function() """), format.raw /*49.39*/ ("""{"""), format.raw /*49.40*/ ("""
                        """), format.raw /*50.25*/ ("""//$( this ).dialog( "close" );
                        window.location.href = '"""), _display_( /*51.50*/ controllers /*51.61*/ .auth.routes.SignInController.view), format.raw /*51.95*/ ("""';
                    """), format.raw /*52.21*/ ("""}"""), format.raw /*52.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*54.17*/ ("""}"""), format.raw /*54.18*/ (""", """), format.raw /*54.20*/ ("""{"""), format.raw /*54.21*/ ("""
                    """), format.raw /*55.21*/ ("""text: """"), _display_( /*55.29*/ Messages("SignUp")), format.raw /*55.47*/ ("""",
                    click : function() """), format.raw /*56.40*/ ("""{"""), format.raw /*56.41*/ ("""
                        """), format.raw /*57.25*/ ("""window.location.href = '"""), _display_( /*57.50*/ controllers /*57.61*/ .auth.routes.SignUpController.view), format.raw /*57.95*/ ("""';
                    """), format.raw /*58.21*/ ("""}"""), format.raw /*58.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*60.17*/ ("""}"""), format.raw /*60.18*/ (""", """), format.raw /*60.20*/ ("""{"""), format.raw /*60.21*/ ("""
                    """), format.raw /*61.21*/ ("""text: """"), _display_( /*61.29*/ Messages("Cancel")), format.raw /*61.47*/ ("""",
                    click: function() """), format.raw /*62.39*/ ("""{"""), format.raw /*62.40*/ ("""
                        """), format.raw /*63.25*/ ("""$( this ).dialog( "close" );
                    """), format.raw /*64.21*/ ("""}"""), format.raw /*64.22*/ (""",
                    class:"btn btn-danger"
                """), format.raw /*66.17*/ ("""}"""), format.raw /*66.18*/ ("""]
            """), format.raw /*67.13*/ ("""}"""), format.raw /*67.14*/ (""");

        function onAddCommentFormSubmit()"""), format.raw /*69.42*/ ("""{"""), format.raw /*69.43*/ ("""
            """), _display_( /*70.14*/ if (user.isDefined) /*70.32*/ {
              _display_(Seq[Any](format.raw /*70.33*/ ("""
                """), format.raw /*71.17*/ ("""return true;
            """)))
            } /*72.15*/ else /*72.20*/ {
              _display_(Seq[Any](format.raw /*72.21*/ ("""
                """), format.raw /*73.17*/ ("""dlg.dialog('open');
                return false;
            """)))
            }), format.raw /*75.14*/ ("""
        """), format.raw /*76.9*/ ("""}"""), format.raw /*76.10*/ (""";
        $(document).ready(function()"""), format.raw /*77.37*/ ("""{"""), format.raw /*77.38*/ ("""
            """), format.raw /*78.13*/ ("""//$('#addCommentForm').on('submit', onAddCommentFormSubmit);
        """), format.raw /*79.9*/ ("""}"""), format.raw /*79.10*/ (""");
    </script>
""")))
          }), format.raw /*81.2*/ ("""



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
                  DATE: Thu Mar 30 01:41:00 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogShow.scala.html
                  HASH: c70360612dabc54626d7baacd8a72ac1f57579db
                  MATRIX: 669->2|937->156|965->178|992->180|1064->244|1102->245|1133->250|1194->285|1229->300|1305->350|1343->368|1392->391|1430->413|1469->414|1505->423|1601->492|1617->499|1647->508|1676->509|1752->557|1769->564|1797->570|1889->635|1905->642|1931->647|1967->656|2009->668|2041->673|2077->683|2090->687|2103->691|2149->699|2186->709|2210->724|2249->725|2290->738|2332->753|2352->764|2411->802|2491->855|2506->861|2542->876|2587->893|2660->939|2697->955|2760->991|2780->1002|2836->1037|2952->1122|2988->1128|3020->1133|3062->1148|3082->1159|3135->1191|3254->1283|3298->1306|3344->1325|3359->1331|3395->1346|3431->1355|3487->1384|3520->1396|3578->1427|3591->1431|3604->1435|3650->1443|3691->1456|3786->1524|3845->1561|3909->1594|3941->1599|4039->1670|4103->1713|4168->1751|4258->1819|4321->1854|4350->1855|4395->1872|4559->2008|4588->2009|4637->2030|4672->2038|4710->2055|4779->2096|4808->2097|4861->2122|4968->2202|4988->2213|5043->2247|5094->2270|5123->2271|5212->2332|5241->2333|5271->2335|5300->2336|5349->2357|5384->2365|5423->2383|5493->2425|5522->2426|5575->2451|5627->2476|5647->2487|5702->2521|5753->2544|5782->2545|5871->2606|5900->2607|5930->2609|5959->2610|6008->2631|6043->2639|6082->2657|6151->2698|6180->2699|6233->2724|6310->2773|6339->2774|6428->2835|6457->2836|6499->2850|6528->2851|6601->2896|6630->2897|6671->2911|6698->2929|6737->2930|6782->2947|6827->2974|6840->2979|6879->2980|6924->2997|7018->3060|7054->3069|7083->3070|7149->3108|7178->3109|7219->3122|7315->3191|7344->3192|7392->3210
                  LINES: 22->2|27->2|29->5|30->6|30->6|30->6|31->7|32->8|32->8|33->9|33->9|35->11|35->11|35->11|36->12|38->14|38->14|38->14|38->14|38->14|38->14|38->14|41->17|41->17|41->17|42->18|43->19|44->20|45->21|45->21|45->21|45->21|46->22|46->22|46->22|47->23|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|52->28|53->29|54->30|54->30|54->30|54->30|55->31|55->31|56->32|56->32|56->32|57->33|57->33|57->33|58->34|58->34|58->34|58->34|59->35|59->35|59->35|60->36|61->37|64->40|64->40|65->41|65->41|66->42|66->42|67->43|71->47|71->47|72->48|72->48|72->48|73->49|73->49|74->50|75->51|75->51|75->51|76->52|76->52|78->54|78->54|78->54|78->54|79->55|79->55|79->55|80->56|80->56|81->57|81->57|81->57|81->57|82->58|82->58|84->60|84->60|84->60|84->60|85->61|85->61|85->61|86->62|86->62|87->63|88->64|88->64|90->66|90->66|91->67|91->67|93->69|93->69|94->70|94->70|94->70|95->71|96->72|96->72|96->72|97->73|99->75|100->76|100->76|101->77|101->77|102->78|103->79|103->79|105->81
                  -- GENERATED --
              */
