<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Books</h1>
<table class="table table-secondary">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allBooks}" var="book" varStatus="loop">
		<tr>    
    		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
    		<td><c:out value="${book.description}"/></td>
    		<td><c:out value="${book.language}"/></td>
    		<td><c:out value="${book.numberOfPages}"/></td>
    		<td><a href="books/delete/${book.id}">Delete</a></td>
		</tr>
		</c:forEach>
    </tbody>
</table>
<a href="/books/add" class="btn btn-secondary">New Book</a>
</body>
</html>
