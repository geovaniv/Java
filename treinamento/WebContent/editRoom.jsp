<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.ArrayList"%>
<% 
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
	<h1>Editar Sala do Evento</h1>
	<form name="frmRoom" action="editRoom">
		<span class="boldSpan">ID da Sala do Evento: </span>
		<br/>
		<input type="text" readonly="readonly" name="roomId" value="<%=room.getRoomId()%>">
		<br/>
		<span class="boldSpan">Nome: </span>
		<br/>
		<input type="text" name="roomName" value="<%=room.getRoomName()%>">
		<br/>
		<span class="boldSpan">Lotação: </span>
		<br/>
		<input type="text" name="roomCapacity" value="<%=room.getRoomCapacity()%>">
		<br/>
		<input type="button" class="button" value="Salvar" onclick="validateRoom()">
	</form>
	<form action="mainRoom">
		<input type="submit" class="button" value="Voltar">
	</form>
<script src="scripts/validator.js"></script>
</body>
</html>