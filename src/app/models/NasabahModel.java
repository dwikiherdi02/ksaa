package app.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import system.core.Model;

public class NasabahModel extends Model {
    
    public NasabahModel() throws ClassNotFoundException {
        super("nasabah");
    }
    
    public ResultSet getDataById(int id) {
        
        try {
            String query = "SELECT id, "
                            + "name, "
                            + "nik, "
                            + "birth_place, "
                            + "birth_date, "
                            + "address, "
                            + "children, "
                            + "job, "
                            + "job_length, "
                            + "company_name, "
                            + "income, "
                            + "phone "
                         + "FROM nasabah "
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
                                    + "OR LOWER(nik) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(job) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(company_name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT id, name, nik, job, company_name FROM nasabah "
                    + "WHERE deleted_at IS NULL "
                    + additionalCondition
                    + "ORDER BY id DESC ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean insert(Map<String, Object> data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String query = "INSERT INTO nasabah "
                         + "("
                            + "name, "
                            + "nik, "
                            + "birth_place, "
                            + "birth_date, "
                            + "address, "
                            + "children, "
                            + "job, "
                            + "job_length, "
                            + "company_name, "
                            + "income, "
                            + "phone, "
                            + "created_at, "
                            + "updated_at "
                         + ") "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("name"));
            ps.setString(2, (String) data.get("nik"));
            ps.setString(3, (String) data.get("birth_place"));
            if(!String.valueOf(data.get("birth_date")).isEmpty()) {
                ps.setString(4, (String) data.get("birth_date"));
            } else {
                ps.setObject(4, null);
            }
            ps.setString(5, (String) data.get("address"));
            ps.setInt(6, (int) data.get("children"));
            ps.setString(7, (String) data.get("job"));
            ps.setInt(8, (int) data.get("job_length"));
            ps.setString(9, (String) data.get("company_name"));
            ps.setInt(10, (int) data.get("income"));
            ps.setString(11, (String) data.get("phone"));
            ps.setString(12, dtf.format(now));
            ps.setString(13, dtf.format(now));
            
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
            String query = "UPDATE nasabah "
                         + "SET name = ?, "
                         + "nik = ?, "
                         + "birth_place = ?, "
                         + "birth_date = ?, "
                         + "address = ?, "
                         + "children = ?, "
                         + "job = ?, "
                         + "job_length = ?, "
                         + "company_name = ?, "
                         + "income = ?, "
                         + "phone = ?, "
                         + "updated_at = ? "
                         + "WHERE id = ?";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("name"));
            ps.setString(2, (String) data.get("nik"));
            ps.setString(3, (String) data.get("birth_place"));
            if(!String.valueOf(data.get("birth_date")).isEmpty()) {
                ps.setString(4, (String) data.get("birth_date"));
            } else {
                ps.setObject(4, null);
            }
            ps.setString(5, (String) data.get("address"));
            ps.setInt(6, (int) data.get("children"));
            ps.setString(7, (String) data.get("job"));
            ps.setInt(8, (int) data.get("job_length"));
            ps.setString(9, (String) data.get("company_name"));
            ps.setInt(10, (int) data.get("income"));
            ps.setString(11, (String) data.get("phone"));
            ps.setString(12, dtf.format(now));
            ps.setInt(13, id);
            
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
            String query = "UPDATE nasabah "
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
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
