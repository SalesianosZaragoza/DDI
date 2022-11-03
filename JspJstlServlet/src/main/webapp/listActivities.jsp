<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/verActividades" method="get">
	<input type="submit" name="mostrar actividades">

</form>
<br/>
<div>---------------------------------------------------------------------</div>
<c:forEach var="activity" items="${requestScope.lista}" varStatus="indice">
	<c:out value="${indice.index}"/>
	<c:out value="${activity.aforo}"/>
	<c:out value="${activity.name}"/>
	<!-- poener un enlace que llama un servlet le pasa
	el parametro del name y el servlet mediante doGet con ese name
	borra la actividad de la base de datos -->
	<br/>
</c:forEach>
</body>
</html>