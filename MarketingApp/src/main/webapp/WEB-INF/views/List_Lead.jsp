<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All List</title>
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<c:forEach var="value" items="${msg}">
			
			<tr>
				<td>${value.firstName}</td>
				<td>${value.lastName}</td>
				<td>${value.mobile}</td>
				<td>${value.email}</td>
				<td><a href="delete?id=${value.id}">delete</a></td>
				<td><a href="update?id=${value.id}">update</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>