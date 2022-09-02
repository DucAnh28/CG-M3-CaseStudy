<%--
  Created by IntelliJ IDEA.
  User: ishopjapan
  Date: 02/09/2022
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Book</title>
</head>
<body>
<h1>Delete Book</h1>
<p>
    <a href="/books">Back to product list</a>
</p>
<form>
    <h3>Are you sure</h3>
    <fieldset>
        <table>
            <tr>
                <td><input type="submit" value="Delete book"></td>
                <td><a href="/books">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
