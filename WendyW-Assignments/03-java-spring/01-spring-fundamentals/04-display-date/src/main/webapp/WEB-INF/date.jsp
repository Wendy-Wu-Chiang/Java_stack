<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="showDate">
		<fieldset>
		<legend>Today's Date</legend>
		<c:set var = "now" value = "${date}" />
		<h3 id="date"><fmt:formatDate pattern = "EEEE, dd MMMM, yyyy"  value = "${now}"/></h3> <!-- format date as Saturday, the 22 of January, 2028 -->
		
		<a href="/">Home Page</a>
		</fieldset>
	</div>
<script type="text/javascript" src="js/date.js"></script>
</body>
</html>