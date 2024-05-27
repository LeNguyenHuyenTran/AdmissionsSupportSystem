<%-- 
    Document   : image
    Created on : 14 May 2024, 18:47:01
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
                    <div class="card-header">Images</div>
                    <div class="card-body">
                        <!-- /.row-->
                        <c:url value="/images" var="action"/>
                        
                        <div class="d-flex">
                            <a href="<c:url value="/products" />" class="me-auto btn btn-dark mb-3">Add Image</a>
                        </div>

                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary">Id</th>
                                        <th class="bg-body-secondary">Source</th>
                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${images}" var="image" >
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap">${image.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">
                                                    <img class="rounded float-start img-fluid" width="300" src="${image.source}" alt="${image.id}"/>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a class="dropdown-item" href="#">Info</a>
                                                        <a class="dropdown-item" href="#">Edit</a>
                                                        <a class="dropdown-item text-danger" href="#">Delete</a>
                                                    </div>
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
