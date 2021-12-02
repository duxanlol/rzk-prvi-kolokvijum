<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<form action="/DusanMandic2AvioWEB/SearchReserveServlet" method="get">
	<input type="text" name="text">
	<input type="submit" value="Search">
</form>
<c:if test="${!empty letovi }">
<h1> IMA LETOVA</h1>
<form action="/DusanMandic2AvioWEB/SearchReserveServlet" method="post">
<select id="let" name="let">
<c:forEach items="${letovi}"  var="l">
	<option value="${l.idAvioLet}"> ${l.idAvioLet} &nbsp ${l.polazniAerodrom} &nbsp ${l.destinacija} &nbsp ${l.cena} &nbsp ${l.datum} &nbsp </option>
</c:forEach>
</select>	
	<input type="number" name="brojKarata">
	<input type="submit" value="rezervisi i kupi">
	<br>
	

</form>
<small>EZ REZERVE SISTEM JEDAN KLIK I REZERVISE I KUPUJE I TIME STEDI VAMA DRAGOCENE SEKUDNE ZIVOTA!!!</small>
</c:if>

</body>
</html>