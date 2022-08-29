<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show all the People</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<h1>Person and licenses</h1>
	<table class="table table-secondary">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License Numbers</th>
				<th>Functions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allPerson}" var="person">
			<tr>
				<td><a href="/people/${person.id}"><c:out value="${person.firstName}"/></a></td>
				<td><c:out value="${person.lastName}"/></td>
				<c:choose>
				<c:when test="${person.license != null }">
				<td><c:out value="${person.license.getNumberAsString()}"/></td>
				</c:when>
				<c:otherwise>
				<td><a href="/license/new">Apply license</a></td>
				</c:otherwise>
				</c:choose>
				<td><a href="/delete/${person.id}">Delete</a> | <a href="/edit/${person.id}">Edit</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/person/new"  class="btn btn-success">Add People</a> 
</body>
</html>