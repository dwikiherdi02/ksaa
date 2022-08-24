package app.models;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import system.core.Model;

public class PembayaranModel extends Model {

    public PembayaranModel() throws ClassNotFoundException {
        super("pembayaran");
    }
    
    public ResultSet getDataById(int id) {
        
        try {
            String query = "SELECT a.id, "
                            + "a.pengajuan_id, "
                            + "c.name AS nasabah, "
                            + "a.nominal, "
                            + "a.date, "
                            + "a.cara_bayar, "
                            + "a.notes "
                         + "FROM pembayaran a "
                         + "LEFT JOIN pengajuan b ON b.id = a.pengajuan_id "
                         + "LEFT JOIN nasabah c ON c.id = b.nasabah_id "
                         + "WHERE a.id = ? AND a.deleted_at IS NULL ";
            
            System.out.println(query);
            System.out.println(id);
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public ResultSet getNasabahName(int pengajuanId) {
        if(pengajuanId > 0) {
            try {
                String query = "SELECT b.name AS nasabah FROM pengajuan a "
                            + "LEFT JOIN nasabah b on b.id = a.nasabah_id "
                            + "WHERE a.id = ? "
                            + "AND a.deleted_at IS NULL "
                            + "LIMIT 1";

                PreparedStatement ps = this.conn.prepareStatement(query);

                ps.setInt(1, pengajuanId);

                ResultSet rs = ps.executeQuery();

                return rs;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        } else {
            return null;
        }
        
    }
    
    public ResultSet getListPengajuan() {
        
        try {
            String query = "SELECT id, no_pengajuan AS name FROM pengajuan "
                        + "WHERE deleted_at IS NULL "
                        + "ORDER BY no_pengajuan ASC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
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
                                    + "LOWER(b.no_pengajuan) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(c.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.nominal) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.date) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.cara_bayar) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT "
                    + "a.id, "
                    + "b.no_pengajuan, "
                    + "c.name AS nasabah, "
                    + "a.nominal, "
                    + "a.date, "
                    + "a.cara_bayar "
                    + "FROM pembayaran a "
                    + "LEFT JOIN pengajuan b ON b.id = a.pengajuan_id "
                    + "LEFT JOIN nasabah c ON c.id = b.nasabah_id "
                    + "WHERE a.deleted_at IS NULL "
                    + additionalCondition
                    + "ORDER BY a.id DESC ";
            
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
            String column, value;
            
            column = "( " 
                        + "pengajuan_id, "
                        +"nominal, "
                        +"date, "
                        +"cara_bayar, "
                        +"notes, "
                        +"created_at, "
                        +"updated_at "
                    + ") ";
            
            value = "(?, ?, ?, ?, ?, ?, ?) ";
            
            String query = "INSERT INTO pembayaran " + column + " VALUES " + value;
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, (int) data.get("pengajuan_id"));
            ps.setInt(2, (int) data.get("nominal"));
            ps.setString(3, (String) data.get("date"));
            ps.setString(4, (String) data.get("cara_bayar"));
            ps.setString(5, (String) data.get("notes"));
            ps.setString(6, dtf.format(now));
            ps.setString(7, dtf.format(now));
            
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
            String set;
            
            set = "SET "
                +"pengajuan_id = ?, "
                +"nominal = ?, "
                +"date = ?, "
                +"cara_bayar = ?, "
                +"notes = ?, "
                +"updated_at = ? ";
            
            String query = "UPDATE pembayaran " + set + "WHERE id = ?";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, (int) data.get("pengajuan_id"));
            ps.setInt(2, (int) data.get("nominal"));
            ps.setString(3, (String) data.get("date"));
            ps.setString(4, (String) data.get("cara_bayar"));
            ps.setString(5, (String) data.get("notes"));
            ps.setString(6, dtf.format(now));
            ps.setInt(7, id);
            
            ps.executeUpdate();
            
            ps.close();
            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String query = "UPDATE pembayaran "
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
