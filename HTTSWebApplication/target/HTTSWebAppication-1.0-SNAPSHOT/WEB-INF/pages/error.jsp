

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
        <script src="<c:url value="/resources/js/load.js" />"></script>

                  <div class="bg-body-tertiary min-vh-100 d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="clearfix">
                    <h1 class="float-start display-3 me-4">404</h1>
                    <h4 class="pt-3">Oops! You're lost.</h4>
                    <p class="text-body-secondary">The page you are looking for was not found.</p>
                </div>
                <div class="input-group"><span class="input-group-text">
                        <svg class="icon">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-magnifying-glass"></use>
                        </svg></span>
                    <input class="form-control" id="prependedInput" size="16" type="text" placeholder="What are you looking for?">
                    <button class="btn btn-info" type="button">Search</button>
                </div>
            </div>
        </div>
    </div>
</div>              

    </body>
</html>
