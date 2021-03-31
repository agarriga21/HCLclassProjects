<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>Successfully Logged in!</h2>

   
<form:form modelAttribute="id" method="post" action="tasks/${id}">
   <h6> </h6>
      <input type="submit" value="Task List"/>
     </form:form>

</div></body>
</html>