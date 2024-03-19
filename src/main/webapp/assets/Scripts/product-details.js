// document.getElementById('addProduct').addEventListener('click', validateAddProduct);
//
// function validateAddProduct() {
//     var quantity = document.getElementById("quantity").value;
//     var product = JSON.parse(document.getElementById("cartItemsData").value); // Assuming cartItemsData is a JSON string
//
//     // Construct the data object
//     var data = {
//         quantity: quantity,
//         product: product
//     };
//
//     // Send the data as JSON in the request body
//     fetch('front?controller=validateAddProduct', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(data)
//     })
//         .then(response => response.text())
//         .then(data => {
//             console.log(data);
//             if (data === "false") {
//                 document.getElementById("quantityError").textContent =
//                     "Uh-oh! Looks like we don't have enough stock for that quantity. Please choose a lower quantity or contact support for assistance.";
//             } else {
//                 document.querySelector('#quantityError').textContent = '';
//             }
//         })
//         .catch(error => {
//             console.log('An error occurred while checking the quantity:', error);
//         });
// }
