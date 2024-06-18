/*------------------- addtocart start -------------------*/
document.addEventListener("DOMContentLoaded", function () {
    const addToCartBtn = document.querySelector(".add_to_cart");
    const productQuantityInput = document.querySelector(".product_quantity");
    const cartArea = document.querySelector(".cart_area");
    let productCount = 0;
    let cartData = JSON.parse(localStorage.getItem("cart")) || [];
  
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
  
    function createCartItem(product) {
      const cartItem = document.createElement("div");
      cartItem.classList.add(
        "cart_item",
        "d-flex",
        "justify-content-between",
        "align-items-center"
      );
      cartItem.innerHTML = `
            <img class="product_img" src="${product.image}" alt="${product.name}">
            <div class="product_text d-flex flex-column">
                <div class="product_title">${product.name}</div>
                <div class="subtotal_price">${product.price}</div>
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
        cartArea.appendChild(cartItem);
        productCount += product.quantity;
      });
      updateCartCount();
    }
  
    function handleAddToCart() {
      const productName = document.querySelector(".product_name").textContent;
      const productPrice = document.querySelector(".product_price").textContent;
      const productQuantity = parseInt(productQuantityInput.value);
      const productImage = document.querySelector(".product_img").src;
  
      const existingProductIndex = cartData.findIndex(
        (product) => product.name === productName
      );
  
      if (existingProductIndex !== -1) {
        cartData[existingProductIndex].quantity += productQuantity;
        productCount += productQuantity;
        const existingCartItem = cartArea.children[existingProductIndex];
        const quantityInput = existingCartItem.querySelector(".product_quantity");
        quantityInput.value = cartData[existingProductIndex].quantity;
      } else {
        const product = {
          name: productName,
          price: productPrice,
          quantity: productQuantity,
          image: productImage,
        };
        const cartItem = createCartItem(product);
        cartArea.appendChild(cartItem);
        cartData.push(product);
        productCount += productQuantity;
      }
  
      updateCartCount();
      updateLocalStorage();
    }
  
    function handleCartItemEvents(event) {
      const target = event.target;
      const cartItem = target.closest(".cart_item");
      if (!cartItem) return;
  
      const input = cartItem.querySelector(".input-number");
      const itemName = cartItem.querySelector(".product_title").textContent;
      const productIndex = cartData.findIndex(
        (product) => product.name === itemName
      );
  
      if (
        target.classList.contains("number-decrement") ||
        target.classList.contains("ti-minus")
      ) {
        if (parseInt(input.value) > 1) {
          input.value--;
          productCount--;
          cartData[productIndex].quantity--;
        }
      } else if (
        target.classList.contains("number-increment") ||
        target.classList.contains("ti-plus")
      ) {
        input.value++;
        productCount++;
        cartData[productIndex].quantity++;
      } else if (
        target.classList.contains("remove_item") ||
        target.classList.contains("far")
      ) {
        productCount -= parseInt(input.value);
        cartItem.remove();
        cartData.splice(productIndex, 1);
      }
  
      updateCartCount();
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
  /*------------------- addtocart end -------------------*/