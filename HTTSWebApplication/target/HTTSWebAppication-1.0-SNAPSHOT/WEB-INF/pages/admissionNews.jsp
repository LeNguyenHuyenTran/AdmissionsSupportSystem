<%-- 
    Document   : news
    Created on : 15 May 2024, 12:35:30
    Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
                        <c:url value="/admission-news" var="action"/>
                        <div class="row d-flex justify-content-between flex-row">
                            <div class="col-8">
                                <p class="d-inline-flex gap-1">
                                    <a class="btn btn-dark" data-coreui-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        Add News
                                    </a>
                                </p>
                                <div class="collapse mb-3" id="collapseExample">
                                    <div class="card card-body container">
                                        <form:form  method="post" action="${action}" enctype="multipart/form-data" >
                                                                                        <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

                                            <div class="mb-3">
                                                <label for="exampleFormControlInput1" class="form-label">Id</label>
                                                <input name="id" type="text" value="${UID}" readonly  class="form-control mb-3" id="exampleFormControlInput1" placeholder="your id"/>
                                                            <form:errors path="id" cssClass="text-danger mb-3" element="span"/>
                                                     <div class="mb-3 d-flex flex-col gap-3">
                                                    <label for="exampleFormControlInput1" class="form-label">Title</label>
                                                    <textarea  class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50" name="tieude" type="text" placeholder="your title"></textarea>
                                                </div>
                                                <form:errors path="tieude" cssClass="text-danger mb-3" element="span"/>

                                                <div class="mb-3">
                                                    <label for="exampleFormControlInput1" class="form-label">Type of Admission</label>
                                                    <select name="loaituyensinhid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                                        <c:forEach items="${typeOfAdmissions}" var="n">
                                                            <option value="${n.id}">${n.ten}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="mb-3 d-flex flex-col gap-3">
                                                    <label for="exampleFormControlInput1" class="form-label">Content</label>
                                                    <textarea  class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="50" name="noidung" type="text" placeholder="your content"></textarea>
                                                </div>
                                        <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>

                                                <button type="submit" class="btn btn-dark mb-3">Create</button>
                                            </div>
                                        </form:form>
                                    </div>

                                </div>
                            </div>
                            <div class="col-4">
                                <div class="d-flex justify-content-end">
                                    <form action="${action}" class="btn-group mb-3" role="group" aria-label="Basic outlined example">
                                        <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                            
                                            <c:if test="${fn:contains(tintuc, 'tatca')==false}">
                                                <input type="radio" class="btn-check" name="tintuc" value="tatca" id="option1" autocomplete="off">
                                                <label class="btn btn-secondary" for="option1">Tất cả</label>
                                            </c:if>
                                            <c:if test="${fn:contains(tintuc, 'tatca')==true}">
                                                <input type="radio" class="btn-check" name="tintuc" value="tatca" id="option1" autocomplete="off" checked="">
                                                <label class="btn btn-secondary" for="option1">Tất cả</label>
                                            </c:if>
                                            <c:if test="${fn:contains(tintuc, 'tintuyensinh')==false}">
                                                <input type="radio" class="btn-check" name="tintuc" value="tintuyensinh" id="option2" autocomplete="off">
                                                <label class="btn btn-secondary" for="option2">Tin tuyển sinh</label>
                                            </c:if>
                                            <c:if test="${fn:contains(tintuc, 'tintuyensinh')==true}">
                                                <input type="radio" class="btn-check" name="tintuc" value="tintuyensinh" id="option2" autocomplete="off" checked="">
                                                <label class="btn btn-secondary" for="option2">Tin tuyển sinh</label>
                                            </c:if>

                                        </div>
                                        <button type="submit" class="ms-1 btn btn-dark">Lọc</button>

                                    </form>
                                </div></div>
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
                                        <th class="bg-body-secondary">Id</th>
                                        <th class="bg-body-secondary">Title</th>
                                        <th class="bg-body-secondary">Type of Admission</th>
                                        <th class="bg-body-secondary">Content</th>
                                        <th class="bg-body-secondary"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${admissionNews}" var="news" >
                                        <c:url value="/admission-news/${news.id}" var="url" />
                                        <c:url value="admission-news/delete/${news.id}" var="deleteUrl" />
                                        <tr class="align-middle"> 
                                            <td>
                                                <div class="text-nowrap fs-3 fw-normal text-body text-left">${news.id}</div>
                                            </td>
                                            <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${news.thongtin.tieude}<div>
                                                        </td>
                                                        
                                                        <td>
                                                            <div class="text-nowrap fs-3 fw-normal text-body text-left">${news.loaituyensinh.ten}</div>
                                                        </td>
                                                        <td>
                                                <div class="text-wrap fs-3 fw-normal text-left text-body">${news.thongtin.noidung}<div>
                                                        </td>
                                                        <td>
                                                            <div class="dropdown">
                                                                <button class="btn btn-transparent p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                    <i class="icon bi bi-three-dots-vertical"></i>
                                                                </button>
                                                                <div class="dropdown-menu dropdown-menu-end">
                                                                    <a class="dropdown-item" href="${url}">Info</a>
                                                                    <a class="dropdown-item" href="${url}">Edit</a>

                                                                    <buttom onclick="Delete('${deleteUrl}', '${news.id}')" class="dropdown-item text-danger" type="submit">Delete</button>

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
                                                            <c:forEach begin="1" end="${admissionNewsQuantity}" var="i">
                                                                <c:url value="/admission-news" var="pageAction">
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


                                            <script src="https://cdn.tiny.cloud/1/${TinyMCE_Key}/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
<!--                                            <script>
                                                                        tinymce.init({
                                                                            selector: 'textarea#tiny',
                                                                            toolbar: 'image',
                                                                            plugins: 'image code',
                                                                            images_file_types: 'jpeg,jpg,jpe,jfi,jif,jfif,png,gif,bmp,webp',
                                                                            file_picker_types: 'file image media',
                                                                            file_picker_callback: (cb, value, meta) => {
                                                                                const input = document.createElement('input');
                                                                                input.setAttribute('type', 'file');
                                                                                input.setAttribute('accept', 'image/*');

                                                                                input.addEventListener('change', (e) => {
                                                                                    const file = e.target.files[0];

                                                                                    const reader = new FileReader();
                                                                                    reader.addEventListener('load', () => {
                                                                                        /*
                                                                                         Note: Now we need to register the blob in TinyMCEs image blob
                                                                                         registry. In the next release this part hopefully won't be
                                                                                         necessary, as we are looking to handle it internally.
                                                                                         */
                                                                                        const id = 'blobid' + (new Date()).getTime();
                                                                                        const blobCache = tinymce.activeEditor.editorUpload.blobCache;
                                                                                        const base64 = reader.result.split(',')[1];
                                                                                        const blobInfo = blobCache.create(id, file, base64);
                                                                                        blobCache.add(blobInfo);

                                                                                        /* call the callback and populate the Title field with the file name */
                                                                                        cb(blobInfo.blobUri(), {title: file.name});
                                                                                    });
                                                                                    reader.readAsDataURL(file);
                                                                                });

                                                                                input.click();
                                                                            }
                                                                        });
                                                                        document.addEventListener('focusin', (e) => {
                                                                            if (e.target.closest(".tox-tinymce, .tox-tinymce-aux, .moxman-window, .tam-assetmanager-root") !== null) {
                                                                                e.stopImmediatePropagation();
                                                                            }
                                                                        });
                                            </script>-->
                                            <script defer src="<c:url value="/resources/js/TinyMCEInit.js" />"></script>

                                            <script defer src="<c:url value="/resources/js/main.js" />"></script>

