<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<head>
	<title>HOME</title>
	<link type="text/css" rel="stylesheet" href="css/global-style.css">
</head>

<body>
	<nav><a href="PrsnRecordControllerServlet">HOME</a></nav>
	
	<h1>My Personal Records</h1>
	<h2>All Training Records</h2>
	
	<form action="PrsnRecordControllerServlet" method="GET">
		<input type="hidden" name="command" value="SEARCH">
		<input type="text" name="keyword" placeholder="search record by keyword">
		<input type="submit" value="Search">
	</form>
	
	<c:set var="length" value="${LENGTH}" />
	<h3> Total: ${length} results</h3>
	
	<input type="button" value="Add Record" onclick="window.location.href='add-record.jsp'">
	
	<table border="1">
		<tr>
			<th>Exercise</th>
			<th>Weights</th>
			<th>Sets</th>
			<th>Reps</th>
			<th>Volume</th>
			<th>Training date</th>
			<th>Actions</th>
		</tr>
			
		<c:forEach var="tempRecord" items="${ALL_RECORDS}">
			<!-- set link and params for update button -->
			<c:url var="updateLink" value="PrsnRecordControllerServlet">
				<c:param name="command" value="LOAD" />
				<c:param name="prsnRecordId" value="${tempRecord.id}" />
			</c:url>
			<c:url var="deleteLink" value="PrsnRecordControllerServlet">
				<c:param name="command" value="DELETE" />
				<c:param name="prsnRecordId" value="${tempRecord.id}" />
			</c:url>
		
			<tr>
				<td>${tempRecord.exerciseName}</td>
				<td>${tempRecord.weights}</td>
				<td>${tempRecord.sets}</td>
				<td>${tempRecord.reps}</td>
				<td>${tempRecord.volume}</td>
				<td>${tempRecord.date}</td>
				<td>
					<a href="${updateLink}">Update</a>
					 |
					<a href="${deleteLink}" onclick="if(!confirm('Are you sure you want to delete this record?')) return false">Delete</a>
				</td>
			</tr>
		</c:forEach> 

	
	
	</table>

	
	
	

</body>


</html>