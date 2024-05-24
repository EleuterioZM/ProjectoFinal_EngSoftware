<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exclusão de Avaliação</title>

        <style>
            body {
                font-family: Arial, sans-serif;
            }

            .modal-container {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 120%;
                display: flex;
                justify-content: center;
                align-items: center;
                background-image: url('../img/avaliacao.jpg'); /* Caminho da sua imagem de fundo */
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

            /* Estilo para o botão Confirmar */
            .confirm-button {
                background-color: #f44336; /* Cor vermelha */
                color: white;
                margin-right: 10px; /* Adiciona um espaçamento à direita */
            }

            /* Estilo para o botão Cancelar */
            .cancel-button {
                background-color: #4CAF50; /* Cor verde */
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="modal-container">
            <div class="modal-content">
                <h2>Exclusão de Avaliação</h2>
                <p>Deseja realmente excluir a avaliação "<%= request.getParameter("nome")%>"?</p>
                <form id="deleteForm" action="${pageContext.request.contextPath}/AvaliacaoServlet?action=delete" method="POST">
                    <input type="hidden" id="avaliacaoId" name="id" value="<%= request.getParameter("id")%>">
                    <input type="hidden" id="avaliacaoNome" name="nome" value="<%= request.getParameter("nome")%>">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" class="confirm-button" onclick="logFormData()">Confirmar Exclusão</button>
                    <button type="button" class="cancel-button" onclick="fecharModal()">Cancelar</button>
                </form>
            </div>
        </div>

        <script>
            function fecharModal() {
                window.location.href = "${pageContext.request.contextPath}/Avaliacao/FRMListarAvaliacoes.jsp"; // Redirecionar de volta para a página de listagem
            }
        </script>

        <script>
            function logFormData() {
                var id = document.getElementById("avaliacaoId").value;
                var nome = document.getElementById("avaliacaoNome").value;

                console.log("ID da avaliação: ", id);
                console.log("Nome da avaliação: ", nome);

                // Retorna true para permitir a submissão do formulário
                return true;
            }
        </script>
    </body>
</html>
