<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cadastrar Disciplina</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel="stylesheet" href="../css/Estudantes.css"> <!-- Reusing the same CSS file -->
</head>
<body>

<div class="container">
    <div class="text">
        Cadastro de Disciplina
    </div>
   
    <form action="${pageContext.request.contextPath}/DisciplinaServlet?action=add" method="post">

        <div class="form-row">
            <div class="input-data">
                <input type="text" required name="nome">
                <div class="underline"></div>
                <label for="">Nome</label>
            </div>
            <div class="input-data">
                <input type="number" required name="chs">
                <div class="underline"></div>
                <label for="">Carga Horária Semanal</label>
            </div>
        </div>
        <div class="form-row">
            <div class="input-data">
                <input type="number" required name="credito">
                <div class="underline"></div>
                <label for="">Crédito</label>
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
