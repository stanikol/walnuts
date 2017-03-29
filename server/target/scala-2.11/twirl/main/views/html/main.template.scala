
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
                </div>

                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-upper">
                            <li><a href=""""), _display_( /*51.43*/ controllers /*51.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*51.87*/ ("""">"""), _display_( /*51.90*/ Messages("Главная")), format.raw /*51.109*/ ("""</a></li>
                            <li><a href=""""), _display_( /*52.43*/ controllers /*52.54*/ .nuts.routes.Goods.listAllGoods), format.raw /*52.85*/ ("""">"""), _display_( /*52.88*/ Messages("Сорта орехов")), format.raw /*52.112*/ ("""</a></li>
                            <li class="empty-li"><a href="#"></a></li>
                            <li><a href=""""), _display_( /*54.43*/ controllers /*54.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*54.87*/ ("""">"""), _display_( /*54.90*/ Messages("Статьи")), format.raw /*54.108*/ ("""</a></li>
                            <li><a href=""""), _display_( /*55.43*/ controllers /*55.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*55.87*/ ("""">"""), _display_( /*55.90*/ Messages("Контакты")), format.raw /*55.110*/ ("""</a></li>
                    </ul>
                </nav>
                <nav class="collapse navbar-collapse navbar-lower navbar-right">
                    <ul class="nav navbar-nav">
                        """), _display_( /*60.26*/ user /*60.30*/ .map /*60.34*/ { u =>
            _display_(Seq[Any](format.raw /*60.41*/ ("""
                            """), format.raw /*61.29*/ ("""<li><a href=""""), _display_( /*61.43*/ controllers /*61.54*/ .pages.routes.ApplicationController.index), format.raw /*61.95*/ ("""">"""), _display_( /*61.98*/ u /*61.99*/ .name), format.raw /*61.104*/ ("""</a></li>
                            """), _display_( /*62.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*62.124*/ {
              _display_(Seq[Any](format.raw /*62.126*/ ("""
                                """), format.raw /*63.33*/ ("""<li><a href=""""), _display_( /*63.47*/ controllers /*63.58*/ .auth.routes.ChangePasswordController.view), format.raw /*63.100*/ ("""">"""), _display_( /*63.103*/ Messages("change.password")), format.raw /*63.130*/ ("""</a></li>
                            """)))
            }), format.raw /*64.30*/ ("""
                            """), format.raw /*65.29*/ ("""<li><a href=""""), _display_( /*65.43*/ controllers /*65.54*/ .pages.routes.ApplicationController.signOut), format.raw /*65.97*/ ("""">"""), _display_( /*65.100*/ Messages("sign.out")), format.raw /*65.120*/ ("""</a></li>
                        """)))
          } /*66.26*/ .getOrElse /*66.36*/ {
            _display_(Seq[Any](format.raw /*66.38*/ ("""
                            """), format.raw /*67.29*/ ("""<li><a href=""""), _display_( /*67.43*/ controllers /*67.54*/ .auth.routes.SignInController.view), format.raw /*67.88*/ ("""">"""), _display_( /*67.91*/ Messages("sign.in")), format.raw /*67.110*/ ("""</a></li>
                            <li><a href=""""), _display_( /*68.43*/ controllers /*68.54*/ .auth.routes.SignUpController.view), format.raw /*68.88*/ ("""">"""), _display_( /*68.91*/ Messages("sign.up")), format.raw /*68.110*/ ("""</a></li>
                        """)))
          }), format.raw /*69.26*/ ("""
                    """), format.raw /*70.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container-main">
            <div class="row">
                """), _display_( /*76.18*/ request /*76.25*/ .flash.get("error").map /*76.48*/ { msg =>
            _display_(Seq[Any](format.raw /*76.57*/ ("""
                """), format.raw /*77.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*79.30*/ Messages("error")), format.raw /*79.47*/ ("""</strong> """), _display_( /*79.58*/ msg), format.raw /*79.61*/ ("""
                """), format.raw /*80.17*/ ("""</div>
                """)))
          }), format.raw /*81.18*/ ("""
                """), _display_( /*82.18*/ request /*82.25*/ .flash.get("info").map /*82.47*/ { msg =>
            _display_(Seq[Any](format.raw /*82.56*/ ("""
                """), format.raw /*83.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*85.30*/ Messages("info")), format.raw /*85.46*/ ("""</strong> """), _display_( /*85.57*/ msg), format.raw /*85.60*/ ("""
                """), format.raw /*86.17*/ ("""</div>
                """)))
          }), format.raw /*87.18*/ ("""
                """), _display_( /*88.18*/ request /*88.25*/ .flash.get("success").map /*88.50*/ { msg =>
            _display_(Seq[Any](format.raw /*88.59*/ ("""
                """), format.raw /*89.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*91.30*/ Messages("success")), format.raw /*91.49*/ ("""</strong> """), _display_( /*91.60*/ msg), format.raw /*91.63*/ ("""
                """), format.raw /*92.17*/ ("""</div>
                """)))
          }), format.raw /*93.18*/ ("""
            """), format.raw /*94.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*96.18*/ content), format.raw /*96.25*/ ("""
            """), format.raw /*97.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*99.50*/ routes /*99.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*99.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*100.50*/ routes /*100.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*100.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*101.50*/ routes /*101.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*101.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*103.27*/ routes /*103.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*103.72*/ (""""></script>-->
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
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/main.scala.html
                  HASH: 462377852bf0beb35853d06ea14bec75f87dc2a4
                  MATRIX: 657->1|947->195|975->197|1242->438|1271->459|1309->460|1350->473|1409->505|1438->513|1481->525|1518->535|1551->559|1590->560|1631->573|1693->608|1725->619|1768->631|1805->641|1882->691|1897->697|1950->729|1996->748|2022->753|2329->1033|2344->1039|2424->1097|2499->1145|2514->1151|2566->1182|2641->1230|2656->1236|2742->1300|2813->1344|2828->1350|2903->1404|2971->1445|2986->1451|3036->1480|3450->1867|3465->1873|3541->1927|3625->1984|3640->1990|3715->2043|3799->2100|3814->2106|3893->2163|3981->2224|3996->2230|4059->2272|4217->2403|4232->2409|4292->2448|4680->2809|4730->2838|5142->3223|5162->3234|5216->3267|5246->3270|5287->3289|5366->3341|5386->3352|5438->3383|5468->3386|5514->3410|5664->3533|5684->3544|5738->3577|5768->3580|5808->3598|5887->3650|5907->3661|5961->3694|5991->3697|6033->3717|6273->3930|6286->3934|6299->3938|6344->3945|6401->3974|6442->3988|6462->3999|6524->4040|6554->4043|6564->4044|6591->4049|6657->4088|6761->4182|6802->4184|6863->4217|6904->4231|6924->4242|6988->4284|7019->4287|7068->4314|7138->4353|7195->4382|7236->4396|7256->4407|7320->4450|7351->4453|7393->4473|7447->4508|7466->4518|7506->4520|7563->4549|7604->4563|7624->4574|7679->4608|7709->4611|7750->4630|7829->4682|7849->4693|7904->4727|7934->4730|7975->4749|8041->4784|8090->4805|8283->4971|8299->4978|8331->5001|8378->5010|8423->5027|8617->5194|8655->5211|8693->5222|8717->5225|8762->5242|8817->5266|8862->5284|8878->5291|8909->5313|8956->5322|9001->5339|9192->5503|9229->5519|9267->5530|9291->5533|9336->5550|9391->5574|9436->5592|9452->5599|9486->5624|9533->5633|9578->5650|9772->5817|9812->5836|9850->5847|9874->5850|9919->5867|9974->5891|10015->5904|10113->5975|10141->5982|10182->5995|10281->6067|10296->6073|10372->6127|10464->6191|10480->6197|10556->6250|10648->6314|10664->6320|10744->6377|10914->6519|10930->6525|10991->6564
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|49->23|49->23|49->23|50->24|50->24|50->24|56->30|56->30|56->30|57->31|57->31|57->31|58->32|58->32|58->32|59->33|59->33|59->33|61->35|61->35|61->35|68->42|68->42|77->51|77->51|77->51|77->51|77->51|78->52|78->52|78->52|78->52|78->52|80->54|80->54|80->54|80->54|80->54|81->55|81->55|81->55|81->55|81->55|86->60|86->60|86->60|86->60|87->61|87->61|87->61|87->61|87->61|87->61|87->61|88->62|88->62|88->62|89->63|89->63|89->63|89->63|89->63|89->63|90->64|91->65|91->65|91->65|91->65|91->65|91->65|92->66|92->66|92->66|93->67|93->67|93->67|93->67|93->67|93->67|94->68|94->68|94->68|94->68|94->68|95->69|96->70|102->76|102->76|102->76|102->76|103->77|105->79|105->79|105->79|105->79|106->80|107->81|108->82|108->82|108->82|108->82|109->83|111->85|111->85|111->85|111->85|112->86|113->87|114->88|114->88|114->88|114->88|115->89|117->91|117->91|117->91|117->91|118->92|119->93|120->94|122->96|122->96|123->97|125->99|125->99|125->99|126->100|126->100|126->100|127->101|127->101|127->101|129->103|129->103|129->103
                  -- GENERATED --
              */
