<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ordenar" method="post">
  <label >Escolha uma forma de ordenar</label>
  <select name="ordanar" id=ordanar>
    <option value="nome">Tarefa</option>
    <option value="tag">Tag</option>
    <option value="pessoa">Quem Criou</option>
    
  </select>
  <br><br>
  <input type="submit" value="Ordenar">
</form>

</body>
</html>