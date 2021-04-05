<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Lists</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <!-- Brand -->
      <a class="navbar-brand" href="#">
        <img src="" alt="Logo" style="width:60px;">
      </a>
    
      <!-- Links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/list">List</a>
        </li>
       </ul>
      
    </nav>
  </header>
  <div align="center">
<h2>JSP that can list entities/models</h2>
<p>Note: Tables will be empty if there isnt data in MySQL tables</p>
 <!-- Had to add the dependency for forEach 
    <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency> 
        
         <dependency>
        <groupId>org.apache.tomcat</groupId>
        <artifactId>tomcat-jasper</artifactId>
        <version>9.0.19</version>
    </dependency>-->
<table>
<tr>
  <th>Genre ID</th>
  <th>Name</th>
  
</tr>
   <c:forEach items="${genres}" var="genres"> 
   
        
        <tr>
            <td>${genres.id}</td>
            <td>${genres.name}</td>
           
        </tr>
    </c:forEach>
</table>

    

<h6> </h6>
<table>
<tr>
  <th>Album ID</th>
  <th>Name</th>
  <th>Artist</th>
  <th>Price</th>
  <th>Release Date</th>
  <th>Genre ID</th>
</tr>
   <c:forEach items="${albums}" var="albums"> 
   
        
        <tr>
            <td>${albums.id}</td>
            <td>${albums.name}</td>
           <td>${albums.artist}</td>
            <td>${albums.price}</td>
            <td>${albums.release_date}</td>
            <td>${albums.genre_id}</td>
        </tr>
    </c:forEach>
</table>

    

<h6> </h6>
<table>
<tr>
 <th>Music ID</th>
  <th>Name</th>
  <th>Price</th>
  <th>Track Number</th>
  <th>Album ID</th>
  
</tr>
   <c:forEach items="${music}" var="music"> 
   
        
        <tr>
            <td>${music.id}</td>
            <td>${music.name}</td>
           <td>${music.price}</td>
            <td>${music.track_number}</td>
            <td>${music.album_id}</td>
            
        </tr>
    </c:forEach>
</table>

    

<h6> </h6>
 <a href="/">
      <input type="submit" value="Home"/>
     </a>
     </div>
</body>
</html>