/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemparkir.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if(connection==null){
            try{
                String url="jdbc:mysql://localhost:8889/sistem_parkir";
                String username="root";
                String password="root";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection=DriverManager.getConnection(url, username, password);
            }catch(SQLException sqlExc){
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, sqlExc);
            }
        }
        return connection;
    }
    
    
}
