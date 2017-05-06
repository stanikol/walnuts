// Set handler for image upload
function onSelectImage() {
    if(document.getElementsByName('name')[0].value === ""){
        document.getElementsByName('name')[0].value = this.files[0].name;
    }
     //document.getElementsByName('content')[0].value = this.files[0].name;
     document.getElementById('save').disabled = false;
};

document.getElementById("new-image").addEventListener("change", onSelectImage);

// Set handler for image deletion and rename
var rename     = document.getElementsByName('rename')[0];
var checkBoxes  = document.getElementsByName("imageChecked");
var what  = document.getElementById("what2rename");
function onCheckImage() {
    if(this.checked){
        if(what.value === 'name'){
            rename.value = this.value;
        }
        if(what.value === 'content'){
            rename.value = this.dataset.content;
        }
    };
};

for(var i=0; i < checkBoxes.length; i++){
    checkBoxes[i].addEventListener("change", onCheckImage)
};

$(document).ready(function(){
    $('#clear-selected-albums').click(function(){
        $("#albums option:selected").prop("selected", false)
    });
});