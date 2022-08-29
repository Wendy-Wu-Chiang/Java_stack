<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Java!</title>
</head>
<body>
<div class="java">
<fieldset>
<legend>Java</legend>
<h1>Awesome! We love <span>Java</span> too!</h1>
</fieldset>
<p>Comment: <c:out value="${comment}"/></p>
<button><a href="/">Back</a></button>
</div>
</body>
</html>