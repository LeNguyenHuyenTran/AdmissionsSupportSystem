<%-- 
    Document   : news
    Created on : 15 May 2024, 12:35:30
    Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="body flex-grow-1">
    <div class="container-lg px-4">
        <!-- /.row-->
        <div class="row">
            <div class="col-md-12">
                <div class="card mb-4">
                    <div class="card-header">News</div>
                    <div class="card-body">
                        <!-- /.row-->
                        <c:url value="/news" var="action"/>

                        <div class="d-flex">
                            <a href="<c:url value="/news" />" class="me-auto btn btn-dark mb-3">Add News</a>
                            <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                    <input type="checkbox" class="btn-check" name = "all" id="btncheck1" autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btncheck1">Tất cả</label>

                                    <input type="checkbox" class="btn-check" name="admission-news" id="btncheck2" autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btncheck2">Tin tuyển sinh</label>

                                    <input type="checkbox" class="btn-check" name="livestream-news" id="btncheck3" autocomplete="off">
                                    <label class="btn btn-outline-primary" for="btncheck3">Tin livestream</label>
                                </div>
                                <button type="submit" class="ms-1 btn btn-dark">Lọc</button>

                            </form>
                        </div>


                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary">Id</th>
                                        <th class="bg-body-secondary">Title</th>
                                        <th class="bg-body-secondary">Content</th>
                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${news}" var="news" >
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap">${news.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${news.title}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${news.content}</div>
                                            </td>
                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Info</a><a class="dropdown-item" href="#">Edit</a><a class="dropdown-item text-danger" href="#">Delete</a></div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.col-->
        </div>
        <!-- /.row-->
    </div>
</div>
