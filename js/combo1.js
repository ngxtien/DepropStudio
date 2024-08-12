document.addEventListener("DOMContentLoaded", function () {
    const comboSlider = document.querySelector('.combo_slider');

    if (comboSlider) {
        const owl = $(comboSlider).owlCarousel({
            items: 1,
            loop: false,
            dots: true,
            nav: true,
            navText: [
                "<span><i class='fa-solid fa-angle-right fa-3x'></i></span>",
                "<span><i class='fa-solid fa-angle-left fa-3x'></i></span>"
            ],
            smartSpeed: 1000,
            responsive: {
                0: { nav: true },
                600: { nav: true },
                768: { nav: true }
            }
        });

        // Add a check for the number of items
        owl.on('initialized.owl.carousel', function(event) {
            const totalItems = event.item.count;
            if (totalItems === 1) {
                $(comboSlider).trigger('stop.owl.autoplay');
            }
        });

        owl.on('changed.owl.carousel', function(event) {
            const productsContainers = document.querySelectorAll('.container .products');
            
            productsContainers.forEach(container => {
                container.style.display = 'none'; // Hide all products containers
            });


            // Index starts from 0, so adding 1 to match with the ID suffix
            const currentSlideIndex = (event.item.index % event.item.count) + 1;
            const currentProductContainer = document.getElementById('products' + currentSlideIndex);

            if (currentProductContainer) {
                currentProductContainer.style.display = 'flex'; // Show current products container
            }
        });

        // Display the products section for the initial slide
        const initialSlideIndex = $('.owl-item.active').index() + 1;
        const initialProductContainer = document.getElementById('products' + initialSlideIndex);

        if (initialProductContainer) {
            initialProductContainer.style.display = 'flex';
        }
    }
});