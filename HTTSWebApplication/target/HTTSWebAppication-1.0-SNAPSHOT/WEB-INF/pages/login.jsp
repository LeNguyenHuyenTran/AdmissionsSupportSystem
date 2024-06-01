<%-- 
    Document   : login
    Created on : May 28, 2024, 2:44:22 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đăng nhập không thành côngg!
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username" >Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username..."/>
    </div>
    <div class="form-group">
        <label for="password" >Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password..."/>
    </div>
    <div class="form-group mt-3">
        <input type="submit" value="ĐĂNG NHẬP"/>
    </div>
</form>