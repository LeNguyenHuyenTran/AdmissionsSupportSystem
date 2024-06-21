<%-- 
    Document   : faculty
    Created on : 15 May 2024, 12:35:13
    Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="body flex-grow-1">
    <div class="container-lg px-4">
        <!-- /.row-->
        <div class="row">
            <div class="col-md-12">
                <div class="card mb-4">
                    <div class="card-body">
                        <!-- /.row-->
                        <c:url value="/faculty" var="actionFaculty"/>
                        <c:url value="/faculty/major" var="actionMajor"/>
                        <c:url value="/faculty/education-program" var="actionEducationProgram"/>
                           <c:set value="faculty" var="faculty" />
                            <c:set value="major" var="major" />
                            <c:set value="educationProgram" var="educationProgram" />

                        <!--                        <div class="row d-flex justify-content-between flex-row">
                                                    <div class="col-8">
                                                        <p class="d-inline-flex gap-1">
                                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                                Add Faculty
                                                            </a>
                                                        </p>
                                                        <div class="collapse mb-3" id="collapseExample">
                                                            <div class="card card-body container">
                                                                <form method="post" action="$action}" enctype="multipart/form-data" >
                                                                    <div class="mb-3">
                                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                                        <input name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
                        
                                                                        <label for="exampleFormControlInput1" class="form-label">Ten khoa</label>
                                                                        <input name="tenkhoa" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your title"/>
                                                                        <input name="tieude" type="hidden" class="form-control mb-3"/>
                                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                                            <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                                            <textarea name="noidung" class="form-control mb-3 ckeditor" id="tiny" rows="10" cols="50"  type="text" placeholder="your name type of admission"></textarea>
                                                                        </div>
                                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                                            <label for="exampleFormControlInput1" class="form-label">Video</label>
                                                                            <textarea class="form-control mb-3 ckeditor" id="tiny1" rows="10" cols="50" name="video" type="text" placeholder="your name type of admission"></textarea>
                                                                        </div>
                        
                        
                                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>
                                                                    </div>
                                                                </form>
                                                            </div>
                        
                                                        </div>
                                                    </div>
                        
                                                </div>-->
                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
 
                            <c:if test="${currentTab eq faculty}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="pills-home-tab" data-coreui-toggle="pill" data-coreui-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Faculty</button>
                                </li>
                            </c:if>
                            <c:if test="${currentTab ne faculty}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="pills-home-tab" data-coreui-toggle="pill" data-coreui-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Faculty</button>
                                </li>
                            </c:if>

                            <c:if test="${currentTab eq major}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="pills-profile-tab" data-coreui-toggle="pill" data-coreui-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Major</button>
                                </li>
                            </c:if>
                            <c:if test="${currentTab ne major}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="pills-profile-tab" data-coreui-toggle="pill" data-coreui-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Major</button>
                                </li>
                            </c:if>

                            <c:if test="${currentTab eq educationProgram}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="pills-contact-tab" data-coreui-toggle="pill" data-coreui-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Education Program</button>
                                </li>
                            </c:if>
                            <c:if test="${currentTab ne educationProgram}">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link" id="pills-contact-tab" data-coreui-toggle="pill" data-coreui-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Education Program</button>
                                </li>
                            </c:if>

                            <!--                            <li class="nav-item" role="presentation">
                                                            <button class="nav-link active" id="pills-home-tab" data-coreui-toggle="pill" data-coreui-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Faculty</button>
                                                        </li>-->
                            <!--                            <li class="nav-item" role="presentation">
                                                            <button class="nav-link" id="pills-profile-tab" data-coreui-toggle="pill" data-coreui-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Major</button>
                                                        </li>-->
                            <!--                            <li class="nav-item" role="presentation">
                                                            <button class="nav-link" id="pills-contact-tab" data-coreui-toggle="pill" data-coreui-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Education Program</button>
                                                        </li>-->
                        </ul>



                        <div class="tab-content" id="pills-tabContent">
                            
                            <c:if test="${currentTab eq faculty}">
                                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Faculty
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">

                                                <form:form name="faculty" method="post" action="${actionFaculty}" enctype="multipart/form-data" >
                                                    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="current-tab" value="${faculty}"/>

                                                    <input type="hidden" name="faculty"/>
                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input name="id"  value="${UID}" readonly type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten khoa</label>
                                                        <input name="tenkhoa" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your faculty name"/>
                                                        <form:errors path="tenkhoa" cssClass="text-danger mb-3" element="span"/>

                                                        <!--<input name="tieude" type="hidden" class="form-control mb-3"/>-->
                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                            <textarea name="noidung" class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50"  type="text" placeholder="your content"></textarea>
                                                        </div>
                                                        <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Video</label>
                                                            <textarea class="form-control mb-3 ckeditor" id="tinyContent2" rows="10" cols="50" name="video" type="text" placeholder="your video content"></textarea>
                                                        </div>
                                                        <form:errors path="video" cssClass="text-danger mb-3" element="span"/>


                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>


                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${faculty}"/>

                                        <input type="text" name="facultyKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Content</th>
                                                <th class="bg-body-secondary">Video</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${faculties}" var="faculty" >
                                                <c:url value="/faculty/${faculty.id}" var="url" />
                                                <c:url value="faculty/delete/${faculty.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${faculty.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${faculty.tenkhoa}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${faculty.thongtin.noidung}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${faculty.video}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${faculty.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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

                                        <c:forEach begin="1" end="${facultyQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="faculty-page" value="${i}"/>
                                                <c:param name="current-tab" value="faculty"/>
                                            </c:url>
                                            <c:if test="${fn:contains(currentFacultyPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentFacultyPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav>   

                            </div>
                            </c:if>
                            <c:if test="${currentTab ne faculty}">
                                <div class="tab-pane fade" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Faculty
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">

                                                <form:form name="faculty" method="post" action="${actionFaculty}" enctype="multipart/form-data" >
                                                    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="current-tab" value="${faculty}"/>

                                                    <input type="hidden" name="faculty"/>
                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input name="id"  value="${UID}" readonly type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten khoa</label>
                                                        <input name="tenkhoa" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your faculty name"/>
                                                        <form:errors path="tenkhoa" cssClass="text-danger mb-3" element="span"/>

                                                        <!--<input name="tieude" type="hidden" class="form-control mb-3"/>-->
                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                            <textarea name="noidung" class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50"  type="text" placeholder="your content"></textarea>
                                                        </div>
                                                        <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Video</label>
                                                            <textarea class="form-control mb-3 ckeditor" id="tinyContent2" rows="10" cols="50" name="video" type="text" placeholder="your video content"></textarea>
                                                        </div>
                                                        <form:errors path="video" cssClass="text-danger mb-3" element="span"/>


                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>


                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${faculty}"/>

                                        <input type="text" name="facultyKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Content</th>
                                                <th class="bg-body-secondary">Video</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${faculties}" var="faculty" >
                                                <c:url value="/faculty/${faculty.id}" var="url" />
                                                <c:url value="faculty/delete/${faculty.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${faculty.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${faculty.tenkhoa}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${faculty.thongtin.noidung}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${faculty.video}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${faculty.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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

                                        <c:forEach begin="1" end="${facultyQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="faculty-page" value="${i}"/>
                                                                                                <c:param name="current-tab" value="faculty"/>

                                            </c:url>
                                            <c:if test="${fn:contains(currentFacultyPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentFacultyPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav>   

                            </div>
                            </c:if>

                            <c:if test="${currentTab eq major}">
                                <div class="tab-pane fade show active" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Major
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">

                                                <form:form  name="major" method="post" action="${actionMajor}" enctype="multipart/form-data" >
                                                    <input type="hidden" name="current-tab" value="${major}"/>
                                                    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="major"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input value="${UID}" readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten nganh</label>
                                                        <input  name="ten" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your title"/>
                                                        <form:errors path="ten" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Khoa</label>
                                                            <select name="khoaid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                                <c:forEach items="${faculties1}" var="n">
                                                                    <option value="${n.id}">${n.tenkhoa}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>

                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${major}"/>

                                        <input type="text" name="majorKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Faculty</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${majors}" var="major" >
                                                <c:url value="/faculty/major/${major.id}" var="url" />
                                                <c:url value="faculty/major/delete/${major.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${major.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${major.ten}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${major.khoa.tenkhoa}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${major.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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
                                        <c:forEach begin="1" end="${majorQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="major-page" value="${i}"/>
                                                                                                <c:param name="current-tab" value="major"/>

                                            </c:url>
                                            <c:if test="${fn:contains(currentMajorPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentMajorPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav> 


                            </div>
                            </c:if>
                            <c:if test="${currentTab ne major}">
                                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Major
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">

                                                <form:form  name="major" method="post" action="${actionMajor}" enctype="multipart/form-data" >
                                                    <input type="hidden" name="current-tab" value="${major}"/>
                                                    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="major"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input value="${UID}" readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten nganh</label>
                                                        <input  name="ten" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your title"/>
                                                        <form:errors path="ten" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Khoa</label>
                                                            <select name="khoaid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                                <c:forEach items="${faculties1}" var="n">
                                                                    <option value="${n.id}">${n.tenkhoa}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>

                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${major}"/>

                                        <input type="text" name="majorKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Faculty</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${majors}" var="major" >
                                                <c:url value="/faculty/major/${major.id}" var="url" />
                                                <c:url value="faculty/major/delete/${major.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${major.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${major.ten}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${major.khoa.tenkhoa}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${major.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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
                                        <c:forEach begin="1" end="${majorQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="major-page" value="${i}"/>
                                                <c:param name="current-tab" value="major"/>
                                            </c:url>
                                            <c:if test="${fn:contains(currentMajorPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentMajorPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav> 


                            </div>
                            </c:if>

                            <c:if test="${currentTab eq educationProgram}">
                                <div class="tab-pane fade show active" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Education Program
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">
                                                <form:form  name="eduProgram" method="post" action="${actionEducationProgram}" enctype="multipart/form-data" >
                                                    <input type="hidden" name="current-tab" value="${educationProgram}"/>

                                                    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="educationProgram"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input value="${UID}" readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten Education Program</label>
                                                        <input  name="ten" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your educaiton program name"/>
                                                        <form:errors path="ten" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                            <textarea   name="mota" class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50"  type="text" placeholder="your content"></textarea>
                                                        </div>
                                                        <form:errors path="mota" cssClass="text-danger mb-3" element="span"/>

                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>

                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${educationProgram}"/>
                                        <input type="text" name="educationProgramKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Content</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${educationPrograms}" var="educationProgram" >
                                                <c:url value="/faculty/education-program/${educationProgram.id}" var="url" />
                                                <c:url value="faculty/education-program/delete/${educationProgram.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${educationProgram.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${educationProgram.ten}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${educationProgram.mota}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${educationProgram.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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

                                        <c:forEach begin="1" end="${educationProgramQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="education-program-page" value="${i}"/>
                                                                                                <c:param name="current-tab" value="educationProgram"/>

                                            </c:url>
                                            <c:if test="${fn:contains(currentEducationProgramPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentEducationProgramPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav>
                            </div>
                            </c:if>
                            <c:if test="${currentTab ne educationProgram}">
                                <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab" tabindex="0">

                                <div class="row d-flex justify-content-between flex-row">
                                    <div class="col-8">
                                        <p class="d-inline-flex gap-1">
                                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                                Add Education Program
                                            </a>
                                        </p>
                                        <div class="collapse mb-3" id="collapseExample">
                                            <div class="card card-body container">
                                                <form:form  name="eduProgram" method="post" action="${actionEducationProgram}" enctype="multipart/form-data" >
                                                    <input type="hidden" name="current-tab" value="${educationProgram}"/>

                                                    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
                                                    <input type="hidden" name="educationProgram"/>

                                                    <div class="mb-3">
                                                        <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                        <input value="${UID}" readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
                                                        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

                                                        <label for="exampleFormControlInput1" class="form-label">Ten Education Program</label>
                                                        <input  name="ten" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your educaiton program name"/>
                                                        <form:errors path="ten" cssClass="text-danger mb-3" element="span"/>

                                                        <div class="mb-3 d-flex flex-col gap-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                            <textarea   name="mota" class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50"  type="text" placeholder="your content"></textarea>
                                                        </div>
                                                        <form:errors path="mota" cssClass="text-danger mb-3" element="span"/>

                                                        <button type="submit" class="btn btn-dark mb-3">Create</button>

                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex">
                                    <form action="${actionFaculty}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <input type="hidden" name="current-tab" value="${educationProgram}"/>
                                        <input type="text" name="educationProgramKeyword" placeholder="Search" class="form-control"></input>
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
                                                <th class="bg-body-secondary">Content</th>

                                                <th class="bg-body-secondary"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${educationPrograms}" var="educationProgram" >
                                                <c:url value="/faculty/education-program/${educationProgram.id}" var="url" />
                                                <c:url value="faculty/education-program/delete/${educationProgram.id}" var="deleteUrl" />
                                                <tr class="align-middle"> 
                                                    <td>
                                                        <div class="text-nowrap">${educationProgram.id}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-wrap">${educationProgram.ten}</div>
                                                    </td>
                                                    <td>
                                                        <div class="text-nowrap">${educationProgram.mota}</div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                <i class="icon bi bi-three-dots-vertical"></i>
                                                            </button>
                                                            <div class="dropdown-menu dropdown-menu-end">
                                                                <a class="dropdown-item" href="${url}">Info</a>
                                                                <a class="dropdown-item" href="${url}">Edit</a>

                                                                <buttom onclick="Delete('${deleteUrl}', '${educationProgram.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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

                                        <c:forEach begin="1" end="${educationProgramQuantity}" var="i">
                                            <c:url value="/faculty" var="pageAction">
                                                <c:param name="education-program-page" value="${i}"/>
                                                        <c:param name="current-tab" value="educationProgram"/>

                                            </c:url>
                                            <c:if test="${fn:contains(currentEducationProgramPage,i)==true}">
                                                <li class="page-item"><a class="page-link active" href="${pageAction}">${i}</a></li>
                                                </c:if>
                                                <c:if test="${fn:contains(currentEducationProgramPage,i)==false}">
                                                <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
                                                </c:if>

                                        </c:forEach>
                                    </ul>
                                </nav>
                            </div>
                            </c:if>
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                        </div>

                        <!--                        <div class="table-responsive">
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
                                                            <:forEach items="$faculties}" var="faculty" >
                                                                <tr class="align-middle"> 
                                                                    <td>
                                                                        <div class="text-nowrap">$faculty.id}</div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-wrap">$faculty.nameFaculty}</div>
                                                                    </td>
                                                                    <td>
                                                                        <div class="text-nowrap">$faculty.website}</div>
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
                                                            </:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>-->
                    </div>
                </div>
            </div>
            <!-- /.col-->
        </div>
        <!-- /.row-->
    </div>
</div>

<script src="https://cdn.tiny.cloud/1/${TinyMCE_Key}/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>


<script defer src="<c:url value="/resources/js/main.js" />"></script>
<script defer src="<c:url value="/resources/js/TinyMCEInit.js" />"></script>

