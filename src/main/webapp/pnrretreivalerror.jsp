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
<h1 style="color:green">Suceess! Your tickets have been booked</h1>
We will send your pnr details by sms soon!You can also contact our support center for details <b><h3>+91-99090 99090</h3></b>
<a href="homepage.jsp">Back to flight search page</a>
<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>