<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SP
  Date: 9/14/2017
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value="/"/>">Customer Transactions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/flutterWave"/>">Flutterwave Response</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/wamsLogs"/>">WAMS Transaction<span class="sr-only">(current)</span></a>
                </li>
            </ul>

        </nav>
        <main class="col-sm-9 ml-sm-auto col-md-10 pt-3" role="main">
            <h1>Dashboard</h1>
            <section class="text-center">
                <%--action="<c:url value="/searchAllFRequest"/>"--%>
                <form name="thisForm" action="<c:url value="/searchFRequest"/>" method="get" id="thisForm">
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label class="col-form-label">Transaction ID:</label>
                            <input type="text" name="transID" class="form-control" id="transID" placeholder="Transaction ID">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="col-form-label">Card No:</label>
                            <input type="text" name="card_no" class="form-control" id="card_no" placeholder="Card No">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="col-form-label">Ref No:</label>
                            <input type="text" name="refNO" class="form-control" id="refNO" placeholder="Ref No">
                        </div>
                        <div class="form-group col-md-3">
                            <label class="col-form-label">Status:</label>
                            <input type="text" name="status" class="form-control" id="status" placeholder="Status">
                        </div>

                    </div>
                    <input type="submit" class="btn btn-primary"/>

                </form>
            </section>

            <h2>Customer Transactions</h2>
            <div class="table-responsive">
                <table id="tableId" class="table table-striped table-hover display">
                    <thead>
                    <tr class="bg-success">
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Card No</th>
                        <th>Amount</th>
                        <th>Ref No</th>
                        <th>Status</th>
                    </tr>
                    </thead>

                    <tfoot>
                    <tr class="sm-success">
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Card No</th>
                        <th>Amount</th>
                        <th>Ref No</th>
                        <th>Status</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </main>
    </div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>
