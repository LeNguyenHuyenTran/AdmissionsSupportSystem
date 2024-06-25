<%-- 
    Document   : detailUser
    Created on : 19 May 2024, 19:21:19
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url value="/admission-news" var="action"/>
<h2 class="mb-4 text-left text-body fw-bold px-5">${title}</h2>

<form:form  class="px-5" method="post" name="admissionNews" action="${action}" >
     <c:if test="${not empty sessionScope.createAdmissionNewsMessage}">
                                        <div class="mb-3 alert-info alert py-2">${sessionScope.createAdmissionNewsMessage}</div>
                                    </c:if>
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input value="${admissionNews.id}" readonly="" name="id" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your id"/>
        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3 d-flex flex-col gap-3">
            <label for="exampleFormControlInput1" class="form-label">Title</label>
            <textarea   rows="10" cols="50" name="tieude" type="text" class="form-control mb-3 ckeditor" id="tinyContent1" placeholder="your title">${admissionNews.thongtin.tieude}</textarea>
        </div>
        <form:errors path="tieude" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Type of Admission</label>
            <select class="form-select" id="exampleFormControlInput1" name="loaituyensinhid" aria-label="Default select example">
                <c:forEach items="${typeOfAdmissions}"  var="n">
                    <c:set var="t1" value="${admissionNews.loaituyensinh.id}"/>
                    <c:set var="t2" value="${n.id}"/>
                    <c:choose>
                        <c:when test="${fn:contains(t1,t2)==true}">
                            <option value="${n.id}" selected>${n.ten}</option>
                        </c:when>
                        <c:otherwise>
                        <option value="${n.id}">${n.ten}</option>

                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        
        <form:errors path="loaituyensinh" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3 d-flex flex-col gap-3">
            <label for="exampleFormControlInput1" class="form-label">Content</label>
            <textarea   class="form-control mb-3 ckeditor" id="tinyContent2" rows="10" cols="50" name="noidung" type="text" placeholder="your content">${admissionNews.thongtin.noidung}</textarea>
        </div>
        <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>
<c:if test="${not empty sessionScope.admissionNewsErrors}">
                                            <c:forEach items="${sessionScope.admissionNewsErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
        <button type="submit" class="btn btn-dark mb-3">Update</button>
    </div>
</form:form>
<script src="https://cdn.tiny.cloud/1/${TinyMCE_Key}/tinymce/7/tinymce.min.js" referrerpolicy="origin"></script>
<script defer src="<c:url value="/resources/js/TinyMCEInit.js" />"></script>

<script defer src="<c:url value="/resources/js/main.js" />"></script>