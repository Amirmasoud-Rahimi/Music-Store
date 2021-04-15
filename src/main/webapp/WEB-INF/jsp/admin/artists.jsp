<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/artists_Style.css">
<div>
    <h3 id="artistHeader">Artists</h3>
    <table id="artistTable">
        <tr>
            <th>Artist ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Nick Name</th>
        </tr>
        <c:forEach items="${artists}" var="artist">
            <tr>
                <td>${artist.artistId}</td>
                <td>${artist.firstName}</td>
                <td>${artist.lastName}</td>
                <td>${artist.nickName}</td>
            </tr>
        </c:forEach>
        <c:if test="${page>0}">
            <button id="previous" name="previous"
                    onclick="location.href='${pageContext.request.contextPath}/admin/artists/${page-1}'">
                Previous
            </button>
        </c:if>
        <c:if test="${artists.size()>5}">
            <button id="next" name="next"
                    onclick="location.href='${pageContext.request.contextPath}/admin/artists/${page+1}'">
                Next
            </button>
        </c:if>
    </table>
</div>