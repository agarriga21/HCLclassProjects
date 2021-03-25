
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
 <div align="center">
<p>You are currently logged in!</p>
 <h3>So you want to go to the main page logged in?</h3>
<a href="/">
      <input type="submit" value="Main Page"/>
     </a>
     <h3>Logout option:</h3>
<form action="/logout" method="post">
    <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout" />
</form>
</div>
</body>
</html>