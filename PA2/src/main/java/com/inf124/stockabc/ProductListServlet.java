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

@WebServlet(name = "product-list", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    Connection productList_conn;
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
            productList_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
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

        // getServletContext().getRequestDispatcher("/product-list.jsp").forward(req,
        // resp);

        // HttpSession session = req.getSession(true);

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");

        writer.println("<head>");
        writer.println("<title>Products</title>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<link rel='stylesheet' href='./resources/css/navbar.css'>");
        writer.println("<link rel='stylesheet' href='./resources/css/product-list.css'>");

        writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>");
        // writer.println("<script src='./resources/js/product.js'></script>");

        writer.println("<script type='text/javascript'>");
        // writer.println("<script language=\"JavaScript\">");
        RequestDispatcher dispatcher = req.getRequestDispatcher("./resources/js/product-list.js");
        dispatcher.include(req, resp);
        writer.println("</script>");

        writer.println("</head>");

        writer.println("<body>");

        writer.println("<header>");
        writer.println("<div class='nav-bar-container'>");
        writer.println("<ul class='nav-bar'>");
        writer.println("<li class='nav-bar-title'>Products</li>");
        writer.println("<li class='tab'><a href='./index.jsp'>Home</a></li>");
        writer.println("<li class='tab'><a href=''>Products</a></li>");
        writer.println("<li class='tab'><a href='./team'>The Team</a></li>");
        writer.println("</ul>");
        writer.println("</div>");
        writer.println("</header>");

        // if (!session.isNew() && ((ArrayList<String>)
        // session.getAttribute("cart")).size() > 0) {
        resp.setContentType("text/html");
        String recentProductsURL = "/recent-products";
        RequestDispatcher rd = req.getRequestDispatcher(recentProductsURL);
        rd.include(req, resp);
        // }

        writer.println("<h1>All Products</h1>");
        writer.println("<hr>");
        writer.println("<div class='products-container'>");

        try {
            Statement productList_stmt = productList_conn.createStatement();

            String productList_query = "SELECT product_id, product_name, product_brand, product_price FROM products";
            ResultSet productList_rs = productList_stmt.executeQuery(productList_query);

            while (productList_rs.next()) {
                String product_id = productList_rs.getString("product_id");
                String product_name = productList_rs.getString("product_name");
                String product_brand = productList_rs.getString("product_brand");
                String product_price = productList_rs.getString("product_price");

                // writer.println("<!-- DUNK LOW (UNIVERSITY BLUE) -->");

                writer.println(
                        // "<div id='p" + product_id + "' class='product'
                        // onclick='handleProductSelect(this.id)'>");
                        "<a href='./product-details?id=" + product_id + "'><div id='p" + product_id
                                + "' class='product''>");
                writer.println("<div class='product-imgs'>");
                writer.println("<img src='./images/p1/bluedunks1.jpg' class='product-img'>");
                writer.println("<img src='./images/p1/bluedunks2.jpg' class='additional-product-img'>");
                writer.println("<img src='./images/p1/bluedunks3.jpg' class='additional-product-img'>");
                writer.println("<img src='./images/p1/bluedunks4.jpg' class='additional-product-img'>");
                writer.println("</div>");
                writer.println("<div class='product-description'>");
                writer.println("<div class='product-name'>" + product_name + "</div>");
                writer.println("<div class='product-type'>" + product_brand + "</div>");
                writer.println("<div class='product-price'>$" + product_price + "</div>");
                writer.println("<div class='product-review'>78 reviews</div>");
                writer.println(
                        "<div class='product-hidden-desc'>Originally created for the hardwood, the Dunk later took to the streets—and as they say, the rest is history. More than 35 years after its debut, the silhouette still delivers bold, defiant style and remains a coveted look for crews across both sport and culture. Now, the university-hoops OG returns, covered in crisp material overlays with heritage-inspired colour-blocking. Modern footwear technology brings the design's comfort into the 21st century, while a clean combination of white and University Blue gives this make-up a classic feel.</div>");
                writer.println("</div>");
                writer.println("</div></a>");
            }

            productList_rs.close();
            productList_stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writer.println("</div>");

        writer.println("<footer>");
        writer.println("Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen");
        writer.println("</footer>");
        writer.println("</body>");

        writer.println("</html>");
    }

    public void destroy() {
        try {
            productList_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
