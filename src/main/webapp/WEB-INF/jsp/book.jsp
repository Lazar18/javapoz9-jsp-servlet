<%--
  Created by IntelliJ IDEA.
  User: Paweł Łazarewicz
  Date: 03.11.2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<c:choose>
<c:when test="${not empty book}">

    <h1>${book.title}</h1>
</c:when>
<c:otherwise>
    <h1>Brak książki</h1>
</c:otherwise>
</c:choose>
</body>
</html>
