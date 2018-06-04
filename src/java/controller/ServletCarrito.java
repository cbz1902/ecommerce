/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Tania Leguizamon
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entidades.Producto;

public class ServletCarrito extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        if(accion.equals("agregar_carrito")){
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idProducto = Integer.parseInt(request.getParameter("id"));
            
            ArrayList<Producto> productos = sesion.getAttribute("carrito") == null ? new ArrayList<Producto>() : (ArrayList<Producto>) sesion.getAttribute("carrito");

            boolean bandera = false;
            if(productos.size() >0){
                for(Producto a : productos){
                    if(idProducto == a.getId_producto()){
                        a.setCantidad(cantidad);
                        bandera = true;
                        break;
                    }
                }
            }
            if(!bandera){
                Producto a = new Producto();
                a.setCantidad(cantidad);
                a.setId_producto(idProducto);
                productos.add(a);
            }
            sesion.setAttribute("carrito", productos);
            response.sendRedirect("carrito.jsp");
        }else if(accion.equals("eliminar")){
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            ArrayList<Producto> productos = sesion.getAttribute("carrito") == null ? null : (ArrayList<Producto>) sesion.getAttribute("carrito");
            if(productos != null){
                for(Producto a : productos){
                    if(a.getId_producto() == idProducto){
                        productos.remove(a);
                        break;
                    }
                }
                
                request.setAttribute("carrito", productos);
                RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
                rd.forward(request, response);
            
                
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

