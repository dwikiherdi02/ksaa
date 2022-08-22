package app.models;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import system.core.Model;

public class SahamModel extends Model {

    public SahamModel() throws ClassNotFoundException {
        super("saham");
    }
    
    public ResultSet getTotalStock(int investorId) {
        try {
            
            String query = "SELECT SUM(buy_price) AS total_stock "
                         + "FROM saham "
                         + "WHERE investor_id = ? "
                         + "LIMIT 1";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, investorId);
            
            ResultSet rs = ps.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet listData(int investorId, String param) {
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
                                    + "OR LOWER(a.no_saham) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.no_bukti) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.buy_date) LIKE '%"+param+"%' ESCAPE '!' "
                                    + "OR LOWER(a.buy_price) LIKE '%"+param+"%' ESCAPE '!' "
                                    + ") ";
            }
            
            String query = "SELECT a.id, b.name, a.no_saham, a.no_bukti, a.buy_date, a.buy_price "
                        + "FROM saham a "
                        + "LEFT JOIN investor b ON b.id = a.investor_id "
                        + "WHERE a.deleted_at IS NULL "
                        + "AND a.investor_id = ? "
                        + additionalCondition
                        + "ORDER BY a.buy_date DESC, a.updated_at DESC ";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setInt(1, investorId);
            
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
            String query = "INSERT INTO saham "
                         + "("
                            + "no_saham, "
                            + "investor_id, "
                            + "buy_price, "
                            + "buy_date, "
                            + "no_bukti, "
                            + "notes, "
                            + "created_at, "
                            + "updated_at "
                         + ") "
                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = this.conn.prepareStatement(query);
            
            ps.setString(1, (String) data.get("no_saham"));
            ps.setInt(2, (int) data.get("investor_id"));
            ps.setInt(3, (int) data.get("buy_price"));
            if(!String.valueOf(data.get("buy_date")).isEmpty()) {
                ps.setString(4, (String) data.get("buy_date"));
            } else {
                ps.setObject(4, null);
            }
            ps.setString(5, (String) data.get("no_bukti"));
            ps.setString(6, (String) data.get("notes"));
            ps.setString(7, dtf.format(now));
            ps.setString(8, dtf.format(now));
            
            ps.executeUpdate();
            
            ps.close();
            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
