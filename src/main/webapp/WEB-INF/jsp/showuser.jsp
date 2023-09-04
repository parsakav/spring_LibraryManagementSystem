<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


<form action="/admin/getalluser" method="get">
    <label for="size">Size: </label>

    <input type="number" value="1" name="size" id="size" required="required"/>
    <label for="page">Page: </label>
    <input type="number" value="1" name="page" id="page" required="required"/>
    <button type="submit">Show</button>
</form>
    <table class="table table-striped">
    <thead >
    <tr>
    <td scope="col" >Id</td>
    <td scope="col" >Name</td>
    <td scope="col" >Password</td>
    <td scope="col" >Delete</td>

    </tr>
    </thead>

    <c:forEach items="${users}" var="user">
        <tbody>

        <td scope="row" > <c:out value="${user.id}"/> </td>
        <td scope="row"> <c:out value="${user.username}"/> </td>

        <td scope="row"> <c:out value="${user.password}"/> </td>
        <td scope="row">
        <td scope="row">

        <form action="/admin/deluser" method="post">

    <input  name="id" type="hidden" value='${user.id}' />
    <input type="submit" class="btn-primary" value="Del"/>
</form>

        </td>
        </tbody>
    </c:forEach>
    </table>
</div>
<a class="btn-primary" href="/admin/adduser">Add User</a>

</body>

</html>
