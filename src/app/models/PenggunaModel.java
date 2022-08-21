package app.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;
import system.core.Model;

public class PenggunaModel extends Model {

    public PenggunaModel() throws ClassNotFoundException {
        super("pengguna");
    }
    
    public ResultSet getDataById(int id) {
        try {
            String query = "SELECT "
                            + "a.id, "
                            + "a.karyawan_id, "
                            + "b.emp_id, "
                            + "b.name, "
                            + "a.username, "
                            + "a.is_active "
                         + "FROM Pengguna a "
                         + "LEFT JOIN karyawan b ON b.id = a.karyawan_id "
                         + "WHERE a.id = ? "
                         + "AND b.deleted_at IS NULL";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listData(String param) {
        try {
            String additionalCondition = "";
    
            if(!"".equals(param)) {

                param = param
                        .replace("!", "!!")
                        .replace("%", "!%")
                        .replace("_", "!_")
                        .replace("[", "![");

                additionalCondition = "AND ( "
                                    + "LOWER(b.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.username) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT "
                            + "a.id, "
                            + "b.name, "
                            + "a.username, "
                            + "CASE "
                                + "WHEN a.is_active = 1 THEN 'Aktif' "
                                + "ELSE 'Tidak Aktif' "
                            + "END AS status "
                         + "FROM Pengguna a "
                         + "LEFT JOIN karyawan b ON b.id = a.karyawan_id "
                         + "WHERE b.deleted_at IS NULL "
                         + additionalCondition
                         + "ORDER BY a.id DESC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean update(Map<String, Object> map, int id, int karyawanId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        try {
            // update pengguna
            String additionalSet = "";
            
            String usr = (String) map.get("username");
            String pwd = (String) map.get("password");

            if(!usr.isEmpty()) {
                String u = (String) map.get("username");
                additionalSet = additionalSet + "username = '"+u+"', ";
            }

            if(!pwd.isEmpty()) {
                String p = (String) BCrypt.hashpw((String) map.get("password"), BCrypt.gensalt(12));
                additionalSet = additionalSet + "password = '"+p+"', ";
            }
            
            String queryUser = "UPDATE pengguna "
                             + "SET "
                             + additionalSet
                             + "is_active = ?, "
                             + "updated_at = ? "
                             + "WHERE id = ? ";
            
            PreparedStatement psUser = this.conn.prepareStatement(queryUser);
            
            psUser.setInt(1, (int) map.get("is_active"));
            psUser.setString(2, dtf.format(now));
            psUser.setInt(3, id);
            
            psUser.executeUpdate();
            
            psUser.close();
            
            // update status pengguna di karyawan
            String queryEmp = "UPDATE karyawan "
                            + "SET is_pengguna = ?, updated_at = ? "
                            + "WHERE id = ?";
            
            PreparedStatement psEmp = this.conn.prepareStatement(queryEmp);
            
            psEmp.setInt(1, (int) map.get("is_active"));
            psEmp.setString(2, dtf.format(now));
            psEmp.setInt(3, karyawanId);
            
            psEmp.executeUpdate();
            
            psEmp.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
