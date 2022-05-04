<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>AirportTable</title>
    <style>
        .text {
            text-align:  center;
        }
        table {
            width: 1000px;
            border: 1px solid green;
            border-collapse: collapse;
            margin: auto;
        }
        td, th {
            border: 1px solid maroon;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="text">
    <h2>Аэропорты</h2>
</div>
<table>
    <tr>
        <td>Код аэропорта</td>
        <td>Название аэропорта</td>
        <td>Город</td>
        <td>Координаты</td>
        <td>Временная зона</td>
    </tr>
    <c:forEach items="${airports}" var="airport" >
        <tr>
            <td>${airport.getCode()}</td>
            <td>${airport.getName()}</td>
            <td>${airport.getCity()}</td>
            <td>${airport.getCoordinates()}</td>
            <td>${airport.getTimezone()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
