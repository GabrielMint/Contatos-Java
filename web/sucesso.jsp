<%-- 
    Document   : sucesso
    Created on : 25/05/2017, 21:24:09
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="CLASSES.Contato"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="Estilo.css">
        <link rel="shortcut icon" href="favicon.ico">
        <title>Agenda</title>
        
        <% 
            Contato c = (Contato) request.getAttribute("contato"); 
        %>
    </head>
    <body>
        <%@include file="Cabecalho.jsp" %>
        <h1 class="titulos">Contato adicionado com sucesso!</h1><br>
        <p class="titulos"><strong>Nome: <%= c.getNome() %></strong> </p>
        <p class="titulos"><strong>Email: <%= c.getEmail() %> </strong></p>
        <p class="titulos"><strong>Telefone: <%= c.getTelefone() %></strong> </p>
        <br><br>
        <form action="Cadastro.jsp" class="titulos" method="get">
            <input type="submit" class="btn btn-default" value="Voltar">
        </form>
    </body>
</html>
