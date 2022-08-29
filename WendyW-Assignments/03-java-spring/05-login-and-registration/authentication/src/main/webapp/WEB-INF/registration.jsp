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
<title>Registration Page</title>
</head>
<body>

	<div class="register">

	<h1>Welcome to the registration page!</h1>
	
	<h3>Please fill in the form below, or login <a href="/login">here</a>.</h3>
	
	<p><form:errors path="user.*"/></p>
	
	<form:form method="POST" action="/registration" modelAttribute="user">
	
		<div class="form-group">	
		
			<form:label path="firstName">First Name:</form:label><br>
			
			
			<form:input class="form-control" type="text" path="firstName"/>
			
		</div>
		
		<div class="form-group">
		
			<form:label path="lastName">Last Name:</form:label><br>
			
			
			<form:input class="form-control" type="text" path="lastName"/>
				
		</div>
	
		<div class="form-group">
		
			<form:label path="email">Email: </form:label>
			
			<form:input class="form-control" type="email" path="email"/>
		
		</div>
		
		<div class="form-group">
			
			<form:label path="password">Password: </form:label>
			
			<form:password class="form-control" path="password"/>
			
		</div>
		
		<div class="form-group">
		
			<form:label path="passwordConfirmation">Password Confirmation: </form:label>
			
			<form:password class="form-control" path="passwordConfirmation"/>
		
		</div>
		
		<button class="btn btn-outline-success" type="submit">Register!</button>
		
	</form:form>
	
	</div>
</body>
</html>