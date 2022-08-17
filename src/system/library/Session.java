package system.library;

import java.util.HashMap;

public class Session {

    /**
     * @param key
     * @return the item
     */
    public Object getItem(String key) {
        Object i = this.item.get(key);
        
        if(this.flashItem.get(key) != null) {
            removeItem(key);
        }
        
        return i;
    }

    /**
     * @param key
     * @param value
     */
    public void setItem(String key, Object value) {
        this.item.put(key, value);
    }
    
    /**
     * @param key
     * @param value
     */
    public void setFlashItem(String key, Object value) {
        this.item.put(key, value);
        this.flashItem.put(key, true);
    }
    
    /**
     * @param key
     */
    public void removeItem(String key) {
        this.item.remove(key);
        
        if(this.flashItem.get(key) != null) {
            this.flashItem.remove(key);
        }
    }
    
    public void clearAll() {
        this.item.clear();
        this.flashItem.clear();
    }
    
    public Session() {
        this.item = new HashMap<String, Object>();
        
        this.flashItem = new HashMap<String, Object>();
    }
    
    private HashMap<String, Object> item;
    private HashMap<String, Object> flashItem;
}
