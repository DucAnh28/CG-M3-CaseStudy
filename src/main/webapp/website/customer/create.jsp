<%--
  Created by IntelliJ IDEA.
  User: yoyo
  Date: 31/08/2022
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
</head>
<body>
<form method="post" action="/customer?action=create">
    <label>
        <input type="number" name="id" placeholder="ID">
    </label>
    <label>
        <input type="text" name="name" placeholder="Name">
    </label>
    <label>
        <input type="number" name="age" placeholder="Age">
    </label>
    <label>
        <input type="radio" name="gender" value="nam">
    </label>Male
    <label>
        <input type="radio" name="gender" value="nu">
    </label>Female
    <label>
        <input type="radio" name="gender" value="khac">
    </label>Another
    <label>
        <input type="text" name="address" placeholder="Address">
    </label>
    <label>
        <input type="text" name="phone" placeholder="Phone">
    </label>
    <label>
        <input type="text" name="email" placeholder="Email">
    </label>
    <label>
        <input type="text" name="account" placeholder="Account Name">
    </label>
    <label>
        <input type="password" name="password" placeholder="Your Password">
    </label>
    <label>
        <input type="submit" name="submit">
    </label>

</form>
</body>
</html>
