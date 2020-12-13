<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Crud</title>
</head>
<body>

	<h1>welcome home</h1>
	<form action="addEmployee">
		Enter id:<input type="text" name="eid"><br> Enter name:<input
			type="text" name="name"><br> <input type="submit">
	</form>
	<hr>
	<form action="getEmployeeById" method="get">
		Enter your id:<input type="text" name="eid"><br> <input
			type="submit">
	</form>
	<hr>
	<form action="getEmployeeByNameOrdered" method="get">
		Enter your Name ordered:<input type="text" name="name"><br> <input
			type="submit">
	</form>
	
		<hr>
	<form action="getEmployeeByNameQuery" method="get">
		Enter your Name with query:<input type="text" name="name"><br> <input
			type="submit">
	</form>
</body>
</html>