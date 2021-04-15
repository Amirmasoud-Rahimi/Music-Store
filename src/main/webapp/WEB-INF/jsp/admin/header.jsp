<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/header_Style.css">
<header class="block">
    <ul class="header-menu horizontal-list">
        <li id="console">Administrator Console</li>
        <li>
            <a class="header-menu-tab" href="${pageContext.request.contextPath}">
                <span class="icon entypo-cog scnd-font-color"></span>Home</a>
        </li>
        <li>
            <a class="header-menu-tab" href="${pageContext.request.contextPath}/musicAlbum"><span
                    class="icon fontawesome-envelope scnd-font-color"></span>Music Albums</a>
        </li>
        <li>
            <a class="header-menu-tab" href="${pageContext.request.contextPath}/admin/members"><span
                    class="icon fontawesome-envelope scnd-font-color"></span>Members</a>
        </li>
        <li>
            <c:set var="page" value="0"> </c:set>
            <a class="header-menu-tab" href="${pageContext.request.contextPath}/admin/artists/${page}"><span
                    class="icon fontawesome-star-empty scnd-font-color"></span>Artists</a>
        </li>
        <li>
            <a class="header-menu-tab" href="${pageContext.request.contextPath}/admin/genres"><span
                    class="icon fontawesome-star-empty scnd-font-color"></span>Genres</a>
        </li>
    </ul>
    <a id="logout" href="${pageContext.request.contextPath}/authenticate/adminLogout">Log Out</a>
</header>