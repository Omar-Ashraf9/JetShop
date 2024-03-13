

// Function to validate name
function validateName() {
    var name = document.getElementById('name').value;
    var nameError = document.getElementById('nameError');
    var regex = /^[a-zA-Z\s]+$/;

    if (!regex.test(name)) {
        nameError.textContent = 'Name must contain characters only.';
        return false;
    } else {
        nameError.textContent = '';
        return true;
    }
}

// Function to validate birthdate
function validateBirthdate() {
    var birthdate = document.getElementById('birthdate').value;
    var birthdateError = document.getElementById('birthdateError');

    if (birthdate === '') {
        birthdateError.textContent = 'Birthdate must not be empty.';
        return false;
    } else {
        birthdateError.textContent = '';
        return true;
    }
}

// Function to validate password
function validatePassword() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirm_password').value;
    var passwordError = document.getElementById('passwordError');
    var regex = /^(?=.*\d).{8,}$/;

    if (!regex.test(password)) {
        passwordError.textContent = 'Password must be at least 8 characters long and contain numbers.';
        return false;
    } else if (password !== confirmPassword) {
        passwordError.textContent = 'Password and confirmation password must match.';
        return false;
    } else {
        passwordError.textContent = '';
        return true;
    }
}

// Function to validate city, country, and streetName
function validateText(id) {
    var text = document.getElementById(id).value;
    var textError = document.getElementById(id + 'Error');
    var regex = /^[a-zA-Z\s]+$/;

    if (!regex.test(text)) {
        textError.textContent = id.charAt(0).toUpperCase() + id.slice(1) + ' must contain characters only.';
        return false;
    } else {
        textError.textContent = '';
        return true;
    }
}

// Function to validate streetNumber
function validateNumber() {
    var number = document.getElementById('streetNumber').value;
    var numberError = document.getElementById('streetNumberError');
    var regex = /^[0-9]+$/;

    if (!regex.test(number)) {
        numberError.textContent = 'Street Number must contain numbers only.';
        return false;
    } else {
        numberError.textContent = '';
        return true;
    }
}

// Add event listeners to the form fields
document.getElementById('name').addEventListener('blur', validateName);
document.getElementById('birthdate').addEventListener('blur', validateBirthdate);
document.getElementById('password').addEventListener('blur', validatePassword);
document.getElementById('confirm_password').addEventListener('blur', validatePassword);
document.getElementById('city').addEventListener('blur', function() { validateText('city'); });
document.getElementById('country').addEventListener('blur', function() { validateText('country'); });
document.getElementById('streetName').addEventListener('blur', function() { validateText('streetName'); });
document.getElementById('streetNumber').addEventListener('blur', validateNumber);