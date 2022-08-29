<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Add a Ninja</title>
</head>
<body>
<div class="ninja">

		<h1>New Ninja</h1><br>
		<h3>Please select your Dojo then enter Ninja's information</h3><br>
		
		<form:form method="POST" action="/add/ninja" modelAttribute="ninja">
		
			
		<div class="form-group">
  
	    	<p>Select a Dojo:  <form:select path="dojo">
				<c:forEach items="${allDojos}" var="dojo">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select></p>
	    </div>
	
		<div class="form-group row">
			<form:label path="firstName">First Name:
			<form:input class="form-control" path="firstName" value="${ninja.firstName}"/></form:label>
		</div>
		
		<div class="form-group row">
			<form:label path="lastName">Last Name:
			<form:input class="form-control" path="lastName" value="${ninja.lastName}"/></form:label>
		</div>
		
		<div class="form-group row">
			<form:label path="age">Age:
			<form:input class="form-control" path="age" value="${ninja.age}"/></form:label>
		</div>
		<button type="submit" class="btn btn-outline-success">Create Ninja</button>
		</form:form>
	</div>
</body>
</html>