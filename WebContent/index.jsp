<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Bienvenido!</title>
</head>
<body>
	<h2>Gatashop</h2>
	
	<form action="ProductListServlet" method="get">
		<button type="submit">Products</button>
	</form>
	
	<h2>Log in/Sign in</h2>
	<%@ include file="FormLogin.jsp"%>
	
	<h2>Supplier</h2>
	<a href="Supplier.jsp">Supplier</a>

	<h2>Shipper</h2>
	<a href="Shipper.jsp">Shipper</a>
	
	
	<h2>Tabla de productos</h2>
	<form action="ProductListServlet" method="get">
		<table border="1">
			<c:forEach items="${listProducts}" var="listProductsi">
				<tr>
					<td>${listProductsi.name}</td>
				</tr>
			</c:forEach>
		</table>
	</form>


</body>
</html>