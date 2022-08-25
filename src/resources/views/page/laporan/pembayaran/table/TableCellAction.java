package resources.views.page.laporan.pembayaran.table;

import resources.views.page.laporan.lunas.table.*;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAction extends DefaultCellEditor {

    private ModelAction data;
    
    public TableCellAction() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object o, boolean isSelected, int row, int column) {
       data = (ModelAction) o;
       Action cell = new Action(data);
       
       return cell;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
