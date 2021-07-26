<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

<form action="LoginServlet" action="post">
	<input type="text" name="email" placeholder="Email">
	<input type="password" name="password" placeholder="Password">
</form>

<a href="Sign_in.jsp">No account yet? Sign in</a>
</body>
</html>