<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Pet</title>
</head>
<body>
 <div align="center">
<h2>Pet add information</h2>
<h3>Please fill in the information about the new pet</h3>
<form action="pets" method="post">
  <label for="name">Name</label><br>
  <input type="text" id="name" name="name"><br>
  <h6> </h6>
  <label for="color">Color</label><br>
  <input type="text" id="color" name="color"><br>
   <h6> </h6>
  <label for="price">Price</label><br>
  <input type="text" id="price" name="price"><br><br>
  <input type="submit" value="Submit">
</form>


</div>
</body>
</html>