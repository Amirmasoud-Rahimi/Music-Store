<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>403 Forbidden</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/error/forbidden-403_Style.css">
</head>
<body>
<div class="code-area">
    <span id="span2">
      public static void check(forbidden){
  </span>
    <span>
    <span id="span3">
      if
    </span>
	  (<span id="span4">forbidden</span>)
    {
  </span>
    <span id="span1">
     <i></i>Reason :${reason}
  </span>
    <span id="span14">
     <i></i>Failed URL :${url}
  </span>
    <span>
    <span id="span5">
       <i></i>throw
    </span>
    <span>
      <span id="span6">New ForbiddenException("403 forbidden");</span>
    </span>
      <span id="span7"><span id="span11">---</span>}</span>
	  <span id="span8">
          }<br><span id="span9">public static void main(String[] args) {</span>
          <br><span id="span10">Home home = new Home();</span><br>
          <a href="${pageContext.request.contextPath}">home.goHome();</a></span>
	  <br><span id="span12"><span id="span13">----</span>}</span><br>}
  </span>
</div>
</body>
</html>