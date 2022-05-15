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

//this servlet adds product to session cart and tells user they are succesful
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
                "    <link rel='stylesheet' href='./resources/css/add-success.css'>");
        writer.println("<script type='text/javascript'>");
        RequestDispatcher dispatcher = req.getRequestDispatcher("./resources/js/product-details.js");
        dispatcher.include(req, resp);
        writer.println(
                "</script><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");

        writer.println("<title>Product Added</title>" +
                "</head>" +

                "<body>" +
                "    <header>" +
                "        <div class='nav-bar-container'>" +
                "           <ul class='nav-bar'>" +
                "               <li id='navbar-title' class='nav-bar-title'>Product Details</li>" +
                "                <li class='tab'><a href='./index.html'>Home</a></li>" +
                "                <li class='tab'><a href='productList.jsp'>Products</a></li>" +
                "                <li class='tab'><a href='team.jsp'>The Team</a></li>" +
                "                <li class='tab'><a href='checkout.jsp'>Cart</a></li>" +
                "            </ul>" +
                "        </div>" +
                "    </header>");

        try {
            PreparedStatement details_stmt = details_conn
                    .prepareStatement("SELECT product_name, img_path_one FROM products WHERE product_id = ?");
            details_stmt.setString(1, productId);
            ResultSet details_rs = details_stmt.executeQuery();

            while (details_rs.next()) {
                String product_name = details_rs.getString("product_name");
                String img_path_1 = details_rs.getString("img_path_one");

                writer.println("<div class='content-container'>" +

                        "<h2>This product was successfully added to your cart!</h2>" +

                        "<form action='./productList.jsp'>" +
                        "  <input type='submit' value='Back to Products List'>" +
                        "</form>" +

                        "<img id='product-img' src='" + img_path_1 + "' alt='Product Image'>" +

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
