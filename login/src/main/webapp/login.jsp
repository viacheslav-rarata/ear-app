<%--
  Created by IntelliJ IDEA.
  User: vyacheslav
  Date: 24.02.17
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="j_security_check">

    Username: <input type="text"     name="j_username"><br />
    Password: <input type="password" name="j_password"><br />
    <br />

    <input type="submit" value="Login">
    <input type="reset"  value="Reset">

</form>
</body>
</html>
