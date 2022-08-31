<%--
  Created by IntelliJ IDEA.
  User: yoyo
  Date: 30/08/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>List</h1>
<table border="1px solid">
    <tr>
        <th>#</th>
        <th>Khach hang</th>
        <th>Ngay Mua</th>
    </tr>
    <tr>
        <c:forEach items="${dsgh}" var="b">
            <td>${b.id}</td>
            <td>${b.customer_id}</td>
            <td>${b.dateBuy}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
