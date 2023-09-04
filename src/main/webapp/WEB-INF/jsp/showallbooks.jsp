<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<%@include file="header.jsp"%>
<div class="container">
<br>

<form action="/book/list" method="get">
    <label for="size">Size: </label>

    <input type="number" value="1" name="size" id="size" required="required"/>
    <label for="page">Page: </label>
    <input type="number" value="1" name="page" id="page" required="required"/>
    <button type="submit">Show</button>
</form>
    <span style="float: right">
        <a href="/book/get-details" class="btn btn-outline-success">Search BookDetails</a>
    </span>


    <table class="table table-striped">
        <thead >
        <tr>
            <td scope="col" >ISSN</td>
            <td scope="col" >Name</td>
            <td scope="col" >Authors</td>
            <td scope="col" >Date of Entered</td>
            <td scope="col" >Date of Published</td>
<%--            <td scope="col" >Pic</td>--%>


        </tr>
        </thead>
        <c:forEach items="${books}" var="book">
            <tbody>

            <td scope="row" > <c:out value="${book.ISSN}"/> </td>
            <td scope="row"> <c:out value="${book.name}"/> </td>
            <td scope="row"> <c:out value="${book.authors}"/> </td>
            <td scope="row"><fmt:formatDate value="${book.added}" pattern="dd-MM-YYYY"></fmt:formatDate></td>
            <td scope="row"><fmt:formatDate value="${book.published}" pattern="dd-MM-YYYY"></fmt:formatDate></td>
<%--            <td scope="row"> <c:out value="${book.added}"/> </td>--%>
<%--            <td scope="row">--%>
<%--<c:if test="${book.picture ne null}">--%>
<%--                <img width="50px" height="50px" class="img-fluid"  src="/images/${book.picture}">--%>
<%--</c:if>--%>
<%--            </td>--%>
            <security:authorize access="hasRole('PUBLISHER')">
            <td scope="row"><a href="/book/edit?id=${book.ISSN}" class="btn btn-dark">Edit</a></td>
            <td scope="row"><a href="/book/delete?id=${book.ISSN}" class="btn btn-danger">Delete</a></td>
            </security:authorize>

            <td scope="row">
            </td>
            </tbody>
        </c:forEach>
    </table>
    <security:authorize access="hasRole('PUBLISHER')">
        <a href="/book/add" class="btn btn-success">Add New Book</a>

    </security:authorize>
</div>
</body>

</html>