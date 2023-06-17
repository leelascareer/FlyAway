<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> <center>LOGIN TO FLYAWAY</center></h1>
<%
	String username = (String) session.getAttribute("username");
	%>
<form action="Login" method="POST">  
UserName:<span class="required-field" style="color:red">*</span> 
<input type="text" name="username" required="true"/><br/><br/>  
Password:<span class="required-field" style="color:red">*</span> 
<input type="password" name="password" required="true"/><br/><br/>  
<input type="submit" value="Login"/>  
</form>
</body>
</html>