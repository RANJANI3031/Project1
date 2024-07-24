<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9f5e9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .message {
            color: green;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .tick {
            font-size: 50px;
            color: green;
            margin-bottom: 20px;
        }
        .details {
            font-size: 16px;
            margin-top: 10px;
            margin-bottom: 20px;
        }
        .button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="tick">✔</div>
        <div class="message">Customer details updated successfully.</div>
        
        <a href="AdminDashboard.jsp" class="button">Back to Dashboard</a>
    </div>
</body>
</html>
