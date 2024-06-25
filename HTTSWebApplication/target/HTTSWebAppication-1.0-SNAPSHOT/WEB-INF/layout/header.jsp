<%-- 
    Document   : header
    Created on : 14 May 2024, 19:32:30
    Author     : minh-nguyen
--%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header header-sticky p-0 mb-4">
    <div class="container-fluid border-bottom px-4">
        <button class="header-toggler" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()" style="margin-inline-start: -14px;">
            <i class="bi bi-list"></i>
        </button>
        <ul class="header-nav d-none d-lg-flex">
            <li class="nav-item"><a class="nav-link" href="<c:url value="/" />">Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/user" />">Users</a></li>
            <%@ page import="org.springframework.security.core.Authentication" %>
                    <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
                    <%@ page import="java.util.Collection" %>
                    <%@page import="org.springframework.security.core.GrantedAuthority"%>
                    <%
                        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
                            String roleName = authorities.iterator().next().toString();
                          
                        if (auth != null && auth.isAuthenticated()) {
                            
                    %>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item ">
                        <a class="nav-link" href="<c:url value="/login" />">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register" />">Register</a>
                    </li>
                </c:when>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />">Username:&nbsp;${pageContext.request.userPrincipal.name}&nbsp;(<%= roleName %>)</a>
                    </li>
                    
                </c:when>

            </c:choose>
                    <% }%>
        </ul>
        <ul class="header-nav ms-auto"> 
            <li class="nav-item"><a class="nav-link" href="#">
                    <svg class="icon icon-lg">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-bell"></use>
                    </svg></a></li>
            <li class="nav-item"><a class="nav-link" href="#">
                    <svg class="icon icon-lg">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-rich"></use>
                    </svg></a></li>
            <li class="nav-item"><a class="nav-link" href="#">
                    <svg class="icon icon-lg">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-envelope-open"></use>
                    </svg></a></li>
        </ul>

        <ul class="header-nav">
            <li class="nav-item dropdown">
                <% 
                    roleName = Character.toUpperCase(roleName.charAt(0)) + roleName.substring(1);
                
                %>
                <a class="nav-link py-0 pe-0" data-coreui-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <span><%= roleName%></span>
                    <div class="avatar avatar-md ms-1"><img class="avatar-img" src="https://media.istockphoto.com/id/1337144146/vector/default-avatar-profile-icon-vector.jpg?s=612x612&w=0&k=20&c=BIbFwuv7FxTWvh5S3vB6bkT0Qv8Vn8N5Ffseq84ClGI=" alt="avatar"></div>

                </a>
                <div class="dropdown-menu dropdown-menu-end pt-0">
                    <div class="dropdown-header bg-body-tertiary text-body-secondary fw-semibold my-2">
                        <div class="fw-semibold">Settings</div>
                    </div>
                    <a class="dropdown-item" href="#">
                        <i class="fa-solid fa-pen-to-square fa-lg me-3"></i>Edit User
                    </a>
                    <div class="dropdown-divider"></div><a class="dropdown-item" href="#">
                        <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
                </div>
            </li>
        </ul>
        



    </div>
    <div class="container-fluid px-4">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb my-0">
                <li class="breadcrumb-item"><a href="<c:url value="/" />">Home</a>
                </li>
                <li class="breadcrumb-item active"><span>Dashboard</span>
                </li>
            </ol>
        </nav>
    </div>
</header>
