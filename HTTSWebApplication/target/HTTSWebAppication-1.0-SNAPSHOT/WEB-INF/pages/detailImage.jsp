<%-- 
    Document   : detailUser
    Created on : 19 May 2024, 19:21:19
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:url value="/images/image" var="actionImage"/>

<h2 class="px-5 mb-4 text-lef text-body fw-bold">${title}
</h2>

<form:form method="post" class="px-5" name="image" action="${actionImage}" enctype="multipart/form-data" >
      <c:if test="${not empty sessionScope.createImageMessage}">
                                        <div class="row mb-3 alert-info alert py-2">${sessionScope.createImageMessage}</div>
                                    </c:if>
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
    <input type="hidden" name="image"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input   value="${image.id}" readonly name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your Id"/>
    </div>
    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

    ${image.nguoidang.id}
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Author</label>
                
        <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
            <c:forEach items="${users}"  var="user">
                <c:choose>
                    <c:when test="${fn:contains(user.id,image.nguoidang.id)==true}">
                        <option value="${user.id}" selected>${user.hoten}</option>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${fn:contains(user.role.id,3)==false}">
                            <option value="${user.id}">${user.hoten}</option>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3 p-3 mt-3">
        <c:set var="theString" value="${image.anh}"/>
        <c:if test="${fn:contains(theString, 'http')==true}">
            <img class="rounded float-start mb-3 mt-3" width="200" src="${image.anh.trim()}" alt="image">
        </c:if>
        <c:if test="${fn:contains(theString, 'http')==false}">
            <img class="rounded float-start mb-3 mt-3" width="200" src="${image.anh.trim()}" alt="image">
        </c:if>
    </div>       

    <div class="mb-3">
        <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
    </div>
<c:if test="${not empty sessionScope.imageErrors}">
                                            <c:forEach items="${sessionScope.imageErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
    <button type="submit" class="btn btn-dark mb-3">Update</button>
</form:form>




