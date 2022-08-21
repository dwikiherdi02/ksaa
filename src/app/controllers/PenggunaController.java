package app.controllers;

import app.models.PenggunaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PenggunaController {
    
    private app.models.PenggunaModel muser;

    public PenggunaController() {
        try {
            this.muser = new PenggunaModel();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Map<String, Object> getData(int id) {
        
        try {
            ResultSet res = this.muser.getDataById(id);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                Map<String, Object> map = new HashMap<String, Object>();
                
                while (res.next()) {                    
                    map.put("id", res.getInt("id"));
                    map.put("karyawan_id", res.getInt("karyawan_id"));
                    map.put("emp_id", res.getString("emp_id"));
                    map.put("name", res.getString("name"));
                    map.put("username", res.getString("username"));
                    map.put("is_active", res.getInt("is_active"));
                }
                
                return map;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<Map<String, Object>> listTable(String param) {
        try {
            ResultSet res = this.muser.listData(param);
            
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
                    map.put("username", res.getString("username"));
                    map.put("status", res.getString("status"));
                    
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
        
        boolean res = false;
        
        if((int) data.get("id") != 0) {
            // update
            int id = (int) data.get("id");
            int karyawanId = (int) data.get("karyawan_id");
            
            res = this.muser.update(data, id, karyawanId);
        } else {
            res = false;
        }
        return res;
    }
}
