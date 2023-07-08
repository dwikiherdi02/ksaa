package system.library.json.structure;

import java.util.List;

/**
 *
 * @author Dwiki
 */
public class Menu {

    /**
     * @return the data
     */
    public List<MenuList> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<MenuList> data) {
        this.data = data;
    }
    
    private List<MenuList> data;
}
