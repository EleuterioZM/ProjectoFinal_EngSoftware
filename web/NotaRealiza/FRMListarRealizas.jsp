<%@page import="Model.Realiza"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RealizaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Realizações de Avaliação</title>
        <!-- Adicione aqui os links para os arquivos CSS do Bootstrap -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
             <link rel="stylesheet" type="text/css" href="../includes/bootstrap.css" />
        <link href="../includes/style.css" rel="stylesheet" />
         <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
     <style>
            body {
                background-color: #ff9966; /* Cor de fundo */
            }
        </style>

    </head>
    <body>
       <%@include file="../includes/menu.jsp" %>
          
        <div class="container mt-4">
            <%-- Exibir mensagens de sucesso ou erro --%>
            <c:choose>
                <c:when test="${param.message == 'deleteSuccess'}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Realização excluída com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'updateSuccess'}">
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        Realização actualizada com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'invalidId'}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Formato de ID inválido.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'addSuccess'}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Realização de avaliação cadastrada com sucesso.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'addError'}">
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Erro ao cadastrar a realização.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
            </c:choose>
        </div>
        <div class="container">
            <h1 class="mt-4" style="color:white">Listagem de Realizações</h1>
            <div class="text-right mb-4">
                 <a href="${pageContext.request.contextPath}/RealizaServlet?action=generateReport" class="btn btn-info">Gerar Relatório</a>
                <a href="${pageContext.request.contextPath}/NotaRealiza/FRMRealizaCadastrar.jsp" class="btn btn-success">Adicionar Nota</a>
            </div>
            <table class="table table-striped mt-4 table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID da Avaliação</th>
                        <th scope="col">ID do Estudante</th>
                        <th scope="col">Nota</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                         int pageSize = 5;
                        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
                       
                        RealizaDAO realizaDAO = new RealizaDAO();
                        List<Realiza> listaRealizacoes = realizaDAO.listarRealizacoes();
                         int totalRealizacoes = listaRealizacoes.size();
                        int totalPages = (int) Math.ceil((double) totalRealizacoes / pageSize);
                        int startIndex = (currentPage - 1) * pageSize;
                        int endIndex = Math.min(startIndex + pageSize, totalRealizacoes);
                        int count = startIndex;
                         for (Realiza realizacao : listaRealizacoes.subList(startIndex, endIndex)) {
                            count++;
                   
                    %>
                    <tr>
                        <td><%= count%></td>
                        <td><%= realizacao.getId().getIdAvaliacao()%></td>
                        <td><%= realizacao.getId().getIdEstudante()%></td>
                        <td><%= realizacao.getNota()%></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/RealizaServlet?action=visualizar&idEstudante=<%= realizacao.getId().getIdEstudante()%>&idAvaliacao=<%= realizacao.getId().getIdAvaliacao()%>&nota=<%= realizacao.getNota()%>" class="btn btn-success btn-sm">
                                <i class="fas fa-eye"></i>
                            </a>
                            <a href="${pageContext.request.contextPath}/RealizaServlet?action=edit&idEstudante=<%= realizacao.getId().getIdEstudante()%>&idAvaliacao=<%= realizacao.getId().getIdAvaliacao()%>&nota=<%= realizacao.getNota()%>" class="btn btn-primary btn-sm">
                                <i class="fas fa-edit"></i>
                            </a>
                            <a href="${pageContext.request.contextPath}/NotaRealiza/FRMExclusaoRealiza.jsp?idEstudante=<%= realizacao.getId().getIdEstudante()%>&idAvaliacao=<%= realizacao.getId().getIdAvaliacao()%>&nota=<%= realizacao.getNota()%>" class="btn btn-danger btn-sm">
                                <i class="fas fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
                 <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item <%= (currentPage == 1) ? "disabled" : ""%>">
                        <a class="page-link" href="?page=<%= currentPage - 1%>">Anterior</a>
                    </li>
                    <% for (int i = 1; i <= totalPages; i++) {%>
                    <li class="page-item <%= (i == currentPage) ? "active" : ""%>">
                        <a class="page-link" href="?page=<%= i%>"><%= i%></a>
                    </li>
                    <% }%>
                    <li class="page-item <%= (currentPage == totalPages || totalPages == 0) ? "disabled" : ""%>">
                        <a class="page-link" href="?page=<%= currentPage + 1%>">Próximo</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- Adicione aqui os scripts necessários, como o Bootstrap e o Font Awesome -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            // Esconder alertas após 5 segundos
            $(document).ready(function () {
                $(".alert").each(function (index, element) {
                    var alert = $(element);
                    setTimeout(function () {
                        alert.alert('close');
                    }, 5000);
                });
            });
        </script>

  <script src="../includes/jquery.js"></script>
 
        <script src="../includes/custom.js"></script>
    </body>
</html>
