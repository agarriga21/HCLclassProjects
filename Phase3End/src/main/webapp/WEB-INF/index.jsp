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
<h2>Welcome to the Task Manager</h2>
<h3>Please login or register!</h3>
<form action="login" method="get">
    
  <h6> </h6>
 

      <input type="submit" value="Login"/>
    
</form>

<form action="register" method="get">
    
  <h6> </h6>
 

      <input type="submit" value="Register"/>
    
</form>
</div>
</body>
</html>