
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object loginOrSignUp_Scope0 {
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

  class loginOrSignUp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Option[models.User], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*2.2*/ (user: Option[models.User])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*2.110*/ ("""{"""), format.raw /*2.111*/ ("""
    """), _display_( /*3.6*/ main("", user) /*3.20*/ {
            _display_(Seq[Any](format.raw /*3.21*/ ("""
        """), format.raw /*4.9*/ ("""<div class="alert alert-warning" role="alert">
            """), _display_( /*5.14*/ Messages("You should be logged in to leave comments.")), format.raw /*5.68*/ ("""
            """), format.raw /*6.13*/ ("""<a href=""""), _display_( /*6.23*/ controllers /*6.34*/ .auth.routes.SignInController.view), format.raw /*6.68*/ ("""" class="btn btn-primary">"""), _display_( /*6.95*/ Messages("Login")), format.raw /*6.112*/ ("""</a>
            <a href=""""), _display_( /*7.23*/ controllers /*7.34*/ .auth.routes.SignUpController.view), format.raw /*7.68*/ ("""" class="btn btn-success">"""), _display_( /*7.95*/ Messages("SignUp")), format.raw /*7.113*/ ("""</a>
        </div>
    """)))
          }), format.raw /*9.6*/ ("""
"""), format.raw /*10.1*/ ("""}"""), format.raw /*10.2*/ ("""



"""))
        }
      }
    }

    def render(user: Option[models.User], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user)(request, messages, webJarAssets)

    def f: ((Option[models.User]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request, messages, webJarAssets) => apply(user)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object loginOrSignUp extends loginOrSignUp_Scope0.loginOrSignUp
/*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/loginOrSignUp.scala.html
                  HASH: bd0ac6771d89007965ee730dff3a2e6b118e0f26
                  MATRIX: 774->2|978->110|1007->111|1038->117|1060->131|1098->132|1133->141|1219->201|1293->255|1333->268|1369->278|1388->289|1442->323|1495->350|1533->367|1586->394|1605->405|1659->439|1712->466|1751->484|1805->509|1833->510|1861->511
                  LINES: 26->2|31->2|31->2|32->3|32->3|32->3|33->4|34->5|34->5|35->6|35->6|35->6|35->6|35->6|35->6|36->7|36->7|36->7|36->7|36->7|38->9|39->10|39->10
                  -- GENERATED --
              */
