let logo = document.getElementById("logo");
var reader = new FileReader();
logo.addEventListener('change', function(e){
    let file = e.target.files[0];
    reader.onloadend = function() {
      let alt = prompt('Alt ?');
      let base64 = reader.result;
//      let currentPosition = quill.getSelection().index || 0;
      quill.setSelection(3, 0)
        quill.updateContents({
          ops: [{
            insert: {
              image: base64
            },
            attributes: {
//              link: 'http://www.google',
              alt: alt

            },

          }]
        })
    };
    let content = reader.readAsDataURL(file);

}, false);