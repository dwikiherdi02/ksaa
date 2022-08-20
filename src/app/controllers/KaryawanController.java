package app.controllers;

// Model
import app.models.KaryawanModel;

// SQL package
import java.sql.SQLException;
import java.sql.ResultSet;

// Other Package
import java.util.HashMap;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class KaryawanController {
    
    public Map<String, Object> getDataKaryawanById(int karyawanId) 
        throws ClassNotFoundException, SQLException {
        
        KaryawanModel mEmp = new KaryawanModel();
        
        ResultSet res = mEmp.getKaryawanById(karyawanId);
        
        res.last();
        int count = res.getRow();
        res.beforeFirst();
        
        if(count > 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            
            while (res.next()) {            
                map.put("id", res.getInt("id"));
                map.put("emp_id", res.getString("emp_id"));
                map.put("jabatan_id", res.getInt("jabatan_id"));
                map.put("name", res.getString("name"));
                map.put("email", res.getString("email"));
                map.put("address", res.getString("address"));
                map.put("is_pengguna", res.getInt("is_pengguna"));
                map.put("username", res.getString("username"));
            }
            
            return map;
        } else {
            return null;
        }
    }

    public boolean process(Map<String, Object> map) throws ClassNotFoundException, SQLException {
        KaryawanModel mEmp = new KaryawanModel();
        
        boolean res;
        
        if((int) map.get("id") > 0) {
            res = mEmp.update(map, (int) map.get("id"));
        } else {
            res = mEmp.insert(map);
        }
        
        return res;
    }
    
    public boolean remove(int id) throws ClassNotFoundException, SQLException {
        KaryawanModel mEmp = new KaryawanModel();
        
        boolean res = mEmp.delete(id);
        
        return res;
    }
            
    public List<Map<String, Object>> listJabatan() throws ClassNotFoundException, SQLException {
        
        KaryawanModel mEmp = new KaryawanModel();
        
        ResultSet res = mEmp.getJabatan();
        
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
            return null;
        }
    }
    
    public List<Map<String, Object>> tableList(String param) 
        throws ClassNotFoundException, SQLException {
        
        KaryawanModel mEmp = new KaryawanModel();
        
        ResultSet res = mEmp.tableListKaryawan(param);
        
        res.last();
        int count = res.getRow();
        res.beforeFirst();
        
        if(count > 0) {
            List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

            int i = 0;

            while (res.next()) {            
                Map<String, Object> map = new HashMap<String, Object>();

                map.put("id", res.getInt("id"));
                map.put("emp_id", res.getString("emp_id"));
                map.put("position", res.getString("position"));
                map.put("name", res.getString("name"));

                data.add(i, map);
                
                i++;
            }
            
            return data;        
        } else {
            System.out.println("NULL");
            return null;
        }
    }
}
