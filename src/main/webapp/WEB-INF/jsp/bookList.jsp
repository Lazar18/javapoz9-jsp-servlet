<%--
  Created by IntelliJ IDEA.
  User: Paweł Łazarewicz
  Date: 03.11.2018
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello I'm Bob.</title>
</head>
<body>
<h1>Lista Książek</h1>

<table style="border-collapse: collapse" border="2">
    <c:forEach var="book" items="${books}" varStatus="loop">
        <%--<c:if test="${((loop.index+1)%2) != 0}">--%>
        <tr>
            <td>${book.id}</td>
            <td><a href="/javapoz9-jsp-servlet-1.0-SNAPSHOT/books?id=${book.id}">${book.title}</a></td>
            <td><a href="/javapoz9-jsp-servlet-1.0-SNAPSHOT/books?author=${book.author}">${book.author}</a></td>
            <td>${book.description}</td>
            <td>${book.isbn}</td>
            <td>${book.date}</td>
        </tr>
        <%--</c:if>--%>
    </c:forEach>

</table>
<br>
<c:if test="${authorFilter}">
    <button onclick="window.location = '/javapoz9-jsp-servlet-1.0-SNAPSHOT/books';">Powrót do listy książek</button>
    <%--<a href="./books">Powrót do listy książek</a>--%>
</c:if>

</body>
</html>
