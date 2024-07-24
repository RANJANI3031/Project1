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
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("CustomerLogin.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountNumber = request.getParameter("accountNumber");
        String password = request.getParameter("password");

        // Validate the user credentials
        Customer customer = validateCredentials(accountNumber, password);

        if (customer != null) {
            HttpSession session = request.getSession();
            session.setAttribute("customerName", customer.getFullName());
            session.setAttribute("accountNumber", customer.getAccountNumber());
            response.sendRedirect("CustomerDashboard.jsp");
        } else {
            response.sendRedirect("CustomerLogin.jsp");
        }
    }

    private Customer validateCredentials(String accountNumber, String password) {
        Customer customer = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/customerdb";
        String dbUsername = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            pst = conn.prepareStatement("SELECT * FROM customertable WHERE Accountno = ? AND Password = ?");
            pst.setString(1, accountNumber);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setFullName(rs.getString("fullname"));
                customer.setAccountNumber(rs.getString("Accountno"));
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

        return customer;
    }

    private class Customer {
        private String fullName;
        private String accountNumber;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }
    }
}
