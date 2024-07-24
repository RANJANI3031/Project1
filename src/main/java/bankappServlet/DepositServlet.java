package bankappServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bankappDAO.DepositDAO;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
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
                    request.setAttribute("errorMessage", "Deposit amount must be greater than 0.");
                    request.getRequestDispatcher("Deposit.jsp").forward(request, response);
                    return;
                }

                // Perform withdrawal
                boolean success = DepositDAO.deposit(amount, accountNumber);

                if (success) {
                    // Record the transaction
                	DepositDAO.recordTransaction(accountNumber, "Deposit", amount);
                    
                    // Fetch the updated balance
                    double updatedBalance = DepositDAO.getBalance(accountNumber);

                    // Set the updated balance as a request attribute and redirect to success page
                    request.setAttribute("updatedBalance", updatedBalance);
                    request.getRequestDispatcher("DepositSuccess.jsp").forward(request, response);
                } else {
                    response.sendRedirect("DepositFailure.jsp");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Invalid amount.");
                request.getRequestDispatcher("Deposit.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid account number.");
            request.getRequestDispatcher("Deposit.jsp").forward(request, response);
        }
    }
}
