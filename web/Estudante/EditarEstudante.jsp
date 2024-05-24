<%@page import="Model.Turma"%>
<%@page import="java.util.List"%>
<%@page import="DAO.TurmaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Editar Estudante</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="../css/Estudantes.css">
  <script src="../js/alertas.js"></script>
</head>
<body>
<div class="container">
    <div class="text">
        Edição de Estudante
    </div>
    <form id="estudanteForm" action="/ProjectoFinalEngSoftware/EstudanteServlet?action=update" method="post">
        <input type="hidden" name="nrMatricula" value="${param.nrMatricula}">
        <div class="form-row">
            <div class="input-data">
                <input type="text" name="nome" required value="${param.nome}">
                <div class="underline"></div>
                <label for="">Nome</label>
            </div>
            <div class="input-data">
                <input type="text" name="apelido" required value="${param.apelido}">
                <div class="underline"></div>
                <label for="">Apelido</label>
            </div>
        </div>
        <div class="form-row">
            <div class="input-data">
                <input type="text" name="endereco" required value="${param.endereco}">
                <div class="underline"></div>
                <label for="">Endereço</label>
            </div>
            <div class="input-data">
                <input type="text" name="contacto" required value="${param.contacto}">
                <div class="underline"></div>
                <label for="">Contacto</label>
            </div>
        </div>
        <div class="form-row">
            <div class="input-data">
                <select name="idTurma" required>
                    <option value="" disabled>Selecione a Turma</option>
                    <%
                        TurmaDAO turmaDAO = new TurmaDAO();
                        List<Turma> listaTurmas = turmaDAO.listarTurmas();
                        int idTurmaSelecionada = Integer.parseInt(request.getParameter("idTurma"));
                        for (Turma turma : listaTurmas) {
                            String selected = (turma.getId() == idTurmaSelecionada) ? "selected" : "";
                    %>
                    <option value="<%= turma.getId() %>" <%= selected %>><%= turma.getNome() %></option>
                    <% } %>
                </select>
                <div class="underline"></div>
          
            </div>
        </div>
        <div class="form-row submit-btn">
            <div class="input-data">
                <div class="inner"></div>
                <input type="submit" value="Salvar Alterações">
            </div>
        </div>
    </form>
</div>
</body>
</html>
