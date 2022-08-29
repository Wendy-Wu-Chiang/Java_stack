<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Show Book Page</title>
</head>
<body>
	<div id="new">
	
	<h1><c:out value="${book.title}"/></h1>
	
	<p>Description: <c:out value="${book.description}"/></p>
	
	<p>Language: <c:out value="${book.language}"/></p>
	
	<p>Number of Pages: <c:out value="${book.numberOfPages}"/></p>
	
	<a href="/books/edit/${book.id}">Edit Book</a>
	
	<form action="/delete/${book.id}" method="POST">
	
		<input type="hidden" name="_method" value="delete">
		
		<input type="submit" value="Delete">
		
	</form>
	</div>
</body>
</html>