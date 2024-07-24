<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Current Balance</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #9FC5E8; /* Changed to match previous customizations */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            padding: 20px 30px;
            max-width: 400px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .header {
            font-size: 24px;
            margin-bottom: 20px;
            font-weight: bold;
        }
        .balance {
            font-size: 20px;
            color: #333;
            margin-bottom: 20px;
        }
        .button {
            display: block;
            width: 100%;
            max-width: 200px;
            margin: 0 auto;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            text-transform: uppercase;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">Current Balance</div>
        <div class="balance">
            Your current balance is: Rs. <%= request.getAttribute("Balance") != null ? request.getAttribute("Balance") : "N/A" %>
        </div>
        <a href="CustomerDashboard.jsp" class="button">Back to Dashboard</a>
    </div>
</body>
</html>
