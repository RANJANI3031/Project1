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
import javax.servlet.http.HttpSession;

@WebServlet("/ViewTransactionServlet")
public class ViewTransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("customerName") == null) {
            response.sendRedirect("CustomerLogin.jsp");
            return;
        }

        String accountNumber = (String) session.getAttribute("accountNumber");
        String sortOrder = request.getParameter("sortOrder");
        if (sortOrder == null) sortOrder = "DESC";

        List<Transaction> transactions = getTransactions(accountNumber, sortOrder);

        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("ViewTransaction.jsp").forward(request, response);
    }

    private List<Transaction> getTransactions(String accountNumber, String sortOrder) {
        List<Transaction> transactions = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/customerdb";
        String dbUsername = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "SELECT * FROM transactions WHERE Accountno = ? ORDER BY date " + sortOrder + " LIMIT 10";
            pst = conn.prepareStatement(query);
            pst.setString(1, accountNumber);
            rs = pst.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setType(rs.getString("type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getDate("date"));
                transactions.add(transaction);
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

        return transactions;
    }

    private class Transaction {
        private String type;
        private double amount;
        private java.sql.Date date;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public java.sql.Date getDate() {
            return date;
        }

        public void setDate(java.sql.Date date) {
            this.date = date;
        }
    }
}