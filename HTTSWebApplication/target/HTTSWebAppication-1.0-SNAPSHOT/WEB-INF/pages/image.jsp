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
                            <c:url value="/images" var="action"/>
                            <c:url value="/images/image" var="actionImage"/>
                            <c:url value="/images/banner" var="actionBanner"/>


                            <div class="row d-flex justify-content-between flex-row">


                                <%@ page import="org.springframework.security.core.Authentication" %>
                                <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
                                <%@ page import="java.util.Collection" %>
                                <%@page import="org.springframework.security.core.GrantedAuthority"%>
                                <%
                                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                                    if (auth != null && auth.isAuthenticated()) {
                                        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
                                        String roleName = authorities.iterator().next().toString();
                                        if (authorities.iterator().next().toString().equals("ROLE_ADMIN")) {
                                %>
                                <c:if test="${not empty sessionScope.createImageMessage}">
                                        <div class="mb-3 alert-info alert py-2">${sessionScope.createImageMessage}</div>
                                    </c:if>
                                        <c:if test="${not empty sessionScope.createBannerMessage}">
                                        <div class="mb-3 alert-info alert py-2">${sessionScope.createBannerMessage}</div>
                                    </c:if>
                                <div class="col-8">
                                    <p class="d-inline-flex gap-1">
                                        <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                            Add Banner
                                        </a>
                                    </p>
                                      
                                    <div class="collapse mb-3 " id="collapseExample">
                                        <div class="card card-body container">
                                            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                                                <li class="nav-item" role="presentation">
                                                    <button class="nav-link active" id="pills-home-tab" data-coreui-toggle="pill" data-coreui-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Pure Image</button>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <button class="nav-link" id="pills-profile-tab" data-coreui-toggle="pill" data-coreui-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Banner</button>
                                                </li>
                                            </ul>
                                            <div class="tab-content" id="pills-tabContent">
                                                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
                                                    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

                                                    <form:form  method="post" name="image" action="${actionImage}" enctype="multipart/form-data" >
                                                        <div class="mb-3">
                                                            <input name="image" type="hidden"/> 

                                                            <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                            <input value="${UID}" readonly  name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your id"/>
                                                            <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                            <div class="mb-3">
                                                                <label for="exampleFormControlInput1" class="form-label">Author</label>
                                                                <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
                                                                    <c:forEach items="${users}"  var="user">
                                                                        <c:if test="${fn:contains(user.role.role, 'ROLE_ADMIN')==true}">
                                                                            <option value="${user.id}">${user.hoten}</option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="exampleFormControlInput1" class="form-label">Image</label>
                                                                <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
                                                            </div>
                                                            <c:if test="${not empty sessionScope.imageErrors}">
                                            <c:forEach items="${sessionScope.imageErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
                                                            <button type="submit" class="btn btn-dark">Create</button>
                                                        </div>
                                                    </form:form>
                                                </div>
                                                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">

                                                    <form:form   method="post" name="banner" action="${actionBanner}" enctype="multipart/form-data" >
                                                        <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3">
                                                            <input name="banner" type="hidden"/> 

                                                            <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                            <input value="${UID}" readonly  name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your id"/>
                                                            <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                            <div class="mb-3">
                                                                <label for="exampleFormControlInput1" class="form-label">Role</label>
                                                                <select path="user_id" class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
                                                                    <c:forEach items="${users}"  var="user">
                                                                        <c:if test="${fn:contains(user.role.role, 'ROLE_ADMIN')==true}">
                                                                            <option value="${user.id}">${user.hoten}</option>
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="exampleFormControlInput1" class="form-label">Image</label>
                                                                <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
                                                            </div>
<c:if test="${not empty sessionScope.bannerErrors}">
                                            <c:forEach items="${sessionScope.bannerErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
                                                            <button type="submit" class="btn btn-dark">Create</button>
                                                        </div>
                                                    </form:form>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%      } else {
                                %>
                                <div class="col-8">
                                    <h3>👋&nbsp;Welcome,&nbsp;<%= auth.getName()%>!</h3>
                                </div>
                                <%
                                        }
                                    }
                                %>





                                <div class="col-4"><div class="d-flex justify-content-end">

                                        <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                            <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">

                                                <c:if test="${fn:contains(imageType, 'image')==false}">
                                                    <input type="radio" class="btn-check" name="image" value="image" id="option1" autocomplete="off">
                                                    <label class="btn btn-secondary" for="option1">Pure Image</label>
                                                </c:if>
                                                <c:if test="${fn:contains(imageType, 'image')==true}">
                                                    <input type="radio" class="btn-check" name="image" value="image" id="option1" autocomplete="off" checked="">
                                                    <label class="btn btn-secondary" for="option1">Pure Image</label>
                                                </c:if>
                                                <c:if test="${fn:contains(imageType, 'banner')==false}">
                                                    <input type="radio" class="btn-check" name="image" value="banner" id="option2" autocomplete="off">
                                                    <label class="btn btn-secondary" for="option2">Banner</label>
                                                </c:if>
                                                <c:if test="${fn:contains(imageType, 'banner')==true}">
                                                    <input type="radio" class="btn-check" name="image" value="banner" id="option2" autocomplete="off" checked="">
                                                    <label class="btn btn-secondary" for="option2">Banner</label>
                                                </c:if>
                                            </div>
                                            <button type="submit" class="ms-1 btn btn-dark">Filter</button>

                                        </form>

                                    </div><div class="mb-3 d-flex justify-content-end">
                                        <form  action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                            <c:set value="default" var="def"/>
                                            <c:set value="asc" var="asc"/>
                                            <c:set value="desc" var="desc"/>

                                            <select onchange="Sort('${action}', this)" name="sort" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                <c:if test="${sortType eq def}">

                                                    <option value="" selected="">Default    </option>
                                                    <option value="asc">Ascending</option>
                                                    <<option value="desc">Descending</option>
                                                </c:if>


                                                <c:if test="${sortType eq asc}">

                                                    <option value="">Default    </option>
                                                    <option value="asc" selected="">Ascending</option>
                                                    <<option value="desc">Descending</option>
                                                </c:if>
                                                <c:if test="${sortType eq desc}">
                                                    <option value="" >Default    </option>
                                                    <option value="asc">Ascending</option>
                                                    <<option value="desc" selected="">Descending</option>
                                                </c:if>
                                            </select>
                                        </form>
                                    </div>
                                </div>








                            </div>
                                                <div class="mb-3">Quantity:&nbsp;${imageQ}</div>
                            <div class="table-responsive">
                                <table class="table border mb-0">
                                    <thead class="fw-semibold text-nowrap">
                                        <tr class="align-middle">
                                            <th class="bg-body-secondary">Id</th>
                                            <th class="bg-body-secondary text-center">
                                                Image
                                            </th>
                                            <th class="bg-body-secondary"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${images}" var="image" >
                                            <c:url value="/images/${image.id}-${imageType}" var="url" />
                                            <c:url value="images/delete/${image.id}-${imageType}" var="deleteUrl" />
                                            <tr class="align-middle"> 
                                                <td>
                                                    <div class="text-nowrap">${image.id}</div>
                                                </td>
                                                <td class="text-center">
                                                    <div class="avatar avatar-md">
                                                        <c:set var="theString" value="${image.anh}"/>
                                                        <c:if test="${fn:contains(theString, 'http')==true}">
                                                            <img class="avatar-img" src="${image.anh}" alt="image">
                                                        </c:if>
                                                        <c:if test="${fn:contains(theString, 'http')==false}">
                                                            <img class="avatar-img" src="${image.anh}" alt="image">
                                                        </c:if>
                                                        <span class="avatar-status bg-success"></span>
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
                                                            <%
                                                                if (auth
                                                                        != null && auth.isAuthenticated()) {
                                                                    Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
                                                                    String roleName = authorities.iterator().next().toString();
                                                                    if (authorities.iterator().next().toString().equals("ROLE_ADMIN")) {
                                                            %>
                                                            <buttom onclick="Delete('${deleteUrl}', '${image.id}')" class="dropdown-item text-danger" type="submit">Delete</button>


                                                                <%      } else {
                                                                %>
                                                                <%
                                                                        }
                                                                    }
                                                                %>

                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <nav class="mt-3" aria-label="Page navigation example">
                                <ul class="pagination">
                                    <!--<:url value="/images" var="allPageAction"/>-->
                                    <!--                                    <:if test="$:contains(currentPage,0)==true}">
                                                                            <li class="page-item"><a class="page-link active" href="$allPageAction}">All</a></li>
                                                                            </:if>
                                                                            <:if test="$:contains(currentPage,0)==false}">
                                                                            <li class="page-item"><a class="page-link" href="$allPageAction}">All</a></li>
                                                                            </:if>-->
                                    <c:forEach begin="1" end="${imageQuantity}" var="i">
                                        <c:url value="/images" var="pageAction">
                                            <c:param name="page" value="${i}"/>
                                            <c:param name="image" value="${imageType}"/>
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

    <script defer src="<c:url value="/resources/js/main.js" />"></script>