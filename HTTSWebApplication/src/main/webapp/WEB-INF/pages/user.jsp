<%-- 
    Document   : user
    Created on : 14 May 2024, 20:11:09
    Author     : minh-nguyen
--%><%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="body flex-grow-1">
    <div class="container-lg px-4">
        <!-- /.row-->
        <div class="row">
            <div class="col-md-12">
                <div class="card mb-4">
                    <div class="card-header">Users</div>
                    <div class="card-body">
                        <!-- /.row-->

                        <div class="">
                            <!-- /.row-->
                            <c:url value="/user" var="action"/>
                            <p class="d-inline-flex gap-1">
                                <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                    Add User
                                </a>
                            </p>
                            <div class="collapse mb-3" id="collapseExample">
                                <div class="card card-body container">
                                    <form method="post" name="user" action="${action}" enctype="multipart/form-data" >

                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Id</label>
                                            <input name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Id"/>

                                            <label for="exampleFormControlInput1" class="form-label">Full Name</label>
                                            <input name="fullName" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="Full Name"/>

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Email</label>
                                                <input name="email" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Address"/>
                                            </div>  
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Username</label>
                                                <input name="username" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Username"/>
                                            </div>
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Password</label>
                                                <input name="password" type="password" class="form-control" id="exampleFormControlInput1" placeholder="Password"/>
                                            </div>
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Image</label>
                                                <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
                                            </div>
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Role</label>
                                                <select id="exampleFormControlInput1" name="role" class="form-select" aria-label="Default select example">
                                                    <option selected value="admin">Your Role</option>
                                                    <option value="admin">ROLE_ADMIN</option>
                                                    <option value="instructor">ROLE_INSTRUCTOR</option>
                                                    <option value="student">ROLE_USER</option>
                                                </select>
                                            </div>
                                            <button type="submit" class="btn btn-dark">Create</button>
                                    </form>
                                </div>

                            </div>
                        </div>
                        <div class="d-flex">
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
                                        <th class="bg-body-secondary">Email</th>
                                        <th class="bg-body-secondary">Username</th>
                                        <th class="bg-body-secondary">Password</th>
                                        <th class="bg-body-secondary">Role</th>
                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user" >
                                        <c:url value="/user/${user.id}" var="url" />
                                        <c:url value="user/delete/${user.id}" var="deleteUrl" />
                                        <tr class="align-middle"> 
                                            <td class="text-center">
                                                <div class="avatar avatar-md">
                                                    <c:set var="theString" value="${user.avatar}"/>
                                                    <c:if test="${fn:contains(theString, 'http')==true}">
                                                        <img class="avatar-img" src="${user.avatar}" alt="user@email.com">
                                                    </c:if>
                                                    <c:if test="${fn:contains(theString, 'http')==false}">
                                                        <img class="avatar-img" src="${user.avatar}" alt="user@email.com">
                                                    </c:if>
                                                    <span class="avatar-status bg-success"></span>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.fullName}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${user.email}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.username}</div>
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
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a class="dropdown-item" href="${url}">Info</a>
                                                        <a class="dropdown-item" href="${url}">Edit</a>
                                                        
                                                        <buttom onclick="Delete('${deleteUrl}','${user.id}')" class="dropdown-item text-danger" type="submit">Delete</button>
                                                        
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <c:url value="/user" var="allPageAction"/>
                                <li class="page-item"><a class="page-link" href="${allPageAction}">All</a></li>
                                <c:forEach begin="1" end="${userQuantity}" var="i">
                                    <c:url value="/user" var="pageAction">
                                        <c:param name="page" value="${i}"/>
                                    </c:url>
                                    <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- /.col-->
        </div>
        <!-- /.row-->
    </div>
</div>
                                
<script defer src="<c:url value="/resources/js/main.js" />"></script>
