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
        <img src="images/whiteGuitar.jpg" alt="Logo" style="width:60px;">
      </a>
    
      <!-- Links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/list">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="">About</a>
          </li>
       </ul>
       <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Register</a>
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

    <style>
      .container-fluid
    {
      
      border-top:1px solid rgb(0, 0, 0);
      border-bottom:1px solid rgb(0, 0, 0);
     width: 1200px;
      border-left:1px solid rgb(0, 0, 0) ;
      border-right:1px solid rgb(0, 0, 0) ;
    }
    
      .col
    {
      padding-top: 30px;
      padding-bottom: 30px;
      border-left:1px solid rgb(0, 0, 0) ;
      border-right:1px solid rgb(0, 0, 0) ;
      
    }
    .table
    {
      padding-bottom: 50px;
      
      
    }
    </style>
    
   
    <div class="table">
    <div class="container-fluid" align="center">
      <div class="row">
        <div class="col"><h5>Picture</h5>
        </div>
        <div class="col"><h5>Genre ID</h5></div>
        <div class="col"><h5>Name</h5></div>
      </div>
    </div>
   
   <c:forEach items="${genres}" var="genres"> 
    <div class="container-fluid" align="center">
      <div class="row">
        <div class="col">
          <img src="images/rock.jpg" alt="rock" width="150" height="150">
        </div>
        <div class="col">${genres.id}</div>
        <div class="col">${genres.name}</div>
      </div>
    </div>
    </c:forEach>
  </div>

    


</div>
<div class="table">
<div class="container-fluid" align="center">
  <div class="row">
    <div class="col"><h5>Picture</h5></div>
    <div class="col"><h5>Album ID</h5></div>
    <div class="col"><h5>Name</h5></div>
    <div class="col"><h5>Artist</h5></div>
    <div class="col"><h5>Price</h5></div>
    <div class="col"><h5>Release Date</h5></div>
    <div class="col"><h5>Genre ID</h5></div>
    <div class="col"><h5>Buy Now</h5></div>
  </div>
</div>

<c:forEach items="${albums}" var="albums"> 
<div class="container-fluid" align="center">
  <div class="row">
    <div class="col">
      <img src="images/album.jpg" alt="album" width="100" height="100">
    </div>
    <div class="col">${albums.id}</div>
    <div class="col">${albums.name}</div>
    <div class="col">${albums.artist}</div>
    <div class="col">${albums.price}</div>
    <div class="col">${albums.release_date}</div>
    <div class="col">${albums.genre_id}</div>
    <div class="col">
      <a href="">
        <input type="submit" value="Add to Cart"/>
       </a><br>
       <p>Would need some function on click</p>
    </div>
  
  </div>
</div>
</c:forEach>
</div>
  


    

<div class="table">
  <div class="container-fluid" align="center">
    <div class="row">
      <div class="col"><h5>Picture</h5></div>
      <div class="col"><h5>Music ID</h5></div>
      <div class="col"><h5>Name</h5></div>
      <div class="col"><h5>Price</h5></div>
      <div class="col"><h5>Track Number</h5></div>
      <div class="col"><h5>Album ID</h5></div>
      <div class="col"><h5>Buy Now</h5></div>
    </div>
  </div>
  
  <c:forEach items="${music}" var="music"> 
  <div class="container-fluid" align="center">
    <div class="row">
      <div class="col">
        <img src="images/song.jpg" alt="song" width="100" height="100">
      </div>
      <div class="col">${music.id}</div>
      <div class="col">${music.name}</div>
      <div class="col">${music.price}</div>
      <div class="col">${music.track_number}</div>
      <div class="col">${music.album_id}</div>
      <div class="col">
        <a href="">
          <input type="submit" value="Add to Cart"/>
         </a><br>
         <p>Would need some function on click</p>
      </div>
    
    </div>
  </div>
  </c:forEach>
  </div>

 
    
</body>
</html>