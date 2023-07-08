package system.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Helper {
    
    public static boolean inArray(Object search, Object[] array) {
        List<Object> arrList = new ArrayList<>(Arrays.asList(array));
        return arrList.contains(search);
    }
}
