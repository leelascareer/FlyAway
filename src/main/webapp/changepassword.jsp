<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ChangePassword" method="POST">  
<%
	String username = (String) session.getAttribute("username");
	%>
	
	<b>Logged in User: <%= username%></b>
	<br>
	<br>
	
Old Password:<span class="required-field" style="color:red">*</span> 
<input type="password" name="oldpassword" required="true"/><br/><br/>  

New Password:<span class="required-field" style="color:red">*</span> 
<input type="password" name="newpassword" required="true"/><br/><br/> 
 
Confirm New Password:<span class="required-field" style="color:red">*</span> 
<input type="password" name="c_newpassword" required="true"/><br/><br/>  

<input type="submit" value="Update and Logout"/>  
</form>
</body>
</html>