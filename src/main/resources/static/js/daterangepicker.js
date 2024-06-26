$(function () {
  var today = moment().startOf("day");

  function updateDayCount(start, end) {
    var dayCount = end.diff(start, "days") - 1; // Bao gồm cả ngày bắt đầu và ngày kết thúc
    dayCount = Math.max(dayCount, 0);
    $("#dayCount").text(dayCount);
    return dayCount;
  }

  function handleDateChange() {
    var startDate = $("#startdate").data("daterangepicker").startDate;
    var endDate = $("#enddate").data("daterangepicker").startDate;

    // Ghi nhật ký các ngày bắt đầu và kết thúc vào bảng điều khiển
    console.log("Start Date:", startDate.format("DD/MM/YYYY"));
    console.log("End Date:", endDate.format("DD/MM/YYYY"));

    localStorage.setItem("startDate", startDate.format("DD/MM/YYYY"));
    localStorage.setItem("endDate", endDate.format("DD/MM/YYYY"));

    // Kiểm tra nếu ngày kết thúc trước ngày bắt đầu, sửa nó
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

  // Đọc giá trị từ localStorage khi trang được tải lại
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

  // Đặt lại giá trị trong các trường input
  $("#startdate").data("daterangepicker").setStartDate(startDate);
  $("#startdate").val(startDate.format("DD/MM/YYYY"));
  $("#enddate").data("daterangepicker").setStartDate(endDate);
  $("#enddate").val(endDate.format("DD/MM/YYYY"));

  updateDayCount(startDate, endDate);

  // Thiết lập sự kiện cho nút xác nhận
  $("#continueBtn").click(function () {
    var dayCount = parseInt($("#dayCount").text());
    if (dayCount > 0) {
      window.location.href = "/check-out";
    } else {
      $("#feedbackMsg")
          .html('<div class="feedback-date">Số ngày thuê phải lớn hơn 0.</div>')
          .show();
    }
  });
});
