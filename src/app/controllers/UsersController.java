package app.controllers;

// SQL package
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

// Model
import app.models.UsersModel;

/**
 *
 * @author Dwiki
 */
public class UsersController {
    public static void main(String[] args) throws SQLException {
        UsersModel tbUser = new UsersModel();
        
        tbUser.getById(1);
        
        System.out.println();
        
        System.out.println("-------------------------------");
        
        String password = "12345678";
        
        String candidate = "12345678";
        
        // Hash a password for the first time
        //String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        
        System.out.println(hashed);
        
        System.out.println("-------------------------------");
        
        System.out.print(candidate + ": ");

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw(candidate, hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
        }
}
