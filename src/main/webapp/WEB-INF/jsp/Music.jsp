<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Music</title>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/icon.png" title="Favicon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/music_Style.css">
</head>
<body>
<embed src="${pageContext.request.contextPath}/resources/mp3/despacito.mp3" autostart="true">
<a id="musicAlbum" href="${pageContext.request.contextPath}/musicAlbum">Music Album </a>
<a id="signUp" href="${pageContext.request.contextPath}/authenticate/register">Sign Up</a>
<div class="dropdown">
    <a class="dropButton">Sign In</a>
    <div class="dropdown-content">
        <a id="userLink" href="${pageContext.request.contextPath}/authenticate/userLogin">Member</a>
        <a id="adminLink" href="${pageContext.request.contextPath}/authenticate/adminLogin">Admin</a>
    </div>
</div>
<c:set var="member" value="${sessionScope.member.firstName} ${sessionScope.member.lastName}"> </c:set>
<a id="user" href="${pageContext.request.contextPath}/member">${member}</a>
<a id="admin" href="${pageContext.request.contextPath}/admin">${sessionScope.admin}</a>
<footer>
    <pre>All Rights Reserved / 2020 / Amirmasoud Rahimi</pre>
</footer>
</body>
</html>