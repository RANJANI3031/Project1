<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #9FC5E8;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            text-align: center;
            background-color: #fff;
            padding: 40px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 100%;
            max-width: 400px;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .input {
            display: block;
            margin: 15px 0;
            padding: 12px;
            font-size: 16px;
            width: calc(100% - 24px);
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .input:focus {
            border-color: #007bff;
            outline: none;
        }
        .button {
            display: inline-block;
            margin: 20px 0;
            padding: 12px 24px;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .button:active {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Login</h1>
        <form action="AdminServlet" method="post">
            <input type="text" name="username" placeholder="Username" class="input" required>
            <input type="password" name="password" placeholder="Password" class="input" required>
            <input type="submit" value="Login" class="button">
        </form>
    </div>
</body>
</html>
