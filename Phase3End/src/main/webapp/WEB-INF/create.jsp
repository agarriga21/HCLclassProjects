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
<h2>Create New Task</h2>
<h3>Please fill in the task information</h3>
<form action="/created/${userid}" method="post">

    <label for="taskname">Task Name</label><br>
  <input type="text" id="taskname" name="taskname" required><br>
  <h6> </h6>
  <label for="description">Description</label><br>
  <input type="text" id="description" name="description" required><br>
   <h6> </h6>
 <label for="start">Start Date</label><br>
  <input type="date" id="start" name="start" required><br>
  <h6> </h6>
  <label for="end">End Date</label><br>
  <input type="date" id="end" name="end" required><br>
  <h6> </h6>
    <label for="severity">Severity</label><br>
  
  <select id="severity" name="severity">
  	<option value="High">High</option>
  	<option value="Medium">Medium</option>
  	<option value="Low">Low</option>
  </select><br>
   <h6> </h6>
 <input type="submit" value="Submit">
 </form>
 <h6> </h6>
 <form action="/tasks/${userid}" method="get">
    
  <h6> </h6>
 

      <input type="submit" value="Go Back"/>
    
</form>


</div>
</body>
</html>