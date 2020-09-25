<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix= "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Tarefas</title>
</head>
<body>
<form action='cria'method='get'>
<input type='submit'value='Adicionar'>
</form>

<form action='ordenar'method='get'>
<input type='submit'value='Ordenar'>
</form>

<table border='1'>
<tr>
<td>Nome</td>
<td>Tag</td>
<td>Pessoa que criou</td>
</tr>
<c:forEach var = "tarefa" items="${tarefas}">
<tr>
<td>${tarefa.nome}</td>
<td>${tarefa.tag}</td>
<td>${tarefa.pessoa}</td>
<td>
<form action='remove'method='post'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='submit'value='Remover'>
</form>

<form action='atualiza'method='get'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='nome' value='${tarefa.nome}'>
<input type='hidden' name='tag' value='${tarefa.tag}'>
<input type='hidden' name='pessoa' value='${tarefa.pessoa}'>
<input type='submit'value='Atualizar'>
</form>

</tr>

</c:forEach>


</table>
</body>
</html>