<%--<!DOCTYPE html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
</head>
<body>

<%@include file="header.jsp"%>
<div class="container">
<br>
    <h5><a href="/publisher"> Click For Back</a></h5>
    <div align="center">

        <section class="get-in-touch">
            <h1 class="title">Edit Book Here</h1>
    <form:form  enctype="multipart/form-data" action="/publisher/edit" method="post" modelAttribute="book" cssClass="contact-form row">
    <div class="form-field col-lg-6">
        <form:label path="name" cssClass="lable">Enter Book Name:</form:label>
        <form:input path="name" required="required" cssClass="input-text js-input"></form:input>
    </div>

        <div class="form-field col-lg-6">
            <form:label path="id" cssClass="lable">Enter Book id:</form:label>
            <form:input path="id" type="text" required="required" cssClass="input-text js-input"/>
        </div>

        <div class="form-field col-lg-12">
            <input class="submit-btn" type="submit" value="Edit Book">
        </div>

    </form:form>
        </section>

    </div>
</div>

</body>
