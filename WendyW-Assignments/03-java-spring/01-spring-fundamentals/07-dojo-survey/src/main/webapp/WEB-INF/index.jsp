<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
</head>
<body>
	<div class="survey">
	<form action="/result" method="POST">
		<p>Your Name: <input type="text" name="name"></p><br>
		<p>Dojo Location:
			<select name ="location">
	        <option value="San Jose, CA">San Jose, CA</option>
	        <option value="Arlington, VA">Arlington, VA</option>
	        <option value="Bellevue, WA">Bellevue, WA</option>
	        <option value="Boise, ID">Boise, ID</option>
	        <option value="Chicago, IL">Chicago, IL</option>
	        <option value="Dallas, TX">Dallas, TX</option>
	        <option value="Los Angeles, CA">Los Angeles, CA</option>
	        <option value="Oakland, CA">Oakland, CA</option>
	        <option value="Tulsa, OK">Tulsa, OK</option>
	        <option value="Online">Online</option>
	       	</select></p><br>
		<div id="lang">
	    <p>Favorite Language: 
	   		<select name="language">
	        <option value="Java">Java</option>
	        <option value="Python">PYthon</option>
	        <option value="HTML">HTML</option>
	        <option value="CSS">CSS</option>
	        <option value="Javascript">JavaScript</option>
	        <option value="MERN">MERN</option>
	        <option value="MEAN">MEAN</option>
			</select></p><br>
		</div>
		<label>Comment (optional):</label><br>
		<textarea rows="8" cols="40" type="text" name="comment"></textarea><br>
		<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>