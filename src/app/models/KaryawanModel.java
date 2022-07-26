package app.models;

// SQL package
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// System package
import system.core.Model;

// Other Packages
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.mindrot.jbcrypt.BCrypt;

public class KaryawanModel extends Model {

    public KaryawanModel() throws ClassNotFoundException {
        super("karyawan");
    }
    
    public ResultSet getKaryawanById(int karyawanId) throws SQLException {
        String query = "SELECT a.id, a.emp_id, a.jabatan_id, a.name, a.email, a.address, a.is_pengguna, b.username "
                     + "FROM karyawan a "
                     + "LEFT JOIN pengguna b ON b.karyawan_id = a.id "
                     + "WHERE a.id = ? "
                     + "LIMIT 1";
        
        PreparedStatement ps = this.conn.prepareStatement(query);
        
        ps.setInt(1, karyawanId);

        ResultSet res = ps.executeQuery();
        
        return res;
    }
    
    public ResultSet getJabatan() throws SQLException {
        String query = "SELECT id, name "
                     + "FROM jabatan "
                     + "WHERE deleted_at IS NULL ";
            
        PreparedStatement ps = this.conn.prepareStatement(query);

        ResultSet res = ps.executeQuery();
        
        return res;
    }
    
    public ResultSet tableListKaryawan(String param) throws SQLException {
        
        String additionalCondition = "";
    
        if(!"".equals(param)) {

            param = param
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");

            additionalCondition = "AND ( "
                                + "LOWER(a.emp_id) LIKE '%"+param+"%' ESCAPE '!' "
                                + "OR LOWER(b.name) LIKE '%"+param+"%' ESCAPE '!' "
                                + "OR LOWER(a.name) LIKE '%"+param+"%' ESCAPE '!' "
                                + "OR LOWER(a.email) LIKE '%"+param+"%' ESCAPE '!' "
                                + "OR LOWER(a.address) LIKE '%"+param+"%' ESCAPE '!' "
                                + ") ";
        }
    
        String query = "SELECT a.id, a.emp_id, b.name as position, a.name "
                     + "FROM karyawan a "
                     + "LEFT JOIN jabatan b ON b.id = a.jabatan_id "
                     + "WHERE a.deleted_at IS NULL "
                     + additionalCondition
                     + "ORDER BY a.id DESC";
            
        PreparedStatement ps = this.conn.prepareStatement(query);

        ResultSet res = ps.executeQuery();
       
        return res;
    }
    
