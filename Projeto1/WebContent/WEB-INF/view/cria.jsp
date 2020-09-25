<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='cria' method = 'post'>
Nome: <input type='text' name='nome' value ='${param.nome}'><br>
Tag: <input type='text' name='tag'><br>
Quem criou: <input type='text' name='pessoa'><br>
<input type='submit' value ='adicionar'>
</form>
</body>
</html>