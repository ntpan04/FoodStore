/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DBUtil {
    public static final String USER_NAME="sa";
    public static final String PASSWORD="12345";
    public static final String DB_NAME="FoodStore";
    public static Connection getConnection()
    throws SQLException,ClassNotFoundException{
        Connection con = null;
        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Load url
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+DB_NAME;
        //3. Tao con
        con = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return con;
    }
}
