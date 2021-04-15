<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/bestSellers_Style.css">
<div>
    <h3 id="sellersHeader">Top Selling Music Albums</h3>
    <form id="dateForm" method="post">
        <label for="startDate">Start</label>
        <input id="startDate" type="date" name="startDate" required>
        <label for="endDate">End</label>
        <input id="endDate" type="date" name="endDate" required>
        <input id="submit" type="submit" name="submit" value="Submit"><br>
        <span><br></span>
        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
        <label for="date">Enable Date</label>
        <input id="date" type="radio" value="enable" onclick="enable()" name="No Date" checked>
        <label for="noDate">Disable Date</label>
        <input id="noDate" type="radio" value="disable" onclick="disable()" name="No Date">
    </form>
    <table id="bestSellersTable">
        <tr>
            <th>Album ID</th>
            <th>Album Name</th>
            <th>Album Genre</th>
            <th>Sales Number</th>
            <th>Start Date</th>
            <th>End Date</th>
        </tr>
        <c:if test="${not empty result}">
            <c:forEach items="${result}" var="item">
                <tr>
                    <td>${item.albumId}</td>
                    <td>${item.albumName}</td>
                    <td>${item.albumGenre}</td>
                    <td>${item.salesNumber}</td>
                    <c:choose>
                        <c:when test="${empty startDate}">
                            <td>Totally</td>
                        </c:when>
                        <c:otherwise>
                            <td>${startDate}</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${endDate}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<script type="text/javascript">
    function disable() {
        document.getElementById("endDate").disabled = true;
        document.getElementById("startDate").disabled = true;
    }

    function enable() {
        document.getElementById("endDate").disabled = false;
        document.getElementById("startDate").disabled = false;
    }
</script>