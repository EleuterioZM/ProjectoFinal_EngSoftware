<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excluir Avaliação</title>
</head>
<body>
    <h1>Excluir Avaliação</h1>
    <p>Você tem certeza que deseja excluir esta avaliação?</p>
    <form action="AvaliacaoServlet" method="post">

        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
         <input type="hidden" name="action" value="confirmarExclusao">
        <input type="submit" value="Excluir Avaliação">
        <button type="button" onclick="history.back()">Cancelar</button>
    </form>
    <a href="teste.jsp">Voltar para a página de teste</a>
</body>
</html>
