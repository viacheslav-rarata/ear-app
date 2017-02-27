
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="POST" action="j_security_check">
        <label style="display:block; float:left; width: 80px;">Username:</label>
        <input type="text" name="j_username"><br>
        <label style="display:block; float:left; width: 80px;">Password:</label>
        <input type="password" name="j_password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
