//prefix price number
document.addEventListener('DOMContentLoaded', (event) => {
    // Select all elements with the class 'price_number'
    const priceElements = document.querySelectorAll('.price_number');

    // Loop through all selected elements and update their content
    priceElements.forEach((priceElement) => {
        const currentPrice = priceElement.textContent;
        const updatedPrice = currentPrice + '.000';
        priceElement.textContent = updatedPrice;
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