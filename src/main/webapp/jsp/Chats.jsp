<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23.04.2022
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<h3>Сообщения</h3>
<p>

<c:choose>
    <c:when test="${messages.size() > 0}">
        Cообщения:<br>
        <c:forEach var="message" items="${messages}">
            <li style="color:red"><c:out value="${message}"/></li>
        </c:forEach>
    </c:when>
    <c:otherwise>
        У вас нет сообщений.
    </c:otherwise>
</c:choose>
</p>