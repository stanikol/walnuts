
package views.html.images

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object editImages_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class editImages extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[models.User, Seq[ImageInfo], Form[SaveImage], Form[FindImages], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, imageInfoList: Seq[ImageInfo], saveImage: Form[SaveImage], findImages: Form[FindImages])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF
          import helper._
          import b3.vertical.fieldConstructor

          Seq[Any](format.raw /*1.191*/ ("""

"""), _display_( /*6.2*/ main(Messages("images.title"), Some(user)) /*6.44*/ {
            _display_(Seq[Any](format.raw /*6.45*/ ("""
    """), format.raw /*7.5*/ ("""<div class="image-info-list">
        """), _display_( /*8.10*/ b3 /*8.12*/ .formCSRF(action = controllers.nuts.routes.Images.save, 'enctype -> "multipart/form-data") /*8.102*/ {
              _display_(Seq[Any](format.raw /*8.104*/ ("""
            """), format.raw /*9.13*/ ("""<div class="row">
                <div class="col-md-4">
                    <div class="well">
                        """), _display_( /*12.26*/ b3 /*12.28*/ .file(saveImage("new-image"), '_label -> Messages("images.choose-image"), 'class -> "form-control")), format.raw /*12.129*/ ("""
                        """), format.raw /*13.25*/ ("""<!--<label for="new-image">"""), _display_( /*13.53*/ Messages("images.choose-image")), format.raw /*13.84*/ ("""</label>-->
                        <!--<input id="new-image" name="new-image" type="file" />-->
                        <input type="submit" id='save-btn' value='"""), _display_( /*15.68*/ Messages("images.save-to-db")), format.raw /*15.97*/ ("""' disabled/>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="well">
                                """), _display_( /*22.34*/ b3 /*22.36*/ .text(
                saveImage("name"),
                '_label -> Messages("images.alt-name"),
                '_id -> "name"
              )), format.raw /*25.34*/ ("""
                                """), _display_( /*26.34*/ b3 /*26.36*/ .text(
                saveImage("content"),
                '_label -> Messages("Content"),
                '_id -> "content"
              )), format.raw /*29.34*/ ("""
                                """), format.raw /*30.33*/ ("""<!--<label for="name">"""), _display_( /*30.56*/ Messages("images.alt-name")), format.raw /*30.83*/ ("""</label>-->
                                <!--<input id="name" name="name" class="form-control form-control-inline"/>-->
                                <!--<label for="content">"""), _display_( /*32.59*/ Messages("Content")), format.raw /*32.78*/ ("""</label>-->
                                <!--<input id="content" name="content" class="form-control" />-->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="well form-inline">
                                """), _display_( /*40.34*/ defining(b3.inline.fieldConstructorSpecific) /*40.78*/ { implicit ifc =>
                _display_(Seq[Any](format.raw /*40.96*/ ("""
                                    """), _display_( /*41.38*/ b3 /*41.40*/ .number(
                  saveImage("height"),
                  '_label -> Messages("images.height"),
                  '_id -> "height"
                )), format.raw /*44.38*/ ("""
                                    """), _display_( /*45.38*/ b3 /*45.40*/ .number(
                  saveImage("width"),
                  '_label -> Messages("images.width"),
                  '_id -> "width"
                )), format.raw /*48.38*/ ("""
                                """)))
              }), format.raw /*49.34*/ ("""
                            """), format.raw /*50.29*/ ("""</div>
                        </div>
                    </div>
                </div>
            </div>
        <!--</form>-->
        """)))
            }), format.raw /*56.10*/ ("""
        """), format.raw /*57.9*/ ("""<hr/>
        """), _display_( /*58.10*/ b3 /*58.12*/ .inline.formCSRF(action = controllers.nuts.routes.Images.find) /*58.74*/ { implicit ifc =>
              _display_(Seq[Any](format.raw /*58.92*/ ("""
            """), _display_( /*59.14*/ b3 /*59.16*/ .text(findImages("search"), '_label -> "Search")), format.raw /*59.64*/ ("""
            """), _display_( /*60.14*/ defining(Seq("name" -> "name", "content" -> "content")) /*60.67*/ { fruits =>
                _display_(Seq[Any](format.raw /*60.78*/ ("""
                """), _display_( /*61.18*/ b3 /*61.20*/ .select(findImages("what"), options = fruits, '_label -> "Select")), format.raw /*61.88*/ ("""
            """)))
              }), format.raw /*62.14*/ ("""
            """), format.raw /*63.13*/ ("""<button type="submit">"""), _display_( /*63.36*/ Messages("Search")), format.raw /*63.54*/ ("""</button>
        """)))
            }), format.raw /*64.10*/ ("""
        """), _display_( /*65.10*/ if (imageInfoList.nonEmpty) /*65.36*/ {
              _display_(Seq[Any](format.raw /*65.37*/ ("""
            """), format.raw /*66.13*/ ("""<hr/>
            <form method="POST" action=""""), _display_( /*67.42*/ CSRF(controllers.nuts.routes.Images.edit)), format.raw /*67.83*/ ("""">
                <label for="rename">"""), _display_( /*68.38*/ Messages("images.rename-to")), format.raw /*68.66*/ ("""</label>
                <input id="rename" name="rename" />
                <select name="what" id="what">
                    <option>name</option>
                    <option>content</option>
                </select>
                <input type="submit" name="action" value='"""), _display_( /*74.60*/ Messages("images.rename")), format.raw /*74.85*/ ("""' class="btn btn-default"/>
                <input type="submit" name="action" value='"""), _display_( /*75.60*/ Messages("images.delete")), format.raw /*75.85*/ ("""' class="btn btn-default"/>
                <div class="row">
                    """), _display_( /*77.22*/ for (imageInfo <- imageInfoList) yield /*77.53*/ {
                _display_(Seq[Any](format.raw /*77.54*/ ("""
                        """), format.raw /*78.25*/ ("""<div class="image-info col-md-3">
                            <input type="radio" value='"""), _display_( /*79.57*/ { if (imageInfo.name.isEmpty) "" else imageInfo.name }), format.raw /*79.108*/ ("""' data-content=""""), _display_( /*79.125*/ imageInfo /*79.134*/ .content), format.raw /*79.142*/ ("""" name="imageChecked">
                            <span>"""), _display_( /*80.36*/ imageInfo /*80.45*/ .name), format.raw /*80.50*/ (""" """), format.raw /*80.51*/ ("""("""), _display_( /*80.53*/ imageInfo /*80.62*/ .content), format.raw /*80.70*/ (""")</span><br>
                            <a href="/img/"""), _display_( /*81.44*/ imageInfo /*81.53*/ .name), format.raw /*81.58*/ ("""">
                                <img src="/img/"""), _display_( /*82.49*/ imageInfo /*82.58*/ .name), format.raw /*82.63*/ ("""" class="img-responsive"/>
                            </a>
                        </div>
                    """)))
              }), format.raw /*85.22*/ ("""
                """), format.raw /*86.17*/ ("""</div>
            </form>
        """)))
            }), format.raw /*88.10*/ ("""
    """), format.raw /*89.5*/ ("""</div>
""")))
          }), format.raw /*90.2*/ ("""
"""), format.raw /*91.1*/ ("""<script src="/assets/javascripts/editImages.js"></script>


"""))
        }
      }
    }

    def render(user: models.User, imageInfoList: Seq[ImageInfo], saveImage: Form[SaveImage], findImages: Form[FindImages], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, imageInfoList, saveImage, findImages)(request, messages, webJarAssets)

    def f: ((models.User, Seq[ImageInfo], Form[SaveImage], Form[FindImages]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, imageInfoList, saveImage, findImages) => (request, messages, webJarAssets) => apply(user, imageInfoList, saveImage, findImages)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object editImages extends editImages_Scope0.editImages
/*
                  -- GENERATED --
                  DATE: Sun Feb 19 00:38:38 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/images/editImages.scala.html
                  HASH: 1ff14b7cf00c8833dc6f888c80833c357c45af16
                  MATRIX: 690->1|1045->190|1073->267|1123->309|1161->310|1192->315|1257->354|1267->356|1366->446|1406->448|1446->461|1594->582|1605->584|1728->685|1781->710|1836->738|1888->769|2079->933|2129->962|2424->1230|2435->1232|2644->1420|2705->1454|2716->1456|2923->1642|2984->1675|3034->1698|3082->1725|3290->1906|3330->1925|3738->2306|3791->2350|3847->2368|3912->2406|3923->2408|4148->2612|4213->2650|4224->2652|4446->2853|4511->2887|4568->2916|4738->3055|4774->3064|4816->3079|4827->3081|4898->3143|4954->3161|4995->3175|5006->3177|5075->3225|5116->3239|5178->3292|5227->3303|5272->3321|5283->3323|5372->3391|5417->3405|5458->3418|5508->3441|5547->3459|5597->3478|5634->3488|5669->3514|5708->3515|5749->3528|5823->3575|5885->3616|5952->3656|6001->3684|6308->3964|6354->3989|6468->4076|6514->4101|6624->4184|6671->4215|6710->4216|6763->4241|6880->4331|6953->4382|6998->4399|7017->4408|7047->4416|7132->4474|7150->4483|7176->4488|7205->4489|7234->4491|7252->4500|7281->4508|7364->4564|7382->4573|7408->4578|7486->4629|7504->4638|7530->4643|7673->4755|7718->4772|7785->4808|7817->4813|7855->4821|7883->4822
                  LINES: 22->1|29->1|31->6|31->6|31->6|32->7|33->8|33->8|33->8|33->8|34->9|37->12|37->12|37->12|38->13|38->13|38->13|40->15|40->15|47->22|47->22|50->25|51->26|51->26|54->29|55->30|55->30|55->30|57->32|57->32|65->40|65->40|65->40|66->41|66->41|69->44|70->45|70->45|73->48|74->49|75->50|81->56|82->57|83->58|83->58|83->58|83->58|84->59|84->59|84->59|85->60|85->60|85->60|86->61|86->61|86->61|87->62|88->63|88->63|88->63|89->64|90->65|90->65|90->65|91->66|92->67|92->67|93->68|93->68|99->74|99->74|100->75|100->75|102->77|102->77|102->77|103->78|104->79|104->79|104->79|104->79|104->79|105->80|105->80|105->80|105->80|105->80|105->80|105->80|106->81|106->81|106->81|107->82|107->82|107->82|110->85|111->86|113->88|114->89|115->90|116->91
                  -- GENERATED --
              */
