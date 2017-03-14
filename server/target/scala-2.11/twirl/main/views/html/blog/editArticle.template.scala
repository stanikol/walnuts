
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
        <input type="hidden" id="blog-short-text" name="blog-short-text" />
        <input type="hidden" id="action" name="action" />
        <div class="form-group">
            <label for="title" class="control-label">"""), _display_( /*19.55*/ Messages("editArticle.title")), format.raw /*19.84*/ ("""</label>
            <input type="text" id="title" name="title" value='"""), _display_( /*20.64*/ { article("title").value }), format.raw /*20.88*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*24.61*/ Messages("editArticle.description")), format.raw /*24.96*/ ("""</label>
            <textarea type="text" id="description" name="description" class="form-control">"""), _display_( /*25.93*/ { article("description").value }), format.raw /*25.123*/ ("""</textarea>
        </div>
        <div class="form-group">
            <label for="blog-edit" class="control-label">"""), _display_( /*28.59*/ Messages("editArticle.article-text")), format.raw /*28.95*/ ("""</label>
            <div id="blog-edit" class="form-control">
                """), _display_( /*30.18*/ { Html(article("blog-text").value.getOrElse("")) }), format.raw /*30.66*/ ("""
            """), format.raw /*31.13*/ ("""</div>
        </div>
        <div class="form-group">
            <label for="keywords" class="control-label">"""), _display_( /*34.58*/ Messages("editArticle.keywords")), format.raw /*34.90*/ ("""</label>
            <input type="text" id="keywords" name="keywords" value='"""), _display_( /*35.70*/ { article("keywords").value }), format.raw /*35.97*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="sort-order" class="control-label">"""), _display_( /*39.60*/ Messages("editArticle.sort-order")), format.raw /*39.94*/ ("""</label>
            <input type="text" id="sort-order" name="sort-order" value='"""), _display_( /*40.74*/ { article("sort-order").value }), format.raw /*40.103*/ ("""'
                   class="form-control"/>
        </div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <button type="button" id="new-btn" class="btn btn-warning">"""), _display_( /*45.73*/ Messages("editArticle.save-as-new")), format.raw /*45.108*/ ("""</button>
            """), _display_( /*46.14*/ if (article("id").value.isDefined) /*46.47*/ {
              _display_(Seq[Any](format.raw /*46.48*/ ("""
                """), format.raw /*47.17*/ ("""<button type="button" id="save-btn" class="btn btn-primary">"""), _display_( /*47.78*/ Messages("editArticle.save-article")), format.raw /*47.114*/ ("""</button>
                <button type="button" id="delete-btn" class="btn btn-danger">"""), _display_( /*48.79*/ Messages("editArticle.delete-article")), format.raw /*48.117*/ ("""</button>
            """)))
            }), format.raw /*49.14*/ ("""
        """), format.raw /*50.9*/ ("""</div>
    </form>

    <!-- Include the Quill library -->
    <link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
    <link href="/assets/styles/editArticle.css" rel="stylesheet"/>
    <script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>
    <!--<script src="/assets/javascripts/editArticle.js"></script>-->
    <script>
        """), _display_( /*59.10*/ Html(views.js.blog.editArticle.render().toString())), format.raw /*59.61*/ ("""
    """), format.raw /*60.5*/ ("""</script>
""")))
          }), format.raw /*61.2*/ ("""
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
                  DATE: Mon Mar 13 15:00:38 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/editArticle.scala.html
                  HASH: 59cfc2556e7c9f3e83483ba6765c2ff9656e4ba1
                  MATRIX: 693->1|1003->197|1030->218|1057->220|1112->267|1150->268|1181->274|1475->548|1508->554|1587->606|1652->649|1703->673|1745->694|1837->759|1879->780|2195->1069|2245->1098|2344->1170|2389->1194|2568->1346|2624->1381|2752->1482|2804->1512|2949->1630|3006->1666|3113->1746|3182->1794|3223->1807|3362->1919|3415->1951|3520->2029|3568->2056|3746->2207|3801->2241|3910->2323|3961->2352|4187->2551|4244->2586|4294->2609|4336->2642|4375->2643|4420->2660|4508->2721|4566->2757|4681->2845|4741->2883|4795->2906|4831->2915|5224->3281|5296->3332|5328->3337|5369->3348
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|37->12|37->12|37->12|38->13|38->13|39->14|39->14|44->19|44->19|45->20|45->20|49->24|49->24|50->25|50->25|53->28|53->28|55->30|55->30|56->31|59->34|59->34|60->35|60->35|64->39|64->39|65->40|65->40|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|73->48|73->48|74->49|75->50|84->59|84->59|85->60|86->61
                  -- GENERATED --
              */
