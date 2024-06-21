<%-- 
    Document   : detailUser
    Created on : 19 May 2024, 19:21:19
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:url value="/images/banner" var="actionBanner"/>

<h2 class="px-5 mb-4 text-lef text-body fw-bold">${title}
</h2>
<form:form method="post" class="px-5" name="banner" modelAttribute="banner" action="${actionBanner}" enctype="multipart/form-data" >
    <input type="hidden" name="banner"/>
        <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
        
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Id</label>
            <input value="${banner.id}" readonly name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your Id"/>
            <form:errors path="id" cssClass="text-danger mb-3" element="span"/>
        </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Author</label>
                <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
                    <c:forEach items="${users}"  var="user">
                        <c:if test="${fn:contains(user.role.id, 1)==true}">
                            <option value="${user.id}">${user.hoten}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3 p-3 mt-3">
                <c:set var="theString" value="${banner.anh}"/>
                <c:if test="${fn:contains(theString, 'http')==true}">
                    <img class="rounded float-start mb-3 mt-3" width="200" src="${banner.anh.trim()}" alt="avatar">
                </c:if>
                <c:if test="${fn:contains(theString, 'http')==false}">
                    <img class="rounded float-start mb-3 mt-3" width="200" src="${banner.anh.trim()}" alt="avatar">
                </c:if>
            </div>       

            <div class="mb-3">
                <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
            </div>

            <button type="submit" class="btn btn-dark mb-3">Update</button>

    </form:form>



