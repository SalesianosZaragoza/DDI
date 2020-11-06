<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/pelicula" method="post">
		<span>cod:</span> <input type="text" name="cod"> <br />
		<span>name:</span> <input type="text" name="name"> <br />
		<span>year:</span> <input type="text" name="year"> <br />
		<input type="submit">
	</form>
</body>
</html>