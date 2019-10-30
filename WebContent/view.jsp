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
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="radio" value="${radio}">
	<div class="container">
		<div style="margin-top: 10pt">
			<form class="form-row" action="add.do" method="get">&nbsp;
				<input class="form-control col-md-5" type="search" name="srch">&nbsp;
				<input type="submit" class="btn btn-primary" value="Search">&nbsp;<a class="btn btn-primary" href="add.do?srch=r">Reset</a>
			</form>
		</div>
		<div style="margin-top: 10pt">
			<table class="table table-striped">
				<thead class="thead thead-dark">
					<th>Book Title</th>
					<th>Author Name</th>
					<th>Price</th>
					<th>Add/View Reviews</th>
				</thead>
				<tbody>
					<c:forEach var="zip" items="${books}">
						<tr>
							<td>${zip.title}</td>
							<td>${zip.author}</td>
							<td>${zip.price}</td>
							<td><a class="btn btn-primary" href="review?id=${zip.id}">Add
									Review</a> <a class="btn btn-primary" href="vreview?id=${zip.id }">View
									Reviews</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>

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