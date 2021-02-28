<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Coffee"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Coffee> list = (ArrayList<Coffee>) request.getAttribute("allCoffee");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
<h1>Espaços de Café</h1>
	<a href="addCoffee.html" class="button">Adicionar Espaço de Café</a>
	<a href="index.html" class="button">Voltar</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i=0; i < list.size(); i++) { %>
				<tr>
					<td><%=list.get(i).getCoffeeId()%></td>
					<td><%=list.get(i).getCoffeeName()%></td>
					<td><a href="infoCoffee?coffeeId=<%=list.get(i).getCoffeeId()%>" class="buttonLight">Info</a>
					<a href="listCoffee?coffeeId=<%=list.get(i).getCoffeeId()%>" class="buttonLight">Editar</a>
					<a href="deleteCoffee?coffeeId=<%=list.get(i).getCoffeeId()%>" class="buttonDelete">Excluir</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>