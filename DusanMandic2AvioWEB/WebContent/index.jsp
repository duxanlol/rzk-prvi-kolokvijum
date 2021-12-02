<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>

	<form action="/DusanMandic2AvioWEB/LoginServlet" method="post">
	
	<input type="text" name="username">
	<input type="password" name="password">
	<input type="submit" value="login">
	
	</form>
	
<c:if test="${!empty bean }">
	<form action="/DusanMandic2AvioWEB/LoginServlet" method="get">
	<input type="submit" value="logout">
	</form>
</c:if>
<c:if test="${!empty message }">
	<h1> ${message}</h1>
	
	
</c:if>	
	
	
</body>
</html>