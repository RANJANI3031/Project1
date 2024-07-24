package bankappServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankappDAO.WithdrawDAO;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the logged-in user's account number from the session
        HttpSession session = request.getSession();
        String accountNumberStr = (String) session.getAttribute("accountNumber");

        try {
            int accountNumber = Integer.parseInt(accountNumberStr);

            // Retrieve the withdrawal amount from the request
            String amountStr = request.getParameter("amount");

            try {
                int amount = Integer.parseInt(amountStr);

                // Validate the withdrawal amount
                if (amount <= 0) {
                    request.setAttribute("errorMessage", "Withdrawal amount must be greater than 0.");
                    request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
                    return;
                }

                // Perform withdrawal
                boolean success = WithdrawDAO.withdraw(amount, accountNumber);

                if (success) {
                    // Record the transaction
                    WithdrawDAO.recordTransaction(accountNumber, "Withdraw", amount);
                    
                    // Fetch the updated balance
                    double updatedBalance = WithdrawDAO.getBalance(accountNumber);

                    // Set the updated balance as a request attribute and redirect to success page
                    request.setAttribute("updatedBalance", updatedBalance);
                    request.getRequestDispatcher("WithdrawSuccess.jsp").forward(request, response);
                } else {
                    response.sendRedirect("WithdrawFailure.jsp");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid amount.");
                request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid account number.");
            request.getRequestDispatcher("Withdraw.jsp").forward(request, response);
        }
    }
}
