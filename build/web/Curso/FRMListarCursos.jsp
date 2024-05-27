<%@page import="DAO.CursoDAO"%>
<%@page import="Model.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listagem de Cursos</title>
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
                        Curso excluído com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>
                <c:when test="${param.message == 'updateSuccess'}">
                    <div class="alert alert-info alert-dismissible fade show" role="alert">
                        Curso actualizado com sucesso!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>

                <c:when test="${param.message == 'addSuccess'}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        Curso  cadastrado com sucesso.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:when>

            </c:choose>
        </div>
        <div class="container">
            <h1 class="mt-4" style="color:white">Listagem de Cursos</h1>


            <div class="text-right mb-4">
                
            <a href="${pageContext.request.contextPath}/CursoServlet?action=report" class="btn btn-info">Gerar Relatório</a>


                <a href="${pageContext.request.contextPath}/Curso/FRMCadastroCurso.jsp" class="btn btn-success">Adicionar Curso</a>
            </div>

            <table class="table table-striped mt-4 table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int pageSize = 6;
                        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
                        CursoDAO cursoDAO = new CursoDAO();
                        List<Curso> listaCursos = cursoDAO.listarCursos();
                        int totalCursos = listaCursos.size();
                        int totalPages = (int) Math.ceil((double) totalCursos / pageSize);
                        int startIndex = (currentPage - 1) * pageSize;
                        int endIndex = Math.min(startIndex + pageSize, totalCursos);
                        int count = startIndex;
                        for (Curso curso : listaCursos.subList(startIndex, endIndex)) {
                            count++;
                    %>
                    <tr>
                        <td><%= count%></td>
                        <td><%= curso.getId()%></td>
                        <td><%= curso.getNome()%></td>
                        <td>

                            <a href="javascript:void(0);" onclick="editarCurso(<%= curso.getId()%>, '<%= curso.getNome()%>')" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i></a>

                            <a href="${pageContext.request.contextPath}/Curso/FRMExclusaoCurso.jsp?id=<%= curso.getId()%>&nome=<%= curso.getNome()%>" class="btn btn-danger btn-sm">
                                <i class="fas fa-trash"></i> <!-- Ícone de exclusão -->
                            </a>
                        <td>

                        </td>
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

                               function editarCurso(cursoId, cursoNome) {
                                   window.location.href = "${pageContext.request.contextPath}/CursoServlet?action=edit&id=" + cursoId + "&nome=" + cursoNome;
                               }

        </script>
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
