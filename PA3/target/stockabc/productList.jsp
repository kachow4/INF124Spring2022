<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.inf124.stockabc.DatabaseHelper" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Products</title>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='stylesheet' href='./resources/css/navbar.css'>
        <link rel='stylesheet' href='./resources/css/recent-products.css'>
        <link rel='stylesheet' href='./resources/css/product-list.css'>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
    </head>

    <body>
    <!-- show navbar -->
        <header>
        <div class='nav-bar-container'>
            <ul class='nav-bar'>
                <li class='nav-bar-title'>Products</li>
                <li class='tab'><a href='./index.html'>Home</a></li>
                <li class='tab'><a href=''>Products</a></li>
                <li class='tab'><a href='team.jsp'>The Team</a></li>
                <li class='tab'><a href='checkout.jsp'>Cart</a></li>
            </ul>
        </div>
        </header>

    <jsp:include page="recentProducts.jsp" flush="true"/>

    <!-- List of all products -->
    <h1>All Products</h1>
    <hr>
    <div class='products-container'>

    <!-- grab all products and info from database -->
    <%
    DatabaseHelper databaseHelper=new DatabaseHelper(); 
    Connection productList_conn=databaseHelper.getConnection(); 

    PreparedStatement productList_stmt = productList_conn.prepareStatement("SELECT * FROM products");

    ResultSet productList_rs = productList_stmt.executeQuery();

    while (productList_rs.next()) {
        String product_id = productList_rs.getString("product_id");
        String product_name = productList_rs.getString("product_name");
        String product_brand = productList_rs.getString("product_brand");
        String product_price = productList_rs.getString("product_price");
        String img_path_1 = productList_rs.getString("img_path_one");
    %>

        <!-- route to product details page using specific identifier as a parameter -->
        <a href='./product-details?id=<%=product_id%>'>
            <div id='p<%=product_id%>' class='product'>
                <img src='<%=img_path_1%>' class='product-img'>
                <div class='product-description'>
                    <div class='product-name'><%=product_name%></div>
                    <div class='product-type'><%=product_brand%></div>
                    <div class='product-price'>$<%=product_price%>0</div>
                    <div class='product-review'>78 reviews</div>
                </div>
            </div>
        </a>
    <%
    }
    productList_conn.close();
    %>

    </div>

    <footer>
    Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen
    </footer>
    </body>

    </html>   