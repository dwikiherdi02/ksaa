package app.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SahamController {

    private app.models.SahamModel mstc;
    
    public SahamController() {
        try {
            this.mstc = new app.models.SahamModel();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public int totalStock(int investorId) {
        
        try {
            ResultSet res = this.mstc.getTotalStock(investorId);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                
                int total = 0;
                
                while (res.next()) {            
                    total = total + res.getInt("total_stock");
                }
                
                return total;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
    
    public List<Map<String, Object>> listTable(int investorId, String param) {
        
        try {
            ResultSet res = this.mstc.listData(investorId, param);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                int i = 0;

                while (res.next()) {            
                    Map<String, Object> map = new HashMap<String, Object>();

                    map.put("id", res.getInt("id"));
                    map.put("name", res.getString("name"));
                    map.put("no_saham", res.getString("no_saham"));
                    map.put("no_bukti", res.getString("no_bukti"));
                    map.put("buy_date", res.getString("buy_date"));
                    map.put("buy_price", res.getInt("buy_price"));
                    
                    data.add(i, map);

                    i++;
                }

                return data;
            } else {
                System.err.println("listData jabatan NULL");
                return null;
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean process(Map<String, Object> data) {
        
        boolean res = this.mstc.insert(data);
        
        return res;
    }
}
