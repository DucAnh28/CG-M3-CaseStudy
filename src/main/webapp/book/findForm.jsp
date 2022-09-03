<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 02/09/2022
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="GET">
    <input type="text" name="name" placeholder="moi nhap ten">
    <input type="text" name="id" placeholder="moi nhap id">
    <input type="text" name="id" placeholder="moi nhap id de sua sach">
<%--    <input type="text" name="action" value="findByName" style="display: none">--%>
    <input type="submit" value="findById" name="action">
    <input type="submit" value="findByName" name="action">
    <input type="submit" value="edit" name="action">
</form>

</body>
</html>
