<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Member</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/member_Style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/header_Style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/menuBox_Style.css">
</head>
<body>
<div class="main-container">
    <header class="block">
        <ul class="header-menu horizontal-list">
            <li>
                <a id="home" class="header-menu-tab" href="${pageContext.request.contextPath}">
                    <span class="icon entypo-cog scnd-font-color"></span>Home</a>
            </li>
            <li>
                <a id="logOut" class="header-menu-tab"
                   href="${pageContext.request.contextPath}/authenticate/userLogout">
                    <span class="icon fontawesome-user scnd-font-color"></span>Log Out</a>
            </li>
            <li id="console">Member Console</li>
        </ul>
        <c:set var="member" value="${sessionScope.member.firstName} ${sessionScope.member.lastName}"> </c:set>
        <div class="profile-menu">
            <p><span class="entypo-down-open scnd-font-color"></span>${member}</p>
        </div>
    </header>
    <div class="left-container container">
        <div class="menu-box block">
            <h2 class="titular">MENU BOX</h2>
            <ul class="menu-box-menu">
                <li>
                    <a class="menu-box-tab" href="${pageContext.request.contextPath}/musicAlbum">
                        <span class="icon fontawesome-envelope scnd-font-color"></span>Music Albums
                    </a>
                </li>
                <li>
                    <a class="menu-box-tab" href="${pageContext.request.contextPath}/cart">
                        <span class="icon entypo-paper-plane scnd-font-color"></span>Shopping Cart
                        <div class="menu-box-number">${sessionScope.cart.cartItems.size()}</div>
                    </a>
                </li>
                <li>
                    <a class="menu-box-tab" href="${pageContext.request.contextPath}/member/memberInfo">
                        <span class="icon entypo-calendar scnd-font-color"></span>Account Settings
                    </a>
                </li>
                <li>
                    <a class="menu-box-tab" href="${pageContext.request.contextPath}/member/changePassword">
                        <span class="icon entypo-calendar scnd-font-color"></span>Password Management
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<c:if test="${not empty shopping}">
    <jsp:include page="shopping.jsp"/>
</c:if>
<c:if test="${not empty total}">
    <jsp:include page="checkOut.jsp"/>
</c:if>
<c:if test="${not empty password}">
    <jsp:include page="password.jsp"/>
</c:if>
<c:if test="${not empty memberInfo}">
    <div class="solid">
        <h3 id="infoHeader">Member Information:</h3>
        <pre>First Name: ${sessionScope.get("member").firstName}</pre>
        <pre>Last Name : ${sessionScope.get("member").lastName}</pre>
        <pre>Email : ${sessionScope.get("member").email}</pre>
        <pre>UserName: ${sessionScope.get("member").userName}</pre>
    </div>
</c:if>
<c:if test="${not empty orderSuccessfullyRegistered}">
    <script>
        alert("${orderSuccessfullyRegistered}");
    </script>
</c:if>
<c:if test="${empty sessionScope.member}">
    <script>
        alert("Please First Login");
        window.location = '${pageContext.request.contextPath}';
    </script>
</c:if>
</body>
</html>