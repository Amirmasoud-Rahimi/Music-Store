<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/genres_Style.css">
<div>
    <h3 id="genresHeader">Genres</h3>
    <form method="post">
        <label>
            <input id="genre" pattern=".*\S+.*" type="text" name="name" placeholder="Enter New Genre" required>
        </label>
        <input type="submit" value="submit">
    </form>
    <table id="genresTable">
        <tr>
            <th>Genre ID</th>
            <th>Genre Name</th>
            <th></th>
        </tr>
        <c:forEach items="${allGenres}" var="genre">
            <tr>
                <td>${genre.genreId}</td>
                <td>${genre.name}</td>
                <td>
                    <button id="genreDelete"
                            onclick="location.href='${pageContext.request.contextPath}/admin/deleteGenre/${genre.genreId}'">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>