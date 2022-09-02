<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 01/09/2022
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<table>
<%--    <form href="/books?action=findByName">--%>
<%--        <input type="text" name="name" id="name" placeholder="moi nhap ten sach can tra">--%>
<%--        <input type="submit" value="submit">--%>
<%--    </form>--%>
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
            <td>${b.getId()}</td>
            <td>${b.getCode()}</td>
            <td >${b.getName()}</td>
            <td>${b.getAuthor()}</td>
            <td>${b.getPrice()}</td>
            <td><img style="height: 50px; width: 50px" src="${b.getImage()}" alt="khong co anh"></td>
            <td>${b.getDescription()}</td>
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
