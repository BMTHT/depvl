/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.Database;

import java.sql.Connection;

/**
 *
 * @author quangbach
 */
public class DatabaseConnect {
    public static final String URL = "jdbc:mysql://localhost/depvl";
    public static final String DRIVER ="com.mysql.jdbc.Driver";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "quangbach";
    public Connection getDBConnection(){
        Connection con = null;
        
        return con;
    }
}
