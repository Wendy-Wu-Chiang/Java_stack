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
	<h1 style= margin-left:20px; >Welcome, <c:out value="${user.firstName}"/>!</h1>
	
	<h3>Here are some of the events that are in your state:</h3>
	
	<a href="/logout" style= margin-left:1350px; >Logout</a>
	
	<div class="events">
	
	<table class="table table-success">
	
   		<thead>
       		<tr>
            	<th>Name</th>
            	<th>Date</th>
            	<th>Location</th>
            	<th>Host</th>
            	<th>Action/Status</th>
        	</tr>
        	
    	</thead>
    	
    	<c:forEach items="${userEvents}" var="event">
    	
    <tbody>
		<tr>    
    		<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
    		
    		<td><c:out value="${event.eventDate}"/></td>
    		
    		<td><c:out value="${event.city}"/></td>
    		
    		<td><c:out value="${event.host.firstName}"/></td>
    		
    		<td>
				<c:choose>
				
					<c:when test="${event.host.id == user.id}">
					
						<a href="/events/edit/${event.id}">Edit</a> <span> | </span>
						
						<a href="/events/delete/${event.id}">Delete</a>
						
					</c:when>
					
					<c:otherwise>
					
					<c:choose>
					
					<c:when test="${event.joinedUsers.contains(user)}">
					
						<p>Joining <span> | </span> <a href="/events/cancel/${event.id}">Cancel</a></p>
						
					</c:when>
					
					<c:otherwise>
					
						<a href="/join/${event.id}">Join</a>
						
						</c:otherwise>
						
					</c:choose>
					
				</c:otherwise>
				
				</c:choose>
				
			</td>
			
		</tr>
		
    </tbody>
    
    </c:forEach>
    
	</table>
	
	</div>
	
	<h3>Here are some of the other events in your state:</h3>
	
	<div class="events">
	
	<table class="table table-success">
	
   		<thead>
   		
       		<tr>
       		
            	<th>Name</th>
            	<th>Date</th>
            	<th>Location</th>
            	<th>State</th>
            	<th>Host</th>
            	<th>Action</th>
            	
        	</tr>
        	
    	</thead>
    	
    	<c:forEach items="${otherEvents}" var="event">
    	
    <tbody>
    
		<tr>    
    		<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a> </td>
    		
    		<td><c:out value="${event.eventDate}"/></td>
    		
    		<td><c:out value="${event.city}"/></td>
    		
    		<td><c:out value="${event.state}"/></td>
    		
    		<td><c:out value="${event.host.firstName}"/></td>
    		
    		<td>
				<c:choose>
				
					<c:when test="${event.host.id == user.id}">
					
						<a href="/events/edit/${event.id}">Edit</a> <span>|</span>
						
						<a href="/events/delete/${event.id}">Delete</a>
						
					</c:when>
					
					<c:otherwise>
					
						<c:choose>
						
							<c:when test="${event.joinedUsers.contains(user)}">
							
							<p>Joining <span>|</span> <a href="/events/cancel/${event.id}">Cancel</a></p>
							
							</c:when>
							
							<c:otherwise>
							
							<a href="/join/${event.id}">Join</a>
							
							</c:otherwise>
							
						</c:choose>
						
					</c:otherwise>
					
				</c:choose>
				
			</td>
			
		</tr>
		
    </tbody>
    
    </c:forEach>
    
	</table>
	
	</div>
	
	<div class="new">
	
	<h3>Create an event:</h3>
	
	<form:form method="POST" action="/events/new" modelAttribute="event">
	
		<div class="form-group">
		
			<form:label path="name">Name: </form:label>
			
			<form:errors path="name"/>
			
			<form:input path="name"/>
		</div>
		
		<div class="form-group">
		
		<form:label path="eventDate">Date: </form:label>
		
		<form:errors path="eventDate"/>
		
		<form:input type="date" path="eventDate"></form:input>
		
		</div>
		
		<div class="location">
		
		<div class="form-group">
		
			<form:label path="city">Location: </form:label>
			
			<form:errors path="city"/>
			
					<form:select path="state">
						<option value="CA">CA</option>
						<option value="UT">UT</option>
						<option value="TX">TX</option>
						<option value="CO">CO</option>
						<option value="WA">WA</option>
						<option value="NV">NV</option>
					</form:select>
					
					<form:input path="city"/>
					
					</div>
					
			<button type="submit" class="btn btn-outline-success">Create Event</button>
			
		</div>
		
		</form:form>
		
	</div>
</body>
</html>