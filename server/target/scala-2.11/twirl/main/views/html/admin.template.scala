
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
  import models.blog.Data._
  import models.blog.FormsData._
  import models.goods._
  import controllers.goods.FormsData._
  import models.images._
  import controllers.images.FormsData._

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
                                """), format.raw /*54.33*/ ("""<li class="dropdown">
                                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">"""), _display_( /*55.152*/ Messages("Фото")), format.raw /*55.168*/ ("""<span class="caret"></span></a>
                                  <ul class="dropdown-menu">
                                    <li><a href=""""), _display_( /*57.51*/ controllers /*57.62*/ .images.routes.Images.showAdminImageForm("")), format.raw /*57.106*/ ("""">"""), _display_( /*57.109*/ Messages("Редактировать")), format.raw /*57.134*/ ("""</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""), _display_( /*59.51*/ controllers /*59.62*/ .images.routes.Images.showGallery), format.raw /*59.95*/ ("""">"""), _display_( /*59.98*/ Messages("Галлерея")), format.raw /*59.118*/ ("""</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""), _display_( /*61.51*/ controllers /*61.62*/ .nuts.routes.AdminCategories.adminAlbumsCategories), format.raw /*61.112*/ ("""">"""), _display_( /*61.115*/ Messages("Редактировать альбомы")), format.raw /*61.148*/ ("""</a></li>
                                  </ul>
                                </li>
                                <li class="dropdown">
                                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">"""), _display_( /*65.152*/ Messages("Орехи")), format.raw /*65.169*/ ("""<span class="caret"></span></a>
                                  <ul class="dropdown-menu">
                                    <li><a href=""""), _display_( /*67.51*/ controllers /*67.62*/ .goods.routes.Goods.showItemEditForm(None)), format.raw /*67.104*/ ("""">Новый</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""), _display_( /*69.51*/ controllers /*69.62*/ .goods.routes.Goods.listAllGoods), format.raw /*69.94*/ ("""">Перечень орехов</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""), _display_( /*71.51*/ controllers /*71.62*/ .nuts.routes.AdminCategories.adminGoodsCategoriesHandle), format.raw /*71.117*/ ("""">Радактировать категории</a></li>
                                  </ul>
                                </li>
                                <li class="dropdown">
                                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">"""), _display_( /*75.152*/ Messages("Статьи")), format.raw /*75.170*/ ("""<span class="caret"></span></a>
                                  <ul class="dropdown-menu">
                                    <li><a href=""""), _display_( /*77.51*/ controllers /*77.62*/ .nuts.routes.Blog.create), format.raw /*77.86*/ ("""">"""), _display_( /*77.89*/ Messages("Новая статья")), format.raw /*77.113*/ ("""</a>
                                    <li role="separator" class="divider"></li>
                                    <li><a href=""""), _display_( /*79.51*/ controllers /*79.62*/ .nuts.routes.Blog.showAllArticles), format.raw /*79.95*/ ("""">"""), _display_( /*79.98*/ Messages("Список статей")), format.raw /*79.123*/ ("""</a></li>
                                  </ul>
                                </li>
                                <li><a href=""""), _display_( /*82.47*/ controllers /*82.58*/ .nuts.routes.Comments.commentsAdmin), format.raw /*82.93*/ ("""">"""), _display_( /*82.96*/ Messages("Комментарии")), format.raw /*82.119*/ ("""</a></li>
                            """)))
            }), format.raw /*83.30*/ ("""
                            """), format.raw /*84.29*/ ("""<li><a href=""""), _display_( /*84.43*/ controllers /*84.54*/ .pages.routes.ApplicationController.signOut), format.raw /*84.97*/ ("""">"""), _display_( /*84.100*/ Messages("sign.out")), format.raw /*84.120*/ ("""</a></li>
                        """)))
          } /*85.26*/ .getOrElse /*85.36*/ {
            _display_(Seq[Any](format.raw /*85.38*/ ("""
                            """), format.raw /*86.29*/ ("""<li><a href=""""), _display_( /*86.43*/ controllers /*86.54*/ .auth.routes.SignInController.view), format.raw /*86.88*/ ("""">"""), _display_( /*86.91*/ Messages("sign.in")), format.raw /*86.110*/ ("""</a></li>
                            <li class="empty-li"><a href="/"></a></li>
                            <li><a href=""""), _display_( /*88.43*/ controllers /*88.54*/ .auth.routes.SignUpController.view), format.raw /*88.88*/ ("""">"""), _display_( /*88.91*/ Messages("sign.up")), format.raw /*88.110*/ ("""</a></li>
                        """)))
          }), format.raw /*89.26*/ ("""
                    """), format.raw /*90.21*/ ("""</ul>
                </nav>
            </div>
        </header>
        <main class="container" id="container">
            <div class="row">
                """), _display_( /*96.18*/ request /*96.25*/ .flash.get("error").map /*96.48*/ { msg =>
            _display_(Seq[Any](format.raw /*96.57*/ ("""
                """), format.raw /*97.17*/ ("""<div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*99.30*/ Messages("error")), format.raw /*99.47*/ ("""</strong> """), _display_( /*99.58*/ msg), format.raw /*99.61*/ ("""
                """), format.raw /*100.17*/ ("""</div>
                """)))
          }), format.raw /*101.18*/ ("""
                """), _display_( /*102.18*/ request /*102.25*/ .flash.get("info").map /*102.47*/ { msg =>
            _display_(Seq[Any](format.raw /*102.56*/ ("""
                """), format.raw /*103.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-info">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*105.30*/ Messages("info")), format.raw /*105.46*/ ("""</strong> """), _display_( /*105.57*/ msg), format.raw /*105.60*/ ("""
                """), format.raw /*106.17*/ ("""</div>
                """)))
          }), format.raw /*107.18*/ ("""
                """), _display_( /*108.18*/ request /*108.25*/ .flash.get("success").map /*108.50*/ { msg =>
            _display_(Seq[Any](format.raw /*108.59*/ ("""
                """), format.raw /*109.17*/ ("""<div class="col-md-6 col-md-offset-3 alert alert-success">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>"""), _display_( /*111.30*/ Messages("success")), format.raw /*111.49*/ ("""</strong> """), _display_( /*111.60*/ msg), format.raw /*111.63*/ ("""
                """), format.raw /*112.17*/ ("""</div>
                """)))
          }), format.raw /*113.18*/ ("""
            """), format.raw /*114.13*/ ("""</div>
            <div class="starter-template row">
                """), _display_( /*116.18*/ content), format.raw /*116.25*/ ("""
            """), format.raw /*117.13*/ ("""</div>
        </main>
        <!--<script type="text/javascript" src=""""), _display_( /*119.50*/ routes /*119.56*/ .WebJarAssets.at(webJarAssets.locate("jquery.min.js"))), format.raw /*119.110*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*120.50*/ routes /*120.56*/ .WebJarAssets.at(webJarAssets.locate("jquery-ui.js"))), format.raw /*120.109*/ (""""></script>-->
        <!--<script type="text/javascript" src=""""), _display_( /*121.50*/ routes /*121.56*/ .WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))), format.raw /*121.113*/ (""""></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>-->
        <!--<script src=""""), _display_( /*123.27*/ routes /*123.33*/ .Assets.at("javascripts/zxcvbnShim.js")), format.raw /*123.72*/ (""""></script>-->
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
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/admin.scala.html
                  HASH: bcb6f2a4c5841d543ef1504362dbb55a07182f00
                  MATRIX: 779->1|1069->195|1097->197|1346->420|1375->441|1413->442|1454->455|1513->487|1542->495|1585->507|1622->517|1655->541|1694->542|1735->555|1797->590|1829->601|1872->613|1909->623|1986->673|2001->679|2054->711|2100->730|2126->735|2429->1011|2444->1017|2519->1071|2587->1112|2602->1118|2653->1148|2725->1193|2740->1199|2790->1228|3207->1618|3222->1624|3298->1678|3382->1735|3397->1741|3472->1794|3556->1851|3571->1857|3650->1914|3738->1975|3753->1981|3816->2023|3974->2154|3989->2160|4049->2199|4413->2536|4463->2565|4844->2919|4857->2923|4870->2927|4915->2934|4972->2963|5013->2977|5033->2988|5095->3029|5125->3032|5135->3033|5162->3038|5228->3077|5332->3171|5373->3173|5434->3206|5475->3220|5495->3231|5559->3273|5590->3276|5639->3303|5709->3342|5766->3372|5788->3385|5827->3386|5888->3419|6089->3592|6127->3608|6297->3751|6317->3762|6383->3806|6414->3809|6461->3834|6627->3973|6647->3984|6701->4017|6731->4020|6773->4040|6939->4179|6959->4190|7031->4240|7062->4243|7117->4276|7438->4569|7477->4586|7647->4729|7667->4740|7731->4782|7904->4928|7924->4939|7977->4971|8160->5127|8180->5138|8257->5193|8603->5511|8643->5529|8813->5672|8833->5683|8878->5707|8908->5710|8954->5734|9115->5868|9135->5879|9189->5912|9219->5915|9266->5940|9427->6074|9447->6085|9503->6120|9533->6123|9578->6146|9648->6185|9705->6214|9746->6228|9766->6239|9830->6282|9861->6285|9903->6305|9957->6340|9976->6350|10016->6352|10073->6381|10114->6395|10134->6406|10189->6440|10219->6443|10260->6462|10410->6585|10430->6596|10485->6630|10515->6633|10556->6652|10622->6687|10671->6708|10859->6869|10875->6876|10907->6899|10954->6908|10999->6925|11193->7092|11231->7109|11269->7120|11293->7123|11339->7140|11395->7164|11441->7182|11458->7189|11490->7211|11538->7220|11584->7237|11776->7401|11814->7417|11853->7428|11878->7431|11924->7448|11980->7472|12026->7490|12043->7497|12078->7522|12126->7531|12172->7548|12367->7715|12408->7734|12447->7745|12472->7748|12518->7765|12574->7789|12616->7802|12715->7873|12744->7880|12786->7893|12886->7965|12902->7971|12979->8025|13071->8089|13087->8095|13163->8148|13255->8212|13271->8218|13351->8275|13521->8417|13537->8423|13598->8462
                  LINES: 26->1|31->1|33->3|39->9|39->9|39->9|40->10|40->10|40->10|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|46->16|46->16|46->16|46->16|47->17|47->17|50->20|50->20|50->20|51->21|51->21|51->21|52->22|52->22|52->22|58->28|58->28|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31|61->31|61->31|63->33|63->33|63->33|70->40|70->40|78->48|78->48|78->48|78->48|79->49|79->49|79->49|79->49|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|81->51|81->51|81->51|82->52|83->53|83->53|83->53|84->54|85->55|85->55|87->57|87->57|87->57|87->57|87->57|89->59|89->59|89->59|89->59|89->59|91->61|91->61|91->61|91->61|91->61|95->65|95->65|97->67|97->67|97->67|99->69|99->69|99->69|101->71|101->71|101->71|105->75|105->75|107->77|107->77|107->77|107->77|107->77|109->79|109->79|109->79|109->79|109->79|112->82|112->82|112->82|112->82|112->82|113->83|114->84|114->84|114->84|114->84|114->84|114->84|115->85|115->85|115->85|116->86|116->86|116->86|116->86|116->86|116->86|118->88|118->88|118->88|118->88|118->88|119->89|120->90|126->96|126->96|126->96|126->96|127->97|129->99|129->99|129->99|129->99|130->100|131->101|132->102|132->102|132->102|132->102|133->103|135->105|135->105|135->105|135->105|136->106|137->107|138->108|138->108|138->108|138->108|139->109|141->111|141->111|141->111|141->111|142->112|143->113|144->114|146->116|146->116|147->117|149->119|149->119|149->119|150->120|150->120|150->120|151->121|151->121|151->121|153->123|153->123|153->123
                  -- GENERATED --
              */
