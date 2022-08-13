package resources.views.component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import resources.views.component.custom.ModernScrollBarUI;

public class ScrollBarFlat extends JScrollBar {
    public ScrollBarFlat() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242, 242));
        setUnitIncrement(20);
    }
}
