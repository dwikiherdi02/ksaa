package app.models;

// SQL package
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

// System package
import system.core.Model;

public class AuthModel extends Model {
    
    public AuthModel() throws ClassNotFoundException {
        super("users");
    }
    
    public Map<String, Object> getDataByUsername(String username) throws SQLException {
        String query = "SELECT * FROM "
                     + this.table + " "
                     + "WHERE username = ? ";
            
        PreparedStatement ps = this.conn.prepareStatement(query);

        ps.setString(1, username);

        ResultSet res = ps.executeQuery();
        
        Map<String, Object> map;
        
        map = new HashMap<String, Object>();
        
        res.last();
        int count = res.getRow();
        res.beforeFirst();
        
        if(count > 0) {
            while (res.next()) {
                map.put("id", res.getInt("id"));

                map.put("name", res.getString("name"));

                map.put("username", res.getString("username"));

                map.put("email", res.getString("email"));
                
                map.put("password", res.getString("password"));
            }

            return map;
        } else {
            return null;
        }
    }
}
