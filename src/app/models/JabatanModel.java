package app.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import system.core.Model;

public class JabatanModel extends Model {

    public JabatanModel() throws ClassNotFoundException {
        super("jabatan");
    }
    
    public ResultSet getDataById(int id) {
        
        try {
            String query = "SELECT id, name, code FROM jabatan "
                    + "WHERE id = ? AND deleted_at IS NULL ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
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
                                    + "LOWER(name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(code) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT id, name, code FROM jabatan "
                    + "WHERE deleted_at IS NULL "
                    + additionalCondition
                    + "ORDER BY id DESC ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean insert(Map<String, Object> data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String query = "INSERT INTO jabatan (name, code, created_at, updated_at) "
                         + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("name"));
            ps.setString(2, (String) data.get("code"));
            ps.setString(3, dtf.format(now));
            ps.setString(4, dtf.format(now));
            
            ps.executeUpdate();
            
            ps.close();
            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(Map<String, Object> data, int id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String query = "UPDATE jabatan "
                         + "SET name = ?, "
                         + "code = ?, "
                         + "updated_at = ? "
                         + "WHERE id = ?";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("name"));
            ps.setString(2, (String) data.get("code"));
            ps.setString(3, dtf.format(now));
            ps.setInt(4, id);
            
            ps.executeUpdate();
            
            ps.close();
            
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean delete(int id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String queryCheckIsUse = "SELECT jabatan_id FROM karyawan "
                                   + "WHERE jabatan_id = ? "
                                   + "AND deleted_at IS NULL";
            
            PreparedStatement psCheckIsUse = this.conn.prepareStatement(queryCheckIsUse);
            
            psCheckIsUse.setInt(1, id);
            
            ResultSet rsCheckIsUse = psCheckIsUse.executeQuery();
            
            rsCheckIsUse.last();
            int count = rsCheckIsUse.getRow();
            rsCheckIsUse.beforeFirst();
            
            rsCheckIsUse.close();
            
            if(count > 0) {
                return false;
            } else {
                String query = "UPDATE jabatan "
                             + "SET deleted_at = ?, "
                             + "updated_at = ? "
                             + "WHERE id = ?";

               PreparedStatement ps = this.conn.prepareStatement(query);

               ps.setString(1, dtf.format(now));
               ps.setString(2, dtf.format(now));
               ps.setInt(3, id);

               ps.executeUpdate();

               ps.close();
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
