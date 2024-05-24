<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Editar Curso</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Estudantes.css">
</head>
<body>
<div class="container">
    <div class="text">
        Edição de Curso
    </div>
    <form action="${pageContext.request.contextPath}/CursoServlet?action=update" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div class="form-row">
            <div class="input-data">
                <!-- Corrigindo aqui para pegar o nome do curso -->
                <input type="text" name="nome" required value="${cursoNome}">
                <div class="underline"></div>
                <label for="nome">Nome do Curso</label>
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
