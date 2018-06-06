<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 05.06.18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
<form action="/close" method="post">
<c:forEach items="${trans}" var="trans">
    <li>Product: ${trans.product}</li>
    <li>Buy price: ${trans.price}</li>
    <li>Current price: ${trans.currentPrice}</li>
    <li>Current profit: ${trans.profit}</li>
    <li>Status: ${trans.status}</li>
    <button type="submit" name="close" value="${trans.id}">Close</button>
</c:forEach>
</form>
</body>
</html>
