package bankappServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bankappDAO.DeleteAccountDAO;

@WebServlet("/AccountDeletionServlet")
public class AccountDeletionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountnoStr = request.getParameter("Accountno");

        if (accountnoStr == null || accountnoStr.trim().isEmpty()) {
            request.setAttribute("status", "Account No cannot be empty.");
            request.getRequestDispatcher("DeleteAccount.jsp").forward(request, response);
            return;
        }

        try {
            int accountno = Integer.parseInt(accountnoStr);

            if (accountno <= 0) {
                request.setAttribute("status", "Invalid Account No.");
                request.getRequestDispatcher("DeleteAccount.jsp").forward(request, response);
                return;
            }

            DeleteAccountDAO dao = new DeleteAccountDAO();
            boolean success = dao.deleteCustomerAccount(accountno);

            if (success) {
                response.sendRedirect("DeletionSuccess.jsp");
            } else {
                request.setAttribute("status", "Account Deletion Failed. Please try again later.");
                request.getRequestDispatcher("DeleteAccount.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("status", "Invalid Account No format.");
            request.getRequestDispatcher("DeleteAccount.jsp").forward(request, response);
        }
    }
}