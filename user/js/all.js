//prefix price number
document.addEventListener("DOMContentLoaded", function() {
  let prices = document.querySelectorAll(".current_prefix");
  prices.forEach(price => {
      let intPrice = parseInt(price.textContent.trim(), 10) * 1000;
      let viPrice = intPrice.toLocaleString('vi-VN', {style : 'currency', currency : 'VND'});
      price.textContent = viPrice;
  });
});

//choose payment
document.querySelectorAll('.accordion-button').forEach(button => {
    button.addEventListener('click', function() {
        // Find the input radio button within the clicked accordion button
        const radioButton = this.querySelector('input[type="radio"]');
        if (radioButton) {
            // Set the radio button to checked
            radioButton.checked = true;
        }
    });
});

//date range picker calendar
$(function() {
    var today = moment().startOf('day');

    function updateDayCount(start, end) {
      var dayCount = end.diff(start, 'days') - 1; // Add 1 to include both start and end dates
      dayCount = Math.max(dayCount, 0);
      $('#dayCount').text(dayCount);
      return dayCount;
    }

    $('#startdate').daterangepicker({
      singleDatePicker: true,
      startDate: today,
      minDate: today,
      locale: {
        format: 'DD/MM/YYYY',
        daysOfWeek: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
        monthNames: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
        firstDay: 1
      }
    });

    $('#enddate').daterangepicker({
      singleDatePicker: true,
      minDate: today,
      locale: {
        format: 'DD/MM/YYYY',
        daysOfWeek: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
        monthNames: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
        firstDay: 1
      }
    });

    // Update day count when applying date range changes
    $('#startdate').on('apply.daterangepicker', function(ev, picker) {
      var startDate = picker.startDate;
      var endDate = $('#enddate').data('daterangepicker').startDate;
      // Check if end date is before start date, fix it
      if (endDate.isBefore(startDate)) {
        $('#enddate').data('daterangepicker').setStartDate(startDate);
        $('#enddate').val(startDate.format('DD/MM/YYYY'));
      }
      updateDayCount(startDate, endDate);
    });

    $('#enddate').on('apply.daterangepicker', function(ev, picker) {
      var endDate = picker.startDate;
      var startDate = $('#startdate').data('daterangepicker').startDate;
      // Check if end date is before start date, fix it
      if (endDate.isBefore(startDate)) {
        $('#startdate').data('daterangepicker').setStartDate(endDate);
        $('#startdate').val(endDate.format('DD/MM/YYYY'));
      }
      updateDayCount(startDate, endDate);
    });

    // Initial calculation and display of day count
    var startDate = today;
    var endDate = today.add(1, 'days');
    updateDayCount(startDate, endDate);

    $('#startdate').on('apply.daterangepicker', handleDateChange);
    $('#enddate').on('apply.daterangepicker', handleDateChange);

    function handleDateChange() {
        var startDate = $('#startdate').data('daterangepicker').startDate;
        var endDate = $('#enddate').data('daterangepicker').startDate;
        var dayCount = updateDayCount(startDate, endDate);
        if (dayCount > 0) {
            $('#feedbackMsg').hide(); // Hide the feedback message if day count is greater than 0
        } else {
            $('#feedbackMsg').show(); // Show the feedback message if day count is 0
        }
    }

    //validation button
    $('#continueBtn').click(function() {
        var dayCount = parseInt($('#dayCount').text());
        if (dayCount > 0) {
            // Continue to the next page
            window.location.href = "/user/checkout.html";
        } else {
            // Show feedback message
            $('#feedbackMsg').html('<div class="feedback-date">Số ngày thuê phải lớn hơn 0.</div>').show();
        }
    });
  });

//form validation
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()


//add to cart
document.addEventListener("DOMContentLoaded", function () {
  const addToCartBtn = document.querySelector('.add_to_cart');
  const productQuantityInput = document.querySelector('.product_quantity');
  const cartArea = document.querySelector('.cart_area');
  let productCount = 0;
  let cartData = JSON.parse(localStorage.getItem('cart')) || [];

  function updateTotalQuantity() {
      const totalQuantityElements = document.querySelectorAll('.total_quantity');
      totalQuantityElements.forEach(element => {
          element.textContent = productCount;
      });
  }

  function updateCartCount() {
      updateTotalQuantity();
  }

  function updateLocalStorage() {
      localStorage.setItem('cart', JSON.stringify(cartData));
  }

  function createCartItem(product) {
      const cartItem = document.createElement('div');
      cartItem.classList.add('cart_item', 'd-flex', 'justify-content-between', 'align-items-center');
      cartItem.innerHTML = `
          <img class="product_img" src="${product.image}" alt="${product.name}">
          <div class="product_text d-flex flex-column">
              <div class="product_title">${product.name}</div>
              <div class="subtotal_price">${product.price}</div>
          </div>
          <div class="product_count">
              <span class="number-decrement"><i class="ti-minus"></i></span>
              <input class="input-number product_quantity" type="text" value="${product.quantity}" min="1">
              <span class="number-increment"><i class="ti-plus"></i></span>
          </div>
          <span class="remove_item"><i class="far fa-trash-alt"></i></span>
      `;
      return cartItem;
  }

  function loadCartData() {
      cartData.forEach(product => {
          const cartItem = createCartItem(product);
          cartArea.appendChild(cartItem);
          productCount += product.quantity;
      });
      updateCartCount();
  }

  function handleAddToCart() {
      const productName = document.querySelector('.product_name').textContent;
      const productPrice = document.querySelector('.product_price').textContent;
      const productQuantity = parseInt(productQuantityInput.value);
      const productImage = document.querySelector('.product_img').src;

      const existingProductIndex = cartData.findIndex(product => product.name === productName);

      if (existingProductIndex !== -1) {
          cartData[existingProductIndex].quantity += productQuantity;
          productCount += productQuantity;
          const existingCartItem = cartArea.children[existingProductIndex];
          const quantityInput = existingCartItem.querySelector('.product_quantity');
          quantityInput.value = cartData[existingProductIndex].quantity;
      } else {
          const product = {
              name: productName,
              price: productPrice,
              quantity: productQuantity,
              image: productImage
          };
          const cartItem = createCartItem(product);
          cartArea.appendChild(cartItem);
          cartData.push(product);
          productCount += productQuantity;
      }

      updateCartCount();
      updateLocalStorage();
  }

  function handleCartItemEvents(event) {
      const target = event.target;
      const cartItem = target.closest('.cart_item');
      if (!cartItem) return;

      const input = cartItem.querySelector('.input-number');
      const itemName = cartItem.querySelector('.product_title').textContent;
      const productIndex = cartData.findIndex(product => product.name === itemName);

      if (target.classList.contains('number-decrement') || target.classList.contains('ti-minus')) {
          if (parseInt(input.value) > 1) {
              input.value--;
              productCount--;
              cartData[productIndex].quantity--;
          }
      } else if (target.classList.contains('number-increment') || target.classList.contains('ti-plus')) {
          input.value++;
          productCount++;
          cartData[productIndex].quantity++;
      } else if (target.classList.contains('remove_item') || target.classList.contains('far')) {
          productCount -= parseInt(input.value);
          cartItem.remove();
          cartData.splice(productIndex, 1);
      }

      updateCartCount();
      updateLocalStorage();
  }

  if (addToCartBtn) {
      addToCartBtn.addEventListener('click', handleAddToCart);
  }

  if (cartArea) {
      cartArea.addEventListener('click', handleCartItemEvents);
  }

  loadCartData();
});











