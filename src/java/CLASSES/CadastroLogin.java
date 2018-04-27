/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASSES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
public class CadastroLogin extends HttpServlet {

     private final static String PATH = "usuarios.csv";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String nome = request.getParameter("nome");
           String senha = request.getParameter("senha");
           
           try{
           if(verificaDisponibilidade(nome)){
                RequestDispatcher rd = request.getRequestDispatcher("CadastroUsuario.jsp");
                rd.forward(request, response);
           }
           }catch(FileNotFoundException e){
               cadastraUsuario(nome, senha);
               HttpSession usuarioLogado = request.getSession();
               usuarioLogado.setAttribute("nome", nome);
               RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
               rd.forward(request, response);
           }
           
           cadastraUsuario(nome, senha);
           
           HttpSession usuarioLogado = request.getSession();
           usuarioLogado.setAttribute("nome", nome);
           
           RequestDispatcher rd = request.getRequestDispatcher("Cadastro.jsp");
           rd.forward(request, response);
    }
    
    private void cadastraUsuario(String usuario, String senha) throws IOException{
        BufferedWriter bf = new BufferedWriter(new FileWriter("PATH", true));
        String linha = usuario + " ; " + senha;
        
        bf.append(linha + "\r\n");
        bf.close();
    }
    
    private boolean verificaDisponibilidade(String usuario) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("PATH"));
        String linha = br.readLine();
        //Retorna true caso o nome já esteja sendo utilizado
        while(linha != null){
            if(linha.contains(usuario)){
                return true;
            }
            linha = br.readLine();
        }
       return false; 
    }
    
}
