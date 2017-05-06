
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
        """), _display_( /*10.10*/ for (comment <- comments) yield /*10.32*/ {
              _display_(Seq[Any](format.raw /*10.33*/ ("""
            """), format.raw /*11.13*/ ("""<hr>
            <div class="row">
                <h5 class="col col-xs-3">"""), _display_( /*13.43*/ comment /*13.50*/ .fullName), format.raw /*13.59*/ (""" """), format.raw /*13.60*/ ("""</h5> <h6 class="col col-xs-3 col-xs-offset-6">"""), _display_( /*13.108*/ comment /*13.115*/ .added), format.raw /*13.121*/ ("""</h6>
            </div>
            <div class="feedtext">
                """), _display_( /*16.18*/ comment /*16.25*/ .text), format.raw /*16.30*/ ("""
            """), format.raw /*17.13*/ ("""</div>
        """)))
            }), format.raw /*18.10*/ ("""
        """), format.raw /*19.9*/ ("""<br>
        """), _display_( /*20.10*/ user /*20.14*/ .map /*20.18*/ { usr =>
              _display_(Seq[Any](format.raw /*20.26*/ ("""
            """), _display_( /*21.14*/ if (usr.isAdmin) /*21.29*/ {
                _display_(Seq[Any](format.raw /*21.30*/ ("""
                """), format.raw /*22.17*/ ("""<form action=""""), _display_( /*22.32*/ controllers /*22.43*/ .nuts.routes.Blog.edit(article.id.get)), format.raw /*22.81*/ ("""" method="get" class="form-inline">
                    """), _display_( /*23.22*/ helper /*23.28*/ .CSRF.formField), format.raw /*23.43*/ ("""
                    """), format.raw /*24.21*/ ("""<button type="submit" class="btn btn-danger">"""), _display_( /*24.67*/ Messages("Edit")), format.raw /*24.83*/ ("""</button>
                    <a href=""""), _display_( /*25.31*/ controllers /*25.42*/ .nuts.routes.Comments.commentsAdmin), format.raw /*25.77*/ ("""" class="btn btn-primary">Редактировать комментарии</a>
                </form>
            """)))
              }), format.raw /*27.14*/ ("""
        """)))
            }), format.raw /*28.10*/ ("""
        """), format.raw /*29.9*/ ("""<form action=""""), _display_( /*29.24*/ controllers /*29.35*/ .nuts.routes.Comments.addComment), format.raw /*29.67*/ ("""" method="post" id="addCommentForm">
            <button type="submit" class="btn btn-warning">"""), _display_( /*30.60*/ Messages("Add comment")), format.raw /*30.83*/ ("""</button>
            """), _display_( /*31.14*/ helper /*31.20*/ .CSRF.formField), format.raw /*31.35*/ ("""
            """), format.raw /*32.13*/ ("""<input type="hidden" value=""""), _display_( /*32.42*/ { article.id }), format.raw /*32.54*/ ("""" name="article-id"/>
            """), _display_( /*33.14*/ user /*33.18*/ .map /*33.22*/ { usr =>
              _display_(Seq[Any](format.raw /*33.30*/ ("""
                """), format.raw /*34.17*/ ("""<textarea name="article-comment" id="article-comment" placeholder=""""), _display_( /*34.85*/ Messages("Add your comment here ...")), format.raw /*34.122*/ ("""" rows="10"></textarea>
            """)))
            }), format.raw /*35.14*/ ("""
        """), format.raw /*36.9*/ ("""</form>
    </div>

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogShow.scala.html
                  HASH: 6141616269e2836b8964cbe65c76514fcfb560fc
                  MATRIX: 789->2|1057->156|1085->178|1112->180|1184->244|1222->245|1253->250|1314->285|1349->300|1425->350|1463->368|1506->384|1544->406|1583->407|1624->420|1728->497|1744->504|1774->513|1803->514|1879->562|1896->569|1924->575|2028->652|2044->659|2070->664|2111->677|2158->693|2194->702|2235->716|2248->720|2261->724|2307->732|2348->746|2372->761|2411->762|2456->779|2498->794|2518->805|2577->843|2661->900|2676->906|2712->921|2761->942|2834->988|2871->1004|2938->1044|2958->1055|3014->1090|3138->1183|3179->1193|3215->1202|3257->1217|3277->1228|3330->1260|3453->1356|3497->1379|3547->1402|3562->1408|3598->1423|3639->1436|3695->1465|3728->1477|3790->1512|3803->1516|3816->1520|3862->1528|3907->1545|4002->1613|4061->1650|4129->1687|4165->1696|4274->1778|4338->1821|4403->1859|4493->1927|4556->1962|4585->1963|4630->1980|4794->2116|4823->2117|4872->2138|4907->2146|4945->2163|5014->2204|5043->2205|5096->2230|5203->2310|5223->2321|5278->2355|5329->2378|5358->2379|5447->2440|5476->2441|5506->2443|5535->2444|5584->2465|5619->2473|5658->2491|5728->2533|5757->2534|5810->2559|5862->2584|5882->2595|5937->2629|5988->2652|6017->2653|6106->2714|6135->2715|6165->2717|6194->2718|6243->2739|6278->2747|6317->2765|6386->2806|6415->2807|6468->2832|6545->2881|6574->2882|6663->2943|6692->2944|6734->2958|6763->2959|6836->3004|6865->3005|6906->3019|6933->3037|6972->3038|7017->3055|7062->3082|7075->3087|7114->3088|7159->3105|7253->3168|7289->3177|7318->3178|7384->3216|7413->3217|7454->3230|7550->3299|7579->3300|7627->3318
                  LINES: 26->2|31->2|33->5|34->6|34->6|34->6|35->7|36->8|36->8|37->9|37->9|38->10|38->10|38->10|39->11|41->13|41->13|41->13|41->13|41->13|41->13|41->13|44->16|44->16|44->16|45->17|46->18|47->19|48->20|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|55->27|56->28|57->29|57->29|57->29|57->29|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|61->33|62->34|62->34|62->34|63->35|64->36|68->40|68->40|69->41|69->41|70->42|70->42|71->43|75->47|75->47|76->48|76->48|76->48|77->49|77->49|78->50|79->51|79->51|79->51|80->52|80->52|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|88->60|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|91->63|92->64|92->64|94->66|94->66|95->67|95->67|97->69|97->69|98->70|98->70|98->70|99->71|100->72|100->72|100->72|101->73|103->75|104->76|104->76|105->77|105->77|106->78|107->79|107->79|109->81
                  -- GENERATED --
              */
