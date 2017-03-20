
package views.html.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object blogEdit_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.html._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class blogEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable, Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.User, Form[models.nuts.Data.Article], Map[String, String], RequestHeader, Messages, WebJarAssets, play.twirl.api.HtmlFormat.Appendable] {

    /**/
    def apply /*1.2*/ (user: models.User, article: Form[models.nuts.Data.Article], errors: Map[String, String] = Map.empty[String, String])(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
        {
          import helper.CSRF

          Seq[Any](format.raw /*1.198*/ ("""
"""), format.raw /*3.1*/ ("""
"""), _display_( /*4.2*/ admin(Messages("blogEdit.title"), Some(user)) /*4.47*/ {
            _display_(Seq[Any](format.raw /*4.48*/ ("""
    """), _display_( /*5.6*/ {
              errors.map {
                case (key, errorMsg) =>
                  <div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>{ Messages("error") } { Messages(s"blogEdit.$key") } => { errorMsg }</strong>
                  </div>
              }
            }), format.raw /*10.7*/ ("""
    """), format.raw /*11.5*/ ("""<input type="file" id="filepicker" style="display: none"/>
    <form id="article-edit-form" method="POST" action=""""), _display_( /*12.57*/ CSRF(controllers.nuts.routes.Blog.onSubmit)), format.raw /*12.100*/ ("""">
        <strong>ID #"""), _display_( /*13.22*/ { article("id").value }), format.raw /*13.43*/ ("""</strong>
        <input type="hidden" id="id" name="id" value=""""), _display_( /*14.56*/ { article("id").value }), format.raw /*14.77*/ (""""/>
        <input type="hidden" id="blog-text" name="blog-text" />
        <input type="hidden" id="blog-short-text" name="blog-short-text" />
        <!--<input type="hidden" id="action" name="action" />-->
        <div class="form-group">
            <label for="title" class="control-label">"""), _display_( /*19.55*/ Messages("blogEdit.title")), format.raw /*19.81*/ ("""</label>
            <input type="text" id="title" name="title" value='"""), _display_( /*20.64*/ { article("title").value }), format.raw /*20.88*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*24.61*/ Messages("blogEdit.description")), format.raw /*24.93*/ ("""</label>
            <textarea type="text" id="description" name="description" class="form-control">"""), _display_( /*25.93*/ { article("description").value }), format.raw /*25.123*/ ("""</textarea>
        </div>
        <div class="form-group">
            <label for="blog-edit" class="control-label">"""), _display_( /*28.59*/ Messages("blogEdit.article-text")), format.raw /*28.92*/ ("""</label>
            <div id="blog-edit" class="form-control">
                """), _display_( /*30.18*/ { Html(article("blog-text").value.getOrElse("")) }), format.raw /*30.66*/ ("""
            """), format.raw /*31.13*/ ("""</div>
        </div>
        <div class="form-group">
            <label for="keywords" class="control-label">"""), _display_( /*34.58*/ Messages("blogEdit.keywords")), format.raw /*34.87*/ ("""</label>
            <input type="text" id="keywords" name="keywords" value='"""), _display_( /*35.70*/ { article("keywords").value }), format.raw /*35.97*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="sort-order" class="control-label">"""), _display_( /*39.60*/ Messages("blogEdit.sort-order")), format.raw /*39.91*/ ("""</label>
            <input type="text" id="sort-order" name="sort-order" value='"""), _display_( /*40.74*/ { article("sort-order").value }), format.raw /*40.103*/ ("""'
                   class="form-control"/>
        </div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <button type="submit" id="new-btn" name="action" value="new" class="btn btn-warning">"""), _display_( /*45.99*/ Messages("blogEdit.save-as-new")), format.raw /*45.131*/ ("""</button>
            """), _display_( /*46.14*/ if (article("id").value.isDefined) /*46.47*/ {
              _display_(Seq[Any](format.raw /*46.48*/ ("""
                """), format.raw /*47.17*/ ("""<button type="submit" id="save-btn" name="action" value="save" class="btn btn-primary">"""), _display_( /*47.105*/ Messages("blogEdit.save-article")), format.raw /*47.138*/ ("""</button>
                <button type="submit" id="delete-btn" name="action" value="delete" class="btn btn-danger">"""), _display_( /*48.108*/ Messages("blogEdit.delete-article")), format.raw /*48.143*/ ("""</button>
            """)))
            }), format.raw /*49.14*/ ("""
        """), format.raw /*50.9*/ ("""</div>
    </form>

    <!-- Include the Quill library -->
    <link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
    <link href="/assets/styles/blogEdit.css" rel="stylesheet"/>
    <script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>
    <!--<script src="/assets/javascripts/blogEdit.js"></script>-->
    <script>
        """), format.raw /*61.21*/ ("""
        """), format.raw /*62.9*/ ("""// QuillJS editor. Will be initiated later.
        var quill;
        var Delta =  Quill.import('delta');

        /**
            Handle image insertion from database.
            First query `/img/list` for list of image available in database.
            Then, after data is received, create dialog (with jQuery) and append
            to it all the image references received from DB.
        */
        function image2Handler() """), format.raw /*72.34*/ ("""{"""), format.raw /*72.35*/ ("""
            """), format.raw /*73.13*/ ("""$.get('"""), _display_( /*73.21*/ controllers /*73.32*/ .nuts.routes.Images.list), format.raw /*73.56*/ ("""', function(listOfImages, status)"""), format.raw /*73.89*/ ("""{"""), format.raw /*73.90*/ ("""
               """), format.raw /*74.16*/ ("""let imagesDialog = $('<div />', """), format.raw /*74.48*/ ("""{"""), format.raw /*74.49*/ ("""id: "imagesDialog", class: "row""""), format.raw /*74.81*/ ("""}"""), format.raw /*74.82*/ (""").dialog("""), format.raw /*74.91*/ ("""{"""), format.raw /*74.92*/ ("""
                        """), format.raw /*75.25*/ ("""autoOpen: false,
                        modal:    true,
                        width:    $(window).width() - $(window).width() * 0.2,
                        height:   $(window).height() - $(window).height() * 0.2,
               """), format.raw /*79.16*/ ("""}"""), format.raw /*79.17*/ (""");
               listOfImages.map((image) => """), format.raw /*80.44*/ ("""{"""), format.raw /*80.45*/ ("""
                    """), format.raw /*81.21*/ ("""const imageHref = '/img/'+image.name;
                    $('<img />', """), format.raw /*82.34*/ ("""{"""), format.raw /*82.35*/ ("""
                        """), format.raw /*83.25*/ ("""src:   imageHref,
                        alt:   image.content,
                        class: "col col-sm-2",
                        click: function()"""), format.raw /*86.42*/ ("""{"""), format.raw /*86.43*/ ("""
                            """), format.raw /*87.29*/ ("""quill.updateContents(
                                new Delta()
                                  .retain(quill.getSelection().index)
                                  .insert("""), format.raw /*90.43*/ ("""{"""), format.raw /*90.44*/ ("""
                                    """), format.raw /*91.37*/ ("""image: imageHref
                                  """), format.raw /*92.35*/ ("""}"""), format.raw /*92.36*/ (""",
                                  """), format.raw /*93.35*/ ("""{"""), format.raw /*93.36*/ ("""
                                """), format.raw /*94.33*/ ("""// link: imageHref,
                                    alt: prompt('"""), _display_( /*95.51*/ Messages("Enter image description")), format.raw /*95.86*/ ("""', image.content)
                                  """), format.raw /*96.35*/ ("""}"""), format.raw /*96.36*/ ("""));
                            imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                        """), format.raw /*98.25*/ ("""}"""), format.raw /*98.26*/ ("""
                   """), format.raw /*99.20*/ ("""}"""), format.raw /*99.21*/ (""").appendTo(imagesDialog);
               """), format.raw /*100.16*/ ("""}"""), format.raw /*100.17*/ (""");
               imagesDialog.dialog('open');
            """), format.raw /*102.13*/ ("""}"""), format.raw /*102.14*/ (""");
        """), format.raw /*103.9*/ ("""}"""), format.raw /*103.10*/ (""";

        /**
            Handle image insertion from filesystem as base64 data.
            Used as default image handler.
        */
        let filepicker = document.getElementById("filepicker");

        function insertImageInQuillJSAsBase64()"""), format.raw /*111.48*/ ("""{"""), format.raw /*111.49*/ ("""
            """), format.raw /*112.13*/ ("""let reader = new FileReader();
            reader.onloadend = function() """), format.raw /*113.43*/ ("""{"""), format.raw /*113.44*/ ("""
                """), format.raw /*114.17*/ ("""let alt = prompt('"""), _display_( /*114.36*/ Messages("Enter image description")), format.raw /*114.71*/ ("""', file);
                let base64 = reader.result;
                quill.updateContents(
                new Delta()
                  .retain(quill.getSelection().index)
                  .insert("""), format.raw /*119.27*/ ("""{"""), format.raw /*119.28*/ ("""
                        """), format.raw /*120.25*/ ("""image: base64
                    """), format.raw /*121.21*/ ("""}"""), format.raw /*121.22*/ (""",
                    """), format.raw /*122.21*/ ("""{"""), format.raw /*122.22*/ ("""
                """), format.raw /*123.17*/ ("""// link: imageHref,
                        alt: alt
                    """), format.raw /*125.21*/ ("""}"""), format.raw /*125.22*/ (""")
                );
            """), format.raw /*127.13*/ ("""}"""), format.raw /*127.14*/ (""";
            let file = filepicker.files[0];
            reader.readAsDataURL(file);
        """), format.raw /*130.9*/ ("""}"""), format.raw /*130.10*/ (""";

        function imageBase64Handler() """), format.raw /*132.39*/ ("""{"""), format.raw /*132.40*/ ("""
            """), format.raw /*133.13*/ ("""$('#filepicker').trigger('click');
        """), format.raw /*134.9*/ ("""}"""), format.raw /*134.10*/ (""";

        var deleteButtonPressed = false;

        $(document).ready(function()"""), format.raw /*138.37*/ ("""{"""), format.raw /*138.38*/ ("""
            """), format.raw /*139.13*/ ("""// Init QuillJS.com editor
            const toolbarOptions = [
                ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
                ['blockquote', 'code-block'],

                ["""), format.raw /*144.18*/ ("""{"""), format.raw /*144.19*/ (""" """), format.raw /*144.20*/ ("""'header': 1 """), format.raw /*144.32*/ ("""}"""), format.raw /*144.33*/ (""", """), format.raw /*144.35*/ ("""{"""), format.raw /*144.36*/ (""" """), format.raw /*144.37*/ ("""'header': 2 """), format.raw /*144.49*/ ("""}"""), format.raw /*144.50*/ ("""],               // custom button values
                ["""), format.raw /*145.18*/ ("""{"""), format.raw /*145.19*/ (""" """), format.raw /*145.20*/ ("""'list': 'ordered'"""), format.raw /*145.37*/ ("""}"""), format.raw /*145.38*/ (""", """), format.raw /*145.40*/ ("""{"""), format.raw /*145.41*/ (""" """), format.raw /*145.42*/ ("""'list': 'bullet' """), format.raw /*145.59*/ ("""}"""), format.raw /*145.60*/ ("""],
                ["""), format.raw /*146.18*/ ("""{"""), format.raw /*146.19*/ (""" """), format.raw /*146.20*/ ("""'script': 'sub'"""), format.raw /*146.35*/ ("""}"""), format.raw /*146.36*/ (""", """), format.raw /*146.38*/ ("""{"""), format.raw /*146.39*/ (""" """), format.raw /*146.40*/ ("""'script': 'super' """), format.raw /*146.58*/ ("""}"""), format.raw /*146.59*/ ("""],      // superscript/subscript
                ["""), format.raw /*147.18*/ ("""{"""), format.raw /*147.19*/ (""" """), format.raw /*147.20*/ ("""'indent': '-1'"""), format.raw /*147.34*/ ("""}"""), format.raw /*147.35*/ (""", """), format.raw /*147.37*/ ("""{"""), format.raw /*147.38*/ (""" """), format.raw /*147.39*/ ("""'indent': '+1' """), format.raw /*147.54*/ ("""}"""), format.raw /*147.55*/ ("""],          // outdent/indent
                ["""), format.raw /*148.18*/ ("""{"""), format.raw /*148.19*/ (""" """), format.raw /*148.20*/ ("""'direction': 'rtl' """), format.raw /*148.39*/ ("""}"""), format.raw /*148.40*/ ("""],                         // text direction

                ["""), format.raw /*150.18*/ ("""{"""), format.raw /*150.19*/ (""" """), format.raw /*150.20*/ ("""'size': ['small', false, 'large', 'huge'] """), format.raw /*150.62*/ ("""}"""), format.raw /*150.63*/ ("""],  // custom dropdown
                ["""), format.raw /*151.18*/ ("""{"""), format.raw /*151.19*/ (""" """), format.raw /*151.20*/ ("""'header': [1, 2, 3, 4, 5, 6, false] """), format.raw /*151.56*/ ("""}"""), format.raw /*151.57*/ ("""],
                [ 'link', 'image', 'image2', 'video', 'formula' ],          // add's image support
                ["""), format.raw /*153.18*/ ("""{"""), format.raw /*153.19*/ (""" """), format.raw /*153.20*/ ("""'color': [] """), format.raw /*153.32*/ ("""}"""), format.raw /*153.33*/ (""", """), format.raw /*153.35*/ ("""{"""), format.raw /*153.36*/ (""" """), format.raw /*153.37*/ ("""'background': [] """), format.raw /*153.54*/ ("""}"""), format.raw /*153.55*/ ("""],          // dropdown with defaults from theme
                ["""), format.raw /*154.18*/ ("""{"""), format.raw /*154.19*/ (""" """), format.raw /*154.20*/ ("""'font': [] """), format.raw /*154.31*/ ("""}"""), format.raw /*154.32*/ ("""],
                ["""), format.raw /*155.18*/ ("""{"""), format.raw /*155.19*/ (""" """), format.raw /*155.20*/ ("""'align': [] """), format.raw /*155.32*/ ("""}"""), format.raw /*155.33*/ ("""],

                ['clean']                                         // remove formatting button
            ];
            quill = new Quill('#blog-edit', """), format.raw /*159.45*/ ("""{"""), format.raw /*159.46*/ ("""
                """), format.raw /*160.17*/ ("""modules: """), format.raw /*160.26*/ ("""{"""), format.raw /*160.27*/ ("""
                    """), format.raw /*161.21*/ ("""toolbar: """), format.raw /*161.30*/ ("""{"""), format.raw /*161.31*/ ("""
                      """), format.raw /*162.23*/ ("""container: toolbarOptions,
                      handlers: """), format.raw /*163.33*/ ("""{"""), format.raw /*163.34*/ ("""
                        """), format.raw /*164.25*/ ("""image: imageBase64Handler,
                        image2: image2Handler
                      """), format.raw /*166.23*/ ("""}"""), format.raw /*166.24*/ ("""
                    """), format.raw /*167.21*/ ("""}"""), format.raw /*167.22*/ ("""
                """), format.raw /*168.17*/ ("""}"""), format.raw /*168.18*/ (""",
                theme: 'snow'
            """), format.raw /*170.13*/ ("""}"""), format.raw /*170.14*/ (""");

            $('#filepicker').change(insertImageInQuillJSAsBase64);

            $('#article-edit-form').on('submit', function()"""), format.raw /*174.60*/ ("""{"""), format.raw /*174.61*/ ("""
                """), format.raw /*175.17*/ ("""if( deleteButtonPressed )"""), format.raw /*175.42*/ ("""{"""), format.raw /*175.43*/ ("""
                    """), format.raw /*176.21*/ ("""let id = document.getElementById('id').value;
                    deleteButtonPressed = false;
                    return confirm('Delete article #'+id);
                """), format.raw /*179.17*/ ("""}"""), format.raw /*179.18*/ (""" """), format.raw /*179.19*/ ("""else """), format.raw /*179.24*/ ("""{"""), format.raw /*179.25*/ ("""
                    """), format.raw /*180.21*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                    document.getElementById('blog-short-text').value = quill.getText(0, 222);
                    return true;
                """), format.raw /*183.17*/ ("""}"""), format.raw /*183.18*/ ("""
            """), format.raw /*184.13*/ ("""}"""), format.raw /*184.14*/ (""");

            if(document.getElementById("delete-btn"))"""), format.raw /*186.54*/ ("""{"""), format.raw /*186.55*/ ("""
                """), format.raw /*187.17*/ ("""document.getElementById("delete-btn").addEventListener('click', (event) => """), format.raw /*187.92*/ ("""{"""), format.raw /*187.93*/ ("""
                    """), format.raw /*188.21*/ ("""deleteButtonPressed = true;
                """), format.raw /*189.17*/ ("""}"""), format.raw /*189.18*/ (""");
            """), format.raw /*190.13*/ ("""}"""), format.raw /*190.14*/ (""";


        """), format.raw /*193.9*/ ("""}"""), format.raw /*193.10*/ (""");
    </script>
""")))
          }), format.raw /*195.2*/ ("""
"""))
        }
      }
    }

    def render(user: models.User, article: Form[models.nuts.Data.Article], errors: Map[String, String], request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets): play.twirl.api.HtmlFormat.Appendable = apply(user, article, errors)(request, messages, webJarAssets)

    def f: ((models.User, Form[models.nuts.Data.Article], Map[String, String]) => (RequestHeader, Messages, WebJarAssets) => play.twirl.api.HtmlFormat.Appendable) = (user, article, errors) => (request, messages, webJarAssets) => apply(user, article, errors)(request, messages, webJarAssets)

    def ref: this.type = this

  }

}

