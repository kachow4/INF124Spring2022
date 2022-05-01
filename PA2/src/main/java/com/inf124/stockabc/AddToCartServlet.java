package com.inf124.stockabc;

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

@WebServlet(name = "add--to-cart", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    Connection details_conn;
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
            details_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /product-details");

        HttpSession session = req.getSession(true);

        if (session.isNew()) {
            String userId = String.valueOf(ThreadLocalRandom.current().nextInt());
        }

        String productId = req.getParameter("id");

        ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");

        cart.add(productId);

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +

                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                "    <link rel='stylesheet' href='./resources/css/add-success.css'>" +
                "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");

        writer.println("<title>Product Added</title>" +
                "</head>" +

                "<body>" +
                "    <header>" +
                "        <div class='nav-bar-container'>" +
                "           <ul class='nav-bar'>" +
                "               <li id='navbar-title' class='nav-bar-title'>Product Details</li>" +
                "                <li class='tab'><a href='./index.jsp'>Home</a></li>" +
                "                <li class='tab'><a href='./product-list'>Products</a></li>" +
                "                <li class='tab'><a href='./team'>The Team</a></li>" +
                "                <li class='tab'><a href='./checkout'>Cart</a></li>" +
                "            </ul>" +
                "        </div>" +
                "    </header>");

        try {
            Statement details_stmt = details_conn.createStatement();

            String details_query = "SELECT product_name FROM products WHERE product_id = " + productId;
            ResultSet details_rs = details_stmt.executeQuery(details_query);

            while (details_rs.next()) {
                String product_name = details_rs.getString("product_name");

                writer.println("<div class='content-container'>" +

                        "<h2>This product was successfully added to your cart!</h2>" +

                        "<form action='./product-list'>" +
                        "  <input type='submit' value='Back to Products List'>" +
                        "</form>" +

                        "<img id='product-img' alt='Product Image'>" +

                        "<div class='product-name'>" + product_name + "</div>" +
                        "</div>");

                details_rs.close();
                details_stmt.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writer.println("<footer>" +
                "            Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen" +
                "        </footer>" +

                "    </div>" +

                "    <script type='text/javaScript'>" +
                "        document.getElementById('product-img').src = localStorage['productImages0'];" +
                "   </script>" +
                "</body>" +

                "</html>");

    }

    public void destroy() {
        try {
            details_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
