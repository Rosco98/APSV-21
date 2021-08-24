<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin</h2>
	<p> <b>Number of products: </b>${fn:length(products)}</p>
	<p> <b>&nbsp Available: </b>${fn:length(availableProducts)}</p>
	<p> <b>Number of clients: </b>${fn:length(clients)}</p>
	<p> <b>Number of suppliers: </b>${fn:length(suppliers)}</p>
	<p> <b>Number of shippers: </b>${fn:length(shippers)}</p>
	<p> <b>Number of OrderDetails: </b>${fn:length(orderDetails)}</p>
	
	<!-- Products Table -->
	<h3>Products</h3>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Unit</th>
			<th>Price</th>
			<th>URL</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${products}" var="productsi">
			<tr>
				<td>${productsi.name}</td>
				<td>${productsi.unit}</td>
				<td> <fmt:formatNumber type="number" minFractionDigits="2" value="${productsi.price}"/> &euro;</td>
				
				<td>
					<form action="ProductServlet" method="get">
						<input type="submit" id="productID" name="productID" value="${productsi.id}">
					</form>
					<a href="<%= request.getContextPath() + "/ProductServlet?productID="%>${productsi.id}">${productsi.id}</a> 
				</td>
				
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="productID" name="productID" value="${productsi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>
	
	<!-- Suppliers Table -->
	<h3>Suppliers</h3>	
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Contact Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Country</th>
			<th>City</th>
			<th>Address</th>
			<th>Postal Code</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${suppliers}" var="suppliersi">
			<tr>
				<td>${suppliersi.name}</td>
				<td>${suppliersi.contactName}</td>
				<td>${suppliersi.email}</td>
				<td>${suppliersi.phone}</td>
				<td>${suppliersi.country}</td>
				<td>${suppliersi.city}</td>
				<td>${suppliersi.address}</td>
				<td>${suppliersi.postalCode}</td>
			
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="supplierID" name="supplierID" value="${suppliersi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>
	
	<!-- Shippers Table -->
	<h3>Shippers</h3>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Contact Name</th>
			<th>Email</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${shippers}" var="shippersi">
			<tr>
				<td>${shippersi.name}</td>
				<td>${shippersi.phone}</td>
				<td>${shippersi.email}</td>
			
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="shipperID" name="shipperID" value="${shippersi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>
	
	<!-- Clients Table -->
	<h3>Clients</h3>
	<table border="1">
		<tr>
			<th>User</th>
			<th>Email</th>
			<th>Country</th>
			<th>City</th>
			<th>Address</th>
			<th>Postal Code</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${clients}" var="clientsi">
			<tr>
				<td>${clientsi.user}</td>
				<td>${clientsi.email}</td>
				<td>${clientsi.country}</td>
				<td>${clientsi.city}</td>
				<td>${clientsi.address}</td>
				<td>${clientsi.postalCode}</td>
			
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="clientID" name="clientID" value="${clientsi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>
	
	
	
	<!-- Orders Table -->
	<h3>Orders</h3>
	<table border="1">
		<tr>
			<th>orderDate</th>
			<th>Client</th>
			<th>Shipper</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${orders}" var="ordersi">
			<tr>
				<td>${ordersi.orderDate.getTime()}</td>
				<td>${ordersi.client.user}</td>
				<td>${ordersi.shipper.name}</td>
				
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="orderID" name="orderID" value="${ordersi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>

	<!-- OrderDetails Table -->
	<h3>Order Details</h3>
	<table border="1">
		<tr>
			<th>Product</th>
			<th>Quantity</th>
			<th>Order</th>
			<th>Remove</th>
		</tr>
		<c:forEach items="${orderDetails}" var="orderDetailsi">
			<tr>
				<td>${orderDetailsi.product.name}</td>
				<td>${orderDetailsi.quantity}</td>
				<td>${orderDetailsi.order.id}</td>
				
				<td> 	<form action="RemoveServlet" method="get">
							<input type="submit" id="orderDetailID" name="orderDetailID" value="${orderDetailsi.id}">
						</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>

	
	<!-- Categories Table -->
	<h3>Categories</h3>
	<table border="1">
		<tr>
			<th>Description</th>
			<th>Name</th>
			<th>Number products</th>
			<th>Remove</th>
		</tr>
		
		<c:set var="index" value="${0}" scope="page" />
		<c:forEach items="${categories}" var="categoriesi">
			<tr>
				<td>${categoriesi.description}</td>
				<td>${categoriesi.name}</td>
				
				<c:set var="count" value="${count_CategoriesID.get(\"count\")}" scope="page" />
				<c:set var="categoriesID" value="${count_CategoriesID.get(\"categoriesID\")}" scope="page" />

				<!-- Look if the number of categoriesID=0 (not products tagged with this category -->
				<!-- and if is full the table with 0's, if not, it finds with are the one's not used -->
				<!-- and full the table with 0's if is the case -->
				<c:choose>
					<c:when test="${categoriesID.isEmpty()}">
						<td>0</td>
					</c:when>
					<c:otherwise>
						<c:forEach items="${categoriesID}" var="categoriesIDi">
							<c:choose>
								<c:when test="${categoriesi.id==categoriesIDi}">
									<td>${count.get(index)}</td>
								</c:when>
								<c:otherwise>
									<td>0</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>



				<td>	<form action="RemoveServlet" method="get">
							<input type="submit" id="categoryID" name="categoryID" value="${categoriesi.id}">
						</form>
				</td>
				
				<c:set var="index" value="${index+1}" scope="page" />
			</tr>
		</c:forEach>
	</table>
	<p></p>
	<p></p>


	<!-- Log out -->
	<%@ include file="FormLogout.jsp"%>
	
	
</body>
</html>
