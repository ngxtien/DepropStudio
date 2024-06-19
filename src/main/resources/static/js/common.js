//prefix price number
// document.addEventListener("DOMContentLoaded", function () {
//   let prices = document.querySelectorAll(".current_prefix");
//   prices.forEach((price) => {
//     let intPrice = parseInt(price.textContent.trim(), 10) * 1000;
//     let viPrice = intPrice.toLocaleString("vi-VN", {
//       style: "currency",
//       currency: "VND",
//     });
//     price.textContent = viPrice;
//   });
// });

//Price format
// function formatPrice(price) {
//   const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&.');
//   ${formatPrice(product.price)}
//   return formattedPrice.substring(0, formattedPrice.length + 4) + " VND";
// }

document.addEventListener("DOMContentLoaded", function () {
  function formatPrice(price) {
    const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&.');
    return formattedPrice.substring(0, formattedPrice.length - 4) + ".000 đ";
  }

  let prices = document.querySelectorAll(".current_prefix");
  prices.forEach((priceElement) => {
    let price = parseFloat(priceElement.textContent.trim());
    let formattedPrice = formatPrice(price);
    priceElement.textContent = formattedPrice;
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
















