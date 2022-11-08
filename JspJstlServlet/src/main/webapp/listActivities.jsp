<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<div class="container">
<form action="/verActividades" method="get">
	<input type="submit" name="mostrar actividades">

</form>
<br/>
<table class="table table-dark table-striped">
<c:forEach var="activity" items="${requestScope.lista}" varStatus="indice">
	<tr style="border:1px solid black; padding:5pt">
		<td><c:out value="${indice.index}"/></td>
		<td><c:out value="${activity.aforo}"/></td>
		<td><c:out value="${activity.name}"/></td>
		<td><a href="/eliminar?item=${activity.name}">ELIMINAR</a> </td>
		<!-- poener un enlace que llama un servlet le pasa
		el parametro del name y el servlet mediante doGet con ese name
		borra la actividad de la base de datos -->
	</tr>
</c:forEach>
</table>
<br/>
<a type="button" class="btn btn-primary" href="index.jsp">Volver a Home</a>
</div>
</body>
</html>