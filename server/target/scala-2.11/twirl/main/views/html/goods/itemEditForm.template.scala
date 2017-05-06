
package views.html.goods

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object itemEditForm_Scope0 {
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

class itemEditForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.User,Form[GoodsItem],Seq[Category],RequestHeader,Messages,WebJarAssets,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User, goodsItemForm: Form[GoodsItem], categories: Seq[Category])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper.CSRF
import b3.vertical.fieldConstructor

Seq[Any](format.raw/*1.161*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/admin(Messages("itemEdit.title"), Some(user))/*5.47*/{_display_(Seq[Any](format.raw/*5.48*/("""
    """),format.raw/*6.5*/("""<input type="file" id="filepickuper" style="display: none"/>
    <form id="item-edit-form" method="POST" action=""""),_display_(/*7.54*/CSRF(controllers.goods.routes.Goods.itemEditFormHandle)),format.raw/*7.109*/("""">
        <strong>ID #"""),_display_(/*8.22*/{goodsItemForm("id").value}),format.raw/*8.49*/("""</strong>
        <input type="hidden" id="id" name="id" value=""""),_display_(/*9.56*/{goodsItemForm("id").value}),format.raw/*9.83*/(""""/>
        <input type="hidden" id="description" name="description" />
        """),_display_(/*11.10*/b3/*11.12*/.select(goodsItemForm("category"),
            options = categories.map(c=>c.id.map(_.toString).getOrElse("")->c.name),
            '_label -> "Категория"
        )),format.raw/*14.10*/("""
        """),_display_(/*15.10*/b3/*15.12*/.text(goodsItemForm("title"), '_label -> "Наименование")),format.raw/*15.68*/("""
        """),format.raw/*16.9*/("""<div class="form-group">
            <label for="description-edit" class="control-label">Описание</label>
            <div id="description-edit" class="form-control">
                """),_display_(/*19.18*/{Html(goodsItemForm("description").value.getOrElse(""))}),format.raw/*19.74*/("""
            """),format.raw/*20.13*/("""</div>
        </div>
        """),_display_(/*22.10*/b3/*22.12*/.text(goodsItemForm("show-order"), '_label -> "Порядок сортировки")),format.raw/*22.79*/("""
        """),format.raw/*23.9*/("""<img id="image-displayed" src=""""),_display_(/*23.41*/controllers/*23.52*/.images.routes.Images.getThumbnail(goodsItemForm("image").value.getOrElse(""))),format.raw/*23.130*/("""">
        """),_display_(/*24.10*/b3/*24.12*/.text(goodsItemForm("image"), '_label -> "Картинка")),format.raw/*24.64*/("""
        """),format.raw/*25.9*/("""<button type="button" id="search-images-btn">Поиск фото</button>
        <div id="search-images" class="row"></div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <a href=""""),_display_(/*29.23*/CSRF(controllers.goods.routes.Goods.showItemEditForm(goodsItemForm("id").value.map(_.toLong)))),format.raw/*29.117*/(""""
                class="btn btn-success">Обновить</a>
            """),_display_(/*31.14*/if(goodsItemForm("id").value.isDefined)/*31.53*/{_display_(Seq[Any](format.raw/*31.54*/("""
                """),format.raw/*32.17*/("""<button type="submit" id="save-btn" name="action" value="save" class="btn btn-primary">Сохранить</button>
                <button type="submit" id="delete-btn" name="action" value="delete" class="btn btn-danger">Удалить</button>
            """)))}),format.raw/*34.14*/("""
            """),format.raw/*35.13*/("""<button type="submit" id="new-btn" name="action" value="new" class="btn btn-warning">Сохранить как новый сорт</button>
        </div>
    </form>

    <!-- Include the Quill library -->
    <link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
    <link href="/assets/styles/blogEdit.css" rel="stylesheet"/>
    <script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>
    <!--<script src="/assets/javascripts/blogEdit.js"></script>-->
    <script>
        // QuillJS editor. Will be initiated later.
        var quill;
        var Delta =  Quill.import('delta');

        /**
            Handle image insertion from database.
            First query `/img/list` for list of image available in database.
            Then, after data is received, create dialog (with jQuery) and append
            to it all the image references received from DB.
        */
        function image2Handler() """),format.raw/*55.34*/("""{"""),format.raw/*55.35*/("""
            """),format.raw/*56.13*/("""$.get('"""),_display_(/*56.21*/controllers/*56.32*/.images.routes.Images.jsonAllImageInfo),format.raw/*56.70*/("""', function(listOfImages, status)"""),format.raw/*56.103*/("""{"""),format.raw/*56.104*/("""
               """),format.raw/*57.16*/("""let imagesDialog = $('<div />', """),format.raw/*57.48*/("""{"""),format.raw/*57.49*/("""id: "imagesDialog", class: "row""""),format.raw/*57.81*/("""}"""),format.raw/*57.82*/(""").dialog("""),format.raw/*57.91*/("""{"""),format.raw/*57.92*/("""
                        """),format.raw/*58.25*/("""autoOpen: false,
                        modal:    true,
                        width:    $(window).width() - $(window).width() * 0.2,
                        height:   $(window).height() - $(window).height() * 0.2,
               """),format.raw/*62.16*/("""}"""),format.raw/*62.17*/(""");
               listOfImages.map((image) => """),format.raw/*63.44*/("""{"""),format.raw/*63.45*/("""
                    """),format.raw/*64.21*/("""//const imageHref = '/img/'+image.name;
                    const imageHref = '/img/150x150/'+image.name;
                    $('<img />', """),format.raw/*66.34*/("""{"""),format.raw/*66.35*/("""
                        """),format.raw/*67.25*/("""src:   imageHref,
                        alt:   image.content,
                        class: "col col-sm-2 image-responsive",
                        click: function()"""),format.raw/*70.42*/("""{"""),format.raw/*70.43*/("""
                            """),format.raw/*71.29*/("""quill.updateContents(
                                new Delta()
                                  .retain(quill.getSelection().index)
                                  .insert("""),format.raw/*74.43*/("""{"""),format.raw/*74.44*/("""
                                    """),format.raw/*75.37*/("""image: imageHref
                                  """),format.raw/*76.35*/("""}"""),format.raw/*76.36*/(""",
                                  """),format.raw/*77.35*/("""{"""),format.raw/*77.36*/("""
                                """),format.raw/*78.33*/("""// link: imageHref,
                                    alt: prompt('"""),_display_(/*79.51*/Messages("Enter image description")),format.raw/*79.86*/("""', image.content)
                                  """),format.raw/*80.35*/("""}"""),format.raw/*80.36*/("""));
                            imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                        """),format.raw/*82.25*/("""}"""),format.raw/*82.26*/("""
                   """),format.raw/*83.20*/("""}"""),format.raw/*83.21*/(""").appendTo(imagesDialog);
               """),format.raw/*84.16*/("""}"""),format.raw/*84.17*/(""");
               imagesDialog.dialog('open');
            """),format.raw/*86.13*/("""}"""),format.raw/*86.14*/(""");
        """),format.raw/*87.9*/("""}"""),format.raw/*87.10*/(""";

        /**
            Handle image insertion from filesystem as base64 data.
            Used as default image handler.
        */
        var filepickuper = document.getElementById("filepickuper");

        function insertImageInQuillJSAsBase64()"""),format.raw/*95.48*/("""{"""),format.raw/*95.49*/("""
            """),format.raw/*96.13*/("""let reader = new FileReader();
            reader.onloadend = function() """),format.raw/*97.43*/("""{"""),format.raw/*97.44*/("""
                """),format.raw/*98.17*/("""let alt = prompt('"""),_display_(/*98.36*/Messages("Enter image description")),format.raw/*98.71*/("""', file);
                let base64 = reader.result;
                quill.updateContents(
                new Delta()
                  .retain(quill.getSelection().index)
                  .insert("""),format.raw/*103.27*/("""{"""),format.raw/*103.28*/("""
                        """),format.raw/*104.25*/("""image: base64
                    """),format.raw/*105.21*/("""}"""),format.raw/*105.22*/(""",
                    """),format.raw/*106.21*/("""{"""),format.raw/*106.22*/("""
                """),format.raw/*107.17*/("""// link: imageHref,
                        alt: alt
                    """),format.raw/*109.21*/("""}"""),format.raw/*109.22*/(""")
                );
            """),format.raw/*111.13*/("""}"""),format.raw/*111.14*/(""";
            var file = filepickuper.files[0];
            reader.readAsDataURL(file);
        """),format.raw/*114.9*/("""}"""),format.raw/*114.10*/(""";

        function imageBase64Handler() """),format.raw/*116.39*/("""{"""),format.raw/*116.40*/("""
            """),format.raw/*117.13*/("""$('#filepickuper').trigger('click');
        """),format.raw/*118.9*/("""}"""),format.raw/*118.10*/(""";

        var deleteButtonPressed = false;

        ////
        $(document).ready(function()"""),format.raw/*123.37*/("""{"""),format.raw/*123.38*/("""
            """),format.raw/*124.13*/("""// Init QuillJS.com editor
            const toolbarOptions = [
                ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                ['blockquote', 'code-block'],

                ["""),format.raw/*129.18*/("""{"""),format.raw/*129.19*/(""" """),format.raw/*129.20*/("""'header': 1 """),format.raw/*129.32*/("""}"""),format.raw/*129.33*/(""", """),format.raw/*129.35*/("""{"""),format.raw/*129.36*/(""" """),format.raw/*129.37*/("""'header': 2 """),format.raw/*129.49*/("""}"""),format.raw/*129.50*/("""],               // custom button values
                ["""),format.raw/*130.18*/("""{"""),format.raw/*130.19*/(""" """),format.raw/*130.20*/("""'list': 'ordered'"""),format.raw/*130.37*/("""}"""),format.raw/*130.38*/(""", """),format.raw/*130.40*/("""{"""),format.raw/*130.41*/(""" """),format.raw/*130.42*/("""'list': 'bullet' """),format.raw/*130.59*/("""}"""),format.raw/*130.60*/("""],
                ["""),format.raw/*131.18*/("""{"""),format.raw/*131.19*/(""" """),format.raw/*131.20*/("""'script': 'sub'"""),format.raw/*131.35*/("""}"""),format.raw/*131.36*/(""", """),format.raw/*131.38*/("""{"""),format.raw/*131.39*/(""" """),format.raw/*131.40*/("""'script': 'super' """),format.raw/*131.58*/("""}"""),format.raw/*131.59*/("""],      // superscript/subscript
                ["""),format.raw/*132.18*/("""{"""),format.raw/*132.19*/(""" """),format.raw/*132.20*/("""'indent': '-1'"""),format.raw/*132.34*/("""}"""),format.raw/*132.35*/(""", """),format.raw/*132.37*/("""{"""),format.raw/*132.38*/(""" """),format.raw/*132.39*/("""'indent': '+1' """),format.raw/*132.54*/("""}"""),format.raw/*132.55*/("""],          // outdent/indent
                ["""),format.raw/*133.18*/("""{"""),format.raw/*133.19*/(""" """),format.raw/*133.20*/("""'direction': 'rtl' """),format.raw/*133.39*/("""}"""),format.raw/*133.40*/("""],                         // text direction

                ["""),format.raw/*135.18*/("""{"""),format.raw/*135.19*/(""" """),format.raw/*135.20*/("""'size': ['small', false, 'large', 'huge'] """),format.raw/*135.62*/("""}"""),format.raw/*135.63*/("""],  // custom dropdown
                ["""),format.raw/*136.18*/("""{"""),format.raw/*136.19*/(""" """),format.raw/*136.20*/("""'header': [1, 2, 3, 4, 5, 6, false] """),format.raw/*136.56*/("""}"""),format.raw/*136.57*/("""],
                [ 'link', 'image', 'image2', 'video', 'formula' ],          // add's image support
                ["""),format.raw/*138.18*/("""{"""),format.raw/*138.19*/(""" """),format.raw/*138.20*/("""'color': [] """),format.raw/*138.32*/("""}"""),format.raw/*138.33*/(""", """),format.raw/*138.35*/("""{"""),format.raw/*138.36*/(""" """),format.raw/*138.37*/("""'background': [] """),format.raw/*138.54*/("""}"""),format.raw/*138.55*/("""],          // dropdown with defaults from theme
                ["""),format.raw/*139.18*/("""{"""),format.raw/*139.19*/(""" """),format.raw/*139.20*/("""'font': [] """),format.raw/*139.31*/("""}"""),format.raw/*139.32*/("""],
                ["""),format.raw/*140.18*/("""{"""),format.raw/*140.19*/(""" """),format.raw/*140.20*/("""'align': [] """),format.raw/*140.32*/("""}"""),format.raw/*140.33*/("""],

                ['clean']                                         // remove formatting button
            ];
            quill = new Quill('#description-edit', """),format.raw/*144.52*/("""{"""),format.raw/*144.53*/("""
                """),format.raw/*145.17*/("""modules: """),format.raw/*145.26*/("""{"""),format.raw/*145.27*/("""
                    """),format.raw/*146.21*/("""toolbar: """),format.raw/*146.30*/("""{"""),format.raw/*146.31*/("""
                      """),format.raw/*147.23*/("""container: toolbarOptions,
                      handlers: """),format.raw/*148.33*/("""{"""),format.raw/*148.34*/("""
                        """),format.raw/*149.25*/("""image: imageBase64Handler,
                        image2: image2Handler
                      """),format.raw/*151.23*/("""}"""),format.raw/*151.24*/("""
                    """),format.raw/*152.21*/("""}"""),format.raw/*152.22*/("""
                """),format.raw/*153.17*/("""}"""),format.raw/*153.18*/(""",
                theme: 'snow'
            """),format.raw/*155.13*/("""}"""),format.raw/*155.14*/(""");

            $('#filepickuper').change(insertImageInQuillJSAsBase64);

            $('#item-edit-form').on('submit', function()"""),format.raw/*159.57*/("""{"""),format.raw/*159.58*/("""
                """),format.raw/*160.17*/("""document.getElementById('description').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                if( deleteButtonPressed )"""),format.raw/*161.42*/("""{"""),format.raw/*161.43*/("""
                    """),format.raw/*162.21*/("""var id = document.getElementById('id').value;
                    deleteButtonPressed = false;
                    return confirm('Delete item #'+id);
                """),format.raw/*165.17*/("""}"""),format.raw/*165.18*/(""" """),format.raw/*165.19*/("""else """),format.raw/*165.24*/("""{"""),format.raw/*165.25*/("""
                    """),format.raw/*166.21*/("""return true;
                """),format.raw/*167.17*/("""}"""),format.raw/*167.18*/("""
            """),format.raw/*168.13*/("""}"""),format.raw/*168.14*/(""");

            if(document.getElementById("delete-btn"))"""),format.raw/*170.54*/("""{"""),format.raw/*170.55*/("""
                """),format.raw/*171.17*/("""document.getElementById("delete-btn").addEventListener('click', (event) => """),format.raw/*171.92*/("""{"""),format.raw/*171.93*/("""
                    """),format.raw/*172.21*/("""deleteButtonPressed = true;
                """),format.raw/*173.17*/("""}"""),format.raw/*173.18*/(""");
            """),format.raw/*174.13*/("""}"""),format.raw/*174.14*/(""";

            // SEARCH IMAGES
            $('#search-images-btn').click(function() """),format.raw/*177.54*/("""{"""),format.raw/*177.55*/("""
                """),format.raw/*178.17*/("""$.get('"""),_display_(/*178.25*/controllers/*178.36*/.images.routes.Images.jsonAllImageInfo),format.raw/*178.74*/("""', function(listOfImages, status)"""),format.raw/*178.107*/("""{"""),format.raw/*178.108*/("""
                   """),format.raw/*179.20*/("""var searchImagesDiv = $('#search-images');
                   listOfImages.map((image) => """),format.raw/*180.48*/("""{"""),format.raw/*180.49*/("""
                        """),format.raw/*181.25*/("""const imageHref = '/img/150x150/'+image.name;
                        const img = $('<img />', """),format.raw/*182.50*/("""{"""),format.raw/*182.51*/("""
                            """),format.raw/*183.29*/("""src:   imageHref,
                            alt:   image.content,
                            click: function()"""),format.raw/*185.46*/("""{"""),format.raw/*185.47*/("""
                                """),format.raw/*186.33*/("""$('#image').val(image.name);
                                $('#image-displayed').attr('src', imageHref);
                                $('#search-images').empty();
                            """),format.raw/*189.29*/("""}"""),format.raw/*189.30*/("""
                        """),format.raw/*190.25*/("""}"""),format.raw/*190.26*/(""");
                        const div = $('<div />', """),format.raw/*191.50*/("""{"""),format.raw/*191.51*/("""
                            """),format.raw/*192.29*/("""class: "col col-sm-2",
                        """),format.raw/*193.25*/("""}"""),format.raw/*193.26*/(""");
                        div.append(img).append(
                            $('<span />', """),format.raw/*195.43*/("""{"""),format.raw/*195.44*/(""" """),format.raw/*195.45*/("""text: image.content.slice(0, 22)"""),format.raw/*195.77*/("""}"""),format.raw/*195.78*/(""")
                        ).appendTo(searchImagesDiv);
                    """),format.raw/*197.21*/("""}"""),format.raw/*197.22*/(""");
                """),format.raw/*198.17*/("""}"""),format.raw/*198.18*/(""");
            """),format.raw/*199.13*/("""}"""),format.raw/*199.14*/(""");



        """),format.raw/*203.9*/("""}"""),format.raw/*203.10*/(""");
    </script>
    <style>
    #description-edit"""),format.raw/*206.22*/("""{"""),format.raw/*206.23*/("""
        """),format.raw/*207.9*/("""min-height: 500px;
        max-height: 400px;
        overflow: hidden;
        overflow-y: scroll;
        overflow-x: scroll;
    """),format.raw/*212.5*/("""}"""),format.raw/*212.6*/("""

    """),format.raw/*214.5*/(""".ql-image2:after """),format.raw/*214.22*/("""{"""),format.raw/*214.23*/("""
        """),format.raw/*215.9*/("""content: "Ω";
    """),format.raw/*216.5*/("""}"""),format.raw/*216.6*/("""
    """),format.raw/*217.5*/("""</style>
""")))}),format.raw/*218.2*/("""
"""))
      }
    }
  }

  def render(user:models.User,goodsItemForm:Form[GoodsItem],categories:Seq[Category],request:RequestHeader,messages:Messages,webJarAssets:WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user,goodsItemForm,categories)(request,messages,webJarAssets)

  def f:((models.User,Form[GoodsItem],Seq[Category]) => (RequestHeader,Messages,WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user,goodsItemForm,categories) => (request,messages,webJarAssets) => apply(user,goodsItemForm,categories)(request,messages,webJarAssets)

  def ref: this.type = this

}


}

/**/
object itemEditForm extends itemEditForm_Scope0.itemEditForm
              /*
                  -- GENERATED --
                  DATE: Sun May 07 01:06:03 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/itemEditForm.scala.html
                  HASH: 932a247d4ea9127df21f46a46896fa828ec1317b
                  MATRIX: 795->1|1104->160|1131->218|1158->220|1211->265|1249->266|1280->271|1420->385|1496->440|1546->464|1593->491|1684->556|1731->583|1839->664|1850->666|2035->830|2072->840|2083->842|2160->898|2196->907|2407->1091|2484->1147|2525->1160|2583->1191|2594->1193|2682->1260|2718->1269|2777->1301|2797->1312|2897->1390|2936->1402|2947->1404|3020->1456|3056->1465|3289->1671|3405->1765|3500->1833|3548->1872|3587->1873|3632->1890|3905->2132|3946->2145|4893->3064|4922->3065|4963->3078|4998->3086|5018->3097|5077->3135|5139->3168|5169->3169|5213->3185|5273->3217|5302->3218|5362->3250|5391->3251|5428->3260|5457->3261|5510->3286|5770->3518|5799->3519|5873->3565|5902->3566|5951->3587|6118->3726|6147->3727|6200->3752|6397->3921|6426->3922|6483->3951|6689->4129|6718->4130|6783->4167|6862->4218|6891->4219|6955->4255|6984->4256|7045->4289|7142->4359|7198->4394|7278->4446|7307->4447|7546->4658|7575->4659|7623->4679|7652->4680|7721->4721|7750->4722|7837->4781|7866->4782|7904->4793|7933->4794|8213->5046|8242->5047|8283->5060|8384->5133|8413->5134|8458->5151|8504->5170|8560->5205|8789->5405|8819->5406|8873->5431|8936->5465|8966->5466|9017->5488|9047->5489|9093->5506|9195->5579|9225->5580|9287->5613|9317->5614|9441->5710|9471->5711|9541->5752|9571->5753|9613->5766|9686->5811|9716->5812|9839->5906|9869->5907|9911->5920|10153->6133|10183->6134|10213->6135|10254->6147|10284->6148|10315->6150|10345->6151|10375->6152|10416->6164|10446->6165|10533->6223|10563->6224|10593->6225|10639->6242|10669->6243|10700->6245|10730->6246|10760->6247|10806->6264|10836->6265|10885->6285|10915->6286|10945->6287|10989->6302|11019->6303|11050->6305|11080->6306|11110->6307|11157->6325|11187->6326|11266->6376|11296->6377|11326->6378|11369->6392|11399->6393|11430->6395|11460->6396|11490->6397|11534->6412|11564->6413|11640->6460|11670->6461|11700->6462|11748->6481|11778->6482|11870->6545|11900->6546|11930->6547|12001->6589|12031->6590|12100->6630|12130->6631|12160->6632|12225->6668|12255->6669|12403->6788|12433->6789|12463->6790|12504->6802|12534->6803|12565->6805|12595->6806|12625->6807|12671->6824|12701->6825|12796->6891|12826->6892|12856->6893|12896->6904|12926->6905|12975->6925|13005->6926|13035->6927|13076->6939|13106->6940|13299->7104|13329->7105|13375->7122|13413->7131|13443->7132|13493->7153|13531->7162|13561->7163|13613->7186|13701->7245|13731->7246|13785->7271|13909->7366|13939->7367|13989->7388|14019->7389|14065->7406|14095->7407|14168->7451|14198->7452|14357->7582|14387->7583|14433->7600|14609->7747|14639->7748|14689->7769|14885->7936|14915->7937|14945->7938|14979->7943|15009->7944|15059->7965|15117->7994|15147->7995|15189->8008|15219->8009|15305->8066|15335->8067|15381->8084|15485->8159|15515->8160|15565->8181|15638->8225|15668->8226|15712->8241|15742->8242|15856->8327|15886->8328|15932->8345|15968->8353|15989->8364|16049->8402|16112->8435|16143->8436|16192->8456|16311->8546|16341->8547|16395->8572|16519->8667|16549->8668|16607->8697|16749->8810|16779->8811|16841->8844|17066->9040|17096->9041|17150->9066|17180->9067|17261->9119|17291->9120|17349->9149|17425->9196|17455->9197|17577->9290|17607->9291|17637->9292|17698->9324|17728->9325|17832->9400|17862->9401|17910->9420|17940->9421|17984->9436|18014->9437|18056->9451|18086->9452|18165->9502|18195->9503|18232->9512|18392->9644|18421->9645|18455->9651|18501->9668|18531->9669|18568->9678|18614->9696|18643->9697|18676->9702|18717->9712
                  LINES: 26->1|32->1|33->4|34->5|34->5|34->5|35->6|36->7|36->7|37->8|37->8|38->9|38->9|40->11|40->11|43->14|44->15|44->15|44->15|45->16|48->19|48->19|49->20|51->22|51->22|51->22|52->23|52->23|52->23|52->23|53->24|53->24|53->24|54->25|58->29|58->29|60->31|60->31|60->31|61->32|63->34|64->35|84->55|84->55|85->56|85->56|85->56|85->56|85->56|85->56|86->57|86->57|86->57|86->57|86->57|86->57|86->57|87->58|91->62|91->62|92->63|92->63|93->64|95->66|95->66|96->67|99->70|99->70|100->71|103->74|103->74|104->75|105->76|105->76|106->77|106->77|107->78|108->79|108->79|109->80|109->80|111->82|111->82|112->83|112->83|113->84|113->84|115->86|115->86|116->87|116->87|124->95|124->95|125->96|126->97|126->97|127->98|127->98|127->98|132->103|132->103|133->104|134->105|134->105|135->106|135->106|136->107|138->109|138->109|140->111|140->111|143->114|143->114|145->116|145->116|146->117|147->118|147->118|152->123|152->123|153->124|158->129|158->129|158->129|158->129|158->129|158->129|158->129|158->129|158->129|158->129|159->130|159->130|159->130|159->130|159->130|159->130|159->130|159->130|159->130|159->130|160->131|160->131|160->131|160->131|160->131|160->131|160->131|160->131|160->131|160->131|161->132|161->132|161->132|161->132|161->132|161->132|161->132|161->132|161->132|161->132|162->133|162->133|162->133|162->133|162->133|164->135|164->135|164->135|164->135|164->135|165->136|165->136|165->136|165->136|165->136|167->138|167->138|167->138|167->138|167->138|167->138|167->138|167->138|167->138|167->138|168->139|168->139|168->139|168->139|168->139|169->140|169->140|169->140|169->140|169->140|173->144|173->144|174->145|174->145|174->145|175->146|175->146|175->146|176->147|177->148|177->148|178->149|180->151|180->151|181->152|181->152|182->153|182->153|184->155|184->155|188->159|188->159|189->160|190->161|190->161|191->162|194->165|194->165|194->165|194->165|194->165|195->166|196->167|196->167|197->168|197->168|199->170|199->170|200->171|200->171|200->171|201->172|202->173|202->173|203->174|203->174|206->177|206->177|207->178|207->178|207->178|207->178|207->178|207->178|208->179|209->180|209->180|210->181|211->182|211->182|212->183|214->185|214->185|215->186|218->189|218->189|219->190|219->190|220->191|220->191|221->192|222->193|222->193|224->195|224->195|224->195|224->195|224->195|226->197|226->197|227->198|227->198|228->199|228->199|232->203|232->203|235->206|235->206|236->207|241->212|241->212|243->214|243->214|243->214|244->215|245->216|245->216|246->217|247->218
                  -- GENERATED --
              */
          