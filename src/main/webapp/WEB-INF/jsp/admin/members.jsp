<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/members_Style.css">
<div>
    <h3 id="membersHeader">Members :</h3>
    <form action="${pageContext.request.contextPath}/admin/members" method="get">
        <label>
            <input id="maxResult" type="text" name="maxResult" onchange="this.form.submit()"
                   placeholder="Enter Max Result (Default: 5)" required>
        </label>
    </form>
    <c:if test="${not empty membersPage}">
        <table id="membersTable">
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User Name</th>
            </tr>
            <c:forEach items="${membersPage}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>