<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo alumno</title>
</head>
<body>
	<form:form action="addOwner" method="post" modelAttribute="owner">
		<span>Nombre:</span>
		<form:input path="name" type="text" name="name"/>
		<span>Apellidos:</span>
		<form:input path="surname" type="text" name="surname"/>
		<input type="submit"/>
	</form:form>
</body>
</html>