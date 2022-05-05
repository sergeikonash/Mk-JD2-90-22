<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Flights</title>
    <style>
    .text {
    text-align:  center;
    }
    </style>
</head>
<body>
<div class="text">
    <h2>Фильтр по рейсам</h2>
</div>
<form action="${pageContext.request.contextPath}/filterFlights" method="POST">
    <p>Дата вылета*: <input type="text" name="dateOfDeparture" />
       Аэропорт вылета:
        <select name="airportOfDeparture">
            <option disabled selected value> Выбрать аэропорт </option>
            <c:forEach  var="airport" items="${airports}">
                <option name="airport" value="${airport}">${airport}</option>
            </c:forEach>
        </select>
       Дата прилета*: <input type="text" name="dateOfArrival"/>
       Аэропорт прилета:
        <select name="airportOfArrival">
            <option disabled selected value> Выбрать аэропорт </option>
            <c:forEach  var="airport" items="${airports}">
                <option name="airport" value="${airport}">${airport}</option>
            </c:forEach>
        </select>
       <input type="submit" value="Найти"><br><br>
    </p>
    <p>* дата в формате "гггг-мм-дд"</p>
</form>

</body>
</html>
