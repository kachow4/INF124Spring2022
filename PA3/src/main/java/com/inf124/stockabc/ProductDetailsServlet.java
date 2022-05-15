package com.inf124.stockabc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "product-details", value = "/product-details")
public class ProductDetailsServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get product identifier as a parameter
        String productId = req.getParameter("id");

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +

                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <title>Product Details</title>" +
                "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                "    <link rel='stylesheet' href='./resources/css/product-details.css'>" +
                "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");

        writer.println("</head><body>" +

        // show navbar
                "    <header>" +
                "        <div class='nav-bar-container'>" +
                "           <ul class='nav-bar'>" +
                "               <li id='navbar-title' class='nav-bar-title'>Product Details</li>" +
                "                <li class='tab'><a href='./index.html'>Home</a></li>" +
                "                <li class='tab'><a href='productList.jsp'>Products</a></li>" +
                "                <li class='tab'><a href='team.jsp'>The Team</a></li>" +
                "               <li class='tab'><a href='checkout.jsp'>Cart</a></li>" +
                "            </ul>" +
                "        </div>" +
                "    </header>");

        // grab individual product information from database
        try {
            PreparedStatement details_stmt = details_conn
                    .prepareStatement("SELECT * FROM products WHERE product_id = ?");

            details_stmt.setString(1, productId);
            ResultSet details_rs = details_stmt.executeQuery();

            while (details_rs.next()) {
                String product_id = details_rs.getString("product_id");
                String product_name = details_rs.getString("product_name");
                String product_brand = details_rs.getString("product_brand");
                String product_price = details_rs.getString("product_price");
                String product_description = details_rs.getString("product_description");
                String img_path_1 = details_rs.getString("img_path_one");
                String img_path_2 = details_rs.getString("img_path_two");
                String img_path_3 = details_rs.getString("img_path_three");
                String img_path_4 = details_rs.getString("img_path_four");

                writer.println("    <div class='content-container'>" +

                        "        <div class='product-container'>" +
                        "            <div class='top-product-description'>" +
                        "                <div class='product-name'>" + product_name + "</div>" +
                        "                <div class='brand'>" + product_brand + "</div>" +
                        "                <div class='price'>$" + product_price + "0</div>" +
                        "                <form action='./add-to-cart?id=" + product_id + "' method='POST'>" +
                        "                    <input type='submit' value='Add to Cart'>" +
                        "                </form>" +

                        "                <div class='description'>" + product_description + "</div>" +
                        "           </div>" +

                        "           <div class='product-img-container'>" +
                        "               <img id='product-img0' src='" + img_path_1 + "' alt='Product Image'>" +

                        "               <img id='product-img1' src='" + img_path_2 + "'>" +
                        "               <img id='product-img2' src='" + img_path_3 + "'>" +
                        "               <img id='product-img3' src='" + img_path_4 + "'>" +
                        "            </div>" +

                        "           <div class='side-product-description'>" +
                        "               <div class='product-name'>" + product_name + "</div>" +
                        "               <div class='brand'>" + product_brand + "</div>" +
                        "               <div class='price'>" + product_price + "</div>" +
                        "               <div class='reviews'></div>" +

                        // add to cart button
                        "               <form action='./add-to-cart?id=" + product_id + "' method='POST'>" +
                        "                    <input type='submit' value='Add to Cart'>" +
                        "                        </form>" +

                        "               <div class='description'>" + product_description + "</div>" +
                        "            </div>" +
                        "        </div>");

                details_rs.close();
                details_stmt.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writer.println("       <footer>" +
                "            Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen" +
                "        </footer>" +

                "    </div>" +
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
