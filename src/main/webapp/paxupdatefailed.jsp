<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details Failed</title>
</head>
<body>
<%
	String username = (String) session.getAttribute("username");
	%>
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
<h1 style="color:red">Oops! Something went wrong</h1>
Please try again after sometime or contact our support center for help <b><h3>+91-99090 99090</h3></b>
<a href="homepage.jsp">Back to flight search page</a>
<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>