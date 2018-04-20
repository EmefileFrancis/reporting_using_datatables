<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SP
  Date: 9/14/2017
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <link rel="icon" href="../../../../favicon.ico">

    <title>Flutterwave Report - ${title}</title>

    <script>
        window.menu = '${title}';
        window.contextRoot = '${contextRoot}';
        /*window.idVar = "empty";
        window.card_noVar = "empty";
        window.refNOVar = "empty";
        window.statusVar = "empty";*/
    </script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="<c:url value="resources/css/dataTables.bootstrap4.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/dashboard.css"/>" rel="stylesheet">


</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Flutterwave Report</a>
</nav>
<ul class="nav md-dark justify-content-end">
    <li class="nav-item">
        <a class="nav-link active" href="#">Excel</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">CSV</a>
    </li>
</ul>



