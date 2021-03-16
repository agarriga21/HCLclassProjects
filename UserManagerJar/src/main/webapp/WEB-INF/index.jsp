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
<h3>Please fill in your User Id</h3>
<form action="users" method="post">
    <label for="id">User ID</label><br>
  <input type="number" id="id" name="id"><br>
  <h6> </h6>
 

      <input type="submit" value="Submit"/>
    
</form>
<h5><font color="red">${errorMessage}</font></h5>
<form action="list" method="get">
  
  <h6> </h6>
 

      <input type="submit" value="List"/>
    
</form>
</div>
</body>
</html>