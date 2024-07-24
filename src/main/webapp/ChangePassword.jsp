<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #9FC5E8;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 300px; /* Set a fixed width for better layout */
        }
        .input {
            display: block;
            margin: 10px auto; /* Center the elements horizontally */
            padding: 10px;
            font-size: 16px;
            width: calc(100% - 22px); /* Adjust the width to account for padding */
            box-sizing: border-box; /* Include padding and border in the element's total width and height */
        }
        .button {
            display: block;
            margin: 20px auto; /* Center the button horizontally */
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            width: 100%; /* Make the button take full width */
            box-sizing: border-box; /* Include padding and border in the element's total width and height */
        }
        .button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Change Password</h1>
        <form action="ChangePasswordServlet" method="post">
            <input type="password" name="oldPassword" placeholder="Old Password" class="input" required>
            <input type="password" name="newPassword" placeholder="New Password" class="input" required>
            <input type="password" name="confirmPassword" placeholder="Confirm New Password" class="input" required>
            <input type="submit" value="Change Password" class="button">
        </form>
        <div class="error">
            <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
        </div>
    </div>
</body>
</html>
