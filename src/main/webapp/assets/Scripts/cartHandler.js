function addToCartWhenLogin(id) {
    console.log(id);
 // Retrieve existing cart items from local storage or initialize an empty array
        var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

        // Add the new product ID to the cart items array
         if (!cartItems.includes(id))
               // If the ID does not exist, add it to the cart items array
              cartItems.push(id);

        // Save the updated cart items array back to local storage
        localStorage.setItem("cartItems", JSON.stringify(cartItems));

        addCartItemToDB(id);

 }

function addCartItemToDB(id) {

    console.log(id);
    var data = new URLSearchParams();
    data.append('productId', id);

    fetch('front?controller=addToCart', {
        method: 'POST',
        body: data
    })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            if(data=="false") {
                console.log("out of stock")
                //document.getElementById("emailError").textContent = 'Email already exists';
            } else {
                console.log("done");
                //document.querySelector('#emailError').textContent = '';
            }
        })
        .catch(error => {
            console.log('An error occurred while add the product to cart:', error);
        });
}
