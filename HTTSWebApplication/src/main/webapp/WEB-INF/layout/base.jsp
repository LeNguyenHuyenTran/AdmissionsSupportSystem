<%-- 
    Document   : base
    Created on : 14 May 2024, 19:06:13
    Author     : minh-nguyen
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>
            <tiles:insertAttribute name="title"/>
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
        </style>
         <!-- Option 2: CoreUI PRO for Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/@coreui/coreui-pro@5.1.0/dist/js/coreui.bundle.min.js" integrity="sha384-86eT557yN6+cWfDcCEUIjzKvSe8xM5LXynY586L2TwybjqoAzi5SJaQ4Bphcm3TF" crossorigin="anonymous"></script>
    </head>
    <body>
        <tiles:insertAttribute name="sidebar" />
        <div class="wrapper d-flex flex-column min-vh-100">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="content" />
            <tiles:insertAttribute name="footer" />
        </div>
       
    </body>
</html>
