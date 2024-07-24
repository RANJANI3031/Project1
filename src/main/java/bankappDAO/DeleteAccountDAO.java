package bankappDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccountDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/customerdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customertable WHERE Accountno = ?;";

    // Method to establish a connection to the database
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // Method to delete a customer account
    public boolean deleteCustomerAccount(int accountno) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {

            preparedStatement.setInt(1, accountno);

            int affectedRows = preparedStatement.executeUpdate();
            rowDeleted = (affectedRows > 0);

            System.out.println("Rows affected: " + affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return rowDeleted;
    }
}