<%-- 
    Document   : logout
    Created on : Jun 1, 2024, 3:55:47 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐĂNG KÝ</h1>

<c:if test="${param.errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />

<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="fullname" >Full name</label>
        <form:input type="text" id="fullname" path="fullName" class="form-control" placeholder="Your full name..."/>
    </div>
    <div class="form-group">
        <label for="email" >Email</label>
        <form:input type="email" id="email" path="email" class="form-control" placeholder="Email..."/>
    </div>
    <div class="form-group">
        <label for="username" >Username</label>
        <form:input type="text" id="username" path="username" class="form-control" placeholder="Username..."/>
    </div>
    <div class="form-group">
        <label for="password" >Password</label>
        <form:input type="password" id="password" path="password" class="form-control" placeholder="Password..."/>
    </div>
    <div class="form-group">
        <label for="confirm-password" >Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" placeholder="Confirm Password..."/>
    </div>
    <div class="form-group">
        <label for="avatar" >Avatar</label>
        <form:input type="file" id="avatar" path="avatar" class="form-control" placeholder="Avatar..."/>
    </div>
    <div class="form-group mt-3">
        <input type="submit" value="ĐĂNG KÝ"/>
    </div>
</form:form>
