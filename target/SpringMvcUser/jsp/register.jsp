<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="../style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<form:form id="regForm" modelAttribute="user" action="registerProcess"
           method="post">

    <table align="center">
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" name="name" id="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname" name="surname" id="surname"/></td>
            <td><form:errors path="surname"/></td>
        </tr>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username" name="username" id="username"/></td>
            <td><form:errors path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password" name="password" id="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" name="email" id="email"/></td>
            <td><form:errors path="email"/></td>
        </tr>
        <td><form:input path="balance" name="balance" id="balance" type="hidden"/></td>
        <tr>
            <td></td>
            <td><form:button id="register" name="register">Register</form:button></td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="home.jsp">Home</a></td>
        </tr>
    </table>
</form:form>

</body>
</html>