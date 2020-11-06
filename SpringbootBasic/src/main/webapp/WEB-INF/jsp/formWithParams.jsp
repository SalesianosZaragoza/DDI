<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="showparam" method="post" modelAttribute="student">
    <input type="text" value="msg" name="msg" />
    <form:input type="text" name="name" path="name"  />
    <form:input type="text" name="surname" path="surname"   />
    <input type="submit"/>     
</form:form>


</body>
</html>