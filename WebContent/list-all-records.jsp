<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>
	<h1>My Personal Records</h1>
	<h2>All Training Records</h2>
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
		
			<tr>
				<td>${tempRecord.exerciseName}</td>
				<td>${tempRecord.weights}</td>
				<td>${tempRecord.sets}</td>
				<td>${tempRecord.reps}</td>
				<td>${tempRecord.volume}</td>
				<td>${tempRecord.date}</td>
				<td><a href="${updateLink}">Update</a></td>
			</tr>
		</c:forEach> 

	
	
	</table>
	
	
	

</body>


</html>