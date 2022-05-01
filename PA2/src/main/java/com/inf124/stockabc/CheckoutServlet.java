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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "checkout", value = "/checkout")
public class CheckoutServlet extends HttpServlet {
    Connection recent_conn;
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
            recent_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the POST request has been made to /product-list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /product-list");

        HttpSession session = req.getSession(true);

        if (session.isNew()) {
            String userId = String.valueOf(ThreadLocalRandom.current().nextInt());
        }

        String productId = req.getParameter("id");

        if (session.getAttribute("cart") == null) {
            ArrayList<String> empty_cart = new ArrayList<String>();
            session.setAttribute("cart", empty_cart);
        }

        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +

                "<head>" +

                "<link rel='stylesheet' href='./resources/css/navbar.css'>" +
                "<link rel='stylesheet' href='./resources/css/checkout.css'>" +

                "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +

                "</head>" +

                "<body>" +

                "<header>" +
                "<div class='nav-bar-container'>" +
                "<ul class='nav-bar'>" +
                "<li class='nav-bar-title'>Products</li>" +
                "<li class='tab'><a href='./index.jsp'>Home</a></li>" +
                "<li class='tab'><a href='./product-list'>Products</a></li>" +
                "<li class='tab'><a href='./team'>The Team</a></li>" +
                "<li class='tab'><a href=''>Cart</a></li>" +

                "</ul>" +
                "</div>" +
                "</header>" +

                "<h1>Cart</h1>" +
                "<hr>" +
                "<div class='cart-container'>");

        // writer.println(cart);
        double total = 0;

        if (cart.size() > 0) {
            try {
                for (int i = 0; i < cart.size(); i++) {
                    Statement recent_stmt = recent_conn.createStatement();

                    String recent_query = "SELECT * FROM products WHERE product_id = "
                            + cart.get(i);
                    ResultSet recent_rs = recent_stmt.executeQuery(recent_query);

                    while (recent_rs.next()) {
                        String product_name = recent_rs.getString("product_name");
                        String product_brand = recent_rs.getString("product_brand");
                        String product_price = recent_rs.getString("product_price");

                        total += Double.parseDouble(product_price);

                        writer.println(
                                "<div class='cart'>" +
                                        "<div class='cart-imgs'>" +
                                        "<img src='./images/p1/bluedunks1.jpg' class='cart-img'>" +
                                        "</div>" +
                                        "<div class='cart-description'>" +
                                        "<div class='cart-name'>" + product_name + "</div>" +
                                        "<div class='cart-type'>" + product_brand + "</div>" +
                                        "<div class='cart-price'>" + product_price + "</div>" +
                                        "<div class='cart-review'>78 reviews</div>" +
                                        "</div>" +
                                        "</div>");
                    }

                    recent_rs.close();
                    recent_stmt.close();
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            writer.println("Your cart is currently empty.");
        }

        writer.println("</div>" +

                "<h1>Total: " + total + " </h1>" +

                "<!-- product form -->" +
                "<div class='form-container'>" +
                "   <form action='mailto:' method='POST' enctype='text/plain' id='cart-form' name='cartForm'" +
                "       onsubmit='formValidation()'>" +
                "       <!-- <h2>Checkout Information</h2> -->" +
                "       <div class='form-row'>" +
                "           <div class='form-column shipping-info'>" +
                "               <h3>Shipping Information</h3>" +
                "               <div class='input-field'>" +
                "                   <label for='first-name'>First Name</label><br>" +
                "                   <input id='first-name' name='firstName' type='text' />" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='last-name'>Last Name</label><br>" +
                "                   <input id='last-name' name='lastName' type='text' />" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='street-address'>Street Address</label><br>" +
                "                   <input id='street-address' name='streetAddress' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='city'>City</label><br>" +
                "                   <input id='city' name='city' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='state'>State</label><br>" +
                "                   <input id='state' name='state' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='zipcode'>Zipcode</label><br>" +
                "                   <input id='zipcode' name='zipcode' type='text' /><br>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='shipping-speed'>Shipping Speed</label><br>" +
                "                   <select id='shipping-speed' name='shipping-speed'>" +
                "                       <option>Overnight</option>" +
                "                       <option>2-days Expedited</option>" +
                "                       <option>6-days Ground</option>" +
                "                   </select>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                   <label for='email'>Email</label><br>" +
                "                   <input id='email' name='email' type='text' />" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='phone-number'>Phone Number</label><br>" +
                "                   <input id='phone-number' name='phone-number' type='text' />" +
                "               </div>" +
                "           </div>" +

                "           <div class='form-column payment-info'>" +
                "               <h3>Payment Information</h3>" +
                "               <div class='input-field'>" +
                "                   <label for='card-type'>Card Type</label><br><br>" +
                "                   <div id='card-type' name='card-type'>" +
                "                       <input type='radio' id='credit' name='payment-method' value='Credit'>" +
                "                       <label for='credit'>Credit</label>" +

                "                       <input type='radio' id='debit' name='payment-method' value='Debit'>" +
                "                       <label for='debit'>Debit</label>" +
                "                   </div><br>" +
                "               </div>" +

                "               <div class='input-field'>" +
                "                    <label for='card-number'>Card Number</label><br>" +
                "                   <input id='card-number' name='card-number' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='expiration-date'>Expiration Date</label><br>" +
                "                   <input id='expiration-date' name='expiration-date' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <label for='security-code'>Security Code</label><br>" +
                "                   <input id='security-code' name='security-code' type='text' /><br>" +
                "               </div>" +
                "               <div class='input-field'>" +
                "                   <input type='submit' value='Submit My Order'></button>" +
                "               </div>" +
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
            recent_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
