
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

  class commentsEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[models.User, Seq[models.blog.Data.CommentInfo], Form[CommentsShow], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, comments: Seq[models.blog.Data.CommentInfo], commentsShowForm: Form[CommentsShow], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
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
        """), format.raw /*33.9*/ ("""<form class="comments-edit-form" method="POST" action=""""), _display_( /*33.65*/ CSRF(controllers.nuts.routes.Comments.editComment)), format.raw /*33.115*/ ("""">
            <!--"""), _display_( /*34.18*/ helper /*34.24*/ .CSRF.formField), format.raw /*34.39*/ ("""-->
            <a href=""""), _display_( /*35.23*/ controllers /*35.34*/ .nuts.routes.Blog.article(comment.articleID)), format.raw /*35.78*/ ("""" class="form-group">#"""), _display_( /*35.101*/ comment /*35.108*/ .articleID), format.raw /*35.118*/ (""" """), _display_( /*35.120*/ comment /*35.127*/ .articleTitle), format.raw /*35.140*/ ("""</a>
            <h5 class="form-group">"""), _display_( /*36.37*/ comment /*36.44*/ .fullName), format.raw /*36.53*/ (""" """), _display_( /*36.55*/ comment /*36.62*/ .userEmail.map(e => s"<$e>")), format.raw /*36.88*/ (""" """), format.raw /*36.89*/ ("""(#"""), _display_( /*36.92*/ comment /*36.99*/ .id), format.raw /*36.102*/ (""" """), format.raw /*36.103*/ ("""from """), _display_( /*36.109*/ comment /*36.116*/ .added), format.raw /*36.122*/ (""")</h5>
            <input type="hidden" name="comment-id" value=""""), _display_( /*37.60*/ comment /*37.67*/ .id), format.raw /*37.70*/ (""""/>
            <textarea name="comment-text" rows="5" class="article-comment">"""), _display_( /*38.77*/ comment /*38.84*/ .text), format.raw /*38.89*/ ("""</textarea>
            <button type="submit" class="btn btn-danger" name="action" value="del">"""), _display_( /*39.85*/ Messages("Delete")), format.raw /*39.103*/ ("""</button>
            <button type="submit" class="btn btn-warning" name="action" value="upd">"""), _display_( /*40.86*/ Messages("Update")), format.raw /*40.104*/ ("""</button>
        </form>
    """)))
            }), format.raw /*42.6*/ ("""
""")))
          }), format.raw /*43.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, comments: Seq[models.blog.Data.CommentInfo], commentsShowForm: Form[CommentsShow], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, comments, commentsShowForm, errors)(request, messages, webJarAssets)

    def f: ((models.User, Seq[models.blog.Data.CommentInfo], Form[CommentsShow], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, comments, commentsShowForm, errors) => (request, messages, webJarAssets) => apply(user, comments, commentsShowForm, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object commentsEdit extends commentsEdit_Scope0.commentsEdit
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:08:08 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/commentsEdit.scala.html
                  HASH: e58766cf33bb1eab26f7c777eb798da5b5076df3
                  MATRIX: 837->1|1189->239|1216->260|1243->262|1287->298|1325->299|1356->305|1647->576|1679->581|1891->766|1911->777|1968->812|2015->832|2030->838|2373->1160|2418->1178|2433->1184|2744->1474|2789->1491|2931->1607|2971->1631|3010->1632|3046->1641|3129->1697|3201->1747|3248->1767|3263->1773|3299->1788|3352->1814|3372->1825|3437->1869|3488->1892|3505->1899|3537->1909|3567->1911|3584->1918|3619->1931|3687->1972|3703->1979|3733->1988|3762->1990|3778->1997|3825->2023|3854->2024|3884->2027|3900->2034|3925->2037|3955->2038|3989->2044|4006->2051|4034->2057|4127->2123|4143->2130|4167->2133|4274->2213|4290->2220|4316->2225|4439->2321|4479->2339|4601->2434|4641->2452|4702->2483|4734->2485
                  LINES: 26->1|31->1|32->3|33->4|33->4|33->4|34->5|39->10|40->11|43->14|43->14|43->14|44->15|44->15|50->21|51->22|51->22|56->27|57->28|61->32|61->32|61->32|62->33|62->33|62->33|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|64->35|64->35|64->35|64->35|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|65->36|66->37|66->37|66->37|67->38|67->38|67->38|68->39|68->39|69->40|69->40|71->42|72->43
                  -- GENERATED --
              */
