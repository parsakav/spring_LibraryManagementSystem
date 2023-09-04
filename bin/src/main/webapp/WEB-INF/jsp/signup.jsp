<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" var="bootstrap" />
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

    <link rel="stylesheet" type="text/css" href="${bootstrap}" />

</head>
<body>
<%@include file="header.jsp"%>
<br/>
<%
    String attr= (String) request.getAttribute("singupok");

    if(attr != null) {
        if (attr.equals("true")) {
            response.sendRedirect("/");
        }
    }
%>
    <br>

<div class="container">
    <div class="card">
        <form class="text-center border border-light p-5" action="/signup/adduser" method="post">

            <p class=" h4 mb-4">Sign up</p>

            <!-- Email -->
            <input required type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail" name="username">

            <!-- Password -->
            <input required type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" name="password">

            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

            <!-- Register -->
            <p>You have an account?
                <a  class="" href="/login">Login</a>
            </p>
        </form>
        <!-- Default form login -->
    </div>

<c:if test="${error ne null}">
    <br>
    <span>error: ${error}</span>
</c:if>
</div>
    <%@include file="footer.jsp"%>

</body>
</html>
