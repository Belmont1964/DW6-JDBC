/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author belmo
 */


@WebServlet(urlPatterns = {"/Agenda"})
public class Agenda extends HttpServlet {
    
    // conectando o projeto com o banco de dados
    Connection conexao = null;

    @Override
    public void init() throws ServletException{
        
        try{
            // fazendo a conexão com o BD
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/Agenda","ze","123");
        }
        catch (Exception ex){
            
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Agenda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Agenda at " + request.getContextPath() + "</h1>");
            
            out.println("<h1> AGENDA </h1");
            out.println ("<form action = 'Agenda' method = 'post'> ");
            out.println("<input type = 'text' name = 'nome' placeholder = 'NOME' ><br>");
            out.println("<input type = 'text' name = 'tel' placeholder = 'TELEFONE' ><br>");
            out.println("<input type = 'submit' >");
            out.println("</form><br>");               
            out.println("</body>");
            out.println("</html>");    */
            
            String nome = request.getParameter("nome");
            String tel = request.getParameter("tel");
            
            String comandoSql = "insert into Agenda (nome,tel) values (?,?)";
            try (PreparedStatement sql = conexao.prepareStatement(comandoSql)){
                int id;
                sql.setString(1, nome);
                sql.setString(2, tel);
                
                sql.executeUpdate();
            }
            catch (Exception e){
                out.println("erro " + e );
            }
            
            comandoSql = "select * from Agenda"; 
            try(PreparedStatement sql = conexao.prepareStatement(comandoSql)){
                ResultSet rs = sql.executeQuery();
                List <Contato> contatos = new ArrayList<>();
                while (rs.next()){
                    contatos.add(new Contato(
                            rs.getString("nome"),
                            rs.getString("tel"),
                            rs.getInt ("id")));   
                }
                
                request.setAttribute("contatos", contatos);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("Agenda.jsp");
                    if (dispatcher != null){
                        dispatcher.forward(request, response);
                    }
            }
            catch (Exception e){
                
            }
  
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
