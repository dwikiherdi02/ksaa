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

    public boolean store(Map<String, Object> map) throws ClassNotFoundException, SQLException {
        KaryawanModel mEmp = new KaryawanModel();
        
        boolean res = mEmp.insert(map);
        
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
//            for (Map<String, Object> map : data) {
//                System.out.println(map.get("id"));
//                System.out.println(map.get("name"));
//            }            
        } else {
            return null;
        }
    }
}
