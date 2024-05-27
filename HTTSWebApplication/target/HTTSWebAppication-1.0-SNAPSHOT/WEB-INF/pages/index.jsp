<%-- 
    Document   : index
    Created on : 12 May 2024, 21:42:55
    Author     : minh-nguyen
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="body flex-grow-1">
    <div class="container-lg px-4">
        <!-- /.row-->
        <div class="row">
            <div class="col-md-12">
                <div class="card mb-4">
                    <div class="card-header">Users</div>
                    <div class="card-body">
                        <!-- /.row-->
                        <c:url value="/" var="action"/>

                        <div class="d-flex">
                            <a href="<c:url value="/products" />" class="me-auto btn btn-dark mb-3">Add User</a>
                            <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                <input type="text" name="keyword" placeholder="Search" class="form-control"></input>
                                <button type="submit" class="btn btn-outline-primary">Search</button>
                            </form>
                        </div>


                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary text-center">
                                            Avatar
                                        </th>
                                        <th class="bg-body-secondary">User</th>
                                        <th class="bg-body-secondary">Address</th>
                                        <th class="bg-body-secondary">Phone</th>
                                        <th class="bg-body-secondary">Password</th>
                                        <th class="bg-body-secondary">Role</th>
                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user" >
                                        <tr class="align-middle"> 
                                            <td class="text-center">
                                                <div class="avatar avatar-md">
                                                    <c:set var="theString" value="${user.avatar}"/>
                                                    <c:if test="${fn:contains(theString, 'http')==true}">
                                                        <img class="avatar-img" src="${user.avatar}" alt="user@email.com">
                                                    </c:if>
                                                    <c:if test="${fn:contains(theString, 'http')==false}">
                                                        <img class="avatar-img" src="resources/images/${user.avatar}" alt="user@email.com">
                                                    </c:if>

                                                    <span class="avatar-status bg-success">
                                                        
                                                    </span>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.fullName}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${user.phone}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.address}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${user.password}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.role}</div>
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
