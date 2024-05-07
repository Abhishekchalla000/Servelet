<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Registration page</h3>
	<form action = "registrationservlet"  method = "post">
		<table>
		<tr><td><label>Email : </label></td><td><input type = "Email" name = "gmail"></td></tr> 
		<tr><td><label>First name : </label></td><td><input type = "text" name = "fname"></td></tr>
		<tr><td><label>Last name : </label></td><td><input type = "text" name = "lname"></td></tr>
		<tr><td><label>Phone number : </label></td><td><input type = "tel" name = "phone"></td></tr>
		<tr><td><label>Date of Birth </label></td><td><input type = "Date" name = "date"></td></tr>
		<tr><td><label>Address : </label></td><td><textarea name = "text" rows = " 4" cols = " 40"></textarea></td></tr>
		<tr><td><label>password : </label></td><td><input type = "password" name = "password"></td></tr>
		</td><td><input type = "submit" value = "Register"></td></tr>
		</table>
	</form>

</body>
</html>