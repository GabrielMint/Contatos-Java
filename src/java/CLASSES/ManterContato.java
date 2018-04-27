package CLASSES;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ManterContato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Contato c = new Contato();
                c.setNome(request.getParameter("nome"));
                c.setEmail(request.getParameter("email"));
                c.setTelefone(request.getParameter("telefone"));
                
                HttpSession sessao = request.getSession();
                String path = "contato_" + sessao.getAttribute("nome");
                
                cadastraContato(c,path);
               
                RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
                request.setAttribute("contato", c);
                rd.forward(request, response);  
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession sessao = request.getSession();
            String path = "contato_" + sessao.getAttribute("nome");
            RequestDispatcher rd = request.getRequestDispatcher("ListagemContatos.jsp");
            
            try{
            request.setAttribute("lista", listaContatos(path));
             }catch(FileNotFoundException e){
                    RequestDispatcher rds = request.getRequestDispatcher("NaoPossuiContato.jsp");
                    rds.forward(request, response);
             }
            rd.forward(request, response);
    }

    private void cadastraContato(Contato c, String path) throws IOException{
        BufferedWriter bf = new BufferedWriter(new FileWriter(path, true));
        String linha = c.getNome() + " ; " + c.getEmail() + " ; " + c.getTelefone();
        
        bf.append(linha + "\r\n");
        bf.close();
    }
    
    private ArrayList<Contato> listaContatos(String path) throws IOException, FileNotFoundException{
        ArrayList<Contato> contatos = new ArrayList<Contato>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String linha = "";
        
        while(linha != null){
            linha = br.readLine();
             if(linha == null){
                break;
            }
            Contato c = new Contato();
            c.setNome(linha.split(" ; ")[0]);
            c.setEmail(linha.split(" ; ")[1]);
            c.setTelefone(linha.split(" ; ")[2]);
            contatos.add(c);
        }
        
        br.close();

        return contatos;
    }
    

}
