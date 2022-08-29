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
<title>Register Dojo</title>
</head>
<body>
	<div class="dojo">
		<h1>Add Dojo</h1>
		
			<c:forEach items="${errors}" var="err">
			<h4>${err}</h4>
			</c:forEach>
		
		<form:form method="POST" action="/create/dojo" modelAttribute="dojo">
		
	<div class="form-group row">
		
		<form:label path="name">Dojo Name:
			
		<form:errors path="name"/>
			
		<form:input class="form-control" path="name" value="${dojo.name}"/></form:label>
			
	</div>
		
		<button type="submit" class="btn btn-outline-success">Create Dojo</button>
		
		</form:form>
	</div>
</body>
</html>
