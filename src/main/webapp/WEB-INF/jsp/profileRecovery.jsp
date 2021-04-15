<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile Recovery</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profileRecovery_Style.css">
</head>
<body>
<br>
<h1>Username / Password Recovery</h1><br>
<form method="post">
    <label>
        <input type="email" name="email" placeholder="Enter Your Email Address" required>
    </label>
    <input type="submit" value="submit">
</form>
<c:if test="${ not empty userNotFound}">
    <script>
        alert("${userNotFound}");
    </script>
</c:if>
<c:if test="${not empty result}">
    <div class="solid">
        <pre>Username: ${result.userName}</pre>
        <br>
        <pre>Password: ${result.password}</pre>
    </div>
</c:if>
<<br>
<a href="${pageContext.request.contextPath}/authenticate/userLogin">Login</a>
</body>
</html>