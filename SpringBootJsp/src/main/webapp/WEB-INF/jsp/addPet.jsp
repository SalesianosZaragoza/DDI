<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nueva mascota</title>
</head>

<%
 request.getAttribute("owner");
%>

<body>
	<form action="/addPet" method="post">
		<input type="text" name="codOwner" value="<c:out value="${owner.codOwner}"/>" style="display:none" >
		<span>Nombre:</span><input type="text" name="name">
		<input type="submit">
	</form>
</body>
</html>