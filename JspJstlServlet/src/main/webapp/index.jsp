<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formulario nuevas actividades</title>
</head>
<body>
	<form action="/insert" method="post">
		<span>Nombre Actividad</span> <input type="text" id="name" name="name" /> 
		<span>Aforo</span>	<input type="text" id="gauging" name="gauging" /> <input type="submit" value="enviar" />
	</form>
	<a href="Validation.jsp">Quiero comprobar una actividad</a>
</body>
</html>