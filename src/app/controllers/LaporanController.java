package app.controllers;

import app.models.LaporanModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaporanController {

    private app.models.LaporanModel mrprt;
    
    public LaporanController() {
        try {
            this.mrprt = new LaporanModel();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Map<String, Object>> listTablePaidOff(String param) {
        
        try {
            ResultSet res = this.mrprt.listDataLaporanLunas(param);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                int i = 0;

                while (res.next()) {            
                    Map<String, Object> map = new HashMap<String, Object>();

                    map.put("no_pengajuan", (String) res.getString("no_pengajuan"));
                    map.put("nasabah", (String) res.getString("nasabah"));
                    map.put("modal", (int) res.getInt("modal"));
                    map.put("est_laba", (int) res.getInt("est_laba"));
                    map.put("lfn_date", (String) res.getString("lfn_date"));
                    map.put("est_end", (String) res.getString("est_end"));
                    
                    data.add(i, map);

                    i++;
                }

                return data;
            } else {
                System.err.println("listData Pengajuan NULL");
                return null;
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<Map<String, Object>> listTableArrears(String param) {
        
        try {
            ResultSet res = this.mrprt.listDataLaporanMenunggak(param);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                int i = 0;

                while (res.next()) {            
                    Map<String, Object> map = new HashMap<String, Object>();

                    map.put("no_pengajuan", (String) res.getString("no_pengajuan"));
                    map.put("nasabah", (String) res.getString("nasabah"));
                    map.put("sisa", (int) res.getInt("sisa"));
                    map.put("modal", (int) res.getInt("modal"));
                    map.put("est_laba", (int) res.getInt("est_laba"));
                    map.put("lfn_date", (String) res.getString("lfn_date"));
                    map.put("est_end", (String) res.getString("est_end"));
                    
                    data.add(i, map);

                    i++;
                }

                return data;
            } else {
                System.err.println("listData Pengajuan NULL");
                return null;
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
