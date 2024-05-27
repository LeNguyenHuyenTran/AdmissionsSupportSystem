<%-- 
    Document   : faculty
    Created on : 15 May 2024, 12:35:13
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
                    <div class="card-header">Faculty</div>
                    <div class="card-body">
                        <!-- /.row-->
                        <c:url value="/faculty" var="action"/>

                        <div class="d-flex">
                            <a href="${action}" class="me-auto btn btn-dark mb-3">Add Faculty</a>
                            <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                <input type="text" name="keyword" placeholder="Search" class="form-control"></input>
                                <button type="submit" class="btn btn-outline-primary">Search</button>
                            </form>
                        </div>


                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary">
                                            Id
                                        </th>
                                        <th class="bg-body-secondary">Name</th>
                                        <th class="bg-body-secondary">Website</th>

                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${faculties}" var="faculty" >
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap">${faculty.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${faculty.nameFaculty}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${faculty.website}</div>
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
