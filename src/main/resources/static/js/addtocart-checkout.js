document.addEventListener("DOMContentLoaded", function() {
    const cartArea = document.querySelector(".list-group");
    const totalPriceElement = document.querySelector(".total_price");
    const submitOrderBtn = document.querySelector(".submit_order");
    let productCount = 0;
    let cartData = JSON.parse(localStorage.getItem("cart")) || [];
    const startDate = localStorage.getItem("startDate");
    const endDate = localStorage.getItem("endDate");

    function formatPrice(price) {
        const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&,');
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
        sendCartDataToServer(cartData, startDate, endDate);
    }

    // function displayDates() {
    //     const dateElement = document.querySelector(".date_display");
    //     if (dateElement) {
    //         dateElement.innerHTML = `
    //             <p>Start Date: ${startDate ? startDate : 'Not Set'}</p>
    //             <p>End Date: ${endDate ? endDate : 'Not Set'}</p>
    //         `;
    //     }
    // }

    function sendCartDataToServer(cartData, startDate, endDate) {
        fetch('/check-out/add-to-cart', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ cartData, startDate, endDate }),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });

    }
    const checkoutForm = document.getElementById("checkoutForm");
    checkoutForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Ngăn chặn gửi form theo cách truyền thống
        sendCartDataToServer(cartData, startDate, endDate);
    });

    loadCartData();

});
