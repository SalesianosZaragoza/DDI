<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Propietario editado</title>
</head>
<body>
<%
 request.getAttribute("owner");
%>
	<form action="/updateOwner" method="post">
		<span>cod:</span> 
		<input type="text" name="codOwner" value="<c:out value="${owner.codOwner}"/>" style="display:none"> <br/>
		<span>nombre:</span> 
		<input type="text" name="name" value="<c:out value="${owner.name}"/>" > <br/>
		<span>apellido:</span> 
		<input type="text" name="surname" value="<c:out value="${owner.surname}"/>"> <br/>
		
		<input type="submit">
	</form>
</body>
</html>