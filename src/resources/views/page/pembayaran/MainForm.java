package resources.views.page.pembayaran;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import resources.views.component.ScrollBarFlat;
import resources.views.page.pembayaran.table.EventAction;
import resources.views.page.pembayaran.table.ModelTable;

/**
 *
 * @author Dwiki
 */
public class MainForm extends javax.swing.JPanel {
    
    private resources.views.layout.Main frame;   
    
    // pages
    private AddForm add;

    public MainForm(resources.views.layout.Main frm) {
        
        this.frame = frm;
        
        init();
    }
    
    public MainForm() {
        init();
    }
    
    private void init() {
        initComponents();
        
        String errMsg = (String) this.frame.session.getItem("errorNotif");
        
        String okMsg = (String) this.frame.session.getItem("successNotif");
        
        if(errMsg != null) {
            panelNotification.notify("error", errMsg);
        } else if(okMsg != null) {
            panelNotification.notify("success", okMsg);
        } else {
            panelNotification.setVisible(false);
        }
        
        scrollTable.setVerticalScrollBar(new ScrollBarFlat());
        scrollTable.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTable.getViewport().setBackground(Color.WHITE);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        loadTable(null);
    }
    
     private void loadTable(String param) {
        param = param != null ? param : "";
        
        table.clearRows();
        
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelTable emp) {
                System.out.println("Deleted ID: " + emp.getId());
            }

            @Override
            public void update(ModelTable emp) {
                System.out.println("Updated ID: " + + emp.getId());
            }
        };
        
        table.addRow(new ModelTable(1, "P210921/1", "Amirudin", "200,000", "2022-08-24", "Tranfer").toRowTable(eventAction));
        
//        try {
//             
//            EventAction eventAction = new EventAction() {
//                @Override
//                public void delete(ModelTable emp) {
//                    System.out.println("Deleted ID: " + emp.getId());
//                    
//                    try {
//                        int id = emp.getId();
//                        
//                        app.controllers.NasabahController custCtrl = new app.controllers.NasabahController();
//                        
//                        boolean res = custCtrl.remove(id);
//                        
//                        if(res == true) {
//                            panelNotification.notify("success", "Nasabah Berhasil Dihapus.");
//                            
//                            loadTable(null);
//                        } else {
//                            panelNotification.notify("error", "Gagal Dihapus.");
//                        }
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                        panelNotification.notify("error", "Gagal Dihapus.");
//                    }
//                }
//
//                @Override
//                public void update(ModelTable emp) {
//                    try {
//                        System.out.println("Updated ID: " + + emp.getId());
//
//                        int id = emp.getId();
//
//                        MainForm.this.frame.session.setFlashItem("id", id);
//
//                        MainForm.this.add = new AddForm(MainForm.this.frame);
//
//                        MainForm.this.frame.setPage(MainForm.this.add);
//                    } catch (Exception ex) {
//                        System.out.println(ex.getMessage());
//                    }
//                }
//            };
//            
//            app.controllers.NasabahController custCtrl = new app.controllers.NasabahController();
//            
//            List<Map<String, Object>> list = custCtrl.listTable(param);
//            
//            int no = 1;
//            
//            for (Map<String, Object> map : list) {
//                
//                table.addRow(
//                    new ModelTable(
//                        (int) map.get("id"), 
//                        no, 
//                        (String) map.get("name"), 
//                        (String) map.get("nik"), 
//                        (String) map.get("job"), 
//                        (String) map.get("company_name")
//                    ).toRowTable(eventAction) 
//                );
//                
//                no++;
//            }
//         } catch (Exception e) {
//             System.err.println(e.getMessage());
//         }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNotification = new resources.views.component.PanelNotification();
        panelBtn = new javax.swing.JPanel();
        btnAdd = new resources.views.component.button.FlatButton();
        panelCard = new javax.swing.JPanel();
        panelCardHeader = new javax.swing.JPanel();
        labelTableTitle = new javax.swing.JLabel();
        btnSearch = new resources.views.component.button.FlatButton();
        inputSearch = new javax.swing.JTextField();
        scrollTable = new javax.swing.JScrollPane();
        table = new resources.views.page.pembayaran.table.TablePage();

        setBackground(new java.awt.Color(238, 238, 238));
        setForeground(new java.awt.Color(238, 238, 238));

        panelBtn.setBackground(new java.awt.Color(204, 204, 204));
        panelBtn.setForeground(new java.awt.Color(204, 204, 204));
        panelBtn.setOpaque(false);

        btnAdd.setText("Tambah Pembayaran");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setRadius(10);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAct(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCard.setBackground(new java.awt.Color(255, 255, 255));
        panelCard.setForeground(new java.awt.Color(255, 255, 255));

        panelCardHeader.setOpaque(false);

        labelTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTableTitle.setForeground(new java.awt.Color(51, 51, 51));
        labelTableTitle.setText("Daftar Pembayaran Nasabah");

        btnSearch.setBackground(new java.awt.Color(0, 123, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/search.png"))); // NOI18N
        btnSearch.setBorderColor(new java.awt.Color(0, 123, 255));
        btnSearch.setColor(new java.awt.Color(0, 123, 255));
        btnSearch.setColorClick(new java.awt.Color(2, 112, 229));
        btnSearch.setColorOver(new java.awt.Color(2, 112, 229));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAct(evt);
            }
        });

        inputSearch.setBackground(new java.awt.Color(255, 255, 255));
        inputSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputSearch.setForeground(new java.awt.Color(102, 102, 102));
        inputSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputSearch.setOpaque(true);

        javax.swing.GroupLayout panelCardHeaderLayout = new javax.swing.GroupLayout(panelCardHeader);
        panelCardHeader.setLayout(panelCardHeaderLayout);
        panelCardHeaderLayout.setHorizontalGroup(
            panelCardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelTableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelCardHeaderLayout.setVerticalGroup(
            panelCardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardHeaderLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelTableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inputSearch)
        );

        scrollTable.setBorder(null);
        scrollTable.setViewportView(table);

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTable)
                    .addComponent(panelCardHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelCardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAct
        try {
            add = new AddForm(this.frame);
            
            this.frame.setPage(add);
        } catch (ClassNotFoundException ex) {
            System.exit(0);
        } catch (SQLException ex) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnAddAct

    private void btnSearchAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAct
        String param = inputSearch.getText().toLowerCase();
        
        loadTable(param);
    }//GEN-LAST:event_btnSearchAct


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnAdd;
    private resources.views.component.button.FlatButton btnSearch;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel labelTableTitle;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelCardHeader;
    private resources.views.component.PanelNotification panelNotification;
    private javax.swing.JScrollPane scrollTable;
    private resources.views.page.pembayaran.table.TablePage table;
    // End of variables declaration//GEN-END:variables
}
