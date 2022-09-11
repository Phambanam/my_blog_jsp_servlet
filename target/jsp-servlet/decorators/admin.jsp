<%--
  Created by IntelliJ IDEA.
  User: namlk
  Date: 9/9/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->


    <link href="<c:url value='/templates/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet"
          type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <script src="<c:url value='/templates/admin/vendor/jquery/jquery.js'/>"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value='/templates/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>
    <link href="<c:url value='/templates/admin/css/sb-admin-2.min.css'/>" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/templates/admin/vendor/fontawesome-free/css/fontawesome.css"/>">
    <script src="<c:url value='/ckeditor/ckeditor.js' />"></script>



</head>
<body id="page-top">

<div id="wrapper">
    <%@ include file="/common/admin/menu.jsp" %>
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <%@ include file="/common/admin/header.jsp" %>
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                </div>
                <dec:body/>
            </div>
        </div>

    </div>

</div>
<%@ include file="/common/admin/footer.jsp" %>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value='/templates/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value='/templates/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value='/templates/admin/js/sb-admin-2.min.js'/>"></script>

<!-- Page level plugins -->
<script src="<c:url value='/templates/admin/vendor/chart.js/Chart.min.js'/>"></script>

<!-- Page level custom scripts -->
<%--<script src="<c:url value='/templates/admin/js/demo/chart-area-demo.js'/>"></script>--%>
<%--<script src="<c:url value='/templates/admin/js/demo/chart-pie-demo.js'/>"></script>--%>
</body>
</html>
