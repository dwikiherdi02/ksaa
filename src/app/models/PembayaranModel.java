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
    
    public ResultSet getNasabahName(int pengajuanId) {
        if(pengajuanId > 0) {
            try {
                String query = "SELECT b.name AS nasabah FROM pengajuan a "
                            + "LEFT JOIN nasabah b on b.id = a.nasabah_id "
                            + "WHERE a.id = ? "
                            + "AND a.deleted_at IS NULL "
                            + "LIMIT 1";
                
//                System.out.println(query);

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
    
}
