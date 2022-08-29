<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Gift Pup a Toy</h1>

<form:form method="POST" action="/toys/newToy" modelAttribute="toy">
	<div class="form-group">
	<form:label path="dog">Select a Dog</form:label>
	<form:errors path="dog"/>
	<form:select path="dog">
	<c:forEach items="${allDogs }" var="dog">
	<option value="${dog.id}">${dog.name}</option>
	</c:forEach>
	</form:select>
	</div>

	<div class="form-group">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
    </div>
        <div class="form-group">
    <form:label path="color">Color
    <form:errors path="color"/>
    <form:input path="color"/></form:label>
    </div>
        <div class="form-group">
    <form:label path="hasSqueeker">Has Squeeker?</form:label>
    <form:errors path="hasSqueeker"/>
    <form:select path="hasSqueeker">
		<option value="true">True</option>
		<option value="false">False</option>	
	</form:select>
    </div>
            <div class="form-group">
    <form:label path="price">Price
    <form:errors path="price"/>
    <form:input path="price"/></form:label>
    </div>
    <button>Gift Toy!</button>
</form:form>

</div>
</body>
</html>
