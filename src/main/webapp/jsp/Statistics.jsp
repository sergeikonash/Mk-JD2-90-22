<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.04.2022
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>

<h2>Статистика</h2>

<p>Кол-во отправленных сообщений: ${requestScope.messages}</p>
<p>Кол-во активных пользователей: ${requestScope.loggedUsers}</p>

<input type="button" onclick="history.back();" value="Назад"/>

</body>
</html>