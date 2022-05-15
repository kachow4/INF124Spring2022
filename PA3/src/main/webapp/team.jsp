<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="com.inf124.stockabc.DatabaseHelper" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang='en'>

    <head>
        <title>The Team</title>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='stylesheet' href='./resources/css/navbar.css'>
        <link rel='stylesheet' href='./resources/css/team.css'>
    </head>

    <body>
        <header>
            <div class='nav-bar-container'>
                <ul class='nav-bar'>
                    <li class='nav-bar-title'>Team</li>
                    <li class='tab'><a href='./index.html'>Home</a></li>
                    <li class='tab'><a href='productList.jsp'>Products</a></li>
                    <li class='tab'><a href=''>The Team</a></li>
                    <li class='tab'><a href='checkout.jsp'>Cart</a></li>
                </ul>
            </div>
        </header>

        <div class='website-description'>
            Welcome to StockABC, a platform that hosts the selling and buying of your favorite sneakers.
            Our collection of products ranges from shoes sourced directly from the retailer as well as
            shoes currated from our community. This site is the buying side, which means customer are able
            to shop for sneakers but not sell on this specific version of the platform. Our management and
            devlopemnt team comprises of three people. You can read through our Bios below.
        </div>

        <div class='bio-container'>

        <%
            DatabaseHelper databaseHelper=new DatabaseHelper(); 
            Connection members_conn=databaseHelper.getConnection(); 
            PreparedStatement members_stmt = members_conn
                    .prepareStatement("SELECT first_name, last_name, major, school_status, img_path FROM members");

            ResultSet members_rs = members_stmt.executeQuery();

            while (members_rs.next()) {
                String first_name = members_rs.getString("first_name");
                String last_name = members_rs.getString("last_name");
                String major = members_rs.getString("major");
                String school_status = members_rs.getString("school_status");
                String img_path = members_rs.getString("img_path");
        %>
        
                <div class='individual-bio'>
                    <img src='<%=img_path%>' class='bio-pic'>
                        <div class='bio-description'>
                        <div class='bio-name'><%=first_name + " " + last_name%></div>
                        <div class='bio-major'>Major: <%=major%></div>
                        <div class='bio-year'>Year: <%=school_status%></div>
                    </div>
                </div>
        
        <%
                }
            members_rs.close();
            members_stmt.close();
            members_conn.close();

        %>
        </div>
        <footer>Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen</footer>
    </body>
</html>



