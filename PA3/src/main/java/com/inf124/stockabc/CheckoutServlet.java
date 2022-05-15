package com.inf124.stockabc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// This servlet shows the current cart and form to submit an order and includes form validation
@WebServlet(name = "checkout", value = "/checkout")
public class CheckoutServlet extends HttpServlet {
    Connection checkout_conn;
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/stockabc?useSSL=false";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            checkout_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        // create an empty cart if it doesn't already exist
        if (session.getAttribute("cart") == null) {
            ArrayList<String> empty_cart = new ArrayList<String>();
            session.setAttribute("cart", empty_cart);
        }

        // get the current session's cart
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "<link rel='stylesheet' href='./resources/css/navbar.css'>" +
                "<link rel='stylesheet' href='./resources/css/checkout.css'>");

        writer.println("<script type='text/javascript'>");
        RequestDispatcher dispatcher = req.getRequestDispatcher("./resources/js/product-details.js");
        dispatcher.include(req, resp);

        writer.println(
                "</script><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +

                // navigation bar
                        "</head>" +
                        "<body>" +
                        "<header>" +
                        "<div class='nav-bar-container'>" +
                        "<ul class='nav-bar'>" +
                        "<li class='nav-bar-title'>Products</li>" +
                        "<li class='tab'><a href='./index.html'>Home</a></li>" +
                        "<li class='tab'><a href='./productList.jsp'>Products</a></li>" +
                        "<li class='tab'><a href='./team.jsp'>The Team</a></li>" +
                        "<li class='tab'><a href=''>Cart</a></li>" +
                        "</ul>" +
                        "</div>" +
                        "</header>" +
                        "<h1>Cart</h1>" +
                        "<hr>" +
                        "<div class='cart-container'>");

        // save the total price of the cart
        double total = 0;

        // show the current cart and calculate the total price
        if (cart.size() > 0) {
            try {
                for (int i = 0; i < cart.size(); i++) {
                    PreparedStatement checkout_stmt = checkout_conn
                            .prepareStatement("SELECT * FROM products WHERE product_id = ?");

                    checkout_stmt.setString(1, cart.get(i));
                    ResultSet checkout_rs = checkout_stmt.executeQuery();

                    while (checkout_rs.next()) {
                        String product_name = checkout_rs.getString("product_name");
                        String product_brand = checkout_rs.getString("product_brand");
                        String product_price = checkout_rs.getString("product_price");
                        String img_path_1 = checkout_rs.getString("img_path_one");

                        total += Double.parseDouble(product_price);

                        writer.println(
                                "<div class='cart'>" +
                                        "<div class='cart-imgs'>" +
                                        "<img src='" + img_path_1 + "' class='cart-img'>" +
                                        "</div>" +
                                        "<div class='cart-description'>" +
                                        "<div class='cart-name'>" + product_name + "</div>" +
                                        "<div class='cart-type'>" + product_brand + "</div>" +
                                        "<div class='cart-price'>" + product_price + "</div>" +
                                        "<div class='cart-review'>78 reviews</div>" +
                                        "</div>" +
                                        "</div>");
                    }

                    checkout_rs.close();
                    checkout_stmt.close();
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            writer.println("Your cart is currently empty.");
        }

        // form to submit an order
        writer.println("</div>" +

                "<h1>Total: " + total + " </h1>" +
                "<div class='form-container'>" +
                "   <form action='./submit-order' method='POST' id='order-form' name='orderForm' onsubmit='return formValidation()'>"
                +
                "       <!-- <h2>Checkout Information</h2> -->" +
                "       <div class='form-row'>" +
                "           <div class='form-column shipping-info'>" +
                "               <h3>Shipping Information</h3>" +
                "               <div class='input-field'>" +
                "                   <label for='first-name'>First Name</label><br>" +
                "                   <input id='first-name' name='firstName' type='text' required/>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='last-name'>Last Name</label><br>" +
                "                   <input id='last-name' name='lastName' type='text' required/>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='street-address'>Street Address</label><br>" +
                "                   <input id='street-address' name='streetAddress' type='text' required/><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='city'>City</label><br>" +
                "                   <input id='city' name='city' type='text' required/><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='state'>State</label><br>" +
                "                   <input id='state' name='state' type='text' required/><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='zipcode'>Zipcode</label><br>" +
                "                   <input id='zipcode' name='zipcode' type='text' required /><br>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='shipping-speed'>Shipping Speed</label><br>" +
                "                   <select id='shipping-speed' name='shippingSpeed'>" +
                "                       <option>Overnight</option>" +
                "                       <option>2-days Expedited</option>" +
                "                       <option>6-days Ground</option>" +
                "                   </select>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='email'>Email</label><br>" +
                "                   <input id='email' name='email' type='text' required/>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='phone-number'>Phone Number</label><br>" +
                "                   <input id='phone-number' name='phoneNumber' type='text' required/>" +
                "               </div>" +
                "           </div>" +

                "           <div class='form-column payment-info'>" +
                "               <h3>Payment Information</h3>" +
                "               <div class='input-field'>" +
                "                   <label for='card-type'>Card Type</label><br><br>" +
                "                   <div id='card-type' name='cardType'>" +
                "                       <input type='radio' id='credit' name='paymentMethod' value='Credit' required>" +
                "                       <label for='credit'>Credit</label>" +

                "                       <input type='radio' id='debit' name='paymentMethod' value='Debit'>" +
                "                       <label for='debit'>Debit</label>" +
                "                   </div><br>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                    <label for='card-number'>Card Number</label><br>" +
                "                   <input id='card-number' name='cardNumber' type='text' required/><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='expiration-date'>Expiration Date</label><br>" +
                "                   <input id='expiration-date' name='expirationDate' type='text' required/><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='security-code'>Security Code</label><br>" +
                "                   <input id='security-code' name='securityCode' type='text' required/><br>" +
                "               </div>" +
                "               <input type='submit' value='Submit my Order'>" +
                "           </div>" +
                "       </div>" +
                "  </form>" +
                "</div>" +

                "<footer>" +
                "   Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen" +
                "</footer>" +

                "</body>" +

                "</html>");
    }

    public void destroy() {
        try {
            checkout_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
