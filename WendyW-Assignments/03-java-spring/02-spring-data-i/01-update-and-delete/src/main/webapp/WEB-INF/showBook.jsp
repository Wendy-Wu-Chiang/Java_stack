<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Show Book</title>
</head>
<body>
	<div id="edit">
	<h1><c:out value="${book.title}" /></h1>
	
	<p>Language: <c:out value="${book.language}" /></p>
	<p>Number of pages: <c:out value="${book.numberOfPages}" /></p>
	<p>Description: <c:out value="${book.description}" /></p>
	
	<a href="/books">Back to Catalog</a>
	</div>
<hr><hr>	

<h3>Edit Book</h3>
<form:form method="POST" action="/books/update/${book.id}" modelAttribute="book">
<div class="form-group">
	<form:label path="title">Title:
	<form:errors path="title"/>
	<form:input path="title"/></form:label>
</div>
<div class="form-group">
	<form:label path="language">Language:
	<form:errors path="language"/>
	<form:input path="language"/></form:label>
</div>
<div class="form-group">
	<form:label path="numberOfPages">Number Of Pages:
	<form:errors path="numberOfPages"/>
	<form:input path="numberOfPages"/></form:label>
</div>
<div class="form-group">
	<form:label path="description">Description:</form:label><br>
	<form:errors path="description"/>
	<form:textarea rows="3" cols="70" path="description"/>
</div>
<button class="btn btn-secondary">Save Changes</button>
</form:form><br>

<a href="/books/delete/${book.id}" class="btn btn-dark">Delete This Book</a><br><br>

<a href="/books">Back to Catalog</a>

</body>
</html>