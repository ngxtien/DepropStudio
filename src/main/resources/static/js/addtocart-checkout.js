

document.addEventListener("DOMContentLoaded", function() {
    const cartArea = document.querySelector(".list-group");
    const totalPriceElement = document.querySelector(".total_price");
    let productCount = 0;
    let cartData = JSON.parse(localStorage.getItem("cart")) || [];


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

    // function updateSubtotalPrice(cartItem, product) {
    //     const subtotalPriceElement = cartItem.querySelector(".subtotal_price");
    //     const newSubtotal = product.price * product.quantity;
    //     subtotalPriceElement.textContent = formatPrice(newSubtotal);
    // }

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
        sendCartDataToServer(cartData);

    }

    function sendCartDataToServer(cartData) {
        fetch('/add-to-cart/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(cartData),
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
