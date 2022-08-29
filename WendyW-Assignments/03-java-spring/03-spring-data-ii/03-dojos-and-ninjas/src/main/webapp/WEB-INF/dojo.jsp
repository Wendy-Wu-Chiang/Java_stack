<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="show">
		
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
	
	<div class="btn-group">
  <a href="/new/dojo" type="button" class="btn btn-outline-primary">Create New Dojo</a>
  <a href="/new/ninja" type="button" class="btn btn-outline-primary">Create New Ninja</a>
  
  <!--<div class="btn-group">  Add dropdown button to view other dojos
    <button type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown">
       Change Dojo
    </button>
    <div class="dropdown-menu">
    <c:forEach items="${allDojos}" var="dojo">
      <a href="/show/dojo/id" value="${dojo.id}" class="dropdown-item" href="#">${dojo.name}</a>
      </c:forEach>
    </div>
  </div>-->
</div>
	
	<table class="table table-success">
   		<thead>
       		<tr>
            	<th>First Name</th>
            	<th>Last Name</th>
            	<th>Age</th>
            	<!--<th>Action</th>-->
        	</tr>
    	</thead>
    <tbody>
        <c:forEach items="${ninjas}" var="ninja">
		<tr>    
    		<td><c:out value="${ninja.firstName}"/></td>
    		<td><c:out value="${ninja.lastName}"/></td>
    		<td><c:out value="${ninja.age}"/></td>
    		<!--<td><a href="/delete/ninja/${ninja.id}"><c:out value="${ninja.age}"/></a></td>--> <!-- Delete ninja from dojo -->
		</tr>
		</c:forEach>
    </tbody>
	</table>
	</div>
</body>
</html>
