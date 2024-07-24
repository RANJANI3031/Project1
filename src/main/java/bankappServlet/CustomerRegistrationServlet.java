package bankappServlet;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phono = request.getParameter("phono");
        String emailid = request.getParameter("Emailid");
        String dob = request.getParameter("DOB");
        String accounttype = request.getParameter("Accounttype");
        double balance = Double.parseDouble(request.getParameter("Balance"));
        String idproof = request.getParameter("Idproof");

        // Validation: Check if balance is at least 1000
        if (balance < 1000) {
            request.setAttribute("errorMessage", "The initial balance must be at least 1000.");
            request.getRequestDispatcher("CustomerRegistration.jsp").forward(request, response);
            return;
        }

        // Auto-generate account number
        String accountno = generateAccountNumber();

        // Auto-generate password
        String password = generatePassword();

        // Database connection
        String url = "jdbc:mysql://localhost:3306/customerdb";
        String user = "root";
        String passwordDb = "root";

        try (Connection conn = DriverManager.getConnection(url, user, passwordDb)) {
            String sql = "INSERT INTO customertable (fullname, address, phono, Emailid, DOB, Accountno, Accounttype, Password, Balance, Idproof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, fullname);
                stmt.setString(2, address);
                stmt.setString(3, phono);
                stmt.setString(4, emailid);
                stmt.setString(5, dob);
                stmt.setString(6, accountno);
                stmt.setString(7, accounttype);
                stmt.setString(8, password);
                stmt.setDouble(9, balance);
                stmt.setString(10, idproof);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

     // Set account number and password as request attributes
        request.setAttribute("accountNo", accountno);
        request.setAttribute("password", password);

        // Forward to success page
        request.getRequestDispatcher("RegistrationSuccess.jsp").forward(request, response);
    }

    private String generateAccountNumber() {
        // Example: Generate a random 10-digit account number
        SecureRandom random = new SecureRandom();
        return String.format("%010d", random.nextInt(1000000000));
    }

    private String generatePassword() {
        // Example: Generate a random 8-character password
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int charType = random.nextInt(3);
            if (charType == 0) {
                password.append((char) (random.nextInt(26) + 'A')); // Uppercase letter
            } else if (charType == 1) {
                password.append((char) (random.nextInt(26) + 'a')); // Lowercase letter
            } else {
                password.append(random.nextInt(10)); // Digit
            }
        }
        return password.toString();
    }
}
