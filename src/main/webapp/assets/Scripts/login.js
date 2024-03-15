function login(){

    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;



    var data = {
        email: email,
        password: password,
    };

    // Convert the object to a JSON string
    var jsonData = JSON.stringify(data);

    // Log the JSON data
    console.log('JSON data:', jsonData);

    // Send the JSON string as the body of a POST request
    fetch('front?controller=login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: jsonData
    })
        .then(response => {
            console.log('Status:', response.status);
            return response.text();
        });
}