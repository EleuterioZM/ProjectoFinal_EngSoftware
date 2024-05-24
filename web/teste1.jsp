<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Disciplinas</title>
</head>
<body>
    <h1>Adicionar Nova Disciplina</h1>
    <form action="DisciplinaServlet" method="post">
        Nome: <input type="text" name="nome" required><br>
        Carga Horária Semanal: <input type="text" name="chs" required><br>
        Crédito: <input type="text" name="credito" required><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Adicionar Disciplina">
    </form>

<h1>Buscar Disciplina por Nome</h1>
<form action="" method="get">
    Nome: <input type="text" name="nome" required>
    <input type="hidden" name="action" value="searchByName">
    <input type="submit" value="Buscar">
</form>

<%
    String nomeParam = request.getParameter("nome");
    if (nomeParam != null && !nomeParam.isEmpty()) {
        DAO.DisciplinaDAO disciplinaDAO = new DAO.DisciplinaDAO();
        List<Model.Disciplina> disciplinasEncontradas = disciplinaDAO.buscarPorNome(nomeParam);
        if (!disciplinasEncontradas.isEmpty()) {
%>
<h2>Resultados da Busca por Nome "<%= nomeParam %>":</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Carga Horária Semanal</th>
        <th>Crédito</th>
        <th>Ações</th>
    </tr>
    <% for (Model.Disciplina disciplina : disciplinasEncontradas) { %>
    <tr>
        <td><%= disciplina.getId() %></td>
        <td><%= disciplina.getNome() %></td>
        <td><%= disciplina.getChs() %></td>
        <td><%= disciplina.getCredito() %></td>
        <td>
            <form action="DisciplinaServlet" method="post">
                <input type="hidden" name="id" value="<%= disciplina.getId() %>">
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Editar">
            </form>
            <form action="DisciplinaServlet" method="post">
                <input type="hidden" name="id" value="<%= disciplina.getId() %>">
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Apagar">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<%
        } else {
%>
<p>Nenhuma disciplina encontrada com o nome "<%= nomeParam %>".</p>
<%
        }
    }
%>

    <h1>Lista de Disciplinas</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Carga Horária Semanal</th>
            <th>Crédito</th>
            <th>Ações</th>
        </tr>
        <% 
            DAO.DisciplinaDAO disciplinaDAO = new DAO.DisciplinaDAO();
            for (Model.Disciplina disciplina : disciplinaDAO.listarDisciplinas()) {
        %>
        <tr>
            <td><%= disciplina.getId() %></td>
            <td><%= disciplina.getNome() %></td>
            <td><%= disciplina.getChs() %></td>
            <td><%= disciplina.getCredito() %></td>
            <td>
                <form action="DisciplinaServlet" method="post">
                    <input type="hidden" name="id" value="<%= disciplina.getId() %>">
                    <input type="hidden" name="action" value="edit">
                    <input type="submit" value="Editar">
                </form>
                <form action="DisciplinaServlet" method="post">
                    <input type="hidden" name="id" value="<%= disciplina.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <input type="submit" value="Apagar">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
