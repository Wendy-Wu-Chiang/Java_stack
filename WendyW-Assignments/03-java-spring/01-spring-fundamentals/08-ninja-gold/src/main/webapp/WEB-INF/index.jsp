<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css"/>
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
<div id="score">
    <h1>Your <strong>GOLD</strong>: <c:out value="${gold}"/> <span>|</span></h1>
   <!--<input type="text" id="gold" value="{{request.session.gold}}">-->
    <a href="/reset">Reset Gold</a>
    </div>
    <div id="farm">
        <form action="/getgold" method="POST">
            <h2>Farm</h2>
            <p>( earns 10 - 20 golds )</p>
            <input type="hidden" name="location" value="farm">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div class="play">
        <form action="/getgold" method="POST">
            <h2>Cave</h2>
            <p>( earns 5 - 10 golds )</p>
            <input type="hidden" name="location" value="cave">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div class="play">
        <form action="/getgold" method="POST">
            <h2>Spa</h2>
            <p>( loses 5 - 20 golds )</p>
            <input type="hidden" name="location" value="spa">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div class="play">
        <form action="/getgold" method="POST">
            <h2>House</h2>
            <p>( earns 2 - 5 golds )</p>
            <input type="hidden" name="location" value="house">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div class="play">
        <form action="/getgold" method="POST">
            <h2>Casino</h2>
            <p>( earns 0 - 50 golds )</p>
            <input type="hidden" name="location" value="casino">
           <input type="submit" value="Find Gold!">
        </form>
    </div>
    <h3>Activity:</h3>
    <div class="activity">
		<c:forEach items="${activity}" var="act">
			<p class="${act.contains("lost")? "red" : "green" }">
				<c:out value="${act}"/>
			</p>
		</c:forEach>
	</div>
</body>
</html>
