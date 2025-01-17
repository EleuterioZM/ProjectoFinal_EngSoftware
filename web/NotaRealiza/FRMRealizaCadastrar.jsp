<%@page import="Model.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page import="DAO.AvaliacaoDAO"%>
<%@page import="Model.Estudante"%>
<%@page import="DAO.EstudanteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar">

</div>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Realizar Avaliação</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <!-- Você pode precisar ajustar o caminho para o seu arquivo CSS -->
        <link rel="stylesheet" href="../css/Estudantes.css">
        <!-- Adicionando o Font Awesome CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">


        <style>
            /* Adiciona um estilo para colocar os elementos em linha */
            .form-row {
                display: flex;
                justify-content: space-between;
            }

            .sidebar {


                position: fixed;
                top: 0;
                left: 0;
                bottom: 0;
                overflow-y: auto;
            }
            .content {
                flex: 1;
                margin-left: 140px; /* Largura do dashboard */
                padding-top: 70px; /* Espaçamento do topo */
            }


        </style>
    </head>
    <body>
        <div class="container">
            <div class="text">
                Adicionar Avaliação
            </div>
            <form action="${pageContext.request.contextPath}/RealizaServlet?action=add" method="post">


                <div class="form-row">
                    <div class="input-data">
                        <input type="number" name="nota" step="0.1" min="0" max="20" required>
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
                            <option value="<%= avaliacao.getId()%>"><%= avaliacao.getDescricao()%></option>
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
                            <option value="<%= estudante.getNrMatricula()%>"><%= estudante.getNome()%></option>
                            <% }%>
                        </select>
                    </div>
                </div>



                <div class="form-row submit-btn">
                    <div class="input-data">
                        <div class="inner"></div>
                        <input type="submit" value="Enviar Avaliação">
                    </div>
                </div>
            </form>
        </div>
        <a href="FRMListarRealizas.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
            <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 30px; color: white;"></i>
        </a>             
    </body>
</html>
