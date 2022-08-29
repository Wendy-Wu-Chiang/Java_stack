<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Idea</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h3>Edit </h3>
<hr>
	<form:form method="POST" action="/ideas/${idea.id}/edit" modelAttribute="idea">
	<div class="form-group">
	<form:label path="content">Content:</form:label>
	<form:errors path="content"/>
	<form:input path="content"/>
	</div>
	<button type="submit" class="btn btn-outline-success">Update</button>
	<a href="/delete">Delete</a> 
</form:form>
</div>
</body>
</html>

