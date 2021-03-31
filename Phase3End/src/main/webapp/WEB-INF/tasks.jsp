<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Welcome to the Task Manager</h2>
<table>
<tr>
  <th>Task Name</th>
  <th>Description</th>
  <th>Start Date</th> 
  <th>End Date</th>
  <th>Task Severity</th>
 <th>Edit</th>
 <th>Delete</th>
</tr>
    <c:forEach items="${usertasks}" var="usertasks">
        <tr>
            <td>${usertasks.taskName}</td>
            <td>${usertasks.description}</td>
            <td>${usertasks.start}</td>
            <td>${usertasks.end}</td>
            <td>${usertasks.severity}</td>
            <td><a href="/edit/${usertasks.userid}/${usertasks.id}">Edit</a></td>
            <td><a href="/delete/${usertasks.userid}/${usertasks.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>