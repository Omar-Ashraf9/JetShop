function addCartToLocalStorage(id) {
 // Retrieve existing cart items from local storage or initialize an empty array
        var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

        // Add the new product ID to the cart items array
         if (!cartItems.includes(id)) 
               // If the ID does not exist, add it to the cart items array
              cartItems.push(id);

        // Save the updated cart items array back to local storage
        localStorage.setItem("cartItems", JSON.stringify(cartItems));
 }
