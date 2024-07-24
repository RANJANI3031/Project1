package bankappServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerDetails")
public class CustomerDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/customerdb", 
                "root", 
                "root"
            );

            // SQL query to fetch customer details
            String query = "SELECT fullname, address, phono, Emailid, DOB, Accountno, Accounttype, IdProof FROM customertable";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Process the result set
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setFullname(rs.getString("fullname"));
                customer.setAddress(rs.getString("address"));
                customer.setPhono(rs.getString("phono"));
                customer.setEmailid(rs.getString("Emailid"));
                customer.setDob(rs.getString("DOB"));
                customer.setAccountno(rs.getString("Accountno"));
                customer.setAccounttype(rs.getString("Accounttype"));
                customer.setIdProof(rs.getString("IdProof"));
                customers.add(customer);
            }

            // Print the number of customers to the server console
            System.out.println("Number of customers: " + customers.size());

            // Close resources
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the customers list as a request attribute
        request.setAttribute("customers", customers);

        // Forward the request to the JSP page
        request.getRequestDispatcher("CustomerDetails.jsp").forward(request, response);
    }
}
