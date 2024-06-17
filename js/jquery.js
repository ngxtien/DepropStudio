(function ($) {
  "use strict";

  var spinner = function () {
    setTimeout(function () {
        if ($('#spinner').length > 0) {
            $('#spinner').removeClass('show');
        }
    }, 1);
  };
  spinner();

  //product list slider
  var product_list_slider = $('.product_list_slider');
  if (product_list_slider.length) {
    product_list_slider.owlCarousel({
      items: 1,
      loop: true,
      dots: true,
      autoplay: true,
      autoplayHoverPause: true,
      autoplayTimeout: 5000,
      nav: true,
      navText: ["<span><i class='fa-solid fa-angle-right fa-3x'></i></span>", "<span><i class='fa-solid fa-angle-left fa-3x'></i></span>"],
      smartSpeed: 1000,
      responsive: {
        0: {
          margin: 15,
          nav: false,
          items: 1
        },
        600: {
          margin: 15,
          items: 1,
          nav: false
        },
        768: {
          margin: 30,
          nav: true,
          items: 1
        }
      }
    });
  }

  if ($('.img-gal').length > 0) {
    $('.img-gal').magnificPopup({
      type: 'image',
      gallery: {
        enabled: true
      }
    });
  }


  //single banner slider
  $('.banner_slider').owlCarousel({
    items: 1,
    loop: true,
    dots: true,
    autoplay: true,
    autoplayHoverPause: true,
    autoplayTimeout: 5000,
    nav: true,
    navText: ["<span><i class='fa-solid fa-angle-right fa-3x'></i></span>", "<span><i class='fa-solid fa-angle-left fa-3x'></i></span>"],
    smartSpeed: 1000,
    responsive: {
      0: {
        nav: true
      },
      600: {
        nav: true
      },
      768: {
        nav: true
      }
    }
  });

  $('.feature_slider').owlCarousel({
    items: 1,
    loop: true,
    dots: true,
    autoplay: true,
    autoplayHoverPause: true,
    autoplayTimeout: 5000,
    nav: true,
    navText: ["<span><i class='fa-solid fa-angle-right fa-3x'></i></span>", "<span><i class='fa-solid fa-angle-left fa-3x'></i></span>"],
    smartSpeed: 1000,
    responsive: {
      0: {
        nav: true
      },
      600: {
        nav: true
      },
      768: {
        nav: true
      }
    }
  });


  // Search Toggle
  $("#search_input_box").hide();
  $("#search_1").on("click", function () {
    $("#search_input_box").slideToggle();
    $("#search_input").focus();
  });
  $("#close_search").on("click", function () {
    $('#search_input_box').slideUp(500);
  });

  // click counter js
  (function() {
 
  window.inputNumber = function(el) {

    var min = el.attr('min') || false;
    var max = el.attr('max') || false;

    var els = {};

    els.dec = el.prev();
    els.inc = el.next();

    el.each(function() {
      init($(this));
    });

    function init(el) {

      els.dec.on('click', decrement);
      els.inc.on('click', increment);

      function decrement() {
        var value = el[0].value;
        value--;
        if(!min || value >= min) {
          el[0].value = value;
        }
      }

      function increment() {
        var value = el[0].value;
        value++;
        if(!max || value <= max) {
          el[0].value = value++;
        }
      }
    }
  }
  })();

  inputNumber($('.input-number'));

  $(document).ready(function() {
    $('.s_product_img').magnificPopup({
        type: 'image',
        zoom: {
            enabled: true, // Enable zoom effect
            duration: 300, // Duration of the zoom effect, in milliseconds
            easing: 'ease-in-out' // CSS transition easing function
        },
        callbacks: {
            open: function() {
                $('html').css('overflow', ''); // Enable page scrolling
            },
            close: function() {
                $('html').css('overflow', ''); // Ensure page scrolling is reset when popup is closed
            }
        }
    });
});
    
}(jQuery));