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
<h2>User information</h2>
<h3>Please fill in your information</h3>
<form action="register" method="post">
  <label for="firstname">First Name</label><br>
  <input type="text" id="firstname" name="firstname"><br>
  <h6> </h6>
  <label for="lastname">Last Name</label><br>
  <input type="text" id="lastname" name="lastname"><br>
   <h6> </h6>
    <label for="username">Username</label><br>
  <input type="text" id="username" name="username"><br>
  <h6> </h6>
  <label for="password">Password</label><br>
  <input type="password" id="password" name="password"><br>
   <h6> </h6>
 <input type="submit" value="Submit">
 </form>
 <h6> </h6>
 <a href="index.jsp">
      <input type="submit" value="Main Menu"/>
     </a>



</div>
</body>
</html>