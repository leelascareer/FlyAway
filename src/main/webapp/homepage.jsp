<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<h1>
		<center>*******FLYAWAY******</center>
	</h1>
		
	<%
	String username= (String)session.getAttribute("username");
	%>
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
	<%
	if (username.equals("admin")) {
	%> <div style="margin-bottom:15px">
	<form action="changepassword.jsp">
	<input type="submit" value="Change Password" />
	</form>
	</div>
	<%
	}
	%>
<center> ************* Enter Your Search Criteria *************</center>
<br>
	<form action=FlightSearch>
		<div>
			<div>
				<label for="origin">Origin</label> 
				<select name="origin" id="origin" required="true">
					<option value="Hyderabad">Hyderabad</option>
					<option value="Indore">Indore</option>
					<option value="Kochi">Kochi</option>
					<option value="Mumbai">Mumbai</option>
					<option value="New Delhi">New Delhi</option>
				</select>
			</div>
			<br>
			<div>
				<label for="destination">Destination</label> <select
					name="destination" id="destination">
					<option value="Hyderabad">Hyderabad</option>
					<option value="Indore">Indore</option>
					<option value="Kochi">Kochi</option>
					<option value="Mumbai">Mumbai</option>
					<option value="New Delhi">New Delhi</option>
				</select>
			</div>
			<br>
			

			<div>
				<label for="no_of_pax">Passengers</label> <select name="no_of_pax"
					id="no_of_pax">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
			</div>
			<br>
			<div>
				<label for="departure">Departure Date</label><span class="required-field" style="color:red">*</span>  <input type="date"
					id="departure_dt" name="departure_dt" required="true">
			</div>
			<br>
			<div>
				<input type="submit" id="submit" name="submit"> 
			</div>
		</div>
		<br>
		</form>
		<jsp:include page="footer.jsp" />	
	
</body>
</html>
