<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar propietario</title>
</head>
<body>
	<form action="/updateOwner" method="post">
		<span>Nombre:</span><input type="text" name="nombre" value="<c:out value="${editableOwner.name}"/>" >
		<span>Apellidos:</span><input type="text" name="apellidos" value="<c:out value="${editableOwner.surname}"/>" >
		<input type="submit">
	</form>
</body>
</html>