<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Bienvenido ${tfg.name}</h2>
	
	<c:if test="${tfg.status > 2}">
		<h2>TFG propuesto: "${tfg.title}"</h2>
		<form action="Form4TFGServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="tfgemail" value="${tfg.email}" /> 
			<input type="file" name="file" />
			<button type="submit">Subir memoria</button>
		</form>
	</c:if>

	
	<c:if test="${tfg.status > 3}">
			<b>Memoria: </b>
		<form action="ServeFileServlet" method="get">
			<input type="hidden" name="tfgemail" value="${tfg.email}" />
			<button type="submit">Descargar</button>
		</form>
	</c:if>
	
	
	<h2>Salir de la aplicación</h2>
	<%@ include file="FormLogout.jsp"%>

</body>
</html>