<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix= "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action='crialogin' method = 'get'>
Nome: <input type='text' name='nome'><br>
Senha: <input type='text' name='senha'><br>
<input type='submit' value ='adicionar'>
</form>

</body>
</html>