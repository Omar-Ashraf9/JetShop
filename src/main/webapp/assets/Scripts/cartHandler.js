var cartCount = 0;
function addToCartWhenLogin(
  id,
  productName,
  productPrice,
  productDescription,
  productImage,
  isLogin
) {
  var product = {
    productId: id,
    name: productName,
    price: productPrice,
    description: productDescription,
    image: productImage,
    quantity: 1,
  };

  console.log(product);
  // Retrieve existing cart items from local storage or initialize an empty array
  var nameProduct = $("#addToCartButton")
    .closest(".product-container")
    .find(".js-name-detail")
    .text();
  swal(nameProduct, "is added to cart !", "success");
  var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
  var existingProductIndex = cartItems.findIndex(function (p) {
    return p.productId === id;
  });
  //   // If the product already exists, update its quantity

  if (existingProductIndex !== -1) {
    console.log("terminate because product already exist");
    return;
  }
  cartItems.push(product);

  // Save the updated cart items array back to local storage
  localStorage.setItem("cartItems", JSON.stringify(cartItems));
  loadProductsToCart(); // thios method from side-cart.jsp
  if (isLogin == true) addCartItemToDB(id);
}

function addCartItemToDB(id) {
  var data = new URLSearchParams();
  data.append("productId", id);
  console.log("isnside db method js");
  fetch("front?controller=addToCart", {
    method: "POST",
    body: data,
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
  })
    .then((response) => response.text())
    .then((data) => {
      if (data == "false") {
        console.log("out of stock");
        var cartMessage = document.getElementById("cartMessage");
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


function check_out(){
  fetch("front?controller=checkOut", {
    method: "GET"
  })
      .then((response) => response.text())
      .then((data) => {
        if (data == "Apologies, but your credit limit is insufficient for this order") {
          console.log("credit error");
          var nameProduct1 = $("#check")
              .closest(".product-container")
              .find(".js-name-detail")
              .text();
          swal(nameProduct1,"data","error");
        } else {
          var nameProduct2 = $("#check")
              .closest(".product-container")
              .find(".js-name-detail")
              .text();
          swal(nameProduct2,"data","error");
          console.log("out of stock");
        }
      })
      .catch((error) => {
        console.log("An error occurred while checkout:", error);
      });
}