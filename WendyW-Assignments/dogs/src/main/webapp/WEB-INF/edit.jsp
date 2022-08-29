<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dog</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Edit ${dog.name}</h1>
<hr>
	<form:form method="POST" action="/edit/${dog.id}" modelAttribute="dog">
	<p>
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</p>
	
	<p>
	<form:label path="breed">Breed:
	<form:errors path="breed"/>
	<form:input path="breed"/></form:label>
	</p>
	<p>
	<form:label path="age">Age
	<form:errors path="age"/>
	<form:input path="age"/></form:label>
	</p>
	<button>Add Pup</button>
</form:form>
</div>
</body>
</html>