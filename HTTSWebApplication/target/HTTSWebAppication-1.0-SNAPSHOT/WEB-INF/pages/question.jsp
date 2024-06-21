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

                        <c:url value="/question" var="action"/>
                        <div class="row d-flex justify-content-between flex-row">
                            <div class="col-4">
                                <p class="d-inline-flex gap-1">
                                    <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Add Questions
                                    </a>
                                </p>
                                <div class="collapse mb-3 " id="collapseExample">
                                    <div class="card card-body container">

                                        <form:form modelAttribute="question" name="question" method="post" action="${action}" >
                                            <form:errors path="*" cssClass="text-danger alert alert-danger p-2 mb-3" element="span"/>

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                <input value ="${UID}" type="text" name="id" class="form-control" id="exampleFormControlInput1" placeholder="your id"/>
                                            </div>
                                            <form:errors path="id" cssClass="text-danger alert alert-danger p-2 mb-3" element="span"/>

                                            

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput5" class="form-label">Content</label>
                                                <input name="hoten" class="form-control" id="exampleFormControlInput5" placeholder="your content"/>
                                            </div>
                                            <form:errors path="hoten" cssClass="text-danger alert alert-danger p-2 mb-3" element="span"/>

                                            
                                            <div class="mb-3">
                                                <label for="exampleFormControlInput2" class="form-label">Content</label>
                                                <input type="datetime-local" name="thoidiemdate" class="form-control" id="exampleFormControlInput2" placeholder="your content"/>
                                            </div>
                                            <form:errors path="thoidiemdate" cssClass="text-danger alert alert-danger p-2 mb-3" element="span"/>
                                            
                                            
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
                                        <th class="bg-body-secondary">Create</th>
                                        <th class="bg-body-secondary">Author</th>
                                        <th class="bg-body-secondary">Live stream Notify</th>
                                        <th class="bg-body-secondary">Video live stream</th>
                                        <th class="bg-body-secondary"></th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Comment data -->
                                    <c:forEach items="${questions}" var="question" >
                                        <c:url value="/questions/${question.id}" var="url" />
                                        <c:url value="questions/delete/${question.id}" var="deleteUrl" />
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap fs-3 fw-normal text-body text-left">${question.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${question.noidung}</div>
                                            </td>

                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${question.thoidiem}</div>
                                            </td>

                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${question.thisinh.user.hoten}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${question.thongbaolivestream.giolivestream}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${question.video.tieude}</div>
                                            </td>

                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end">
                                                        <a class="dropdown-item" href="${url}">Info</a>
                                                        <a class="dropdown-item" href="${url}">Edit</a>

                                                        <buttom onclick="Delete('${deleteUrl}', '${question.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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

                                <c:forEach begin="1" end="${questionQuantity}" var="i">
                                    <c:url value="/questions" var="pageAction">
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