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
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
    .tg .tg-yw4l{vertical-align:top}
</style>
<form action="/close" method="post">

    <table class="tg">
        <tr>
            <th class="tg-yw4l">Product</th>
            <th class="tg-yw4l">Buy price</th>
            <th class="tg-yw4l">Current price</th>
            <th class="tg-yw4l">Current profit</th>
            <th class="tg-yw4l">Status</th>
            <th class="tg-yw4l">Close transaction</th>
        </tr>
        <c:forEach items="${trans}" var="trans">
        <tr>
            <td class="tg-yw4l">${trans.product}</td>
            <td class="tg-yw4l">${trans.price}</td>
            <td class="tg-yw4l">${trans.currentPrice}</td>
            <td class="tg-yw4l">${trans.profit}</td>
            <td class="tg-yw4l">${trans.status}</td>
            <td class="tg-yw4l"><button type="submit" name="close" value="${trans.id}">Close</button></td>
        </tr>
        </c:forEach>
    </table>
<%--<c:forEach items="${trans}" var="trans">--%>
    <%--<li>Product: ${trans.product}</li>--%>
    <%--<li>Buy price: ${trans.price}</li>--%>
    <%--<li>Current price: ${trans.currentPrice}</li>--%>
    <%--<li>Current profit: ${trans.profit}</li>--%>
    <%--<li>Status: ${trans.status}</li>--%>
    <%--<button type="submit" name="close" value="${trans.id}">Close</button>--%>
<%--</c:forEach>--%>
</form>
</body>
</html>
