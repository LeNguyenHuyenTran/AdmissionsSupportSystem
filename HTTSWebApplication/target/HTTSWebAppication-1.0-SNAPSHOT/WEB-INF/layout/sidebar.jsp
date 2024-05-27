<%-- 
    Document   : sidebar
    Created on : 14 May 2024, 19:04:57
    Author     : minh-nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar sidebar-dark sidebar-fixed border-end" id="sidebar" datasqstyle="{&quot;top&quot;:null}" datasquuid="c3f2de4c-e8b3-4191-a44f-ef5f8c885813" datasqtop="40">
    <div class="sidebar-header border-bottom">
        <div class="sidebar-brand">
            <svg class="sidebar-brand-full" width="88" height="32" alt="CoreUI Logo">
            <use xlink:href="assets/brand/coreui.svg#full"></use>
            </svg>
            <svg class="sidebar-brand-narrow" width="32" height="32" alt="CoreUI Logo">
            <use xlink:href="assets/brand/coreui.svg#signet"></use>
            </svg>
        </div>
        <button class="btn-close d-lg-none" type="button" data-coreui-dismiss="offcanvas" data-coreui-theme="dark" aria-label="Close" onclick="coreui.Sidebar.getInstance(document.querySelector( & quot; #sidebar & quot; )).toggle()"></button>
    </div>
    <ul class="sidebar-nav simplebar-scrollable-y" data-coreui="navigation" data-simplebar="init"><div class="simplebar-wrapper" style="margin: -8px;"><div class="simplebar-height-auto-observer-wrapper"><div class="simplebar-height-auto-observer"></div></div><div class="simplebar-mask"><div class="simplebar-offset" style="right: 0px; bottom: 0px;"><div class="simplebar-content-wrapper" tabindex="0" role="region" aria-label="scrollable content" style="height: 100%; overflow: hidden scroll;"><div class="simplebar-content" style="padding: 8px;">
                            <li class="nav-item"><a class="nav-link" href="index.html">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
                                    </svg> Dashboard</a></li>
                            <li class="nav-title">System</li>
                            <li class="nav-item"><a class="nav-link" href="colors.html">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-drop"></use>
                                    </svg> Users</a></li>
                            <li class="nav-item"><a class="nav-link" href="colors.html">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-drop"></use>
                                    </svg> Faculty</a></li>
                            <li class="nav-item"><a class="nav-link" href="colors.html">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-drop"></use>
                                    </svg> News</a></li>
                            <li class="nav-item"><a class="nav-link" href="colors.html">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-drop"></use>
                                    </svg> Faculty</a></li>
                            <li class="nav-group"><a class="nav-link nav-group-toggle" href="#">
                                    <svg class="nav-icon">
                                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-puzzle"></use>
                                    </svg> Resources</a>
                                <ul class="nav-group-items compact">
                                    <li class="nav-item"><a class="nav-link" href="base/accordion.html"><span class="nav-icon"><span class="nav-icon-bullet"></span></span> Images</a></li>
                                    <li class="nav-item"><a class="nav-link" href="base/breadcrumb.html"><span class="nav-icon"><span class="nav-icon-bullet"></span></span> Avatar</a></li>
                                    <li class="nav-item"><a class="nav-link" href="base/breadcrumb.html"><span class="nav-icon"><span class="nav-icon-bullet"></span></span> Banner</a></li>
                                    <li class="nav-item"><a class="nav-link" href="base/breadcrumb.html"><span class="nav-icon"><span class="nav-icon-bullet"></span></span> Video</a></li>
                                </ul>
                            </li>
                        </div></div></div></div><div class="simplebar-placeholder" style="width: 255px; height: 823px;"></div></div><div class="simplebar-track simplebar-horizontal" style="visibility: hidden;"><div class="simplebar-scrollbar" style="width: 0px; display: none;"></div></div><div class="simplebar-track simplebar-vertical" style="visibility: visible;"><div class="simplebar-scrollbar" style="height: 25px; transform: translate3d(0px, 1px, 0px); display: block;"></div></div></ul>
    <div class="sidebar-footer border-top d-none d-md-flex">
        <button class="sidebar-toggler" type="button" data-coreui-toggle="unfoldable"></button>
    </div>
</div>
