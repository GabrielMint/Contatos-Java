<%-- 
    Document   : Cabecalho
    Created on : 03/06/2017, 20:45:26
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sessao = request.getSession();
    if(sessao == null){
    RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
    rd.forward(request, response);
}
%>
        <header>
            <div id="cabecalho">
                <p id="usuario">Usuario Logado: <%= sessao.getAttribute("nome") %>
                    <span class="glyphicon glyphicon-user" style="color:white"></span></p>
                <form id="logout" action="LoginSessao.do" method="get">
                    <input type="submit" class="btn btn-link" id="sair" value="SAIR">
                </form>
            </div>
        </header>
        
