package system.core;

// SQL package
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// System package
import system.database.DB;

/**
 *
 * @author Dwiki
 */
public class Model extends DB {
    
    public Model(String table) throws ClassNotFoundException {
        super(table);
    }
    
    protected ResultSet getDataById(int id) throws SQLException {
        String query = "SELECT * FROM "
                     + this.table + " "
                     + "WHERE id = ? ";
            
        PreparedStatement ps = this.conn.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet res = ps.executeQuery();
        
        return res;
    }
}