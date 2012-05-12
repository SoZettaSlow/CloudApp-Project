<%@ page import="ie.cit.video.Videostore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script>

$(document).ready(function()
{
		for(var j=0;j<=5;j++)
		{
			var e = document.getElementById('dropdown_menu_'+j);
			
			if(e != null){
				//alert(e.options[j].value+ " " +e.options[j].text);
				//alert(j);
				document.getElementById("dropdown_menu_"+j).value = j;
			}
		}
});

</script>
<title>CIT Video Store</title>
</head>
<body>
	<h1>CIT Video Store</h1>
	<h2>Your Basket</h2>
	
<p id="username">
	User : <security:authentication
		property="principal.username"/>
	<a href="j_spring_security_logout"><br/> Logout</a><br/>
	</p>
	<div id="total" style="text-align:center">
		<c:forEach items="${videostore}" var="video" varStatus="row">
		
			Product: ${video.text} <br />
	
			<form method="post">
				<input name="_method" type="hidden" value="put"> 
				<input name="videoId" type="hidden" value="${video.id}">
				Quantity: <select name="stocknum" id="dropdown_menu_${video.stocknum}">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
				<input type="submit" value="Update">
			</form>
			
			<form method="post">
				<input name="_method" type="hidden" value="delete"> 
				<input name="videoId" type="hidden" value="${video.id}">
				<input type="submit" value="Delete">
			</form>

		</c:forEach>
		
		<h2>------------------------</h2>
		<form action="productcatalog.html">
			<input type="submit" value="Return to Store">
		</form>
	</div>
	
</body>
</html>