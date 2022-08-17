package app.controllers;

// Model
import app.models.AuthModel;

// SQL package
import java.sql.SQLException;
import java.sql.ResultSet;

// Other Package
import java.util.HashMap;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Map;

public class AuthController {
    
    // private system.library.Session session;
    
    public Map<String, Object> attempt(String username, String password) 
        throws ClassNotFoundException, SQLException {
        
        AuthModel mAuth = new AuthModel();
        
        ResultSet res = mAuth.getDataByUsername(username);
        
        res.last();
        int count = res.getRow();
        res.beforeFirst();
        
        if(count > 0) {
            Map<String, Object> map;  
            map = new HashMap<String, Object>();
            
            while (res.next()) {
                map.put("id", res.getInt("id"));

                map.put("name", res.getString("name"));

                map.put("username", res.getString("username"));
                
                map.put("password", res.getString("password"));
                
                map.put("is_active", res.getInt("is_active"));
            }
            
            if (BCrypt.checkpw(password, (String) map.get("password"))) {                
                return map;
            } else {
                return null;
            }    
        } else {
            return null;
        }
    }
}
