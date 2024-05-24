<%@page import="Model.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page import="DAO.AvaliacaoDAO"%>
<%@page import="Model.Estudante"%>
<%@page import="DAO.EstudanteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Realizar Avaliação</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Estudantes.css">
        <style>
            /* Adiciona um estilo para colocar os elementos em linha */
            .form-row {
                display: flex;
                justify-content: space-between;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="text">
                Realizar Avaliação
            </div>
            <form action="${pageContext.request.contextPath}/RealizaServlet?action=update" method="post">
                <div class="form-row">
                    <div class="input-data">
                        <input type="number" name="nota" step="0.1" min="0" max="20" required value="${param.nota}">
                        <div class="underline"></div>
                        <label for="nota">Nota:</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="input-data">
                        <select name="idAvaliacao" required>
                            <option value="" disabled selected>Selecione a Avaliação</option>
                            <%
                                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                                List<Avaliacao> avaliacoes = avaliacaoDAO.listarAvaliacoes();
                                for (Avaliacao avaliacao : avaliacoes) {%>
                            <option value="<%= avaliacao.getId()%>" <% if (avaliacao.getId() == Integer.parseInt(request.getParameter("idAvaliacao"))) { %> selected <% }%>><%= avaliacao.getDescricao()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="input-data">
                        <select name="idEstudante" required>
                            <option value="" disabled selected>Selecione o Estudante</option>
                            <%
                                EstudanteDAO estudanteDAO = new EstudanteDAO();
                                List<Estudante> estudantes = estudanteDAO.listarEstudantes();
                                for (Estudante estudante : estudantes) {%>
                            <option value="<%= estudante.getNrMatricula()%>" <% if (estudante.getNrMatricula() == Integer.parseInt(request.getParameter("idEstudante"))) { %> selected <% }%>><%= estudante.getNome()%></option>
                            <% }%>
                        </select>
                    </div>
                </div>
                <!-- Adicione aqui campos adicionais, se necessário -->
                <div class="form-row submit-btn">
                    <div class="input-data">
                        <div class="inner"></div>
                        <input type="submit" value="Enviar Avaliação">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
