<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietario editado</title>
</head>
<body>
	<form:form action="/updateOwner" method="post" modelAttribute="owner">
		<span>cod:</span> 
		<form:input type="text" name="codOwner" path="codOwner" style="display:none"/> <br/>
		<span>nombre:</span> 
		<form:input type="text" name="name" path="name" /> <br/>
		<span>apellido:</span> 
		<form:input type="text" name="surname" path="surname"/> <br/>
		
		<input type="submit">
	</form:form>
</body>
</html>