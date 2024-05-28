<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="../css/Dashboard.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
</head>
<body>
    <div>
        <!--wrapper start-->
        <div class="wrapper">
            <!--header menu start-->
            <div class="header">
                <div class="header-menu">
                    <div class="sidebar-btn">
                        <i class="fas fa-bars"></i>
                    </div>
                    <ul></ul>
                </div>
            </div>
            <!--header menu end-->
            <!--sidebar start-->
            <div class="sidebar">
                <div class="sidebar-menu">
                    <center class="profile">
                        <img src="../img/books.jpg" alt="">
                        <p>Gestão de estudantes</p>
                    </center>
                     <li class="item">
                        <a href="#" class="menu-btn">
                            <i class="fas fa-desktop"></i><span>Dashboard</span>
                        </a>
                    </li>
                    <li class="item">
                        <a href="../Home_Page/Home.jsp" class="menu-btn">
                            <i class="fas fa-home"></i><span>Página Inicial</span>
                        </a>
                    </li>
                   
                    <li class="item" id="avaliacao">
                        <a href="" class="menu-btn">
                            <i class="fas fa-star"></i><span>Avaliação <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../Avaliacao/FRMCadastroAvaliacao.jsp"><i class="fas fa-plus"></i><span>Adicionar Avaliação</span></a>
                            <a href="../Avaliacao/FRMListarAvaliacoes.jsp"><i class="fas fa-eye"></i><span>Visualizar Avaliações</span></a>
                        </div>
                    </li>
                    <li class="item" id="curso">
                        <a href="#curso" class="menu-btn">
                            <i class="fas fa-book"></i><span>Curso <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../Curso/FRMCadastroCurso.jsp"><i class="fas fa-plus"></i><span>Adicionar Curso</span></a>
                            <a href="../Curso/FRMListarCursos.jsp"><i class="fas fa-eye"></i><span>Visualizar Cursos</span></a>
                        </div>
                    </li>
                    <li class="item" id="turma">
                        <a href="#turma" class="menu-btn">
                            <i class="fas fa-users"></i><span>Turma <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../Turma/FRMCadastroTurma.jsp"><i class="fas fa-plus"></i><span>Adicionar Turma</span></a>
                            <a href="../Turma/FRMListarTurmas.jsp"><i class="fas fa-eye"></i><span>Visualizar Turmas</span></a>
                        </div>
                    </li>
                    <li class="item" id="estudante">
                        <a href="#estudante" class="menu-btn">
                            <i class="fas fa-user-graduate"></i><span>Estudante <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../Estudante/FRMCadastroEstudantes.jsp"><i class="fas fa-plus"></i><span>Adicionar Estudante</span></a>
                            <a href="../Estudante/FRMListarEstudantes.jsp"><i class="fas fa-eye"></i><span>Visualizar Estudantes</span></a>
                        </div>
                    </li>
                    <li class="item" id="disciplina">
                        <a href="#disciplina" class="menu-btn">
                            <i class="fas fa-book-reader"></i><span>Disciplina <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../Disciplina/FRMCadastroDisciplina.jsp"><i class="fas fa-plus"></i><span>Adicionar Disciplina</span></a>
                            <a href="../Disciplina/FRMListarDisciplinas.jsp"><i class="fas fa-eye"></i><span>Visualizar Disciplinas</span></a>
                        </div>
                    </li>
                    <li class="item" id="nota">
                        <a href="#nota" class="menu-btn">
                            <i class="fas fa-graduation-cap"></i><span>Nota <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="../NotaRealiza/FRMRealizaCadastrar.jsp"><i class="fas fa-plus"></i><span>Adicionar Nota</span></a>
                            <a href="../NotaRealiza/FRMListarRealizas.jsp"><i class="fas fa-eye"></i><span>Visualizar Notas</span></a>
                        </div>
                    </li>
                </div>
            </div>
            <!--sidebar end-->
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".sidebar-btn").click(function(){
                $(".wrapper").toggleClass("collapse");
            });

            $(".menu-btn").click(function(){
                $(this).next(".sub-menu").slideToggle();
                $(this).find(".drop-down").toggleClass("rotate");
            });
        });
    </script>
</body>
</html>

