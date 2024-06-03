<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Estudantes</title>
</head>
<body>
     <form action="EstudanteServlet" method="post">
                <input type="hidden" name="action" value="listar">
                <button type="submit" class="btn btn-primary">Listar</button>
            </form>
    <h2>Lista de Estudantes</h2>
    <table border="1">
        <tr>
            <th>Número de Matrícula</th>
            <th>Nome</th>
            <th>Apelido</th>
            <th>Endereço</th>
            <th>Contato</th>
            <th>Turma</th>
            <th>Curso</th>
        </tr>
        <c:forEach var="estudante" items="${listaEstudantes}">
            <tr>
                <td>${estudante.nrMatricula}</td>
                <td>${estudante.nome}</td>
                <td>${estudante.apelido}</td>
                <td>${estudante.endereco}</td>
                <td>${estudante.contacto}</td>
                <td><c:choose>
                    <c:when test="${not empty estudante.turma}">
                        ${estudante.turma.nome}
                    </c:when>
                    <c:otherwise>
                        N/A
                    </c:otherwise>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${not empty estudante.turma && not empty estudante.turma.curso}">
                        ${estudante.turma.curso.nome}
                    </c:when>
                    <c:otherwise>
                        N/A
                    </c:otherwise>
                </c:choose></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>