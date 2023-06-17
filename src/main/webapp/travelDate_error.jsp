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
	
<h1>Date of travel cannot be less than current date</h1>
<a href="homepage.jsp">Back to flight search page</a>
<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>