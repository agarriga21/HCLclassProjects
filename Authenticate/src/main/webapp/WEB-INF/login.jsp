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
<form action="login" method="post">

    <label for="name">Username</label><br>
  <input type="text" id="name" name="name"><br>
  <h6> </h6>
  <label for="password">Password</label><br>
  <input type="password" id="password" name="password"><br>
   <h6> </h6>
 <input type="submit" value="Submit"><br>
</form>


</div>
</body>
</html>