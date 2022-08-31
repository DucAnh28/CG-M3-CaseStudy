<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 31/08/2022
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach sach</h1>
<table border="1px solid">
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Image</th>
        <th>Description</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${books}" var="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.code}</td>
            <td>${b.name}</td>
            <td>${b.author}</td>
            <td>${b.price}</td>
            <td>${b.image}</td>
            <td>${b.description}</td>
            <td>
                <c:forEach items="${b.categories}" var="c">
                    <span>${c.type}</span> &nbsp;
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
