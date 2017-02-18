
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object main_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[String, Option[models.User], String, String, Html, RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

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
        <link rel="stylesheet" href=""""), _display_( /*20.39*/ routes /*20.45*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.css"))), format.raw /*20.103*/ ("""">
        <link rel="stylesheet" href=""""), _display_( /*21.39*/ routes /*21.45*/ .WebJarAssets.at(webJarAssets.locate("bootstrap-theme.min.css"))), format.raw /*21.109*/ ("""">
        <link rel="stylesheet" href=""""), _display_( /*22.39*/ routes /*22.45*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.css"))), format.raw /*22.99*/ ("""">
        <link rel="stylesheet" href=""""), _display_( /*23.39*/ routes /*23.45*/ .Assets.at("styles/main.css")), format.raw /*23.74*/ ("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        <script type="text/javascript" src=""""), _display_( /*29.46*/ routes /*29.52*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*29.106*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*30.46*/ routes /*30.52*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*30.105*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*31.46*/ routes /*31.52*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*31.109*/ (""""></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script src=""""), _display_( /*33.23*/ routes /*33.29*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*33.68*/ (""""></script>
    </head>
    <body>
        <header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">"""), _display_( /*40.48*/ Messages("toggle.navigation")), format.raw /*40.77*/ ("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""""), _display_( /*45.52*/ controllers /*45.63*/ .pages.routes.ApplicationController.index), format.raw /*45.104*/ ("""">"""), _display_( /*45.107*/ Messages("main-name")), format.raw /*45.128*/ ("""</a>
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href=""""), _display_( /*49.39*/ controllers /*49.50*/ .pages.routes.ApplicationController.index), format.raw /*49.91*/ ("""">"""), _display_( /*49.94*/ Messages("home")), format.raw /*49.110*/ ("""</a></li>
                        <li><a href="https://github.com/dpitkevics/play-silhouette-4.0-slick-postgres-seed">GitHub</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        """), _display_( /*53.26*/ user /*53.30*/ .map /*53.34*/ { u =>
            _display_(Seq[Any](format.raw /*53.41*/ ("""
                            """), format.raw /*54.29*/ ("""<li><a href=""""), _display_( /*54.43*/ controllers /*54.54*/ .pages.routes.ApplicationController.index), format.raw /*54.95*/ ("""">"""), _display_( /*54.98*/ u /*54.99*/ .name), format.raw /*54.104*/ ("""</a></li>
                            """), _display_( /*55.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*55.124*/ {
              _display_(Seq[Any](format.raw /*55.126*/ ("""
                                """), format.raw /*56.33*/ ("""<li><a href=""""), _display_( /*56.47*/ controllers /*56.58*/ .auth.routes.ChangePasswordController.view), format.raw /*56.100*/ ("""">"""), _display_( /*56.103*/ Messages("change.password")), format.raw /*56.130*/ ("""</a></li>
                            """)))
            }), format.raw /*57.30*/ ("""
                            """), format.raw /*58.29*/ ("""<li><a href=""""), _display_( /*58.43*/ controllers /*58.54*/ .pages.routes.ApplicationController.signOut), format.raw /*58.97*/ ("""">"""), _display_( /*58.100*/ Messages("sign.out")), format.raw /*58.120*/ ("""</a></li>
                        """)))
          } /*59.26*/ .getOrElse /*59.36*/ {
            _display_(Seq[Any](format.raw /*59.38*/ ("""
                            """), format.raw /*60.29*/ ("""<li><a href=""""), _display_( /*60.43*/ controllers /*60.54*/ .auth.routes.SignInController.view), format.raw /*60.88*/ ("""">"""), _display_( /*60.91*/ Messages("sign.in")), format.raw /*60.110*/ ("""</a></li>
                            <li><a href=""""), _display_( /*61.43*/ controllers /*61.54*/ .auth.routes.SignUpController.view), format.raw /*61.88*/ ("""">"""), _display_( /*61.91*/ Messages("sign.up")), format.raw /*61.110*/ ("""</a></li>
                        """)))
          }), format.raw /*62.26*/ ("""
                    """), format.raw /*63.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container">
            <div class="row">
                """), _display_( /*69.18*/ request /*69.25*/ .flash.get("error").map /*69.48*/ { msg =>
            _display_(Seq[Any](format.raw /*69.57*/ ("""
                """), format.raw /*70.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*72.30*/ Messages("error")), format.raw /*72.47*/ ("""</strong> """), _display_( /*72.58*/ msg), format.raw /*72.61*/ ("""
                """), format.raw /*73.17*/ ("""</div>
                """)))
          }), format.raw /*74.18*/ ("""
                """), _display_( /*75.18*/ request /*75.25*/ .flash.get("info").map /*75.47*/ { msg =>
            _display_(Seq[Any](format.raw /*75.56*/ ("""
                """), format.raw /*76.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*78.30*/ Messages("info")), format.raw /*78.46*/ ("""</strong> """), _display_( /*78.57*/ msg), format.raw /*78.60*/ ("""
                """), format.raw /*79.17*/ ("""</div>
                """)))
          }), format.raw /*80.18*/ ("""
                """), _display_( /*81.18*/ request /*81.25*/ .flash.get("success").map /*81.50*/ { msg =>
            _display_(Seq[Any](format.raw /*81.59*/ ("""
                """), format.raw /*82.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*84.30*/ Messages("success")), format.raw /*84.49*/ ("""</strong> """), _display_( /*84.60*/ msg), format.raw /*84.63*/ ("""
                """), format.raw /*85.17*/ ("""</div>
                """)))
          }), format.raw /*86.18*/ ("""
            """), format.raw /*87.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*89.18*/ content), format.raw /*89.25*/ ("""
            """), format.raw /*90.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*92.50*/ routes /*92.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*92.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*93.50*/ routes /*93.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*93.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*94.50*/ routes /*94.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*94.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*96.27*/ routes /*96.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*96.72*/ (""""></script>-->
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
object main extends main_Scope0.main
/*
                  -- GENERATED --
                  DATE: Sat Feb 18 23:36:13 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/main.scala.html
                  HASH: e59de7d59f13a21647de13c51cb16521cab134f4
                  MATRIX: 657->1|947->195|975->197|1224->420|1253->441|1291->442|1332->455|1391->487|1420->495|1463->507|1500->517|1533->541|1572->542|1613->555|1675->590|1707->601|1750->613|1787->623|1864->673|1879->679|1932->711|1978->730|2004->735|2307->1011|2322->1017|2402->1075|2470->1116|2485->1122|2571->1186|2639->1227|2654->1233|2729->1287|2797->1328|2812->1334|2862->1363|3276->1750|3291->1756|3367->1810|3451->1867|3466->1873|3541->1926|3625->1983|3640->1989|3719->2046|3874->2174|3889->2180|3949->2219|4339->2582|4389->2611|4670->2865|4690->2876|4753->2917|4784->2920|4827->2941|5023->3110|5043->3121|5105->3162|5135->3165|5173->3181|5446->3427|5459->3431|5472->3435|5517->3442|5574->3471|5615->3485|5635->3496|5697->3537|5727->3540|5737->3541|5764->3546|5830->3585|5934->3679|5975->3681|6036->3714|6077->3728|6097->3739|6161->3781|6192->3784|6241->3811|6311->3850|6368->3879|6409->3893|6429->3904|6493->3947|6524->3950|6566->3970|6620->4005|6639->4015|6679->4017|6736->4046|6777->4060|6797->4071|6852->4105|6882->4108|6923->4127|7002->4179|7022->4190|7077->4224|7107->4227|7148->4246|7214->4281|7263->4302|7436->4448|7452->4455|7484->4478|7531->4487|7576->4504|7770->4671|7808->4688|7846->4699|7870->4702|7915->4719|7970->4743|8015->4761|8031->4768|8062->4790|8109->4799|8154->4816|8345->4980|8382->4996|8420->5007|8444->5010|8489->5027|8544->5051|8589->5069|8605->5076|8639->5101|8686->5110|8731->5127|8925->5294|8965->5313|9003->5324|9027->5327|9072->5344|9127->5368|9168->5381|9266->5452|9294->5459|9335->5472|9434->5544|9449->5550|9525->5604|9616->5668|9631->5674|9706->5727|9797->5791|9812->5797|9891->5854|10060->5996|10075->6002|10135->6041
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|49->23|49->23|49->23|55->29|55->29|55->29|56->30|56->30|56->30|57->31|57->31|57->31|59->33|59->33|59->33|66->40|66->40|71->45|71->45|71->45|71->45|71->45|75->49|75->49|75->49|75->49|75->49|79->53|79->53|79->53|79->53|80->54|80->54|80->54|80->54|80->54|80->54|80->54|81->55|81->55|81->55|82->56|82->56|82->56|82->56|82->56|82->56|83->57|84->58|84->58|84->58|84->58|84->58|84->58|85->59|85->59|85->59|86->60|86->60|86->60|86->60|86->60|86->60|87->61|87->61|87->61|87->61|87->61|88->62|89->63|95->69|95->69|95->69|95->69|96->70|98->72|98->72|98->72|98->72|99->73|100->74|101->75|101->75|101->75|101->75|102->76|104->78|104->78|104->78|104->78|105->79|106->80|107->81|107->81|107->81|107->81|108->82|110->84|110->84|110->84|110->84|111->85|112->86|113->87|115->89|115->89|116->90|118->92|118->92|118->92|119->93|119->93|119->93|120->94|120->94|120->94|122->96|122->96|122->96
                  -- GENERATED --
              */
