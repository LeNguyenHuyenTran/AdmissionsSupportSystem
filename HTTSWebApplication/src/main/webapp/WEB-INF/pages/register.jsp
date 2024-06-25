<%-- 
    Document   : logout
    Created on : Jun 1, 2024, 3:55:47 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Register
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
            }@keyframes fadeIn {
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
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
        <script src="<c:url value="/resources/js/load.js" />"></script>

        <c:if test="${param.errMsg != null}">
            <div class="alert alert-info">
                ${errMsg}
            </div>
        </c:if>

        <c:url value="/register" var="action" />

        <%--<form:form method="post" action="${action}" modelAttribute="user">
            <form:errors path="*" element="div" cssClass="text-danger alert alert-info p-2 mb-3"/>

    <label for="exampleFormControlInput1" class="form-label">Id</label>
    <input name="id" value="${UID}" readonly type="text" class="form-control mb-3"
           id="exampleFormControlInput1" placeholder="your id"/>
    <div class="form-group">
        <label for="fullname" >Full name</label>
        <input type="text" id="hoten" name="hoten" class="form-control" placeholder="Your full name..."/>
    </div>
    <form:errors path="hoten" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>

    <div class="form-group">
        <label for="username" >Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username..."/>
    </div>
    <form:errors path="username" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>

    <div class="form-group">
        <label for="password" >Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password..."/>
    </div>
    <form:errors path="password" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>

    <div class="form-group">
        <label for="confirm-password" >Confirm Password</label>
        <input type="password" id="confirm-password" name="confirmPassword" class="form-control" placeholder="Confirm Password..."/>
    </div>
    <form:errors path="confirmPassword" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Role</label>
        <select name="roleid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
            <c:forEach items="${roles}" var="n">
                <c:if test="${fn:contains(n.role, 'student')==false}">
                    <option value="${n.id}">${n.role}</option>
                </c:if>
            </c:forEach>
        </select>
    </div>
    <div class="form-group mt-3">
        <input type="submit" value="ĐĂNG KÝ"/>
    </div>

</form:form>--%>
        <div class="bg-body-tertiary min-vh-100 d-flex flex-row align-items-center">
             <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card mb-4 mx-4">
                        <div class="card-body p-4">
                            <h1>Register</h1>
                            <p class="text-body-secondary">Create your account</p>
                            <form:form method="post" action="${action}" modelAttribute="user">
                                <div class="input-group mb-3"><span class="input-group-text">
                                        <i class="fa-solid fa-fingerprint"></i></span>
                                    <input name="id" value="${UID}" readonly type="text" class="form-control mb-3"
                                           id="exampleFormControlInput1" placeholder="your id"/>
                                </div>
                                <div class="input-group mb-3"><span class="input-group-text">
                                        <i class="fa-regular fa-id-card"></i></span>
                                    <input type="text" id="hoten" name="hoten" class="form-control" placeholder="Your full name"/>
                                </div>
                                <form:errors path="hoten" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>

                                <div class="input-group mb-3"><span class="input-group-text">
                                        <i class="fa-regular fa-user"></i></span>
                                    <input type="text" id="username" name="username" class="form-control" placeholder="Your Username"/>
                                </div>
                                <form:errors path="username" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>

                                <div class="input-group mb-4"><span class="input-group-text">
                                        <i class="fa-solid fa-lock"></i></span>
                                    <input type="password" id="password" name="password" class="form-control" placeholder="Your Password"/>
                                </div>
                                <form:errors path="password" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>
                                <div class="input-group mb-4"><span class="input-group-text">
                                        <i class="fa-solid fa-lock"></i></span>
                                    <input type="password" id="confirm-password" name="confirmPassword" class="form-control" placeholder="Your Confirm Password"/>

                                </div>
                                <form:errors path="confirmPassword" cssClass="text-danger alert alert-info mb-3 p-2" element="div"/>
                                <div class="input-group mb-4"><span class="input-group-text">
                                        <i class="fa-solid fa-person-circle-question"></i></span>
                                    <select name="roleid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
                                        <c:forEach items="${roles}" var="n">
                                            <c:if test="${fn:contains(n.role, 'ROLE_STUDENT')==false}">
                                                <option value="${n.id}">${n.role}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>

                                </div>
                                <c:if test="${not empty sessionScope.userErrors}">
                                            <c:forEach items="${sessionScope.userErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
                                <form:errors path="*" element="div" cssClass="text-danger alert alert-info p-2 mb-3"/>
                                <button class="btn btn-block btn-primary" type="submit">Create Account</button>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>

       
    </body>
</html>
