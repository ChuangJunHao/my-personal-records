<html>

<head>
	<title>FORM</title>
	<link type="text/css" rel="stylesheet" href="css/global-style.css">
</head>

<body>
	<div>
		<div>
			<h2>My Personal Record</h2>
		</div>
	</div>
	
	<div>
		<h3>Add Record</h3>
		
		<form action="PrsnRecordControllerServlet" method="GET">
			
			<input type="hidden" name="command" value="ADD">
			
			<table>
				<tbody>
				 <tr>
				 	<td><label>Exercise name:</label></td>
				 	<td><input type="text" name="exerciseName"></td>
				 </tr>
 				 <tr>
				 	<td><label>Weights(kg):</label></td>
				 	<td><input type="number" name="weights"></td>
				 </tr>
				  <tr>
				 	<td><label>Sets:</label></td>
				 	<td><input type="number" name="sets"></td>
				 </tr>
				  <tr>
				 	<td><label>Reps:</label></td>
				 	<td><input type="number" name="reps"></td>
				 </tr>				 
				  <tr>
				 	<td><label>Training date:</label></td>
				 	<td><input type="date" name="date"></td>
				 </tr>				 
				 <tr>
				 	<td><label></label></td>
				 	<td><input type="submit" value="Save"></td>
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