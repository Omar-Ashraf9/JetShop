var cartCount = 0;
function addToCartWhenLogin(id, quantity) {
  var cartMessage = document.getElementById("cartMessage");
  console.log(id);

  // Retrieve existing cart items from local storage or initialize an empty array
  var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

  // Add the new product ID to the cart items array if it doesn't already exist
  if (!cartItems.includes(id)) {
    cartItems.push(id);
  }

  // Save the updated cart items array back to local storage
  localStorage.setItem("cartItems", JSON.stringify(cartItems));

  addCartItemToDB(id);
}

function addCartItemToDB(id) {
  var data = new URLSearchParams();
  data.append("productId", id);

  fetch("front?controller=addToCart", {
    method: "POST",
    body: data,
  })
    .then((response) => response.text())
    .then((data) => {
      console.log(data);
      if (data == "false") {
        console.log("out of stock");
        cartMessage.innerText = "Sorry it is out of stock";
      } else {
        cartCount++;
        var nameProduct = $("#addToCartButton")
          .closest(".product-container")
          .find(".js-name-detail")
          .text();
        swal(nameProduct, "is added to cart !", "success");
        console.log("done");
      }
    })
    .catch((error) => {
      console.log(
        "An error occurred while adding the product to the cart:",
        error
      );
    });
}

function handleQuantityChange(selectElement, productId) {
  var selectedQuantity = selectElement.value;
  var data = new URLSearchParams();
  data.append("quantity", selectedQuantity);
  data.append("productId", productId);

  fetch("front?controller=updateQuantity", {
    method: "POST",
    body: data,
  })
    .then((response) => response.text())
    .catch((error) => {
      console.log("An error occurred while updating quantity:", error);
    });
}
