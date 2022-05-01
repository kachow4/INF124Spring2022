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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the POST request has been made to /product-details");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /product-details");

        String productId = req.getParameter("id");

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>" +
                "<html lang='en'>" +

                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                "    <link rel='stylesheet' href='./resources/css/product-details.css'>" +
                "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");
        // " <script src='./product.js'></script>" +

        writer.println("<script type='text/javascript'>");
        // writer.println("<script language=\"JavaScript\">");
        RequestDispatcher dispatcher = req.getRequestDispatcher("./resources/js/product-list.js");
        dispatcher.include(req, resp);
        writer.println("</script>");

        writer.println("<title>Product Details</title>" +
                "</head>" +

                "<body>" +
                "    <header>" +
                "        <div class='nav-bar-container'>" +
                "           <ul class='nav-bar'>" +
                "               <li id='navbar-title' class='nav-bar-title'>Product Details</li>" +
                "                <li class='tab'><a href='./index.jsp'>Home</a></li>" +
                "                <li class='tab'><a href='./product-list'>Products</a></li>" +
                "                <li class='tab'><a href='./team'>The Team</a></li>" +
                "            </ul>" +
                "        </div>" +
                "    </header>");

        try {
            Statement details_stmt = details_conn.createStatement();

            String details_query = "SELECT * FROM products WHERE product_id = " + productId;
            ResultSet details_rs = details_stmt.executeQuery(details_query);

            while (details_rs.next()) {
                String product_id = details_rs.getString("product_id");
                String product_name = details_rs.getString("product_name");
                String product_brand = details_rs.getString("product_brand");
                String product_price = details_rs.getString("product_price");
                String product_description = details_rs.getString("product_description");

                // writer.println("<!-- DUNK LOW (UNIVERSITY BLUE) -->");

                writer.println("    <div class='content-container'>" +

                        "        <div class='product-container'>" +
                        "            <div class='top-product-description'>" +
                        "                <div class='product-name'>" + product_name + "</div>" +
                        "                <div class='brand'>" + product_brand + "</div>" +
                        "                <div class='price'>" + product_price + "</div>" +
                        "            </div>" +

                        "           <div class='product-img-container'>" +
                        "               <img id='product-img0' alt='Product Image'>" +

                        "               <img id='product-img1'>" +
                        "               <img id='product-img2'>" +
                        "               <img id='product-img3'>" +
                        "            </div>" +

                        "           <div class='side-product-description'>" +
                        "               <div class='product-name'>" + product_name + "</div>" +
                        "               <div class='brand'>" + product_brand + "</div>" +
                        "                <div class='price'>" + product_price + "</div>" +
                        "                        <div class='reviews'></div>" +

                        "               <form action='./add-to-cart?id=" + productId + "' method='POST'>" +
                        "                    <input type='submit' value='Add to Cart'></button>" +
                        "                        </form>" +

                        "               <div class='description'>" + product_description + "</div>" +
                        "            </div>" +

                        "                    <div id='reviews'></div>" +
                        "            <div id='description'></div>" +

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

                "    <script type='text/javaScript'>" +
                "        document.getElementById('product-img0').src = localStorage['productImages0'];" +
                "        document.getElementById('product-img1').src = localStorage['productImages1'];" +
                "        document.getElementById('product-img2').src = localStorage['productImages2'];" +
                "        document.getElementById('product-img3').src = localStorage['productImages3'];" +
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
