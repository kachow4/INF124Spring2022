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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "recent-products", value = "/recent-products")
public class RecentProductsServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the POST request has been made to /product-list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /product-list");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");

        writer.println("<head>");
        // writer.println("<title>Products</title>");
        // writer.println("<meta name='viewport' content='width=device-width,
        // initial-scale=1.0'>");
        // writer.println("<link rel='stylesheet' href='./resources/css/navbar.css'>");
        writer.println("<link rel='stylesheet' href='./resources/css/recent-products.css'>");

        writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");
        // writer.println("<script type='text/javascript'>");
        // RequestDispatcher dispatcher =
        // req.getRequestDispatcher("./resources/js/product-list.js");
        // dispatcher.include(req, resp);
        // writer.println("</script>");
        writer.println("</head>");

        writer.println("<body>");
        writer.println("<h2>Your Recent Products</h2>");
        writer.println("<hr>");
        writer.println("<div class='recents-container'>");
        writer.println("<!-- DUNK LOW (UNIVERSITY BLUE) -->");
        writer.println("<div  class='recents'>");
        writer.println("<div class='recents-imgs'>");
        writer.println("<img src='./images/p1/bluedunks1.jpg' class='recents-img'>");
        writer.println("</div>");
        writer.println("<div class='recents-description'>");
        writer.println("<div class='recents-name'>Dunk Low (University Blue)</div>");
        writer.println("<div class='recents-type'>Nike</div>");
        writer.println("<div class='recents-price'>$100</div>");
        writer.println("<div class='recents-review'>78 reviews</div>");
        writer.println("</div>");
        writer.println("</div>");

        // writer.println("<div class='recents'");
        // writer.println("<div class='recents-imgs'>");
        // writer.println("<img src='./images/p1/bluedunks1.jpg' class='recents-img'>");
        // writer.println("</div>");
        // writer.println("<div class='recents-description'>");
        // writer.println("<div class='recents-name'>Dunk Low (University Blue)</div>");
        // writer.println("<div class='recents-type'>Nike</div>");
        // writer.println("<div class='recents-price'>$100</div>");
        // writer.println("<div class='recents-review'>78 reviews</div>");
        // writer.println("</div>");
        // writer.println("</div>");

        // writer.println("<div class='recents'>");
        // writer.println("<div class='recents-imgs'>");
        // writer.println("<img src='./images/p1/bluedunks1.jpg' class='recents-img'>");
        // writer.println("</div>");
        // writer.println("<div class='recents-description'>");
        // writer.println("<div class='recents-name'>Dunk Low (University Blue)</div>");
        // writer.println("<div class='recents-type'>Nike</div>");
        // writer.println("<div class='recents-price'>$100</div>");
        // writer.println("<div class='recents-review'>78 reviews</div>");
        // writer.println("</div>");
        // writer.println("</div>");

        // writer.println("<div class='recents'>");
        // writer.println("<div class='recents-imgs'>");
        // writer.println("<img src='./images/p1/bluedunks1.jpg' class='recents-img'>");
        // writer.println("</div>");
        // writer.println("<div class='recents-description'>");
        // writer.println("<div class='recents-name'>Dunk Low (University Blue)</div>");
        // writer.println("<div class='recents-type'>Nike</div>");
        // writer.println("<div class='recents-price'>$100</div>");
        // writer.println("<div class='recents-review'>78 reviews</div>");
        // writer.println("</div>");
        // writer.println("</div>");

        // writer.println("<div class='recents'>");
        // writer.println("<div class='recents-imgs'>");
        // writer.println("<img src='./images/p1/bluedunks1.jpg' class='recents-img'>");
        // writer.println("</div>");
        // writer.println("<div class='recents-description'>");
        // writer.println("<div class='recents-name'>Dunk Low (University Blue)</div>");
        // writer.println("<div class='recents-type'>Nike</div>");
        // writer.println("<div class='recents-price'>$100</div>");
        // writer.println("<div class='recents-review'>78 reviews</div>");
        // writer.println("</div>");
        // writer.println("</div>");

        writer.println("</div>");
        writer.println("</body>");

        writer.println("</html>");
    }

    // public void destroy() {
    // }
}
