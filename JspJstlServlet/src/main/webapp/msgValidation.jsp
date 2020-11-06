<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Respuesta del validation servlet</title>
</head>
<body>
	<c:out value="la actividad"></c:out>
	<c:set var="realizable" value="${isRealizable}" />
	<c:if test="${requestScope.isRealizable}">
		<c:out value="Se puede realizar la actividad"></c:out>
	</c:if>
	<c:if test="${!requestScope.isRealizable}">
		<c:out value="NO se puede realizar la actividad"></c:out>
	</c:if>
	
<%
    boolean isRealizable = (boolean)request.getAttribute("isRealizable");
    if ( isRealizable ) {
%>
   <p>Se puede realizar la actividad</p>
<%
    }else{
%>
   <p>No se puede realizar la actividad</p>
<%
    }
%>
</body>
</html>