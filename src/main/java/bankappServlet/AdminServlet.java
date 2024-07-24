package bankappServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user credentials (you can replace this with your validation logic)
        boolean valid = validateCredentials(username, password);

        if (valid) {
            response.sendRedirect("AdminDashboard.jsp");
        } else {
            response.sendRedirect("AdminLogin.jsp");
        }
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	System.out.println(" inside doPost  "); 
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user credentials (you can replace this with your validation logic)
        boolean valid = validateCredentials(username, password);

        if (valid) {
            response.sendRedirect("AdminDashboard.jsp");
        } else {
            response.sendRedirect("AdminLogin.jsp");
        }
    }



    private boolean validateCredentials(String username, String password) {
        boolean isValid = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/admindb";
        String dbUsername = "root";
        String dbPassword = "root"; // Replace with your actual database password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            pst = conn.prepareStatement("SELECT * FROM admintable "
            		+ "WHERE fullname = ? AND Password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                isValid = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isValid;
    

    }
}