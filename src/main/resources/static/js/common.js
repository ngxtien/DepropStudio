//prefix price number
document.addEventListener("DOMContentLoaded", function () {
  let prices = document.querySelectorAll(".current_prefix");
  prices.forEach((price) => {
    let intPrice = parseInt(price.textContent.trim(), 10) * 1000;
    let viPrice = intPrice.toLocaleString("vi-VN", {
      style: "currency",
      currency: "VND",
    });
    price.textContent = viPrice;
  });
});

//choose payment
document.querySelectorAll(".accordion-button").forEach((button) => {
  button.addEventListener("click", function () {
    // Find the input radio button within the clicked accordion button
    const radioButton = this.querySelector('input[type="radio"]');
    if (radioButton) {
      // Set the radio button to checked
      radioButton.checked = true;
    }
  });
});
















