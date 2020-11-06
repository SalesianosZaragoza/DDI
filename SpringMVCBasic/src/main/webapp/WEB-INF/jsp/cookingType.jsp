<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cooking types manager</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<form:form action="cookingTypeInsert" method="post">
		<span>tipo de cocina:</span>
		<form:input type="text" path="name" />
		<input type="submit"/>
	</form:form>
	<br/>
	<br/>
	<br/>
	<br/>
	
  <c:if test="${not empty cookingTypes}">
	<table border="1">
        <thead>
            <tr>
                <td>Listado de tipos de cocina</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cookingType" items="${cookingTypes}">
                <tr>
                    <td><c:out value="${cookingType.name}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>