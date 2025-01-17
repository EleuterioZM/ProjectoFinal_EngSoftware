<%@page import="Model.Turma"%>
<%@page import="java.util.List"%>
<%@page import="DAO.TurmaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar">

</div>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cadastrar Estudante</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <!-- Adicionando o Font Awesome CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">


        <link rel="stylesheet" href="../css/Estudantes.css">
        <script src="../js/alertas.js"></script>
        <style>

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
                Cadastro de Estudante
            </div>
            <form id="estudanteForm" action="/ProjectoFinalEngSoftware/EstudanteServlet?action=add" method="post">


                <div class="form-row">
                    <div class="input-data">
                        <input type="text" name="nome" required>
                        <div class="underline"></div>
                        <label for="">Nome</label>
                    </div>
                    <div class="input-data">
                        <input type="text" name="apelido" required>
                        <div class="underline"></div>
                        <label for="">Apelido</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="input-data">
                        <input type="text" name="endereco" required>
                        <div class="underline"></div>
                        <label for="">Endereço</label>
                    </div>
                    <div class="input-data">
                        <input type="text" name="contacto" required>
                        <div class="underline"></div>
                        <label for="">Contacto</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="input-data">
                        <select name="idTurma" required>
                            <option value="" disabled selected>Selecione a Turma</option>
                            <%
                                TurmaDAO turmaDAO = new TurmaDAO();
                                List<Turma> turmas = turmaDAO.listarTurmas();
                                for (Turma turma : turmas) {%>
                            <option value="<%= turma.getId()%>"><%= turma.getNome()%></option>
                            <% }%>
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
        <a href="FRMListarEstudantes.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
            <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 30px; color: white;"></i>
        </a>
    </body>
</html>
