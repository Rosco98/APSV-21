<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome Supplier: ${supplier.name}</h1>

	<p>User: ${supplier.name}</p>
	<p>Email: ${supplier.email}</p>

	<form action="CategoriesServlet" method="post">
			<input type="submit" value="Add product">
	</form> 
	
	<!-- Log out -->
	<%@ include file="FormLogout.jsp"%>
	
</body>
</html>