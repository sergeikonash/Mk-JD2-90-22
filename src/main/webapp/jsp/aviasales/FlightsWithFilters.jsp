<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 03.05.2022
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FlightsWithFilters</title>
    <style>
        .text {
            text-align:  center;
        }
        table {
            width: 1350px;
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
    <h2>Результаты поиска</h2>
</div>
<table>
    <tr>
        <td>Id рейса</td>
        <td>Номер рейса</td>
        <td>Дата вылета</td>
        <td>Аэропорт вылета</td>
        <td>Дата прилета</td>
        <td>Аэропорт прилета</td>
        <td>Статус</td>
        <td>Код самолета</td>
        <td>Актуальная дата вылета</td>
        <td>Актуальная дата прилета</td>
    </tr>
    <%--@elvariable id="flights" type="java.util.List"--%>
    <c:forEach items="${flights}" var="flight" >
        <tr>
            <td>${flight.getFlightId()}</td>
            <td>${flight.getFlightNumber()}</td>
            <td>${flight.getDateOfDeparture()}</td>
            <td>${flight.getAirportOfDeparture()}</td>
            <td>${flight.getDateOfArrival()}</td>
            <td>${flight.getAirportOfArrival()}</td>
            <td>${flight.getStatus()}</td>
            <td>${flight.getAircraftCode()}</td>
            <td>${flight.getActualDeparture()}</td>
            <td>${flight.getActualArrival()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
