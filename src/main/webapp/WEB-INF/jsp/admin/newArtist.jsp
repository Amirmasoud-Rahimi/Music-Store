<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/newArtist_Style.css">
<div>
    <h2 id="artistHeader">Add New Artist</h2>
    <form:form id="artistForm" method="post" modelAttribute="artist">
        <label id="firstName">
            <form:input placeholder="Enter First Name" path="firstName"/>
            <form:errors id="error1" path="firstName" cssClass="error"/>
        </label><br>
        <label id="lastName">
            <form:input placeholder="Enter Last Name" path="lastName"/>
            <form:errors id="error2" path="lastName" cssClass="error"/>
        </label><br>
        <label id="nickName">
            <form:input placeholder="Enter Nick Name" path="nickName"/>
            <form:errors id="error3" path="nickName" cssClass="error"/>
        </label><br>
        <button class="button artist-button" type="submit">Register</button>
    </form:form>
</div>