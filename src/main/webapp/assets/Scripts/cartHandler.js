var cartCount = 0;
function addToCartWhenLogin(id,quantity) {


    var addToCartButton = document.getElementById("addToCartButton");
    var cartMessage = document.getElementById("cartMessage");


    if (quantity === 0) {
        console.log("out of stock inside the if condition")
        addToCartButton.disabled = true;
        addToCartButton.style.backgroundColor = "#cccccc"; // Change the button's color
        addToCartButton.style.opacity = "0.6"; // Make the button look faded
        cartMessage.innerText = "This product is out of stock";
        return;
    }

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
                //cartMessage.innerText = "Sorry it is out of stock";
            } else {
                cartCount++;
                cartMessage.innerText = "1 item has been successfully added to your cart";

                console.log("done");

            }
        })
        .catch(error => {
            console.log('An error occurred while add the product to cart:', error);
        });
}

function handleQuantityChange(selectElement,productId) {
    var selectedQuantity = selectElement.value;
    var data = new URLSearchParams();
    data.append('quantity',selectedQuantity);
    data.append('productId',productId);
    fetch('front?controller=updateQuantity', {
        method: 'POST',
        body: data
    })
        .then(response => response.text())
        .catch(error => {
            console.log('An error occurred while update quantity:', error);
        });
}