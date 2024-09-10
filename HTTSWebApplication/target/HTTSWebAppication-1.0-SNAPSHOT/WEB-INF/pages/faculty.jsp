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
                        <p class="d-inline-flex gap-1">
                            <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                Add Faculty
                            </a>
                        </p>
                        <div class="collapse mb-3" id="collapseExample">
                            <div class="card card-body container">
                                <form method="post" name="faculty" action="${action}" enctype="multipart/form-data" >

                                    <div class="mb-3">
                                        <label for="id" class="form-label">Id</label>
                                        <input name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Id"/>

                                        <label for="tenKhoa" class="form-label">Tên Khoa</label>
                                        <input name="tenKhoa" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="Tên Khoa"/>
                                        
                                        <label for="thongTin" class="form-label">Giới Thiệu</label>
                                        <input name="thongTin" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="Nội Dung"/>
                                        
                                        <div>
                                            <label for="file" class="form-label">Video</label>
                                            <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-dark">Create</button>
                                    </div>
                                </form>
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
                                        <th class="bg-body-secondary">
                                            Id
                                        </th>
                                        <th class="bg-body-secondary">Tên Khoa</th>
                                        <th class="bg-body-secondary">Giới Thiệu</th>
                                        <th class="bg-body-secondary">Video</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${faculties}" var="faculty" >
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap">${faculty.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${faculty.tenKhoa}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap">${faculty.thongTin.noiDung}</div>
                                            </td>
                                            <td>
                                                <div class="text-nowrap text-center">${faculty.video}</div>
                                            </td>
                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="icon bi bi-three-dots-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Info</a>
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
