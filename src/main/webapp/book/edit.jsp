<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 03/09/2022
  Time: 15:23
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
<form action="/books?action=edit" method="POST" >
    <input type="submit" value="update">

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

        <tr>
            <td><input type="text" name="id" value="${book.getId()}"></td>
            <td><input type="text" name="code" value="${book.getCode()}"></td>
            <td ><input type="text" name="name" value="${book.getName()}"></td>
            <td><input type="text" name="author" value="${book.getAuthor()}"></td>
            <td><input type="text" name="price" value="${book.getPrice()}"></td>
<%--            <td><input type="image" name="image"  src="${book.getImage()}" alt="khong co anh"></td>--%>
            <td>${book.getImage()}</td>
            <td><input type="text" name="description" value="${book.getDescription()}"></td>
            <td>
                <select name="categories" id="categories" multiple>
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.id}">${c.type}</option>
                        <%--            <option value="${c.id}">${c.description}</option>--%>
                    </c:forEach>
                </select>
            </td>
        </tr>

</table>
</form>
</body>
</html>


