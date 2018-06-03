/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carlos
 */
public class connexion {
      public static Connection getConnection() {
        String url= "jdbc:postgresql://localhost:5432/ecommerce";
        String user = "postgres";
        String pass = "123";
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}