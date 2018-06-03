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
import model.entidades.Categoria;
/**
 *
 * @author carlos
 */
public class ManagerCategoria {
    public boolean insertar(Categoria cat) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("INSERT INTO Categoria (descripcion) values (?)");
            pstmt.setString(1, cat.getDescripcion());
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
                Logger.getLogger(ManagerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public boolean actualizar(Categoria cat) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("UPDATE categoria SET descripcion = ? WEHRE id_categoria=?");
            pstmt.setString(1, cat.getDescripcion());
            pstmt.setInt(2, cat.getIdCategoria());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public boolean eliminar(int id) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("DELETE FROM Categoria WHERE id_categoria = ?");
            pstmt.setInt(1,id);
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
                Logger.getLogger(ManagerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public Categoria getCategoriaById(int id) {
        Categoria ret = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Categoria WHERE id_categoria = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                ret = new Categoria();
                ret.setIdCategoria(rs.getInt("id_categoria"));
                ret.setDescripcion(rs.getString("descripcion"));
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
                Logger.getLogger(ManagerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public ArrayList<Categoria> getAll() {
        ArrayList<Categoria> ret = new ArrayList<Categoria>();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Categoria");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                Categoria cat = new Categoria();
                cat.setIdCategoria(rs.getInt("id_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
                //agregando el bean a la estructura de salida
                ret.add(cat);
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
                Logger.getLogger(ManagerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }
    public boolean yaExiste(String descripcion){
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean r = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM categoria WHERE UPPER(descripcion) like UPPER(?)");            
            pstmt.setString(1, descripcion);
            rs = pstmt.executeQuery();
            r = rs.next();
        } catch (Exception e) {
        }finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
