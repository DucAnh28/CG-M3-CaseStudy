<%--
  Created by IntelliJ IDEA.
  User: yoyo
  Date: 30/08/2022
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Of Customer</title>
</head>
<body>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Account</th>
        <th>Password</th>
        <th>Date Join</th>
    </tr>
    <tr>
        <c:forEach items="${dskh}" var="listCus">
            <td>${listCus.id}</td>
            <td>${listCus.name}</td>
            <td>${listCus.age}</td>
            <td>${listCus.gender}</td>
            <td>${listCus.address}</td>
            <td>${listCus.phone}</td>
            <td>${listCus.email}</td>
            <td>${listCus.account}</td>
            <td>${listCus.password}</td>
            <td>${listCus.startDate}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
