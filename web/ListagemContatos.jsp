<%-- 
    Document   : ListagemContatos
    Created on : 25/05/2017, 21:27:54
    Author     : Gabriel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="CLASSES.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="Estilo.css">
        <link rel="shortcut icon" href="favicon.ico">
        <title>Agenda</title>
        <% 
        ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("lista");
        %>
    </head>
    <body>
        <%@include file="Cabecalho.jsp" %>
        <table class="table tabela">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                </tr>
            </thead>
            <tbody>
                <% for(Contato c : lista){ %>
                <tr>
                    <td> <%= c.getNome() %> </td>
                    <td> <%= c.getEmail() %> </td>
                    <td> <%= c.getTelefone() %> </td>
                </tr>
                <% } %>
            </tbody>
        </table> 
            <form action="Cadastro.jsp" id="cadastrar" method="get">
                <input type="submit" class="btn btn-default" value="Cadastrar Contato">
            </form>
    </body>
</html>
