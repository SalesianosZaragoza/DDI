<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo alumno</title>
</head>
<body>
	<form action="inscribirAlumnos" method="post">
		<span>Nombre:</span><input type="text" name="name">
		<span>Apellidos:</span><input type="text" name="surname">
		<input type="submit">
	</form>
</body>
</html>