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
<form:form method="post" name="user" action="${action}" enctype="multipart/form-data" >
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input value="${user.id}" path="id" name="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your Id"/>

        <label for="exampleFormControlInput1" class="form-label">Full Name</label>
        <input value="${user.fullName}" name="fullName" type="text" class="form-control mb-3" id="exampleFormControlInput1" placeholder="your fullname"/>

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Address</label>
            <input value="${user.address}" path="address" name="address" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your address"/>
        </div>  
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Phone</label>
            <input value="${user.phone}" path="phone" name="phone" type="text" class="form-control" id="exampleFormControlInput1" placeholder="your phone"/>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Password</label>
            <input value="${user.password}" path="password" name="password" type="password" class="form-control" id="exampleFormControlInput1" placeholder="your password"/>
        </div>
        <div class="mb-3">
            ${user.avatar}
            <c:set var="theString" value="${user.avatar}"/>
            <c:if test="${fn:contains(theString, 'http')==true}">
                <img class="rounded float-start" src="${user.avatar.trim()}" alt="user@email.com">
            </c:if>
            <c:if test="${fn:contains(theString, 'http')==false}">
                <img class="rounded float-start" src="${user.avatar.trim()}" alt="user@email.com">
            </c:if>
        </div>       

        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Image</label>
            <input name="file" type="file" class="form-control" id="exampleFormControlInput1"/>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Role</label>
            <select class="form-select" id="exampleFormControlInput1" name="role" aria-label="Default select example">
                <c:forEach items="${roles}"  var="role">
                    <c:choose>
                        <c:when test="${fn:contains(user.role,role)==true}">
                            <option value="${role}" selected>${role}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${role}">${role}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-dark">Update</button>
    </form:form>
