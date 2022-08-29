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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
	<h1>Welcome, <c:out value="${user.name}"/>!</h1>
	<div class="top">
	<h3>Ideas</h3>   <h4>Low Likes</h4>        <h4>High Likes</h4>
	</div>
	<hr>
	<table class="table table-dark">
   		<thead>
       		<tr>
            	<th>Ideas</th>
            	<th>Created By:</th>
            	<th>Liked</th>
            	<th>Action</th>
        	</tr>
        	
    	</thead>
    	
    	<c:forEach items="${allIdeas}" var="idea">
    	
    <tbody>
		<tr>    
    		<td><a href="/ideas/${idea.id}"><c:out value="${idea.content}"/></a></td>
    		
    		<td><c:out value="${user.name}"/></td>
    		
    		<td><c:out value="${idea.likedUser.size()}"/></td>
    		
    		<td>
    		<c:choose>
 				<c:when test="${idea.likedUser.contains(user)}">
 				<a href="/unlike/${idea.id }">Unlike</a>
 				</c:when>
 				<c:otherwise>
 				<a href="/like/${idea.id}">Like</a>
 				</c:otherwise>
 			</c:choose>
 		</c:forEach>
		</tr>
    </tbody>
	</div>
	<a href="/ideas/new">Create an Idea</a> | <a href="/logout">Logout</a>   
</body>
</html>