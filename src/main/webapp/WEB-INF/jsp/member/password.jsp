<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/password_Style.css">
<div>
    <form method="post">
        <h2 id="passHeader">Change Password</h2>
        <input type="hidden" name="memberId" value="${sessionScope.member.userId}">
        <label>
            <input id="firstPass" type="password" pattern="\d{4}" name="password" placeholder="Enter New Password"
                   title="Password Must Be at Least 4 Characters Long" required>
        </label><br><br>
        <label>
            <input id="secondPass" type="password" name="confirmPassword" placeholder="Confirm New Password" required>
        </label><br><br>
        <input id="passSubmit" type="submit" value="Change" onclick="return checkPassword(this.form)">
    </form>
</div>
<script type="text/javascript">
    function checkPassword(form) {
        if (document.getElementById('firstPass').value !== document.getElementById('secondPass').value) {
            alert("Password Not Match!");
            return false;
        } else {
            return true;
        }
    }
</script>