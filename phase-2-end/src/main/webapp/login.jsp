<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User</title>
</head>
<body>
 <div align="center">
<h2>User Login</h2>
<h3>Please fill in your Username and Password</h3>
<form action="authenticate" method="post">

    <label for="username">Username</label><br>
  <input type="text" id="username" name="username"><br>
  <h6> </h6>
  <label for="password">Password</label><br>
  <input type="password" id="password" name="password"><br>
   <h6> </h6>
 <input type="submit" value="Submit"><br>
 <span style=color:red; class="error">${error}</span>
</form>
 <h6> </h6>
 <a href="index.jsp">
      <input type="submit" value="Main Menu"/>
     </a>

</div>
</body>
</html>