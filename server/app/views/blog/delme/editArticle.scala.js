@()
// QuillJS editor. Will be initiated later.
var quill;
var Delta =  Quill.import('delta');

/**
    Handle image insertion.
    First query `/img/list` for list of image available in database.
    Then, after data is received, create dialog (with jQuery) and append
    to it all the image references received from DB.
*/
function imageHandler() {
//    function insertEmbed(imageHref){
//        this.quill.insertEmbed(range.index, 'image', imageHref, Quill.sources.USER);
//    };
    let range = this.quill.getSelection(); // where to insert image into quilljs editor
    $.get('@controllers.nuts.routes.Images.list', function(listOfImages, status){
       let imagesDialog = $('<div />', {id: "imagesDialog", class: "row"}).dialog({
                autoOpen: false,
                modal:    true,
                width:    $(window).width() - $(window).width() * 0.2,
                height:   $(window).height() - $(window).height() * 0.2,
       });
       listOfImages.map((image) => {
            const imageHref = '/img/'+image.name;
            $('<img />', {
                src:   imageHref,
                alt:   image.content,
                class: "col col-sm-2",
                click: function(){
//                    quill.insertEmbed(range.index, 'image', imageHref, Quill.sources.USER)
                    quill.updateContents(
                        new Delta()
                          .retain(quill.getSelection().index)
                          .insert({
                            image: imageHref
                          },
                          {
//                            link: imageHref,
                            alt: image.content
                          }));
                    imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                }
           }).appendTo(imagesDialog);
       });
       imagesDialog.dialog('open');
    });
};



$(document).ready(function(){
    // Init QuillJS.com editor
    const toolbarOptions = [
        ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
        ['blockquote', 'code-block'],

        [{ 'header': 1 }, { 'header': 2 }],               // custom button values
        [{ 'list': 'ordered'}, { 'list': 'bullet' }],
        [{ 'script': 'sub'}, { 'script': 'super' }],      // superscript/subscript
        [{ 'indent': '-1'}, { 'indent': '+1' }],          // outdent/indent
        [{ 'direction': 'rtl' }],                         // text direction

        [{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
        [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
        [ 'link', 'image', 'video', 'formula' ],          // add's image support
        [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
        [{ 'font': [] }],
        [{ 'align': [] }],

        ['clean']                                         // remove formatting button
    ];
    quill = new Quill('#blog-edit', {
        modules: {
            toolbar: {
              container: toolbarOptions,
              handlers: {
                image: imageHandler
              }
            }
        },
        theme: 'snow'
    });
    // Before submitting form do
    $('#article-form').submit(() => {
      alert('Handler for .submit() called.');
      var text = $('.ql-editor').html();
      $('#text').val(text);
      return true;
    });
    function save_blog(){
        document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
        document.getElementById('blog-short-text').value = quill.getText(0, 222);
        document.forms['article-edit-form'].submit();
    };
    // Handle save button pressed
    if(document.getElementById("save-btn")){
        document.getElementById("save-btn").addEventListener('click', () => {
            document.getElementById('action').value = "save"
            save_blog();
        });
    };
    // Handle save as new button pressed
    if(document.getElementById("new-btn")){
        document.getElementById("new-btn").addEventListener('click', () => {
            document.getElementById('action').value = "new"
            save_blog();
        });
    };
    // Set delault value for sort-order
    if(document.getElementById('sort-order').value === ''){
        document.getElementById('sort-order').value = new Date().toISOString();
    };
    // Handle deletion of article
    if(document.getElementById("delete-btn")){
        document.getElementById("delete-btn").addEventListener('click', () => {
            document.getElementById('action').value = "delete"
            let id = document.getElementById('id').value;
            if(id && confirm('Delete article #'+id)){
                document.getElementById('blog-text').value = document.getElementsByClassName('ql-editor')[0].innerHTML;
                document.forms['article-edit-form'].submit();
            }
        });
    };


});