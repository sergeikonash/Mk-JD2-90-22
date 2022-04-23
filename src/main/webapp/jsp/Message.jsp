<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22.04.2022
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Message</title>
</head>
<body>
<h3>Написать сообщение</h3>

<c:if test="${message == true}">
    <p style="color: blue">Пользователя с таким логином не существует</p>
</c:if>

<form action="${pageContext.request.contextPath}/api/message" method="POST">
    <p><b>Получатель </b><input type="text" placeholder="Логин" name="recipient"></p>
    <p><b>Текст </b><input type="text" placeholder="Текст сообщения" name="textOfMessage"></p>
    <p><input type="submit" value="Отправить"></p>
</form>

<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui'" value="Главная"></p>

</body>
</html>
