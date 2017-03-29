
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

  class commentsEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.User, Seq[models.nuts.Data.CommentInfo], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, comments: Seq[models.nuts.Data.CommentInfo], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*1.202*/ ("""
"""), format.raw /*3.1*/ ("""
"""), _display_( /*4.2*/ admin(Messages("blogEdit.title"), Some(user)) /*4.47*/ {
            _display_(Seq[Any](format.raw /*4.48*/ ("""
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
        <div class="panel-heading">"""), _display_( /*12.37*/ Messages("Sort order")), format.raw /*12.59*/ ("""</div>
        <div class="panel-body">
            <form class="form-inline" method="get" action=""""), _display_( /*14.61*/ controllers /*14.72*/ .nuts.routes.Comments.commentsAdmin), format.raw /*14.107*/ ("""">
                <button name="comments-order" value="byArticle">"""), _display_( /*15.66*/ Messages("By article")), format.raw /*15.88*/ ("""</button>
                <button name="comments-order" value="byID">"""), _display_( /*16.61*/ Messages("By comment ID")), format.raw /*16.86*/ ("""</button>
            </form>
        </div>
    </div>
    """), _display_( /*20.6*/ for (comment <- comments) yield /*20.30*/ {
              _display_(Seq[Any](format.raw /*20.31*/ ("""
        """), format.raw /*21.9*/ ("""<form class="comments-edit-form" method="POST" action=""""), _display_( /*21.65*/ controllers /*21.76*/ .nuts.routes.Comments.editComment), format.raw /*21.109*/ ("""">
            """), _display_( /*22.14*/ helper /*22.20*/ .CSRF.formField), format.raw /*22.35*/ ("""
            """), format.raw /*23.13*/ ("""<!--<a href=""""), _display_( /*23.27*/ controllers /*23.38*/ .nuts.routes.Blog.edit(comment.articleID)), format.raw /*23.79*/ ("""" class="form-group">#"""), _display_( /*23.102*/ comment /*23.109*/ .articleID), format.raw /*23.119*/ (""" """), _display_( /*23.121*/ comment /*23.128*/ .articleTitle), format.raw /*23.141*/ ("""</a>-->
            <a href=""""), _display_( /*24.23*/ controllers /*24.34*/ .nuts.routes.Blog.article(comment.articleID)), format.raw /*24.78*/ ("""" class="form-group">#"""), _display_( /*24.101*/ comment /*24.108*/ .articleID), format.raw /*24.118*/ (""" """), _display_( /*24.120*/ comment /*24.127*/ .articleTitle), format.raw /*24.140*/ ("""</a>
            <h5 class="form-group">"""), _display_( /*25.37*/ comment /*25.44*/ .fullName), format.raw /*25.53*/ (""" """), _display_( /*25.55*/ comment /*25.62*/ .userEmail.map(e => s"<$e>")), format.raw /*25.88*/ (""" """), format.raw /*25.89*/ ("""(#"""), _display_( /*25.92*/ comment /*25.99*/ .id), format.raw /*25.102*/ (""" """), format.raw /*25.103*/ ("""from """), _display_( /*25.109*/ comment /*25.116*/ .added), format.raw /*25.122*/ (""")</h5>
            <input type="hidden" name="comment-id" value=""""), _display_( /*26.60*/ comment /*26.67*/ .id), format.raw /*26.70*/ (""""/>
            <textarea name="comment-text" rows="5" class="article-comment">"""), _display_( /*27.77*/ comment /*27.84*/ .text), format.raw /*27.89*/ ("""</textarea>
            <button type="submit" class="btn btn-danger" name="action" value="del">"""), _display_( /*28.85*/ Messages("Delete")), format.raw /*28.103*/ ("""</button>
            <button type="submit" class="btn btn-warning" name="action" value="upd">"""), _display_( /*29.86*/ Messages("Update")), format.raw /*29.104*/ ("""</button>
        </form>
    """)))
            }), format.raw /*31.6*/ ("""
""")))
          }), format.raw /*32.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, comments: Seq[models.nuts.Data.CommentInfo], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, comments, errors)(request, messages, webJarAssets)

    def f: ((models.User, Seq[models.nuts.Data.CommentInfo], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, comments, errors) => (request, messages, webJarAssets) => apply(user, comments, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object commentsEdit extends commentsEdit_Scope0.commentsEdit
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/commentsEdit.scala.html
                  HASH: 5c35f292ae584c483fe820ab8f76323aea5540c1
                  MATRIX: 698->1|1012->201|1039->222|1066->224|1119->269|1157->270|1188->276|1479->547|1511->552|1605->619|1648->641|1775->741|1795->752|1852->787|1947->855|1990->877|2087->947|2133->972|2220->1033|2260->1057|2299->1058|2335->1067|2418->1123|2438->1134|2493->1167|2536->1183|2551->1189|2587->1204|2628->1217|2669->1231|2689->1242|2751->1283|2802->1306|2819->1313|2851->1323|2881->1325|2898->1332|2933->1345|2990->1375|3010->1386|3075->1430|3126->1453|3143->1460|3175->1470|3205->1472|3222->1479|3257->1492|3325->1533|3341->1540|3371->1549|3400->1551|3416->1558|3463->1584|3492->1585|3522->1588|3538->1595|3563->1598|3593->1599|3627->1605|3644->1612|3672->1618|3765->1684|3781->1691|3805->1694|3912->1774|3928->1781|3954->1786|4077->1882|4117->1900|4239->1995|4279->2013|4340->2044|4372->2046
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|36->11|37->12|37->12|39->14|39->14|39->14|40->15|40->15|41->16|41->16|45->20|45->20|45->20|46->21|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|48->23|48->23|48->23|48->23|48->23|48->23|48->23|49->24|49->24|49->24|49->24|49->24|49->24|49->24|49->24|49->24|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|54->29|54->29|56->31|57->32
                  -- GENERATED --
              */
