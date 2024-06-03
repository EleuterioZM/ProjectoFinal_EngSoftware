<%@page import="Model.Curso"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="Model.Turma"%>
<%@page import="DAO.TurmaDAO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.EstudanteDAO"%>
<%@page import="Model.Estudante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gerenciar Estudantes</title>
    <script>
        function preencherFormulario(nrMatricula, nome, apelido, endereco, contacto, idTurma) {
            document.getElementById("edit_nrMatricula").value = nrMatricula;
            document.getElementById("edit_nome").value = nome;
            document.getElementById("edit_apelido").value = apelido;
            document.getElementById("edit_endereco").value = endereco;
            document.getElementById("edit_contacto").value = contacto;
            document.getElementById("edit_idTurma").value = idTurma;
        }
    </script>
</head>
<body>

<h1>Adicionar Novo Estudante</h1>
<form action="EstudanteServlet?action=add" method="post">
    Nome: <input type="text" name="nome" required><br>
    Apelido: <input type="text" name="apelido" required><br>
    Endereço: <input type="text" name="endereco" required><br>
    Contacto: <input type="text" name="contacto" required><br>
    <label for="turma">Turma:</label>
    <select id="turma" name="idTurma">
        <%-- Listar todas as turmas disponíveis --%>
        <% 
            TurmaDAO turmaDAO = new TurmaDAO();
            List<Turma> turmas = turmaDAO.listarTurmas();
            for (Turma turma : turmas) { %>
                <option value="<%= turma.getId() %>"><%= turma.getNome() %></option>
            <% } %>
    </select>
    <input type="submit" value="Adicionar Estudante">
</form>

<h1>Buscar Estudante por Nome</h1>
<form action="" method="get">
    Nome: <input type="text" name="nome" required>
    <input type="submit" value="Buscar">
</form>

<%
    String nomeParam = request.getParameter("nome");
    if (nomeParam != null && !nomeParam.isEmpty()) {
        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudantesEncontrados = estudanteDAO.buscarPorNome(nomeParam);
        if (!estudantesEncontrados.isEmpty()) {
%>
<h2>Resultados da Busca por Nome "<%= nomeParam %>":</h2>
<table border="1">
    <tr>
        <th>Número de Matrícula</th>
        <th>Nome</th>
        <th>Apelido</th>
        <th>Endereço</th>
        <th>Contacto</th>
      
        <th>Ações</th>
    </tr>
    <% for (Estudante estudante : estudantesEncontrados) { 
        %>
        <tr>
            <td><%= estudante.getNrMatricula() %></td>
            <td><%= estudante.getNome() %></td>
            <td><%= estudante.getApelido() %></td>
            <td><%= estudante.getEndereco() %></td>
            <td><%= estudante.getContacto() %></td>
            <td>
                <button onclick="preencherFormulario('<%= estudante.getNrMatricula() %>', '<%= estudante.getNome() %>', '<%= estudante.getApelido() %>', '<%= estudante.getEndereco() %>', '<%= estudante.getContacto() %>', '<%= estudante.getTurma() != null ? estudante.getTurma().getId() : "" %>')">Editar</button>
                <form action="EstudanteServlet?action=delete" method="post">
                    <input type="hidden" name="nrMatricula" value="<%= estudante.getNrMatricula() %>">
                    <input type="submit" value="Apagar">
                </form>
            </td>
        </tr>
    <% } %>
</table>
<%
        } else {
%>
<p>Nenhum estudante encontrado com o nome "<%= nomeParam %>".</p>
<%
        }
    }
%>

<h1>Lista de Estudantes</h1>
<table border="1">
    <tr>
        <th>Número de Matrícula</th>
        <th>Nome</th>
        <th>Apelido</th>
        <th>Endereço</th>
        <th>Contacto</th>
        <th>Turma</th>
        <th>Curso</th>
                    <th>Realizações</th>
        <th>Ações</th>
    </tr>
    <% 
        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> listaEstudantes = estudanteDAO.listarEstudantesComTurma();
        for (Estudante estudante : listaEstudantes) { %>
        <%
            CursoDAO cursoDAO = new CursoDAO();
        turmaDAO.listarTurmasComCurso();
        
        %>
        <tr>
            <td><%= estudante.getNrMatricula() %></td>
            <td><%= estudante.getNome() %></td>
            <td><%= estudante.getApelido() %></td>
            <td><%= estudante.getEndereco() %></td>
            <td><%= estudante.getContacto() %></td>    
           <td><%= estudante.getTurma() != null ? estudante.getTurma().getNome() : "Turma não definida" %></td>
  <td><%= estudante.getTurma().getCurso().getNome() %></td> 
           <td>
    <button onclick="preencherFormulario('<%= estudante.getNrMatricula() %>', '<%= estudante.getNome() %>', '<%= estudante.getApelido() %>', '<%= estudante.getEndereco() %>', '<%= estudante.getContacto() %>', '<%= estudante.getTurma() != null ? estudante.getTurma().getId() : "" %>')">Editar</button>
    <form action="EstudanteServlet?action=delete" method="post">
        <input type="hidden" name="nrMatricula" value="<%= estudante.getNrMatricula() %>">
        <input type="submit" value="Apagar">
    </form>
</td>
</tr>
<% } %>
</table>

<h1>Editar Estudante</h1>
<form action="EstudanteServlet?action=edit" method="post">
    <input type="hidden" id="edit_nrMatricula" name="nrMatricula">
    Nome: <input type="text" id="edit_nome" name="nome" required><br>
    Apelido: <input type="text" id="edit_apelido" name="apelido" required><br>
    Endereço: <input type="text" id="edit_endereco" name="endereco" required><br>
    Contacto: <input type="text" id="edit_contacto" name="contacto" required><br>
    <label for="edit_idTurma">Turma:</label>
    <select id="edit_idTurma" name="idTurma">
        <%-- Listar todas as turmas disponíveis --%>
        <% 
             turmaDAO = new TurmaDAO();
            List<Turma> turmass = turmaDAO.listarTurmas();
            for (Turma turma : turmass) { %>
                <option value="<%= turma.getId() %>"><%= turma.getNome() %></option>
            <% } %>
    </select>
    <input type="submit" value="Atualizar">
</form>

</body>
</html>

