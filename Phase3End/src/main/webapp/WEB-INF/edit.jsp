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
<form:form method="post" action="/editted/${userid}/${id}" modelAttribute = "task">
  <form:hidden path="Id"/>
  <form:hidden path="userid"/>
    <form:label path="taskName">Task Name</form:label><br>
  <form:input path="taskName" required="required"/><br>
  <h6> </h6>
  <form:label path="description">Description</form:label><br>
  <form:input path="description"/><br>
   <h6> </h6>
   <form:label path="start">Start Date</form:label><br>
  <form:input type = "date" path="start" required="required"/><br>
   <h6> </h6>
   <form:label path="end">End Date</form:label><br>
  <form:input type = "date" path="end" required="required"/><br>
   <h6> </h6>
   <form:label path="severity">Severity</form:label><br>
  <form:input path="severity" required="required"/><br>
   <h6> </h6>
 <input type="submit" value="Submit">
 </form:form>



</div>
</body>
</html>