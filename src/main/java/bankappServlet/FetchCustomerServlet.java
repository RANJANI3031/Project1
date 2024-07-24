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

@WebServlet("/FetchCustomerServlet")
public class FetchCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountno = request.getParameter("accountno");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/customerdb";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL query to fetch customer details
            String query = "SELECT * FROM customertable WHERE Accountno = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, accountno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Create a Customer object and set its fields
                Customer customer = new Customer();
                customer.setFullname(rs.getString("fullname"));
                customer.setAddress(rs.getString("address"));
                customer.setPhono(rs.getString("phono"));
                customer.setEmailid(rs.getString("Emailid"));
                customer.setDob(rs.getString("DOB"));
                customer.setAccountno(rs.getString("Accountno"));
                customer.setAccounttype(rs.getString("Accounttype"));
                customer.setIdProof(rs.getString("IdProof"));

                // Set the customer object as a request attribute
                request.setAttribute("customer", customer);

                // Forward to the ModifyAccount.jsp page
                request.getRequestDispatcher("ModifyAccount.jsp").forward(request, response);
            } else {
                // Handle case where no customer is found
                request.setAttribute("message", "Customer not found.");
                request.getRequestDispatcher("AdminModify.jsp").forward(request, response);
            }

            // Close resources
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
