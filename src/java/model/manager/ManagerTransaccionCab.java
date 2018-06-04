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
import model.entidades.Transaccionescab;

public class ManagerTransaccionCab {
    
    public boolean insertar(Transaccionescab tc){
        Connection conn = null;
        PreparedStatement ps = null;
        boolean retorno = false;
        try {
            conn = connexion.getConnection();
            if(tc.getId_medio_pago() == 1){ //insertar nro de tarjeta
                ps = conn.prepareStatement("insert into transacciones_cab(id_usuario, total, direccion_envio,id_medio_pago,nro_tarjeta,estado, fecha) values(?,?,?,?,?,current_timestamp)");
                ps.setInt(1, tc.getId_usuario());
                ps.setInt(2, tc.getTotal());
                ps.setString(3, tc.getDireccion_de_envio());
                ps.setInt(4, tc.getId_medio_pago());
                ps.setInt(5, tc.getNro_tarjeta());
                ps.setString(6, tc.getEstado());
                retorno = ps.execute();
            }else{
                ps = conn.prepareStatement("insert into transacciones_cab(id_usuario, total, direccion_envio,id_medio_pago,estado, fecha) values(?,?,?,?,?,current_timestamp)");
                ps.setInt(1, tc.getId_usuario());
                ps.setInt(2, tc.getTotal());
                ps.setString(3, tc.getDireccion_de_envio());
                ps.setInt(4, tc.getId_medio_pago());
                ps.setString(5, tc.getEstado());
                retorno = ps.execute();
            }
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
    public ArrayList<Transaccionescab> getTransaccionesCab(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Transaccionescab> lista = new ArrayList<Transaccionescab>();
        Transaccionescab tc = null;
        ManagerUsuario mu = new ManagerUsuario(); 
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("select * from transacciones_cab");
            rs = ps.executeQuery();
            while(rs.next()){
                tc = new Transaccionescab();
                tc.setId_transaccion(rs.getInt("id_transaccion"));
                tc.setDireccion_de_envio(rs.getString("direccion_envio"));
                tc.setEstado(rs.getString("estado"));
                tc.setFecha(rs.getDate("fecha"));
                tc.setId_medio_pago(rs.getInt("id_medio_pago"));
                tc.setNro_tarjeta(rs.getInt("nro_tarjeta"));
                tc.setTotal(rs.getInt("total"));
                tc.setId_usuario(mu.getUsuariosById(rs.getInt("id_usuario")).getId_usuario());
                lista.add(tc);
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
    public Transaccionescab getTransaccionById(int idTransaccion){
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        Transaccionescab tc = null;
        ManagerUsuario mu = new ManagerUsuario(); 
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("select  * from transacciones_cab where id_transaccion = ?");
            ps.setInt(1, idTransaccion);
            rs = ps.executeQuery();
            while(rs.next()){
                tc = new Transaccionescab();
                tc.setId_transaccion(rs.getInt("id_transaccion"));
                tc.setDireccion_de_envio(rs.getString("direccion_envio"));
                tc.setEstado(rs.getString("estado"));
                tc.setFecha(rs.getDate("fecha"));
                tc.setId_medio_pago(rs.getInt("id_medio_pago"));
                tc.setNro_tarjeta(rs.getInt("nro_tarjeta"));
                tc.setTotal(rs.getInt("total"));
                tc.setId_usuario(mu.getUsuariosById(rs.getInt("id_usuario")).getId_usuario());
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
        return tc;
    }
    public ArrayList<Transaccionescab> getTransaccionByUser(int idUser){
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        Transaccionescab tc = null;
        ManagerUsuario mu = new ManagerUsuario(); 
        ArrayList<Transaccionescab> lista  = new ArrayList<Transaccionescab>();
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("select  * from transacciones_cab where id_usuario = ?");
            ps.setInt(1, idUser);
            rs = ps.executeQuery();
            while(rs.next()){
                tc = new Transaccionescab();
                tc.setId_transaccion(rs.getInt("id_transaccion"));
                tc.setDireccion_de_envio(rs.getString("direccion_envio"));
                tc.setEstado(rs.getString("estado"));
                tc.setFecha(rs.getDate("fecha"));
                tc.setId_medio_pago(rs.getInt("id_medio_pago"));
                tc.setNro_tarjeta(rs.getInt("nro_tarjeta"));
                tc.setTotal(rs.getInt("total"));
                tc.setId_usuario(mu.getUsuariosById(rs.getInt("id_usuario")).getId_usuario());
                
                lista.add(tc);
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
    public int getLastTransaccion(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id=0;
        try {
            conn = connexion.getConnection();
            ps = conn.prepareStatement("select max(id_transaccion) maximo from transacciones_cab");
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("maximo");
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
        return id;
    }
}

