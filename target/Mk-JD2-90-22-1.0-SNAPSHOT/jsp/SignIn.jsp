<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 20.04.2022
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<form action="../api/login" method="POST">
    <p>Login: <input type="text" name="login" />
        Password: <input type="text" name="password"/>
    <input type="submit" value="Submit"></p>>
</form>

</body>
</html>
