package app.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NasabahController {
    
    private app.models.NasabahModel mcust;

    public NasabahController() {
        try {
            this.mcust = new app.models.NasabahModel();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public List<Map<String, Object>> listTable(String param) {
        
        try {
            ResultSet res = this.mcust.listData(param);
            
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
                    map.put("nik", res.getString("nik"));
                    map.put("job", res.getString("job"));
                    map.put("company_name", res.getString("company_name"));
                    
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
            ResultSet res = this.mcust.getDataById(id);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                
                Map<String, Object> map = new HashMap<String, Object>();
                
                while (res.next()) {
                    map.put("id", res.getInt("id"));
                    map.put("name", res.getString("name"));
                    map.put("nik", res.getString("nik"));
                    map.put("birth_place", res.getString("birth_place"));
                    map.put("birth_date", res.getString("birth_date"));
                    map.put("address", res.getString("address"));
                    map.put("children", res.getInt("children"));
                    map.put("job", res.getString("job"));
                    map.put("job_length", res.getInt("job_length"));
                    map.put("company_name", res.getString("company_name"));
                    map.put("income", res.getInt("income"));
                    map.put("phone", res.getString("phone"));
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
            res = this.mcust.update(data, id);
        } else {
            // insert
            res = this.mcust.insert(data);
        }
        return res;
    }
    
    public boolean remove(int id) {
        
        try {
            boolean res = this.mcust.delete(id);
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
