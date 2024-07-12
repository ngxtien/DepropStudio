document.addEventListener("DOMContentLoaded", function () {
    function formatPrice(price) {
        const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&.');
        return formattedPrice.substring(0, formattedPrice.length - 4) + "đ";
    }

    let prices = document.querySelectorAll(".totalprice");
    prices.forEach((priceElement) => {
        let price = parseFloat(priceElement.textContent.trim());
        let formattedPrice = formatPrice(price);
        priceElement.textContent = formattedPrice;
    });
});
