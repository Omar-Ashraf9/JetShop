function login(event) {
  event.preventDefault();
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var data = new URLSearchParams();
  var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
  var productIds = cartItems.map((item) => item.productId);
  var quantities = cartItems.map((item) => item.quantity);
  data.append("email", email);
  data.append("password", password);
  data.append("productIds", JSON.stringify(productIds)); // Convert to JSON string before sending
  data.append("quantities", JSON.stringify(quantities)); // Convert to JSON string before sending
  fetch("front?controller=login", {
    method: "POST",
    body: data,
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Product added to cart:", data);

      if(data=="please enter a correct email and password"){
        document.getElementById("passwordError").innerText = data;
        return;
      }
      data.forEach((productData) => {
        // Create a product object from the response
        var product = {
          productId: productData.productId,
          productName: productData.productName,
          productPrice: productData.productPrice,
          productDescription: productData.productDescription,
          productImage: productData.productImage,
          quantity: productData.productQuantity, // You may adjust the quantity as needed
        };

        // Add the product to cartItems
        cartItems.push(product);
        document.getElementById("passwordError").innerText = '';
        console.log("Product added to cart:", product);
      });
      // Update cartItems in localStorage
      localStorage.setItem("cartItems", JSON.stringify(cartItems));
        var url = "front?";
         if(data!="please enter a correct email and password"){
            window.location.href = url;
            updateCount();
            loadProductsToCart();
         }
    })
    .catch((error) => {
      console.log(
        "An error occurred while adding the product to the cart:",
        error
      );
    });
}
