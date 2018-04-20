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
                    <a class="nav-link" href="<c:url value="/"/>">Customer Transactions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/flutterWave"/>">Flutterwave Response</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value="/#"/>">WAMS Transaction<span class="sr-only">(current)</span></a>
                </li>
            </ul>

        </nav>
        <main class="col-sm-9 ml-sm-auto col-md-10 pt-3" role="main">
            <h1>Dashboard</h1>
            <section class="text-center">
                <form action="<c:url value="/searchWamsLog"/>" method="get">
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="id" class="col-form-label">Log ID:</label>
                            <input type="text" name="id" class="form-control" id="id" placeholder="Log ID">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="paycomNo" class="col-form-label">Paycom No:</label>
                            <input type="text" name="paycomNo" class="form-control" id="paycomNo" placeholder="Paycom No">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="wamsResp" class="col-form-label">Wams Response:</label>
                            <input type="text" name="wamsResp" class="form-control" id="wamsResp" placeholder="Wams Resp">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="wamsResponseID" class="col-form-label">Wams Response ID:</label>
                            <input type="text" name="wamsResponseID" class="form-control" id="wamsResponseID" placeholder="Wams Response ID">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="fRequest_ID" class="col-form-label">Transaction ID:</label>
                            <input type="text" name="fRequest_ID" class="form-control" id="fRequest_ID" placeholder="Transaction ID">
                        </div>
                    </div>
                    <input type="submit" class="btn btn-primary"/>
                </form>
            </section>

            <h2>Wams Log</h2>
            <div class="table-responsive">
                <table id="tableId" class="table table-striped table-hover display">
                    <thead>
                    <tr class="bg-success">
                        <th>#</th>
                        <th>Paycom No</th>
                        <th>Wams Response</th>
                        <th>Wams Response ID</th>
                        <th>Amount</th>
                        <th>Transaction ID</th>
                    </tr>
                    </thead>

                    <tfoot>
                    <tr class="sm-success">
                        <th>#</th>
                        <th>Paycom No</th>
                        <th>Wams Response</th>
                        <th>Wams Response ID</th>
                        <th>Amount</th>
                        <th>Transaction ID</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </main>
    </div>
</div>
</main>
</div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<script>window.jQuery || document.write('<script src="<c:url value="resources/js/jquery-3.2.1.js"/>"><\/script>')</script>
<script src="<c:url value="resources/js/popper.min.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>

<!-- DataTables Plugin -->
<script src="<c:url value="resources/js/jquery.dataTables.js"/>"></script>

<!-- BootStrap DataTables Script -->
<script src="<c:url value="resources/js/dataTables.bootstrap4.js"/>"></script>

<script src="<c:url value="resources/js/wamslog.js"/>"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
