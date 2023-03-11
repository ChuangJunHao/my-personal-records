<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<body>

	<c:forEach var="tempRecord" items="${ALL_RECORDS}">
		${tempRecord.exerciseName}, ${tempRecord.weights}, ${tempRecord.sets}, ${tempRecord.reps}, ${tempRecord.volume}
	</c:forEach> 

</body>


</html>