<%-- 
    Document   : login
    Created on : May 28, 2024, 2:44:22 PM
    Author     : Admin
--%>





<%-- 
Document   : base
Created on : 14 May 2024, 19:06:13
Author     : minh-nguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Index
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <!-- Option 2: CoreUI PRO for Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/@coreui/coreui-pro@5.1.0/dist/css/coreui.min.css" rel="stylesheet" integrity="sha384-GEH24oINaP0CP7v1z+N804ebgDoavE2mUsfGGKLMDAukIK60qCLORzfAKEE7RWbb" crossorigin="anonymous">
        <!-- Option 1: Include in HTML -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            .wrapper{
                width: 100%;
                will-change: auto;
                transition: padding 0.15s;
                padding-left: var(--cui-sidebar-occupy-start, 0);
                padding-right: var(--cui-sidebar-occupy-end, 0);
            }
            @keyframes fadeIn {
                0% {
                    opacity: 0;
                }
                100% {
                    opacity: 1;
                }


            }
            @keyframes fadeOut {
                0% {
                    opacity: 1;
                }
                100% {
                    opacity: 0;
                    display: none; /* Ensure element is removed after animation */
                }
            }
            .fade-out {
                animation: fadeOut 0.3s ease forwards;
            }
            #loadItem{
                z-index: 9999;
                position: fixed;
                animation: fadeIn 0.3s ease forwards;

            }
        </style>
        <!-- Option 2: CoreUI PRO for Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/@coreui/coreui-pro@5.1.0/dist/js/coreui.bundle.min.js" integrity="sha384-86eT557yN6+cWfDcCEUIjzKvSe8xM5LXynY586L2TwybjqoAzi5SJaQ4Bphcm3TF" crossorigin="anonymous"></script>

    </head>
    <body>
        <script src="<c:url value="/resources/js/load.js" />"></script>


        <c:if test="${param.error != null}">
            <div class="alert alert-info">
                Đăng nhập không thành côngg!
            </div>
        </c:if>

        <c:url value="/" var="indexAction" />

        <c:url value="/login" var="loginAction" />
        <c:url value="/logout" var="logoutAction" />

        <c:url value="/register" var="registerAction" />
        <c:url value="/user" var="userAction" />
        <c:url value="/images" var="imageAction" />
        <c:url value="/faculty" var="facultyAction" />
        <c:url value="/questions" var="questionAction" />
        <c:url value="/comments" var="commentAction" />
        <c:url value="/admission-news" var="admissionNewsAction" />
        <c:url value="/faculty?current-tab=major" var="majorAction" />
        <c:url value="/faculty?current-tab=educationProgram" var="educationProgramAction" />
        <c:url value="/faculty?current-tab=admissionScore" var="admissionScoreAction" />



        <div class="container d-flex justify-content-center align-items-center min-vh-100">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="card-group d-block d-md-flex row">
                        <div class="card col-md-7 p-4 mb-0">
                            <div class="card-body">
                                <%@ page import="org.springframework.security.core.Authentication" %>
                                <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
                                <%@ page import="java.util.Collection" %>
                                <%@page import="org.springframework.security.core.GrantedAuthority"%>
                                <%
                                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                                    if (auth != null && auth.isAuthenticated()) {
                                %>
                                <h2>👋&nbsp;Welcome,&nbsp;<%= auth.getName()%>!</h2>
                                <%}
                                %>


                                <p class="text-body-secondary">Management Routing Map</p>
                                <div class="list-group">
                                    <a href="${userAction}" class="list-group-item list-group-item-action active" aria-current="true">
                                        User management
                                    </a>
                                    <a href="${imageAction}" class="list-group-item list-group-item-action">Image management</a>
                                    <a href="${facultyAction}" class="list-group-item list-group-item-action">Faculty management</a>
                                    <a href="${majorAction}" class="list-group-item list-group-item-action">Major management</a>
                                    <a href="${educationProgramAction}" class="list-group-item list-group-item-action">Education program management</a>
                                    <a href="${admissionScoreAction}" class="list-group-item list-group-item-action">Admission score management</a>
                                    <a href="${questionAction}" class="list-group-item list-group-item-action">Question management</a>
                                    <a href="${commentAction}" class="list-group-item list-group-item-action">Comment management</a>
                                    <a href="${admissionNewsAction}" class="list-group-item list-group-item-action">Admission News Management</a>
                                    <a href="${register}" class="list-group-item list-group-item-action">Register</a>
                                    <a href="${logoutAction}" class="list-group-item list-group-item-action">Logout</a>

                                </div>

                            </div>
                        </div>
                        <div class="card col-md-5 text-white bg-primary py-5 border-0 pt-0 px-0">
                            <img src="https://hoisinhvientphcm.com/wp-content/uploads/2021/06/IMG_1679-copy-1024x683-1.jpg" class="card-img" alt="image">

                            <div class="card-body text-center ">
                                <div>
                                    <h2>Admission Supporter System</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                    <a href="${indexAction}" class="btn btn-lg btn-outline-light mt-3" >Home Page</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script defer="" src="<c:url value="/resources/js/main.js" />"></script>
    </body>
</html>
