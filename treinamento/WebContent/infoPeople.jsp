<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.People"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.ArrayList"%>
<%
People people = (People) request.getAttribute("people");
Room room = (Room) request.getAttribute("room");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Info Pessoa</h1>
	<span class="boldSpan">ID da Pessoa: </span>
	<span><%=people.getPeopleId()%></span>
	<br />
	<span class="boldSpan">Nome: </span>
	<span><%=people.getPeopleFirstName()%></span>
	<br />
	<span class="boldSpan">Sobrenome: </span>
	<span><%=people.getPeopleLastName()%></span>
	<br />
	<span class="boldSpan">Sala de Evento (Primeira Etapa):</span>
	<span><%=room.getRoomName()%></span>
	<form action="mainPeople" class="return">
		<input type="submit" class="button" value="Voltar">
	</form>
</body>
</html>