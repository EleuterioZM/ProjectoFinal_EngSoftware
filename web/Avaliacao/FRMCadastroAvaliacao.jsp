<%-- 
    Document   : FRMAvalicao
    Created on : 11-May-2024, 16:36:04
    Author     : User
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cadastrar Avaliação</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
         <!-- Adicionando o Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <link rel="stylesheet" href="../css/Estudantes.css">

 

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
            <a href="FRMListarAvaliacoes.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
        <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 30px; color: white;"></i>
    </a>

    </body>
</html>
