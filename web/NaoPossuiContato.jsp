<%-- 
    Document   : NaoPossuiContato
    Created on : 14/06/2017, 19:10:32
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="Estilo.css?version=2">
        <link rel="shortcut icon" href="favicon.ico">
        <title>Agenda</title>
    </head>
    <body>
        <%@include file="Cabecalho.jsp" %>
        <h2>Você não possui contatos, cadastre um já!</h2>
        <form action="Cadastro.jsp" id="cadastrar" method="get">
                <input type="submit" class="btn btn-default" value="Cadastrar Contato">
        </form>
    </body>
</html>
