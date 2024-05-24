<%@page import="DAO.AvaliacaoDAO"%>
<%@page import="Model.Avaliacao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Avaliações</title>
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
                        Avaliacao excluída com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'updateSuccess'}">
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        Avaliacao actualizada com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>

                <c:when test="${param.message == 'addSuccess'}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Avaliacao  cadastrada com sucesso.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>

            </c:choose>
        </div>
        <div class="container">
            <h1 class="mt-4" style="color:white">Listagem de Avaliações</h1>

            <div class="text-right mb-4">

                <a href="${pageContext.request.contextPath}/Avaliacao/FRMCadastroAvaliacao.jsp" class="btn btn-success">Adicionar Curso</a>
            </div>
            <table class="table table-striped mt-4 table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Peso</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int pageSizeAvaliacao = 6;
                        int currentPageAvaliacao = (request.getParameter("pageAvaliacao") != null) ? Integer.parseInt(request.getParameter("pageAvaliacao")) : 1;
                        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                        List<Avaliacao> listaAvaliacoes = avaliacaoDAO.listarAvaliacoes();
                        int totalAvaliacoes = listaAvaliacoes.size();
                        int totalPagesAvaliacao = (int) Math.ceil((double) totalAvaliacoes / pageSizeAvaliacao);
                        int startIndexAvaliacao = (currentPageAvaliacao - 1) * pageSizeAvaliacao;
                        int endIndexAvaliacao = Math.min(startIndexAvaliacao + pageSizeAvaliacao, totalAvaliacoes);
                        int countAvaliacao = startIndexAvaliacao;
                        for (Avaliacao avaliacao : listaAvaliacoes.subList(startIndexAvaliacao, endIndexAvaliacao)) {
                            countAvaliacao++;
                    %>
                    <tr>
                        <td><%= countAvaliacao%></td>
                        <td><%= avaliacao.getDescricao()%></td>
                        <td><%= avaliacao.getPeso()%></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/AvaliacaoServlet?action=visualizar&id=<%= avaliacao.getId()%>" class="btn btn-success btn-sm">
                                <i class="fas fa-eye"></i>
                            </a>

                            <a href="${pageContext.request.contextPath}/AvaliacaoServlet?action=edit&id=<%= avaliacao.getId()%>" class="btn btn-primary btn-sm">
                                <i class="fas fa-edit"></i>
                            </a> 

                            <a href="${pageContext.request.contextPath}/Avaliacao/FRMExclusaoAvaliacao.jsp?id=<%= avaliacao.getId()%>&nome=<%= avaliacao.getDescricao()%>" class="btn btn-danger btn-sm">
                                <i class="fas fa-trash"></i> <!-- Ícone de exclusão -->
                            </a> </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item <%= (currentPageAvaliacao == 1) ? "disabled" : ""%>">
                        <a class="page-link" href="?pageAvaliacao=<%= currentPageAvaliacao - 1%>">Anterior</a>
                    </li>
                    <% for (int i = 1; i <= totalPagesAvaliacao; i++) {%>
                    <li class="page-item <%= (i == currentPageAvaliacao) ? "active" : ""%>">
                        <a class="page-link" href="?pageAvaliacao=<%= i%>"><%= i%></a>
                    </li>
                    <% }%>
                    <li class="page-item <%= (currentPageAvaliacao == totalPagesAvaliacao || totalPagesAvaliacao == 0) ? "disabled" : ""%>">
                        <a class="page-link" href="?pageAvaliacao=<%= currentPageAvaliacao + 1%>">Próximo</a>
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
    </body>
</html>
