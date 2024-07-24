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

@WebServlet("/ViewBalanceServlet")
public class ViewBalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String accNo = (String) session.getAttribute("accountNumber");
            System.out.println("Account Number from Session: " + accNo); // Debug print
            if (accNo != null && !accNo.isEmpty()) {
                try {
                    Integer balance = getCurrentBalance(Integer.parseInt(accNo));
                    System.out.println("Retrieved Balance: " + balance); // Debug print
                    request.setAttribute("Balance", balance != null ? balance.toString() : "N/A");
                    request.getRequestDispatcher("ViewBalance.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("ErrorPage.jsp");
                }
            } else {
                response.sendRedirect("CustomerLogin.jsp");
            }
        } else {
            response.sendRedirect("CustomerLogin.jsp");
        }
    }

    private Integer getCurrentBalance(int accNo) throws Exception {
        String query = "SELECT Balance FROM customertable WHERE Accountno = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer balance = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, accNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                balance = rs.getInt("Balance");
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }

        return balance;
    }
}
