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
import model.entidades.Categoria;
import model.manager.ManagerCategoria;


/**
 *
 * @author carlos
 */
public class ServletCategoria extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);
        String accion = request.getParameter("accion");
        request.setAttribute("accion", accion);
        ManagerCategoria mc = new ManagerCategoria();
        Categoria c = null;
        switch (accion) {
            case "insertar":
                {
                    String descripcion = request.getParameter("descripcion");
                    boolean isExist = false;
                    try {
                        isExist = mc.yaExiste(descripcion);
                    } catch (Exception e) {
                    }       if(isExist){
                        request.setAttribute("msj", "La categoria ya existe");
                    }else{
                        c = new Categoria();
                        c.setDescripcion(descripcion);
                        mc.insertar(c);
                        request.setAttribute("msj", "Categoria añadida");
                    }       RequestDispatcher rd = request.getRequestDispatcher("/Acategorias.jsp");
                    rd.forward(request, response);
                    break;
                }
            case "actualizar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String descripcion = request.getParameter("descripcion");
                    c = new Categoria();
                    c.setDescripcion(descripcion);
                    c.setIdCategoria(id);
                    mc.actualizar(c);
                    RequestDispatcher rd = request.getRequestDispatcher("/Mcategorias.jsp");
                    if (rd != null) {
                        rd.forward(request, response);
                    }
                }
            case "eliminar":
                {
                    int id =  Integer.parseInt(request.getParameter("id"));
                    mc.eliminar(id);
                    response.sendRedirect("ABMcategorias.jsp");
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
