	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add License</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
</head>
<body>
	<h2>New License</h2>
	<hr>
	<form:form method="POST" action="/newlicense"  modelAttribute="license">
    	<div class="form-group">
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select class="form-control" path="person">
        <c:forEach items="${person}" var="p">
        <form:option value="NONE" label="--- Select ---"/>
        <form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
		</c:forEach>
		</form:select>
		</div>
        <div class="form-group">
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input class="form-control" path="state"/>
        </div>
        <div class="form-group">
		<form:label path="expirationDate">Expiration Date</form:label>
		<form:errors path="expirationDate"/>
		<form:input type="date" class="form-control" path="expirationDate"/>
		</div>
		
    <button>Add License</button>
	</form:form>
</body>
</html>
