<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar</title>
</head>
<body>
<form action='atualiza' method = 'post'>
Nome: <input type='text' name='nome' value='${param.nome}'><br>
Tag: <input type='text' name='tag'value='${param.tag}'><br>
Quem Criou: <input type='text' name='pessoa'value='${param.pessoa}'><br>
<input type='hidden' name='id' value ='${param.id}'>
<input type='submit' value ='atualizar'>

</form>
</body>
</html>