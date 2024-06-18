document.addEventListener("DOMContentLoaded", function() {
    const addToCartBtn = document.querySelector(".add_to_cart");
    const productQuantityInput = document.querySelector(".product_quantity");
    const cartArea = document.querySelector(".cart_area");
    const totalPriceElement = document.querySelector(".total_price");
    let productCount = 0;
    let cartData = JSON.parse(localStorage.getItem("cart")) || [];

    // Function to format price with commas (or dots for some locales) and maintain decimals
    function formatPrice(price) {
        const formattedPrice = price.toFixed(3).replace(/\d(?=(\d{3})+\.)/g, '$&.');
        return formattedPrice.substring(0, formattedPrice.length + 4) + " VND";
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

    function updateLocalStorage() {
        localStorage.setItem("cart", JSON.stringify(cartData));
    }

    function updateSubtotalPrice(cartItem, product) {
        const subtotalPriceElement = cartItem.querySelector(".subtotal_price");
        const newSubtotal = product.price * product.quantity;
        subtotalPriceElement.textContent = formatPrice(newSubtotal);
    }

    function updateTotalPrice() {
        const totalPrice = cartData.reduce((total, product) => {
            return total + (product.price * product.quantity);
        }, 0);
        totalPriceElement.textContent = formatPrice(totalPrice);
    }

    function parsePrice(priceString) {
        // Convert price string to a number, e.g., "100.000đ" to 100000
        return parseFloat(priceString.replace(/[^\d.-]/g, ''));
    }

    function createCartItem(product) {
        const cartItem = document.createElement("div");
        cartItem.classList.add("cart_item", "d-flex", "justify-content-between", "align-items-center");
        cartItem.innerHTML = `
            <img class="product_img" src="${product.image}" alt="${product.name}">
            <div class="product_text d-flex flex-column">
                <div class="product_title">${product.name}</div>
                <div class="subtotal_price">${formatPrice(product.price * product.quantity)}</div>
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
        cartData.forEach((product) => {
            const cartItem = createCartItem(product);
            if (cartArea) cartArea.appendChild(cartItem);
            productCount += product.quantity;
        });
        updateCartCount();
        updateTotalPrice();
    }

    function handleAddToCart() {
        const productName = document.querySelector(".product_name").textContent;
        const productPrice = parsePrice(document.querySelector(".product_price").textContent); // Convert price to number
        const productQuantity = parseInt(productQuantityInput.value);
        const productImage = document.querySelector(".s_product_img img").src;
        const productId = addToCartBtn.getAttribute('data-id');

        const existingProductIndex = cartData.findIndex((product) => product.id === productId);

        if (existingProductIndex !== -1) {
            cartData[existingProductIndex].quantity += productQuantity;
            productCount += productQuantity;
            const existingCartItem = cartArea.children[existingProductIndex];
            const quantityInput = existingCartItem.querySelector(".product_quantity");
            quantityInput.value = cartData[existingProductIndex].quantity;
            updateSubtotalPrice(existingCartItem, cartData[existingProductIndex]);
        } else {
            const product = {
                id: productId,
                name: productName,
                price: productPrice,
                quantity: productQuantity,
                image: productImage,
            };
            const cartItem = createCartItem(product);
            if (cartArea) cartArea.appendChild(cartItem);
            cartData.push(product);
            productCount += productQuantity;
        }

        updateCartCount();
        updateTotalPrice();
        updateLocalStorage();
    }

    function handleCartItemEvents(event) {
        const target = event.target;
        const cartItem = target.closest(".cart_item");
        if (!cartItem) return;

        const input = cartItem.querySelector(".input-number");
        const itemName = cartItem.querySelector(".product_title").textContent;
        const productIndex = cartData.findIndex((product) => product.name === itemName);

        if (target.classList.contains("number-decrement") || target.classList.contains("ti-minus")) {
            if (parseInt(input.value) > 1) {
                input.value--;
                productCount--;
                cartData[productIndex].quantity--;
                updateSubtotalPrice(cartItem, cartData[productIndex]);
            }
        } else if (target.classList.contains("number-increment") || target.classList.contains("ti-plus")) {
            input.value++;
            productCount++;
            cartData[productIndex].quantity++;
            updateSubtotalPrice(cartItem, cartData[productIndex]);
        } else if (target.classList.contains("remove_item") || target.classList.contains("far")) {
            productCount -= parseInt(input.value);
            cartItem.remove();
            cartData.splice(productIndex, 1);
        }

        updateCartCount();
        updateTotalPrice();
        updateLocalStorage();
    }

    if (addToCartBtn) {
        addToCartBtn.addEventListener("click", handleAddToCart);
    }

    if (cartArea) {
        cartArea.addEventListener("click", handleCartItemEvents);
    }

    loadCartData();
});
