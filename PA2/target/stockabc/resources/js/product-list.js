// get current product information
function handleProductSelect(id) {
    // alert("ID of clicked product: "+id);
    // var test = $('#'+id);

    //get current product Id
    let currentProductId = $('#' + id);

    //save current product image
    // let productImage = currentProductId[0].firstElementChild.src;
    // localStorage["productImage"] = productImage;

    //save current product images
    let productImages = [];
    for (let i = 0; i < 4; i++) {
        productImages.push(currentProductId[0].firstElementChild.children[i].src);
        localStorage["productImages" + i] = currentProductId[0].firstElementChild.children[i].src;
    }

    console.log(productImages)

    console.log("Product Id: ", currentProductId);
    console.log("Product Description: ", currentProductId[0].lastElementChild);
    console.log("Product Description Elements: ", currentProductId[0].lastElementChild.children);

    // parse product description info into an array 
    let productDescriptionInfo = [];

    for (let i = 0; i < 5; i++) {
        productDescriptionInfo.push(currentProductId[0].lastElementChild.children[i].textContent);
        localStorage["productDesc" + i] = currentProductId[0].lastElementChild.children[i].textContent;
    }

    // console.log(productDescriptionInfo);

    //set location to product description page
    location.href = "./product-details";

    // sessionStorage.setItem("productDesc", temp);
    // const yuh = sessionStorage.getItem("productDesc");
    // console.log(yuh[0]);
}