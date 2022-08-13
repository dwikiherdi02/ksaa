package resources.views.component.navigation;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import resources.event.EventMenuSelected;
import system.library.Navigation;

public class NavList<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    private EventMenuSelected event;
    private String pageName;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public NavList() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof Navigation) {
                        Navigation menu = (Navigation) o;
                        if (menu.getType() == Navigation.MenuType.MENU) {
                            setPageName(menu.getName());
                            selectedIndex = index;
                            if (event != null) {
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
            
            @Override
            public void mouseExited(MouseEvent me) {
                overIndex = -1;
                repaint();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if (index != overIndex) {
                    Object o = model.getElementAt(index);
                    if (o instanceof Navigation) {
                        Navigation menu = (Navigation) o;
                        if (menu.getType() == Navigation.MenuType.MENU) {
                            overIndex = index;
                        } else {
                            overIndex = -1;
                        }
                        repaint();
                    }
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Navigation data;
                if (o instanceof Navigation) {
                    data = (Navigation) o;
                } else {
                    data = new Navigation("", o + "", Navigation.MenuType.EMPTY);
                }
                NavItem item = new NavItem(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }
        };
    }
    
    public void addItem(Navigation data) {
        model.addElement(data);
    }
}
