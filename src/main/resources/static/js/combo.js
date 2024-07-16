document.addEventListener('DOMContentLoaded', function() {
    // Selectors for slider and thumbnail elements
    const sliderItems = document.querySelectorAll('.slider .list .item');
    const thumbnails = document.querySelectorAll('.thumbnail .item');

    // Function to show current slider item based on index
    function showSlider(index) {
        // Remove 'active' class from all slider items and thumbnails
        sliderItems.forEach(item => item.classList.remove('active'));
        thumbnails.forEach(item => item.classList.remove('active'));

        // Add 'active' class to the current slider item and thumbnail
        sliderItems[index].classList.add('active');
        thumbnails[index].classList.add('active');
    }

    // Event listener for thumbnails
    thumbnails.forEach((thumbnail, index) => {
        thumbnail.addEventListener('click', function() {
            showSlider(index); // Show corresponding slider item when thumbnail is clicked
        });
    });

    // Optional: Auto slide functionality
    let currentIndex = 0;
    const maxIndex = sliderItems.length - 1;

    function autoSlide() {
        currentIndex = (currentIndex + 1) % sliderItems.length;
        showSlider(currentIndex);
    }

    // Uncomment the line below to enable auto sliding every 5 seconds
    setInterval(autoSlide, 5000);
});
