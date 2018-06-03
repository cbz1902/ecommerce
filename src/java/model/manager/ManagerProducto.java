/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connexion;
import model.entidades.Producto;

/**
 *
 * @author carlos
 */
public class ManagerProducto {
    public boolean insertar(Producto pro) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("INSERT INTO Producto (descripcion,precio_unitario,cantidad,imagen_producto,id_categoria) values (?, ?, ?, ?, ?)");
            pstmt.setString(1, pro.getDescripcion());
            pstmt.setInt(2, pro.getPrecio_unitario());
            pstmt.setInt(3, pro.getCantidad());
            pstmt.setString(4, pro.getImagen_producto());
            pstmt.setInt(5, pro.getId_categoria());
            ret = pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public boolean actualizar(Producto u) {
        return true;
    }

    public boolean eliminar(Producto pro) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("DELETE FROM Producto WHERE id = ?");

            pstmt.setInt(1, pro.getId_producto());

            ret = pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public Producto getProductoById(int id) {
        Producto ret = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Producto WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                ret = new Producto();
                ret.setId_producto(rs.getInt("id_producto"));
                ret.setDescripcion(rs.getString("descripcion"));
                ret.setPrecio_unitario(rs.getInt("precio_unitario"));
                ret.setCantidad(rs.getInt("cantidad"));
                ret.setImagen_producto(rs.getString("imagen_producto"));
                ret.setId_categoria(rs.getInt("id_categoria"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public ArrayList<Producto> getAll() {
        ArrayList<Producto> ret = new ArrayList<Producto>();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Producto");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_unitario(rs.getInt("precio_unitario"));
                pro.setCantidad(rs.getInt("cantidad"));
                pro.setImagen_producto(rs.getString("imagen_producto"));
                pro.setId_categoria(rs.getInt("id_categoria"));
                //agregando el bean a la estructura de salida
                ret.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }
}
