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
import model.manager.ManagerTransaccionCab;
import model.manager.ManagerTransaccionDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entidades.Producto;
import model.entidades.Transaccionescab;
import model.entidades.Transaccionesdet;
import model.entidades.Usuarios;

/**
 *
 * @author usuario
 */
public class ServletPago extends HttpServlet {

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
        String direccion = request.getParameter("direccion");
        int formaPago = Integer.parseInt(request.getParameter("medio"));
        int totalPagar = (int) sesion.getAttribute("totalPagar");
        ArrayList<Producto> productos  = (ArrayList<Producto>)sesion.getAttribute("carrito");
        Usuarios u = (Usuarios) sesion.getAttribute("usuario");
        ManagerTransaccionCab mtc = new ManagerTransaccionCab();
        ManagerTransaccionDetalle mtd = new ManagerTransaccionDetalle();
        ManagerProducto mp = new ManagerProducto();
        Transaccionescab tc = new Transaccionescab(); 
        Transaccionesdet td = null;
        Producto p = null ;
        int idTransac, item=0;
        //poblar la tabla de transaccines_cab
        tc.setDireccion_de_envio(direccion);
        tc.setEstado("i");
        tc.setId_medio_pago(formaPago);
        tc.setTotal(totalPagar);
        tc.setId_usuario(u.getId_usuario());
        if(formaPago == 1){  //pago por tarjeta
            int nroTarjeta = Integer.parseInt(request.getParameter("nroTarjeta"));
            tc.setNro_tarjeta(nroTarjeta);
        }
        mtc.insertar(tc);
        
        //poblar la tabla transacciones_det
        idTransac = mtc.getLastTransaccion();
        tc.setId_transaccion(idTransac);
        for(Producto a : productos){
            //poblar la tabla transacciones_det
            td = new Transaccionesdet();
            p = mp.getProductoById(a.getId_producto());
            item++;
            td.setId_transaccion(tc.getId_transaccion());
            td.setId_producto(a.getId_producto());
            td.setCantidad(a.getCantidad());
            td.setItem(item);
            td.setPrecio(p.getPrecio_unitario());
            td.setSubtotal(td.getPrecio() * td.getCantidad());
            mtd.insertar(td);
            
            p.setCantidad(p.getCantidad() - a.getCantidad());
            mp.actualizar(p);
        }
        productos.clear();
        sesion.setAttribute("carrito", productos);
        sesion.setAttribute("totalPagar", 0);
        response.sendRedirect("comprar.jsp");
        
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
