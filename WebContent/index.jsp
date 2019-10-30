<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Welcome</title>
</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron" style="color: orange">
			<h1 class="display-4">Welcome To the Library</h1>
			<hr class="my-4">
			<a class="btn btn-primary " href="add.jsp">Add Book</a> <a
				class="btn btn-primary " href="add.do">View Books</a>
		</div>

		<c:if test="${created eq true }">
			<p style="color: red">Book Added Successfully...</p>
		</c:if>
		<c:if test="${created eq false }">
			<p style="color: red">Book could not be added successfully...</p>
		</c:if>
		
		<c:if test="${rev eq true}">
			<p style="color: red">Review Added Successfully...</p>
		</c:if>
		<c:if test="${rev eq false}">
			<p style="color: red">Review could not be added successfully...</p>
		</c:if>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>