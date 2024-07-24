<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Customer Account</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #9FC5E8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        h2 {
            color: #333333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333333;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .form-group input[type="submit"] {
            background-color: #d9534f;
            color: #ffffff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            padding: 10px;
            transition: background-color 0.3s ease;
            border-radius: 5px;
            margin-top: 20px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #c9302c;
        }
        .feedback {
            margin-top: 20px;
            color: #d9534f;
            font-size: 14px;
        }
    </style>
    <script>
        function validateForm() {
            var accountNo = document.getElementById("Accountno").value;
            if (accountNo.trim() === "" || isNaN(accountNo) || accountNo <= 0) {
                alert("Please enter a valid positive account number.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Delete Customer Account</h2>
        <form action="AccountDeletionServlet" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="Accountno">Account Number</label>
                <input type="text" id="Accountno" name="Accountno" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Delete">
            </div>
        </form>
        <!-- Display feedback messages -->
        <div class="feedback">
            <% if (request.getAttribute("status") != null) { %>
                <p><%= request.getAttribute("status") %></p>
            <% } %>
        </div>
    </div>
</body>
</html>
