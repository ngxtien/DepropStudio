document.addEventListener("DOMContentLoaded", function() {
    const cartArea = document.querySelector(".list-group");
    const totalPriceElement = document.querySelector(".total_price");
    const dayCountElement = document.getElementById("dayCount");
    const deliveryFeeElement = document.querySelector(".delivery_fee");
    const totalPaymentElement = document.querySelector(".total_payment");
    let productCount = 0;
    let cartData = JSON.parse(localStorage.getItem("cart")) || [];
    let dayCount = localStorage.getItem("dayCount") || 0;
    const deliveryFee = 50000;


    function formatPrice(price) {
        const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&.');
        return formattedPrice.substring(0, formattedPrice.length - 4) + " đ";
    }

    function updateTotalQuantity() {
        const totalQuantityElements = document.querySelectorAll(".total_quantity");
        totalQuantityElements.forEach((element) => {
            element.textContent = productCount;
        });
    }

    function updateCartCount() {
        updateTotalQuantity();
    }

    function updateTotalPrice() {
        const totalPrice = cartData.reduce((total, product) => {
            return total + (product.price * product.quantity);
        }, 0);
        totalPriceElement.textContent = formatPrice(totalPrice);

        const totalPayment = (totalPrice * dayCount) + deliveryFee;
        totalPaymentElement.textContent = formatPrice(totalPayment);
    }

    function loadCartData() {
        cartData.forEach((product) => {
            const cartItem = document.createElement("li");
            cartItem.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-center", "lh-condensed");
            cartItem.innerHTML = `
                <div class="d-flex align-items-center">
                    <img class="product_img" src="${product.image}" alt="${product.name}" style="height: 35px; width: 35px" />
                    <div>
                        <h6 class="product_name my-0">${product.name}</h6>
                        <small class="text-muted-1">Số lượng: <span class="product_quantity">${product.quantity}</span></small>
                    </div>
                </div>
                <span class="subtotal_price text-muted-1">${formatPrice(product.price * product.quantity)}</span>
            `;
            cartArea.insertBefore(cartItem, cartArea.querySelector(".total_area"));
            productCount += product.quantity;
            console.log(product);
        });

        updateCartCount();
        updateTotalPrice();
        sendCartDataToServer(cartData);

        // Display dayCount
        dayCountElement.textContent = dayCount;
        // Display delivery fee
        deliveryFeeElement.textContent = formatPrice(deliveryFee);
    }

    function sendCartDataToServer(cartData) {
        const dataToSend = { cartData, dayCount }; // Include dayCount in the data to be sent
        fetch('/add-to-cart/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dataToSend),
        })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Đoạn này có thể thực hiện các hành động khác sau khi lưu dữ liệu thành công
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    loadCartData();
});