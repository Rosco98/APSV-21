<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<title>Bienvenido!</title>
</head>
<body>
	<h2>HOLA</h2>

	<% int i = 0; %>

	<!-- Al hacer la tabla de productos, recordar usar funciones iterator, no array -->

	<h2>Tabla de productos</h2>
	<form action="ProductsListServlet" method="get">
		<table border="1">
			<c:forEach items="${arrayListProducts}" var="arrayListProductsi">
				<tr>
					<td>${arrayListProductsi.name}</td>
				</tr>
			</c:forEach>
		</table>
	</form>


</body>
</html>