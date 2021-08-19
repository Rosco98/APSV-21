<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome Client: ${client.user}</h1>

	<p>User: ${client.user}</p>
	<p>Email: ${client.email}</p>
	<p>Cart: </p>
	<c:forEach items="${client.cart}" var="ProductCarti">
		<p>&nbsp;&nbsp;${ProductCarti.name}</p>
	</c:forEach>
	
	<p>Order: </p>
	<c:forEach items="${client.orders}" var="Orderi">
		<p>&nbsp;&nbsp;${Orderi.id}</p>
	</c:forEach>

	<p>Products</p>
	
	<form action="ProductListServlet" method="get">
		<button type="submit">Products</button>
	</form>


	<!-- Log out -->
	<%@ include file="FormLogout.jsp"%>

</body>
</html>