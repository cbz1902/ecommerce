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
import model.manager.ManagerProducto;
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

public class ServletProducto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(true);
        PrintWriter out = response.getWriter();
        String accion = request.getParameter("accion");
        request.setAttribute("accion", accion);
        ManagerProducto mp = new ManagerProducto();
        Producto p = null;
        if (accion.equals("insertar")){
            String descripcion = request.getParameter("descripcion");
            int id_categoria = Integer.parseInt(request.getParameter("selCategoria"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String imagen = request.getParameter("imagen");
            p = new Producto();
            p.setDescripcion(descripcion);
            p.setCantidad(cantidad);
            p.setId_categoria(id_categoria);
            p.setPrecio_unitario(precio);
            p.setImagen_producto(imagen);
            mp.insertar(p);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Producto añadido');");
            out.println("location='insertarProducto.jsp';");
            out.println("</script>");      
        }else if(accion.equals("actualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String descripcion = request.getParameter("descripcion");
            int id_categoria = Integer.parseInt(request.getParameter("selCategoria"));
            int precio = Integer.parseInt(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            String imagen = request.getParameter("imagen");
           
            //anhadir imagen para validar
            if(descripcion.isEmpty()){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Todos los campos deben contener datos');");
                out.println("location='/editarProducto.jsp';");
                out.println("</script>");
            }else{
                p = new Producto();
                p.setId_producto(id);
                p.setDescripcion(descripcion);
                p.setId_categoria(id_categoria);
                p.setCantidad(cantidad);
                p.setPrecio_unitario(precio);
                p.setImagen_producto(imagen);
                mp.actualizar(p);
                RequestDispatcher rd = request.getRequestDispatcher("/listadoProductos.jsp");
                if (rd != null) {
                    rd.forward(request, response);
                }
            }
        }else if(accion.equals("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            mp.eliminar(id);
            response.sendRedirect("ABMproductos.jsp");
        }else if(accion.equals("buscar")){
            String parametro = request.getParameter("buscador");
            if(parametro != ""){
                parametro = "%"+parametro.toLowerCase()+"%";
            }
            int categoria = Integer.parseInt(request.getParameter("selCategoria"));
            /*ArrayList<Producto> productos = mp.buscarProductos(parametro,categoria);
            if(productos==null){
                request.setAttribute("productos", null);
            }else{
                request.setAttribute("productos", productos);
            }*/
            request.getRequestDispatcher("/").forward(request, response);
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

