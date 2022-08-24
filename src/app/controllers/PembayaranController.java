package app.controllers;

import app.models.PembayaranModel;
import app.models.PengajuanModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PembayaranController {
    
    private app.models.PembayaranModel mpay;

    public PembayaranController() {
        try {
            this.mpay = new PembayaranModel();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Object getNasabahName(int pengajuanId) {
        try {
            ResultSet res = this.mpay.getNasabahName(pengajuanId);
            
            if(res != null) {
                res.last();
                int count = res.getRow();
                res.beforeFirst();

                if(count > 0) {
                    String nasabah = null;

                    while (res.next()) { 
                        nasabah = res.getString("nasabah");
                    }

                    return nasabah;
                } else {
                    return null;
                }
            } else {
                return null;
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
   
    public List<Map<String, Object>> listPengajuan() {
        try {
            ResultSet res = this.mpay.getListPengajuan();
            
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
                    
                    data.add(i, map);

                    i++;
                }

                return data;
            } else {
                System.err.println("List pengajuan NULL");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
