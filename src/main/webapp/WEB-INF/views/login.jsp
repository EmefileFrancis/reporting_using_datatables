<%--
  Created by IntelliJ IDEA.
  User: SP
  Date: 9/14/2017
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Flutterwave Report</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/dashboard.css"/>" rel="stylesheet">

    <!-- DataTables CDN -->
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">

    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="<c:url value="resources/js/datatables.js"/>"></script>

</head>
<body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">Flutterwave Report</a>
    </nav>

    <div class="container-wrapper">
        <div class="container">
            <br><br><br>
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Login</h4>

                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>

                </div>
                <div class="card-body">
                    <c:if test="${not empty error}">
                        <div class="error" style="color: #ff0000;">${error}</div>
                    </c:if>
                        <form action="<c:url value="/login"/>" method="post">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary">Login</button>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                </div>
            </div>
        </div>
    </div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="<c:url value="resources/js/jquery-3.2.1.min.js"/>"><\/script>')</script>
<script src="<c:url value="resources/js/popper.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

