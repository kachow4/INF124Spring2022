package com.inf124.stockabc;

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

@WebServlet(name = "team", value = "/team")
public class TeamServlet extends HttpServlet {

    Connection members_conn;
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
            members_conn = DriverManager.getConnection(DB_URL, "root", "Stevens!Univers3");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeamServlet DoGet");

        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");

        writer.println("<head>");
        writer.println("<title>The Team</title>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<link rel='stylesheet' href='./resources/css/navbar.css'>");
        writer.println("<link rel='stylesheet' href='./resources/css/team.css'>");
        writer.println("</head>");

        writer.println("<body>");
        writer.println("<header>");
        writer.println("<div class='nav-bar-container'>");
        writer.println("<ul class='nav-bar'>");
        writer.println("<li class='nav-bar-title'>Team</li>");
        writer.println("<li class='tab'><a href='./index.jsp'>Home</a></li>");
        writer.println("<li class='tab'><a href='./product-list'>Products</a></li>");
        writer.println("<li class='tab'><a href=''>The Team</a></li>");
        writer.println("</ul>");
        writer.println("</div>");
        writer.println("</header>");

        writer.println("<div class='website-description'>");
        writer.println(
                "Welcome to StockABC, a platform that hosts the selling and buying of your favorite sneakers.");
        writer.println("Our collection of products ranges from shoes sourced directly from the retailer as well as");
        writer.println(
                "shoes currated from our community. This site is the buying side, which means customer are able");
        writer.println(
                "to shop for sneakers but not sell on this specific version of the platform. Our management and");
        writer.println("devlopemnt team comprises of three people. You can read through our Bios below.");
        writer.println("</div>");

        writer.println("<div class='bio-container'>");

        try {
            Statement members_stmt = members_conn.createStatement();

            String members_query = "SELECT first_name, last_name, major, school_status FROM members";
            ResultSet members_rs = members_stmt.executeQuery(members_query);

            while (members_rs.next()) {
                String first_name = members_rs.getString("first_name");
                String last_name = members_rs.getString("last_name");
                String major = members_rs.getString("major");
                String school_status = members_rs.getString("school_status");
                // String first_name = members_rs.getString("first_name");

                writer.println("<div class='individual-bio katieBio'>");
                writer.println("<img src='./images/team/katie.jpg' class='bio-pic'>");
                writer.println("<div class='bio-description'>");
                writer.println("<div class='bio-name'>" + first_name + " " + last_name + "</div>");
                writer.println("<div class='bio-major'>Major: " + major + "</div>");
                writer.println("<div class='bio-year'>Year: " + school_status + "</div>");
                writer.println("</div>");
                writer.println("</div>");
            }

            members_rs.close();
            members_stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        writer.println("</div>");
        writer.println("<footer>Made with brains by: Katie Chow, Andrew Owyang, and Huan Nguyen</footer>");
        writer.println("</body>");

        writer.println("</html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // cool
    }

    public void destroy() {
        try {
            members_conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
