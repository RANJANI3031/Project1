<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
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
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .welcome {
            font-size: 20px;
        }
        .options {
            margin-top: 20px;
        }
        .button {
            display: block;
            margin: 10px 0;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="welcome">
                Welcome, ${customerName}!<br>
                Account Number: ${accountNumber}
            </div>
            <form action="LogoutServlet" method="post">
                <input type="submit" value="Log Out" class="button">
            </form>
        </div>
        <div class="options">
            <a href="Deposit.jsp" class="button">Deposit</a>
            <a href="Withdraw.jsp" class="button">Withdraw</a>
            <a href="ViewTransaction.jsp" class="button">View Transactions</a>
            <a href="ViewBalanceServlet" class="button">View Current Balance</a>
            <a href="ChangePassword.jsp" class="button">Change Password</a>
        </div>
    </div>
</body>
</html>
