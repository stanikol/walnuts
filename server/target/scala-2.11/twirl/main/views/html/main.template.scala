
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
        <!--<link rel="stylesheet" href=""""), _display_( /*20.43*/ routes /*20.49*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.css"))), format.raw /*20.107*/ ("""">-->
        <link rel="stylesheet" href=""""), _display_( /*21.39*/ routes /*21.45*/ .Assets.at("styles/styles.css")), format.raw /*21.76*/ ("""">
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
    <body>
        <header class="navbar" id="header" role="navigation">
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
                    <ul class="nav navbar-nav">
                        """), _display_( /*51.26*/ user /*51.30*/ .map /*51.34*/ { u =>
            _display_(Seq[Any](format.raw /*51.41*/ ("""
                            """), format.raw /*52.29*/ ("""<li><a href=""""), _display_( /*52.43*/ controllers /*52.54*/ .pages.routes.ApplicationController.index), format.raw /*52.95*/ ("""">"""), _display_( /*52.98*/ u /*52.99*/ .name), format.raw /*52.104*/ ("""</a></li>
                            """), _display_( /*53.30*/ if (u.loginInfo.providerID == com.mohiva.play.silhouette.impl.providers.CredentialsProvider.ID) /*53.124*/ {
              _display_(Seq[Any](format.raw /*53.126*/ ("""
                                """), format.raw /*54.33*/ ("""<li><a href=""""), _display_( /*54.47*/ controllers /*54.58*/ .auth.routes.ChangePasswordController.view), format.raw /*54.100*/ ("""">"""), _display_( /*54.103*/ Messages("change.password")), format.raw /*54.130*/ ("""</a></li>
                            """)))
            }), format.raw /*55.30*/ ("""
                            """), _display_( /*56.30*/ if (u.isAdmin) /*56.43*/ {
              _display_(Seq[Any](format.raw /*56.44*/ ("""
                                """), format.raw /*57.33*/ ("""<li><a href=""""), _display_( /*57.47*/ controllers /*57.58*/ .nuts.routes.Images.show()), format.raw /*57.84*/ ("""">"""), _display_( /*57.87*/ Messages("Edit images")), format.raw /*57.110*/ ("""</a></li>
                                <li><a href=""""), _display_( /*58.47*/ controllers /*58.58*/ .nuts.routes.Blog.showAllArticles), format.raw /*58.91*/ ("""">"""), _display_( /*58.94*/ Messages("Edit articles")), format.raw /*58.119*/ ("""</a></li>
                            """)))
            }), format.raw /*59.30*/ ("""
                            """), format.raw /*60.29*/ ("""<li><a href=""""), _display_( /*60.43*/ controllers /*60.54*/ .pages.routes.ApplicationController.signOut), format.raw /*60.97*/ ("""">"""), _display_( /*60.100*/ Messages("sign.out")), format.raw /*60.120*/ ("""</a></li>
                        """)))
          } /*61.26*/ .getOrElse /*61.36*/ {
            _display_(Seq[Any](format.raw /*61.38*/ ("""
                            """), format.raw /*62.29*/ ("""<li><a href=""""), _display_( /*62.43*/ controllers /*62.54*/ .auth.routes.SignInController.view), format.raw /*62.88*/ ("""">"""), _display_( /*62.91*/ Messages("sign.in")), format.raw /*62.110*/ ("""</a></li>
                            <li class="empty-li"><a href="/"></a></li>
                            <li><a href=""""), _display_( /*64.43*/ controllers /*64.54*/ .auth.routes.SignUpController.view), format.raw /*64.88*/ ("""">"""), _display_( /*64.91*/ Messages("sign.up")), format.raw /*64.110*/ ("""</a></li>
                        """)))
          }), format.raw /*65.26*/ ("""
                    """), format.raw /*66.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container">
            <div class="row">
                """), _display_( /*72.18*/ request /*72.25*/ .flash.get("error").map /*72.48*/ { msg =>
            _display_(Seq[Any](format.raw /*72.57*/ ("""
                """), format.raw /*73.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*75.30*/ Messages("error")), format.raw /*75.47*/ ("""</strong> """), _display_( /*75.58*/ msg), format.raw /*75.61*/ ("""
                """), format.raw /*76.17*/ ("""</div>
                """)))
          }), format.raw /*77.18*/ ("""
                """), _display_( /*78.18*/ request /*78.25*/ .flash.get("info").map /*78.47*/ { msg =>
            _display_(Seq[Any](format.raw /*78.56*/ ("""
                """), format.raw /*79.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*81.30*/ Messages("info")), format.raw /*81.46*/ ("""</strong> """), _display_( /*81.57*/ msg), format.raw /*81.60*/ ("""
                """), format.raw /*82.17*/ ("""</div>
                """)))
          }), format.raw /*83.18*/ ("""
                """), _display_( /*84.18*/ request /*84.25*/ .flash.get("success").map /*84.50*/ { msg =>
            _display_(Seq[Any](format.raw /*84.59*/ ("""
                """), format.raw /*85.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*87.30*/ Messages("success")), format.raw /*87.49*/ ("""</strong> """), _display_( /*87.60*/ msg), format.raw /*87.63*/ ("""
                """), format.raw /*88.17*/ ("""</div>
                """)))
          }), format.raw /*89.18*/ ("""
            """), format.raw /*90.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*92.18*/ content), format.raw /*92.25*/ ("""
            """), format.raw /*93.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*95.50*/ routes /*95.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*95.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*96.50*/ routes /*96.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*96.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*97.50*/ routes /*97.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*97.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*99.27*/ routes /*99.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*99.72*/ (""""></script>-->
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
                  DATE: Wed Mar 15 00:14:40 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/main.scala.html
                  HASH: a8cd2d376e0dd16963ee63f8f34a64d5132e3dfc
                  MATRIX: 657->1|947->195|975->197|1224->420|1253->441|1291->442|1332->455|1391->487|1420->495|1463->507|1500->517|1533->541|1572->542|1613->555|1675->590|1707->601|1750->613|1787->623|1864->673|1879->679|1932->711|1978->730|2004->735|2311->1015|2326->1021|2406->1079|2477->1123|2492->1129|2544->1160|2616->1205|2631->1211|2717->1275|2788->1319|2803->1325|2878->1379|2946->1420|2961->1426|3011->1455|3425->1842|3440->1848|3516->1902|3600->1959|3615->1965|3690->2018|3774->2075|3789->2081|3868->2138|3956->2199|3971->2205|4034->2247|4192->2378|4207->2384|4267->2423|4643->2772|4693->2801|4978->3059|4998->3070|5061->3111|5092->3114|5135->3135|5321->3294|5334->3298|5347->3302|5392->3309|5449->3338|5490->3352|5510->3363|5572->3404|5602->3407|5612->3408|5639->3413|5705->3452|5809->3546|5850->3548|5911->3581|5952->3595|5972->3606|6036->3648|6067->3651|6116->3678|6186->3717|6243->3747|6265->3760|6304->3761|6365->3794|6406->3808|6426->3819|6473->3845|6503->3848|6548->3871|6631->3927|6651->3938|6705->3971|6735->3974|6782->3999|6852->4038|6909->4067|6950->4081|6970->4092|7034->4135|7065->4138|7107->4158|7161->4193|7180->4203|7220->4205|7277->4234|7318->4248|7338->4259|7393->4293|7423->4296|7464->4315|7614->4438|7634->4449|7689->4483|7719->4486|7760->4505|7826->4540|7875->4561|8063->4722|8079->4729|8111->4752|8158->4761|8203->4778|8397->4945|8435->4962|8473->4973|8497->4976|8542->4993|8597->5017|8642->5035|8658->5042|8689->5064|8736->5073|8781->5090|8972->5254|9009->5270|9047->5281|9071->5284|9116->5301|9171->5325|9216->5343|9232->5350|9266->5375|9313->5384|9358->5401|9552->5568|9592->5587|9630->5598|9654->5601|9699->5618|9754->5642|9795->5655|9893->5726|9921->5733|9962->5746|10061->5818|10076->5824|10152->5878|10243->5942|10258->5948|10333->6001|10424->6065|10439->6071|10518->6128|10687->6270|10702->6276|10762->6315
                  LINES: 22->1|27->1|29->3|35->9|35->9|35->9|36->10|36->10|36->10|37->11|38->12|38->12|38->12|39->13|39->13|39->13|40->14|42->16|42->16|42->16|42->16|43->17|43->17|46->20|46->20|46->20|47->21|47->21|47->21|48->22|48->22|48->22|49->23|49->23|49->23|50->24|50->24|50->24|56->30|56->30|56->30|57->31|57->31|57->31|58->32|58->32|58->32|59->33|59->33|59->33|61->35|61->35|61->35|68->42|68->42|73->47|73->47|73->47|73->47|73->47|77->51|77->51|77->51|77->51|78->52|78->52|78->52|78->52|78->52|78->52|78->52|79->53|79->53|79->53|80->54|80->54|80->54|80->54|80->54|80->54|81->55|82->56|82->56|82->56|83->57|83->57|83->57|83->57|83->57|83->57|84->58|84->58|84->58|84->58|84->58|85->59|86->60|86->60|86->60|86->60|86->60|86->60|87->61|87->61|87->61|88->62|88->62|88->62|88->62|88->62|88->62|90->64|90->64|90->64|90->64|90->64|91->65|92->66|98->72|98->72|98->72|98->72|99->73|101->75|101->75|101->75|101->75|102->76|103->77|104->78|104->78|104->78|104->78|105->79|107->81|107->81|107->81|107->81|108->82|109->83|110->84|110->84|110->84|110->84|111->85|113->87|113->87|113->87|113->87|114->88|115->89|116->90|118->92|118->92|119->93|121->95|121->95|121->95|122->96|122->96|122->96|123->97|123->97|123->97|125->99|125->99|125->99
                  -- GENERATED --
              */
