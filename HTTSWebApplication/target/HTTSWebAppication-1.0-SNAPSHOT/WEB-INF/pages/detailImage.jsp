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
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>
    <input type="hidden" name="image"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input   value="${image.id}" readonly name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your Id"/>
    </div>
    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Author</label>
        <!--            <select path="user_id" class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
                        <:forEach items="{users}"  var="user">
                            <:if test="{fn:contains(user.role, 'admin')==true}">
                                <option value="{user.id}">{user.fullname}</option>
                            </:if>
                        </:forEach>
                    </select>-->
        <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
            <c:forEach items="${users}"  var="user">
                <c:choose>
                    <c:set var="u1" value="${user.id}"/>
                    <c:set var="u2" value="${image.nguoidang.id}"/>
                    <c:when test="${fn:contains(u1,u2)==true}">
                        <option value="${image.nguoidang.id}" selected>${image.nguoidang.hoten}</option>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${fn:contains(user.role.id,3)==false}">
                            <option value="${image.nguoidang.id}">${image.nguoidang.hoten}</option>
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

    <button type="submit" class="btn btn-dark mb-3">Update</button>
</form:form>




