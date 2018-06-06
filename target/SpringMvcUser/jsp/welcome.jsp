<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td>Welcome _set_firstName</td>
    </tr>
    <tr>
        <td>Your current balance is ${balance}</td>
    </tr>


    <tr>
        <form action="/pickProduct">
            From currency:</br>
            <select name="fromCurrency">
                <c:forEach items="${list}" var="shortName">
                    <option value="${shortName}">${shortName}</option>
                </c:forEach>
            </select>

            </br>
            To currency:</br>
            <select name="toCurrency">
                <c:forEach items="${list}" var="shortName">
                    <option value="${shortName}">${shortName}</option>
                    </c:forEach>
            </select>
            <input type="submit">
        </form>
    </tr>
    <tr>
        <td><a href="home.jsp">Home</a></td>
        <td><a href="/logout">Logout</a></td>
    </tr>
</table>
</body>
</html>