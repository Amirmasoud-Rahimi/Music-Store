<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="//use.fontawesome.com/84c9ca0cf8.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/FitText.js/1.2.0/jquery.fittext.js"></script>
    <script type="text/javascript">
        $("#fittext1").fitText(1.1);
        $("#fittext2").fitText(1.5);
    </script>
    <title>500 Server Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error/server-500_Style.css">
</head>
<body>
<div class="wrap">
    <article>
        <header>
            <h1 id="fittext1">500<i class="fa fa-exclamation-triangle fa-fw"></i></h1>
        </header>
        <p id="fittext2">Internal Server Error</p>
    </article>
    <pre>Reason :${reason}</pre>
    <pre>Failed URL :${url}</pre>
</div>
<a href="${pageContext.request.contextPath}">Home Page</a>
</body>
</html>