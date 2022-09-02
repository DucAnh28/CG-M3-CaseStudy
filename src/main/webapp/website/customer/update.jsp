<%--
  Created by IntelliJ IDEA.
  User: drago
  Date: 31/08/2022
  Time: 11:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Detail</title>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<form method="post" action="">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Name</label>
            <input type="text" class="form-control" id="inputEmail4" value="${thisCus.name}">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword4">Age</label>
            <input type="text" class="form-control" id="inputPassword4" value="${thisCus.age}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputAddress">Address</label>
        <input type="text" class="form-control" id="inputAddress" value="${thisCus.address}">
    </div>
    <div class="form-group">
        <label for="inputAddress2">Phone</label>
        <input type="text" class="form-control" id="inputAddress2" value="${thisCus.phone}">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputCity">Email</label>
            <input type="email" class="form-control" id="inputCity" value="${thisCus.email}">
        </div>
        <div class="form-group col-md-2">
            <label for="inputZip">Account</label>
            <input type="text" class="form-control" id="inputZip" value="${thisCus.account}">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Confirm</button>
</form>
</body>
</html>
