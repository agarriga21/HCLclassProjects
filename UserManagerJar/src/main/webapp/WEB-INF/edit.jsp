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
<h2>Edit User information</h2>
<h3>Please fill in your information</h3>
<form:form method="post" action="/confirm" modelAttribute = "user">
  <form:hidden path="Id"/>
    <form:label path="name">Username</form:label><br>
  <form:input path="name"/><br>
  <h6> </h6>
  <form:label path="password">Password</form:label><br>
  <form:input path="password"/><br>
   <h6> </h6>
   <form:label path="email">email</form:label><br>
  <form:input path="email"/><br>
   <h6> </h6>
 <input type="submit" value="Submit">
 </form:form>
 <h6> </h6>
 <a href="/">
      <input type="submit" value="Logout"/>
     </a>



</div>
</body>
</html>