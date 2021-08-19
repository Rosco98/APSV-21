<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>Product List</h1>
	
	<c:if test="${client != null}">
		<h2><a href="LoggedClient.jsp">${client.user} </a></h2>
	</c:if>
	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Unit</th>
			<th>Price</th>
			<th>URL</th>
		</tr>
		<c:forEach items="${listProducts}" var="listProductsi">
			<c:if test="${listProductsi.available}">
				<tr>
					<td>${listProductsi.name}</td>
					<td>${listProductsi.unit}</td>
					<td> <fmt:formatNumber type="number" minFractionDigits="2" value="${listProductsi.price}"/> &euro;</td>
				
					<td>
						<form action="ProductServlet" method="get">
							<input type="submit" id="productID" name="productID" value="${listProductsi.id}">
						</form>
						<a href="<%= request.getContextPath() + "/ProductServlet?productID="%>${listProductsi.id}">${listProductsi.id}</a> 
					
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<p></p>
	<!-- Log in -->
	<c:if test="${null == client}">
		<%@ include file="FormLogin.jsp"%>
	</c:if>
	<!-- Log out -->
	<c:if test="${(client != null) || (supplier != null) || (shipper != null)}">
		<%@ include file="FormLogout.jsp"%>
	</c:if>
		
</body>
</html>