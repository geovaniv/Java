<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.People"%>
<%@ page import="java.util.ArrayList"%>
<% 
	People people = (People) request.getAttribute("people");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Editar Pessoa</h1>
	<form name="frmPeople" action="editPeople">
		<span class="boldSpan">ID da Pessoa: </span>
		<br/>
		<input type="text" readonly="readonly" name="peopleId" value="<%=people.getPeopleId()%>">
		<br/>
		<span class="boldSpan">Nome: </span>
		<br/>
		<input type="text" name="peopleFirstName"value="<%=people.getPeopleFirstName()%>">
		<br/>
		<span class="boldSpan">Sobrenome: </span>
		<br/>
		<input type="text" name="peopleLastName" value="<%=people.getPeopleLastName()%>">
		<br/>
		<input type="button" class="button" value="Salvar" onclick="validatePeople()">
	</form>
	<form action="mainPeople">
		<input type="submit" class="button" value="Voltar">
	</form>
<script src="scripts/validator.js"></script>
</body>
</html>