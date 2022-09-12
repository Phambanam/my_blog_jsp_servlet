<%--
  Created by IntelliJ IDEA.
  User: namlk
  Date: 9/9/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <!-- Blog entries-->
    <div class="col-lg-8">
        <!-- Featured blog post-->
        <div class="card mb-4">

            <a href="#!"><img class="card-img-top" src="${model.listResult[0].thumbnail}"
                              alt="..."/></a>
            <div class="card-body">

                <div class="small text-muted">${model.listResult[0].createdDate}</div>
                <h2 class="card-title">${model.listResult[0].title}</h2>
                <p class="card-text">${model.listResult[0].shortDescription}</p>
                <a class="btn btn-primary" href="<c:url value='/trang-chu?newmodelId=${model.listResult[0].id}'/>">Read more →</a>
            </div>
        </div>
        <!-- Nested row for non-featured blog posts-->
        <form method="get" id="submitForm" action="<c:url value='/trang-chu'/>">
        <div class="row">
            <c:forEach var="newmodel" items="${model.listResult}">
                <div class="col-lg-6">
                    <!-- Blog post-->

                    <div class="card mb-4">
                        <c:if test="${ not empty newmodel.thumbnail}">
                            <a href=""><img class="card-img-top img-top" width="355px"  height="256px" src="${newmodel.thumbnail}"
                                            alt="..."/></a>
                        </c:if>
                        <c:if test="${empty newmodel.thumbnail}">
                            <a href=""><img class="card-img-top img-top"  width="355px"  height="256px" src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                                            alt="..."/></a>
                        </c:if>
                        <div class="card-body">
                            <div class="small text-muted">${newmodel.createdDate}</div>
                            <h2 class="card-title h4">${newmodel.title}</h2>
                            <p class="card-text">${newmodel.shortDescription}</p>
                            <a class="btn btn-primary" href="<c:url value='/trang-chu?newmodelId=${newmodel.id}'/>">Read more →</a>
                        </div>
                    </div>
                    <!-- Blog post-->

                    <!-- Blog post-->
                </div>
            </c:forEach>
        </div>
            <input type="hidden" name="page" value="" id="page"/>
        </form>
        <!-- Pagination-->
        <nav aria-label="Pagination">
            <ul class="pagination  justify-content-center" id="pagination"></ul>
        </nav>
    </div>
    <!-- Side widgets-->
    <div class="col-lg-4">
        <!-- Search widget-->
        <div class="card mb-4">
            <div class="card-header">Search</div>
            <div class="card-body">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Enter search term..."
                           aria-label="Enter search term..." aria-describedby="button-search"/>
                    <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                </div>
            </div>
        </div>
        <!-- Categories widget-->
        <div class="card mb-4">
            <div class="card-header">Categories</div>
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-6">
                        <ul class="list-unstyled mb-0">
                            <li><a href="#!">Web Design</a></li>
                            <li><a href="#!">HTML</a></li>
                            <li><a href="#!">Freebies</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6">
                        <ul class="list-unstyled mb-0">
                            <li><a href="#!">JavaScript</a></li>
                            <li><a href="#!">CSS</a></li>
                            <li><a href="#!">Tutorials</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Side widget-->
        <div class="card mb-4">
            <div class="card-header">Side Widget</div>
            <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use, and
                feature the Bootstrap 5 card component!
            </div>
        </div>
    </div>
</div>
<script>
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $("#page").val(page);
                    $("#submitForm").submit();
                }
            }
        });
    });
</script>
</body>
</html>

