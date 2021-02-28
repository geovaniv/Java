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
	<h1>Info Espaço de Café</h1>
	<span class="boldSpan">ID do Espaço de Café: </span>
	<span><%=coffee.getCoffeeId()%></span>
	<br/>
	<span class="boldSpan">Nome: </span>
	<span><%=coffee.getCoffeeName()%></span>
	<br/>
	<form action="mainCoffee" class="return">
		<input type="submit" class="button" value="Voltar">
	</form>
</body>
</html>