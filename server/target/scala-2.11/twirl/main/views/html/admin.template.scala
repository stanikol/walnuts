
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object admin_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class admin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[String, Option[models.User], String, String, Html, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (title: String, user: Option[models.User] = None, keywords: String = "", description: String = "")(content: Html)(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.196*/ ("""

"""), format.raw /*3.1*/ ("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        """), _display_( /*9.10*/ if (keywords.nonEmpty) /*9.31*/ {
            _display_(Seq[Any](format.raw /*9.32*/ ("""
            """), format.raw /*10.13*/ ("""<meta name="keywords" content=""""), _display_( /*10.45*/ keywords), format.raw /*10.53*/ ("""">
        """)))
          }), format.raw /*11.10*/ ("""
        """), _display_( /*12.10*/ if (description.nonEmpty) /*12.34*/ {
            _display_(Seq[Any](format.raw /*12.35*/ ("""
            """), format.raw /*13.13*/ ("""<meta name="description" content=""""), _display_( /*13.48*/ description), format.raw /*13.59*/ ("""">
        """)))
          }), format.raw /*14.10*/ ("""

        """), format.raw /*16.9*/ ("""<link rel="shortcut icon" type="image/png" href=""""), _display_( /*16.59*/ routes /*16.65*/ .Assets.at("images/favicon.png")), format.raw /*16.97*/ ("""">
        <title>"""), _display_( /*17.17*/ title), format.raw /*17.22*/ ("""</title>
        <link href="//fonts.googleapis.com/css?family=Roboto|Montserrat:400,700|Open+Sans:400,300,600" rel="stylesheet">
        <link href="//cdnjs.cloudflare.com/ajax/libs/ionicons/1.5.2/css/ionicons.min.css" rel="stylesheet">
        <link rel="stylesheet" href=""""), _display_( /*20.39*/ routes /*20.45*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.css"))), format.raw /*20.99*/ ("""">
        <link rel="stylesheet" href=""""), _display_( /*21.39*/ routes /*21.45*/ .Assets.at("styles/admin.css")), format.raw /*21.75*/ ("""">
        <!--<link rel="stylesheet" href=""""), _display_( /*22.43*/ routes /*22.49*/ .Assets.at("styles/main.css")), format.raw /*22.78*/ ("""">-->
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        <script type="text/javascript" src=""""), _display_( /*28.46*/ routes /*28.52*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*28.106*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*29.46*/ routes /*29.52*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*29.105*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*30.46*/ routes /*30.52*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*30.109*/ (""""></script>
        <!--<script type="text/javascript" src=""""), _display_( /*31.50*/ routes /*31.56*/ .Assets.at("javascripts/bootstrap.min.js")), format.raw /*31.98*/ (""""></script>-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script src=""""), _display_( /*33.23*/ routes /*33.29*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*33.68*/ (""""></script>
    </head>
    <body>
        <header class="navbar" role="navigation">
            <div class="container" >
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">!!! """), _display_( /*40.52*/ Messages("toggle.navigation")), format.raw /*40.81*/ ("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a class="navbar-brand" href=""""), _display_( /*45.56*/ controllers /*45.67*/ .pages.routes.ApplicationController.index), format.raw /*45.108*/ ("""">"""), _display_( /*45.111*/ Messages("main-name")), format.raw /*45.132*/ ("""</a>-->
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        """), _display_( /*49.26*/ user /*49.30*/ .map /*49.34*/ { u =>
            _display_(Seq[Any](format.raw /*49.41*/ ("""
                            """), format.raw /*50.29*/ ("""<li><a href=""""), _display_( /*50.43*/ controllers /*50.54*/ .pages.routes.ApplicationController.index), format.raw /*50.95*/ ("""">"""), _display_( /*50.98*/ u /*50.99*/ .name), format.raw /*50.104*/ ("""</a></li>
                            """), _display_( /*51.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*51.124*/ {
              _display_(Seq[Any](format.raw /*51.126*/ ("""
                                """), format.raw /*52.33*/ ("""<li><a href=""""), _display_( /*52.47*/ controllers /*52.58*/ .auth.routes.ChangePasswordController.view), format.raw /*52.100*/ ("""">"""), _display_( /*52.103*/ Messages("change.password")), format.raw /*52.130*/ ("""</a></li>
                            """)))
            }), format.raw /*53.30*/ ("""
                            """), _display_( /*54.30*/ if (u.isAdmin) /*54.43*/ {
              _display_(Seq[Any](format.raw /*54.44*/ ("""
                                """), format.raw /*55.33*/ ("""<li><a href=""""), _display_( /*55.47*/ controllers /*55.58*/ .nuts.routes.Images.show()), format.raw /*55.84*/ ("""">"""), _display_( /*55.87*/ Messages("Edit images")), format.raw /*55.110*/ ("""</a></li>
                                <li><a href=""""), _display_( /*56.47*/ controllers /*56.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*56.91*/ ("""">"""), _display_( /*56.94*/ Messages("Edit articles")), format.raw /*56.119*/ ("""</a></li>
                                <li><a href=""""), _display_( /*57.47*/ controllers /*57.58*/ .nuts.routes.Comments.commentsAdmin), format.raw /*57.93*/ ("""">"""), _display_( /*57.96*/ Messages("Edit comments")), format.raw /*57.121*/ ("""</a></li>
                            """)))
            }), format.raw /*58.30*/ ("""
                            """), format.raw /*59.29*/ ("""<li><a href=""""), _display_( /*59.43*/ controllers /*59.54*/ .pages.routes.ApplicationController.signOut), format.raw /*59.97*/ ("""">"""), _display_( /*59.100*/ Messages("sign.out")), format.raw /*59.120*/ ("""</a></li>
                        """)))
          } /*60.26*/ .getOrElse /*60.36*/ {
            _display_(Seq[Any](format.raw /*60.38*/ ("""
                            """), format.raw /*61.29*/ ("""<li><a href=""""), _display_( /*61.43*/ controllers /*61.54*/ .auth.routes.SignInController.view), format.raw /*61.88*/ ("""">"""), _display_( /*61.91*/ Messages("sign.in")), format.raw /*61.110*/ ("""</a></li>
                            <li class="empty-li"><a href="/"></a></li>
                            <li><a href=""""), _display_( /*63.43*/ controllers /*63.54*/ .auth.routes.SignUpController.view), format.raw /*63.88*/ ("""">"""), _display_( /*63.91*/ Messages("sign.up")), format.raw /*63.110*/ ("""</a></li>
                        """)))
          }), format.raw /*64.26*/ ("""
                    """), format.raw /*65.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container">
            <div class="row">
                """), _display_( /*71.18*/ request /*71.25*/ .flash.get("error").map /*71.48*/ { msg =>
            _display_(Seq[Any](format.raw /*71.57*/ ("""
                """), format.raw /*72.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*74.30*/ Messages("error")), format.raw /*74.47*/ ("""</strong> """), _display_( /*74.58*/ msg), format.raw /*74.61*/ ("""
                """), format.raw /*75.17*/ ("""</div>
                """)))
          }), format.raw /*76.18*/ ("""
                """), _display_( /*77.18*/ request /*77.25*/ .flash.get("info").map /*77.47*/ { msg =>
            _display_(Seq[Any](format.raw /*77.56*/ ("""
                """), format.raw /*78.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*80.30*/ Messages("info")), format.raw /*80.46*/ ("""</strong> """), _display_( /*80.57*/ msg), format.raw /*80.60*/ ("""
                """), format.raw /*81.17*/ ("""</div>
                """)))
          }), format.raw /*82.18*/ ("""
                """), _display_( /*83.18*/ request /*83.25*/ .flash.get("success").map /*83.50*/ { msg =>
            _display_(Seq[Any](format.raw /*83.59*/ ("""
                """), format.raw /*84.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*86.30*/ Messages("success")), format.raw /*86.49*/ ("""</strong> """), _display_( /*86.60*/ msg), format.raw /*86.63*/ ("""
                """), format.raw /*87.17*/ ("""</div>
                """)))
          }), format.raw /*88.18*/ ("""
            """), format.raw /*89.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*91.18*/ content), format.raw /*91.25*/ ("""
            """), format.raw /*92.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*94.50*/ routes /*94.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*94.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*95.50*/ routes /*95.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*95.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*96.50*/ routes /*96.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*96.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*98.27*/ routes /*98.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*98.72*/ (""""></script>-->
    </body>
</html>
"""))
        }
      }
    }

    def render(title: String, user: Option[models.User], keywords: String, description: String, content: Html, request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(title, user, keywords, description)(content)(request, messages, webJarAssets)

    def f: ((String, Option[models.User], String, String) => (Html) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (title, user, keywords, description) => (content) => (request, messages, webJarAssets) => apply(title, user, keywords, description)(content)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object admin extends admin_Scope0.admin
/*
                  -- GENERATED --
                  DATE: Mon Mar 20 14:32:37 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/admin.scala.html
                  HASH: 89c5009cb16566c7628bb16c52dfcf6e22ef51a7
                  MATRIX: 659->1|949->195|977->197|1226->420|1255->441|1293->442|1334->455|1393->487|1422->495|1465->507|1502->517|1535->541|1574->542|1615->555|1677->590|1709->601|1752->613|1789->623|1866->673|1881->679|1934->711|1980->730|2006->735|2309->1011|2324->1017|2399->1071|2467->1112|2482->1118|2533->1148|2605->1193|2620->1199|2670->1228|3087->1618|3102->1624|3178->1678|3262->1735|3277->1741|3352->1794|3436->1851|3451->1857|3530->1914|3618->1975|3633->1981|3696->2023|3854->2154|3869->2160|3929->2199|4293->2536|4343->2565|4628->2823|4648->2834|4711->2875|4742->2878|4785->2899|4971->3058|4984->3062|4997->3066|5042->3073|5099->3102|5140->3116|5160->3127|5222->3168|5252->3171|5262->3172|5289->3177|5355->3216|5459->3310|5500->3312|5561->3345|5602->3359|5622->3370|5686->3412|5717->3415|5766->3442|5836->3481|5893->3511|5915->3524|5954->3525|6015->3558|6056->3572|6076->3583|6123->3609|6153->3612|6198->3635|6281->3691|6301->3702|6355->3735|6385->3738|6432->3763|6515->3819|6535->3830|6591->3865|6621->3868|6668->3893|6738->3932|6795->3961|6836->3975|6856->3986|6920->4029|6951->4032|6993->4052|7047->4087|7066->4097|7106->4099|7163->4128|7204->4142|7224->4153|7279->4187|7309->4190|7350->4209|7500->4332|7520->4343|7575->4377|7605->4380|7646->4399|7712->4434|7761->4455|7949->4616|7965->4623|7997->4646|8044->4655|8089->4672|8283->4839|8321->4856|8359->4867|8383->4870|8428->4887|8483->4911|8528->4929|8544->4936|8575->4958|8622->4967|8667->4984|8858->5148|8895->5164|8933->5175|8957->5178|9002->5195|9057->5219|9102->5237|9118->5244|9152->5269|9199->5278|9244->5295|9438->5462|9478->5481|9516->5492|9540->5495|9585->5512|9640->5536|9681->5549|9779->5620|9807->5627|9848->5640|9947->5712|9962->5718|10038->5772|10129->5836|10144->5842|10219->5895|10310->5959|10325->5965|10404->6022|10573->6164|10588->6170|10648->6209
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|54->28|54->28|54->28|55->29|55->29|55->29|56->30|56->30|56->30|57->31|57->31|57->31|59->33|59->33|59->33|66->40|66->40|71->45|71->45|71->45|71->45|71->45|75->49|75->49|75->49|75->49|76->50|76->50|76->50|76->50|76->50|76->50|76->50|77->51|77->51|77->51|78->52|78->52|78->52|78->52|78->52|78->52|79->53|80->54|80->54|80->54|81->55|81->55|81->55|81->55|81->55|81->55|82->56|82->56|82->56|82->56|82->56|83->57|83->57|83->57|83->57|83->57|84->58|85->59|85->59|85->59|85->59|85->59|85->59|86->60|86->60|86->60|87->61|87->61|87->61|87->61|87->61|87->61|89->63|89->63|89->63|89->63|89->63|90->64|91->65|97->71|97->71|97->71|97->71|98->72|100->74|100->74|100->74|100->74|101->75|102->76|103->77|103->77|103->77|103->77|104->78|106->80|106->80|106->80|106->80|107->81|108->82|109->83|109->83|109->83|109->83|110->84|112->86|112->86|112->86|112->86|113->87|114->88|115->89|117->91|117->91|118->92|120->94|120->94|120->94|121->95|121->95|121->95|122->96|122->96|122->96|124->98|124->98|124->98
                  -- GENERATED --
              */
