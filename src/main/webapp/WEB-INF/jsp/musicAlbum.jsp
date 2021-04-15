<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Music Albums</title>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/musicAlbum_Style.css"/>
</head>
<body>
<header>
    <div class="container" id="header">
        Collection Of Best Music
    </div>
</header>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <div id="lhs">
                <div>
                    <button id="category" onclick="location.href='${pageContext.request.contextPath}/musicAlbum'">
                        Category by Genre
                    </button>
                    <button id="search" onclick="location.href='${pageContext.request.contextPath}/musicAlbum/search'">
                        Search
                    </button>
                </div>
                <br>
                <c:forEach items="${genres}" var="genre">
                    <a id="album"
                       href="${pageContext.request.contextPath}/musicAlbum/${genre.name}">${genre.name}</a><br>
                </c:forEach>
                <c:if test="${not empty genre}">
                    <pre>Category By Genre: ${genre}</pre>
                    <br>
                </c:if>
                <c:forEach items="${albums}" var="album">
                    <a id="album"
                       href="${pageContext.request.contextPath}/musicAlbum/${album.albumId}/${album.genre.name}">
                            ${album.albumName}
                    </a><br>
                </c:forEach>
                <c:if test="${not empty search}">
                    <form method="get">
                        <br>
                        <label>
                            <input type="text" name="keyWord" placeholder="Enter Music Album Name">
                        </label>
                        <input id="submit" type="submit" value="Search">
                    </form>
                    <span><br></span>
                    <span><br></span>
                    <c:forEach items="${foundAlbums}" var="album">
                        <a id="album"
                           href="${pageContext.request.contextPath}/musicAlbum/${album.albumId}/${album.genre.name}">
                                ${album.albumName}
                        </a><br>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div class="col-xs-6">
            <div id="rhs1">
                <c:if test="${empty album && not empty albums}">
                    <pre>Click On Music Album Name to Show Details</pre>
                </c:if>
                <c:if test="${not empty genres}">
                    <pre>Click On Genre to See Albums Of Each Genre</pre>
                </c:if>
                <c:if test="${not empty album}">
                    <audio controls>
                        <source src="${album.sampleSongUrl}" type="audio/MPeg">
                    </audio>
                    <pre>Music Album Details :</pre>
                    <pre>Album Name : ${album.albumName}</pre>
                    <pre>Singer : ${album.artist.firstName} ${album.artist.lastName}</pre>
                    <pre>Singer Nick Name : ${album.artist.nickName}</pre>
                    <pre>Genre : ${album.genre.name}</pre>
                    <pre>Release Date :${album.releaseDate}</pre>
                    <pre>Price : ${album.price} (T)</pre>
                    <p>Music Album Images :
                        <c:forEach items="${album.images}" var="image">
                            <button id="image" onclick="myFunction('${image}')">Image</button>
                        </c:forEach>
                    </p>
                    <c:if test="${not empty sessionScope.member}">
                        <a id="add"
                           href="${pageContext.request.contextPath}/cart/add/${album.albumId}/${album.genre.name}">
                            Add To Card
                        </a>
                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                        <a id="vote" href="${pageContext.request.contextPath}/member/setVote/${album.albumId}">
                            Get Vote
                        </a>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div id="footer" class="container">
    <a href="${pageContext.request.contextPath}">
        <input type="button" value="Back to Home" class="btn btn-block btn-primary"/>
    </a>
</div>
<c:if test="${not empty sessionScope.member and empty sessionScope.admin}">
    <div id="profile" class="container">
        <a href="${pageContext.request.contextPath}/member">
            <input type="button" value="Member Profile" class="btn btn-block btn-primary"/>
        </a>
    </div>
</c:if>
<c:if test="${not empty sessionScope.admin and empty sessionScope.member}">
    <div id="profile" class="container">
        <a href="${pageContext.request.contextPath}/admin">
            <input type="button" value="Admin Profile" class="btn btn-block btn-primary"/>
        </a>
    </div>
</c:if>
<c:if test="${empty sessionScope.member and empty sessionScope.admin}">
    <div id="profile" class="container">
        <a href="${pageContext.request.contextPath}/authenticate/register">
            <input type="button" value="Please Sign Up to Use The Site Features" class="btn btn-block btn-primary"/>
        </a>
    </div>
</c:if>
<c:if test="${not empty voteSetSuccessfully}">
    <script>
        alert("${voteSetSuccessfully}");
    </script>
</c:if>
<c:if test="${not empty invalidVote}">
    <script>
        alert("${invalidVote}");
    </script>
</c:if>
<c:if test="${not empty albumAddedSuccessfully}">
    <script>
        alert("${albumAddedSuccessfully}");
    </script>
</c:if>
<c:if test="${not empty addToCartSuccessfully}">
    <script>
        alert("${addToCartSuccessfully}");
    </script>
</c:if>
<script>
    function myFunction(fileName) {
        window.open(fileName, "_blank", "top=200,left=500,width=400,height=400");
    }
</script>
</body>
</html>