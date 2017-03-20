
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
<html lang="en" class="main-html">
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
        <!--<link rel="stylesheet" href=""""), _display_( /*20.43*/ routes /*20.49*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.css"))), format.raw /*20.107*/ ("""">-->
        <!--<link rel="stylesheet" href=""""), _display_( /*21.43*/ routes /*21.49*/ .Assets.at("styles/styles.css")), format.raw /*21.80*/ ("""">-->
        <!--<link rel="stylesheet" href=""""), _display_( /*22.43*/ routes /*22.49*/ .WebJarAssets.at(webJarAssets.locate("bootstrap-theme.min.css"))), format.raw /*22.113*/ ("""">-->
        <link rel="stylesheet" href=""""), _display_( /*23.39*/ routes /*23.45*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.css"))), format.raw /*23.99*/ ("""">
        <link rel="stylesheet" href=""""), _display_( /*24.39*/ routes /*24.45*/ .Assets.at("styles/main.css")), format.raw /*24.74*/ ("""">
            <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
        <script type="text/javascript" src=""""), _display_( /*30.46*/ routes /*30.52*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*30.106*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*31.46*/ routes /*31.52*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*31.105*/ (""""></script>
        <script type="text/javascript" src=""""), _display_( /*32.46*/ routes /*32.52*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*32.109*/ (""""></script>
        <!--<script type="text/javascript" src=""""), _display_( /*33.50*/ routes /*33.56*/ .Assets.at("javascripts/bootstrap.min.js")), format.raw /*33.98*/ (""""></script>-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>
        <script src=""""), _display_( /*35.23*/ routes /*35.29*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*35.68*/ (""""></script>
    </head>
    <body class="main-body">
        <header class="navbar brand" role="navigation">
            <div class="container" >
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">!!! """), _display_( /*42.52*/ Messages("toggle.navigation")), format.raw /*42.81*/ ("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a class="navbar-brand" href=""""), _display_( /*47.56*/ controllers /*47.67*/ .pages.routes.ApplicationController.index), format.raw /*47.108*/ ("""">"""), _display_( /*47.111*/ Messages("main-name")), format.raw /*47.132*/ ("""</a>-->
                </div>

                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-upper">
                            <li><a href=""""), _display_( /*52.43*/ controllers /*52.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*52.87*/ ("""">"""), _display_( /*52.90*/ Messages("Главная")), format.raw /*52.109*/ ("""</a></li>
                            <li><a href=""""), _display_( /*53.43*/ controllers /*53.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*53.87*/ ("""">"""), _display_( /*53.90*/ Messages("Сорта орехов")), format.raw /*53.114*/ ("""</a></li>
                            <li class="empty-li"><a href="#"></a></li>
                            <li><a href=""""), _display_( /*55.43*/ controllers /*55.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*55.87*/ ("""">"""), _display_( /*55.90*/ Messages("Статьи")), format.raw /*55.108*/ ("""</a></li>
                            <li><a href=""""), _display_( /*56.43*/ controllers /*56.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*56.87*/ ("""">"""), _display_( /*56.90*/ Messages("Контакты")), format.raw /*56.110*/ ("""</a></li>
                    </ul>
                </nav>
                <nav class="collapse navbar-collapse navbar-lower navbar-right">
                    <ul class="nav navbar-nav">
                        """), _display_( /*61.26*/ user /*61.30*/ .map /*61.34*/ { u =>
            _display_(Seq[Any](format.raw /*61.41*/ ("""
                            """), format.raw /*62.29*/ ("""<li><a href=""""), _display_( /*62.43*/ controllers /*62.54*/ .pages.routes.ApplicationController.index), format.raw /*62.95*/ ("""">"""), _display_( /*62.98*/ u /*62.99*/ .name), format.raw /*62.104*/ ("""</a></li>
                            """), _display_( /*63.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*63.124*/ {
              _display_(Seq[Any](format.raw /*63.126*/ ("""
                                """), format.raw /*64.33*/ ("""<li><a href=""""), _display_( /*64.47*/ controllers /*64.58*/ .auth.routes.ChangePasswordController.view), format.raw /*64.100*/ ("""">"""), _display_( /*64.103*/ Messages("change.password")), format.raw /*64.130*/ ("""</a></li>
                            """)))
            }), format.raw /*65.30*/ ("""
                            """), format.raw /*66.29*/ ("""<li><a href=""""), _display_( /*66.43*/ controllers /*66.54*/ .pages.routes.ApplicationController.signOut), format.raw /*66.97*/ ("""">"""), _display_( /*66.100*/ Messages("sign.out")), format.raw /*66.120*/ ("""</a></li>
                        """)))
          } /*67.26*/ .getOrElse /*67.36*/ {
            _display_(Seq[Any](format.raw /*67.38*/ ("""
                            """), format.raw /*68.29*/ ("""<li><a href=""""), _display_( /*68.43*/ controllers /*68.54*/ .auth.routes.SignInController.view), format.raw /*68.88*/ ("""">"""), _display_( /*68.91*/ Messages("sign.in")), format.raw /*68.110*/ ("""</a></li>
                            <li><a href=""""), _display_( /*69.43*/ controllers /*69.54*/ .auth.routes.SignUpController.view), format.raw /*69.88*/ ("""">"""), _display_( /*69.91*/ Messages("sign.up")), format.raw /*69.110*/ ("""</a></li>
                        """)))
          }), format.raw /*70.26*/ ("""
                    """), format.raw /*71.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container">
            <div class="row">
                """), _display_( /*77.18*/ request /*77.25*/ .flash.get("error").map /*77.48*/ { msg =>
            _display_(Seq[Any](format.raw /*77.57*/ ("""
                """), format.raw /*78.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*80.30*/ Messages("error")), format.raw /*80.47*/ ("""</strong> """), _display_( /*80.58*/ msg), format.raw /*80.61*/ ("""
                """), format.raw /*81.17*/ ("""</div>
                """)))
          }), format.raw /*82.18*/ ("""
                """), _display_( /*83.18*/ request /*83.25*/ .flash.get("info").map /*83.47*/ { msg =>
            _display_(Seq[Any](format.raw /*83.56*/ ("""
                """), format.raw /*84.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*86.30*/ Messages("info")), format.raw /*86.46*/ ("""</strong> """), _display_( /*86.57*/ msg), format.raw /*86.60*/ ("""
                """), format.raw /*87.17*/ ("""</div>
                """)))
          }), format.raw /*88.18*/ ("""
                """), _display_( /*89.18*/ request /*89.25*/ .flash.get("success").map /*89.50*/ { msg =>
            _display_(Seq[Any](format.raw /*89.59*/ ("""
                """), format.raw /*90.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*92.30*/ Messages("success")), format.raw /*92.49*/ ("""</strong> """), _display_( /*92.60*/ msg), format.raw /*92.63*/ ("""
                """), format.raw /*93.17*/ ("""</div>
                """)))
          }), format.raw /*94.18*/ ("""
            """), format.raw /*95.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*97.18*/ content), format.raw /*97.25*/ ("""
            """), format.raw /*98.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*100.50*/ routes /*100.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*100.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*101.50*/ routes /*101.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*101.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*102.50*/ routes /*102.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*102.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*104.27*/ routes /*104.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*104.72*/ (""""></script>-->
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
                  DATE: Mon Mar 20 14:32:37 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/main.scala.html
                  HASH: 47316b1f9cf7ed7d97bdca1beaf6e2176c6773b5
                  MATRIX: 657->1|947->195|975->197|1242->438|1271->459|1309->460|1350->473|1409->505|1438->513|1481->525|1518->535|1551->559|1590->560|1631->573|1693->608|1725->619|1768->631|1805->641|1882->691|1897->697|1950->729|1996->748|2022->753|2329->1033|2344->1039|2424->1097|2499->1145|2514->1151|2566->1182|2641->1230|2656->1236|2742->1300|2813->1344|2828->1350|2903->1404|2971->1445|2986->1451|3036->1480|3450->1867|3465->1873|3541->1927|3625->1984|3640->1990|3715->2043|3799->2100|3814->2106|3893->2163|3981->2224|3996->2230|4059->2272|4217->2403|4232->2409|4292->2448|4680->2809|4730->2838|5015->3096|5035->3107|5098->3148|5129->3151|5172->3172|5389->3362|5409->3373|5463->3406|5493->3409|5534->3428|5613->3480|5633->3491|5687->3524|5717->3527|5763->3551|5913->3674|5933->3685|5987->3718|6017->3721|6057->3739|6136->3791|6156->3802|6210->3835|6240->3838|6282->3858|6522->4071|6535->4075|6548->4079|6593->4086|6650->4115|6691->4129|6711->4140|6773->4181|6803->4184|6813->4185|6840->4190|6906->4229|7010->4323|7051->4325|7112->4358|7153->4372|7173->4383|7237->4425|7268->4428|7317->4455|7387->4494|7444->4523|7485->4537|7505->4548|7569->4591|7600->4594|7642->4614|7696->4649|7715->4659|7755->4661|7812->4690|7853->4704|7873->4715|7928->4749|7958->4752|7999->4771|8078->4823|8098->4834|8153->4868|8183->4871|8224->4890|8290->4925|8339->4946|8527->5107|8543->5114|8575->5137|8622->5146|8667->5163|8861->5330|8899->5347|8937->5358|8961->5361|9006->5378|9061->5402|9106->5420|9122->5427|9153->5449|9200->5458|9245->5475|9436->5639|9473->5655|9511->5666|9535->5669|9580->5686|9635->5710|9680->5728|9696->5735|9730->5760|9777->5769|9822->5786|10016->5953|10056->5972|10094->5983|10118->5986|10163->6003|10218->6027|10259->6040|10357->6111|10385->6118|10426->6131|10526->6203|10542->6209|10619->6263|10711->6327|10727->6333|10803->6386|10895->6450|10911->6456|10991->6513|11161->6655|11177->6661|11238->6700
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|49->23|49->23|49->23|50->24|50->24|50->24|56->30|56->30|56->30|57->31|57->31|57->31|58->32|58->32|58->32|59->33|59->33|59->33|61->35|61->35|61->35|68->42|68->42|73->47|73->47|73->47|73->47|73->47|78->52|78->52|78->52|78->52|78->52|79->53|79->53|79->53|79->53|79->53|81->55|81->55|81->55|81->55|81->55|82->56|82->56|82->56|82->56|82->56|87->61|87->61|87->61|87->61|88->62|88->62|88->62|88->62|88->62|88->62|88->62|89->63|89->63|89->63|90->64|90->64|90->64|90->64|90->64|90->64|91->65|92->66|92->66|92->66|92->66|92->66|92->66|93->67|93->67|93->67|94->68|94->68|94->68|94->68|94->68|94->68|95->69|95->69|95->69|95->69|95->69|96->70|97->71|103->77|103->77|103->77|103->77|104->78|106->80|106->80|106->80|106->80|107->81|108->82|109->83|109->83|109->83|109->83|110->84|112->86|112->86|112->86|112->86|113->87|114->88|115->89|115->89|115->89|115->89|116->90|118->92|118->92|118->92|118->92|119->93|120->94|121->95|123->97|123->97|124->98|126->100|126->100|126->100|127->101|127->101|127->101|128->102|128->102|128->102|130->104|130->104|130->104
                  -- GENERATED --
              */
