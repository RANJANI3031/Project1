package bankappServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountno = request.getParameter("accountno");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phono = request.getParameter("phono");
        String emailid = request.getParameter("emailid");
        String dob = request.getParameter("dob");
        String accounttype = request.getParameter("accounttype");
        String idProof = request.getParameter("idProof");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/customerdb";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL query to update customer details
            String query = "UPDATE customertable SET fullname = ?, address = ?, phono = ?, Emailid = ?, DOB = ?, Accounttype = ?, IdProof = ? WHERE Accountno = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, address);
            ps.setString(3, phono);
            ps.setString(4, emailid);
            ps.setString(5, dob);
            ps.setString(6, accounttype);
            ps.setString(7, idProof);
            ps.setString(8, accountno);

            int rowsUpdated = ps.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                request.setAttribute("message", "Customer details updated successfully.");
            } else {
                request.setAttribute("message", "Update failed. Please try again.");
            }

            // Forward to the AdminModify.jsp page with a message
            request.getRequestDispatcher("UpdateSuccess.jsp").forward(request, response);

            // Close resources
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred. Please try again.");
            request.getRequestDispatcher("AdminModify.jsp").forward(request, response);
        }
    }
}
