<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/navbar.css">
    <link rel="stylesheet" href="./resources/css/product-details.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./product.js"></script>

    <title>Product Page</title>
</head>

<body>
    <header>
        <div class="nav-bar-container">
            <ul class="nav-bar">
                <li id="navbar-title" class="nav-bar-title">Product Page</li>
                <li class="tab"><a href="./index.jsp">Home</a></li>
                <li class="tab"><a href="./product-list">Products</a></li>
                <li class="tab"><a href="./team">The Team</a></li>
            </ul>
        </div>
    </header>

    <div class="content-container">

        <div class="product-container">
            <div class="top-product-description">
                <div class="product-name"></div>
                <div class="brand"></div>
                <div class="price"></div>
            </div>

            <div class="product-img-container">
                <img id="product-img0" alt="Product Image">

                <img id="product-img1">
                <img id="product-img2">
                <img id="product-img3">
            </div>

            <div class="side-product-description">
                <div class="product-name"></div>
                <div class="brand"></div>
                <div class="price"></div>
                <div class="reviews"></div>

                <form action="./checkout.jsp">
                    <input type="submit" value="Add to Cart"></button>
                </form>

                <div class="description"></div>
            </div>

            <div id="reviews"></div>
            <div id="description"></div>

        </div>

        <footer>
            Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen
        </footer>

    </div>

    <script type="text/javaScript">
        document.getElementsByClassName("product-name")[0].innerHTML = localStorage["productDesc0"];
        
        document.getElementById("product-img0").src = localStorage["productImages0"]
        document.getElementById("product-img1").src = localStorage["productImages1"];
        document.getElementById("product-img2").src = localStorage["productImages2"];
        document.getElementById("product-img3").src = localStorage["productImages3"];

        document.getElementsByClassName("brand")[0].innerHTML = localStorage["productDesc1"];
        document.getElementsByClassName("price")[0].innerHTML = localStorage["productDesc2"];

        document.getElementsByClassName("product-name")[1].innerHTML = localStorage["productDesc0"];
        document.getElementsByClassName("brand")[1].innerHTML = localStorage["productDesc1"];
        document.getElementsByClassName("price")[1].innerHTML = localStorage["productDesc2"];
        document.getElementsByClassName("reviews")[0].innerHTML = localStorage["productDesc3"];
        document.getElementsByClassName("description")[0].innerHTML = localStorage["productDesc4"];
        // document.getElementsByClassName("reviews")[1].innerHTML = localStorage["productDesc3"];
        // document.getElementsByClassName("description")[1].innerHTML = localStorage["productDesc4"];
        // document.getElementById("side-reviews").innerHTML = localStorage["productDesc3"];
    </script>
</body>

</html>