/**/
object blogEdit extends blogEdit_Scope0.blogEdit
/*
                  -- GENERATED --
                  DATE: Mon Mar 20 14:42:49 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogEdit.scala.html
                  HASH: 4eb2f5753a405b0768917acfdfa44920cd1f087e
                  MATRIX: 687->1|997->197|1024->218|1051->220|1104->265|1142->266|1173->272|1464->543|1496->548|1638->663|1703->706|1754->730|1796->751|1888->816|1930->837|2253->1133|2300->1159|2399->1231|2444->1255|2623->1407|2676->1439|2804->1540|2856->1570|3001->1688|3055->1721|3162->1801|3231->1849|3272->1862|3411->1974|3461->2003|3566->2081|3614->2108|3792->2259|3844->2290|3953->2372|4004->2401|4256->2626|4310->2658|4360->2681|4402->2714|4441->2715|4486->2732|4602->2820|4657->2853|4802->2970|4859->3005|4913->3028|4949->3037|5336->3487|5372->3496|5833->3929|5862->3930|5903->3943|5938->3951|5958->3962|6003->3986|6064->4019|6093->4020|6137->4036|6197->4068|6226->4069|6286->4101|6315->4102|6352->4111|6381->4112|6434->4137|6694->4369|6723->4370|6797->4416|6826->4417|6875->4438|6974->4509|7003->4510|7056->4535|7236->4687|7265->4688|7322->4717|7528->4895|7557->4896|7622->4933|7701->4984|7730->4985|7794->5021|7823->5022|7884->5055|7981->5125|8037->5160|8117->5212|8146->5213|8385->5424|8414->5425|8462->5445|8491->5446|8561->5487|8591->5488|8679->5547|8709->5548|8748->5559|8778->5560|9055->5808|9085->5809|9127->5822|9229->5895|9259->5896|9305->5913|9352->5932|9409->5967|9638->6167|9668->6168|9722->6193|9785->6227|9815->6228|9866->6250|9896->6251|9942->6268|10044->6341|10074->6342|10136->6375|10166->6376|10288->6470|10318->6471|10388->6512|10418->6513|10460->6526|10531->6569|10561->6570|10671->6651|10701->6652|10743->6665|10985->6878|11015->6879|11045->6880|11086->6892|11116->6893|11147->6895|11177->6896|11207->6897|11248->6909|11278->6910|11365->6968|11395->6969|11425->6970|11471->6987|11501->6988|11532->6990|11562->6991|11592->6992|11638->7009|11668->7010|11717->7030|11747->7031|11777->7032|11821->7047|11851->7048|11882->7050|11912->7051|11942->7052|11989->7070|12019->7071|12098->7121|12128->7122|12158->7123|12201->7137|12231->7138|12262->7140|12292->7141|12322->7142|12366->7157|12396->7158|12472->7205|12502->7206|12532->7207|12580->7226|12610->7227|12702->7290|12732->7291|12762->7292|12833->7334|12863->7335|12932->7375|12962->7376|12992->7377|13057->7413|13087->7414|13235->7533|13265->7534|13295->7535|13336->7547|13366->7548|13397->7550|13427->7551|13457->7552|13503->7569|13533->7570|13628->7636|13658->7637|13688->7638|13728->7649|13758->7650|13807->7670|13837->7671|13867->7672|13908->7684|13938->7685|14124->7842|14154->7843|14200->7860|14238->7869|14268->7870|14318->7891|14356->7900|14386->7901|14438->7924|14526->7983|14556->7984|14610->8009|14734->8104|14764->8105|14814->8126|14844->8127|14890->8144|14920->8145|14993->8189|15023->8190|15183->8321|15213->8322|15259->8339|15313->8364|15343->8365|15393->8386|15592->8556|15622->8557|15652->8558|15686->8563|15716->8564|15766->8585|16042->8832|16072->8833|16114->8846|16144->8847|16230->8904|16260->8905|16306->8922|16410->8997|16440->8998|16490->9019|16563->9063|16593->9064|16637->9079|16667->9080|16707->9092|16737->9093|16786->9111
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|36->11|37->12|37->12|38->13|38->13|39->14|39->14|44->19|44->19|45->20|45->20|49->24|49->24|50->25|50->25|53->28|53->28|55->30|55->30|56->31|59->34|59->34|60->35|60->35|64->39|64->39|65->40|65->40|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|73->48|73->48|74->49|75->50|84->61|85->62|95->72|95->72|96->73|96->73|96->73|96->73|96->73|96->73|97->74|97->74|97->74|97->74|97->74|97->74|97->74|98->75|102->79|102->79|103->80|103->80|104->81|105->82|105->82|106->83|109->86|109->86|110->87|113->90|113->90|114->91|115->92|115->92|116->93|116->93|117->94|118->95|118->95|119->96|119->96|121->98|121->98|122->99|122->99|123->100|123->100|125->102|125->102|126->103|126->103|134->111|134->111|135->112|136->113|136->113|137->114|137->114|137->114|142->119|142->119|143->120|144->121|144->121|145->122|145->122|146->123|148->125|148->125|150->127|150->127|153->130|153->130|155->132|155->132|156->133|157->134|157->134|161->138|161->138|162->139|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|171->148|171->148|171->148|171->148|171->148|173->150|173->150|173->150|173->150|173->150|174->151|174->151|174->151|174->151|174->151|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|177->154|177->154|177->154|177->154|177->154|178->155|178->155|178->155|178->155|178->155|182->159|182->159|183->160|183->160|183->160|184->161|184->161|184->161|185->162|186->163|186->163|187->164|189->166|189->166|190->167|190->167|191->168|191->168|193->170|193->170|197->174|197->174|198->175|198->175|198->175|199->176|202->179|202->179|202->179|202->179|202->179|203->180|206->183|206->183|207->184|207->184|209->186|209->186|210->187|210->187|210->187|211->188|212->189|212->189|213->190|213->190|216->193|216->193|218->195
                  -- GENERATED --
              */
