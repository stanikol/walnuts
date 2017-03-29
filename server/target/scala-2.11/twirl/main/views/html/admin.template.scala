
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
                </div>
                <nav class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        """), _display_( /*48.26*/ user /*48.30*/ .map /*48.34*/ { u =>
            _display_(Seq[Any](format.raw /*48.41*/ ("""
                            """), format.raw /*49.29*/ ("""<li><a href=""""), _display_( /*49.43*/ controllers /*49.54*/ .pages.routes.ApplicationController.index), format.raw /*49.95*/ ("""">"""), _display_( /*49.98*/ u /*49.99*/ .name), format.raw /*49.104*/ ("""</a></li>
                            """), _display_( /*50.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*50.124*/ {
              _display_(Seq[Any](format.raw /*50.126*/ ("""
                                """), format.raw /*51.33*/ ("""<li><a href=""""), _display_( /*51.47*/ controllers /*51.58*/ .auth.routes.ChangePasswordController.view), format.raw /*51.100*/ ("""">"""), _display_( /*51.103*/ Messages("change.password")), format.raw /*51.130*/ ("""</a></li>
                            """)))
            }), format.raw /*52.30*/ ("""
                            """), _display_( /*53.30*/ if (u.isAdmin) /*53.43*/ {
              _display_(Seq[Any](format.raw /*53.44*/ ("""
                                """), format.raw /*54.33*/ ("""<li><a href=""""), _display_( /*54.47*/ controllers /*54.58*/ .nuts.routes.Images.show()), format.raw /*54.84*/ ("""">"""), _display_( /*54.87*/ Messages("Edit images")), format.raw /*54.110*/ ("""</a></li>
                                <li><a href=""""), _display_( /*55.47*/ controllers /*55.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*55.91*/ ("""">"""), _display_( /*55.94*/ Messages("Edit articles")), format.raw /*55.119*/ ("""</a></li>
                                <li><a href=""""), _display_( /*56.47*/ controllers /*56.58*/ .nuts.routes.Comments.commentsAdmin), format.raw /*56.93*/ ("""">"""), _display_( /*56.96*/ Messages("Edit comments")), format.raw /*56.121*/ ("""</a></li>
                            """)))
            }), format.raw /*57.30*/ ("""
                            """), format.raw /*58.29*/ ("""<li><a href=""""), _display_( /*58.43*/ controllers /*58.54*/ .pages.routes.ApplicationController.signOut), format.raw /*58.97*/ ("""">"""), _display_( /*58.100*/ Messages("sign.out")), format.raw /*58.120*/ ("""</a></li>
                        """)))
          } /*59.26*/ .getOrElse /*59.36*/ {
            _display_(Seq[Any](format.raw /*59.38*/ ("""
                            """), format.raw /*60.29*/ ("""<li><a href=""""), _display_( /*60.43*/ controllers /*60.54*/ .auth.routes.SignInController.view), format.raw /*60.88*/ ("""">"""), _display_( /*60.91*/ Messages("sign.in")), format.raw /*60.110*/ ("""</a></li>
                            <li class="empty-li"><a href="/"></a></li>
                            <li><a href=""""), _display_( /*62.43*/ controllers /*62.54*/ .auth.routes.SignUpController.view), format.raw /*62.88*/ ("""">"""), _display_( /*62.91*/ Messages("sign.up")), format.raw /*62.110*/ ("""</a></li>
                        """)))
          }), format.raw /*63.26*/ ("""
                    """), format.raw /*64.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container">
            <div class="row">
                """), _display_( /*70.18*/ request /*70.25*/ .flash.get("error").map /*70.48*/ { msg =>
            _display_(Seq[Any](format.raw /*70.57*/ ("""
                """), format.raw /*71.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*73.30*/ Messages("error")), format.raw /*73.47*/ ("""</strong> """), _display_( /*73.58*/ msg), format.raw /*73.61*/ ("""
                """), format.raw /*74.17*/ ("""</div>
                """)))
          }), format.raw /*75.18*/ ("""
                """), _display_( /*76.18*/ request /*76.25*/ .flash.get("info").map /*76.47*/ { msg =>
            _display_(Seq[Any](format.raw /*76.56*/ ("""
                """), format.raw /*77.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*79.30*/ Messages("info")), format.raw /*79.46*/ ("""</strong> """), _display_( /*79.57*/ msg), format.raw /*79.60*/ ("""
                """), format.raw /*80.17*/ ("""</div>
                """)))
          }), format.raw /*81.18*/ ("""
                """), _display_( /*82.18*/ request /*82.25*/ .flash.get("success").map /*82.50*/ { msg =>
            _display_(Seq[Any](format.raw /*82.59*/ ("""
                """), format.raw /*83.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*85.30*/ Messages("success")), format.raw /*85.49*/ ("""</strong> """), _display_( /*85.60*/ msg), format.raw /*85.63*/ ("""
                """), format.raw /*86.17*/ ("""</div>
                """)))
          }), format.raw /*87.18*/ ("""
            """), format.raw /*88.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*90.18*/ content), format.raw /*90.25*/ ("""
            """), format.raw /*91.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*93.50*/ routes /*93.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*93.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*94.50*/ routes /*94.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*94.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*95.50*/ routes /*95.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*95.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*97.27*/ routes /*97.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*97.72*/ (""""></script>-->
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
                  DATE: Fri Mar 24 12:14:57 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/admin.scala.html
                  HASH: a807d699854cb1694b916ed22df06831890d7646
                  MATRIX: 659->1|949->195|977->197|1226->420|1255->441|1293->442|1334->455|1393->487|1422->495|1465->507|1502->517|1535->541|1574->542|1615->555|1677->590|1709->601|1752->613|1789->623|1866->673|1881->679|1934->711|1980->730|2006->735|2309->1011|2324->1017|2399->1071|2467->1112|2482->1118|2533->1148|2605->1193|2620->1199|2670->1228|3087->1618|3102->1624|3178->1678|3262->1735|3277->1741|3352->1794|3436->1851|3451->1857|3530->1914|3618->1975|3633->1981|3696->2023|3854->2154|3869->2160|3929->2199|4293->2536|4343->2565|4724->2919|4737->2923|4750->2927|4795->2934|4852->2963|4893->2977|4913->2988|4975->3029|5005->3032|5015->3033|5042->3038|5108->3077|5212->3171|5253->3173|5314->3206|5355->3220|5375->3231|5439->3273|5470->3276|5519->3303|5589->3342|5646->3372|5668->3385|5707->3386|5768->3419|5809->3433|5829->3444|5876->3470|5906->3473|5951->3496|6034->3552|6054->3563|6108->3596|6138->3599|6185->3624|6268->3680|6288->3691|6344->3726|6374->3729|6421->3754|6491->3793|6548->3822|6589->3836|6609->3847|6673->3890|6704->3893|6746->3913|6800->3948|6819->3958|6859->3960|6916->3989|6957->4003|6977->4014|7032->4048|7062->4051|7103->4070|7253->4193|7273->4204|7328->4238|7358->4241|7399->4260|7465->4295|7514->4316|7702->4477|7718->4484|7750->4507|7797->4516|7842->4533|8036->4700|8074->4717|8112->4728|8136->4731|8181->4748|8236->4772|8281->4790|8297->4797|8328->4819|8375->4828|8420->4845|8611->5009|8648->5025|8686->5036|8710->5039|8755->5056|8810->5080|8855->5098|8871->5105|8905->5130|8952->5139|8997->5156|9191->5323|9231->5342|9269->5353|9293->5356|9338->5373|9393->5397|9434->5410|9532->5481|9560->5488|9601->5501|9700->5573|9715->5579|9791->5633|9882->5697|9897->5703|9972->5756|10063->5820|10078->5826|10157->5883|10326->6025|10341->6031|10401->6070
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|54->28|54->28|54->28|55->29|55->29|55->29|56->30|56->30|56->30|57->31|57->31|57->31|59->33|59->33|59->33|66->40|66->40|74->48|74->48|74->48|74->48|75->49|75->49|75->49|75->49|75->49|75->49|75->49|76->50|76->50|76->50|77->51|77->51|77->51|77->51|77->51|77->51|78->52|79->53|79->53|79->53|80->54|80->54|80->54|80->54|80->54|80->54|81->55|81->55|81->55|81->55|81->55|82->56|82->56|82->56|82->56|82->56|83->57|84->58|84->58|84->58|84->58|84->58|84->58|85->59|85->59|85->59|86->60|86->60|86->60|86->60|86->60|86->60|88->62|88->62|88->62|88->62|88->62|89->63|90->64|96->70|96->70|96->70|96->70|97->71|99->73|99->73|99->73|99->73|100->74|101->75|102->76|102->76|102->76|102->76|103->77|105->79|105->79|105->79|105->79|106->80|107->81|108->82|108->82|108->82|108->82|109->83|111->85|111->85|111->85|111->85|112->86|113->87|114->88|116->90|116->90|117->91|119->93|119->93|119->93|120->94|120->94|120->94|121->95|121->95|121->95|123->97|123->97|123->97
                  -- GENERATED --
              */
