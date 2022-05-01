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

@WebServlet(name = "recent-products", value = "/recent-products")
public class RecentProductsServlet extends HttpServlet {
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

                "<link rel='stylesheet' href='./resources/css/recent-products.css'>" +

                "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +

                "</head>" +

                "<body>" +
                "<h2>Your Recent Products</h2>" +
                "<hr>" +
                "<div class='recents-container'>");

        // writer.println(cart);

        if (cart.size() > 0 && cart.size() < 5) {
            try {
                for (int i = cart.size(); i > 0; i--) {
                    Statement recent_stmt = recent_conn.createStatement();

                    String recent_query = "SELECT product_name, product_brand, product_price FROM products WHERE product_id = "
                            + cart.get(i - 1);
                    ResultSet recent_rs = recent_stmt.executeQuery(recent_query);

                    while (recent_rs.next()) {
                        String product_name = recent_rs.getString("product_name");
                        String product_brand = recent_rs.getString("product_brand");
                        String product_price = recent_rs.getString("product_price");

                        writer.println(
                                "<div class='recents'>" +
                                        "<div class='recents-imgs'>" +
                                        "<img src='./images/p1/bluedunks1.jpg' class='recents-img'>" +
                                        "</div>" +
                                        "<div class='recents-description'>" +
                                        "<div class='recents-name'>" + product_name + "</div>" +
                                        "<div class='recents-type'>" + product_brand + "</div>" +
                                        "<div class='recents-price'>" + product_price + "</div>" +
                                        "<div class='recents-review'>78 reviews</div>" +
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
        } else if (cart.size() >= 5) {
            try {
                for (int i = cart.size(); i > cart.size() - 5; i--) {
                    Statement recent_stmt = recent_conn.createStatement();

                    String recent_query = "SELECT product_name, product_brand, product_price FROM products WHERE product_id = "
                            + cart.get(i - 1);
                    ResultSet recent_rs = recent_stmt.executeQuery(recent_query);

                    while (recent_rs.next()) {
                        String product_name = recent_rs.getString("product_name");
                        String product_brand = recent_rs.getString("product_brand");
                        String product_price = recent_rs.getString("product_price");

                        writer.println(
                                "<div class='recents'>" +
                                        "<div class='recents-imgs'>" +
                                        "<img src='./images/p1/bluedunks1.jpg' class='recents-img'>" +
                                        "</div>" +
                                        "<div class='recents-description'>" +
                                        "<div class='recents-name'>" + product_name + "</div>" +
                                        "<div class='recents-type'>" + product_brand + "</div>" +
                                        "<div class='recents-price'>" + product_price + "</div>" +
                                        "<div class='recents-review'>78 reviews</div>" +
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
