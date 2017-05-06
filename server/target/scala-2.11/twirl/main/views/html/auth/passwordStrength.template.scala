
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/auth/passwordStrength.scala.html
                  HASH: 48db58a9de2ba81422bec68afd91d3be92bfcfa0
                  MATRIX: 872->36|1088->156|1115->157|1153->170|1162->172|1242->232|1272->236
                  LINES: 29->2|34->2|35->3|36->4|36->4|36->4|38->6
                  -- GENERATED --
              */
