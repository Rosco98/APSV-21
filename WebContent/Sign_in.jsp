<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
</head>
<body>
	<h1>Sign in</h1>

	<p>${message}</p>
	
		<c:if test="${type == 'client'}">
		<h2>I'm a client</h2>
		<form action="RegisterServlet" method="post">
			<input type="email" name="email" placeholder="Email"> 
			<input type="text" name="user" placeholder="User"> 
			<input type="text" name="city" placeholder="City"> 
			<input type="text" name="address" placeholder="Address"> 
			<input type="text" name="country" placeholder="Country"> 
			<input type="text" name="postalCode" placeholder="PostalCode"> 
			<input type="password" name="password" placeholder="Password">
			<input type="hidden" name="type" value="${type}">
			<button type="submit">Register</button>
		</form>
	</c:if>

	<c:if test="${type == 'supplier'}">
		<h2>I'm a supplier</h2>
		<form action="RegisterServlet" method="post">
			<input type="email" name="email" placeholder="Email"> 
			<input type="tel" name="phone" placeholder="Phone"> 
			<input type="text" name="name" placeholder="Name"> 
			<input type="text" name="city" placeholder="City"> 
			<input type="text" name="address" placeholder="Address"> 
			<input type="text" name="country" placeholder="Country"> 
			<input type="text" name="postalCode" placeholder="PostalCode"> 
			<input type="text" name="contactName" placeholder="Contact Name"> 
			<input type="password" name="password" placeholder="Password">
			<input type="hidden" name="type" value="${type}">
			<button type="submit">Register</button>
		</form>
	</c:if>

	<c:if test="${type == 'shipper'}">
		<h2>I'm a shipper</h2>
		<form action="RegisterServlet" method="post">
			<input type="email" name="email" placeholder="Email"> 
			<input type="tel" name="phone" placeholder="Phone"> 
			<input type="text" name="contactName" placeholder="Contact Name"> 
			<input type="text" name="name" placeholder="Enterprise"> 
			<input type="password" name="password" placeholder="Password">
			<input type="hidden" name="type" value="${type}">
			<button type="submit">Register</button>
		</form>
	</c:if>
	


</body>
</html>