/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangbach
 */
public class DatabaseConnect {
    private static final String URL = "jdbc:mysql://localhost/depvl";
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "quangbach";
    public static Connection getDBConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
   
}
