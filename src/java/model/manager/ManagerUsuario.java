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
import model.entidades.Usuarios;

/**
 *
 * @author carlos
 */
public class ManagerUsuario {
    
    public boolean insertar(Usuarios u) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("INSERT INTO Usuarios (nombre,apellido,login_name,password, tipo_usuario) values (?, ?, ?, md5(?), ?)");
            pstmt.setString(1, u.getNombre());
            pstmt.setString(2, u.getApellido());
            pstmt.setString(3, u.getLogin_name());
            pstmt.setString(4, u.getPassword());
            pstmt.setInt(5, u.getTipo_usuario());
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
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public boolean actualizar(Usuarios u) {
        Connection c = null;
        PreparedStatement pstmt = null;
        boolean ret = false;
        try {
            pstmt = c.prepareStatement("UPDATE usuarios SET login_name = ? ,nombre=?, apellido=? WHERE id_usuario = ?");
            pstmt.setString(1, u.getLogin_name());
            pstmt.setString(2, u.getNombre());
            pstmt.setString(3, u.getApellido());
            pstmt.setInt(4, u.getId_usuario());
            ret = pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            pstmt = c.prepareStatement("DELETE FROM Usuarios WHERE id_usuario = ?");

            pstmt.setInt(1, id);

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
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public Usuarios getUsuariosById(int id) {
        Usuarios ret = null;
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Usuarios WHERE id_usuario = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                ret = new Usuarios();
                ret.setId_usuario(rs.getInt("id_usuario"));
                ret.setNombre(rs.getString("nombre"));
                ret.setApellido(rs.getString("apellido"));
                ret.setLogin_name(rs.getString("login_name"));
                ret.setPassword(rs.getString("password"));
                ret.setTipo_usuario(rs.getInt("tipo_usuario"));
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
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }

    public ArrayList<Usuarios> getAll() {
        ArrayList<Usuarios> ret = new ArrayList<Usuarios>();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM Usuarios");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                //Se carga el bean a partir de la base de datos
                Usuarios u = new Usuarios();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setLogin_name(rs.getString("login_name"));
                u.setPassword(rs.getString("password"));
                u.setTipo_usuario(rs.getInt("tipo_usuario"));
                //agregando el bean a la estructura de salida
                ret.add(u);
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
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }
    public Usuarios ingresar(String nombreUser, String pass){
        
        Connection c = null;
        PreparedStatement ps = null;
        Usuarios u = null;
        ResultSet rs = null;
        try {
            c = connexion.getConnection();
            ps = c.prepareStatement("SELECT * FROM usuarios WHERE login_name = ? and password = md5(?)");
            ps.setString(1, nombreUser);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new Usuarios();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setLogin_name(rs.getString("login_name"));
                u.setPassword(rs.getString("pass"));
                u.setId_usuario(rs.getInt("tipo_usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                connexion.closeConnection(c);
            } catch (SQLException ex) {
                Logger.getLogger(ManagerUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;
    }
}
