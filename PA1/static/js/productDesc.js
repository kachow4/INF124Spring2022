function formValidation() {
    console.log("Beginning of validation");
    
    // let quantity = document.cartForm.quantity;
    // console.log(quantity.value);
    
    // if(!(parseInt(quantity.value)>0)){
    //     alert("Invalid. Please enter a number less than 10.")
    // }
    // else if(parseInt(quantity.value) > 10){
    //     alert("Sorry! You can't order more than 10 of this item. Please enter a number less than 10.")
    //     return false;
    // }

    // FIRST NAME
    let firstName = document.cartForm.firstName;
    console.log(firstName.value);
    
    if(parseInt(firstName.value)){
        alert("Invalid. First Names cannot include numbers.")
    }

    // LAST NAME
    let lastName = document.cartForm.lastName;
    console.log(lastName.value);
    
    if(parseInt(lastName.value)){
        alert("Invalid. Last Names cannot include numbers.")
    }
    // STREET ADDRESS
    let streetAddress = document.cartForm.streetAddress;
    console.log(streetAddress.value);

    const validStreetAddress=/\d{1,5}\s\w+(\s[a-zA-Z]+(.?))?/;
    
    if(streetAddress.value == ""){
        alert("Invalid. Please enter your street address.");
    }
    else if(!validStreetAddress.test(streetAddress.value)){
        alert("Invalid. Please enter a street address with the following format: A 1-5 digit number followed by your abbreviated street name.")
    }
    
    // CITY
    let city = document.cartForm.city;
    console.log("Testing City Input: ", city.value);
    // const validCity=/^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))[a-zA-Z\u0080-\u024F]$/;
    const validCity=/^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$/;
    if(city.value == ""){
        alert("Invalid. Please enter your city.");
    }
    else if(!validCity.test(city.value)){
        alert("Invalid. Please enter a valid city.")
    }

    // STATE
    let state = document.cartForm.state;


    //ZIPCODE
    let zipcode = document.cartForm.zipcode;
    console.log("Testing zipcode Input: ", zipcode.value);
    const validZip=/^\d{5}(?:[-\s]\d{4})?$/;
    if(zipcode.value == ""){
        alert("Invalid. Please enter your zipcode.");
    }
    else if(!validZip.test(zipcode.value)){
        alert("Invalid. Please enter a valid zipcode.")
    }

    //EMAIL
    let email = document.cartForm.email;
    // const validEmail=/(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;
    const validEmail=/^\S+@\S+\.\S+$/;
    if(email.value == ""){
        alert("Invalid. Please enter your email.");
    }
    else if(!validEmail.test(email.value)){
        alert("Invalid. Please enter a valid email.")
    }

    //PHONE NUMBER
    let phone = document.cartForm.phone_number;
    const validPhone=/^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;
    if(phone.value == ""){
        alert("Invalid. Please enter your phone number.");
    }
    else if(!validPhone.test(phone.value)){
        alert("Invalid. Please enter a valid phone number.")
    }

    //CARD NUMBER
    let card = document.cartForm.card_number;
    const validCard=/\b\d{4}(| |-)\d{4}\1\d{4}\1\d{4}\b/;
    if(card.value == ""){
        alert("Invalid. Please enter your card number.");
    }
    else if(!validCard.test(card.value)){
        alert("Invalid. Please enter a valid card number.")
    }

    //EXPIRATION DATE
    let date = document.cartForm.expiration_date;
    const validDate=/^(0[1-9]|1[0-2])\/?([0-9]{4}|[0-9]{2})$/;
    if(date.value == ""){
        alert("Invalid. Please enter your card expiration date.");
    }
    else if(!validDate.test(date.value)){
        alert("Invalid. Please enter a valid card expiration date.")
    }

    //SECURITY CODE
    let code = document.cartForm.security_code;
    const validCode=/^[0-9]{3,4}$/;
    if(code.value == ""){
        alert("Invalid. Please enter your card secuirty code.");
    }
    else if(!validCode.test(code.value)){
        alert("Invalid. Please enter a valid card secuirty code.")
    }
}