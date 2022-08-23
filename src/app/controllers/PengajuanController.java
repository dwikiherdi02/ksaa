package app.controllers;

import app.models.PengajuanModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;


public class PengajuanController {

    private app.models.PengajuanModel msbm;
    
    public PengajuanController() {
        try {
            this.msbm = new PengajuanModel();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Map<String, Object>> listTable(String param) {
        
        try {
            ResultSet res = this.msbm.listData(param);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

                int i = 0;

                while (res.next()) {            
                    Map<String, Object> map = new HashMap<String, Object>();

                    map.put("id", res.getInt("id"));
                    map.put("status_pengajuan_id", res.getInt("status_pengajuan_id"));
                    map.put("no_pengajuan", res.getString("no_pengajuan"));
                    map.put("status_pengajuan", res.getString("status_pengajuan"));
                    map.put("status_pembiayan", res.getString("status_pembiayan"));
                    map.put("nasabah", res.getString("nasabah"));
                    map.put("tipe_pengajuan", res.getString("tipe_pengajuan"));
                    map.put("tipe_barang", res.getString("tipe_barang"));
                    map.put("nama_barang", res.getString("nama_barang"));
                    map.put("modal", res.getInt("modal"));
                    map.put("laba", res.getInt("laba"));
                    map.put("total", res.getInt("total"));
                    map.put("dp", res.getInt("dp"));
                    map.put("dp_date", res.getString("dp_date"));
                    map.put("cicilan", res.getInt("cicilan"));
                    map.put("total_angsuran", res.getInt("total_angsuran"));
                    map.put("total_paid", res.getInt("total_paid"));
                    
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
    
    public Map<String, Object> getData(int id) {
        
        try {
            ResultSet res = this.msbm.getDataById(id);
            
            res.last();
            int count = res.getRow();
            res.beforeFirst();
            
            if(count > 0) {
                
                Map<String, Object> map = new HashMap<String, Object>();
                
                while (res.next()) {
                    map.put("id", res.getInt("id"));
                    map.put("no_pengajuan", res.getString("no_pengajuan"));
                    map.put("nasabah_id", res.getInt("nasabah_id"));
                    map.put("tipe_pengajuan_id", res.getInt("tipe_pengajuan_id"));
                    map.put("tipe_barang_id", res.getInt("tipe_barang_id"));
                    map.put("nama_barang", res.getString("nama_barang"));
                    map.put("modal", res.getInt("modal"));
                    map.put("est_laba", res.getInt("est_laba"));
                    map.put("total", res.getInt("total"));
                    map.put("cicilan", res.getInt("cicilan"));
                    map.put("total_angsuran", res.getInt("total_angsuran"));
                    map.put("dp", res.getInt("dp"));
                    map.put("notes", res.getString("notes"));
                    map.put("status_pengajuan_id", res.getInt("status_pengajuan_id"));
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
    
    public List<Map<String, Object>> listNasabah() {
        try {
            ResultSet res = this.msbm.getListNasabah();
            
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
                System.err.println("List nasabah NULL");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<Map<String, Object>> listTipePengajuan() {
        try {
            ResultSet res = this.msbm.getListTipePengajuan();
            
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
                System.err.println("List nasabah NULL");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<Map<String, Object>> listTipeBarang() {
        try {
            ResultSet res = this.msbm.getListTipeBarang();
            
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
                System.err.println("List nasabah NULL");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public List<Map<String, Object>> ListStatusPengajuan() {
        try {
            ResultSet res = this.msbm.getListStatusPengajuan();
            
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
                System.err.println("List nasabah NULL");
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
            res = this.msbm.update(data, id);
        } else {
            // insert
            res = this.msbm.insert(data);
        }
        return res;
    }

    public boolean remove(int id) {
        
        try {
            boolean res = this.msbm.delete(id);
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
