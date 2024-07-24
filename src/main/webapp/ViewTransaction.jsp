<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #9FC5E8;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 50px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
           
        }
        .button-container {
            margin-top: 20px;
            text-align: right;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin-left: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .button: hover {
            background-color: #0056b3;
        }
        
        
    </style>
</head>
<body>
    <div class="container">
        <form method="get" action="ViewTransactionServlet">
            <label for="sortOrder">Sort by Date:</label>
            <select id="sortOrder" name="sortOrder">
                <option value="DESC">Descending</option>
                <option value="ASC">Ascending</option>
            </select>
            <button type="submit">Sort</button>
        </form>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.type}</td>
                   <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction History</title>
    <style>
        /* Add your CSS here */
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #9FC5E8;
        }
    </style>
</head>
<body>
    <h1>Transaction History</h1>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Type</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <% 
                String accNo = (String) session.getAttribute("accountNumber");
                String url = "jdbc:mysql://localhost:3306/customerdb";
                String user = "root";
                String password = "root";
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, password);
                    stmt = conn.createStatement();
                    String query = "SELECT * FROM transactions WHERE Accountno = " + accNo + " ORDER BY date DESC";
                    rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getTimestamp("date") + "</td>");
                        out.println("<td>" + rs.getString("type") + "</td>");
                        out.println("<td>" + rs.getInt("amount") + "</td>");
                        out.println("</tr>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
                    <td>${transaction.amount}</td>
                    <td>${transaction.date}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="button-container">
            <a href="CustomerDashboard.jsp" class="button">Back to Dashboard</a>
            <a href="PrintTransactionServlet" class="button">Print</a>
        </div>
    </div>
</body>
</html>