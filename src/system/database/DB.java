package system.database;

// SQL package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Dwiki
 */
public class DB {
    
    public Connection conn;
    
    public String table;
    
    public DB(String table) {
        this.table = table;
        
        try {
            String url = "jdbc:sqlite:" 
                       + app.config.DB.PATH 
                       + app.config.DB.NAME;
            
            this.conn = DriverManager.getConnection(url);            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}