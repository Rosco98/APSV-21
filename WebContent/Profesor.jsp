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
	<h2>Bienvenido ${profesor.name}</h2>



	<h2>TFGs propuestos</h2>
	<table border="1">
		<c:forEach items="${profesor.advisedTFGs}" var="advisedTFGsi">
			<tr>
				<td>${advisedTFGsi.title}</td>
				<td>${advisedTFGsi.email}</td>
				<c:if test="${advisedTFGsi.status == 1}">
					<td>
						<form action="Form2ProfesorServlet">
							<input type="hidden" name="tfgemail"
								value="${advisedTFGsi.email}" /> <input type="hidden"
								name="profesor" value="${profesor.email}" />
							<button type="submit">Aceptar Tutela</button>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	
	<h2>Salir de la aplicación</h2>
	<%@ include file="FormLogout.jsp"%>

</body>
</html>
