<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<h1>Products</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Unit</th>
			<th>Price</th>
			<th>URL</th>
		</tr>
		<c:forEach items="${listProducts}" var="listProductsi">
			<tr>
				<td>${listProductsi.name}</td>
				<td>${listProductsi.unit}</td>
				<td>${listProductsi.price}</td>
				<td>
					<form action="ProductServlet" method="get">
						<input type="submit" id="productID" name="productID" value="${listProductsi.id}">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>