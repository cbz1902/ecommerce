/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

/**
 *
 * @author Tania Leguizamon
 */
import model.connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entidades.Transaccionesdet;

public class ManagerTransaccionDetalle {
    public boolean insertar(Transaccionesdet td){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean retorno = false;
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("insert into transacciones_det(id_transaccion,item,id_producto,cantidad,precio,sub_total) values(?,?,?,?,?,?)");
            ps.setInt(1, td.getId_transaccion());
            ps.setInt(2, td.getItem());
            ps.setInt(3, td.getId_producto());
            ps.setInt(4, td.getCantidad());
            ps.setInt(5, td.getPrecio());
            ps.setInt(6, td.getSubtotal());
            retorno = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (ps != null) {
                    ps.close();
                }
                connexion.closeConnection(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }
    public ArrayList<Transaccionesdet> getTransaccionByIdTransaccion(int idTransaccion){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Transaccionesdet> lista = new ArrayList<Transaccionesdet>();
        Transaccionesdet td = null;
        ManagerTransaccionCab mtc = new ManagerTransaccionCab();
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("select * from transacciones_det where id_transaccion = ?");
            ps.setInt(1, idTransaccion);
            rs = ps.executeQuery();
            while(rs.next()){
                td = new Transaccionesdet();
                td.setId_transaccion(rs.getInt("id_transaccion"));
                td.setId_producto(rs.getInt("id_producto"));
                td.setCantidad(rs.getInt("cantidad"));
                td.setItem(rs.getInt("item"));
                td.setPrecio(rs.getInt("precio"));
                td.setSubtotal(rs.getInt("sub_total"));
                
                lista.add(td);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                connexion.closeConnection(conn);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}

