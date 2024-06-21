<%-- 
    Document   : user
    Created on : 14 May 2024, 20:11:09
    Author     : minh-nguyen
--%><%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="body flex-grow-1">
    <div class="container-lg">
        <!-- /.row-->
        <div class="row">
            <h2 class="mb-4 fw-bold text-left text-body">${title}</h2>

            <div class="col-md-12">
                <div class="card mb-4">
                    <div class="card-header">${title}</div>
                    <div class="card-body">
                        <!-- /.row-->
                        
                        <div class="">




                            <!-- /.row-->
                            <c:url value="/user" var="action"/>

                            <div class="row d-flex justify-content-between flex-row">
                                <div class="col-4">
                                    <p class="d-inline-flex gap-1">
                                        <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                            Add User
                                        </a>
                                    </p>
                                    <div class="collapse mb-3" id="collapseExample">
                                        <div class="card card-body container">
                                            <form:form modelAttribute="user" method="post" name="user" action="${action}">
                                                <form:errors path="*" element="div" cssClass="text-danger alert alert-danger p-2 mb-3"/>
                                                <div class="mb-3">
                                                    <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                    <input name="id" value="${UID}" readonly type="text" class="form-control mb-3"
                                                           id="exampleFormControlInput1" placeholder="your id"/>
                                                    <form:errors path="id" cssClass="text-danger alert alert-danger mb-3 p-2" element="div"/>
                                                    <label for="exampleFormControlInput1" class="form-label">Full Name</label>
                                                    <input name="hoten" type="text" class="form-control mb-3"
                                                           id="exampleFormControlInput1" placeholder="your fullname"/>
                                                    <form:errors path="hoten" cssClass="text-danger alert alert-danger p-2 mb-3" element="div"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Username</label>
                                                        <input  name="username" type="text" class="form-control"
                                                                id="exampleFormControlInput1" placeholder="your username"/>
                                                    </div>
                                                    <form:errors path="username" cssClass="text-danger alert alert-danger p-2 mb-3" element="div"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Date</label>
                                                        <input name="date" type="datetime-local" class="form-control"
                                                               id="exampleFormControlInput1" placeholder="your username"/>
                                                    </div>
                                                    <form:errors path="date" cssClass="text-danger alert alert-danger p-2 mb-3" element="div"/>
                                                    
                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Date</label>
                                                        <textarea name="noidung" type="textarea" class="form-control"
                                                                  id="tinyContent1" placeholder="your username"></textarea>
                                                    </div>
                                                    <form:errors path="noidung" cssClass="text-danger alert alert-danger p-2 mb-3" element="div"/>
                                                    
                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Password</label>
                                                        <input name="password" type="password" class="form-control"
                                                               id="exampleFormControlInput1" placeholder="your password"/>
                                                    </div>
                                                    <form:errors path="password" cssClass="text-danger alert alert-danger p-2 mb-3" element="div"/>

                                                    <!--                                            <div class="mb-3">
                                                                                                    <label for="exampleFormControlInput1" class="form-label">Image</label>
                                                                                                    <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
                                                                                                </div>-->
                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Role</label>
                                                        <select name="roleid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                            <c:forEach items="${roles}" var="n">
                                                                <c:if test="${fn:contains(n.role, 'student')==false}">
                                                                    <option value="${n.id}">${n.role}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <button type="submit" class="btn btn-dark">Create</button>
                                            </form:form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-8">
                                <div class="d-flex justify-content-end">
                                    <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="text" name="keyword" placeholder="Search" class="form-control"></input>
                                        <button type="submit" class="btn btn-outline-primary">Search</button>
                                    </form>
                                </div>
                                <div class="d-flex justify-content-end">

                                    <!--                                    <form action="$action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                                                            <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                                                                        
                                                                                <:forEach items="$userRoles}" var="role">
                                                                                    <:if test="$:contains(userRoleType, role.id)==false}">
                                                                                    <input type="radio" class="btn-check" name="userrole" value="$role.id}" id="option1" autocomplete="off">
                                                                                    <label class="btn btn-secondary" for="option1">$:toUpperCase(role.role)}</label>
                                                                                    </:if>
                                                                                    <:if test="$:contains(userRoleType, role.id)==true}">
                                                                                        <input type="radio" class="btn-check" name="userrole" value="$role.id}" id="option1" autocomplete="off" checked="">
                                                                                        <label class="btn btn-secondary" for="option1">$:toUpperCase(role.role)}</label>
                                                                                    </:if>
                                                                                </:forEach>
                                                                                
                                                                            </div>
                                                                            <button type="submit" class="ms-1 btn btn-dark">Filter</button>
                                    
                                                                        </form>-->
                                </div>
                            </div>
                        </div>




                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary">Full Name</th>
                                        <th class="bg-body-secondary">Username</th>
                                        <th class="bg-body-secondary">Password</th>
                                        <th class="bg-body-secondary">Role</th>
                                        <th class="bg-body-secondary">Avatar</th>

                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user" >
                                        <c:url value="/user/${user.id}" var="url" />
                                        <c:url value="user/delete/${user.id}" var="deleteUrl" />
                                        <tr class="align-middle"> 

                                            <td>
                                                <div class="text-nowrap">${user.hoten}</div>
                                            </td>

                                            <td>
                                                <div class="text-nowrap">${user.username}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${user.password}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap">${user.role.role}</div>
                                            </td>
                                            <td class="text-center">
                                                <div class="avatar avatar-md">
                                                    <c:set var="roleId" value="${user.role.id}" />
                                                    <c:if test="${fn:contains(roleId, 3)==false}">
                                                        <img class="avatar-img" src="" alt="avatar"/>
                                                    </c:if>
                                                    <c:if test="${fn:contains(roleId, 3)==true}">
                                                        <img class="avatar-img" src="${user.thisinh.avatar}" alt="avatar"/>
                                                        <span class="avatar-status bg-success"></span>
                                                    </c:if> 
                                                </div>
                                            </td>
                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a class="dropdown-item" href="${url}">Info</a>
                                                        <a class="dropdown-item" href="${url}">Edit</a>

                                                        <buttom onclick="Delete('${deleteUrl}', '${user.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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
                                    <c:forEach begin="1" end="${userQuantity}" var="i">
                                        <c:url value="/user" var="pageAction">
                                            <c:param name="page" value="${i}"/>
                                        </c:url>
                                        <c:if test="${fn:contains(currentPage,i)==true}">
                                        <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                        </c:if>
                                        <c:if test="${fn:contains(currentPage,i)==false}">
                                        <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                        </c:if>

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
                                                                                    <script src="https://cdn.tiny.cloud/1/${TinyMCE_Key}/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>

                                            <script defer src="<c:url value="/resources/js/TinyMCEInit.js" />"></script>

<script defer src="<c:url value="/resources/js/main.js" />"></script>