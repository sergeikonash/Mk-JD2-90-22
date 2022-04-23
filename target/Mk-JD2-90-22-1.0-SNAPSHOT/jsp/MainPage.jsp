<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.04.2022
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>


<body>

<c:if test="${user == null}">
    <h3 style="color: blue">Зарегистрируйтесь или авторизуйтесь</h3>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/registration'" value="Зарегистрироваться"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn'" value="войти в аккаунт"></p>
</c:if>

<c:if test="${user != null}">
    <h3 style="color: green">Привет, <c:out value="${user.login}"/>!</h3>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message'" value="Написать сообщение"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats'" value="Посмотреть сообщения"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics'" value="Статистика"></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/out'" value="Выйти"></p>
</c:if>

</body>
</html>