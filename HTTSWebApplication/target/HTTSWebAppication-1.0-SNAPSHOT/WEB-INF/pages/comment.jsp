<%-- 
    Document   : comment
    Created on : 27 May 2024, 20:16:27
    Author     : minh-nguyen
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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

                        <c:url value="/comments" var="action"/>
                        <div class="row d-flex justify-content-between flex-row">
                            <div class="col-4">
                                <p class="d-inline-flex gap-1">
                                    <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Add Comments
                                    </a>
                                </p>
                                <div class="collapse mb-3 " id="collapseExample">
                                    <div class="card card-body container">
                                        <form:form modelAttribute="comment" method="post" action="${action}" >
                            <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                <input type="text" name="id"  value="${UID}" readonly class="form-control" id="exampleFormControlInput1" placeholder="your id">
                                            </div>
                                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                <input   type="text" name="binhluan" class="form-control" id="exampleFormControlInput1" placeholder="your content">
                                            </div>
                                            <form:errors path="binhluan" cssClass="text-danger mb-3" element="span"/>
                 
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Admission News</label>
                                                <select name="admissionnewsid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                    <c:forEach items="${admissionNews}" var="n">
                                                        <option value="${n.id}">${n.thongtin.tieude}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Author</label>
                                                <select name="userid" class="form-select" id="exampleFormControlInput1" aria-label="Default select example">
                                                    <c:forEach items="${users}" var="u">
                                                        <option value="${u.id}">${u.hoten}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <button type="submit" class="btn btn-dark">Create</button>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-8">
                                <div class="d-flex justify-content-end">
                                    <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="text" name="keyword" placeholder="Search" class="form-control"></input>
                                        <button type="submit" class="btn btn-secondary">Search</button>
                                    </form>
                                </div>
                                <div class="d-flex justify-content-end">

                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table border mb-0">
                                <thead class="fw-semibold text-nowrap">
                                    <tr class="align-middle">
                                        <th class="bg-body-secondary">Id</th>
                                        <th class="bg-body-secondary">Content</th>
                                        <th class="bg-body-secondary">Author</th>
                                        <th class="bg-body-secondary">Admission News</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Comment data -->
                                    <c:forEach items="${comments}" var="comment" >
                                        <c:url value="/comments/${comment.id}" var="url" />
                                        <c:url value="comments/delete/${comment.id}" var="deleteUrl" />
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap fs-3 fw-normal text-body text-left">${comment.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${comment.binhluan}</div>
                                            </td>

                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${comment.nguoibinhluan.hoten}</div>
                                            </td>
                                            
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${comment.tintuyensinh.thongtin.tieude}</div>
                                            </td>
                                               

                                            <!-- Others col -->
                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a class="dropdown-item" href="${url}">Info</a>
                                                        <a class="dropdown-item" href="${url}">Edit</a>

                                                        <buttom onclick="Delete('${deleteUrl}', '${comment.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>



                                </tbody>
                            </table>
                        </div>

                        <!-- Nav paging-->
                        <nav class="mt-3" aria-label="Page navigation example">
                            <ul class="pagination">
                                
                                    <c:forEach begin="1" end="${commentQuantity}" var="i">
                                        <c:url value="/comments" var="pageAction">
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
        </div>
        <!-- /.col-->
    </div>
    <!-- /.row-->
</div>

<script defer src="<c:url value="/resources/js/main.js" />"></script>
