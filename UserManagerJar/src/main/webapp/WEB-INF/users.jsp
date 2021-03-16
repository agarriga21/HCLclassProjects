<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<div align="center">
<h2>User Information</h2>



<table style="float:center">
   <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
   <c:forEach items="${user}" var="user" varStatus="count">
    <tr id="${count.index}">
    	<td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>
    </tr>
  </c:forEach>
</table>
<form:form modelAttribute="id" method="get" action="edit/${id}">
   <h6> </h6>
      <input type="submit" value="Edit"/>
     </form:form> 
 <h6> </h6>
 <a href="/">
      <input type="submit" value="Logout"/>
     </a>
</div>
</body>
</html>