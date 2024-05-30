<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <!-- Adicionando o Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Adicionando o Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        .rotate-icon:hover {
            transform: rotate(10deg);
        }
    </style>
</head>
<body>
    <a href="index.jsp" style="position: fixed; top: 20px; left: 20px; z-index: 9999;">
        <i class="fas fa-arrow-right fa-flip-horizontal rotate-icon" style="font-size: 24px; color: black;"></i>
    </a>
</body>
</html>
