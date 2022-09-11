<%--
  Created by IntelliJ IDEA.
  User: namlk
  Date: 9/9/2022
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#!">Nam's Blog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
        <c:if test="${empty USERMODEL}">
          <li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap?action=login'/>">Sign in</a></li>
          <li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap?action=register'/>">Sign up</a></li>
        </c:if>
        <c:if test="${not empty USERMODEL}">
          <li class="nav-item"><a class="nav-link" href="#">Wellcome</a></li>
          <li class="nav-item"><a class="nav-link"href="#">${USERMODEL.fullName}</li>
        </c:if>

      </ul>
    </div>
  </div>
</nav>
