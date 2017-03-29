
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
  import models.nuts.Data._
  import models.nuts.FormsData._

  class itemEditForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.User, Form[GoodsItem], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, item: Form[GoodsItem], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*1.180*/ ("""
"""), format.raw /*3.1*/ ("""
"""), _display_( /*4.2*/ admin(Messages("itemEdit.title"), Some(user)) /*4.47*/ {
            _display_(Seq[Any](format.raw /*4.48*/ ("""
    """), _display_( /*5.6*/ {
              if (item.hasErrors) {
                item.errors.map {
                  case play.api.data.FormError(key, errorMsgs, _) =>
                    <div class="col-md-10 col-md-offset-2 alert alert-danger">
                      <a href="#" class="close" data-dismiss="alert">&times;</a>
                      <strong>{ Messages("error") } { Messages(key) } => { errorMsgs.mkString("; ") }</strong>
                    </div>
                }
              }
            }), format.raw /*12.7*/ ("""
    """), format.raw /*13.5*/ ("""<input type="file" id="filepicker" style="display: none"/>
    <form id="item-edit-form" method="POST" action=""""), _display_( /*14.54*/ CSRF(controllers.nuts.routes.Goods.updateOrCreateOrDelete)), format.raw /*14.112*/ ("""">
        <strong>ID #"""), _display_( /*15.22*/ { item("id").value }), format.raw /*15.40*/ ("""</strong>
        <input type="hidden" id="id" name="id" value=""""), _display_( /*16.56*/ { item("id").value }), format.raw /*16.74*/ (""""/>
        <input type="hidden" id="description" name="description" />
        <!--<input type="hidden" id="action" name="action" />-->
        <div class="form-group">
            <label for="category" class="control-label">"""), _display_( /*20.58*/ Messages("Category")), format.raw /*20.78*/ ("""</label>
            <input type="text" id="category" name="category" value='"""), _display_( /*21.70*/ { item("category").value }), format.raw /*21.94*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="description-edit" class="control-label">"""), _display_( /*25.66*/ Messages("description")), format.raw /*25.89*/ ("""</label>
            <div id="description-edit" class="form-control" rows="11">
                """), _display_( /*27.18*/ { Html(item("description").value.getOrElse("")) }), format.raw /*27.65*/ ("""
            """), format.raw /*28.13*/ ("""</div>
        </div>
        <div class="form-group">
            <label for="title" class="control-label">"""), _display_( /*31.55*/ Messages("title")), format.raw /*31.72*/ ("""</label>
            <input type="text" id="title" name="title" value='"""), _display_( /*32.64*/ { item("title").value }), format.raw /*32.85*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="show-order" class="control-label">"""), _display_( /*36.60*/ Messages("show-order")), format.raw /*36.82*/ ("""</label>
            <input type="text" id="show-order" name="show-order" value='"""), _display_( /*37.74*/ { item("show-order").value }), format.raw /*37.100*/ ("""'
                   class="form-control"/>
        </div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <button type="submit" id="new-btn" name="action" value="new" class="btn btn-warning">"""), _display_( /*42.99*/ Messages("Save as new")), format.raw /*42.122*/ ("""</button>
            """), _display_( /*43.14*/ if (item("id").value.isDefined) /*43.44*/ {
              _display_(Seq[Any](format.raw /*43.45*/ ("""
                """), format.raw /*44.17*/ ("""<button type="submit" id="save-btn" name="action" value="save" class="btn btn-primary">"""), _display_( /*44.105*/ Messages("Update")), format.raw /*44.123*/ ("""</button>
                <button type="submit" id="delete-btn" name="action" value="delete" class="btn btn-danger">"""), _display_( /*45.108*/ Messages("Delete")), format.raw /*45.126*/ ("""</button>
            """)))
            }), format.raw /*46.14*/ ("""
        """), format.raw /*47.9*/ ("""</div>
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
        function image2Handler() """), format.raw /*66.34*/ ("""{"""), format.raw /*66.35*/ ("""
            """), format.raw /*67.13*/ ("""$.get('"""), _display_( /*67.21*/ controllers /*67.32*/ .nuts.routes.Images.list), format.raw /*67.56*/ ("""', function(listOfImages, status)"""), format.raw /*67.89*/ ("""{"""), format.raw /*67.90*/ ("""
               """), format.raw /*68.16*/ ("""let imagesDialog = $('<div />', """), format.raw /*68.48*/ ("""{"""), format.raw /*68.49*/ ("""id: "imagesDialog", class: "row""""), format.raw /*68.81*/ ("""}"""), format.raw /*68.82*/ (""").dialog("""), format.raw /*68.91*/ ("""{"""), format.raw /*68.92*/ ("""
                        """), format.raw /*69.25*/ ("""autoOpen: false,
                        modal:    true,
                        width:    $(window).width() - $(window).width() * 0.2,
                        height:   $(window).height() - $(window).height() * 0.2,
               """), format.raw /*73.16*/ ("""}"""), format.raw /*73.17*/ (""");
               listOfImages.map((image) => """), format.raw /*74.44*/ ("""{"""), format.raw /*74.45*/ ("""
                    """), format.raw /*75.21*/ ("""const imageHref = '/img/'+image.name;
                    $('<img />', """), format.raw /*76.34*/ ("""{"""), format.raw /*76.35*/ ("""
                        """), format.raw /*77.25*/ ("""src:   imageHref,
                        alt:   image.content,
                        class: "col col-sm-2",
                        click: function()"""), format.raw /*80.42*/ ("""{"""), format.raw /*80.43*/ ("""
                            """), format.raw /*81.29*/ ("""quill.updateContents(
                                new Delta()
                                  .retain(quill.getSelection().index)
                                  .insert("""), format.raw /*84.43*/ ("""{"""), format.raw /*84.44*/ ("""
                                    """), format.raw /*85.37*/ ("""image: imageHref
                                  """), format.raw /*86.35*/ ("""}"""), format.raw /*86.36*/ (""",
                                  """), format.raw /*87.35*/ ("""{"""), format.raw /*87.36*/ ("""
                                """), format.raw /*88.33*/ ("""// link: imageHref,
                                    alt: prompt('"""), _display_( /*89.51*/ Messages("Enter image description")), format.raw /*89.86*/ ("""', image.content)
                                  """), format.raw /*90.35*/ ("""}"""), format.raw /*90.36*/ ("""));
                            imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                        """), format.raw /*92.25*/ ("""}"""), format.raw /*92.26*/ ("""
                   """), format.raw /*93.20*/ ("""}"""), format.raw /*93.21*/ (""").appendTo(imagesDialog);
               """), format.raw /*94.16*/ ("""}"""), format.raw /*94.17*/ (""");
               imagesDialog.dialog('open');
            """), format.raw /*96.13*/ ("""}"""), format.raw /*96.14*/ (""");
        """), format.raw /*97.9*/ ("""}"""), format.raw /*97.10*/ (""";

        /**
            Handle image insertion from filesystem as base64 data.
            Used as default image handler.
        */
        let filepicker = document.getElementById("filepicker");

        function insertImageInQuillJSAsBase64()"""), format.raw /*105.48*/ ("""{"""), format.raw /*105.49*/ ("""
            """), format.raw /*106.13*/ ("""let reader = new FileReader();
            reader.onloadend = function() """), format.raw /*107.43*/ ("""{"""), format.raw /*107.44*/ ("""
                """), format.raw /*108.17*/ ("""let alt = prompt('"""), _display_( /*108.36*/ Messages("Enter image description")), format.raw /*108.71*/ ("""', file);
                let base64 = reader.result;
                quill.updateContents(
                new Delta()
                  .retain(quill.getSelection().index)
                  .insert("""), format.raw /*113.27*/ ("""{"""), format.raw /*113.28*/ ("""
                        """), format.raw /*114.25*/ ("""image: base64
                    """), format.raw /*115.21*/ ("""}"""), format.raw /*115.22*/ (""",
                    """), format.raw /*116.21*/ ("""{"""), format.raw /*116.22*/ ("""
                """), format.raw /*117.17*/ ("""// link: imageHref,
                        alt: alt
                    """), format.raw /*119.21*/ ("""}"""), format.raw /*119.22*/ (""")
                );
            """), format.raw /*121.13*/ ("""}"""), format.raw /*121.14*/ (""";
            let file = filepicker.files[0];
            reader.readAsDataURL(file);
        """), format.raw /*124.9*/ ("""}"""), format.raw /*124.10*/ (""";

        function imageBase64Handler() """), format.raw /*126.39*/ ("""{"""), format.raw /*126.40*/ ("""
            """), format.raw /*127.13*/ ("""$('#filepicker').trigger('click');
        """), format.raw /*128.9*/ ("""}"""), format.raw /*128.10*/ (""";

        var deleteButtonPressed = false;

        $(document).ready(function()"""), format.raw /*132.37*/ ("""{"""), format.raw /*132.38*/ ("""
            """), format.raw /*133.13*/ ("""// Init QuillJS.com editor
            const toolbarOptions = [
                ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                ['blockquote', 'code-block'],

                ["""), format.raw /*138.18*/ ("""{"""), format.raw /*138.19*/ (""" """), format.raw /*138.20*/ ("""'header': 1 """), format.raw /*138.32*/ ("""}"""), format.raw /*138.33*/ (""", """), format.raw /*138.35*/ ("""{"""), format.raw /*138.36*/ (""" """), format.raw /*138.37*/ ("""'header': 2 """), format.raw /*138.49*/ ("""}"""), format.raw /*138.50*/ ("""],               // custom button values
                ["""), format.raw /*139.18*/ ("""{"""), format.raw /*139.19*/ (""" """), format.raw /*139.20*/ ("""'list': 'ordered'"""), format.raw /*139.37*/ ("""}"""), format.raw /*139.38*/ (""", """), format.raw /*139.40*/ ("""{"""), format.raw /*139.41*/ (""" """), format.raw /*139.42*/ ("""'list': 'bullet' """), format.raw /*139.59*/ ("""}"""), format.raw /*139.60*/ ("""],
                ["""), format.raw /*140.18*/ ("""{"""), format.raw /*140.19*/ (""" """), format.raw /*140.20*/ ("""'script': 'sub'"""), format.raw /*140.35*/ ("""}"""), format.raw /*140.36*/ (""", """), format.raw /*140.38*/ ("""{"""), format.raw /*140.39*/ (""" """), format.raw /*140.40*/ ("""'script': 'super' """), format.raw /*140.58*/ ("""}"""), format.raw /*140.59*/ ("""],      // superscript/subscript
                ["""), format.raw /*141.18*/ ("""{"""), format.raw /*141.19*/ (""" """), format.raw /*141.20*/ ("""'indent': '-1'"""), format.raw /*141.34*/ ("""}"""), format.raw /*141.35*/ (""", """), format.raw /*141.37*/ ("""{"""), format.raw /*141.38*/ (""" """), format.raw /*141.39*/ ("""'indent': '+1' """), format.raw /*141.54*/ ("""}"""), format.raw /*141.55*/ ("""],          // outdent/indent
                ["""), format.raw /*142.18*/ ("""{"""), format.raw /*142.19*/ (""" """), format.raw /*142.20*/ ("""'direction': 'rtl' """), format.raw /*142.39*/ ("""}"""), format.raw /*142.40*/ ("""],                         // text direction

                ["""), format.raw /*144.18*/ ("""{"""), format.raw /*144.19*/ (""" """), format.raw /*144.20*/ ("""'size': ['small', false, 'large', 'huge'] """), format.raw /*144.62*/ ("""}"""), format.raw /*144.63*/ ("""],  // custom dropdown
                ["""), format.raw /*145.18*/ ("""{"""), format.raw /*145.19*/ (""" """), format.raw /*145.20*/ ("""'header': [1, 2, 3, 4, 5, 6, false] """), format.raw /*145.56*/ ("""}"""), format.raw /*145.57*/ ("""],
                [ 'link', 'image', 'image2', 'video', 'formula' ],          // add's image support
                ["""), format.raw /*147.18*/ ("""{"""), format.raw /*147.19*/ (""" """), format.raw /*147.20*/ ("""'color': [] """), format.raw /*147.32*/ ("""}"""), format.raw /*147.33*/ (""", """), format.raw /*147.35*/ ("""{"""), format.raw /*147.36*/ (""" """), format.raw /*147.37*/ ("""'background': [] """), format.raw /*147.54*/ ("""}"""), format.raw /*147.55*/ ("""],          // dropdown with defaults from theme
                ["""), format.raw /*148.18*/ ("""{"""), format.raw /*148.19*/ (""" """), format.raw /*148.20*/ ("""'font': [] """), format.raw /*148.31*/ ("""}"""), format.raw /*148.32*/ ("""],
                ["""), format.raw /*149.18*/ ("""{"""), format.raw /*149.19*/ (""" """), format.raw /*149.20*/ ("""'align': [] """), format.raw /*149.32*/ ("""}"""), format.raw /*149.33*/ ("""],

                ['clean']                                         // remove formatting button
            ];
            quill = new Quill('#description-edit', """), format.raw /*153.52*/ ("""{"""), format.raw /*153.53*/ ("""
                """), format.raw /*154.17*/ ("""modules: """), format.raw /*154.26*/ ("""{"""), format.raw /*154.27*/ ("""
                    """), format.raw /*155.21*/ ("""toolbar: """), format.raw /*155.30*/ ("""{"""), format.raw /*155.31*/ ("""
                      """), format.raw /*156.23*/ ("""container: toolbarOptions,
                      handlers: """), format.raw /*157.33*/ ("""{"""), format.raw /*157.34*/ ("""
                        """), format.raw /*158.25*/ ("""image: imageBase64Handler,
                        image2: image2Handler
                      """), format.raw /*160.23*/ ("""}"""), format.raw /*160.24*/ ("""
                    """), format.raw /*161.21*/ ("""}"""), format.raw /*161.22*/ ("""
                """), format.raw /*162.17*/ ("""}"""), format.raw /*162.18*/ (""",
                theme: 'snow'
            """), format.raw /*164.13*/ ("""}"""), format.raw /*164.14*/ (""");

            $('#filepicker').change(insertImageInQuillJSAsBase64);

            $('#item-edit-form').on('submit', function()"""), format.raw /*168.57*/ ("""{"""), format.raw /*168.58*/ ("""
                """), format.raw /*169.17*/ ("""document.getElementById('description').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                if( deleteButtonPressed )"""), format.raw /*170.42*/ ("""{"""), format.raw /*170.43*/ ("""
                    """), format.raw /*171.21*/ ("""let id = document.getElementById('id').value;
                    deleteButtonPressed = false;
                    return confirm('Delete item #'+id);
                """), format.raw /*174.17*/ ("""}"""), format.raw /*174.18*/ (""" """), format.raw /*174.19*/ ("""else """), format.raw /*174.24*/ ("""{"""), format.raw /*174.25*/ ("""
                    """), format.raw /*175.21*/ ("""return true;
                """), format.raw /*176.17*/ ("""}"""), format.raw /*176.18*/ ("""
            """), format.raw /*177.13*/ ("""}"""), format.raw /*177.14*/ (""");

            if(document.getElementById("delete-btn"))"""), format.raw /*179.54*/ ("""{"""), format.raw /*179.55*/ ("""
                """), format.raw /*180.17*/ ("""document.getElementById("delete-btn").addEventListener('click', (event) => """), format.raw /*180.92*/ ("""{"""), format.raw /*180.93*/ ("""
                    """), format.raw /*181.21*/ ("""deleteButtonPressed = true;
                """), format.raw /*182.17*/ ("""}"""), format.raw /*182.18*/ (""");
            """), format.raw /*183.13*/ ("""}"""), format.raw /*183.14*/ (""";


        """), format.raw /*186.9*/ ("""}"""), format.raw /*186.10*/ (""");
    </script>
    <style>
    #description-edit"""), format.raw /*189.22*/ ("""{"""), format.raw /*189.23*/ ("""
        """), format.raw /*190.9*/ ("""min-height: 500px;
        max-height: 400px;
        overflow: hidden;
        overflow-y: scroll;
        overflow-x: scroll;
    """), format.raw /*195.5*/ ("""}"""), format.raw /*195.6*/ ("""

    """), format.raw /*197.5*/ (""".ql-image2:after """), format.raw /*197.22*/ ("""{"""), format.raw /*197.23*/ ("""
        """), format.raw /*198.9*/ ("""content: "Ω";
    """), format.raw /*199.5*/ ("""}"""), format.raw /*199.6*/ ("""
    """), format.raw /*200.5*/ ("""</style>
