<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrator</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin_Style.css">
</head>
<body>
<div class="main-container">
    <jsp:include page="header.jsp"/>
    <jsp:include page="menuBox.jsp"/>
    <c:if test="${not empty page}">
        <jsp:include page="artists.jsp"/>
    </c:if>
    <c:if test="${not empty allGenres or not empty genre}">
        <jsp:include page="genres.jsp"/>
    </c:if>
    <c:if test="${not empty membersTab}">
        <jsp:include page="members.jsp"/>
    </c:if>
    <c:if test="${not empty musicAlbum}">
        <jsp:include page="newAlbum.jsp"/>
    </c:if>
    <c:if test="${not empty artist}">
        <jsp:include page="newArtist.jsp"/>
    </c:if>
    <c:if test="${not empty bestSellers}">
        <jsp:include page="bestSellers.jsp"/>
    </c:if>
    <c:if test="${not empty membersVote}">
        <jsp:include page="votes.jsp"/>
    </c:if>
    <c:if test="${not empty albums}">
        <jsp:include page="albumImage.jsp"/>
    </c:if>
</div>
<c:if test="${not empty artistAddedSuccessfully}">
    <script>
        alert("${artistAddedSuccessfully}");
    </script>
</c:if>
<c:if test="${not empty duplicateArtist}">
    <script>
        alert("${duplicateArtist}");
    </script>
</c:if>
<c:if test="${not empty duplicateGenre}">
    <script>
        alert("${duplicateGenre}");
    </script>
</c:if>
<c:if test="${not empty albumAddedSuccessfully}">
    <script>
        alert("${albumAddedSuccessfully}");
    </script>
</c:if>
<c:if test="${not empty duplicateAlbum}">
    <script>
        alert("${duplicateAlbum}");
    </script>
</c:if>
<c:if test="${not empty imageAddedSuccessfully}">
    <script>
        alert("${imageAddedSuccessfully}");
    </script>
</c:if>
<c:if test="${not empty duplicateImage}">
    <script>
        alert("${duplicateImage}");
    </script>
</c:if>
<c:if test="${not empty InvalidNumber}">
    <script>
        alert("${InvalidNumber}");
    </script>
</c:if>
<c:if test="${empty sessionScope.admin}">
    <script>
        alert("Please First Login!");
        window.location = '${pageContext.request.contextPath}';
    </script>
</c:if>
</body>
</html>