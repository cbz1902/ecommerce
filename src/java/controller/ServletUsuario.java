/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entidades.Usuarios;
import model.manager.ManagerUsuario;

/**
 *
 * @author carlos
 */
public class ServletUsuario extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);
        String accion = request.getParameter("accion");
        request.setAttribute("accion", accion);
        ManagerUsuario mu = new ManagerUsuario();
        PrintWriter out = response.getWriter();
        Usuarios u = null;
        if(accion.equals("ingresar")){
           String user = request.getParameter("user");
           String pass = request.getParameter("pass");
           u = mu.ingresar(user,pass);
            if(u == null){
               out.println("<script type=\"text/javascript\">");
               out.println("alert('Nombre de usuario o contraseña incorrecta');");
               out.println("location='index.jsp';");
               out.println("</script>");
            }else{

               String lugar = (String)sesion.getAttribute("lugar");
               sesion.setAttribute("usuario", u);
               RequestDispatcher rd = null;
               if(lugar == "compra"){
                   sesion.setAttribute("lugar", "");
                   rd = request.getRequestDispatcher("/comprar.jsp");
               }else{
                   rd = request.getRequestDispatcher("/index.jsp");
               }
               if (rd != null) {
                   rd.forward(request, response);
               }
           }
        }else if(accion.equals("salir")){
           sesion.invalidate();
           response.sendRedirect("index.jsp");
        } 
        switch (accion) {
            
            case "insertar":
                {
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String userName = request.getParameter("nombre_user");
                    String pass = request.getParameter("pass");
                    int tipo_user = Integer.parseInt(request.getParameter("tipo_usuario"));
                    u = new Usuarios();
                    u.setApellido(apellido);
                    u.setNombre(nombre);
                    u.setLogin_name(userName);
                    u.setPassword(pass);
                    u.setTipo_usuario(tipo_user);
                    mu.insertar(u);
                    request.setAttribute("usuario", u);
                    RequestDispatcher rd = request.getRequestDispatcher("/ABMusuarios.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }      break;
                }
            case "actualizar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String userName = request.getParameter("nombre_user");
                    u = new Usuarios();
                    u.setId_usuario(id);
                    u.setApellido(apellido);
                    u.setNombre(nombre);
                    u.setLogin_name(userName);
                    mu.actualizar(u);
                    RequestDispatcher rd = request.getRequestDispatcher("/ABMusuarios.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }       break;
                }
            case "eliminar":
                {
                    int id = Integer.valueOf(request.getParameter("id"));
                    mu.eliminar(id);
                    response.sendRedirect("ABMusuarios.jsp");
                    break;
                }
            default:
                break;
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
