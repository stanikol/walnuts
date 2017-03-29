
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
"""), _display_( /*4.2*/ admin(Messages("title"), Some(user)) /*4.38*/ {
            _display_(Seq[Any](format.raw /*4.39*/ ("""
    """), _display_( /*5.6*/ {
              errors.map {
                case (key, errorMsg) =>
                  <div class="col-md-10 col-md-offset-2 alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert">&times;</a>
                    <strong>{ Messages("error") } { Messages(s"blog.$key") } => { errorMsg }</strong>
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
            <label for="title" class="control-label">"""), _display_( /*19.55*/ Messages("blog.title")), format.raw /*19.77*/ ("""</label>
            <input type="text" id="title" name="title" value='"""), _display_( /*20.64*/ { article("title").value }), format.raw /*20.88*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="description" class="control-label">"""), _display_( /*24.61*/ Messages("blog.description")), format.raw /*24.89*/ ("""</label>
            <textarea type="text" id="description" name="description" class="form-control">"""), _display_( /*25.93*/ { article("description").value }), format.raw /*25.123*/ ("""</textarea>
        </div>
        <div class="form-group">
            <label for="blog-edit" class="control-label">"""), _display_( /*28.59*/ Messages("blog.article-text")), format.raw /*28.88*/ ("""</label>
            <div id="blog-edit" class="form-control">
                """), _display_( /*30.18*/ { Html(article("blog-text").value.getOrElse("")) }), format.raw /*30.66*/ ("""
            """), format.raw /*31.13*/ ("""</div>
        </div>
        <div class="form-group">
            <label for="keywords" class="control-label">"""), _display_( /*34.58*/ Messages("blog.keywords")), format.raw /*34.83*/ ("""</label>
            <input type="text" id="keywords" name="keywords" value='"""), _display_( /*35.70*/ { article("keywords").value }), format.raw /*35.97*/ ("""'
                   class="form-control"/>
        </div>
        <div class="form-group">
            <label for="sort-order" class="control-label">"""), _display_( /*39.60*/ Messages("blog.sort-order")), format.raw /*39.87*/ ("""</label>
            <input type="text" id="sort-order" name="sort-order" value='"""), _display_( /*40.74*/ { article("sort-order").value }), format.raw /*40.103*/ ("""'
                   class="form-control"/>
        </div>
        <!--BUTTONS-->
        <div class="btn-group btn-group-lg">
            <button type="submit" id="new-btn" name="action" value="new" class="btn btn-warning">"""), _display_( /*45.99*/ Messages("blog.save-as-new")), format.raw /*45.127*/ ("""</button>
            """), _display_( /*46.14*/ if (article("id").value.isDefined) /*46.47*/ {
              _display_(Seq[Any](format.raw /*46.48*/ ("""
                """), format.raw /*47.17*/ ("""<button type="submit" id="save-btn" name="action" value="save" class="btn btn-primary">"""), _display_( /*47.105*/ Messages("blog.save-article")), format.raw /*47.134*/ ("""</button>
                <button type="submit" id="delete-btn" name="action" value="delete" class="btn btn-danger">"""), _display_( /*48.108*/ Messages("blog.delete-article")), format.raw /*48.139*/ ("""</button>
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
                """), format.raw /*175.17*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                document.getElementById('blog-short-text').value = quill.getText(0, 222);
                if( deleteButtonPressed )"""), format.raw /*177.42*/ ("""{"""), format.raw /*177.43*/ ("""
                    """), format.raw /*178.21*/ ("""let id = document.getElementById('id').value;
                    deleteButtonPressed = false;
                    return confirm('Delete article #'+id);
                """), format.raw /*181.17*/ ("""}"""), format.raw /*181.18*/ (""" """), format.raw /*181.19*/ ("""else """), format.raw /*181.24*/ ("""{"""), format.raw /*181.25*/ ("""
                    """), format.raw /*182.21*/ ("""return true;
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
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/blogEdit.scala.html
                  HASH: 66e597303a0a705d58ca9b172a20e96b8d3db41b
                  MATRIX: 687->1|997->197|1024->218|1051->220|1095->256|1133->257|1164->263|1451->530|1483->535|1625->650|1690->693|1741->717|1783->738|1875->803|1917->824|2240->1120|2283->1142|2382->1214|2427->1238|2606->1390|2655->1418|2783->1519|2835->1549|2980->1667|3030->1696|3137->1776|3206->1824|3247->1837|3386->1949|3432->1974|3537->2052|3585->2079|3763->2230|3811->2257|3920->2339|3971->2368|4223->2593|4273->2621|4323->2644|4365->2677|4404->2678|4449->2695|4565->2783|4616->2812|4761->2929|4814->2960|4868->2983|4904->2992|5291->3442|5327->3451|5788->3884|5817->3885|5858->3898|5893->3906|5913->3917|5958->3941|6019->3974|6048->3975|6092->3991|6152->4023|6181->4024|6241->4056|6270->4057|6307->4066|6336->4067|6389->4092|6649->4324|6678->4325|6752->4371|6781->4372|6830->4393|6929->4464|6958->4465|7011->4490|7191->4642|7220->4643|7277->4672|7483->4850|7512->4851|7577->4888|7656->4939|7685->4940|7749->4976|7778->4977|7839->5010|7936->5080|7992->5115|8072->5167|8101->5168|8340->5379|8369->5380|8417->5400|8446->5401|8516->5442|8546->5443|8634->5502|8664->5503|8703->5514|8733->5515|9010->5763|9040->5764|9082->5777|9184->5850|9214->5851|9260->5868|9307->5887|9364->5922|9593->6122|9623->6123|9677->6148|9740->6182|9770->6183|9821->6205|9851->6206|9897->6223|9999->6296|10029->6297|10091->6330|10121->6331|10243->6425|10273->6426|10343->6467|10373->6468|10415->6481|10486->6524|10516->6525|10626->6606|10656->6607|10698->6620|10940->6833|10970->6834|11000->6835|11041->6847|11071->6848|11102->6850|11132->6851|11162->6852|11203->6864|11233->6865|11320->6923|11350->6924|11380->6925|11426->6942|11456->6943|11487->6945|11517->6946|11547->6947|11593->6964|11623->6965|11672->6985|11702->6986|11732->6987|11776->7002|11806->7003|11837->7005|11867->7006|11897->7007|11944->7025|11974->7026|12053->7076|12083->7077|12113->7078|12156->7092|12186->7093|12217->7095|12247->7096|12277->7097|12321->7112|12351->7113|12427->7160|12457->7161|12487->7162|12535->7181|12565->7182|12657->7245|12687->7246|12717->7247|12788->7289|12818->7290|12887->7330|12917->7331|12947->7332|13012->7368|13042->7369|13190->7488|13220->7489|13250->7490|13291->7502|13321->7503|13352->7505|13382->7506|13412->7507|13458->7524|13488->7525|13583->7591|13613->7592|13643->7593|13683->7604|13713->7605|13762->7625|13792->7626|13822->7627|13863->7639|13893->7640|14079->7797|14109->7798|14155->7815|14193->7824|14223->7825|14273->7846|14311->7855|14341->7856|14393->7879|14481->7938|14511->7939|14565->7964|14689->8059|14719->8060|14769->8081|14799->8082|14845->8099|14875->8100|14948->8144|14978->8145|15138->8276|15168->8277|15214->8294|15478->8529|15508->8530|15558->8551|15757->8721|15787->8722|15817->8723|15851->8728|15881->8729|15931->8750|15989->8779|16019->8780|16061->8793|16091->8794|16177->8851|16207->8852|16253->8869|16357->8944|16387->8945|16437->8966|16510->9010|16540->9011|16584->9026|16614->9027|16654->9039|16684->9040|16733->9058
                  LINES: 22->1|27->1|28->3|29->4|29->4|29->4|30->5|35->10|36->11|37->12|37->12|38->13|38->13|39->14|39->14|44->19|44->19|45->20|45->20|49->24|49->24|50->25|50->25|53->28|53->28|55->30|55->30|56->31|59->34|59->34|60->35|60->35|64->39|64->39|65->40|65->40|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|73->48|73->48|74->49|75->50|84->61|85->62|95->72|95->72|96->73|96->73|96->73|96->73|96->73|96->73|97->74|97->74|97->74|97->74|97->74|97->74|97->74|98->75|102->79|102->79|103->80|103->80|104->81|105->82|105->82|106->83|109->86|109->86|110->87|113->90|113->90|114->91|115->92|115->92|116->93|116->93|117->94|118->95|118->95|119->96|119->96|121->98|121->98|122->99|122->99|123->100|123->100|125->102|125->102|126->103|126->103|134->111|134->111|135->112|136->113|136->113|137->114|137->114|137->114|142->119|142->119|143->120|144->121|144->121|145->122|145->122|146->123|148->125|148->125|150->127|150->127|153->130|153->130|155->132|155->132|156->133|157->134|157->134|161->138|161->138|162->139|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|167->144|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|168->145|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|169->146|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|170->147|171->148|171->148|171->148|171->148|171->148|173->150|173->150|173->150|173->150|173->150|174->151|174->151|174->151|174->151|174->151|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|176->153|177->154|177->154|177->154|177->154|177->154|178->155|178->155|178->155|178->155|178->155|182->159|182->159|183->160|183->160|183->160|184->161|184->161|184->161|185->162|186->163|186->163|187->164|189->166|189->166|190->167|190->167|191->168|191->168|193->170|193->170|197->174|197->174|198->175|200->177|200->177|201->178|204->181|204->181|204->181|204->181|204->181|205->182|206->183|206->183|207->184|207->184|209->186|209->186|210->187|210->187|210->187|211->188|212->189|212->189|213->190|213->190|216->193|216->193|218->195
                  -- GENERATED --
              */
