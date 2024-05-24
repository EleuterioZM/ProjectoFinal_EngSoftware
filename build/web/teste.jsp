<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teste Avaliação Servlet</title>
</head>
<body>
    <h1>Adicionar Nova Avaliação</h1>
    <form action="AvaliacaoServlet" method="post">
        Descrição: <input type="text" name="descricao" required><br>
        Peso: <input type="text" name="peso" required><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Adicionar Avaliação">
    </form>

    <hr>

    <h1>Buscar Avaliação por ID</h1>
    <form action="" method="get">
        ID: <input type="text" name="id" required>
        <input type="hidden" name="action" value="search">
        <input type="submit" value="Buscar">
    </form>
    
    <%
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            DAO.AvaliacaoDAO avaliacaoDAO = new DAO.AvaliacaoDAO();
            Model.Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
    %>
    <h2>Resultado da Busca:</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Peso</th>
            <th>Ações</th>
        </tr>
        <tr>
            <td><%= avaliacao.getId() %></td>
            <td><%= avaliacao.getDescricao() %></td>
            <td><%= avaliacao.getPeso() %></td>
            <td>
                <form action="AvaliacaoServlet" method="post">
                    <input type="hidden" name="id" value="<%= avaliacao.getId() %>">
                    <input type="hidden" name="action" value="edit">
                    <input type="submit" value="Editar">
                </form>
                <form action="AvaliacaoServlet" method="post">
                    <input type="hidden" name="id" value="<%= avaliacao.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <input type="submit" value="Apagar">
                </form>
            </td>
        </tr>
    </table>
    <% } %>

    <hr>

    <h1>Lista de Avaliações</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Peso</th>
            <th>Ações</th>
        </tr>
        <% 
            DAO.AvaliacaoDAO avaliacaoDAO = new DAO.AvaliacaoDAO();
            for (Model.Avaliacao avaliacao : avaliacaoDAO.listarAvaliacoes()) {
        
        %>
        <tr>
            <td><%= avaliacao.getId() %></td>
            <td><%= avaliacao.getDescricao() %></td>
            <td><%= avaliacao.getPeso() %></td>
           <td>
    <form action="AvaliacaoServlet" method="post">
        <input type="hidden" name="id" value="<%= avaliacao.getId() %>">
        <input type="hidden" name="action" value="edit">
        <input type="submit" value="Editar">
    </form>
    <form action="AvaliacaoServlet" method="post">
        <input type="hidden" name="id" value="<%= avaliacao.getId() %>">
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Apagar">
    </form>
</td>

        </tr>
        <% } %>
    </table>

    <br>
    <a href="AvaliacaoServlet">Atualizar Lista</a>
</body>
</html>
