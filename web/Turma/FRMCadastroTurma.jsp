<%-- 
    Document   : FRMTurma
    Created on : [Date]
    Author     : [Author]
--%>

<%@page import="Model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cadastrar Turma</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <!-- You might need to adjust the path to your CSS file -->
  <link rel="stylesheet" href="../css/Estudantes.css">
</head>
<body>
<div class="container">
    <div class="text">
        Cadastro de Turma
    </div>
    <form action="${pageContext.request.contextPath}/TurmaServlet?action=add" method="post">

        <div class="form-row">
            <div class="input-data">
                <input type="text" name="nome" required>
                <div class="underline"></div>
                <label for="nome">Nome da Turma</label>
            </div>
        </div>
        <div class="form-row">
            <div class="input-data">
                <!-- Adjust the select tag according to your requirements -->
                <select name="idCurso" required>
                    <option value="">Selecione um curso</option>
                    <%-- Here you can populate the dropdown with courses from your database --%>
                    <% 
                        CursoDAO cursoDAO = new CursoDAO();
                        List<Curso> cursos = cursoDAO.listarCursos();
                        for (Curso curso : cursos) { 
                    %>
                    <option value="<%= curso.getId() %>"><%= curso.getNome() %></option>
                    <% } %>
                </select>
                <div class="underline"></div>
           
            </div>
        </div>
        <div class="form-row submit-btn">
            <div class="input-data">
                <div class="inner"></div>
                <input type="submit" value="Cadastrar">
            </div>
        </div>
    </form>
</div>
</body>
</html>
