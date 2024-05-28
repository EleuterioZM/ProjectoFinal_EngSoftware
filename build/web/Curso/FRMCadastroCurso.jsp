<%-- 
    Document   : FRMCurso
    Created on : 11-May-2024, 16:47:26
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar">
        <%@ include file="../Dashboard/Dashboard.jsp" %>
    </div>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cadastrar Curso</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel="stylesheet" href="../css/Estudantes.css">
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
                Cadastro de Curso
            </div>
            <form action="${pageContext.request.contextPath}/CursoServlet?action=add" method="post">

                <div class="form-row">
                    <div class="input-data">
                        <input type="text" name="nome" required>
                        <div class="underline"></div>
                        <label for="nome">Nome do Curso</label>
                    </div>
                </div>
                <div class="form-row submit-btn">
                    <div class="input-data">
                        <div class="inner"></div>
                        <input type="submit" value="Cadastrar">
                    </div>
                </div>
            </form>
            <%--<p>${message}</p>
            <a href="${pageContext.request.contextPath}/CursoServlet">Voltar à lista</a>--%>
        </div>
    </body>
</html>
