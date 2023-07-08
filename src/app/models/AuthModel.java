package app.models;

// SQL package
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// System package
import system.core.Model;

// Other Packages
import java.util.HashMap;
import java.util.Map;

public class AuthModel extends Model {
    
    public AuthModel() throws ClassNotFoundException {
        super("pengguna");
    }
    
//    public Map<String, Object> getDataByUsername(String username) throws SQLException {
    public ResultSet getDataByUsername(String username) throws SQLException {
        String query = "SELECT a.id, "
                + "b.name, "
                + "c.name as position_name, "
                + "c.code as position_code,  "
                + "a.username, "
                + "a.password, "
                + "a.is_active "
                + "FROM pengguna a "
                + "LEFT JOIN karyawan b ON b.id = a.karyawan_id "
                + "LEFT JOIN jabatan c ON c.id = b.jabatan_id "
                + "WHERE username = ? ";
            
        PreparedStatement ps = this.conn.prepareStatement(query);

        ps.setString(1, username);

        ResultSet res = ps.executeQuery();
        
        return res;
    }
}
