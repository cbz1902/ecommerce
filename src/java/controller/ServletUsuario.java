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
        String accion = request.getParameter("accion");
        request.setAttribute("accion", accion);
        ManagerUsuario mu = new ManagerUsuario();
        PrintWriter out = response.getWriter();
        Usuarios u = null;
        if(accion.equals("insertar")){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String userName = request.getParameter("nombre_user");
            String pass = request.getParameter("pass");
            int tipo_user = Integer.parseInt(request.getParameter("tipo_usuario"));
            boolean bandera = true;
            u = new Usuarios();
            u.setApellido(apellido);
            u.setNombre(nombre);
            u.setLogin_name(userName);
            u.setPassword(pass);
            u.getLogin_name();
            if(nombre.isEmpty() || apellido.isEmpty() || userName.isEmpty() || pass.isEmpty() || pass2.isEmpty()){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Debe llenar todos los campos del formulario');");
                out.println("location='register.jsp';");
                out.println("</script>");
            }else{
                //verificar que el nombre de usuario no se repita en la bd
                try {
                    bandera = mu.isUserExists(userName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(bandera){    //el usuario ya existe en la bd

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('El nombre de usuario ya existe');");
                    out.println("location='register.jsp';");
                    out.println("</script>");
                }else{  //el usuario no existe en la bd
                    //verificamos que las contraseñas coincidan
                    if(! pass.equals(pass2)){
                       out.println("<script type=\"text/javascript\">");
                       out.println("alert('Las contraseñas no coinciden');");
                       out.println("location='register.jsp';");
                       out.println("</script>");
                    }else{
                       mu.insertar(u);
                       request.setAttribute("usuario", u);
                       RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        if (rd != null) {
                            rd.forward(request, response);
                        }
                    }
                }
            }
 
        }else if(accion.equals("actualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String userName = request.getParameter("user");
            String pass = request.getParameter("pass");
            
            u = new Usuario();
            u.setId(id);
            u.setApellido(apellido);
            u.setNombre(nombre);
            u.setNombreUser(userName);
            u.setPass(pass);
            mu.actualizar(u);
            RequestDispatcher rd = request.getRequestDispatcher("/ListadoUsuarios.jsp");
            if (rd != null) {
                rd.forward(request, response);
            }
        }else if(accion.equals("eliminar")){
            int id = Integer.valueOf(request.getParameter("id"));
            mu.eliminar(id);
            response.sendRedirect("ListadoUsuarios.jsp");
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
