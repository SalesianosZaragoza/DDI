<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corfirmar el borrado de propietario</title>
</head>

<body>

	<form action="deleteOwner" method="get">
		<div>¿Está seguro de que desea borrar el propietario?</div>
		<input type="submit" name="answer" value="SI" />
		<input type="submit" name="answer" value="NO" />
		<!-- 
		<a href="listado.jsp">NO</a>
		 -->
		<input type="hidden" name="codOwner" value="${codOwner}" />

	</form>

</body>
</html>