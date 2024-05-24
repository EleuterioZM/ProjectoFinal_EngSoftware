<%@page import="DAO.DisciplinaDAO"%>
<%@page import="Model.Disciplina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem de Disciplinas</title>
    <!-- Adicione aqui os links para os arquivos CSS do Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Adicione aqui os links para os arquivos CSS de ícones, como Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #ff9966; /* Cor de fundo */
        }
    </style>
   
</head>
<body>
     <div class="container mt-4">
    <%-- Exibir mensagens de sucesso ou erro --%>
    <c:choose>
        <c:when test="${param.message == 'deleteSuccess'}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Disciplina excluída com sucesso!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:when>
        <c:when test="${param.message == 'updateSuccess'}">
            <div class="alert alert-info alert-dismissible fade show" role="alert">
              Disciplina actualizada com sucesso!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:when>
      
        <c:when test="${param.message == 'addSuccess'}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Disciplina  cadastrada com sucesso.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:when>
        
    </c:choose>
</div>
<div class="container">
    <h1 class="mt-4" style="color:white">Listagem de Disciplinas</h1>
    <div class="text-right mb-4">
        <a href="${pageContext.request.contextPath}/Disciplina/FRMCadastroDisciplina.jsp" class="btn btn-success">Adicionar Disciplina</a>
    </div>
    <table class="table table-striped mt-4 table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">CHS</th>
            <th scope="col">Crédito</th>
            <th scope="col">Ações</th>
        </tr>
        </thead>
        <tbody>
        <%
            int pageSizeDisciplina = 6;
            int currentPageDisciplina = (request.getParameter("pageDisciplina") != null) ? Integer.parseInt(request.getParameter("pageDisciplina")) : 1;
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            List<Disciplina> listaDisciplinas = disciplinaDAO.listarDisciplinas();
            int totalDisciplinas = listaDisciplinas.size();
            int totalPagesDisciplina = (int) Math.ceil((double) totalDisciplinas / pageSizeDisciplina);
            int startIndexDisciplina = (currentPageDisciplina - 1) * pageSizeDisciplina;
            int endIndexDisciplina = Math.min(startIndexDisciplina + pageSizeDisciplina, totalDisciplinas);
            int countDisciplina = startIndexDisciplina;
            for (Disciplina disciplina : listaDisciplinas.subList(startIndexDisciplina, endIndexDisciplina)) {
                countDisciplina++;
        %>
        <tr>
            <td><%= countDisciplina %></td>
            <td><%= disciplina.getNome() %></td>
            <td><%= disciplina.getChs() %></td>
            <td><%= disciplina.getCredito() %></td>
            <td>
              
                    <a href="${pageContext.request.contextPath}/DisciplinaServlet?action=visualizar&nome=<%= disciplina.getNome() %>&chs=<%= disciplina.getChs() %>&credito=<%= disciplina.getCredito() %>" class="btn btn-success btn-sm">
    <i class="fas fa-eye"></i>
</a>

                <a href="${pageContext.request.contextPath}/DisciplinaServlet?action=edit&id=<%= disciplina.getId() %>" class="btn btn-primary btn-sm">
                    <i class="fas fa-edit"></i>
                </a>
                <a href="${pageContext.request.contextPath}/Disciplina/FRMExclusaoDisciplina.jsp?id=<%= disciplina.getId()%>&nome=<%= disciplina.getNome()%>" class="btn btn-danger btn-sm">
                    <i class="fas fa-trash"></i> <!-- Ícone de exclusão -->
                </a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item <%= (currentPageDisciplina == 1) ? "disabled" : ""%>">
                <a class="page-link" href="?pageDisciplina=<%= currentPageDisciplina - 1%>">Anterior</a>
            </li>
            <% for (int i = 1; i <= totalPagesDisciplina; i++) {%>
            <li class="page-item <%= (i == currentPageDisciplina) ? "active" : ""%>">
                <a class="page-link" href="?pageDisciplina=<%= i%>"><%= i%></a>
            </li>
            <% } %>
            <li class="page-item <%= (currentPageDisciplina == totalPagesDisciplina || totalPagesDisciplina == 0) ? "disabled" : ""%>">
                <a class="page-link" href="?pageDisciplina=<%= currentPageDisciplina + 1%>">Próximo</a>
            </li>
        </ul>
    </nav>
</div>
<!-- Adicione aqui os scripts necessários, como o Bootstrap e o Font Awesome -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script>
    // Esconder alertas após 5 segundos
    $(document).ready(function(){
        $(".alert").each(function(index, element) {
            var alert = $(element);
            setTimeout(function() {
                alert.alert('close');
            }, 5000);
        });
    });
</script>
</body>
</html>
