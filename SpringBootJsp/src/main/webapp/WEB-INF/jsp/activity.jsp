<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina1</title>
</head>
<body>
 <form:form method="POST"
          action="/hello2" modelAttribute="activity">
                    <form:label path="activityName">activityName</form:label>
                    <form:input path="activityName"/>
                    <br/>
                    <form:label path="aforo">aforo</form:label>
                    <form:input path="aforo"/>
                    <br/>
                    <input type="submit" value="Submit"/>
        </form:form>
</body>
</html>