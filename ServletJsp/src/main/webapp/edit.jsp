<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.salesianos.model.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="welcome" method="post">
		<span>nombre:</span> 
		
		<input type="text" name="name" value="<c:out value="${editableUser.name}"/>" disabled="disabled"> <br/>
		<span>fecha nac:</span> 
		
		<input type="date" name="dob" value="<c:out value="${editableUser.dateOfBirth}"/>"><br/>
		<span>curso:</span> 
		<input type="text" name="course" value="<c:out value="${editableUser.course}"/>"> <br/>
		<input type="submit">
	</form>
</body>
</html>