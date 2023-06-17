<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payments Page</title>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	%>
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
	<form action="ConfirmationPage" method="post">
		<center>
			<div style="margin-top: 130px">
				*****************CHOOSE PAYMENT METHOD***************** <br> <br>
				<br> <input type="submit" value="PAY NOW" name="paynow" />
			</div>
		</center>
	</form>
	<span> <a href="homepage.jsp"> Back to Flight Search</a>
	</span>
	<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>