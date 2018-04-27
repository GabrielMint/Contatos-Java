/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASSES;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
public class LoginSessao extends HttpServlet {
    
    private final static String PATH ="usuarios.csv";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession sessaoAtual = request.getSession();
            sessaoAtual.invalidate();
            response.sendRedirect("Logout.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        try{
        if(autenticaUsuario(nome, senha)){
                HttpSession usuarioLogado = request.getSession();
                usuarioLogado.setAttribute("nome", nome);
                RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
                rd.forward(request, response); 
        }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
        }
        }catch(FileNotFoundException e){
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
    }
    
    private boolean autenticaUsuario(String usuario, String senha) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("PATH"));
        String linha = br.readLine();
        
        while(linha != null){
            if(linha.split(" ; ")[0].equals(usuario) && linha.split(" ; ")[1].equals(senha)){
                return true;
            }
            linha = br.readLine();
        }
        return false;
    }
}
