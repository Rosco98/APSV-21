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
	<h2>Admin</h2>
	<p>
		<b>Número de trabajos activos: </b>${fn:length(tfgs)}</p>
	<p>
		<b>Número de profesores activos: </b>${fn:length(profesores)}</p>
	<h2>Profesores</h2>
	<table border="1">
		<c:forEach items="${profesores}" var="profesori">
			<tr>
				<td>${profesori.name}</td>
				<td>${profesori.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>TFGs</h2>
	<table border="1">
		<tr>
			<td>name</td>
			<td>email</td>
			<td>title</td>
			<td>status</td>
		</tr>
		<c:forEach items="${tfgs}" var="tfgi">
			<tr>
				<td>${tfgi.name}</td>
				<td>${tfgi.email}</td>
				<td>${tfgi.title}</td>
				<td>${tfgi.status}</td>
				<c:if test="${tfgi.status == 2}">
					<form action="Form3AdminServlet">
						<input type="hidden" name="tfgemail" value="${tfgi.email}" />
						<button type="submit">Aceptar Trabajo Fin de Grado
							${tfgi.email}</button>
					</form>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<h2>Registrar un nuevo profesor</h2>
	<%@ include file="FormCreaProfesor.jsp"%>
	
	<h2>Salir de la aplicación</h2>
	<%@ include file="FormLogout.jsp"%>
	
</body>
</html>
