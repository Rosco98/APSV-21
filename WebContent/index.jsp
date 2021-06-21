<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

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
			<tr>
				<s:iterator value="iteratorProducts" >
					<td><s:property/></td>
				</s:iterator>
			</tr>
		</table>
	</form>


</body>
</html>