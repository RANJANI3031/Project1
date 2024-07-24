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

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            String accNo = (String) session.getAttribute("accountNumber");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");

            if (newPassword.equals(confirmPassword)) {
                try {
                    boolean isPasswordChanged = changePassword(Integer.parseInt(accNo), oldPassword, newPassword);
                    if (isPasswordChanged) {
                        response.sendRedirect("CustomerDashboard.jsp");
                    } else {
                        response.sendRedirect("ChangePassword.jsp?error=Invalid+Old+Password");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("ErrorPage.jsp");
                }
            } else {
                response.sendRedirect("ChangePassword.jsp?error=Passwords+do+not+match");
            }
        } else {
            response.sendRedirect("CustomerLogin.jsp");
        }
    }

    private boolean changePassword(int accNo, String oldPassword, String newPassword) throws Exception {
        String queryCheck = "SELECT * FROM customertable WHERE Accountno = ? AND Password = ?";
        String queryUpdate = "UPDATE customertable SET Password = ? WHERE Accountno = ?";
        Connection conn = null;
        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
            pstmtCheck = conn.prepareStatement(queryCheck);
            pstmtCheck.setInt(1, accNo);
            pstmtCheck.setString(2, oldPassword);
            rs = pstmtCheck.executeQuery();

            if (rs.next()) {
                pstmtUpdate = conn.prepareStatement(queryUpdate);
                pstmtUpdate.setString(1, newPassword);
                pstmtUpdate.setInt(2, accNo);
                int rowsUpdated = pstmtUpdate.executeUpdate();
                return rowsUpdated > 0;
            } else {
                return false;
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmtCheck != null) pstmtCheck.close();
            if (pstmtUpdate != null) pstmtUpdate.close();
            if (conn != null) conn.close();
        }
    }
}
