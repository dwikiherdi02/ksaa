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
    
    public List<Map<String, Object>> listTable(String param) {
        
        try {
            ResultSet res = this.mpay.listData(param);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                int i = 0;

                while (res.next()) {            
                    Map<String, Object> map = new HashMap<String, Object>();

                    map.put("id", res.getInt("id"));
                    map.put("no_pengajuan", res.getString("no_pengajuan"));
                    map.put("nasabah", res.getString("nasabah"));
                    map.put("nominal", res.getInt("nominal"));
                    map.put("date", res.getString("date"));
                    map.put("cara_bayar", res.getString("cara_bayar"));
                    
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

    public Map<String, Object> getData(int id) {
        
        try {
            ResultSet res = this.mpay.getDataById(id);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                
                Map<String, Object> map = new HashMap<String, Object>();
                
                while (res.next()) {
                    map.put("id", res.getInt("id"));
                    map.put("pengajuan_id", res.getInt("pengajuan_id"));
                    map.put("nasabah", res.getString("nasabah"));
                    map.put("nominal", res.getInt("nominal"));
                    map.put("date", res.getString("date"));
                    map.put("cara_bayar", res.getString("cara_bayar"));
                    map.put("notes", res.getString("notes"));
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
            res = this.mpay.update(data, id);
        } else {
            // insert
            res = this.mpay.insert(data);
        }
        return res;
    }

    public boolean remove(int id) {
        
        try {
            boolean res = this.mpay.delete(id);
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
