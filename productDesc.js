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

    // STATE

    //ZIPCODE

    //EMAIL

    //PHONE NUMBER

    //CARD NUMBER

    //EXPIRATION DATE

    //SECURITY CODE
}