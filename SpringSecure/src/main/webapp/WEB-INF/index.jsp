<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

 <div align="center">
<h2>Welcome to the Spring Security Login</h2>
<h3>Proceed to user login</h3>
<form action="loginsuccess" method="get">
    
 
      <input type="submit" value="Go"/>
    
</form>

 <h3>Note: If you have not logged out, you will be taken to the success page</h3>


    
</div>
</body>
</html>