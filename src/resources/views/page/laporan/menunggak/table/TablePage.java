package resources.views.page.laporan.menunggak.table;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import resources.views.component.table.Table;

/**
 *
 * @author Dwiki
 */
public class TablePage extends Table {

    public TablePage() {
        super();
        
        Object[][] data = new Object[][]{};
        String[] titles = {
            "No Pengajuan", 
            "Nama Nasabah", 
            "Sisa Cicilan (Rp)",
            "Harga Jual (Rp)",
            "Keuntungan (Rp)",
            "Terakhir Bayar",
            "Esitmasi Lunas"
        };
        
        setModel(new javax.swing.table.DefaultTableModel(
            data,
            titles    
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        if (getColumnModel().getColumnCount() > 0) {
//            for (int i = 0; i < 6; i++) {
//                getColumnModel().getColumn(i).setMinWidth(150);
//                getColumnModel().getColumn(i).setMaxWidth(150);
//                getColumnModel().getColumn(i).setCellRenderer(new WordWrapCellRenderer());
//            }
        }
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                
                Integer[] intArrayCenter = new Integer[]{0, 5, 6};
                List<Integer> labelCenter = new ArrayList<>(Arrays.asList(intArrayCenter));
                
                Integer[] intArrayRight = new Integer[]{2, 3, 4};
                List<Integer> labelRight = new ArrayList<>(Arrays.asList(intArrayRight));

                if(labelCenter.contains(i1)) {
                    setHorizontalAlignment(JLabel.CENTER);
                } else if(labelRight.contains(i1)) {
                    setHorizontalAlignment(JLabel.RIGHT);
                } else {
                    setHorizontalAlignment(JLabel.LEFT);
                }

                setBorder(noFocusBorder);
                
                if(o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);
                    
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    com.setBackground(Color.WHITE);
                    com.setForeground(Color.decode("#333333"));

                    return com;
                }
            }
        });
    }
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        return super.getCellEditor(row, col);
    }
    
    static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
        WordWrapCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setBorder(BorderFactory.createEmptyBorder());
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }
    }
}
