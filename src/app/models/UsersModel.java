package app.models;

// SQL package
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// System package
import system.core.Model;
/**
 *
 * @author Dwiki
 */
public class UsersModel extends Model {
    public UsersModel() {
        super("users");                
    }
    
    public void getById(int id) throws SQLException {
        ResultSet res;
        res = this.getDataById(id);

        while (res.next()) {
            System.out.println("ID: " + res.getInt("id"));

            System.out.println("Name: " + res.getString("name"));

            System.out.println("Username: " + res.getString("username"));

            System.out.println("Email: " + res.getString("email"));
        }
    }
}
