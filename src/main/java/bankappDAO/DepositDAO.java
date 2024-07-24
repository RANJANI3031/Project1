package bankappDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepositDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/customerdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean deposit(int amount, int accountNumber) {
        String query = "UPDATE customertable SET Balance = Balance + ? WHERE Accountno = ? AND Balance >= ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, amount);
            pstmt.setInt(2, accountNumber);
            pstmt.setInt(3, amount);
            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void recordTransaction(int accountNumber, String type, int amount) {
        String query = "INSERT INTO transactions (Accountno, type, amount, date) VALUES (?, ?, ?, NOW())";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, accountNumber);
            pstmt.setString(2, type);
            pstmt.setInt(3, amount);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static double getBalance(int accountNumber) {
        try (Connection conn = getConnection()) {
            String query = "SELECT Balance FROM customertable WHERE Accountno = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, accountNumber);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getDouble("Balance");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
