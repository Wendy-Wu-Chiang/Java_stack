<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="showTime">
		<fieldset>
		<legend>Current Time</legend>
		<c:set var = "now" value = "${time}" />
		<h2 id="time"><fmt:formatDate pattern = "hh:mm a" value = "${now}" /></h2>  <!-- format time as 11:30 PM -->
		<a href="/">Home Page</a>
		</fieldset>
	</div>
<script type="text/javascript" src="js/time.js"></script>
</body>
</html>