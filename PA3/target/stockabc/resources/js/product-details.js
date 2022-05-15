function formValidation() {

    // FIRST NAME
    let firstName = document.orderForm.firstName;

    if (parseInt(firstName.value)) {
        alert("Invalid. First Names cannot include numbers.")
        return false;
    }

    // LAST NAME
    let lastName = document.orderForm.lastName;

    if (parseInt(lastName.value)) {
        alert("Invalid. Last Names cannot include numbers.")
        return false;
    }
    // STREET ADDRESS
    let streetAddress = document.orderForm.streetAddress;


    const validStreetAddress = /\d{1,5}\s\w+(\s[a-zA-Z]+(.?))?/;

    if (streetAddress.value == "") {
        alert("Invalid. Please enter your street address.");
        return false;
    }
    else if (!validStreetAddress.test(streetAddress.value)) {
        alert("Invalid. Please enter a street address with the following format: A 1-5 digit number followed by your abbreviated street name.")
        return false;
    }

    // CITY
    let city = document.orderForm.city;

    const validCity = /^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$/;
    if (city.value == "") {
        alert("Invalid. Please enter your city.");
        return false;
    }
    else if (!validCity.test(city.value)) {
        alert("Invalid. Please enter a valid city.");
        return false;
    }

    // STATE
    let state = document.orderForm.state;


    //ZIPCODE
    let zipcode = document.orderForm.zipcode;

    const validZip = /^\d{5}(?:[-\s]\d{4})?$/;
    if (zipcode.value == "") {
        alert("Invalid. Please enter your zipcode.");
        return false;
    }
    else if (!validZip.test(zipcode.value)) {
        alert("Invalid. Please enter a valid zipcode.");
        return false;
    }

    //EMAIL
    let email = document.orderForm.email;

    const validEmail = /^\S+@\S+\.\S+$/;
    if (email.value == "") {
        alert("Invalid. Please enter your email.");
        return false;
    }
    else if (!validEmail.test(email.value)) {
        alert("Invalid. Please enter a valid email.");
        return false;
    }

    //PHONE NUMBER
    let phone = document.orderForm.phoneNumber;

    const validPhone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;
    if (phone.value == "") {
        alert("Invalid. Please enter your phone number.");
        return false;
    }
    else if (!validPhone.test(phone.value)) {
        alert("Invalid. Please enter a valid phone number.");
        return false;
    }

    let paymentMethod = document.orderForm.paymentMethod;


    //CARD NUMBER
    let card = document.orderForm.cardNumber;

    const validCard = /\b\d{4}(| |-)\d{4}\1\d{4}\1\d{4}\b/;
    if (card.value == "") {
        alert("Invalid. Please enter your card number.");
        return false;
    }
    else if (!validCard.test(card.value)) {
        alert("Invalid. Please enter a valid card number.")
        return false;
    }

    //EXPIRATION DATE
    let date = document.orderForm.expirationDate;
    const validDate = /^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$/;
    if (date.value == "") {
        alert("Invalid. Please enter your card expiration date.");
        return false;
    }
    else if (!validDate.test(date.value)) {
        alert("Invalid. Please enter a valid card expiration date.");
        return false;
    }

    //SECURITY CODE
    let code = document.orderForm.securityCode;
    const validCode = /^[0-9]{3,4}$/;
    if (code.value == "") {
        alert("Invalid. Please enter your card security code.");
        return false;
    }
    else if (!validCode.test(code.value)) {
        alert("Invalid. Please enter a valid card security code.");
        return false;
    }
}