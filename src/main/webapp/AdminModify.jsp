<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Customer Account</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #9FC5E8;
            font-family: Arial, sans-serif;
        }
        form {
            max-width: 600px;
            width: 100%;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .input-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        .input-group input {
            width: 100%;
            max-width: calc(100% - 22px);
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
        }
        .button {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <form action="FetchCustomerServlet" method="post">
        <h2>Enter Account Number to Modify</h2>
        <div class="input-group">
            <label for="accountno">Account Number</label>
            <input type="text" id="accountno" name="accountno" required>
        </div>
        <input type="submit" value="Fetch Details" class="button">
    </form>
</body>
</html>
