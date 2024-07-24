<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #9FC5E8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            position: relative;
        }
        .dashboard-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .dashboard-container h1 {
            margin-bottom: 20px;
        }
        .button {
            display: inline-block;
            padding: 15px 25px;
            margin: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .button-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }
        .logout-button {
            position: absolute;
            top: 20px;
            right: 20px;
            background-color: #dc3545;
        }
        .logout-button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <a href="LogoutServlet" class="button logout-button">Logout</a>
    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>
        <div class="button-container">
            <a href="CustomerRegistration.jsp" class="button">Customer Registration</a>
            <a href="AdminModify.jsp" class="button">Modify Account</a>
            <a href="DeleteAccount.jsp" class="button">Delete Account</a>
            <a href="CustomerDetails" class="button">Customer Details</a>
        </div>
    </div>
</body>
</html>
