package com.inf124.stockabc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "add-to-cart", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {

    static int cart_length = 0;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        if (session.isNew()) {
            String userId = String.valueOf(ThreadLocalRandom.current().nextInt());

            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>" +
                    "<html lang='en'>" +

                    "<head>" +
                    "    <meta charset='UTF-8'>" +
                    "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                    "    <link rel='stylesheet' href='./resources/css/product-details.css'>" +
                    "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +
                    "    <script src='./product.js'></script>" +

                    "    <title>Product Page</title>" +
                    "</head>" +

                    "<body>" +
                    "    <header>" +
                    "        <div class='nav-bar-container'>" +
                    "           <ul class='nav-bar'>" +
                    "               <li id='navbar-title' class='nav-bar-title'>Product Page</li>" +
                    "                <li class='tab'><a href='./index.jsp'>Home</a></li>" +
                    "                <li class='tab'><a href='./product-list'>Products</a></li>" +
                    "                <li class='tab'><a href='./team'>The Team</a></li>" +
                    "            </ul>" +
                    "        </div>" +
                    "    </header>" +

                    "PRODUCT WAS SUCCESSFULLY ADDED TO CART" +
                    "NEW user" + userId +

                    "</body>" +

                    "</html>");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>" +
                    "<html lang='en'>" +

                    "<head>" +
                    "    <meta charset='UTF-8'>" +
                    "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "    <link rel='stylesheet' href='./resources/css/navbar.css'>" +
                    "    <link rel='stylesheet' href='./resources/css/product-details.css'>" +
                    "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>" +
                    "    <script src='./product.js'></script>" +

                    "    <title>Product Page</title>" +
                    "</head>" +

                    "<body>" +
                    "    <header>" +
                    "        <div class='nav-bar-container'>" +
                    "           <ul class='nav-bar'>" +
                    "               <li id='navbar-title' class='nav-bar-title'>Product Page</li>" +
                    "                <li class='tab'><a href='./index.jsp'>Home</a></li>" +
                    "                <li class='tab'><a href='./product-list'>Products</a></li>" +
                    "                <li class='tab'><a href='./team'>The Team</a></li>" +
                    "            </ul>" +
                    "        </div>" +
                    "    </header>" +

                    "PRODUCT WAS SUCCESSFULLY ADDED TO CART" +
                    "RETURNING user " + (String) session.getAttribute("userId") +
                    "</body>" +

                    "</html>");
        }

        // String name = "orderitem" + orderitem_counter;
        // session.setAttribute(name,req.getParameter("orderObj"));
        // orderitem_counter++;

        /*
         * PreparedStatement st = con.
         * prepareStatement("insert into orderitem(orderItem_id, item_id, order_id) values(?,?,?)"
         * );
         * st.setInt(1, orderitem_counter); //random number generator );
         * st.setInt(2,
         * Integer.valueOf(Integer.parseInt(req.getParameter("orderObj"))));
         * st.setInt(3,s.getID() );//random number generator );
         * orderitem_counter++;
         * 
         * 
         * st.executeUpdate();
         * st.close();
         */

        // PrintWriter writer = resp.getWriter();
        // writer.println("<!DOCTYPE html>" +
        // "<html lang='en'>" +

        // "<head>" +
        // " <meta charset='UTF-8'>" +
        // " <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
        // " <link rel='stylesheet' href='./resources/css/navbar.css'>" +
        // " <link rel='stylesheet' href='./resources/css/product-details.css'>" +
        // " <script
        // src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>"
        // +
        // " <script src='./product.js'></script>" +

        // " <title>Product Page</title>" +
        // "</head>" +

        // "<body>" +
        // " <header>" +
        // " <div class='nav-bar-container'>" +
        // " <ul class='nav-bar'>" +
        // " <li id='navbar-title' class='nav-bar-title'>Product Page</li>" +
        // " <li class='tab'><a href='./index.jsp'>Home</a></li>" +
        // " <li class='tab'><a href='./product-list'>Products</a></li>" +
        // " <li class='tab'><a href='./team'>The Team</a></li>" +
        // " </ul>" +
        // " </div>" +
        // " </header>" +

        // "PRODUCT WAS SUCCESSFULLY ADDED TO CART" +
        // userId +

        // "</body>" +

        // "</html>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("the GET request has been made to /add-to-cart");
    }

    public void destroy() {
        // do nothing
    }
}
