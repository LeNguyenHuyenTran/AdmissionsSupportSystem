<%-- 
    Document   : detailUser
    Created on : 19 May 2024, 19:21:19
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:url value="/user" var="action"/>
<h2 class="px-5 mb-4 text-lef text-body fw-bold">${title}</h2>
<form:form  method="post" class="px-5" name="user" action="${action}" enctype="multipart/form-data" >
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input value="${user.id}" readonly path="id" name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your Id"/>
        <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

        <label for="exampleFormControlInput1" class="form-label">Full Name</label>
        <input   value="${user.hoten}" name="hoten" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your fullname"/>
        <form:errors path="hoten" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Username</label>
            <input   value="${user.username}"  name="username" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your username"/>
        </div>
        <form:errors path="username" cssClass="text-danger mb-3" element="span"/>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Password</label>
            <input   value="${user.password}" name="password" type="password" class="form-control" id="exampleFormControlInput1" placeholder="your password"/>
        </div>
        <form:errors path="password" cssClass="text-danger mb-3" element="span"/>

        <c:if test="${fn:contains(user.role.id,3)==true}">
            <div class="mb-3 p-3 mt-3">
                <c:set var="theString" value="${user.thisinh.avatar}"/>
                <c:if test="${fn:contains(theString, 'http')==true}">
                    <img class="rounded float-start mb-3 mt-3" width="200" src="${user.thisinh.avatar.trim()}" alt="avatar">
                </c:if>
                <c:if test="${fn:contains(theString, 'http')==false}">
                    <img class="rounded float-start mb-3 mt-3" width="200" src="${user.thisinh.avatar.trim()}" alt="avatar">
                </c:if>
            </div>
            <div class="mb-3">
                <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
            </div>
        </c:if>


        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Role</label>
            <select class="form-select" id="exampleFormControlInput1" name="roleid" aria-label="Default select example">
                <c:forEach items="${roles}"  var="role">
                    <c:set var="roleId" value="${user.role.id}"/>
                    <c:set var="roleId2" value="${role.id}"/>
                    <c:choose>
                        <c:when test="${fn:contains(roleId,roleId2)==true}">
                            <option value="${role.id}" selected>${role.role}</option>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${fn:contains(roleId,3)==false}">
                                <option value="${role.id}">${role.role}</option>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-dark">Update</button>
    </form:form>
