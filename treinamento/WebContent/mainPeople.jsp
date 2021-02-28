<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.People"%>
<%@ page import="java.util.ArrayList"%>
<%
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
<h1>Pessoas</h1>
	<a href="addPeople.html" class="button">Adicionar Pessoa</a>
	<a href="index.html" class="button">Voltar</a>
	<p class="spanAlert">Para adicionar uma pessoa, é necessário que pelo menos uma Sala de Evento esteja cadastrada!</p>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i < list.size(); i++) { %>
				<tr>
					<td><%=list.get(i).getPeopleId()%></td>
					<td><%=list.get(i).getPeopleFirstName()%></td>
					<td><%=list.get(i).getPeopleLastName()%></td>
					<td><a href="infoPeople?peopleId=<%=list.get(i).getPeopleId()%>" class="buttonLight">Info</a>
					<a href="listPeople?peopleId=<%=list.get(i).getPeopleId()%>" class="buttonLight">Editar</a>
					<a href="deletePeople?peopleId=<%=list.get(i).getPeopleId()%>" class="buttonDelete">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>