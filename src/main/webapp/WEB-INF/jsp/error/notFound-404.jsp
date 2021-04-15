<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>404 Not Found</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error/notFound-404_Style.css">
</head>
<body>
<div title="404">404 Not Found!</div>
<div><a href="${pageContext.request.contextPath}">Home Page</a></div>
<div id="error">
    <pre>Reason :${reason}</pre>
    <pre>Failed URL :${url}</pre>
</div>
</body>
</html>