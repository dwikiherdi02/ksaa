package system.library;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Navigation {

    /**
     * @return the menu
     */
    public String getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(String menu) {
        this.menu = menu;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }
    
    public Navigation(String icon, String name, String menu, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.menu = menu;
        this.type = type;
    }
    
    public Navigation() {
        
    }
    
    private String icon;
    private String name;
    private String menu;
    private MenuType type;
    
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/resources/assets/icons/"+ icon +".png"));
        // ImageIcon imgIcon  = new ImageIcon(getClass().getResource("/resources/assets/icons/"+ icon +".png"));
        // Image img = imgIcon.getImage();
        // Image imgScale = img.getScaledInstance(50, 50 - 10, Image.SCALE_SMOOTH);
        // return new ImageIcon(imgScale);
    }
    
    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
