<%-- 
    Document   : FRMAvalicao
    Created on : 11-May-2024, 16:36:04
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
        <title>Cadastrar Avaliação</title>
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
                Cadastro de Avaliação
            </div>

            <form action="${pageContext.request.contextPath}/AvaliacaoServlet?action=add" method="post">

                <div class="form-row">
                    <div class="input-data">
                        <input type="text" required name="descricao">
                        <div class="underline"></div>
                        <label for="">Descrição</label>
                    </div>
                    <div class="input-data">
                        <input type="number" step="0.01" name="peso" required>
                        <div class="underline"></div>
                        <label for="">Peso</label>
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


    </body>
</html>
