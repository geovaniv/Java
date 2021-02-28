<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Room"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Room> list = (ArrayList<Room>) request.getAttribute("allRoom");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
<h1>Salas do Evento</h1>
	<a href="addRoom.html" class="button">Adicionar Sala do Evento</a>
	<a href="index.html" class="button">Voltar</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Lotação</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i < list.size(); i++) { %>
				<tr>
					<td><%=list.get(i).getRoomId()%></td>
					<td><%=list.get(i).getRoomName()%></td>
					<td><%=list.get(i).getRoomCapacity()%></td>
					<td><a href="infoRoom?roomId=<%=list.get(i).getRoomId()%>" class="buttonLight">Info</a>
					<a href="listRoom?roomId=<%=list.get(i).getRoomId()%>" class="buttonLight">Editar</a>
					<a href="deleteRoom?roomId=<%=list.get(i).getRoomId()%>" class="buttonDelete">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>