""")))
          }), format.raw /*201.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, item: Form[GoodsItem], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, item, errors)(request, messages, webJarAssets)

    def f: ((models.User, Form[GoodsItem], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, item, errors) => (request, messages, webJarAssets) => apply(user, item, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object itemEditForm extends itemEditForm_Scope0.itemEditForm
/*
                  -- GENERATED --
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/goods/itemEditForm.scala.html
                  HASH: b159ddd96119b7fec924a27dd80ea380b931f485
                  MATRIX: 681->1|973->179|1000->200|1027->202|1080->247|1118->248|1149->254|1545->630|1577->635|1716->747|1796->805|1847->829|1886->847|1978->912|2017->930|2271->1157|2312->1177|2417->1255|2462->1279|2646->1436|2690->1459|2814->1556|2882->1603|2923->1616|3059->1725|3097->1742|3196->1814|3238->1835|3416->1986|3459->2008|3568->2090|3616->2116|3868->2341|3913->2364|3963->2387|4002->2417|4041->2418|4086->2435|4202->2523|4242->2541|4387->2658|4427->2676|4481->2699|4517->2708|5337->3500|5366->3501|5407->3514|5442->3522|5462->3533|5507->3557|5568->3590|5597->3591|5641->3607|5701->3639|5730->3640|5790->3672|5819->3673|5856->3682|5885->3683|5938->3708|6198->3940|6227->3941|6301->3987|6330->3988|6379->4009|6478->4080|6507->4081|6560->4106|6740->4258|6769->4259|6826->4288|7032->4466|7061->4467|7126->4504|7205->4555|7234->4556|7298->4592|7327->4593|7388->4626|7485->4696|7541->4731|7621->4783|7650->4784|7889->4995|7918->4996|7966->5016|7995->5017|8064->5058|8093->5059|8180->5118|8209->5119|8247->5130|8276->5131|8553->5379|8583->5380|8625->5393|8727->5466|8757->5467|8803->5484|8850->5503|8907->5538|9136->5738|9166->5739|9220->5764|9283->5798|9313->5799|9364->5821|9394->5822|9440->5839|9542->5912|9572->5913|9634->5946|9664->5947|9786->6041|9816->6042|9886->6083|9916->6084|9958->6097|10029->6140|10059->6141|10169->6222|10199->6223|10241->6236|10483->6449|10513->6450|10543->6451|10584->6463|10614->6464|10645->6466|10675->6467|10705->6468|10746->6480|10776->6481|10863->6539|10893->6540|10923->6541|10969->6558|10999->6559|11030->6561|11060->6562|11090->6563|11136->6580|11166->6581|11215->6601|11245->6602|11275->6603|11319->6618|11349->6619|11380->6621|11410->6622|11440->6623|11487->6641|11517->6642|11596->6692|11626->6693|11656->6694|11699->6708|11729->6709|11760->6711|11790->6712|11820->6713|11864->6728|11894->6729|11970->6776|12000->6777|12030->6778|12078->6797|12108->6798|12200->6861|12230->6862|12260->6863|12331->6905|12361->6906|12430->6946|12460->6947|12490->6948|12555->6984|12585->6985|12733->7104|12763->7105|12793->7106|12834->7118|12864->7119|12895->7121|12925->7122|12955->7123|13001->7140|13031->7141|13126->7207|13156->7208|13186->7209|13226->7220|13256->7221|13305->7241|13335->7242|13365->7243|13406->7255|13436->7256|13629->7420|13659->7421|13705->7438|13743->7447|13773->7448|13823->7469|13861->7478|13891->7479|13943->7502|14031->7561|14061->7562|14115->7587|14239->7682|14269->7683|14319->7704|14349->7705|14395->7722|14425->7723|14498->7767|14528->7768|14685->7896|14715->7897|14761->7914|14937->8061|14967->8062|15017->8083|15213->8250|15243->8251|15273->8252|15307->8257|15337->8258|15387->8279|15445->8308|15475->8309|15517->8322|15547->8323|15633->8380|15663->8381|15709->8398|15813->8473|15843->8474|15893->8495|15966->8539|15996->8540|16040->8555|16070->8556|16110->8568|16140->8569|16219->8619|16249->8620|16286->8629|16446->8761|16475->8762|16509->8768|16555->8785|16585->8786|16622->8795|16668->8813|16697->8814|16730->8819|16771->8829
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|37->12|38->13|39->14|39->14|40->15|40->15|41->16|41->16|45->20|45->20|46->21|46->21|50->25|50->25|52->27|52->27|53->28|56->31|56->31|57->32|57->32|61->36|61->36|62->37|62->37|67->42|67->42|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|71->46|72->47|91->66|91->66|92->67|92->67|92->67|92->67|92->67|92->67|93->68|93->68|93->68|93->68|93->68|93->68|93->68|94->69|98->73|98->73|99->74|99->74|100->75|101->76|101->76|102->77|105->80|105->80|106->81|109->84|109->84|110->85|111->86|111->86|112->87|112->87|113->88|114->89|114->89|115->90|115->90|117->92|117->92|118->93|118->93|119->94|119->94|121->96|121->96|122->97|122->97|130->105|130->105|131->106|132->107|132->107|133->108|133->108|133->108|138->113|138->113|139->114|140->115|140->115|141->116|141->116|142->117|144->119|144->119|146->121|146->121|149->124|149->124|151->126|151->126|152->127|153->128|153->128|157->132|157->132|158->133|163->138|163->138|163->138|163->138|163->138|163->138|163->138|163->138|163->138|163->138|164->139|164->139|164->139|164->139|164->139|164->139|164->139|164->139|164->139|164->139|165->140|165->140|165->140|165->140|165->140|165->140|165->140|165->140|165->140|165->140|166->141|166->141|166->141|166->141|166->141|166->141|166->141|166->141|166->141|166->141|167->142|167->142|167->142|167->142|167->142|169->144|169->144|169->144|169->144|169->144|170->145|170->145|170->145|170->145|170->145|172->147|172->147|172->147|172->147|172->147|172->147|172->147|172->147|172->147|172->147|173->148|173->148|173->148|173->148|173->148|174->149|174->149|174->149|174->149|174->149|178->153|178->153|179->154|179->154|179->154|180->155|180->155|180->155|181->156|182->157|182->157|183->158|185->160|185->160|186->161|186->161|187->162|187->162|189->164|189->164|193->168|193->168|194->169|195->170|195->170|196->171|199->174|199->174|199->174|199->174|199->174|200->175|201->176|201->176|202->177|202->177|204->179|204->179|205->180|205->180|205->180|206->181|207->182|207->182|208->183|208->183|211->186|211->186|214->189|214->189|215->190|220->195|220->195|222->197|222->197|222->197|223->198|224->199|224->199|225->200|226->201
                  -- GENERATED --
              */
