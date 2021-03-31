<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User</title>
</head>
<body>
 <div align="center">
<h2>User Login</h2>
<h3>Please fill in your Username and Password</h3>
<form action="login" method="post">

    <label for="username">Username</label><br>
  <input type="text" id="name" name="username" required="required"><br>
  <h6> </h6>
  <label for="password">Password</label><br>
  <input type="password" id="password" name="password" required="required"><br>
   <h6> </h6>
 <input type="submit" value="Submit"><br>
</form>

<h1><font color="red">${errorMessage}</font></h1>
</div>
</body>
</html>