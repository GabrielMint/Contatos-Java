<%-- 
    Document   : CadastroUsuario
    Created on : 11/06/2017, 17:52:25
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="Estilo.css">
        <link rel="shortcut icon" href="favicon.ico">
        <title>Agenda</title>
    </head>
    <body>
        <div class="login">
            <h1>Cadastre-se já!</h1>
            <div class="form-group">
            <form action="CadastroLogin.do" method="post">
                <label for="nome">Nome:</label><br>
                <input type="text" id="nome" name="nome" size="20"
                       class="form-control" required="required"><br/>
                <label for="senha">Senha:</label><br>
                <input type="password" name="senha" size="20"
                       class="form-control" required="required"><br/>
                <input type="submit" class="btn" value="Cadastrar">
            </form>
            </div>
        </div>
    </body>
</html>
