<%-- 
    Document   : news
    Created on : 15 May 2024, 12:35:30
    Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url value="/faculty/admission-score" var="action"/>
<h2 class="px-5 mb-4 text-left text-body fw-bold">${title}</h2>


<form:form class="px-5"  name="eduProgram" method="post" action="${action}" enctype="multipart/form-data" >
    <c:if test="${not empty sessionScope.createAdmissionScoreMessage}">
    <div class="mb-3 alert-info alert py-2">${sessionScope.createAdmissionScoreMessage}</div>
</c:if>
    <input type="hidden" name="current-tab" value="admissionScore"/>

    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
    <input type="hidden" name="admissionScore"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input value="${admissionScore.id}"  readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

        <label for="exampleFormControlInput1" class="form-label">Score</label>
        <input value="${admissionScore.diem}"  name="diem" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your admission score"/>
        <form:errors path="diem" cssClass="text-danger mb-3" element="span"/>

        <label for="exampleFormControlInput1" class="form-label">Year</label>
        <input  value="${admissionScore.namhoc}"  name="namhoc" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your year"/>
        <form:errors path="namhoc" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Faculty</label>
            <select name="khoaid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                <c:forEach items="${faculties1}"  var="faculty">

                    <c:set var="mjId" value="${admissionScore.khoa.id}"/>
                    <c:set var="mjId2" value="${faculty.id}"/>

                    <c:choose>
                        <c:when test="${fn:contains(mjId,mjId2)==true}">
                            <option value="${faculty.id}" selected>${faculty.tenkhoa}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${faculty.id}">${faculty.tenkhoa}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Education program</label>
            <select name="chuongtrinhdaotaoid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                <c:forEach items="${educationPrograms1}"  var="educationProgram">

                    <c:set var="epId" value="${admissionScore.khoa.id}"/>
                    <c:set var="epId2" value="${educationProgram.id}"/>

                    <c:choose>
                        <c:when test="${fn:contains(epId,epId2)==true}">
                            <option value="${educationProgram.id}" selected>${educationProgram.ten}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${educationProgram.id}">${educationProgram.ten}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Major</label>
            <select name="nganhid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                <c:forEach items="${majors1}"  var="major">

                    <c:set var="asId" value="${admissionScore.khoa.id}"/>
                    <c:set var="asId2" value="${major.id}"/>

                    <c:choose>
                        <c:when test="${fn:contains(asId,asId2)==true}">
                            <option value="${major.id}" selected>${major.ten}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${major.id}">${major.ten}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <c:choose>
            <c:when test="${not empty sessionScope.admissionScoreErrors}">
                <c:forEach items="${sessionScope.admissionScoreErrors}" var="error">
                    <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                </c:forEach>
            </c:when>
        </c:choose>
        <button type="submit" class="btn btn-dark mb-3">Create</button>

    </div>
</form:form>



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

