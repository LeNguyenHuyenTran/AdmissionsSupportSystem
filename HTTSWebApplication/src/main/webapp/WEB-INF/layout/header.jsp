<%-- 
    Document   : header
    Created on : 14 May 2024, 19:32:30
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header class="header header-sticky p-0 mb-4">
    <div class="container-fluid border-bottom px-4">
        <button class="header-toggler" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()" style="margin-inline-start: -14px;">
            <i class="bi bi-list"></i>
        </button>
        <ul class="header-nav d-none d-lg-flex">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/" />">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Users</a>
            </li>
            <c:if test="${pageContext.request.userPrincipal.name == null}" >
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/login" />">Login</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}" >
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                </li>
                <<li class="nav-item">
                    <a class="nav-link" href="#">Logout</a>
                </li>
            </c:if>
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
                <a class="nav-link py-0 pe-0" data-coreui-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <div class="avatar avatar-md"><img class="avatar-img" src="assets/img/avatars/8.jpg" alt="user@email.com"></div>
                </a>
                <div class="dropdown-menu dropdown-menu-end pt-0">
                    <div class="dropdown-header bg-body-tertiary text-body-secondary fw-semibold my-2">
                        <div class="fw-semibold">Settings</div>
                    </div>
                        <a class="dropdown-item" href="#">
                            <svg class="icon me-2">
                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-account-logout"></use>
                            </svg> Logout
                        </a>
                </div>
            </li>
        </ul>
    </div>
</header>
