<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.entities.Flight"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	String noofpax= (String) request.getParameter("no_of_pax");
	session.setAttribute("noofpax", noofpax);
	%>
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
	<h2>
		<center>**********Flight Details**********</center>
	</h2>
	<form action="FlightDetails" method="POST">
		<% Flight f=(Flight)request.getAttribute("results");%>
		<c:set var="f" value="${results}" />
		<c:set var="price" value="${f.baseFare + f.surcharge}" />
		<c:set var="noofpax" value="${noofpax}" />

		
		<b>Flight Number: </b>${f.flightno } <br> <b>Carrier Name: </b>${f.carrierName}
		<br>
		__________________________________________________________________________________________________
		<br> <b>Origin City: </b>${f.origin} , ${f.departure} hrs <small>and
			will arrive at</small> <b>Destination City: </b>${f.destination},
		${f.arrival} <br> <b>Duration: </b>${f.duration} <br>

		__________________________________________________________________________________________________
		<br> <b>Checkin Baggage Limit: </b>${f.chkin_BgLimit} <br> <b>Cabin
			Baggage Limit: </b>${f.cabin_BgLimit} <br>

		__________________________________________________________________________________________________
		<br> <b>Base Fare: </b>${f.baseFare} INR <br> <b>Surcharge:
		</b>${f.surcharge} INR <br>
		__________________________________________________________________________________________________
		<br> <b>Price: </b>${price} INR<b> per person</b> <br> <b>No
			of Passengers</b> ${noofpax}

		<div style="color: white; margin-top: 10px; background-color: blue;">
			Total Price : ${price*noofpax} INR</div>

		<br> <br> 
		<span> 
		<a href="homepage.jsp"> Back to Flight Search</a> 
		</span>
		<div style="background-color:yellow" align="right">
		<a href="paxdetails.jsp">PROCEED </a>
		</div>
		<br>	
	<a href="logout.jsp"> Click here to logout</a>
		</body>
</html>