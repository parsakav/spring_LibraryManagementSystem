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
    <h5><a href="/book/list"> Click For Back</a></h5>
    <div align="center">

        <section class="get-in-touch">
            <h1 class="title">Add New Book Here</h1>
    <form:form  enctype="multipart/form-data" action="/book/add" method="post" modelAttribute="book" cssClass="contact-form row">
    <div class="form-field col-lg-6">
        <form:label path="name" cssClass="lable">Enter Book Name:</form:label>
        <form:input path="name" required="required" cssClass="input-text js-input"></form:input>
    </div>

        <div class="form-field col-lg-6">
            <form:label path="authors" cssClass="lable">Enter Book Author Names:</form:label>
            <form:input path="authors" type="text" required="required" cssClass="input-text js-input"/>
        </div>

        <div class="form-field col-lg-6">

            <form:label path="publisher">Enter Book Publisher:</form:label>
            <form:input path="publisher" type="text" required="required" cssClass="input-text js-input"/>

        </div class="form-field col-lg-6">

        <div class="form-field col-lg-6">

            <form:label path="published">Enter PublishedDate:</form:label>
            <form:input path="published" type="date" required="required" cssClass="input-text js-input"/>

        </div class="form-field col-lg-6">

        <div class="form-field col-lg-6">

            <form:label path="picture">Enter Picture Path:</form:label>
        <input accept=".png,.jpg,.jpeg" type="file" name="file"  required="required" class="input-text js-input"/>

        </div class="form-field col-lg-6">

        <div class="form-field col-lg-12">
            <input class="submit-btn" type="submit" value="Add Book">
        </div>

    </form:form>
        </section>

    </div>
</div>

</body>
