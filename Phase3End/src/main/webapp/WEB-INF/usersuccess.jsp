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
<h2>User Successfully Edited</h2>
<h3>New User Information:</h3>
   
   	<h5>ID: test</h5>
      <h5>Username: ${user.username}</h5>
       <h5>Email: ${user.email}</h5>
        <h5>Password: ${user.password}</h5>
   

<a href="/">
      <input type="submit" value="Logout"/>
     </a>

</div></body>
</html>