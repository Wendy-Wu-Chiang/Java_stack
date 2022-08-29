<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter_two</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="revisit">
		<fieldset>
		<legend>Times Visited</legend>
		<p>You visited this site ${countTwo} times.</p>
		<a href="/your_server">Go Back</a> 
	</fieldset>
</div>
<a href="/your_server/clear_two">Clear</a>   <a href="/your_server/counter_two">add visits</a>
</body>
</html>