/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.views.page.pengajuan.table;

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
public class TablePage extends Table {

    public TablePage() {
        super();
        setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        
        Object[][] data = new Object[][]{};
        String[] titles = {
            "No Pengajuan",
            "Status Pengajuan", 
            "Status Pembiayaan",
            "Nasabah", 
            "Tipe Pengajuan", 
            "Tipe Barang", 
            "Nama Barang", 
            "Harga Modal (Rp)", 
            "Keuntungan (Rp)", 
            "Total Pengajuan (Rp)", 
            "Total DP (Rp)", 
            "Tanggal DP", 
            "Cicilan (Rp)", 
            "Lama Angsuran",   
            "Aksi"
        };
        
        setModel(new javax.swing.table.DefaultTableModel(
            data,
            titles    
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        if (getColumnModel().getColumnCount() > 0) {
            for (int i = 0; i <= 13; i++) {
                getColumnModel().getColumn(i).setMinWidth(150);
                getColumnModel().getColumn(i).setMaxWidth(150);
            }
            
            getColumnModel().getColumn(14).setMinWidth(80);
            getColumnModel().getColumn(14).setMaxWidth(80);
        }
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                
                Integer[] intArrayCenter = new Integer[]{0, 1, 2, 4, 5, 11, 13, 14};
                List<Integer> labelCenter = new ArrayList<>(Arrays.asList(intArrayCenter));
                
                Integer[] intArrayRight = new Integer[]{7, 8, 9, 10, 12};
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
        if(col == 14) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
