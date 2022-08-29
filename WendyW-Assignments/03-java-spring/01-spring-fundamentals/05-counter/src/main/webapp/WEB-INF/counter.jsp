<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="visit">
		<fieldset>
			<legend>Times Visited</legend> 
			<p>You visited this site ${count} times.</p>
			<a href="/your_server">Go Back</a>
		</fieldset>
	</div>
	<a href="/your_server/clear">Clear</a>   <a href="/your_server/counter">add visits</a>
</body>
</html>