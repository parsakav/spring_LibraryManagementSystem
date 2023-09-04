<!DOCTYPE html>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>

</head>
<body>
<%@include file="header.jsp"%>
<div class="container" align="center">

<h4> Select book for getting details more..</h4>
<div class="container search-table">
    <div class="search-box">
        <div class="row">
            <div class="col-md-3">
                <h5>Search All Fields</h5>
            </div>
            <div class="col-md-9">
                <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Search your book name">
                <script>
                    $(document).ready(function () {
                        $("#myInput").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#myTable tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                    });
                </script>
            </div>
        </div>
    </div>
    <br>
    <div class="search-list">
        <table class="table" id="myTable">
            <thead>
            <tr>
                <th>Title</th>
                <th>Date of Entry</th>
                <th>Authors</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${searchbook}" var="book">
                <tr>
                    <td><a href="/book/get-book-details-one?book_name=${book.name}"> ${book.name}</a></td>
                    <td><fmt:formatDate value="${book.published}" pattern="dd-MMM-YYYY"></fmt:formatDate> </td>
                    <td>${book.authors}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>