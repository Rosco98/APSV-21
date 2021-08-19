<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Bienvenido!</title>
</head>
<body>
	
	<p>Description to be one of our shippers</p>
	
		<h2>Sign in</h2>
	<a href="Sign_in.jsp">No account yet? Sign in</a>
	<c:set var="type" value="shipper" scope="session" />
	
</body>
</html>