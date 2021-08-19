<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${(client != null)}">
		<c:redirect url="LoggedClient.jsp"></c:redirect>
	</c:if>
	<c:if test="${supplier != null}">
		<c:redirect url="LoggedSupplier.jsp"></c:redirect>
	</c:if>
	<c:if test="${shipper != null}">
		<c:redirect url="LoggedShipper.jsp"> </c:redirect>
	</c:if>
	
	
	<h1>Login</h1>
	<p>${message}</p>

	<form action="LoginServlet" method="post">
		<input type="text" name="email" placeholder="Email">
		<input type="password" name="password" placeholder="Password">
		<input type="submit" value="Log in">
	</form>

	<c:set var="type" value="client" scope="session" />

<a href="Sign_in.jsp">No account yet? Sign in</a>
</body>
</html>