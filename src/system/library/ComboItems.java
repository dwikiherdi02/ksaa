package system.library;


public class ComboItems {

    /**
     * @return the key
     */
    public Object getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    public ComboItems(Object key, String value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    private Object key;
    private String value;
    
}
