<%@page import="Model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Editar Turma</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <!-- Ajuste o caminho para o seu arquivo CSS -->
        <link rel="stylesheet" href="../css/Estudantes.css">
    </head>
    <body>
        <div class="container">
            <div class="text">
                Edição de Turma
            </div>
            <form action="${pageContext.request.contextPath}/TurmaServlet?action=update" method="post">
                <input type="hidden" name="id" value="${param.id}">
                <div class="form-row">
                    <div class="input-data">
                        <input type="text" name="nome" required value="<%= request.getParameter("nome")%>">
                        <div class="underline"></div>
                        <label for="nome">Nome da Turma</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="input-data">
                        <select name="idCurso" required>
                            <option value="">Selecione um curso</option>
                            <%
                                CursoDAO cursoDAO = new CursoDAO();
                                List<Curso> cursos = cursoDAO.listarCursos();
                                for (Curso curso : cursos) {
                                    // Verificando se o parâmetro "idCurso" está presente e se corresponde ao ID do curso atual
                                    String selected = "";
                                    if (request.getParameter("idCurso") != null && request.getParameter("idCurso").equals(String.valueOf(curso.getId()))) {
                                        selected = "selected";
                                    }
                            %>
                            <option value="<%= curso.getId()%>" <%= selected%>><%= curso.getNome()%></option>
                            <% }%>
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
