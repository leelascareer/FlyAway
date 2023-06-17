<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.flyaway.util.PaxUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
************ CONGRATULATIONS *************************
<br>
Your tickets are booked. Here are your travel details
<br>
	<table border=1 style="margin-top:15px">
	<thead>
		<tr>
			<th>PNR</th>
			<th>Passenger Name</th>
		</tr>
	</thead>
	<tbody>
			
		<c:forEach items="${travelDetails}" var="td">
			<tr>
				<td>${td.getPNR()}  </td>
				<td>${td.getFirstname()} ${td.getLastname()}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>

	<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>