<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 01/09/2022
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Book</title>
</head>
<body>
<h1>View Book</h1>
<%--<p>--%>
<%--    <a href="/books">Back to product list</a>--%>
<%--</p>--%>
<form method="get">
    <input type="text" name="name" id="name" placeholder="moi nhap ten sach can tra">
</form>
<table>
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
    <c:forEach items="${bookss}" var="b">
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
