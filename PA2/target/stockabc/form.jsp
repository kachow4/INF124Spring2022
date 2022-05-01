<!DOCTYPE html>
<html lang="en">

<head>
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./static/css/navbar.css">
    <link rel="stylesheet" href="./static/css/cart.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="./products.js"></script>
</head>

<body>
    <!-- product form -->
    <div class="form-container">
        <form action="mailto:" method="POST" enctype="text/plain" id="cart-form" name="cartForm"
            onsubmit="formValidation()">
            <!-- <h2>Checkout Information</h2> -->
            <div class="form-row">
                <div class="form-column shipping-info">
                    <h3>Shipping Information</h3>
                    <div class="input-field">
                        <label for="first-name">First Name</label><br>
                        <input id="first-name" name="firstName" type="text" />
                    </div>

                    <div class="input-field">
                        <label for="last-name">Last Name</label><br>
                        <input id="last-name" name="lastName" type="text" />
                    </div>

                    <div class="input-field">
                        <label for="street-address">Street Address</label><br>
                        <input id="street-address" name="streetAddress" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <label for="city">City</label><br>
                        <input id="city" name="city" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <label for="state">State</label><br>
                        <input id="state" name="state" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <label for="zipcode">Zipcode</label><br>
                        <input id="zipcode" name="zipcode" type="text" /><br>
                    </div>

                    <div class="input-field">
                        <label for="shipping-speed">Shipping Speed</label><br>
                        <select id="shipping-speed" name="shipping-speed">
                            <option>Overnight</option>
                            <option>2-days Expedited</option>
                            <option>6-days Ground</option>
                        </select>
                    </div>

                    <div class="input-field">
                        <label for="email">Email</label><br>
                        <input id="email" name="email" type="text" />
                    </div>
                    <div class="input-field">
                        <label for="phone-number">Phone Number</label><br>
                        <input id="phone-number" name="phone-number" type="text" />
                    </div>
                </div>

                <div class="form-column payment-info">
                    <h3>Payment Information</h3>
                    <div class="input-field">
                        <label for="card-type">Card Type</label><br><br>
                        <div id="card-type" name="card-type">
                            <input type="radio" id="credit" name="payment-method" value="Credit">
                            <label for="credit">Credit</label>

                            <input type="radio" id="debit" name="payment-method" value="Debit">
                            <label for="debit">Debit</label>
                        </div><br>
                    </div>

                    <div class="input-field">
                        <label for="card-number">Card Number</label><br>
                        <input id="card-number" name="card-number" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <label for="expiration-date">Expiration Date</label><br>
                        <input id="expiration-date" name="expiration-date" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <label for="security-code">Security Code</label><br>
                        <input id="security-code" name="security-code" type="text" /><br>
                    </div>
                    <div class="input-field">
                        <input type="submit" value="Submit My Order"></button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <footer>
        Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen
    </footer>
</body>

</html>