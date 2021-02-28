<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Room"%>
<%@ page import="model.People"%>
<%@ page import="java.util.ArrayList"%>
<%
Room room = (Room) request.getAttribute("room");
ArrayList<People> list = (ArrayList<People>) request.getAttribute("allPeople");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Info Sala do Evento</h1>
	<span class="boldSpan">ID da Sala:</span>
	<span><%=room.getRoomId()%></span>
	<br />
	<span class="boldSpan">Nome:</span>
	<span><%=room.getRoomName()%></span>
	<br />
	<span class="boldSpan">Lotação:</span>
	<span><%=room.getRoomCapacity()%></span>
	<form action="mainRoom" class="return">
		<input type="submit" class="button" value="Voltar">
	</form>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Sala de Evento (Primeira Etapa)</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getPeopleId()%></td>
				<td><%=list.get(i).getPeopleFirstName()%></td>
				<td><%=list.get(i).getPeopleLastName()%></td>
				<td><%=room.getRoomName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>