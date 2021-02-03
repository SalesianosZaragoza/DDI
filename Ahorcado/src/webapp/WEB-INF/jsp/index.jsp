<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de inicio</title>
</head>
<body>
<form:form action="yieldRandomSolutionWord" method="get">
	<input type="submit">
</form:form>

<br/>
<br/>
<br/>
<br/>

<form:form action="checkAnswer">
	<form:input type="text" path="userInput" name="answer"/>
</form:form>


<br/>
<br/>
<br/>
<br/>

<td><c:out value="${feedback}" /></td>
	
	
</body>
</html>