<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product}</title>
</head>
<body>
<p>
    Price: ${price} </br>
    Product: ${fromCurrency} / ${toCurrency}</br>
    </br>
<form method="post" action="buyProduct">
    <input type="number" name="quantity" value="${quantity}" step="0.01">
    <input type="submit" name="buyButton" value="Buy" />
    <input type="hidden" name="price" value="${price}"/>
    <input type="hidden" name="product" value="${product}"/>
    <input type="hidden" name="fromCurrency" value="${fromCurrency}"/>
    <input type="hidden" name="toCurrency" value="${toCurrency}"/>
</form>
<form method="post" action="sellProduct">
<input type="submit" name="sellButton" value="Sell" />
</form>
</p>

</body>
</html>
