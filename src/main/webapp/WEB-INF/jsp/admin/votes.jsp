<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/votes_Style.css">
<div>
    <h3 id="voteHeader">Music Album Votes Table</h3>
    <c:if test="${empty membersVote}">
        <pre>None Of The Music Albums Have Been Voted On</pre>
    </c:if>
    <table id="voteTable">
        <tr>
            <th>Album Name</th>
            <th>Album Genre</th>
            <th>Number of Votes</th>
        </tr>
        <c:forEach items="${membersVote}" var="vote">
            <tr>
                <td>${vote.albumName}</td>
                <td>${vote.albumGenre}</td>
                <td>${vote.numberOfVotes}</td>
            </tr>
        </c:forEach>
    </table>
</div>