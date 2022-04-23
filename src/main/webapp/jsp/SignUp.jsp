<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.04.2022
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="../api/user" method="POST">
    <p>Login: <input type="text" name="login" />
        Password: <input type="text" name="password"/>
        Name: <input type="text" name="name"/>
        Date of birthday: <input type="text" name="dateOfBirth"/>
    <input type="submit" value="Register"></p>>
</form>

</body>
</html>
