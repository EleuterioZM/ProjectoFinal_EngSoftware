<%@page import="Model.Turma"%>
<%@page import="java.util.List"%>
<%@page import="Model.Curso"%>
<%@page import="DAO.CursoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes da Turma</title>
</head>
<body>

<h1>Detalhes da Turma</h1>

<%
    Turma turma = (Turma) request.getAttribute("turma");
    if (turma != null) {
%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Curso</th>
    </tr>
    <tr>
        <td><%= turma.getId() %></td>
        <td><%= turma.getNome() %></td>
        <td><%= turma.getCurso().getNome() %></td>
    </tr>
</table>

<%
    } else {
%>

<p>Nenhuma turma encontrada com o ID fornecido.</p>

<%
    }
%>

<a href="TurmaServlet">Voltar para a lista de turmas</a>

</body>
</html>
