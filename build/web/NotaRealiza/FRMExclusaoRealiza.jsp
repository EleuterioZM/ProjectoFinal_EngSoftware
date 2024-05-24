<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exclusão de Realização</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .modal-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url('../img/realiza.jpg'); /* Caminho da sua imagem de fundo */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            backdrop-filter: blur(5px); /* Adiciona um efeito de desfoque ao fundo */
        }
        .modal-content {
            background-color: rgba(255, 255, 255, 0.8); /* Cor de fundo semi-transparente */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            width: 100%;
            text-align: center;
        }
        .modal-content h2 {
            margin-top: 0;
        }
        .modal-content p {
            margin-bottom: 20px;
        }
        .modal-content button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .confirm-button {
            background-color: #f44336; /* Cor vermelha */
            color: white;
            margin-right: 10px; /* Adiciona um espaçamento à direita */
        }
        .cancel-button {
            background-color: #4CAF50; /* Cor verde */
            color: white;
        }
    </style>
</head>
<body>
    <div class="modal-container">
        <div class="modal-content">
            <h2>Exclusão de Realização</h2>
            <p>Deseja realmente excluir esta realização?</p>
            <form id="deleteForm" action="${pageContext.request.contextPath}/RealizaServlet" method="POST">
                <input type="hidden" id="idEstudante" name="idEstudante" value="<%= request.getParameter("idEstudante") %>">
                <input type="hidden" id="idAvaliacao" name="idAvaliacao" value="<%= request.getParameter("idAvaliacao") %>">
                <input type="hidden" id="nota" name="nota" value="<%= request.getParameter("nota") %>">
                <input type="hidden" name="action" value="delete">
                <button type="submit" class="confirm-button" onclick="logFormData()">Confirmar Exclusão</button>
                <button type="button" class="cancel-button" onclick="fecharModal()">Cancelar</button>
            </form>
        </div>
    </div>

    <script>
        function fecharModal() {
            window.location.href = "${pageContext.request.contextPath}/RealizaServlet"; // Redirecionar de volta para o servlet
        }
        
        function logFormData() {
            var idEstudante = document.getElementById("idEstudante").value;
            var idAvaliacao = document.getElementById("idAvaliacao").value;
            var nota = document.getElementById("nota").value;
            
            console.log("ID do Estudante: ", idEstudante);
            console.log("ID da Avaliação: ", idAvaliacao);
            console.log("Nota: ", nota);

            // Retorna true para permitir a submissão do formulário
            return true;
        }
    </script>
</body>
</html>
