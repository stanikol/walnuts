
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object commentsEdit_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class commentsEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[models.User, Seq[models.nuts.Data.CommentInfo], Form[CommentsShow], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, comments: Seq[models.nuts.Data.CommentInfo], commentsShowForm: Form[CommentsShow], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*1.240*/ ("""
"""), format.raw /*3.1*/ ("""
"""), _display_( /*4.2*/ admin(Messages("title"), Some(user)) /*4.38*/ {
            _display_(Seq[Any](format.raw /*4.39*/ ("""
    """), _display_( /*5.6*/ {
              errors.map {
                case (key, errorMsg) =>
                  <div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>{ Messages("error") } { Messages(s"blogEdit.$key") } => { errorMsg }</strong>
                  </div>
              }
            }), format.raw /*10.7*/ ("""
    """), format.raw /*11.5*/ ("""<div class="panel panel-info">
        <div class="panel-heading">Фильтр & сортировка</div>
        <div class="panel-body">
            <form class="form-inline" method="get" action=""""), _display_( /*14.61*/ controllers /*14.72*/ .nuts.routes.Comments.commentsAdmin), format.raw /*14.107*/ ("""">
                """), _display_( /*15.18*/ helper /*15.24*/ .select(
              field = commentsShowForm("article-id"),
              options = comments.groupBy(a => (a.articleID.toString, a.articleTitle)).keys.toSeq,
              '_label -> "Фильтр",
              '_default -> "Все статьи",
              '_class -> "form-group"
            )), format.raw /*21.18*/ ("""
                """), _display_( /*22.18*/ helper /*22.24*/ .select(
              field = commentsShowForm("comments-order"),
              options = Seq("byArticle" -> Messages("By article"), "byID" -> Messages("By comment ID")),
              '_label -> "Сортировка",
              '_class -> "form-group"
            )), format.raw /*27.18*/ ("""
                """), format.raw /*28.17*/ ("""<button type="submit" class="btn btn-primary">Применить</button>
            </form>
        </div>
    </div>
    """), _display_( /*32.6*/ for (comment <- comments) yield /*32.30*/ {
              _display_(Seq[Any](format.raw /*32.31*/ ("""
        """), format.raw /*33.9*/ ("""<form class="comments-edit-form" method="POST" action=""""), _display_( /*33.65*/ controllers /*33.76*/ .nuts.routes.Comments.editComment), format.raw /*33.109*/ ("""">
            """), _display_( /*34.14*/ helper /*34.20*/ .CSRF.formField), format.raw /*34.35*/ ("""
            """), format.raw /*35.13*/ ("""<!--<a href=""""), _display_( /*35.27*/ controllers /*35.38*/ .nuts.routes.Blog.edit(comment.articleID)), format.raw /*35.79*/ ("""" class="form-group">#"""), _display_( /*35.102*/ comment /*35.109*/ .articleID), format.raw /*35.119*/ (""" """), _display_( /*35.121*/ comment /*35.128*/ .articleTitle), format.raw /*35.141*/ ("""</a>-->
            <a href=""""), _display_( /*36.23*/ controllers /*36.34*/ .nuts.routes.Blog.article(comment.articleID)), format.raw /*36.78*/ ("""" class="form-group">#"""), _display_( /*36.101*/ comment /*36.108*/ .articleID), format.raw /*36.118*/ (""" """), _display_( /*36.120*/ comment /*36.127*/ .articleTitle), format.raw /*36.140*/ ("""</a>
            <h5 class="form-group">"""), _display_( /*37.37*/ comment /*37.44*/ .fullName), format.raw /*37.53*/ (""" """), _display_( /*37.55*/ comment /*37.62*/ .userEmail.map(e => s"<$e>")), format.raw /*37.88*/ (""" """), format.raw /*37.89*/ ("""(#"""), _display_( /*37.92*/ comment /*37.99*/ .id), format.raw /*37.102*/ (""" """), format.raw /*37.103*/ ("""from """), _display_( /*37.109*/ comment /*37.116*/ .added), format.raw /*37.122*/ (""")</h5>
            <input type="hidden" name="comment-id" value=""""), _display_( /*38.60*/ comment /*38.67*/ .id), format.raw /*38.70*/ (""""/>
            <textarea name="comment-text" rows="5" class="article-comment">"""), _display_( /*39.77*/ comment /*39.84*/ .text), format.raw /*39.89*/ ("""</textarea>
            <button type="submit" class="btn btn-danger" name="action" value="del">"""), _display_( /*40.85*/ Messages("Delete")), format.raw /*40.103*/ ("""</button>
            <button type="submit" class="btn btn-warning" name="action" value="upd">"""), _display_( /*41.86*/ Messages("Update")), format.raw /*41.104*/ ("""</button>
        </form>
    """)))
            }), format.raw /*43.6*/ ("""
""")))
          }), format.raw /*44.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, comments: Seq[models.nuts.Data.CommentInfo], commentsShowForm: Form[CommentsShow], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, comments, commentsShowForm, errors)(request, messages, webJarAssets)

    def f: ((models.User, Seq[models.nuts.Data.CommentInfo], Form[CommentsShow], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, comments, commentsShowForm, errors) => (request, messages, webJarAssets) => apply(user, comments, commentsShowForm, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object commentsEdit extends commentsEdit_Scope0.commentsEdit
/*
                  -- GENERATED --
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/commentsEdit.scala.html
                  HASH: ae3df29ce652241f6054fb95eb7182aef8e5227d
                  MATRIX: 717->1|1069->239|1096->260|1123->262|1167->298|1205->299|1236->305|1527->576|1559->581|1771->766|1791->777|1848->812|1895->832|1910->838|2253->1160|2298->1178|2313->1184|2624->1474|2669->1491|2811->1607|2851->1631|2890->1632|2926->1641|3009->1697|3029->1708|3084->1741|3127->1757|3142->1763|3178->1778|3219->1791|3260->1805|3280->1816|3342->1857|3393->1880|3410->1887|3442->1897|3472->1899|3489->1906|3524->1919|3581->1949|3601->1960|3666->2004|3717->2027|3734->2034|3766->2044|3796->2046|3813->2053|3848->2066|3916->2107|3932->2114|3962->2123|3991->2125|4007->2132|4054->2158|4083->2159|4113->2162|4129->2169|4154->2172|4184->2173|4218->2179|4235->2186|4263->2192|4356->2258|4372->2265|4396->2268|4503->2348|4519->2355|4545->2360|4668->2456|4708->2474|4830->2569|4870->2587|4931->2618|4963->2620
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|36->11|39->14|39->14|39->14|40->15|40->15|46->21|47->22|47->22|52->27|53->28|57->32|57->32|57->32|58->33|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|60->35|60->35|60->35|60->35|60->35|60->35|60->35|61->36|61->36|61->36|61->36|61->36|61->36|61->36|61->36|61->36|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|66->41|66->41|68->43|69->44
                  -- GENERATED --
              */
