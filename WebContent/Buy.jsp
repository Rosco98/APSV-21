<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
</head>
<body>
	<h1>Buy the product ${product.name}</h1>
	
	<p> <fmt:formatNumber type="number" minFractionDigits="2" value="${product.price}" /> &euro; </p>
	
	<p></p>
	<p>Pagar con tarjeta</p>
	<p>Pagar con Paypal</p>
	
	<!-- Log out -->
	<c:if test="${null != client}">
		<%@ include file="FormLogout.jsp"%>
	</c:if>

</body>
</html>