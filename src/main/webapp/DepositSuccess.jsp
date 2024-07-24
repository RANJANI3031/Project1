<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Success</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9f5e9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .success-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }
        .success-icon {
            width: 50px;
            height: 50px;
            margin-bottom: 15px;
        }
        .success-message {
            font-size: 18px;
            color: #28a745;
            font-weight: bold;
        }
        .balance-message {
            font-size: 16px;
            color: #333;
            margin-top: 10px;
        }
        .button-container {
            margin-top: 20px;
        }
        .success-button, .dashboard-button {
            display: inline-block;
            margin: 5px;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            color: #ffffff;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .success-button {
            background-color: #007bff;
        }
        .success-button:hover {
            background-color: #0056b3;
        }
        .dashboard-button {
            background-color: #28a745;
        }
        .dashboard-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <!-- SVG Tick Icon -->
        <svg class="success-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" color="#28a745">
            <path d="M20 6L9 17l-5-5"></path>
        </svg>
        <div class="success-message">Successfully Deposited!</div>
        <div class="balance-message">Updated Balance: ₹${updatedBalance}</div>
        <div class="button-container">
            <a href="Deposit.jsp" class="success-button">Deposit Again</a>
            <a href="CustomerDashboard.jsp" class="dashboard-button">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
