const dropArea = document.getElementById("drop-area");
const inputFile = document.getElementById("image-update");
const imageView = document.getElementById("img-view");
const imgPreview = document.getElementById('image-preview');
const currentImg = document.getElementById('imaged');

inputFile.addEventListener("change", previewImage);

dropArea.addEventListener("dragover", function(e) {
    e.preventDefault();
});

dropArea.addEventListener("drop", function(e) {
    e.preventDefault();
    inputFile.files = e.dataTransfer.files;
    previewImage();
});

function previewImage(event) {
    var input = event.target;
    var reader = new FileReader();

    reader.onload = function() {
        var imgPreview = document.getElementById('image-preview');
        imgPreview.style.display = 'block'; // Hiển thị thẻ img xem trước

        var currentImg = document.getElementById('imaged');
        currentImg.style.display = 'none'; // Ẩn ảnh hiện tại

        imgPreview.src = reader.result;
    };

    reader.readAsDataURL(input.files[0]);

    var hiddenImageInput = document.querySelector('input[type="hidden"][name="image"]');
    if (hiddenImageInput) {
        hiddenImageInput.value = ''; // Xóa giá trị của ảnh hiện tại
    }
}
