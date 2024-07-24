<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration</title>
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
        .registration-container {
            background-color: #ffffff;
            padding: 15px; /* Reduced padding */
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 350px; /* Reduced width */
        }
        .box-title {
            background-color: #007bff;
            color: #ffffff;
            padding: 8px; /* Reduced padding */
            border-radius: 10px 10px 0 0;
            text-align: center;
            font-size: 16px; /* Reduced font size */
            font-weight: bold;
            margin: -15px -15px 15px -15px; /* Adjusted margin */
        }
        .form-group {
            margin-bottom: 8px; /* Reduced margin */
        }
        .form-group label {
            display: block;
            margin-bottom: 4px; /* Reduced margin */
            font-weight: bold;
            color: #333333;
            font-size: 12px; /* Reduced font size */
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 6px; /* Reduced padding */
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 12px; /* Reduced font size */
        }
        .form-group input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            cursor: pointer;
            font-size: 14px; /* Reduced font size */
            padding: 8px; /* Reduced padding */
            transition: background-color 0.3s ease;
            border-radius: 5px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: #ff0000;
            font-size: 12px; /* Reduced font size */
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="registration-container">
        <div class="box-title">Customer Registration</div>
        <form action="CustomerRegistrationServlet" method="post">
            <div class="form-group">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="fullname" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="form-group">
                <label for="phono">Phone Number</label>
                <input type="text" id="phono" name="phono" required>
            </div>
            <div class="form-group">
                <label for="emailid">Email ID</label>
                <input type="email" id="emailid" name="Emailid" required>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="DOB" required>
            </div>
            <div class="form-group">
                <label for="accounttype">Account Type</label>
                <select id="accounttype" name="Accounttype" required>
                    <option value="Savings">Savings</option>
                    <option value="Current">Current</option>
                </select>
            </div>
            <div class="form-group">
                <label for="balance">Initial Balance</label>
                <input type="number" id="balance" name="Balance" step="0.01" min="1000" required>
            </div>
            <div class="form-group">
                <label for="idproof">ID Proof</label>
                <select id="idproof" name="Idproof" required>
                    <option value="Aadhar">Aadhar</option>
                    <option value="PAN">PAN</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" value="Register">
            </div>
            <c:if test="${not empty errorMessage}">
                <p class="error-message">${errorMessage}</p>
            </c:if>
        </form>
    </div>
</body>
</html>
