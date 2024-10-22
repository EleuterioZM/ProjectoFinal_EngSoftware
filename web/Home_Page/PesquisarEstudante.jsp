<%@page import="DAO.EstudanteDAO"%>
<%@page import="java.util.List"%>
<%@page import="Model.Estudante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pesquisar Estudante</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/Estudantes.css"> <!-- Este é o estilo da página de cadastro de estudantes -->
         <!-- Adicionando o Font Awesome CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <style>
            * {
                border: 0;
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }
            :root {
                font-size: calc(16px + (24 - 16)*(100vw - 320px)/(1920 - 320));
            }
            body, button, input {
                font: 1em Hind, sans-serif;
                line-height: 1.5em;
            }
            body, input {
                color: #f1f1f1;
            }
            body, .search-bar {
                display: flex;
            }
            body {
                background: #ff9966;
                
                height: 100vh;
            }
            .search-bar input,
            .search-btn, 
            .search-btn:before, 
            .search-btn:after {
                transition: all 0.25s ease-out;
            }
            .search-bar input,
            .search-btn {
                width: 3em;
                height: 3em;
            }
            .search-bar input:invalid:not(:focus),
            .search-btn {
                cursor: pointer;
            }
            .search-bar,
            .search-bar input:focus,
            .search-bar input:valid  {
                width: 100%;
            }
            .search-bar input:focus,
            .search-bar input:not(:focus) + .search-btn:focus {
                outline: transparent;
            }
            .search-bar {
                margin: auto;
                padding: 1.5em;
                justify-content: center;
                max-width: 30em;
            }
            .search-bar input {
                background: transparent;
                border-radius: 1.5em;
                box-shadow: 0 0 0 0.4em #171717 inset;
                padding: 0.75em;
                transform: translate(0.5em,0.5em) scale(0.5);
                transform-origin: 100% 0;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }
            .search-bar input::-webkit-search-decoration {
                -webkit-appearance: none;
            }
            .search-bar input:focus,
            .search-bar input:valid {
                background: #fff;
                border-radius: 0.375em 0 0 0.375em;
                box-shadow: 0 0 0 0.1em #d9d9d9 inset;
                transform: scale(1);
            }
            .search-btn {
                background: #171717;
                border-radius: 0 0.75em 0.75em 0 / 0 1.5em 1.5em 0;
                padding: 0.75em;
                position: relative;
                transform: translate(0.25em,0.25em) rotate(45deg) scale(0.25,0.125);
                transform-origin: 0 50%;
            }
            .search-btn:before, 
            .search-btn:after {
                content: "";
                display: block;
                opacity: 0;
                position: absolute;
            }
            .search-btn:before {
                border-radius: 50%;
                box-shadow: 0 0 0 0.2em #f1f1f1 inset;
                top: 0.75em;
                left: 0.75em;
                width: 1.2em;
                height: 1.2em;
            }
            .search-btn:after {
                background: #f1f1f1;
                border-radius: 0 0.25em 0.25em 0;
                top: 51%;
                left: 51%;
                width: 0.75em;
                height: 0.25em;
                transform: translate(0.2em,0) rotate(45deg);
                transform-origin: 0 50%;
            }
            .search-btn span {
                display: inline-block;
                overflow: hidden;
                width: 1px;
                height: 1px;
            }

            /* Active state */
            .search-bar input:focus + .search-btn,
            .search-bar input:valid + .search-btn {
                background: #2762f3;
                border-radius: 0 0.375em 0.375em 0;
                transform: scale(1);
            }
            .search-bar input:focus + .search-btn:before, 
            .search-bar input:focus + .search-btn:after,
            .search-bar input:valid + .search-btn:before, 
            .search-bar input:valid + .search-btn:after {
                opacity: 1;
            }
            .search-bar input:focus + .search-btn:hover,
            .search-bar input:valid + .search-btn:hover,
            .search-bar input:valid:not(:focus) + .search-btn:focus {
                background: #0c48db;
            }
            .search-bar input:focus + .search-btn:active,
            .search-bar input:valid + .search-btn:active {
                transform: translateY(1px);
            }

            @media screen and (prefers-color-scheme: dark) {
                body, input {
                    color: #f1f1f1;
                }
                body {
                    background: #ff9966;
                }
                .search-bar input {
                    box-shadow: 0 0 0 0.4em #f1f1f1 inset;
                }
                .search-bar input:focus,
                .search-bar input:valid {
                    background: #3d3d3d;
                    box-shadow: 0 0 0 0.1em #3d3d3d inset;
                }
                .search-btn {
                    background: #f1f1f1;
                }
            }

        </style>
    </head>

    <body>

          <div class="content">
       <h3> pesquisar Estudante   </h3> 
        <form action="" class="search-bar">
            <input type="search" name="search" pattern=".*\S.*" required>
            <button class="search-btn" type="submit">
                <span>Search</span>
            </button>
        </form>

        <!-- Tabela de resultados -->
        <%
            String nomeParam = request.getParameter("search");
            if (nomeParam != null && !nomeParam.isEmpty()) {
                EstudanteDAO estudanteDAO = new EstudanteDAO();
                List<Estudante> estudantesEncontrados = estudanteDAO.buscarPorNome(nomeParam);
                if (!estudantesEncontrados.isEmpty()) {
        %>
        <table class="table table-striped mt-4 table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Número de Matrícula</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Apelido</th>
                    <th scope="col">Endereço</th>
                    <th scope="col">Contacto</th>
                    <th scope="col">Turma</th>
                    <th scope="col">Curso</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (Estudante estudante : estudantesEncontrados) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><%= estudante.getNrMatricula()%></td>
                    <td><%= estudante.getNome()%></td>
                    <td><%= estudante.getApelido()%></td>
                    <td><%= estudante.getEndereco()%></td>
                    <td><%= estudante.getContacto()%></td>
                    <td><%= estudante.getTurma() != null ? estudante.getTurma().getNome() : "N/A" %></td>
                    <td><%= estudante.getTurma() != null && estudante.getTurma().getCurso() != null ? estudante.getTurma().getCurso().getNome() : "N/A" %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <% } else { %>
        <!-- Mensagem se nenhum estudante for encontrado -->
        <p class="text-white">Nenhum estudante encontrado com o nome "<%= nomeParam%>".</p>
        <% }
            } %>

        <!-- Botão de retorno à página inicial -->
        <a href="Home.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
            <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 30px; color: white;"></i>
        </a>
    </div>

       

            <a href="Home.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
            <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 30px; color: white;"></i>
        </a>
    </body>

</html>

</body>

</html>
