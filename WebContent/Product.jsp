<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>

	<script>
		function confirmation() {
			String message = (String) request.getSession().getAttribute("message");
			if (message != null){
				confirm(message);
			}else {
				confirm("No hubo suerte");
			}
			request.getSession().removeAttribute("message");			
		}
	</script>
	
	<h1>Web del Producto ${product.name}</h1>
	
	<c:if test="${client != null}">
		<h2><a href="LoggedClient.jsp">${client.user} </a></h2>
	</c:if>
	
	<c:set var="imageLink" value="Images\\${product.name.toLowerCase()}.jpg" scope="page" />
	<img alt="${product.name} photo not available" src="${imageLink}">
	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Unit</th>
			<th>Price</th>
		</tr>
		<tr>
			<td>${product.name}</td>
			<td>${product.unit}</td>

			<td><fmt:formatNumber type="number" minFractionDigits="2" value="${product.price}" /> &euro;</td>
			
		</tr>
	</table>

	<p></p>

	<c:if test="${client != null}">
		<a href="\Buy.jsp">Buy</a>
		<form action="CartServlet" method="get">
			<input type="submit" value="Add to cart">
		</form>
	</c:if>
	<p></p>
	
	<!-- Log in -->
	<c:if test="${client == null}">
		<a href="Login.jsp">Buy</a>
	</c:if>
	<!-- Log out -->
	<c:if test="${(client != null) || (supplier != null) || (shipper != null)}">
		<%@ include file="FormLogout.jsp"%>
	</c:if>

</body>
</html>