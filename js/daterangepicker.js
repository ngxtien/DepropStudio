$(function () {
  var today = moment().startOf("day");

  function updateDayCount(start, end) {
    var dayCount = end.diff(start, "days") - 1; // Include both start and end dates
    dayCount = Math.max(dayCount, 0);
    $("#dayCount").text(dayCount);
    $(".rent_day").text(dayCount);

    console.log(dayCount);
    // Save dayCount to localStorage
    localStorage.setItem("dayCount", dayCount);
    
    // Update elements with the class rent_day
    return dayCount;
  }

  function handleDateChange() {
    var startDate = $("#startdate").data("daterangepicker").startDate;
    var endDate = $("#enddate").data("daterangepicker").startDate;

    // Log start and end dates to the console
    console.log("Start Date:", startDate.format("DD/MM/YYYY"));
    console.log("End Date:", endDate.format("DD/MM/YYYY"));

    localStorage.setItem("startDate", startDate.format("DD/MM/YYYY"));
    localStorage.setItem("endDate", endDate.format("DD/MM/YYYY"));

    // Check if end date is before start date, and fix it
    if (endDate.isBefore(startDate)) {
      endDate = startDate;
      $("#enddate").data("daterangepicker").setStartDate(startDate);
      $("#enddate").val(startDate.format("DD/MM/YYYY"));
    }

    var dayCount = updateDayCount(startDate, endDate);
    if (dayCount > 0) {
      $("#feedbackMsg").hide();
    } else {
      $("#feedbackMsg").show();
    }
  }

  $("#startdate, #enddate").daterangepicker({
    singleDatePicker: true,
    minDate: today,
    locale: {
      format: "DD/MM/YYYY",
      daysOfWeek: ["CN", "T2", "T3", "T4", "T5", "T6", "T7"],
      monthNames: [
        "Tháng 1",
        "Tháng 2",
        "Tháng 3",
        "Tháng 4",
        "Tháng 5",
        "Tháng 6",
        "Tháng 7",
        "Tháng 8",
        "Tháng 9",
        "Tháng 10",
        "Tháng 11",
        "Tháng 12"
      ],
      firstDay: 1
    }
  });

  $("#startdate").on("apply.daterangepicker", handleDateChange);
  $("#enddate").on("apply.daterangepicker", handleDateChange);

  // Read values from localStorage when the page is reloaded
  var checkLocalStartDate = localStorage.getItem("startDate");
  var checkLocalEndDate = localStorage.getItem("endDate");
  var startDate;
  var endDate;

  if (checkLocalStartDate === null || checkLocalEndDate === null) {
    startDate = today;
    endDate = today.clone().add(1, "days");
  } else {
    startDate = moment(checkLocalStartDate, "DD/MM/YYYY");
    endDate = moment(checkLocalEndDate, "DD/MM/YYYY");
  }

  // Reset values in the input fields
  $("#startdate").data("daterangepicker").setStartDate(startDate);
  $("#startdate").val(startDate.format("DD/MM/YYYY"));
  $("#enddate").data("daterangepicker").setStartDate(endDate);
  $("#enddate").val(endDate.format("DD/MM/YYYY"));

  updateDayCount(startDate, endDate);

  // Set up event for the confirm button
  $("#continueBtn").click(function () {
    var dayCount = parseInt($("#dayCount").text());
    if (dayCount > 0) {
      window.location.href = "checkout.html";
    } else {
      $("#feedbackMsg")
          .html('<div class="feedback-date">Số ngày thuê phải lớn hơn 0.</div>')
          .show();
    }
  });
});
