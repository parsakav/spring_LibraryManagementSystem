<!DOCTYPE html>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

</head>
<div class="container" align="center">


    <div class="container contact">
        <div class="row">

            <div class="col-md-3" align="center">
                <br>
                <p style="font: medium" align="justify">

                    <strong>Complete Book Deatils</strong>
                </p>

                <div>
                    <table class="table table-hover">
                        <tr>
                            <h5>
                                <td>Book Id</td>
                                <td>${clickbook.ISSN}</td>
                            </h5>
                        </tr>

                        <tr>
                            <h5>
                                <td>Name</td>
                                <td>${clickbook.name}</td>
                            </h5>
                        </tr>

                        <tr>
                            <h5>
                                <td>Authors</td>
                                <td>${clickbook.authors}</td>
                            </h5>
                        </tr>

                        <tr>
                            <h5>
                                <td>Published</td>
                                <td><fmt:formatDate value="${clickbook.published}" pattern="dd-MM-YYYY"></fmt:formatDate> </td>
                            </h5>
                        </tr>

                        <tr>
                            <h5>
                                <td>Publisher</td>
                                <td>${clickbook.publisher}</td>
                            </h5>
                        </tr>




                    </table>
                </div>
            </div>

            <div class="col-md-9">
                <div class="contact-info">
                    <br>
                    <img src="/images/istock_78312587_medium.jpg" alt="image" height="200" width="300"/>

                    <h2 style="color: #4cae4c">${clickbook.name} - Book</h2>
                </div>
            </div>

        </div>
    </div>


</div>
