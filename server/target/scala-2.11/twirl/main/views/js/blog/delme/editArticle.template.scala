
package views.js.blog.delme

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
       """), format.raw /*18.8*/ ("""let imagesDialog = $('<div />', """), format.raw /*18.40*/ ("""{"""), format.raw /*18.41*/ ("""id: "imagesDialog", class: "row""""), format.raw /*18.73*/ ("""}"""), format.raw /*18.74*/ (""").dialog("""), format.raw /*18.83*/ ("""{"""), format.raw /*18.84*/ ("""
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
                class: "col col-sm-2",
                click: function()"""), format.raw /*30.34*/ ("""{"""), format.raw /*30.35*/ ("""
"""), format.raw /*31.1*/ ("""//                    quill.insertEmbed(range.index, 'image', imageHref, Quill.sources.USER)
                    quill.updateContents(
                        new Delta()
                          .retain(quill.getSelection().index)
                          .insert("""), format.raw /*35.35*/ ("""{"""), format.raw /*35.36*/ ("""
                            """), format.raw /*36.29*/ ("""image: imageHref
                          """), format.raw /*37.27*/ ("""}"""), format.raw /*37.28*/ (""",
                          """), format.raw /*38.27*/ ("""{"""), format.raw /*38.28*/ ("""
"""), format.raw /*39.1*/ ("""//                            link: imageHref,
                            alt: image.content
                          """), format.raw /*41.27*/ ("""}"""), format.raw /*41.28*/ ("""));
                    imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                """), format.raw /*43.17*/ ("""}"""), format.raw /*43.18*/ ("""
           """), format.raw /*44.12*/ ("""}"""), format.raw /*44.13*/ (""").appendTo(imagesDialog);
       """), format.raw /*45.8*/ ("""}"""), format.raw /*45.9*/ (""");
       imagesDialog.dialog('open');
    """), format.raw /*47.5*/ ("""}"""), format.raw /*47.6*/ (""");
"""), format.raw /*48.1*/ ("""}"""), format.raw /*48.2*/ (""";



