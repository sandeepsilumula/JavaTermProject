/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0637609
 */
public class Database {
     /**
     * Provides a Connection to the My Sql dataBase
     * @return - the connection object or null if a connection failed
     * @throws java.sql.SQLException
     */
    
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://localhost/population";
        String user = "root";
        String pass = "";
        conn = DriverManager.getConnection(jdbc, user, pass);
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        }
        
    }
     
    
