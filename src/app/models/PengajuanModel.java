package app.models;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import system.core.Model;

public class PengajuanModel extends Model {

    public PengajuanModel() throws ClassNotFoundException {
        super("pengajuan");
    }
    
    public ResultSet getDataById(int id) {
        
        try {
            String query = "SELECT id, "
                            + "no_pengajuan, "
                            + "nasabah_id, "
                            + "tipe_pengajuan_id, "
                            + "tipe_barang_id, "
                            + "nama_barang, "
                            + "modal, "
                            + "est_laba, "
                            + "total, "
                            + "cicilan, "
                            + "total_angsuran, "
                            + "dp, "
                            + "notes, "
                            + "status_pengajuan_id "
                         + "FROM pengajuan "
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
    
    public ResultSet getListNasabah() {
        
        try {
            String query = "SELECT id, name FROM nasabah "
                        + "WHERE deleted_at IS NULL "
                        + "ORDER BY name ASC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet getListTipePengajuan() {
        
        try {
            String query = "SELECT id, name FROM tipe_pengajuan "
                        + "ORDER BY id ASC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet getListTipeBarang() {
        
        try {
            String query = "SELECT id, name FROM tipe_barang "
                        + "ORDER BY id ASC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet getListStatusPengajuan() {
        
        try {
            String query = "SELECT id, name FROM status_pengajuan "
                        + "WHERE deleted_at IS NULL "
                        + "ORDER BY id ASC";
            
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
                                    + "LOWER(a.no_pengajuan) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(b.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(d.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(e.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(f.name) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.nama_barang) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.modal) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.est_laba) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.total) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.dp) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.dp_date) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.cicilan) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.total_angsuran) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT "
                        + "a.id, "
			+ "a.no_pengajuan, "
			+ "b.name AS status_pengajuan, "
			+ "CASE "
			+ "WHEN a.status_pengajuan_id = 1  OR a.status_pengajuan_id = 3 THEN '-' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) < a.total AND a.est_end < NOW() ) THEN 'Menunggak' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) < a.total AND a.est_end >= NOW() ) THEN 'Belum Lunas' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) >= a.total ) THEN 'Lunas' "
			+ "ELSE '-' "
			+ "END AS status_pembiayan, "
			+ "d.name AS nasabah, "
			+ "e.name AS tipe_pengajuan, "
			+ "f.name AS tipe_barang, "
			+ "a.nama_barang, "
			+ "a.modal, "
			+ "a.est_laba AS laba, "
			+ "a.total, "
			+ "a.dp, "
			+ "a.dp_date, "
			+ "a.cicilan, "
			+ "a.total_angsuran, "
                        + "a.status_pengajuan_id, "
			+"(SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) AS total_paid "
			+ "FROM pengajuan a "
			+ "LEFT JOIN status_pengajuan b ON b.id = a.status_pengajuan_id "
			+ "LEFT JOIN ( "
			+ "SELECT pengajuan_id, SUM(nominal) AS total_paid  "
			+ "FROM pembayaran WHERE deleted_at IS NULL LIMIT 1 "
			+ ") c ON c.pengajuan_id = a.id "
			+ "LEFT JOIN nasabah d ON d.id = a.nasabah_id "
			+ "LEFT JOIN tipe_pengajuan e ON e.id = a.tipe_pengajuan_id "
			+ "LEFT JOIN tipe_barang f ON f.id = a.tipe_barang_id "
			+ "WHERE a.deleted_at IS NULL "
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
    
    public boolean insert(Map<String, Object> data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            
            String column, value;
            
            if((int) data.get("status_pengajuan_id") == 2) {
                column = "("
                    + "no_pengajuan, "
                    + "nasabah_id, "
                    + "tipe_pengajuan_id, "
                    + "tipe_barang_id, "
                    + "nama_barang, "
                    + "modal, "
                    + "est_laba, "
                    + "total, "
                    + "cicilan, "
                    + "total_angsuran, "
                    + "dp, "
                    + "notes, "
                    + "status_pengajuan_id, "
                    + "created_at, "
                    + "updated_at, "
                    + "dp_date, "
                    + "est_end "
                    + ") ";
                
                value = "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            } else {
                column = "("
                    + "no_pengajuan, "
                    + "nasabah_id, "
                    + "tipe_pengajuan_id, "
                    + "tipe_barang_id, "
                    + "nama_barang, "
                    + "modal, "
                    + "est_laba, "
                    + "total, "
                    + "cicilan, "
                    + "total_angsuran, "
                    + "dp, "
                    + "notes, "
                    + "status_pengajuan_id, "
                    + "created_at, "
                    + "updated_at "
                    + ") ";
                
                value = "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            }
            String query = "INSERT INTO pengajuan " + column + " VALUES " + value;
            
            PreparedStatement ps = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, (String) data.get("no_pengajuan"));
            ps.setInt(2, (int) data.get("nasabah_id"));
            ps.setInt(3, (int) data.get("tipe_pengajuan_id"));
            ps.setInt(4, (int) data.get("tipe_barang_id"));
            ps.setString(5, (String) data.get("nama_barang"));
            ps.setInt(6, (int) data.get("modal"));
            ps.setInt(7, (int) data.get("est_laba"));
            ps.setInt(8, (int) data.get("total"));
            ps.setInt(9, (int) data.get("cicilan"));
            ps.setInt(10, (int) data.get("total_angsuran"));
            ps.setInt(11, (int) data.get("dp"));
            ps.setString(12, (String) data.get("notes"));
            ps.setInt(13, (int) data.get("status_pengajuan_id"));
            ps.setString(14, dtf.format(now));
            ps.setString(15, dtf.format(now));
            
            if((int) data.get("status_pengajuan_id") == 2) {
                ps.setString(16, (String) data.get("dp_date"));
                ps.setString(17, (String) data.get("est_end"));
            }
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int insertId;
            
            if(rs.next()) {
                insertId = rs.getInt(1);
            } else {
                insertId = 0;
            }
            
            ps.close();
            
            boolean res = true;
            
            if((int) data.get("status_pengajuan_id") == 2) {
                Map<String, Object> map = new HashMap<String, Object>();
                
                map.put("pengajuan_id", insertId);
                map.put("nominal", data.get("dp"));
                map.put("date", data.get("dp_date"));
                map.put("cara_bayar", "-");
                map.put("notes", "Bayar DP");
                
                res = insertToPembayaran(map);
            }
            
            return res;
        } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
        }
    }
    
    public boolean update(Map<String, Object> data, int id) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            
            String set;
            if((int) data.get("status_pengajuan_id") == 2) {
                set = "SET "
                    + "no_pengajuan = ?, "
                    + "nasabah_id = ?, "
                    + "tipe_pengajuan_id = ?, "
                    + "tipe_barang_id = ?, "
                    + "nama_barang = ?, "
                    + "modal = ?, "
                    + "est_laba = ?, "
                    + "total = ?, "
                    + "cicilan = ?, "
                    + "total_angsuran = ?, "
                    + "dp = ?, "
                    + "notes = ?, "
                    + "status_pengajuan_id = ?, "
                    + "created_at = ?, "
                    + "updated_at = ?, "
                    + "dp_date = ?, "
                    + "est_end = ? ";
            } else {
                set = "SET "
                    + "no_pengajuan = ?, "
                    + "nasabah_id = ?, "
                    + "tipe_pengajuan_id = ?, "
                    + "tipe_barang_id = ?, "
                    + "nama_barang = ?, "
                    + "modal = ?, "
                    + "est_laba = ?, "
                    + "total = ?, "
                    + "cicilan = ?, "
                    + "total_angsuran = ?, "
                    + "dp = ?, "
                    + "notes = ?, "
                    + "status_pengajuan_id = ?, "
                    + "created_at = ?, "
                    + "updated_at = ? ";
            }
            
            String query = "UPDATE pengajuan " + set + "WHERE id = ?";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("no_pengajuan"));
            ps.setInt(2, (int) data.get("nasabah_id"));
            ps.setInt(3, (int) data.get("tipe_pengajuan_id"));
            ps.setInt(4, (int) data.get("tipe_barang_id"));
            ps.setString(5, (String) data.get("nama_barang"));
            ps.setInt(6, (int) data.get("modal"));
            ps.setInt(7, (int) data.get("est_laba"));
            ps.setInt(8, (int) data.get("total"));
            ps.setInt(9, (int) data.get("cicilan"));
            ps.setInt(10, (int) data.get("total_angsuran"));
            ps.setInt(11, (int) data.get("dp"));
            ps.setString(12, (String) data.get("notes"));
            ps.setInt(13, (int) data.get("status_pengajuan_id"));
            ps.setString(14, dtf.format(now));
            ps.setString(15, dtf.format(now));
            
            if((int) data.get("status_pengajuan_id") == 2) {
                ps.setString(16, (String) data.get("dp_date"));
                ps.setString(17, (String) data.get("est_end"));
                ps.setInt(18, id);
            } else {
                ps.setInt(16, id);
            }
            
            ps.executeUpdate();
            
            ps.close();
            
            boolean res = true;
            
            if((int) data.get("status_pengajuan_id") == 2) {
                Map<String, Object> map = new HashMap<String, Object>();
                
                map.put("pengajuan_id", id);
                map.put("nominal", (int) data.get("dp"));
                map.put("date", (String) data.get("dp_date"));
                map.put("cara_bayar", "-");
                map.put("notes", "Bayar DP");
                
                res = insertToPembayaran(map);
            }
            
            return res;
        } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
        }
    }
    
    public boolean insertToPembayaran(Map<String, Object> data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            
            String query = "INSERT INTO pembayaran (pengajuan_id, nominal, date, cara_bayar, notes, created_at, updated_at) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

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
        } catch (SQLException e) {
           System.out.println(e.getMessage());
           return false;
        }
    }

    public boolean delete(int id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        try {
            String query = "UPDATE pengajuan "
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
