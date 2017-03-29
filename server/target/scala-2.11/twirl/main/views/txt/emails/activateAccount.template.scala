
package views.txt.emails

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object activateAccount_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.txt._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class activateAccount extends BaseScalaTemplate[play.twirl.api.TxtFormat.Appendable, Format[play.twirl.api.TxtFormat.Appendable]](play.twirl.api.TxtFormat) with play.twirl.api.Template3[User, String, Messages, play.twirl.api.TxtFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: User, url: String)(implicit messages: Messages): play.twirl.api.TxtFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.56*/ ("""
"""), _display_( /*2.2*/ messages("email.activate.account.hello", user.name.getOrElse("user"))), format.raw /*2.71*/ ("""

"""), _display_( /*4.2*/ messages("email.activate.account.txt.text", url)), format.raw /*4.50*/ ("""
"""))
        }
      }
    }

    def render(user: User, url: String, messages: Messages): play.twirl.api.TxtFormat.Appendable = apply(user, url)(messages)

    def f: ((User, String) => (Messages) => play.twirl.api.TxtFormat.Appendable) = (user, url) => (messages) => apply(user, url)(messages)

    def ref: this.type = this

  }

}

/**/
object activateAccount extends activateAccount_Scope0.activateAccount
/*
                  -- GENERATED --
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/emails/activateAccount.scala.txt
                  HASH: 8ef6543e58903495bff75a09f9d2a96fd1ed2e01
                  MATRIX: 619->1|767->55|794->57|883->126|911->129|979->177
                  LINES: 22->1|27->1|28->2|28->2|30->4|30->4
                  -- GENERATED --
              */
