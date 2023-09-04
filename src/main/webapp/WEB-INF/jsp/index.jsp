<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Access the bootstrap Css like this,
        Spring boot will handle the resource mapping automcatically -->
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">


    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <c:url value="" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<%@include file="header.jsp"%>
<div class="container">
    <br>
    <br>
    <br>
    <br>

</div>

<script type="text/javascript" src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
<%@include file="footer.jsp"%>
</body>

