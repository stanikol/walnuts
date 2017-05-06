
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
        <!--<header class="navbar brand" role="navigation">-->
        <header class="navbar brand" role="navigation">
            <div class="container" >
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-nuts">
                        <span class="sr-only">!!! """), _display_( /*43.52*/ Messages("toggle.navigation")), format.raw /*43.81*/ ("""</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="navbar-nuts">
                    <ul class="nav navbar-nav navbar-upper navbar-left" id="navbar-upper-left">
                            <li><a href=""""), _display_( /*52.43*/ controllers /*52.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*52.87*/ ("""">"""), _display_( /*52.90*/ Messages("ГЛАВНАЯ")), format.raw /*52.109*/ ("""</a></li>
                            <li><a href=""""), _display_( /*53.43*/ controllers /*53.54*/ .goods.routes.Goods.listAllGoods), format.raw /*53.86*/ ("""">"""), _display_( /*53.89*/ Messages("СОРТА ОРЕХОВ")), format.raw /*53.113*/ ("""</a></li>
                            <!--<li class="empty-li"><a href="#"></a></li>-->
                            <!--<li><a href=""""), _display_( /*55.47*/ controllers /*55.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*55.91*/ ("""">"""), _display_( /*55.94*/ Messages("Статьи")), format.raw /*55.112*/ ("""</a></li>-->
                            <!--<li><a href=""""), _display_( /*56.47*/ controllers /*56.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*56.91*/ ("""">"""), _display_( /*56.94*/ Messages("Контакты")), format.raw /*56.114*/ ("""</a></li>-->
                    </ul>
                    <ul class="nav navbar-nav navbar-upper navbar-right" id="navbar-upper-right">
                            <!--<li><a href=""""), _display_( /*59.47*/ controllers /*59.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*59.91*/ ("""">"""), _display_( /*59.94*/ Messages("Главная")), format.raw /*59.113*/ ("""</a></li>-->
                            <!--<li><a href=""""), _display_( /*60.47*/ controllers /*60.58*/ .goods.routes.Goods.listAllGoods), format.raw /*60.90*/ ("""">"""), _display_( /*60.93*/ Messages("Сорта орехов")), format.raw /*60.117*/ ("""</a></li>-->
                            <!--<li class="empty-li"><a href="#"></a></li>-->
                            <li><a href=""""), _display_( /*62.43*/ controllers /*62.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*62.87*/ ("""">"""), _display_( /*62.90*/ Messages("СТАТЬИ")), format.raw /*62.108*/ ("""</a></li>
                            <li><a href=""""), _display_( /*63.43*/ controllers /*63.54*/ .images.routes.Images.showGallery), format.raw /*63.87*/ ("""">ФОТО</a></li>
                            <li><a href=""""), _display_( /*64.43*/ controllers /*64.54*/ .nuts.routes.Blog.showAllArticles), format.raw /*64.87*/ ("""">"""), _display_( /*64.90*/ Messages("КОНТАКТЫ")), format.raw /*64.110*/ ("""</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-lower navbar-left" id="navbar-lower-left">
                        <li><a href=""""), _display_( /*67.39*/ controllers /*67.50*/ .images.routes.Images.showGallery), format.raw /*67.83*/ ("""">Фото</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-lower navbar-right" id="navbar-lower-right">
                        """), _display_( /*70.26*/ user /*70.30*/ .map /*70.34*/ { u =>
            _display_(Seq[Any](format.raw /*70.41*/ ("""
                            """), format.raw /*71.29*/ ("""<!--<li><a href=""""), _display_( /*71.47*/ controllers /*71.58*/ .pages.routes.ApplicationController.index), format.raw /*71.99*/ ("""">"""), _display_( /*71.102*/ u /*71.103*/ .name), format.raw /*71.108*/ ("""</a></li>-->
                            """), _display_( /*72.30*/ if (u.isAdmin) /*72.43*/ {
              _display_(Seq[Any](format.raw /*72.44*/ ("""
                                """), format.raw /*73.33*/ ("""<li><a href=""""), _display_( /*73.47*/ controllers /*73.58*/ .images.routes.Images.showAdminImageForm()), format.raw /*73.100*/ ("""">Admin</a></li>
                            """)))
            }), format.raw /*74.30*/ ("""
                            """), _display_( /*75.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*75.124*/ {
              _display_(Seq[Any](format.raw /*75.126*/ ("""
                                """), format.raw /*76.33*/ ("""<li><a href=""""), _display_( /*76.47*/ controllers /*76.58*/ .auth.routes.ChangePasswordController.view), format.raw /*76.100*/ ("""">"""), _display_( /*76.103*/ Messages("change.password")), format.raw /*76.130*/ ("""</a></li>
                            """)))
            }), format.raw /*77.30*/ ("""
                            """), format.raw /*78.29*/ ("""<li><a href=""""), _display_( /*78.43*/ controllers /*78.54*/ .pages.routes.ApplicationController.signOut), format.raw /*78.97*/ ("""">"""), _display_( /*78.100*/ Messages("sign.out")), format.raw /*78.120*/ ("""</a></li>
                        """)))
          } /*79.26*/ .getOrElse /*79.36*/ {
            _display_(Seq[Any](format.raw /*79.38*/ ("""
                            """), format.raw /*80.29*/ ("""<li><a href=""""), _display_( /*80.43*/ controllers /*80.54*/ .auth.routes.SignInController.view), format.raw /*80.88*/ ("""">"""), _display_( /*80.91*/ Messages("sign.in")), format.raw /*80.110*/ ("""</a></li>
                            <li><a href=""""), _display_( /*81.43*/ controllers /*81.54*/ .auth.routes.SignUpController.view), format.raw /*81.88*/ ("""">"""), _display_( /*81.91*/ Messages("sign.up")), format.raw /*81.110*/ ("""</a></li>
                        """)))
          }), format.raw /*82.26*/ ("""
                    """), format.raw /*83.21*/ ("""</ul>
                </div>
            </div>
        </header>
        <main class="container" id="container-main">
            <div class="row">
                """), _display_( /*89.18*/ request /*89.25*/ .flash.get("error").map /*89.48*/ { msg =>
            _display_(Seq[Any](format.raw /*89.57*/ ("""
                """), format.raw /*90.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*92.30*/ Messages("error")), format.raw /*92.47*/ ("""</strong> """), _display_( /*92.58*/ msg), format.raw /*92.61*/ ("""
                """), format.raw /*93.17*/ ("""</div>
                """)))
          }), format.raw /*94.18*/ ("""
                """), _display_( /*95.18*/ request /*95.25*/ .flash.get("info").map /*95.47*/ { msg =>
            _display_(Seq[Any](format.raw /*95.56*/ ("""
                """), format.raw /*96.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*98.30*/ Messages("info")), format.raw /*98.46*/ ("""</strong> """), _display_( /*98.57*/ msg), format.raw /*98.60*/ ("""
                """), format.raw /*99.17*/ ("""</div>
                """)))
          }), format.raw /*100.18*/ ("""
                """), _display_( /*101.18*/ request /*101.25*/ .flash.get("success").map /*101.50*/ { msg =>
            _display_(Seq[Any](format.raw /*101.59*/ ("""
                """), format.raw /*102.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*104.30*/ Messages("success")), format.raw /*104.49*/ ("""</strong> """), _display_( /*104.60*/ msg), format.raw /*104.63*/ ("""
                """), format.raw /*105.17*/ ("""</div>
                """)))
          }), format.raw /*106.18*/ ("""
            """), format.raw /*107.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*109.18*/ content), format.raw /*109.25*/ ("""
            """), format.raw /*110.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*112.50*/ routes /*112.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*112.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*113.50*/ routes /*113.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*113.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*114.50*/ routes /*114.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*114.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*116.27*/ routes /*116.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*116.72*/ (""""></script>-->
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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/main.scala.html
                  HASH: 700c156092b86ff5fec84b92a097917297a01a14
                  MATRIX: 777->1|1067->195|1095->197|1362->438|1391->459|1429->460|1470->473|1529->505|1558->513|1601->525|1638->535|1671->559|1710->560|1751->573|1813->608|1845->619|1888->631|1925->641|2002->691|2017->697|2070->729|2116->748|2142->753|2449->1033|2464->1039|2544->1097|2619->1145|2634->1151|2686->1182|2761->1230|2776->1236|2862->1300|2933->1344|2948->1350|3023->1404|3091->1445|3106->1451|3156->1480|3570->1867|3585->1873|3661->1927|3745->1984|3760->1990|3835->2043|3919->2100|3934->2106|4013->2163|4101->2224|4116->2230|4179->2272|4337->2403|4352->2409|4412->2448|4859->2868|4909->2897|5373->3334|5393->3345|5447->3378|5477->3381|5518->3400|5597->3452|5617->3463|5670->3495|5700->3498|5746->3522|5907->3656|5927->3667|5981->3700|6011->3703|6051->3721|6137->3780|6157->3791|6211->3824|6241->3827|6283->3847|6493->4030|6513->4041|6567->4074|6597->4077|6638->4096|6724->4155|6744->4166|6797->4198|6827->4201|6873->4225|7033->4358|7053->4369|7107->4402|7137->4405|7177->4423|7256->4475|7276->4486|7330->4519|7415->4577|7435->4588|7489->4621|7519->4624|7561->4644|7758->4814|7778->4825|7832->4858|8024->5023|8037->5027|8050->5031|8095->5038|8152->5067|8197->5085|8217->5096|8279->5137|8310->5140|8321->5141|8348->5146|8417->5188|8439->5201|8478->5202|8539->5235|8580->5249|8600->5260|8664->5302|8741->5348|8798->5378|8902->5472|8943->5474|9004->5507|9045->5521|9065->5532|9129->5574|9160->5577|9209->5604|9279->5643|9336->5672|9377->5686|9397->5697|9461->5740|9492->5743|9534->5763|9588->5798|9607->5808|9647->5810|9704->5839|9745->5853|9765->5864|9820->5898|9850->5901|9891->5920|9970->5972|9990->5983|10045->6017|10075->6020|10116->6039|10182->6074|10231->6095|10424->6261|10440->6268|10472->6291|10519->6300|10564->6317|10758->6484|10796->6501|10834->6512|10858->6515|10903->6532|10958->6556|11003->6574|11019->6581|11050->6603|11097->6612|11142->6629|11333->6793|11370->6809|11408->6820|11432->6823|11477->6840|11533->6864|11579->6882|11596->6889|11631->6914|11679->6923|11725->6940|11920->7107|11961->7126|12000->7137|12025->7140|12071->7157|12127->7181|12169->7194|12268->7265|12297->7272|12339->7285|12439->7357|12455->7363|12532->7417|12624->7481|12640->7487|12716->7540|12808->7604|12824->7610|12904->7667|13074->7809|13090->7815|13151->7854
                  LINES: 26->1|31->1|33->3|39->9|39->9|39->9|40->10|40->10|40->10|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|46->16|46->16|46->16|46->16|47->17|47->17|50->20|50->20|50->20|51->21|51->21|51->21|52->22|52->22|52->22|53->23|53->23|53->23|54->24|54->24|54->24|60->30|60->30|60->30|61->31|61->31|61->31|62->32|62->32|62->32|63->33|63->33|63->33|65->35|65->35|65->35|73->43|73->43|82->52|82->52|82->52|82->52|82->52|83->53|83->53|83->53|83->53|83->53|85->55|85->55|85->55|85->55|85->55|86->56|86->56|86->56|86->56|86->56|89->59|89->59|89->59|89->59|89->59|90->60|90->60|90->60|90->60|90->60|92->62|92->62|92->62|92->62|92->62|93->63|93->63|93->63|94->64|94->64|94->64|94->64|94->64|97->67|97->67|97->67|100->70|100->70|100->70|100->70|101->71|101->71|101->71|101->71|101->71|101->71|101->71|102->72|102->72|102->72|103->73|103->73|103->73|103->73|104->74|105->75|105->75|105->75|106->76|106->76|106->76|106->76|106->76|106->76|107->77|108->78|108->78|108->78|108->78|108->78|108->78|109->79|109->79|109->79|110->80|110->80|110->80|110->80|110->80|110->80|111->81|111->81|111->81|111->81|111->81|112->82|113->83|119->89|119->89|119->89|119->89|120->90|122->92|122->92|122->92|122->92|123->93|124->94|125->95|125->95|125->95|125->95|126->96|128->98|128->98|128->98|128->98|129->99|130->100|131->101|131->101|131->101|131->101|132->102|134->104|134->104|134->104|134->104|135->105|136->106|137->107|139->109|139->109|140->110|142->112|142->112|142->112|143->113|143->113|143->113|144->114|144->114|144->114|146->116|146->116|146->116
                  -- GENERATED --
              */
