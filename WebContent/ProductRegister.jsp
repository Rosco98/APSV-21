<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Register</title>
</head>
<body>
	<h1>Register your new product</h1>
	<form action="ProductRegisterServlet" method="post">
			<input type="text" name="name" placeholder="Name"> 
			<input type="text" name="unit" placeholder="Unit"> 
			<input type="number" name="price" placeholder="Price"> 
			
		
			<c:forEach items="${listCategories}" var="listCategoriesi">
				<input type="checkbox" name="${listCategoriesi.name}" value="${listCategoriesi.name}">
					<label for="${listCategoriesi.name}">${listCategoriesi.name}</label><br>
			</c:forEach>
			
			
		
			
			<p></p>
			<input type="radio" name="available" value="true">
  				<label for="available">Product available</label><br>
  			<input type="radio" name="available" value="false">
  				<label for="available">Product not available</label><br>
			
			
		<p></p>
		<button type="submit">Register</button>
		</form>
</body>
</html>