@()(implicit request: RequestHeader, messages: Messages, webJarAssets: WebJarAssets)
<link href="https://cdn.quilljs.com/1.2.0/quill.snow.css" rel="stylesheet"/>
<script src="https://cdn.quilljs.com/1.2.0/quill.js"></script>
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
    function image2Handler() {
        $.get('@controllers.images.routes.ImagesAdmin.jsonAllImageInfo', function(listOfImages, status){
           let imagesDialog = $('<div />', {id: "imagesDialog", class: "row"}).dialog({
                    autoOpen: false,
                    modal:    true,
                    width:    $(window).width() - $(window).width() * 0.2,
                    height:   $(window).height() - $(window).height() * 0.2,
           });
           listOfImages.map((image) => {
//                const imageHref = '/img/'+image.name;
                const imageHref = '@controllers.images.routes.Images.getThumbnail("change-me")'.replace('change-me', image.name)
                $('<img />', {
                    src:   imageHref,
                    alt:   image.content,
                    class: "col col-sm-2",
                    click: function(){
                        quill.updateContents(
                            new Delta()
                              .retain(quill.getSelection().index)
                              .insert({
                                image: imageHref
                              },
                              {
                            // link: imageHref
                                alt: prompt('@Messages("Enter image description")', image.content)
                                ,style: {float: 'left'}
                                //className:'img-responsive'
                              }));
                        imagesDialog.dialog('destroy').remove(); // dialog has to be destroyed, otherwise next time there will be 2 or more dialogs with the same id #imagesDialog
                    }
               }).appendTo(imagesDialog);
           });
           imagesDialog.dialog('open');
        });
    };

    /**
        Handle image insertion from filesystem as base64 data.
        Used as default image handler.
    */
    var filepicker = document.getElementById("filepicker");

    function insertImageInQuillJSAsBase64(){
        let reader = new FileReader();
        reader.onloadend = function() {
            let alt = prompt('@Messages("Enter image description")', file);
            let base64 = reader.result;
            quill.updateContents(
            new Delta()
              .retain(quill.getSelection().index)
              .insert({
                    image: base64
                },
                {
            // link: imageHref,
                    alt: alt
                })
            );
        };
        let file = filepicker.files[0];
        reader.readAsDataURL(file);
    };

    function imageBase64Handler() {
        $('#filepicker').trigger('click');
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
            [ 'link', 'image', 'image2', 'video', 'formula' ],          // add's image support
            [{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
            [{ 'font': [] }],
            [{ 'align': [] }],

            ['clean']                                         // remove formatting button
        ];
        quill = new Quill('div#quilljs-edit', {
            modules: {
                toolbar: {
                  container: toolbarOptions,
                  handlers: {
                    image: imageBase64Handler,
                    image2: image2Handler
                  }
                }
            },
            theme: 'snow'
        });

        $('#filepicker').change(insertImageInQuillJSAsBase64);

        $('#insert-pic').on('click', image2Handler);


    });
</script>
<style>
    .ql-image2:after {
        content: "Ω";
    }
</style>
