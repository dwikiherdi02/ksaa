package app.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import system.core.Model;

public class PenggunaModel extends Model {

    public PenggunaModel(String table) throws ClassNotFoundException {
        super("pengguna");
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
                            + "CASE"
                                + "WHEN a.is_active = 1 THE 'Aktif' "
                                + "ELSE 'Tidak Aktif' "
                            + "END AS status"
                         + "FROM Pengguna a "
                         + "LEFT JOIN karyawan b ON b.id = a.karyawan_id "
                         + "WHERE b.deleted_at IS NULL"
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
}
