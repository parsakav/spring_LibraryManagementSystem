<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

</head>
<body>
<%@include file="header.jsp"%>
<br/>

<div class="container">
    <br>
    <div class="card">
        <form class="text-center border border-light p-5" action="/login" method="post">
            <p class=" h4 mb-4">Sign in</p>
            <input type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Username" name="username" required>
            <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" name="password" required>

            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

            <!-- Register -->
            <p>Not a member?
                <a  class="" href="/signup">Register</a>
            </p>
        </form>
        <!-- Default form login -->
    </div>
    <c:if test="${param.error ne null}">
    <span class="text-danger">Invalid username and password.
        ${param.error}
</span>
    </c:if>
    <c:if test="${param.logout ne null}">
    <span class="text-success">  You have been logged out.
</span>
    </c:if>
</div>


<script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
<%@include file="footer.jsp"%>

</body>
</html>