$(document).ready(function()"""), format.raw /*52.29*/ ("""{"""), format.raw /*52.30*/ ("""
    """), format.raw /*53.5*/ ("""// Init QuillJS.com editor
    const toolbarOptions = [
        ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
        ['blockquote', 'code-block'],

        ["""), format.raw /*58.10*/ ("""{"""), format.raw /*58.11*/ (""" """), format.raw /*58.12*/ ("""'header': 1 """), format.raw /*58.24*/ ("""}"""), format.raw /*58.25*/ (""", """), format.raw /*58.27*/ ("""{"""), format.raw /*58.28*/ (""" """), format.raw /*58.29*/ ("""'header': 2 """), format.raw /*58.41*/ ("""}"""), format.raw /*58.42*/ ("""],               // custom button values
        ["""), format.raw /*59.10*/ ("""{"""), format.raw /*59.11*/ (""" """), format.raw /*59.12*/ ("""'list': 'ordered'"""), format.raw /*59.29*/ ("""}"""), format.raw /*59.30*/ (""", """), format.raw /*59.32*/ ("""{"""), format.raw /*59.33*/ (""" """), format.raw /*59.34*/ ("""'list': 'bullet' """), format.raw /*59.51*/ ("""}"""), format.raw /*59.52*/ ("""],
        ["""), format.raw /*60.10*/ ("""{"""), format.raw /*60.11*/ (""" """), format.raw /*60.12*/ ("""'script': 'sub'"""), format.raw /*60.27*/ ("""}"""), format.raw /*60.28*/ (""", """), format.raw /*60.30*/ ("""{"""), format.raw /*60.31*/ (""" """), format.raw /*60.32*/ ("""'script': 'super' """), format.raw /*60.50*/ ("""}"""), format.raw /*60.51*/ ("""],      // superscript/subscript
        ["""), format.raw /*61.10*/ ("""{"""), format.raw /*61.11*/ (""" """), format.raw /*61.12*/ ("""'indent': '-1'"""), format.raw /*61.26*/ ("""}"""), format.raw /*61.27*/ (""", """), format.raw /*61.29*/ ("""{"""), format.raw /*61.30*/ (""" """), format.raw /*61.31*/ ("""'indent': '+1' """), format.raw /*61.46*/ ("""}"""), format.raw /*61.47*/ ("""],          // outdent/indent
        ["""), format.raw /*62.10*/ ("""{"""), format.raw /*62.11*/ (""" """), format.raw /*62.12*/ ("""'direction': 'rtl' """), format.raw /*62.31*/ ("""}"""), format.raw /*62.32*/ ("""],                         // text direction

        ["""), format.raw /*64.10*/ ("""{"""), format.raw /*64.11*/ (""" """), format.raw /*64.12*/ ("""'size': ['small', false, 'large', 'huge'] """), format.raw /*64.54*/ ("""}"""), format.raw /*64.55*/ ("""],  // custom dropdown
        ["""), format.raw /*65.10*/ ("""{"""), format.raw /*65.11*/ (""" """), format.raw /*65.12*/ ("""'header': [1, 2, 3, 4, 5, 6, false] """), format.raw /*65.48*/ ("""}"""), format.raw /*65.49*/ ("""],
        [ 'link', 'image', 'video', 'formula' ],          // add's image support
        ["""), format.raw /*67.10*/ ("""{"""), format.raw /*67.11*/ (""" """), format.raw /*67.12*/ ("""'color': [] """), format.raw /*67.24*/ ("""}"""), format.raw /*67.25*/ (""", """), format.raw /*67.27*/ ("""{"""), format.raw /*67.28*/ (""" """), format.raw /*67.29*/ ("""'background': [] """), format.raw /*67.46*/ ("""}"""), format.raw /*67.47*/ ("""],          // dropdown with defaults from theme
        ["""), format.raw /*68.10*/ ("""{"""), format.raw /*68.11*/ (""" """), format.raw /*68.12*/ ("""'font': [] """), format.raw /*68.23*/ ("""}"""), format.raw /*68.24*/ ("""],
        ["""), format.raw /*69.10*/ ("""{"""), format.raw /*69.11*/ (""" """), format.raw /*69.12*/ ("""'align': [] """), format.raw /*69.24*/ ("""}"""), format.raw /*69.25*/ ("""],

        ['clean']                                         // remove formatting button
    ];
    quill = new Quill('#blog-edit', """), format.raw /*73.37*/ ("""{"""), format.raw /*73.38*/ ("""
        """), format.raw /*74.9*/ ("""modules: """), format.raw /*74.18*/ ("""{"""), format.raw /*74.19*/ ("""
            """), format.raw /*75.13*/ ("""toolbar: """), format.raw /*75.22*/ ("""{"""), format.raw /*75.23*/ ("""
              """), format.raw /*76.15*/ ("""container: toolbarOptions,
              handlers: """), format.raw /*77.25*/ ("""{"""), format.raw /*77.26*/ ("""
                """), format.raw /*78.17*/ ("""image: imageHandler
              """), format.raw /*79.15*/ ("""}"""), format.raw /*79.16*/ ("""
            """), format.raw /*80.13*/ ("""}"""), format.raw /*80.14*/ ("""
        """), format.raw /*81.9*/ ("""}"""), format.raw /*81.10*/ (""",
        theme: 'snow'
    """), format.raw /*83.5*/ ("""}"""), format.raw /*83.6*/ (""");
    // Before submitting form do
    $('#article-form').submit(() => """), format.raw /*85.37*/ ("""{"""), format.raw /*85.38*/ ("""
      """), format.raw /*86.7*/ ("""alert('Handler for .submit() called.');
      var text = $('.ql-editor').html();
      $('#text').val(text);
      return true;
    """), format.raw /*90.5*/ ("""}"""), format.raw /*90.6*/ (""");
    function save_blog()"""), format.raw /*91.25*/ ("""{"""), format.raw /*91.26*/ ("""
        """), format.raw /*92.9*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
        document.getElementById('blog-short-text').value = quill.getText(0, 222);
        document.forms['article-edit-form'].submit();
    """), format.raw /*95.5*/ ("""}"""), format.raw /*95.6*/ (""";
    // Handle save button pressed
    if(document.getElementById("save-btn"))"""), format.raw /*97.44*/ ("""{"""), format.raw /*97.45*/ ("""
        """), format.raw /*98.9*/ ("""document.getElementById("save-btn").addEventListener('click', () => """), format.raw /*98.77*/ ("""{"""), format.raw /*98.78*/ ("""
            """), format.raw /*99.13*/ ("""document.getElementById('action').value = "save"
            save_blog();
        """), format.raw /*101.9*/ ("""}"""), format.raw /*101.10*/ (""");
    """), format.raw /*102.5*/ ("""}"""), format.raw /*102.6*/ (""";
    // Handle save as new button pressed
    if(document.getElementById("new-btn"))"""), format.raw /*104.43*/ ("""{"""), format.raw /*104.44*/ ("""
        """), format.raw /*105.9*/ ("""document.getElementById("new-btn").addEventListener('click', () => """), format.raw /*105.76*/ ("""{"""), format.raw /*105.77*/ ("""
            """), format.raw /*106.13*/ ("""document.getElementById('action').value = "new"
            save_blog();
        """), format.raw /*108.9*/ ("""}"""), format.raw /*108.10*/ (""");
    """), format.raw /*109.5*/ ("""}"""), format.raw /*109.6*/ (""";
    // Set delault value for sort-order
    if(document.getElementById('sort-order').value === '')"""), format.raw /*111.59*/ ("""{"""), format.raw /*111.60*/ ("""
        """), format.raw /*112.9*/ ("""document.getElementById('sort-order').value = new Date().toISOString();
    """), format.raw /*113.5*/ ("""}"""), format.raw /*113.6*/ (""";
    // Handle deletion of article
    if(document.getElementById("delete-btn"))"""), format.raw /*115.46*/ ("""{"""), format.raw /*115.47*/ ("""
        """), format.raw /*116.9*/ ("""document.getElementById("delete-btn").addEventListener('click', () => """), format.raw /*116.79*/ ("""{"""), format.raw /*116.80*/ ("""
            """), format.raw /*117.13*/ ("""document.getElementById('action').value = "delete"
            let id = document.getElementById('id').value;
            if(id && confirm('Delete article #'+id))"""), format.raw /*119.53*/ ("""{"""), format.raw /*119.54*/ ("""
                """), format.raw /*120.17*/ ("""document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                document.forms['article-edit-form'].submit();
            """), format.raw /*122.13*/ ("""}"""), format.raw /*122.14*/ ("""
        """), format.raw /*123.9*/ ("""}"""), format.raw /*123.10*/ (""");
    """), format.raw /*124.5*/ ("""}"""), format.raw /*124.6*/ (""";


"""), format.raw /*127.1*/ ("""}"""), format.raw /*127.2*/ (""");"""))
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
                  DATE: Thu Mar 30 01:07:17 EEST 2017
                  SOURCE: /Users/snc/scala/walnuts/server/app/views/blog/delme/editArticle.scala.js
                  HASH: e11a446f26f5b4eeb7fb090dbbb966ea594e41d4
                  MATRIX: 620->1|722->3|749->4|1123->350|1152->351|1180->352|1245->389|1274->390|1302->391|1422->484|1450->485|1579->587|1599->598|1644->622|1705->655|1734->656|1769->664|1829->696|1858->697|1918->729|1947->730|1984->739|2013->740|2058->757|2285->957|2313->958|2379->996|2408->997|2449->1010|2540->1073|2569->1074|2614->1091|2770->1219|2799->1220|2827->1221|3122->1488|3151->1489|3208->1518|3279->1561|3308->1562|3364->1590|3393->1591|3421->1592|3569->1712|3598->1713|3821->1908|3850->1909|3890->1921|3919->1922|3979->1955|4007->1956|4077->1999|4105->2000|4135->2003|4163->2004|4224->2037|4253->2038|4285->2043|4494->2224|4523->2225|4552->2226|4592->2238|4621->2239|4651->2241|4680->2242|4709->2243|4749->2255|4778->2256|4856->2306|4885->2307|4914->2308|4959->2325|4988->2326|5018->2328|5047->2329|5076->2330|5121->2347|5150->2348|5190->2360|5219->2361|5248->2362|5291->2377|5320->2378|5350->2380|5379->2381|5408->2382|5454->2400|5483->2401|5553->2443|5582->2444|5611->2445|5653->2459|5682->2460|5712->2462|5741->2463|5770->2464|5813->2479|5842->2480|5909->2519|5938->2520|5967->2521|6014->2540|6043->2541|6126->2596|6155->2597|6184->2598|6254->2640|6283->2641|6343->2673|6372->2674|6401->2675|6465->2711|6494->2712|6615->2805|6644->2806|6673->2807|6713->2819|6742->2820|6772->2822|6801->2823|6830->2824|6875->2841|6904->2842|6990->2900|7019->2901|7048->2902|7087->2913|7116->2914|7156->2926|7185->2927|7214->2928|7254->2940|7283->2941|7444->3074|7473->3075|7509->3084|7546->3093|7575->3094|7616->3107|7653->3116|7682->3117|7725->3132|7804->3183|7833->3184|7878->3201|7940->3235|7969->3236|8010->3249|8039->3250|8075->3259|8104->3260|8159->3288|8187->3289|8287->3361|8316->3362|8350->3369|8509->3501|8537->3502|8592->3529|8621->3530|8657->3539|8928->3783|8956->3784|9063->3863|9092->3864|9128->3873|9224->3941|9253->3942|9294->3955|9404->4037|9434->4038|9469->4045|9498->4046|9612->4131|9642->4132|9679->4141|9775->4208|9805->4209|9847->4222|9956->4303|9986->4304|10021->4311|10050->4312|10179->4412|10209->4413|10246->4422|10350->4498|10379->4499|10489->4580|10519->4581|10556->4590|10655->4660|10685->4661|10727->4674|10917->4835|10947->4836|10993->4853|11200->5031|11230->5032|11267->5041|11297->5042|11332->5049|11361->5050|11393->5054|11422->5055
                  LINES: 22->1|27->1|28->2|38->12|38->12|39->13|39->13|39->13|40->14|41->15|41->15|43->17|43->17|43->17|43->17|43->17|44->18|44->18|44->18|44->18|44->18|44->18|44->18|45->19|49->23|49->23|50->24|50->24|51->25|52->26|52->26|53->27|56->30|56->30|57->31|61->35|61->35|62->36|63->37|63->37|64->38|64->38|65->39|67->41|67->41|69->43|69->43|70->44|70->44|71->45|71->45|73->47|73->47|74->48|74->48|78->52|78->52|79->53|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|84->58|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|85->59|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|86->60|87->61|87->61|87->61|87->61|87->61|87->61|87->61|87->61|87->61|87->61|88->62|88->62|88->62|88->62|88->62|90->64|90->64|90->64|90->64|90->64|91->65|91->65|91->65|91->65|91->65|93->67|93->67|93->67|93->67|93->67|93->67|93->67|93->67|93->67|93->67|94->68|94->68|94->68|94->68|94->68|95->69|95->69|95->69|95->69|95->69|99->73|99->73|100->74|100->74|100->74|101->75|101->75|101->75|102->76|103->77|103->77|104->78|105->79|105->79|106->80|106->80|107->81|107->81|109->83|109->83|111->85|111->85|112->86|116->90|116->90|117->91|117->91|118->92|121->95|121->95|123->97|123->97|124->98|124->98|124->98|125->99|127->101|127->101|128->102|128->102|130->104|130->104|131->105|131->105|131->105|132->106|134->108|134->108|135->109|135->109|137->111|137->111|138->112|139->113|139->113|141->115|141->115|142->116|142->116|142->116|143->117|145->119|145->119|146->120|148->122|148->122|149->123|149->123|150->124|150->124|153->127|153->127
                  -- GENERATED --
              */
