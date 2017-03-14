
package views.js.blog

import play.twirl.api._
import play.twirl.api.TemplateMagic._

object editArticle_Scope0 {
  import models._
  import controllers._
  import play.api.i18n._
  import views.js._
  import play.api.templates.PlayMagic._
  import play.api.mvc._
  import play.api.data._
  import models.nuts.Data._
  import models.nuts.FormsData._

  class editArticle extends BaseScalaTemplate[play.twirl.api.JavaScriptFormat.Appendable, Format[play.twirl.api.JavaScriptFormat.Appendable]](play.twirl.api.JavaScriptFormat) with play.twirl.api.Template0[play.twirl.api.JavaScriptFormat.Appendable] {

    /**/
    def apply /*1.2*/ (): play.twirl.api.JavaScriptFormat.Appendable = {
      _display_ {
        {

          Seq[Any](format.raw /*1.4*/ ("""
"""), format.raw /*2.1*/ ("""// QuillJS editor. Will be initiated later.
var quill;
var Delta =  Quill.import('delta');

/**
    Handle image insertion.
    First query `/img/list` for list of image available in database.
    Then, after data is received, create dialog (with jQuery) and append
    to it all the image references received from DB.
*/
function imageHandler() """), format.raw /*12.25*/ ("""{"""), format.raw /*12.26*/ ("""
"""), format.raw /*13.1*/ ("""//    function insertEmbed(imageHref)"""), format.raw /*13.38*/ ("""{"""), format.raw /*13.39*/ ("""
"""), format.raw /*14.1*/ ("""//        this.quill.insertEmbed(range.index, 'image', imageHref, Quill.sources.USER);
//    """), format.raw /*15.7*/ ("""}"""), format.raw /*15.8*/ (""";
    let range = this.quill.getSelection(); // where to insert image into quilljs editor
    $.get('"""), _display_( /*17.13*/ controllers /*17.24*/ .nuts.routes.Images.list), format.raw /*17.48*/ ("""', function(listOfImages, status)"""), format.raw /*17.81*/ ("""{"""), format.raw /*17.82*/ ("""
       """), format.raw /*18.8*/ ("""let imagesDialog = $('<div />', """), format.raw /*18.40*/ ("""{"""), format.raw /*18.41*/ ("""id: "imagesDialog""""), format.raw /*18.59*/ ("""}"""), format.raw /*18.60*/ (""").dialog("""), format.raw /*18.69*/ ("""{"""), format.raw /*18.70*/ ("""
                """), format.raw /*19.17*/ ("""autoOpen: false,
                modal:    true,
                width:    $(window).width() - $(window).width() * 0.2,
                height:   $(window).height() - $(window).height() * 0.2,
       """), format.raw /*23.8*/ ("""}"""), format.raw /*23.9*/ (""");
       listOfImages.map((image) => """), format.raw /*24.36*/ ("""{"""), format.raw /*24.37*/ ("""
            """), format.raw /*25.13*/ ("""const imageHref = '/img/'+image.name;
            $('<img />', """), format.raw /*26.26*/ ("""{"""), format.raw /*26.27*/ ("""
                """), format.raw /*27.17*/ ("""src:   imageHref,
                alt:   image.content,
                click: function()"""), format.raw /*29.34*/ ("""{"""), format.raw /*29.35*/ ("""
"""), format.raw /*30.1*/ ("""//                    quill.insertEmbed(range.index, 'image', imageHref, Quill.sources.USER)
                    quill.updateContents(
                        new Delta()
                          .retain(quill.getSelection().index)
                          .insert("""), format.raw /*34.35*/ ("""{"""), format.raw /*34.36*/ ("""
                            """), format.raw /*35.29*/ ("""image: imageHref
                          """), format.raw /*36.27*/ ("""}"""), format.raw /*36.28*/ (""",
                          """), format.raw /*37.27*/ ("""{"""), format.raw /*37.28*/ ("""
"""), format.raw /*38.1*/ ("""//                            link: imageHref,
                            alt: image.content
                          """), format.raw /*40.27*/ ("""}"""), format.raw /*40.28*/ ("""));
                    imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                """), format.raw /*42.17*/ ("""}"""), format.raw /*42.18*/ ("""
           """), format.raw /*43.12*/ ("""}"""), format.raw /*43.13*/ (""").appendTo(imagesDialog);
       """), format.raw /*44.8*/ ("""}"""), format.raw /*44.9*/ (""");
       imagesDialog.dialog('open');
    """), format.raw /*46.5*/ ("""}"""), format.raw /*46.6*/ (""");
"""), format.raw /*47.1*/ ("""}"""), format.raw /*47.2*/ (""";



$(document).ready(function()"""), format.raw /*51.29*/ ("""{"""), format.raw /*51.30*/ ("""
    """), format.raw /*52.5*/ ("""// Init QuillJS.com editor
    const toolbarOptions = [
        ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
        ['blockquote', 'code-block'],

        ["""), format.raw /*57.10*/ ("""{"""), format.raw /*57.11*/ (""" """), format.raw /*57.12*/ ("""'header': 1 """), format.raw /*57.24*/ ("""}"""), format.raw /*57.25*/ (""", """), format.raw /*57.27*/ ("""{"""), format.raw /*57.28*/ (""" """), format.raw /*57.29*/ ("""'header': 2 """), format.raw /*57.41*/ ("""}"""), format.raw /*57.42*/ ("""],               // custom button values
        ["""), format.raw /*58.10*/ ("""{"""), format.raw /*58.11*/ (""" """), format.raw /*58.12*/ ("""'list': 'ordered'"""), format.raw /*58.29*/ ("""}"""), format.raw /*58.30*/ (""", """), format.raw /*58.32*/ ("""{"""), format.raw /*58.33*/ (""" """), format.raw /*58.34*/ ("""'list': 'bullet' """), format.raw /*58.51*/ ("""}"""), format.raw /*58.52*/ ("""],
        ["""), format.raw /*59.10*/ ("""{"""), format.raw /*59.11*/ (""" """), format.raw /*59.12*/ ("""'script': 'sub'"""), format.raw /*59.27*/ ("""}"""), format.raw /*59.28*/ (""", """), format.raw /*59.30*/ ("""{"""), format.raw /*59.31*/ (""" """), format.raw /*59.32*/ ("""'script': 'super' """), format.raw /*59.50*/ ("""}"""), format.raw /*59.51*/ ("""],      // superscript/subscript
        ["""), format.raw /*60.10*/ ("""{"""), format.raw /*60.11*/ (""" """), format.raw /*60.12*/ ("""'indent': '-1'"""), format.raw /*60.26*/ ("""}"""), format.raw /*60.27*/ (""", """), format.raw /*60.29*/ ("""{"""), format.raw /*60.30*/ (""" """), format.raw /*60.31*/ ("""'indent': '+1' """), format.raw /*60.46*/ ("""}"""), format.raw /*60.47*/ ("""],          // outdent/indent
        ["""), format.raw /*61.10*/ ("""{"""), format.raw /*61.11*/ (""" """), format.raw /*61.12*/ ("""'direction': 'rtl' """), format.raw /*61.31*/ ("""}"""), format.raw /*61.32*/ ("""],                         // text direction

        ["""), format.raw /*63.10*/ ("""{"""), format.raw /*63.11*/ (""" """), format.raw /*63.12*/ ("""'size': ['small', false, 'large', 'huge'] """), format.raw /*63.54*/ ("""}"""), format.raw /*63.55*/ ("""],  // custom dropdown
        ["""), format.raw /*64.10*/ ("""{"""), format.raw /*64.11*/ (""" """), format.raw /*64.12*/ ("""'header': [1, 2, 3, 4, 5, 6, false] """), format.raw /*64.48*/ ("""}"""), format.raw /*64.49*/ ("""],
        [ 'link', 'image', 'video', 'formula' ],          // add's image support
        ["""), format.raw /*66.10*/ ("""{"""), format.raw /*66.11*/ (""" """), format.raw /*66.12*/ ("""'color': [] """), format.raw /*66.24*/ ("""}"""), format.raw /*66.25*/ (""", """), format.raw /*66.27*/ ("""{"""), format.raw /*66.28*/ (""" """), format.raw /*66.29*/ ("""'background': [] """), format.raw /*66.46*/ ("""}"""), format.raw /*66.47*/ ("""],          // dropdown with defaults from theme
        ["""), format.raw /*67.10*/ ("""{"""), format.raw /*67.11*/ (""" """), format.raw /*67.12*/ ("""'font': [] """), format.raw /*67.23*/ ("""}"""), format.raw /*67.24*/ ("""],
        ["""), format.raw /*68.10*/ ("""{"""), format.raw /*68.11*/ (""" """), format.raw /*68.12*/ ("""'align': [] """), format.raw /*68.24*/ ("""}"""), format.raw /*68.25*/ ("""],

        ['clean']                                         // remove formatting button
    ];
    quill = new Quill('#blog-edit', """), format.raw /*72.37*/ ("""{"""), format.raw /*72.38*/ ("""
        """), format.raw /*73.9*/ ("""modules: """), format.raw /*73.18*/ ("""{"""), format.raw /*73.19*/ ("""
            """), format.raw /*74.13*/ ("""toolbar: """), format.raw /*74.22*/ ("""{"""), format.raw /*74.23*/ ("""
              """), format.raw /*75.15*/ ("""container: toolbarOptions,
              handlers: """), format.raw /*76.25*/ ("""{"""), format.raw /*76.26*/ ("""
                """), format.raw /*77.17*/ ("""image: imageHandler
              """), format.raw /*78.15*/ ("""}"""), format.raw /*78.16*/ ("""
            """), format.raw /*79.13*/ ("""}"""), format.raw /*79.14*/ ("""
        """), format.raw /*80.9*/ ("""}"""), format.raw /*80.10*/ (""",
        theme: 'snow'
    """), format.raw /*82.5*/ ("""}"""), format.raw /*82.6*/ (""");
    // Before submitting form do
    $('#article-form').submit(() => """), format.raw /*84.37*/ ("""{"""), format.raw /*84.38*/ ("""
      """), format.raw /*85.7*/ ("""alert('Handler for .submit() called.');
      var text = $('.ql-editor').html();
      $('#text').val(text);
      return true;
    """), format.raw /*89.5*/ ("""}"""), format.raw /*89.6*/ (""");
    function save_blog()"""), format.raw /*90.25*/ ("""{"""), format.raw /*90.26*/ ("""
        """), format.raw /*91.9*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
        document.getElementById('blog-short-text').value = quill.getText(0, 222);
        document.forms['article-edit-form'].submit();
    """), format.raw /*94.5*/ ("""}"""), format.raw /*94.6*/ (""";
    // Handle save button pressed
    if(document.getElementById("save-btn"))"""), format.raw /*96.44*/ ("""{"""), format.raw /*96.45*/ ("""
        """), format.raw /*97.9*/ ("""document.getElementById("save-btn").addEventListener('click', () => """), format.raw /*97.77*/ ("""{"""), format.raw /*97.78*/ ("""
            """), format.raw /*98.13*/ ("""document.getElementById('action').value = "save"
            save_blog();
        """), format.raw /*100.9*/ ("""}"""), format.raw /*100.10*/ (""");
    """), format.raw /*101.5*/ ("""}"""), format.raw /*101.6*/ (""";
    // Handle save as new button pressed
    if(document.getElementById("new-btn"))"""), format.raw /*103.43*/ ("""{"""), format.raw /*103.44*/ ("""
        """), format.raw /*104.9*/ ("""document.getElementById("new-btn").addEventListener('click', () => """), format.raw /*104.76*/ ("""{"""), format.raw /*104.77*/ ("""
            """), format.raw /*105.13*/ ("""document.getElementById('action').value = "new"
            save_blog();
        """), format.raw /*107.9*/ ("""}"""), format.raw /*107.10*/ (""");
    """), format.raw /*108.5*/ ("""}"""), format.raw /*108.6*/ (""";
    // Set delault value for sort-order
    if(document.getElementById('sort-order').value === '')"""), format.raw /*110.59*/ ("""{"""), format.raw /*110.60*/ ("""
        """), format.raw /*111.9*/ ("""document.getElementById('sort-order').value = new Date().toISOString();
    """), format.raw /*112.5*/ ("""}"""), format.raw /*112.6*/ (""";
    // Handle deletion of article
    if(document.getElementById("delete-btn"))"""), format.raw /*114.46*/ ("""{"""), format.raw /*114.47*/ ("""
        """), format.raw /*115.9*/ ("""document.getElementById("delete-btn").addEventListener('click', () => """), format.raw /*115.79*/ ("""{"""), format.raw /*115.80*/ ("""
            """), format.raw /*116.13*/ ("""document.getElementById('action').value = "delete"
            let id = document.getElementById('id').value;
            if(id && confirm('Delete article #'+id))"""), format.raw /*118.53*/ ("""{"""), format.raw /*118.54*/ ("""
                """), format.raw /*119.17*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                document.forms['article-edit-form'].submit();
            """), format.raw /*121.13*/ ("""}"""), format.raw /*121.14*/ ("""
        """), format.raw /*122.9*/ ("""}"""), format.raw /*122.10*/ (""");
    """), format.raw /*123.5*/ ("""}"""), format.raw /*123.6*/ (""";


"""), format.raw /*126.1*/ ("""}"""), format.raw /*126.2*/ (""");"""))
        }
      }
    }

    def render(): play.twirl.api.JavaScriptFormat.Appendable = apply()

    def f: (() => play.twirl.api.JavaScriptFormat.Appendable) = () => apply()

    def ref: this.type = this

  }

}

