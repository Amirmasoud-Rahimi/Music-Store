<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Error</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error/error_Style.css">
</head>
<body>
<div class="cover">
    <h1>Our Apologies.</h1>
    <p class="lead">This Page Stepped Out For a Quick Ride.</p>
    <p>Please Go Back to Our <a href="${pageContext.request.contextPath}">Home Page</a> to Restart Your Browsing</p>
    <pre>Reason :${reason}</pre>
    <pre>Failed URL :${url}</pre>
</div>
</body>
</html>