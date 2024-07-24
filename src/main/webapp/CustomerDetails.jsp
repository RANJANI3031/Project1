<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #9FC5E8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 90%;
            max-width: 1000px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #9FC5E8;
            color: #333;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
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
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Details</h2>
        <table>
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Email ID</th>
                    <th>Date of Birth</th>
                    <th>Account Number</th>
                    <th>Account Type</th>
                    <th>ID Proof</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.fullname}</td>
                        <td>${customer.address}</td>
                        <td>${customer.phono}</td>
                        <td>${customer.emailid}</td>
                        <td>${customer.dob}</td>
                        <td>${customer.accountno}</td>
                        <td>${customer.accounttype}</td>
                        <td>${customer.idProof}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="AdminDashboard.jsp" class="button">Back to Dashboard</a>
    </div>
</body>
</html>
