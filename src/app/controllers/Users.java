package app.controllers;

// SQL package
import java.sql.SQLException;

/**
 *
 * @author Dwiki
 */
public class Users {
   
   public static void main(String[] args) throws SQLException {
       app.models.Users tbUsers = new app.models.Users();
       
       tbUsers.getById(1);
   } 
}