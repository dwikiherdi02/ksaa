package resources.views.page.karyawan.table;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import resources.views.component.table.Table;

/**
 *
 * @author Dwiki
 */
public class TableKaryawan extends Table {

    public TableKaryawan() {
        super();
        
        Object[][] data = new Object[][]{};
        String[] titles = {
            "No", "ID Karyawan", "Jabatan", "Nama", "Aksi"
        };
        
        setModel(new javax.swing.table.DefaultTableModel(
            data,
            titles    
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        if (getColumnModel().getColumnCount() > 0) {
            getColumnModel().getColumn(0).setMinWidth(40);
            getColumnModel().getColumn(0).setMaxWidth(40);
            
            getColumnModel().getColumn(4).setMinWidth(80);
            getColumnModel().getColumn(4).setMaxWidth(80);
        }
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                
                Integer[] intArray = new Integer[]{0, 1, 4};
                List<Integer> labelCenter = new ArrayList<>(Arrays.asList(intArray));

//                System.out.println(i);
//                System.out.println(i1);
//                System.out.println(labelCenter.contains(i1));
//                System.out.println(getModel().getValueAt(i, i1));
//                System.out.println("-----------------------------------");

                if(labelCenter.contains(i1)) {
                    setHorizontalAlignment(JLabel.CENTER);
                } else {
                    setHorizontalAlignment(JLabel.LEFT);
                }

                setBorder(noFocusBorder);
                
                if(o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);
                    
//                    if(i % 2 == 0) {
//                        cell.setBackground(Color.decode("#EEEEEE"));
//                    } else {
//                        cell.setBackground(Color.decode("#FFFFFF"));
//                    }
                    
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    com.setBackground(Color.WHITE);
                    com.setForeground(Color.decode("#333333"));

//                    if(i % 2 == 0) {
//                        com.setBackground(Color.decode("#EEEEEE"));
//                    } else {
//                        com.setBackground(Color.decode("#FFFFFF"));
//                    }

                    return com;
                }
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if(col == 4) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
