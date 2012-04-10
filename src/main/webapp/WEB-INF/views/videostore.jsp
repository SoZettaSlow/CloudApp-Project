<%@ page import="ie.cit.video.Videostore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CIT Video Store</title>
</head>
<body>
	<h1>CIT Video Store</h1>
	<h2>Our Current Video Selection</h2>
	
	<c:forEach items="${videostore}" var="video" varStatus="row">
	
		Product ${video.text} <br />
		${video.stocknum} Items in the Basket

		<form method="post">
			<input name="_method" type="hidden" value="put"> 
			<input name="videoId" type="hidden" value="${video.id}">
			<input type="submit" value="Update">
		</form>

		<form method="post">
			<input name="_method" type="hidden" value="delete"> 
			<input name="videoId" type="hidden" value="${video.id}">
			<input type="submit" value="Delete">
		</form>
		<br />
	</c:forEach>
	
	<h2></h2>
	<form method="post">
		Text: <select name="text">
			<option>Movie 1</option>
			<option>Movie 2</option>
			<option>Movie 3</option>
		</select>
		Stock: <select name="stocknum">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>
		<br />
		<input type="submit">
		
	</form>
</body>
</html>