/**/
object editArticle extends editArticle_Scope0.editArticle
/*
                  -- GENERATED --
                  DATE: Tue Mar 14 21:07:49 EET 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/editArticle.scala.js
                  HASH: ecce565a9f5f9357fe4c5b0effd6762284d4f874
                  MATRIX: 614->1|716->3|743->4|1117->350|1146->351|1174->352|1239->389|1268->390|1296->391|1416->484|1444->485|1573->587|1593->598|1638->622|1699->655|1728->656|1763->664|1823->696|1852->697|1898->715|1927->716|1964->725|1993->726|2038->743|2265->943|2293->944|2359->982|2388->983|2429->996|2520->1059|2549->1060|2594->1077|2711->1166|2740->1167|2768->1168|3063->1435|3092->1436|3149->1465|3220->1508|3249->1509|3305->1537|3334->1538|3362->1539|3510->1659|3539->1660|3762->1855|3791->1856|3831->1868|3860->1869|3920->1902|3948->1903|4018->1946|4046->1947|4076->1950|4104->1951|4165->1984|4194->1985|4226->1990|4435->2171|4464->2172|4493->2173|4533->2185|4562->2186|4592->2188|4621->2189|4650->2190|4690->2202|4719->2203|4797->2253|4826->2254|4855->2255|4900->2272|4929->2273|4959->2275|4988->2276|5017->2277|5062->2294|5091->2295|5131->2307|5160->2308|5189->2309|5232->2324|5261->2325|5291->2327|5320->2328|5349->2329|5395->2347|5424->2348|5494->2390|5523->2391|5552->2392|5594->2406|5623->2407|5653->2409|5682->2410|5711->2411|5754->2426|5783->2427|5850->2466|5879->2467|5908->2468|5955->2487|5984->2488|6067->2543|6096->2544|6125->2545|6195->2587|6224->2588|6284->2620|6313->2621|6342->2622|6406->2658|6435->2659|6556->2752|6585->2753|6614->2754|6654->2766|6683->2767|6713->2769|6742->2770|6771->2771|6816->2788|6845->2789|6931->2847|6960->2848|6989->2849|7028->2860|7057->2861|7097->2873|7126->2874|7155->2875|7195->2887|7224->2888|7385->3021|7414->3022|7450->3031|7487->3040|7516->3041|7557->3054|7594->3063|7623->3064|7666->3079|7745->3130|7774->3131|7819->3148|7881->3182|7910->3183|7951->3196|7980->3197|8016->3206|8045->3207|8100->3235|8128->3236|8228->3308|8257->3309|8291->3316|8450->3448|8478->3449|8533->3476|8562->3477|8598->3486|8869->3730|8897->3731|9004->3810|9033->3811|9069->3820|9165->3888|9194->3889|9235->3902|9345->3984|9375->3985|9410->3992|9439->3993|9553->4078|9583->4079|9620->4088|9716->4155|9746->4156|9788->4169|9897->4250|9927->4251|9962->4258|9991->4259|10120->4359|10150->4360|10187->4369|10291->4445|10320->4446|10430->4527|10460->4528|10497->4537|10596->4607|10626->4608|10668->4621|10858->4782|10888->4783|10934->4800|11141->4978|11171->4979|11208->4988|11238->4989|11273->4996|11302->4997|11334->5001|11363->5002
                  LINES: 22->1|27->1|28->2|38->12|38->12|39->13|39->13|39->13|40->14|41->15|41->15|43->17|43->17|43->17|43->17|43->17|44->18|44->18|44->18|44->18|44->18|44->18|44->18|45->19|49->23|49->23|50->24|50->24|51->25|52->26|52->26|53->27|55->29|55->29|56->30|60->34|60->34|61->35|62->36|62->36|63->37|63->37|64->38|66->40|66->40|68->42|68->42|69->43|69->43|70->44|70->44|72->46|72->46|73->47|73->47|77->51|77->51|78->52|83->57|83->57|83->57|83->57|83->57|83->57|83->57|83->57|83->57|83->57|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|87->61|87->61|87->61|87->61|87->61|89->63|89->63|89->63|89->63|89->63|90->64|90->64|90->64|90->64|90->64|92->66|92->66|92->66|92->66|92->66|92->66|92->66|92->66|92->66|92->66|93->67|93->67|93->67|93->67|93->67|94->68|94->68|94->68|94->68|94->68|98->72|98->72|99->73|99->73|99->73|100->74|100->74|100->74|101->75|102->76|102->76|103->77|104->78|104->78|105->79|105->79|106->80|106->80|108->82|108->82|110->84|110->84|111->85|115->89|115->89|116->90|116->90|117->91|120->94|120->94|122->96|122->96|123->97|123->97|123->97|124->98|126->100|126->100|127->101|127->101|129->103|129->103|130->104|130->104|130->104|131->105|133->107|133->107|134->108|134->108|136->110|136->110|137->111|138->112|138->112|140->114|140->114|141->115|141->115|141->115|142->116|144->118|144->118|145->119|147->121|147->121|148->122|148->122|149->123|149->123|152->126|152->126
                  -- GENERATED --
              */
