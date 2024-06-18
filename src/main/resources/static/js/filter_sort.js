/*------------------- filter start -------------------*/
// Attach event listeners to checkboxes
var categoryCheckboxes = document.querySelectorAll(".category input");
var colorCheckboxes = document.querySelectorAll(".color input");
var styleCheckboxes = document.querySelectorAll(".style input");
var priceCheckboxes = document.querySelectorAll(".price input");
var categoryLinks = document.querySelectorAll(".category-link");

//Category Filter
for (var i = 0; i < categoryCheckboxes.length; i++) {
  categoryCheckboxes[i].addEventListener("change", function () {
    // Uncheck all other categories when one category is selected
    if (this.checked) {
      for (var j = 0; j < categoryCheckboxes.length; j++) {
        if (categoryCheckboxes[j] !== this) {
          categoryCheckboxes[j].checked = false;
        }
      }
    }
    filter();
  });
}

//Color Filter
for(var i = 0; i < colorCheckboxes.length; i++) {
  colorCheckboxes[i].addEventListener("change", filter);
}

// Style filter
for (var i = 0; i < styleCheckboxes.length; i++) {
  styleCheckboxes[i].addEventListener("change", filter);
}

// Price filter
for (var i = 0; i < priceCheckboxes.length; i++) {
  priceCheckboxes[i].addEventListener("change", filter);
}

// Category links
for (var i = 0; i < categoryLinks.length; i++) {
  categoryLinks[i].addEventListener("click", function (event) {
    event.preventDefault();
    var category = this.getAttribute("data-category");
    window.location.href = "category.html?category=" + category; // Redirect to the filtered page
  });
}

window.addEventListener("load", readUrlParameters);


filter();

function readUrlParameters() {
  var params = new URLSearchParams(window.location.search);
  var category = params.get("category");
  if (category) {
    var categoryInput = document.querySelector(`.category input[value="${category}"]`);
    if (categoryInput) {
      categoryInput.checked = true;
      // Uncheck all other categories
      for (var j = 0; j < categoryCheckboxes.length; j++) {
        if (categoryCheckboxes[j] !== categoryInput) {
          categoryCheckboxes[j].checked = false;
        }
      }
    }
  }
  filter();
}

function filter() {
  // Get selected category
  var selectedCategory = document.querySelector(".category input:checked").value;

  // Get selected colors
  var selectedColors = [];
  var colorCheckbox;
  for (var i = 0; i < colorCheckboxes.length; i++) {
    colorCheckbox = colorCheckboxes[i];
    if (colorCheckbox.checked) {
      selectedColors.push(colorCheckbox.value);
    }
  }

  // Get selected styles
  var selectedStyles = [];
  var styleCheckbox;
  for (var i = 0; i < styleCheckboxes.length; i++) {
    styleCheckbox = styleCheckboxes[i];
    if (styleCheckbox.checked) {
      selectedStyles.push(styleCheckbox.value);
    }
  }

  // Get selected price ranges
  var selectedPriceRanges = [];
  for (var i = 0; i < priceCheckboxes.length; i++) {
    if (priceCheckboxes[i].checked) {
      selectedPriceRanges.push(priceCheckboxes[i].value);
    }
  }

  // Filter items
  var items = document.querySelectorAll(".product_filter");
  var count = 0;

  for (i = 0; i < items.length; i++) {
    var item = items[i];
    var showCategory = (selectedCategory === "all") || item.classList.contains(selectedCategory);
    var showColor = (selectedColors.length === 0) || selectedColors.some(color => item.classList.contains(color));
    var showStyle = (selectedStyles.length === 0) || selectedStyles.some(style => item.classList.contains(style));
    var itemPrice = parseInt(item.querySelector(".product_price").textContent, 10);
    var showPrice = (selectedPriceRanges.length === 0) || selectedPriceRanges.some(range => isPriceInRange(itemPrice, range));

    if (showCategory && showColor && showStyle && showPrice) {
      item.classList.add("show");
      item.classList.remove("hide");
      count++;
    } else {
      item.classList.add("hide");
      item.classList.remove("show");
    }
  }

  // Update product count founded
  document.getElementById("total_product_founded").textContent = count;
}

function isPriceInRange(price, range) {
  var [min, max] = range.split("-").map(Number);
  return price >= min && price <= max;
}

//search in filter
// Function to remove Vietnamese diacritics
function removeDiacritics(str) {
  return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

document.getElementById('categorySearchFilter').addEventListener('keyup', function() {
  var filter = removeDiacritics(this.value.toLowerCase());
  var items = document.querySelectorAll('.category_menu li');
  items.forEach(function(item) {
    var text = removeDiacritics(item.textContent.toLowerCase());
    if (text.indexOf(filter) === -1) {
      item.style.display = 'none';
    } else {
      item.style.display = 'flex';
    }
  });
});

document.getElementById('styleSearchFilter').addEventListener('keyup', function() {
  var filter = removeDiacritics(this.value.toLowerCase());
  var items = document.querySelectorAll('.style_menu li');
  items.forEach(function(item) {
    var text = removeDiacritics(item.textContent.toLowerCase());
    if (text.indexOf(filter) === -1) {
      item.style.display = 'none';
    } else {
      item.style.display = 'flex';
    }
  });
});

document.getElementById('colorSearchFilter').addEventListener('keyup', function() {
  var filter = removeDiacritics(this.value.toLowerCase());
  var items = document.querySelectorAll('.color_menu li');
  items.forEach(function(item) {
    var text = removeDiacritics(item.textContent.toLowerCase());
    if (text.indexOf(filter) === -1) {
      item.style.display = 'none';
    } else {
      item.style.display = 'flex';
    }
  });
});

/*------------------- filter end -------------------*/



/*------------------- sort start -------------------*/

// Attach event listener to the sort select element
var sortSelect = document.getElementById("sort_select");
sortSelect.addEventListener("change", function(event) {
    event.preventDefault(); // Prevent default action
    sortProducts(); // Call the sorting function
});

// Define the sort function
function sortProducts() {
  var selectedOption = sortSelect.value;

  // Get all product items
  var productItems = document.querySelectorAll(".product_filter.show");
  
  // Convert NodeList to an array for easier manipulation
  var productArray = Array.from(productItems);

  // Sort products based on the selected option
  switch (selectedOption) {
    
    case "1": // A ➔ Z (Product Name)
      productArray.sort((a, b) => a.querySelector(".product_title a").textContent.localeCompare(b.querySelector(".product_title a").textContent));
      break;
    case "2": // Z ➔ A (Product Name)
      productArray.sort((a, b) => b.querySelector(".product_title a").textContent.localeCompare(a.querySelector(".product_title a").textContent));
      break;
    case "3": // Price Increase
      productArray.sort((a, b) => parseFloat(a.querySelector(".product_price").textContent.replace(/\./g, '')) - parseFloat(b.querySelector(".product_price").textContent.replace(/\./g, '')));
      break;
    case "4": // Price Decrease
      productArray.sort((a, b) => parseFloat(b.querySelector(".product_price").textContent.replace(/\./g, '')) - parseFloat(a.querySelector(".product_price").textContent.replace(/\./g, '')));
      break;
    default:
      break;
  }

  // Re-append sorted product items
  var parentElement = document.querySelector(".latest_product_inner");
  parentElement.innerHTML = "";
  productArray.forEach(item => parentElement.appendChild(item));
}

// Initial sorting
sortProducts();

/*------------------- sort end -------------------*/