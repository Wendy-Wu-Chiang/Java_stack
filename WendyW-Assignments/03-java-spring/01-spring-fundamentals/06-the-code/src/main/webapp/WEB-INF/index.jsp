<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="UTF-8">
<title>The Secrete Code</title>
</head>
<body>
	<div class="guess">
		<h4><c:out value="${errors}"/></h4>
		<h1>What is the CODE?</h1>
		<form action="/code" method="POST">
			<input type="text" name="guess">
			<br>
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>