<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.inf124.stockabc.DatabaseHelper" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Get current session's cart -->
<%
    if(session.isNew()){
        ArrayList<String> empty_cart = new ArrayList<String>();
        session.setAttribute("cart", empty_cart);
    }

    ArrayList<String> cart = (ArrayList<String>) session.getAttribute("cart");
%>

<!DOCTYPE html>
    <h2>Your Recent Products</h2>
    <hr>
    <div class='recents-container'>

    <%
    DatabaseHelper databaseHelper=new DatabaseHelper(); 
    Connection recent_conn=databaseHelper.getConnection(); 

    if (cart.size() > 0 && cart.size() < 5) {
        for (int i = cart.size(); i > 0; i--) {
            PreparedStatement recent_stmt = recent_conn.prepareStatement(
                    "SELECT product_name, product_brand, product_price, img_path_one FROM products WHERE product_id = ?");

            recent_stmt.setString(1, cart.get(i - 1));
            ResultSet recent_rs = recent_stmt.executeQuery();

            while (recent_rs.next()) {
                String product_name = recent_rs.getString("product_name");
                String product_brand = recent_rs.getString("product_brand");
                String product_price = recent_rs.getString("product_price");
                String img_path_1 = recent_rs.getString("img_path_one");
    %>
                <div class='recents'>
                    <div class='recents-imgs'>
                    <img src='<%=img_path_1%>' class='recents-img'>
                    </div>
                    <div class='recents-description'>
                        <div class='recents-name'><%=product_name%></div>
                        <div class='recents-type'><%=product_brand%></div>
                        <div class='recents-price'>$<%=product_price%>0</div>
                        <div class='recents-review'>78 reviews</div>
                    </div>
                </div>
    <%
            }
            recent_rs.close();
            recent_stmt.close();
        }
    } else if (cart.size() >= 5) {
        for (int i = cart.size(); i > cart.size() - 5; i--) {
            PreparedStatement recent_stmt = recent_conn.prepareStatement(
                    "SELECT product_name, product_brand, product_price, img_path_one FROM products WHERE product_id = ?");

            recent_stmt.setString(1, cart.get(i - 1));
            ResultSet recent_rs = recent_stmt.executeQuery();

            while (recent_rs.next()) {
                String product_name = recent_rs.getString("product_name");
                String product_brand = recent_rs.getString("product_brand");
                String product_price = recent_rs.getString("product_price");
                String img_path_1 = recent_rs.getString("img_path_one");
    %>
                
            <div class='recents'>
                <div class='recents-imgs'>
                <img src='<%=img_path_1%>' class='recents-img'>
                </div>
                <div class='recents-description'>
                    <div class='recents-name'><%=product_name%></div>
                    <div class='recents-type'><%=product_brand%></div>
                    <div class='recents-price'>$<%=product_price%>0</div>
                    <div class='recents-review'>78 reviews</div>
                </div>
            </div>
    <%
            }
            recent_rs.close();
            recent_stmt.close();
        }
    } else {
    %>
        Your cart is currently empty.
    <%
    }
    recent_conn.close();
    %>
    </div>
   
      
 