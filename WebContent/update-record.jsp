<html>

<head>
	<title>Add Student</title>
</head>

<body>
	<div>
		<div>
			<h2>My Personal Record</h2>
		</div>
	</div>
	
	<div>
		<h3>Update Record</h3>
		
		<form action="PrsnRecordControllerServlet" method="GET">
			
			<input type="hidden" name="command" value="UPDATE">
			<input type="hidden" name="prsnRecordId" value="${PRSNRECORD.id}">
			
			<table>
				<tbody>
				 <tr>
				 	<td><label>Exercise name:</label></td>
				 	<td><input type="text" name="exerciseName" value="${PRSNRECORD.exerciseName}"></td>
				 </tr>
 				 <tr>
				 	<td><label>Weights(kg):</label></td>
				 	<td><input type="number" name="weights" value="${PRSNRECORD.weights}"></td>
				 </tr>
				  <tr>
				 	<td><label>Sets:</label></td>
				 	<td><input type="number" name="sets" value="${PRSNRECORD.sets}"></td>
				 </tr>
				  <tr>
				 	<td><label>Reps:</label></td>
				 	<td><input type="number" name="reps" value="${PRSNRECORD.reps}"></td>
				 </tr>				 
				  <tr>
				 	<td><label>Training date:</label></td>
				 	<td><input type="date" name="date" value="${PRSNRECORD.date}"></td>
				 </tr>				 
				 <tr>
				 	<td><label></label></td>
				 	<td><input type="submit" value="Update"></td>
				 </tr>
				</tbody>
			</table>
			
		</form>
	</div>
	
	<p>
		<a href="PrsnRecordControllerServlet">Back to List</a>
	</p>


</body>

</html>