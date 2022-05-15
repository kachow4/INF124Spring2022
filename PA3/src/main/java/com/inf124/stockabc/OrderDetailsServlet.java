package com.inf124.stockabc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "order-details", value = "/order-details")
public class OrderDetailsServlet extends HttpServlet {
    Connection od_conn;
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
            od_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // GRAB THE CART IN THE CURRENT SESSION
        HttpSession session = req.getSession(true);
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

        // GRAB DATA FROM THE CHECKOUT FORM
        String first_name = req.getParameter("firstName");
        String last_name = req.getParameter("lastName");
        String street_address = req.getParameter("streetAddress");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zipcode = req.getParameter("zipcode");
        String shipping_speed = req.getParameter("shippingSpeed");
        String email = req.getParameter("email");
        String phone_number = req.getParameter("phoneNumber");
        String card_type = req.getParameter("paymentMethod");
        String card_number = req.getParameter("cardNumber");
        String expiration_date = req.getParameter("expirationDate");
        String security_code = req.getParameter("securityCode");

        // SHOW NAV BAR
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +

                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                " <link rel='stylesheet' href='./resources/css/order-details.css'>" +
                "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");

        writer.println("<title>Product Added</title>" +
                "</head>" +

                "<body>" +
                "    <header>" +
                "        <div class='nav-bar-container'>" +
                "           <ul class='nav-bar'>" +
                "               <li id='navbar-title' class='nav-bar-title'>Product order</li>" +
                "                <li class='tab'><a href='./index.html'>Home</a></li>" +
                "                <li class='tab'><a href='productList.jsp'>Products</a></li>" +
                "                <li class='tab'><a href='team.jsp'>The Team</a></li>" +
                "                <li class='tab'><a href='checkout.jsp'>Cart</a></li>" +
                "            </ul>" +
                "        </div>" +
                "    </header>");

        // PRINT THE SUCCESS MESSAGE
        writer.println("<div class='content-container'>" +

                "<form action='./index.html'>" +
                "  <input type='submit' value='Back to Home Page'>" +
                "</form>" +

                "<h2>Your order was successfully submitted!</h2>" +

                "<div class='order-details'>" +
                "    <div >First Name: " + first_name + "</div>" +
                "     <div >Last Name: " + last_name + "</div>" +
                "     <div >Street Address: " + street_address + "</div>" +
                "     <div >City: " + city + "</div>" +
                "     <div >State: " + state + "</div>" +
                "     <div >Zipcode: " + zipcode + "</div>" +
                "     <div >Shipping Speed: " + shipping_speed + "</div>" +
                "     <div >Email: " + email + "</div>" +
                "     <div >Phone Number: " + phone_number + "</div>" +
                "     <div >Payment Method: " + card_type + "</div>" + card_type +
                "     <div >Card Number: " + card_number + " </div>" +
                "     <div >Expiration Date: " + expiration_date + "</div>" +
                "     <div >Security Code: " + security_code + "</div>" +
                " </div>" +

                " </div>");

        writer.println("<h1>Your Order Items</h1>" +
                "<hr>" +
                "<div class='products-container'>");

        // save the total price of the cart
        double total = 0;

        // show the current cart and calculate the total price
        try {
            for (int i = 0; i < cart.size(); i++) {
                PreparedStatement od_stmt = od_conn
                        .prepareStatement("SELECT * FROM products WHERE product_id = ?");

                od_stmt.setString(1, cart.get(i));
                ResultSet od_rs = od_stmt.executeQuery();

                while (od_rs.next()) {
                    String product_name = od_rs.getString("product_name");
                    String product_brand = od_rs.getString("product_brand");
                    String product_price = od_rs.getString("product_price");
                    String img_path_1 = od_rs.getString("img_path_one");

                    total += Double.parseDouble(product_price);

                    writer.println(
                            "<div class='product'>" +
                                    "<div class='product-imgs'>" +
                                    "<img src='" + img_path_1
                                    + "' class='product-img'>" +
                                    "</div>" +
                                    "<div class='product-description'>" +
                                    "<div class='product-name'>" + product_name
                                    + "</div>" +
                                    "<div class='product-type'>" + product_brand
                                    + "</div>" +
                                    "<div class='product-price'>" + product_price
                                    + "</div>" +
                                    "<div class='product-review'>78 reviews</div>" +
                                    "</div>" +
                                    "</div>");
                }

                od_rs.close();
                od_stmt.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // form to submit an order
        writer.println("</div>");

        cart.clear();
        session.setAttribute("cart", cart);

        writer.println("<footer>" +
                "            Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen" +
                "        </footer>" +
                "    </div>" +
                "</body>" +
                "</html>");
    }

    public void destroy() {
        try {
            od_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
