package system.library.json;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.IOException;
import system.library.Json;

/**
 *
 * @author Dwiki
 */
public class Menu {
    
    public static system.library.json.structure.Menu data() throws Exception {
        JsonNode node = Json.parse(Menu.jsonFile());
        
        system.library.json.structure.Menu menu = Json.fromJson(node, system.library.json.structure.Menu.class);
        
        return menu;
    }
    
    private static String jsonFile() throws Exception {
        
        String jsonFile = Menu.appPath + "\\json\\menuList.json";
       
        return Json.convertFileIntoString(jsonFile);
    }
    
    private static String appPath = getDefaultAppPath();
    
    private static String getDefaultAppPath() {
        
        String appPath = null;
        
        try {
            appPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            System.err.println("getDefaultAppPath Err: " + e.getMessage());
        }
        
        return appPath;
    }
}
