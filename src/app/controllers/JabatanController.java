package app.controllers;

import app.models.JabatanModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class JabatanController {

    private app.models.JabatanModel mpos;
    
    public JabatanController() {
        try {
            this.mpos = new JabatanModel();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Map<String, Object>> listTable(String param) {
        
        try {
            ResultSet res = this.mpos.listData(param);
            
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
                    map.put("code", res.getString("code"));
                    
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
    
    public Map<String, Object> getData(int id) {
        
        try {
            ResultSet res = this.mpos.getDataById(id);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                
                Map<String, Object> map = new HashMap<String, Object>();
                
                while (res.next()) {
                    map.put("id", res.getInt("id"));
                    map.put("name", res.getString("name"));
                    map.put("code", res.getString("code"));
                }
                
                return map;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean process(Map<String, Object> data) {
        
        boolean res = false;
        
        if((int) data.get("id") != 0) {
            // update
            int id = (int) data.get("id");
            res = this.mpos.update(data, id);
        } else {
            // insert
            res = this.mpos.insert(data);
        }
        return res;
    }
    
    public boolean remove(int id) {
        
        try {
            boolean res = this.mpos.delete(id);
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
