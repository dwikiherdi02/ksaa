package app.controllers;

// Model
import app.models.AuthModel;

// Library
// import system.library.Session;

// SQL package
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Map;

// Other Package

public class AuthController {
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        AuthModel mAuth = new AuthModel();
//        
//        Map<String, Object> data;
//        data = mAuth.getDataByUsername("dwikiherdi");
//        
//        String password = "1234567";
//        
//        if(data != null) {
//            System.out.println("ada");
//            
//            System.out.println("ID: " + data.get("id"));
//            
//            System.out.println("Name: " + data.get("name"));
//            
//            System.out.println("Username: " + data.get("username"));
//            
//            System.out.println("Email: " + data.get("email"));
//            
//            System.out.println("Password: " + data.get("password"));
//            
//            if (BCrypt.checkpw(password, (String) data.get("password"))) {
//                System.out.println("It matches");
//            } else {
//                System.out.println("It does not match");
//            }
//        } else {
//            System.out.println("gak ada");
//        }
//    }
    
    // private system.library.Session session;
    
    public boolean attempt(String username, String password) 
            throws ClassNotFoundException, SQLException {
        AuthModel mAuth = new AuthModel();
        
        // system.library.Session session = new system.library.Session();
        
        Map<String, Object> data;
        data = mAuth.getDataByUsername(username);
        
        if(data != null) {
            if (BCrypt.checkpw(password, (String) data.get("password"))) {
                // session.setId((int) data.get("id"));
                // session.setName((String) data.get("name"));
                // session.setUsername((String) data.get("username"));
                // session.setEmail((String) data.get("email"));
                
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
