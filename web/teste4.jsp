<%@page import="java.util.List"%>
<%@page import="Model.Turma"%>
<%@page import="Model.Curso"%>
<%@page import="DAO.TurmaDAO"%>
<%@page import="DAO.CursoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Turmas</title>
    <script>
        function preencherFormulario(id, nome, cursoId) {
            document.getElementById("edit_id").value = id;
            document.getElementById("edit_nome").value = nome;
            document.getElementById("edit_curso").value = cursoId;
        }
    </script>
</head>
<body>

<h1>Adicionar Nova Turma</h1>
<form action="TurmaServlet" method="post">
    Nome: <input type="text" name="nome" required><br>
    Curso:
    <select name="idCurso" required>
        <option value="">Selecione um curso</option>
        <% 
            CursoDAO cursoDAO = new CursoDAO();
            List<Curso> cursos = cursoDAO.listarCursos();
            for (Curso curso : cursos) { 
        %>
        <option value="<%= curso.getId() %>"><%= curso.getNome() %></option>
        <% } %>
    </select><br>
    <input type="hidden" name="action" value="add">
    <input type="submit" value="Adicionar Turma">
</form>

<h1>Buscar Turma</h1>
<form action="TurmaServlet" method="get">
    Por ID: <input type="text" name="id" placeholder="ID">
    <input type="hidden" name="action" value="search">
    <input type="submit" value="Buscar">
</form>



<h1>Lista de Turmas</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Curso</th>
        <th>Ações</th>
    </tr>
    <% 
        TurmaDAO turmaDAO = new TurmaDAO();
        List<Turma> turmas = null;
        String nomeBusca = request.getParameter("nome");
        if (nomeBusca != null && !nomeBusca.isEmpty()) {
           
        } else {
            turmas = turmaDAO.listarTurmasComCurso();
        }
        for (Turma turma : turmas) {
    %>
    <tr>
        <td><%= turma.getId() %></td>
        <td><%= turma.getNome() %></td>
        <td><%= turma.getCurso().getNome() %></td>
        <td>
            <button onclick="preencherFormulario('<%= turma.getId() %>', '<%= turma.getNome() %>', '<%= turma.getCurso().getId() %>')">Editar</button>
            <form action="TurmaServlet" method="post">
                <input type="hidden" name="id" value="<%= turma.getId() %>">
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Apagar">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<h1>Editar Turma</h1>
<form action="TurmaServlet" method="post">
    <input type="hidden" id="edit_id" name="id">
    Nome: <input type="text" id="edit_nome" name="nome" required><br>
    Curso:
    <select id="edit_curso" name="idCurso" required>
        <option value="">Selecione um curso</option>
        <% 
            for (Curso curso : cursos) { 
        %>
        <option value="<%= curso.getId() %>"><%= curso.getNome() %></option>
        <% } %>
    </select><br>
    <input type="hidden" name="action" value="edit"> 
    <input type="submit" value="Atualizar">
</form>

</body>
</html>
