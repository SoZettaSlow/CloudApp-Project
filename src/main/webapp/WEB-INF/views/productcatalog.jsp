<%@ page import="ie.cit.video.Videostore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>


<title>CIT Video Store</title>
</head>

<h1>CIT Video Store</h1>
<h2>Check our Selection!</h2>
<body>
<p id="username">
	User : <security:authentication
		property="principal.username"/>
	<a href="j_spring_security_logout"><br/> Logout</a><br/>
	</p>
	<form method="post" id="products">
	<div id="collection">
			<img src="images/Ghostbusters.jpg"/>
			<img src="images/Back To The Future.jpg"/>
			<img src="images/Anchorman.jpg"/>
			<img src="images/Hurt Locker.jpg"/>
			<img src="images/Jurassic Park.jpg"/> 
	</div>
	
	<div id="text">
			<div id="option1"><input type="radio" name="text" value="Ghostbusters" checked/>Ghostbusters</div>
			<div id="option2"><input type="radio" name="text" value="Back To The Future"/>Back To The Future</div>
			<div id="option3"><input type="radio" name="text" value="Anchorman"/>Anchorman</div>
			<div id="option4"><input type="radio" name="text" value="Hurt Locker"/>Hurt Locker</div>
			<div id="option5"><input type="radio" name="text" value="Jurassic Park"/>Jurassic Park</div>
	</div>
	
	<div id="quantity">
	Amount:	<select name="stocknum">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
		<input type="submit" value="Add to basket"/>
		</form>
		
		<form action="videostore.html">
			<input type="submit" value="View Basket">
		</form>
	</div>



</body>
</html>