    public boolean insert(Map<String, Object> map) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        try {
            String queryEmp = "INSERT INTO karyawan (jabatan_id, emp_id, name, email, address, is_pengguna, created_at, updated_at) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement psEmp = this.conn.prepareStatement(queryEmp, Statement.RETURN_GENERATED_KEYS);
            
            psEmp.setInt(1, (int) map.get("jabatanId"));
            psEmp.setString(2, (String) map.get("empId"));
            psEmp.setString(3, (String) map.get("name"));
            psEmp.setString(4, (String) map.get("email"));
            psEmp.setString(5, (String) map.get("address"));
            psEmp.setInt(6, (int) map.get("isPengguna"));
            psEmp.setString(7, dtf.format(now));
            psEmp.setString(8, dtf.format(now));
            
            psEmp.executeUpdate();
            
            ResultSet rsEmp = psEmp.getGeneratedKeys();
            
            int insertEmpId;
            
            if(rsEmp.next()) {
                insertEmpId = rsEmp.getInt(1);
            } else {
                insertEmpId = 0;
            }
            
            psEmp.close();
            
            if((int) map.get("isPengguna") == 1) {
                String queryUser = "INSERT INTO pengguna (karyawan_id, username, password, is_active, created_at, updated_at) "
                                 + "VALUES (?, ?, ?, ?, ?, ?)";
                
                PreparedStatement psUser = this.conn.prepareStatement(queryUser, Statement.RETURN_GENERATED_KEYS);
                
                psUser.setInt(1, insertEmpId);
                psUser.setString(2, (String) map.get("username"));
                psUser.setString(3, (String) BCrypt.hashpw((String) map.get("password"), BCrypt.gensalt(12)));
                psUser.setInt(4, 1);
                psUser.setString(5, dtf.format(now));
                psUser.setString(6, dtf.format(now));
                
                psUser.executeUpdate();
                
                ResultSet rsUser = psUser.getGeneratedKeys();
            
                int insertUserId;

                if(rsUser.next()) {
                    insertUserId = rsUser.getInt(1);
                } else {
                    insertUserId = 0;
                }
                
                psUser.close();
            }
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(Map<String, Object> map, int karyawanId) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        try {

            String queryEmp = "UPDATE karyawan "
                            + "SET jabatan_id = ?, "
                            + "emp_id = ?, "
                            + "name = ?, "
                            + "email = ?, "
                            + "address = ?, "
                            + "is_pengguna = ?, "
                            + "updated_at = ? "
                            + "WHERE id = ?";
            
            PreparedStatement psEmp = this.conn.prepareStatement(queryEmp);
            
            psEmp.setInt(1, (int) map.get("jabatanId"));
            psEmp.setString(2, (String) map.get("empId"));
            psEmp.setString(3, (String) map.get("name"));
            psEmp.setString(4, (String) map.get("email"));
            psEmp.setString(5, (String) map.get("address"));
            psEmp.setInt(6, (int) map.get("isPengguna"));
            psEmp.setString(7, dtf.format(now));
            psEmp.setInt(8, karyawanId);
            
            psEmp.executeUpdate();
            
            psEmp.close();
            
            // cek pengguna
            String queryCheckUser = "SELECT karyawan_id "
                                  + "FROM pengguna "
                                  + "WHERE karyawan_id = ? ";
            
            PreparedStatement psCheckUser = this.conn.prepareStatement(queryCheckUser);
            
            psCheckUser.setInt(1, karyawanId);

            ResultSet resCheckUser = psCheckUser.executeQuery();
            
            resCheckUser.last();
            int countUser = resCheckUser.getRow();
            resCheckUser.beforeFirst();
            
            psCheckUser.close();
            
            if(countUser > 0) {
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
                                 + "updated_at = ?"
                                 + "WHERE karyawan_id = ?";

                PreparedStatement psUser = this.conn.prepareStatement(queryUser);

                psUser.setInt(1, (int) map.get("isPengguna"));
                psUser.setString(2, dtf.format(now));
                psUser.setInt(3, karyawanId);

                psUser.executeUpdate();

                psUser.close();
            } else {
                if((int) map.get("isPengguna") == 1) {
                    String queryUser = "INSERT INTO pengguna (karyawan_id, username, password, is_active, created_at, updated_at) "
                                     + "VALUES (?, ?, ?, ?, ?, ?)";

                    PreparedStatement psUser = this.conn.prepareStatement(queryUser);

                    psUser.setInt(1, karyawanId);
                    psUser.setString(2, (String) map.get("username"));
                    psUser.setString(3, (String) BCrypt.hashpw((String) map.get("password"), BCrypt.gensalt(12)));
                    psUser.setInt(4, 1);
                    psUser.setString(5, dtf.format(now));
                    psUser.setString(6, dtf.format(now));

                    psUser.executeUpdate();

                    psUser.close();
                }
            }
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String queryUpEmp = "UPDATE karyawan "
                              + "SET is_pengguna = ?, deleted_at = ?, updated_at = ? "
                              + "WHERE id = ? ";
            
            PreparedStatement psUpEmp = this.conn.prepareStatement(queryUpEmp);
            
            psUpEmp.setInt(1, 0);
            psUpEmp.setString(2, dtf.format(now));
            psUpEmp.setString(3, dtf.format(now));
            psUpEmp.setInt(4, id);
            
            psUpEmp.executeUpdate();
            
            String queryCheckUser = "SELECT karyawan_id "
                                  + "FROM pengguna "
                                  + "WHERE karyawan_id = ? ";
            
            PreparedStatement psCheckUser = this.conn.prepareStatement(queryCheckUser);
            
            psCheckUser.setInt(1, id);

            ResultSet resCheckUser = psCheckUser.executeQuery();
            
            resCheckUser.last();
            int countUser = resCheckUser.getRow();
            resCheckUser.beforeFirst();
            
            if(countUser > 0) {
                String queryUpUser = "UPDATE pengguna "
                                  + "SET is_active = ?, updated_at = ? "
                                  + "WHERE karyawan_id = ? ";
                
                System.out.println(queryUpUser);

                PreparedStatement psUpUser = this.conn.prepareStatement(queryUpUser);
                
                psUpUser.setInt(1, 0);
                psUpUser.setString(2, dtf.format(now));
                psUpUser.setInt(3, id);

                psUpUser.executeUpdate();
            }
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
