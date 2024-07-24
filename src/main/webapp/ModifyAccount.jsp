<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Customer Account</title>
    <style>
        body {
            background-color: #9FC5E8;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .input-group {
            margin-bottom: 15px;
        }
        .input-group label {
            display: block;
            margin-bottom: 5px;
        }
        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .message {
            color: red;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 style="text-align: center;">Modify Customer Account</h2>
        <form action="UpdateCustomerServlet" method="post">
            <c:if test="${not empty message}">
                <div class="message">${message}</div>
            </c:if>
            <div class="input-group">
                <label for="accountno">Account Number</label>
                <input type="text" id="accountno" name="accountno" value="${customer.accountno}" readonly>
            </div>
            <div class="input-group">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="fullname" value="${customer.fullname}">
            </div>
            <div class="input-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" value="${customer.address}">
            </div>
            <div class="input-group">
                <label for="phono">Phone</label>
                <input type="text" id="phono" name="phono" value="${customer.phono}">
            </div>
            <div class="input-group">
                <label for="emailid">Email ID</label>
                <input type="email" id="emailid" name="emailid" value="${customer.emailid}">
            </div>
            <div class="input-group">
                <label for="dob">Date of Birth</label>
                <input type="text" id="dob" name="dob" value="${customer.dob}">
            </div>
            <div class="input-group">
                <label for="accounttype">Account Type</label>
                <input type="text" id="accounttype" name="accounttype" value="${customer.accounttype}">
            </div>
            <div class="input-group">
                <label for="idProof">ID Proof</label>
                <input type="text" id="idProof" name="idProof" value="${customer.idProof}">
            </div>
            <input type="submit" value="Update" class="button">
        </form>
    </div>
</body>
</html>
