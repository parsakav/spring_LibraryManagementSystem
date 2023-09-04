<%--
  Created by IntelliJ IDEA.
  User: parsa
  Date: 21.07.21
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adduser</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <spring:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" var="bootstrap" />
  <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

  <link rel="stylesheet" type="text/css" href="${bootstrap}" />
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
  <div class="card">
<form method="post" action="/admin/adduser">
  <!-- Email -->
  <input required type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail" name="username">

  <!-- Password -->
  <input required type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" name="password">

  <!-- Sign in button -->
  <button class="btn btn-info btn-block my-4" type="submit">Add</button>

</form>
  </div>
</div>


</body>
</html>
