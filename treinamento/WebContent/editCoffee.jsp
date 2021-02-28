<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Coffee"%>
<%@ page import="java.util.ArrayList"%>
<%
Coffee coffee = (Coffee) request.getAttribute("coffee");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Treinamento</title>
<link rel="stylesheet" href="styles/style.css">
</head>
<body>
	<h1>Editar Espaço de Café</h1>
	<form name="frmCoffee" action="editCoffee">
		<span class="boldSpan">ID do Espaço de Café: </span> 
		<br />
		<input type="text" readonly="readonly" name="coffeeId" value="<%=coffee.getCoffeeId()%>">
		<br /> 
		<span class="boldSpan">Nome: </span>
		<br />
		<input type="text" name="coffeeName" value="<%=coffee.getCoffeeName()%>">
		<br />
		<input type="button" class="button" value="Salvar" onclick="validateCoffee()">
	</form>
	<form action="mainCoffee">
		<input type="submit" class="button" value="Voltar">
	</form>
	<script src="scripts/validator.js"></script>
</body>
</html>