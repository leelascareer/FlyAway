<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username = (String) session.getAttribute("username");
	%>
<b>Logged in User: <%= username%></b>
	<br>
	<br>
	
<h1>Something went wrong. Try again later</h1>
<a href="homepage.jsp">Back to Home</a>
<br>	
	<a href="logout.jsp"> Click here to logout</a>

</body>
</html>