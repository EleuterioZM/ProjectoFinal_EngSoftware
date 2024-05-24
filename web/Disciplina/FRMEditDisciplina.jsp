<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Editar Disciplina</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Estudantes.css">
</head>
<body>
<div class="container">
    <div class="text">
        Edição de Disciplina
    </div>
    <form action="${pageContext.request.contextPath}/DisciplinaServlet?action=update" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div class="form-row">
            <div class="input-data">
                <input type="text" name="nome" required value="${param.nome}">
                <div class="underline"></div>
                <label for="nome">Nome da Disciplina</label>
            </div>
            <div class="input-data">
                <input type="number" name="chs" required value="${param.chs}">
                <div class="underline"></div>
                <label for="chs">Carga Horária Semanal</label>
            </div>
        </div>
        <div class="form-row">
            <div class="input-data">
                <input type="number" name="credito" required value="${param.credito}">
                <div class="underline"></div>
                <label for="credito">Crédito</label>
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
