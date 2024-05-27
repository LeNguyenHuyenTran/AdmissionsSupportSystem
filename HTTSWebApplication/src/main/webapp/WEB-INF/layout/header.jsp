<%-- 
    Document   : header
    Created on : 14 May 2024, 19:32:30
    Author     : minh-nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header header-sticky p-0 mb-4">
    <div class="container-fluid border-bottom px-4">
        <button class="header-toggler" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()" style="margin-inline-start: -14px;">
            <i class="bi bi-list"></i>
        </button>
        <ul class="header-nav d-none d-lg-flex">
            <li class="nav-item"><a class="nav-link" href="#">Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Users</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Resources</a></li>
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
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-credit-card"></use>
                        </svg> Payments<span class="badge badge-sm bg-secondary ms-2">42</span>
                    </a>
                    <a class="dropdown-item" href="#">
                        <svg class="icon me-2">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-file"></use>
                        </svg> Projects<span class="badge badge-sm bg-primary ms-2">42</span>
                    </a>
                    <div class="dropdown-divider"></div><a class="dropdown-item" href="#">
                        <a class="dropdown-item" href="#">
                            <svg class="icon me-2">
                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-account-logout"></use>
                            </svg> Logout
                        </a>
                </div>
            </li>
        </ul>
    </div>
    <div class="container-fluid px-4">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb my-0">
                <li class="breadcrumb-item"><a href="#">Home</a>
                </li>
                <li class="breadcrumb-item active"><span>Dashboard</span>
                </li>
            </ol>
        </nav>
    </div>
</header>
