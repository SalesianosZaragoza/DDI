<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="welcome" method="post">
		<span>nombre:</span> 
		
		<input type="text" name="name" value="<c:out value="${editableUser.name}"/>"> <br/>
		<span>fecha nac:</span> 
		
		<input type="date" name="dob" value="<c:out value="${editableUser.dateOfBirth}"/>"><br/>
		<span>curso:</span> 
		<input type="text" name="course" value="<c:out value="${editableUser.course}"/>"> <br/>
		<input type="submit">
	</form>
</body>
</html>