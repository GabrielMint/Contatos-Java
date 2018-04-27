<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Agenda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="Estilo.css">
        <link rel="shortcut icon" href="favicon.ico">
    </head>
    <body>
        <%@include file="Cabecalho.jsp" %>
        <h1 class="titulos">Bem vindo a agenda!</h1>
        <h3 class="titulos">Cadastre um contato</h3>
        <form action="ManterContato.do" method="get">
            <div class="col-xs-3">
            Nome:<input type="text" name="nome" class="form-control" required="required"><br/>
            Email:<input type="text" name="email" class="form-control" required="required"><br/>
            Telefone:<input type="text" name="telefone" class="form-control" required="required"><br/>
            <input type="submit" class="btn btn-default" value="Cadastrar">
            </div>
        </form>
       
        
        <form action="ManterContato.do" id="listar" method="post">
            <input type="submit" class="btn btn-default" value="Listar">
        </form>
        
    </body>
</html>
