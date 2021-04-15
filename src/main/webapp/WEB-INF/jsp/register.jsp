<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/register_Style.css"/>
</head>
<body>
<h1>Register</h1>
<span><br></span>
<div class="body-content">
    <div class="module">
        <form class="form" method="post" autocomplete="off">
            <div class="alert alert-error"></div>
            <label>
                <input type="text" placeholder="First Name" pattern=".*\S+.*" name="firstName" title="Space Is Invalid"
                       required/>
            </label>
            <label>
                <input type="text" placeholder="Last Name" pattern=".*\S+.*" name="lastName" title="Space Is Invalid"
                       required/>
            </label>
            <label>
                <input type="email" placeholder="Email" name="email" required/>
            </label>
            <label>
                <input type="text" placeholder="User Name" pattern=".*\S+.*" name="userName" title="Space Is Invalid"
                       required/>
            </label>
            <label>
                <input type="password" placeholder="Password" name="password" required/>
            </label>
            <input type="hidden" name="userType" value="member"/>
            <input type="submit" value="Register" onclick="return check(this.form)" class="btn btn-block btn-primary"/>
            <button class="btn btn-block btn-primary" onclick="location.href='${pageContext.request.contextPath}'">
                Home
            </button>
        </form>
    </div>
</div>
<c:if test="${not empty duplicateUsername}">
    <script>
        alert("${duplicateUsername}");
    </script>
</c:if>
<c:if test="${not empty duplicateEmail}">
    <script>
        alert("${duplicateEmail}");
    </script>
</c:if>
</body>
<script>
    function check(form) {
        if (form.password.value.length > 3) {
            return true;
        } else {
            alert("Password Must Be at Least 4 Characters Long");
            form.reset();
            return false;
        }
    }
</script>
</html>