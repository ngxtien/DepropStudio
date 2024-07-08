const dropArea = document.getElementById("drop-area");
const inputFile = document.getElementById("input-file");
const imageView = document.getElementById("img-view");

inputFile.addEventListener("change", uploadImage);

function uploadImage(){
    let imgLink = URL.createObjectURL(inputFile.files[0]);
    imageView.style.backgroundImage = `url(${imgLink})`
    imageView.textContent = "";
    imageView.style.border = 0;
}

dropArea.addEventListener("dragover", function(e){
    e.preventDefault();
});

dropArea.addEventListener("drop", function(e){
    e.preventDefault();
    inputFile.files = e.dataTransfer.files;
    uploadImage();
});

function previewImage(event) {
    var input = event.target;
    var reader = new FileReader();

    reader.onload = function(){
        var imgPreview = document.getElementById('image-preview');
        imgPreview.style.display = 'block'; // Hiển thị thẻ img xem trước

        var currentImg = document.getElementById('imaged');
        currentImg.style.display = 'none'; // Ẩn ảnh hiện tại

        imgPreview.src = reader.result;
    };

    reader.readAsDataURL(input.files[0]);
}