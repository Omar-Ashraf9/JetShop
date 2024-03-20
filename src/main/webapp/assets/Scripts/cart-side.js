function loadProductsToCart() {
  var cartProducts = localStorage.getItem("cartItems");
  if (cartProducts) {
    var products = JSON.parse(cartProducts);
    var cartList = document.querySelector(".header-cart-wrapitem");
    cartList.innerHTML = ""; // Clear existing content
    var totalPrice = 0;
    products.forEach(function (product) {
      var listItem = document.createElement("li");
      listItem.classList.add("header-cart-item", "flex-w", "flex-t", "m-b-12");

      var itemImage = document.createElement("div");
      itemImage.classList.add("header-cart-item-img");
      var img = document.createElement("img");
      img.src = product.image;
      img.alt = "Product Image";
      itemImage.appendChild(img);

      var itemText = document.createElement("div");
      itemText.classList.add("header-cart-item-txt", "p-t-8");
      var itemName = document.createElement("a");
      itemName.href = "#";
      itemName.classList.add(
        "header-cart-item-name",
        "m-b-18",
        "hov-cl1",
        "trans-04"
      );
      itemName.textContent = product.name;
      var itemInfo = document.createElement("span");
      itemInfo.classList.add("header-cart-item-info");
      itemInfo.textContent = product.quantity + " x " + product.price;
      totalPrice += product.quantity * product.price;

      listItem.addEventListener("click", function () {
        var productId = product.productId;
        console.log(productId);
        var url = "front?controller=productDetail&productId=" + productId;

        // Make AJAX call to servlet using fetch API
        window.location.href = url;
      });

      itemText.appendChild(itemName);
      itemText.appendChild(itemInfo);

      listItem.appendChild(itemImage);
      listItem.appendChild(itemText);

      cartList.appendChild(listItem);
    });
    // Update total price element
    var totalPriceElement = document.querySelector(".header-cart-total");
    totalPriceElement.textContent = "Total: $" + totalPrice.toFixed(2); // Format total price to 2 decimal places
  }
}

document.addEventListener("DOMContentLoaded", function () {
  loadProductsToCart();
});
