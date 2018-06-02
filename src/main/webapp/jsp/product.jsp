<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tosiak
  Date: 01.06.18
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product}</title>
</head>
<body>
<p>
    Price: ${price} </br>
    Product: ${product}</br>
<form method="post" action="buyProduct">
    <input type="submit" name="buyButton" value="Buy" />
    <input type="hidden" name="product" value="${product}"/>
    <input type="hidden" name="price" value="${price}"/>
</form>
<form method="post" action="sellProduct">
<input type="submit" name="sellButton" value="Sell" />
</form>
</p>

</body>
</html>
