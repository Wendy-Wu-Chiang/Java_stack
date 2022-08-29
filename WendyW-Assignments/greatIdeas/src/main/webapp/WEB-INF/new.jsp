<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an new idea</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

<h2>Create an new idea</h2>
	<hr>
	<div class="new">
	<form:form method="POST" action="/ideas/newIdea" modelAttribute="idea">
	<div class="form-group">
	<form:hidden path="user" value="${user.id}"/>
	<form:label path="content">Content:</form:label>
	<form:errors path="content"/>
	<form:input path="content"/>
	</div>
	<button type="submit" class="btn btn-outline-success">Create</button>
	</form:form>
</div>
</body>
</html>