<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<form:form action="recipeInsert" method="post">
		<span>nombre de la receta:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Guardar nombre receta" />
	</form:form>
	<br />
	<br />
	El nombre de la receta es <span><c:out value="${recipe.name}" /></span>
	<br />
	<br />
	<br />


	<form:form action="ingredientInsert" method="post">
		<span>nuevo ingrediente:</span>
		<form:input type="text" path="ingredientName" />
		<input type="submit" value="guardar ingrediente"/>
	</form:form>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre del ingrediente</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ingredient" items="${recipe.ingredients}">
				<tr>
					<td><c:out value="${ingredient.name}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<br />
	<br /> 



	<form:form action="cookingToolInsert" method="post">
		<span>nuevo utensilio:</span>
		<form:input type="text" path="cookingToolName" />
		<input type="submit" value="guardar herramienta" />
	</form:form>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre del utensilio</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cookingTool" items="${recipe.tools}">
				<tr>
					<td><c:out value="${cookingTool.name}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>