<%-- 
    Document   : news
    Created on : 15 May 2024, 12:35:30
    Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:url value="/faculty" var="action"/>
<h2 class="px-5 mb-4 text-left text-body fw-bold">${title}</h2>


<form:form class="px-5" name="faculty" method="post" action="${action}" enctype="multipart/form-data" >
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
    <input type="hidden" name="faculty"/>
        <input type="hidden" name="current-tab" value="faculty"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input value="${faculty.id}" readonly name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your Id"/>
    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

        <label for="exampleFormControlInput1" class="form-label">Ten khoa</label>
        <input   value="${faculty.tenkhoa}" name="tenkhoa" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your faculty name"/>
    <form:errors path="tenkhoa" cssClass="text-danger mb-3" element="span"/>

        <!--<input name="tieude" type="hidden" class="form-control mb-3"/>-->
        <div class="mb-3 d-flex flex-col gap-3">
            <label for="exampleFormControlInput1" class="form-label">Content</label>
            <textarea   name="noidung" class="form-control mb-3 ckeditor" id="tinyContent1" rows="10" cols="100"  type="text" placeholder="your content">${faculty.thongtin.noidung}</textarea>
        </div>
            <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3 d-flex flex-col gap-3">
            <label for="exampleFormControlInput1" class="form-label">Video</label>
            <textarea   class="form-control mb-3 ckeditor" id="tinyContent2" rows="10" cols="100" name="video" type="text" placeholder="your video content">
                ${faculty.video}
            </textarea>
        </div>
            <form:errors path="video" cssClass="text-danger mb-3" element="span"/>


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
