<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.flyaway.entities.Flight"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
	%>
<b>Logged in User: <%= username%></b>
	<br>
	<br>
	<h2> <center>***** SEARCH RESULTS *****</center></h2>

	<table border=1 style="margin-top:15px">
	<thead>
		<tr>
			<th>Flight Number</th>
			<th>Carrier</th>
			<th>Origin</th>
			<th>Departure</th>
			<th>Destination</th>
			<th>Arrival</th>
			<th>Duration</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
		<% List<Flight> fs=(ArrayList<Flight>)request.getAttribute("results");
		if(fs.size()==0){%>
			<text style="color:red">No results found for the search critera.
			Please <a href="homepage.jsp"> change</a> dates or location and try again</text>

		<% } 
		%>
		<% String no_of_pax=(String)request.getAttribute("noOfPax");%>
		<% String fromDate =(String)request.getAttribute("fromDate");%>
		
		<c:forEach items="${results}" var="f">
			<c:set var="price" value="${f.baseFare + f.surcharge}" />
			<c:set var="pax" value="${no_of_pax}" />
			<c:set var="fromDate" value="${fromDate}" />
			<c:set var="fl_no" value="${f.flightno}" />
			<c:set var="fl_no" value="${fn:replace(fl_no, \" \", \"\")}" />

			<tr>
				<td>${f.flightno}</td>
				<td>${f.carrierName}</td>
				<td>${f.origin}</td>
				<td>${f.departure}</td>
				<td>${f.destination}</td>
				<td>${f.arrival}</td>
				<td>${f.duration}</td>
				<td>${price}</td>
				<td>

					<form method="GET" action="FlightDetails">
						<a
							href="FlightDetails?flightno=${fl_no}&no_of_pax=${pax}&fromDate=${fromDate}">PROCEED
						</a>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="homepage.jsp"> Back to Flight Search</a>
</form>
<br>	
	<a href="logout.jsp"> Click here to logout</a>
</body>
</html>