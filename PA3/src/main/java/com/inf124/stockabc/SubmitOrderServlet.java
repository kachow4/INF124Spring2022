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
import java.sql.SQLException;
import java.util.ArrayList;

// this servlet updates the database upon form submission and forwards() to order details page
@WebServlet(name = "submit-order", value = "/submit-order")
public class SubmitOrderServlet extends HttpServlet {
    Connection order_conn;
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
            order_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the POST request has been made to /product-order");

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
                "    <link rel='stylesheet' href='./resources/css/submit-order.css'>" +
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

        if (!cart.isEmpty()) {
            // INSERT CART ITEMS AND SHIPPING INFO INTO SQL DATABASE BUILD THE QUERY
            try {
                PreparedStatement order_stmt = order_conn
                        .prepareStatement(
                                "INSERT INTO orders (order_items, num_items, first_name, last_name, street_address, city, state_address, zipcode, shipping_speed, email, phone_number, card_type, card_number, expiration_date, security_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                String cartString = String.join(", ", cart);
                order_stmt.setString(1, cartString);
                order_stmt.setInt(2, cart.size());
                order_stmt.setString(3, first_name);
                order_stmt.setString(4, last_name);
                order_stmt.setString(5, street_address);
                order_stmt.setString(6, city);
                order_stmt.setString(7, state);
                order_stmt.setString(8, zipcode);
                order_stmt.setString(9, shipping_speed);
                order_stmt.setString(10, email);
                order_stmt.setString(11, phone_number);
                order_stmt.setString(12, card_type);
                order_stmt.setString(13, card_number);
                order_stmt.setString(14, expiration_date);
                order_stmt.setInt(15, Integer.valueOf(security_code));

                // RUN THE QUERY
                order_stmt.executeUpdate();

                // CLOSE THE PREPARED STATEMENT
                order_stmt.close();

            } catch (NumberFormatException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // successfuly submission --> forward to order details page
            RequestDispatcher orderDetails = req.getRequestDispatcher("order-details");
            orderDetails.forward(req, resp);
        } else {
            writer.print("" +
                    "<div class='message'>" +
                    "<h2>Your cart is empty! Add products to your cart before submitting!</h2>" +
                    "<form action='./productList.jsp'>" +
                    "<input type='submit' value='Back to Products'>" +
                    "</form></div>");
        }

        writer.println("<footer>" +
                "            Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen" +
                "        </footer>" +
                "    </div>" +
                "</body>" +
                "</html>");
    }

    public void destroy() {
        try {
            order_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
