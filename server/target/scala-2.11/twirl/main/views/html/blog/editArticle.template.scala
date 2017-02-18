
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object editArticle_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class editArticle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.User, Form[models.nuts.Data.Article], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, article: Form[models.nuts.Data.Article], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*1.198*/ ("""
"""), format.raw /*3.1*/ ("""
"""), _display_( /*4.2*/ main(Messages("editArticle.title"), Some(user)) /*4.49*/ {
            _display_(Seq[Any](format.raw /*4.50*/ ("""
    """), _display_( /*5.6*/ {
              errors.map {
                case (key, errorMsg) =>
                  <div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>{ Messages("error") } { Messages(s"editArticle.$key") } => { errorMsg }</strong>
                  </div>
              }
            }), format.raw /*10.7*/ ("""

    """), format.raw /*12.5*/ ("""<form id="article-edit-form" method="POST" action=""""), _display_( /*12.57*/ CSRF(controllers.nuts.routes.Blog.onSubmit)), format.raw /*12.100*/ ("""">
        <strong>ID #"""), _display_( /*13.22*/ { article("id").value }), format.raw /*13.43*/ ("""</strong>
        <input type="hidden" id="id" name="id" value=""""), _display_( /*14.56*/ { article("id").value }), format.raw /*14.77*/ (""""/>
        <input type="hidden" id="blog-text" name="blog-text" />
        <input type="hidden" id="action" name="action" />
        <div class="form-group">
            <label for="title" class="control-label">"""), _display_( /*18.55*/ Messages("editArticle.title")), format.raw /*18.84*/ ("""</label>
            <input type="text" id="title" name="title" value='"""), _display_( /*19.64*/ { article("title").value }), format.raw /*19.88*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*23.61*/ Messages("editArticle.description")), format.raw /*23.96*/ ("""</label>
            <textarea type="text" id="description" name="description" class="form-control">"""), _display_( /*24.93*/ { article("description").value }), format.raw /*24.123*/ ("""</textarea>
        </div>
        <div class="form-group">
            <label for="blog-edit" class="control-label">"""), _display_( /*27.59*/ Messages("editArticle.article-text")), format.raw /*27.95*/ ("""</label>
            <div id="blog-edit" class="form-control">
                """), _display_( /*29.18*/ { Html(article("blog-text").value.getOrElse("")) }), format.raw /*29.66*/ ("""
            """), format.raw /*30.13*/ ("""</div>
        </div>
        <div class="form-group">
            <label for="keywords" class="control-label">"""), _display_( /*33.58*/ Messages("editArticle.keywords")), format.raw /*33.90*/ ("""</label>
            <input type="text" id="keywords" name="keywords" value='"""), _display_( /*34.70*/ { article("keywords").value }), format.raw /*34.97*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="sort-order" class="control-label">"""), _display_( /*38.60*/ Messages("editArticle.sort-order")), format.raw /*38.94*/ ("""</label>
            <input type="text" id="sort-order" name="sort-order" value='"""), _display_( /*39.74*/ { article("sort-order").value }), format.raw /*39.103*/ ("""'
                   class="form-control"/>
        </div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <button type="button" id="new-btn" class="btn btn-warning">"""), _display_( /*44.73*/ Messages("editArticle.save-as-new")), format.raw /*44.108*/ ("""</button>
            """), _display_( /*45.14*/ if (article("id").value.isDefined) /*45.47*/ {
              _display_(Seq[Any](format.raw /*45.48*/ ("""
                """), format.raw /*46.17*/ ("""<button type="button" id="save-btn" class="btn btn-primary">"""), _display_( /*46.78*/ Messages("editArticle.save-article")), format.raw /*46.114*/ ("""</button>
                <button type="button" id="delete-btn" class="btn btn-danger">"""), _display_( /*47.79*/ Messages("editArticle.delete-article")), format.raw /*47.117*/ ("""</button>
            """)))
            }), format.raw /*48.14*/ ("""
        """), format.raw /*49.9*/ ("""</div>
    </form>

    <!-- Include the Quill library -->
    <link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
    <link href="/assets/styles/editArticle.css" rel="stylesheet"/>
    <script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>
    <script src="/assets/javascripts/editArticle.js"></script>
""")))
          }), format.raw /*57.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, article: Form[models.nuts.Data.Article], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, article, errors)(request, messages, webJarAssets)

    def f: ((models.User, Form[models.nuts.Data.Article], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, article, errors) => (request, messages, webJarAssets) => apply(user, article, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object editArticle extends editArticle_Scope0.editArticle
/*
                  -- GENERATED --
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/editArticle.scala.html
                  HASH: 04879de08d20c8226c1459c9b28dead625b69d0d
                  MATRIX: 693->1|1003->197|1030->218|1057->220|1112->267|1150->268|1181->274|1475->548|1508->554|1587->606|1652->649|1703->673|1745->694|1837->759|1879->780|2119->993|2169->1022|2268->1094|2313->1118|2492->1270|2548->1305|2676->1406|2728->1436|2873->1554|2930->1590|3037->1670|3106->1718|3147->1731|3286->1843|3339->1875|3444->1953|3492->1980|3670->2131|3725->2165|3834->2247|3885->2276|4111->2475|4168->2510|4218->2533|4260->2566|4299->2567|4344->2584|4432->2645|4490->2681|4605->2769|4665->2807|4719->2830|4755->2839|5123->3177
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|37->12|37->12|37->12|38->13|38->13|39->14|39->14|43->18|43->18|44->19|44->19|48->23|48->23|49->24|49->24|52->27|52->27|54->29|54->29|55->30|58->33|58->33|59->34|59->34|63->38|63->38|64->39|64->39|69->44|69->44|70->45|70->45|70->45|71->46|71->46|71->46|72->47|72->47|73->48|74->49|82->57
                  -- GENERATED --
              */
