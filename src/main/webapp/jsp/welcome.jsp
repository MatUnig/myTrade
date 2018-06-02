<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td>Welcome ${firstname}</td>
    </tr>
    <tr>
        <td>Your current balance is ${balance}</td>
    </tr>
    <tr>
        <form action="/pickProduct">
            <select name="products">
                <option value="usdpln">USD/PLN</option>
                <option value="btc">Bitcoin</option>
                <option value="eurusd">EUR/USD</option>
            </select>
            <br><br>
            <input type="submit">
        </form>
    </tr>
    <tr>
        <td><a href="home.jsp">Home</a></td>
    </tr>
</table>
</body>
</html>