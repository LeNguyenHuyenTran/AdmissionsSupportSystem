<%-- 
    Document   : login
    Created on : May 28, 2024, 2:44:22 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Login
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
                animation: fadeOut 0.5s ease forwards;
            }
            #loadItem{
                z-index: 9999;
                position: fixed;
                animation: fadeIn 0.5s ease forwards;

            }
        </style>
        <!-- Option 2: CoreUI PRO for Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/@coreui/coreui-pro@5.1.0/dist/js/coreui.bundle.min.js" integrity="sha384-86eT557yN6+cWfDcCEUIjzKvSe8xM5LXynY586L2TwybjqoAzi5SJaQ4Bphcm3TF" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



        <c:url value="/" var="action" />
        <c:url value="/register" var="registerAction" />

        <!--
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
        </form>-->
        <div class="bg-body-tertiary min-vh-100 d-flex flex-row align-items-center">
            <div class="container d-flex justify-content-center align-items-center" style="height:100vh;">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="card-group d-block d-md-flex row">
                            <div class="card col-md-7 p-4 mb-0">
                                <div class="card-body">
                                    <h1>Login</h1>
                                    <p class="text-body-secondary">Sign In to your account or <a href="${registerAction}">register here.</a></p>
                                    <form method="post" action="${action}">

                                        <div class="input-group mb-3"><span class="input-group-text">
                                                <i class="fa-regular fa-user"></i></span>
                                            <input type="text" id="username" name="username" class="form-control" placeholder="Username"/>
                                        </div>
                                        <div class="input-group mb-4"><span class="input-group-text">
                                                <i class="fa-solid fa-lock"></i></span>
                                            <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                                        </div>
                                        <c:if test="${param.error != null}">
                                            <div class="alert alert-info mb-3 p-2">
                                                Đăng nhập không thành côngg!
                                            </div>
                                        </c:if>
                                        <div class="row">
                                            <div class="col-6">
                                                <button class="btn btn-primary px-4" type="submit">Login</button>
                                            </div>
                                            <div class="col-6 text-end">
                                                <a class="btn btn-link px-0">Forgot password?</a>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                            <div class="card col-md-5 text-white bg-primary p-0 m-0 border-0 ">

                                <a href="${registerAction}" class="card-img h-100" >
                                    <img src="https://ou.edu.vn/wp-content/uploads/2021/01/IMG_1679-copy-1024x683.jpg" class="card-img h-100 " alt="">
                                </a>

                                <div class="card-img-overlay">

                                </div>

                                <!--                                <div class="card-body text-center">
                                                                    <div>
                                                                        <h2>Sign up</h2>
                                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                                        <a href="${registerAction}" class="btn btn-lg btn-outline-light mt-3" >Register Now!</a>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                

    </body>
</html>
