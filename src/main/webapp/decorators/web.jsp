<%--
  Created by IntelliJ IDEA.
  User: namlk
  Date: 9/9/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
  <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <title>Blog Home - Start Bootstrap Template</title>
      <script src="<c:url value='/templates/admin/vendor/jquery/jquery.js'/>"></script>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
      <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
      <script src="<c:url value='/templates/paging/jquery.twbsPagination.js'/>" type="text/javascript"></script>
      <!-- Favicon-->
      <link rel="icon" type="image/x-icon" href="<c:url value= '/templates/web/assets/favicon.ico'/>" />
      <!-- Core theme CSS (includes Bootstrap)-->
      <link href="<c:url value= '/templates/web/css/styles.css'/>" rel="stylesheet" />


  </head>
  <body>
  <%@include file="/common/web/menu.jsp"%>
  <%@include file="/common/web/header.jsp"%>
  <div class="container">
  <dec:body/>
  </div>
  <%@include file="/common/web/footer.jsp"%>
  <!-- Bootstrap core JS-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="<c:url value= '/templates/web/js/scripts.js'/>"></script>
  </body>
</html>
