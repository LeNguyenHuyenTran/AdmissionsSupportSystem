<%-- 
    Document   : detailComment
    Created on : 27 May 2024, 20:17:14
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:url value="/comments" var="action"/>
<h2 class="px-5 mb-4 text-left text-body fw-bold">${title}</h2>

<form:form method="post" action="${action}" class="px-5">
    <c:if test="${not empty sessionScope.createCommentMessage}">
    <div class="mb-3 alert-info alert py-2">${sessionScope.createCommentMessage}</div>
</c:if>
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input type="text" value="${comment.id}" readonly="" name="id" class="form-control" id="exampleFormControlInput1" placeholder="your id">
    </div>
    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Content</label>
        <input   type="text" value="${comment.binhluan}" name="binhluan" class="form-control" id="exampleFormControlInput1" placeholder="your content">
    </div>
    <form:errors path="binhluan" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Admission News</label>
        <select class="form-select" id="exampleFormControlInput1" name="admissionnewsid" aria-label="Default select example">
            <c:forEach items="${admissionNews}"  var="n">
                <c:set var="m" value="${comment.tintuyensinh.id}"/>
                <c:choose>
                    <c:when test="${n.id eq m}">
                        <option value="${n.id}" selected>${n.thongtin.tieude}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${n.id}">${n.thongtin.tieude}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Author</label>
        <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
            <c:forEach items="${users}"  var="u">
                <c:set var="m" value="${comment.nguoibinhluan.id}"/>
                <c:choose>
                    <c:when test="${fn:contains(u.id, m)==true}">
                        <option value="${u.id}" selected>${u.hoten}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${u.id}">${u.hoten}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <c:if test="${not empty sessionScope.commentErrors}">
        <c:forEach items="${sessionScope.commentErrors}" var="error">
            <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
        </c:forEach>
    </c:if>
    <div class="mb-3">
        <button type="submit" class="btn btn-dark">Create</button>
    </div>
</form:form>
