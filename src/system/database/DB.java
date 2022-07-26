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
    
    public DB(String table) throws ClassNotFoundException {
        this.table = table;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            
            String url = "jdbc:mysql://" 
                       + app.config.DB.HOST 
                       + ":" + app.config.DB.PORT
                       + "/" + app.config.DB.NAME;
            
            this.conn = DriverManager.getConnection(
                    url,
                    app.config.DB.USER,
                    app.config.DB.PASS
            );
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}