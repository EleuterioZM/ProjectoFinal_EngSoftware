<%@page import="java.util.List"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="Model.Curso"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Cursos</title>
    <script>
        function preencherFormulario(id, nome) {
            document.getElementById("edit_id").value = id;
            document.getElementById("edit_nome").value = nome;
        }
    </script>
</head>
<body>

     <h1>Adicionar Novo Curso</h1>
    <form action="CursoServlet" method="post">
        Nome: <input type="text" name="nome" required><br>
        <input type="hidden" name="action" value="add">
        <input type="submit" value="Adicionar Curso">
    </form>

    <h1>Buscar Curso por Nome</h1>
    <form action="" method="get">
        Nome: <input type="text" name="nome" required>
        <input type="hidden" name="action" value="searchByName">
        <input type="submit" value="Buscar">
    </form>

    <% 
        String nomeParam = request.getParameter("nome");
        if (nomeParam != null && !nomeParam.isEmpty()) {
            CursoDAO cursoDAO = new CursoDAO();
            List<Curso> cursosEncontrados = cursoDAO.buscarPorNome(nomeParam);
            if (!cursosEncontrados.isEmpty()) {
    %>
    <h2>Resultados da Busca por Nome "<%= nomeParam %>":</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th>
        </tr>
        <% for (Curso curso : cursosEncontrados) { %>
        <tr>
            <td><%= curso.getId() %></td>
            <td><%= curso.getNome() %></td>
            <td>
                <button onclick="preencherFormulario('<%= curso.getId() %>', '<%= curso.getNome() %>')">Editar</button>
                <form action="CursoServlet" method="post">
                    <input type="hidden" name="id" value="<%= curso.getId() %>">
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
    <p>Nenhum curso encontrado com o nome "<%= nomeParam %>".</p>
    <%
            }
        }
    %>

    <h1>Lista de Cursos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th>
        </tr>
        <% 
            CursoDAO cursoDAO = new CursoDAO();
            for (Curso curso : cursoDAO.listarCursos()) {
        %>
        <tr>
            <td><%= curso.getId() %></td>
            <td><%= curso.getNome() %></td>
            <td>
                <button onclick="preencherFormulario('<%= curso.getId() %>', '<%= curso.getNome() %>')">Editar</button>
                <form action="CursoServlet" method="post">
                    <input type="hidden" name="id" value="<%= curso.getId() %>">
                    <input type="hidden" name="action" value="delete">
                    <input type="submit" value="Apagar">
                </form>
            </td>
        </tr>
        <% } %>
    </table>

   <h1>Editar Curso</h1>
<form action="CursoServlet" method="post">
    <input type="hidden" id="edit_id" name="id">
    Nome: <input type="text" id="edit_nome" name="nome" required><br>
    <input type="hidden" name="action" value="edit"> <!-- Definindo a ação como "edit" -->
    <input type="submit" value="Atualizar">
</form>

</body>
</html>
