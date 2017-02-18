
package views.html.auth

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object passwordStrength_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  object passwordStrength_Scope1 {
    import b3.inline.fieldConstructor

    class passwordStrength extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Field, Array[scala.Tuple2[Symbol, Any]], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

      /**/
      def apply /*2.2*/ (field: Field, options: (Symbol, Any)*)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
        _display_ {
          {

            Seq[Any](format.raw /*2.122*/ ("""
"""), format.raw /*3.1*/ ("""<section>
  """), _display_( /*4.4*/ b3 /*4.6*/ .password(field, (Symbol("data-pwd"), "true") +: options: _*)), format.raw /*4.66*/ ("""

  """), format.raw /*6.3*/ ("""<meter max="4" id="password-strength-meter"></meter>
  <p id="password-strength-text"></p>
</section>
"""))
          }
        }
      }

      def render(field: Field, options: Array[scala.Tuple2[Symbol, Any]], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(field, options: _*)(request, messages, webJarAssets)

      def f: ((Field, Array[scala.Tuple2[Symbol, Any]]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (field, options) => (request, messages, webJarAssets) => apply(field, options: _*)(request, messages, webJarAssets)

      def ref: this.type = this

    }

  }
}

/**/
object passwordStrength extends passwordStrength_Scope0.passwordStrength_Scope1.passwordStrength
/*
                  -- GENERATED --
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/passwordStrength.scala.html
                  HASH: 7325258d349c151f5fc48b1aa527965d96d61f0b
                  MATRIX: 752->36|968->156|995->157|1033->170|1042->172|1122->232|1152->236
                  LINES: 25->2|30->2|31->3|32->4|32->4|32->4|34->6
                  -- GENERATED --
              */
