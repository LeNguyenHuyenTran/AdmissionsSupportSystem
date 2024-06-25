<%-- 
    Document   : detailComment
    Created on : 27 May 2024, 20:17:14
    Author     : minh-nguyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:url value="/question" var="action"/>
<h2 class="px-5 mb-4 text-left text-body fw-bold">${title}</h2>

<form:form  class="px-5" method="post" action="${action}" >
      <c:if test="${not empty sessionScope.createQuestionMessage}">
                                        <div class="mb-3 alert-info alert py-2">${sessionScope.createQuestionMessage}</div>
                                    </c:if>
    <form:errors path="*" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Id</label>
        <input readonly value="${question.id}" type="text" name="id" class="form-control" id="exampleFormControlInput1" placeholder="your id">
    </div>
    <form:errors path="id" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Content</label>
        <input value='${question.noidung}' type="text" name="noidung" class="form-control" id="exampleFormControlInput1" placeholder="your content">
    </div>
        <form:errors path="noidung" cssClass="text-danger mb-3" element="span"/>

    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Create</label>
        <input   type="datetime-local" value="${question.thoidiem}" name="thoidiem" class="form-control" id="exampleFormControlInput1" placeholder="your content"/>
    </div>
    <form:errors path="thoidiem" cssClass="text-danger mb-3" element="span"/>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Author</label>
        <select class="form-select" id="exampleFormControlInput1" name="userid" aria-label="Default select example">
            <c:forEach items="${users}"  var="u">

                <c:set var="questionId" value="${u.id}"/>
              <c:set var="questionId2" value="${question.thisinh.id}"/>
                              
                <c:choose>
                    <c:when test="${questionId eq questionId2}">
                        <option value="${u.id}" selected>${u.hoten}</option>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${fn:contains(u.role.id,3)==true}">
                            <option value="${u.id}">${u.hoten}</option>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Live stream notify</label>
        <select name="livestreamnotifyid" class="form-select" id="exampleFormControlInput1"  aria-label="Default select example">
           
            <c:forEach items="${livestreamNotifies}"  var="n">
                <c:set var="lnId" value="${n.id}" />
                <c:set var="lnId2" value="${question.thongbaolivestream.id}"/>
                <c:choose>
                    <c:when test="${fn:contains(lnId, lnId2)==true}">
                        <option value="${n.id}" selected>${n.giolivestream}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${n.id}">${n.giolivestream}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Video live stream</label>
        <select name="videolivestreamid" class="form-select" id="exampleFormControlInput1" aria-label="Default select example">
            <c:forEach items="${videoLivestream}"  var="n">
                <c:set var="vlId" value="${n.id}"/>
                <c:set var="vlId2" value="${question.video.id}"/>
                <c:choose>
                    <c:when test="${fn:contains(vlId, vlId2)==true}">
                        <option value="${n.id}" selected>${n.tieude}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${n.id}">${n.tieude}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
<c:if test="${not empty sessionScope.questionErrors}">
                                            <c:forEach items="${sessionScope.questionErrors}" var="error">
                                                <div class="text-danger alert alert-info p-2 mb-3">${error}</div>
                                            </c:forEach>
                                                </c:if>
    <div class="mb-3">
        <button type="submit" class="btn btn-dark">Create</button>
    </div>
</form:form>












