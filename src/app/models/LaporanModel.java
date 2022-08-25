package app.models;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import system.core.Model;

public class LaporanModel extends Model{

    public LaporanModel() throws ClassNotFoundException {
        super("pengajuan");
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
    
    public ResultSet getDetailPengajuan(int pengajuanId) {
        
        try {
            String query = "SELECT "
                        + "b.name AS nasabah, "
                        + "a.nama_barang, "
                        + "("
                        + "a.total "
                        + "- (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1)"
                        + ") AS sisa, "
                        + "a.total_angsuran, "
                        + "a.total, "
                        + "CASE "
                        + "WHEN a.status_pengajuan_id = 1  OR a.status_pengajuan_id = 3 THEN '-' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) < a.total AND a.est_end < NOW() ) THEN 'Menunggak' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) < a.total AND a.est_end >= NOW() ) THEN 'Belum Lunas' "
			+ "WHEN (a.status_pengajuan_id = 2 AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) >= a.total ) THEN 'Lunas' "
			+ "ELSE '-' "
			+ "END AS status_pembiayan "
                        + "FROM pengajuan a "
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
    }
    
    public ResultSet listDataLaporanLunas(String param) {
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
                                    + "OR LOWER(a.modal) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.est_laba) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT "
                        + "a.no_pengajuan, "
                        + "b.name AS nasabah, "
                        + "a.modal, "
                        + "a.est_laba, "
                        + "(SELECT x.date FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS null ORDER BY x.created_at DESC, x.id DESC LIMIT 1 ) AS lfn_date, "
                        + "a.est_end "
                        + "FROM pengajuan a "
                        + "LEFT JOIN nasabah b ON b.id = a.nasabah_id "
                        + "WHERE a.deleted_at IS NULL "
                        + "AND a.status_pengajuan_id = 2  "
                        + "AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1 ) >= a.total "
                        + additionalCondition
                        + "ORDER BY a.id DESC ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ResultSet listDataLaporanMenunggak(String param) {
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
                                    + "OR LOWER(a.modal) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.est_laba) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT "
                        + "a.no_pengajuan, "
                        + "b.name AS nasabah, "
                        + "(a.total - (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) ) AS sisa, "
                        + "a.modal, "
                        + "a.est_laba, "
                        + "(SELECT x.date FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS null ORDER BY x.created_at DESC, x.id DESC LIMIT 1 ) AS lfn_date, "
                        + "a.est_end "
                        + "FROM pengajuan a "
                        + "LEFT JOIN nasabah b ON b.id = a.nasabah_id "
                        + "WHERE a.deleted_at IS NULL "
                        + "AND a.status_pengajuan_id = 2  "
                        + "AND (SELECT SUM(x.nominal) FROM pembayaran x WHERE x.pengajuan_id = a.id AND x.deleted_at IS NULL LIMIT 1) < a.total "
                        + "AND a.est_end < NOW() "
                        + additionalCondition
                        + "ORDER BY a.id DESC";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listDataPembayaran(int pengajuanId) {
        try {
            String query = "SELECT "
                    + "a.id, "
                    + "a.nominal, "
                    + "a.date, "
                    + "a.notes "
                    + "FROM pembayaran a "
                    + "LEFT JOIN pengajuan b ON b.id = a.pengajuan_id "
                    + "LEFT JOIN nasabah c ON c.id = b.nasabah_id "
                    + "WHERE a.deleted_at IS NULL "
                    + "AND a.pengajuan_id = ? "
                    + "ORDER BY a.id ASC ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, pengajuanId);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
