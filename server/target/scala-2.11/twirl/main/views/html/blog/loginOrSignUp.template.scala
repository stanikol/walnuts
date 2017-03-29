
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
  import models.nuts.Data._
  import models.nuts.FormsData._

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
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/loginOrSignUp.scala.html
                  HASH: 497e4ef205a41bb37057b7bced6292531fce6764
                  MATRIX: 654->2|858->110|887->111|918->117|940->131|978->132|1013->141|1099->201|1173->255|1213->268|1249->278|1268->289|1322->323|1375->350|1413->367|1466->394|1485->405|1539->439|1592->466|1631->484|1685->509|1713->510|1741->511
                  LINES: 22->2|27->2|27->2|28->3|28->3|28->3|29->4|30->5|30->5|31->6|31->6|31->6|31->6|31->6|31->6|32->7|32->7|32->7|32->7|32->7|34->9|35->10|35->10
                  -- GENERATED --
              */
