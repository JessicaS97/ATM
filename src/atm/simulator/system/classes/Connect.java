/*
 * Connection to database
 */
package atm.simulator.system.classes;

import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author jessi
 */
public class Connect {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";   //default 
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/store";

    // Establish connection to DB
    public Connect() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection made..");
            }
        } catch (Exception e) {
            System.out.println("Error connection to" + e);
        }
    }
    
    // Returns connection to DB
    public Connection getConnection() {
        return conn;
    }
    
    // Disconnect from DB
    public void disconnect() {
        conn = null;
        if (conn == null) {
            System.out.println("Connection ended..");
        }
    }
}
