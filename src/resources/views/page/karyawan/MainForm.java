package resources.views.page.karyawan;

import app.controllers.KaryawanController;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import resources.views.component.ScrollBarFlat;
import resources.views.page.karyawan.table.EventAction;
import resources.views.page.karyawan.table.ModelTable;

/**
 *
 * @author Dwiki
 */
public class MainForm extends javax.swing.JPanel {
    
    private resources.views.layout.Main frame;
    
    private app.controllers.KaryawanController empCtrl;
    
    // karyawan pages
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
        
        this.empCtrl = new KaryawanController();
        
        String errMsg = (String) this.frame.session.getItem("errorNotif");
        
        String okMsg = (String) this.frame.session.getItem("successNotif");
        
        if(errMsg != null) {
            panelNotification.notify("error", errMsg);
        } else if(okMsg != null) {
            panelNotification.notify("success", okMsg);
        } else {
            panelNotification.setVisible(false);
        }
        
        scrollTableEmp.setVerticalScrollBar(new ScrollBarFlat());
        scrollTableEmp.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTableEmp.getViewport().setBackground(Color.WHITE);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTableEmp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        loadTableEmp(null);
    }
    
     private void loadTableEmp(String param) {
        param = param != null ? param : "";
        
        try {
                    
            List<Map<String, Object>> data = (List<Map<String, Object>>) this.empCtrl.tableList(param);
            
            tableEmp.clearRows();
            
            EventAction eventAction = new EventAction() {
                @Override
                public void delete(ModelTable emp) {
                    System.out.println("Deleted ID: " + emp.getId());
                    
                    int idEmp = emp.getId();
                    
                    try {
                        boolean resDeleteEmp = MainForm.this.empCtrl.remove(idEmp);
                        
                        if(resDeleteEmp == true) {
                            panelNotification.notify("success", "Karyawan Berhasil Dihapus.");
                            
                            loadTableEmp(null);
                        } else {
                            panelNotification.notify("error", "Karyawan Gagal Dihapus. Silahkan Hubungi Admin");
                        }
                    } catch (ClassNotFoundException ex) {
                        panelNotification.notify("error", "Karyawan Gagal Dihapus. Silahkan Hubungi Admin");
                    } catch (SQLException ex) {
                        panelNotification.notify("error", "Karyawan Gagal Dihapus. Silahkan Hubungi Admin");
                    }
                }

                @Override
                public void update(ModelTable emp) {
                    try {
                        System.out.println("Updated ID: " + emp.getId());
                        
                        int idEmp = emp.getId();
                        
                        MainForm.this.frame.session.setFlashItem("karyawanId", idEmp);
                        
                        MainForm.this.add = new AddForm(MainForm.this.frame);
                        
                        MainForm.this.frame.setPage(MainForm.this.add);
                    } catch (ClassNotFoundException ex) {
                        System.err.println(ex.getMessage());
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            };
            
            int no = 1;
            
            for (Map<String, Object> map : data) {
                
                tableEmp.addRow(
                    new ModelTable(
                            (int) map.get("id"), 
                            no, 
                            (String) map.get("emp_id"), 
                            (String) map.get("position"), 
                            (String) map.get("name")
                    ).toRowTable(eventAction)
                );
                
                no++;
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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
        btnAddEmp = new resources.views.component.button.FlatButton();
        panelCard = new javax.swing.JPanel();
        panelCardHeader = new javax.swing.JPanel();
        labelListEmp = new javax.swing.JLabel();
        btnSearch = new resources.views.component.button.FlatButton();
        inputSearch = new javax.swing.JTextField();
        scrollTableEmp = new javax.swing.JScrollPane();
        tableEmp = new resources.views.page.karyawan.table.TableKaryawan();

        setBackground(new java.awt.Color(238, 238, 238));
        setForeground(new java.awt.Color(238, 238, 238));

        panelBtn.setBackground(new java.awt.Color(204, 204, 204));
        panelBtn.setForeground(new java.awt.Color(204, 204, 204));
        panelBtn.setOpaque(false);

        btnAddEmp.setText("Tambah Karyawan");
        btnAddEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddEmp.setRadius(10);
        btnAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpAct(evt);
            }
        });

        javax.swing.GroupLayout panelBtnLayout = new javax.swing.GroupLayout(panelBtn);
        panelBtn.setLayout(panelBtnLayout);
        panelBtnLayout.setHorizontalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelBtnLayout.setVerticalGroup(
            panelBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBtnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnAddEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCard.setBackground(new java.awt.Color(255, 255, 255));
        panelCard.setForeground(new java.awt.Color(255, 255, 255));

        panelCardHeader.setOpaque(false);

        labelListEmp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelListEmp.setForeground(new java.awt.Color(51, 51, 51));
        labelListEmp.setText("Daftar Karyawan");

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
                .addComponent(labelListEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelCardHeaderLayout.setVerticalGroup(
            panelCardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardHeaderLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelListEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inputSearch)
        );

        scrollTableEmp.setBorder(null);
        scrollTableEmp.setViewportView(tableEmp);

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTableEmp)
                    .addComponent(panelCardHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelCardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scrollTableEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
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
                    .addComponent(panelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEmpAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpAct
        try {
            add = new AddForm(this.frame);
            
            this.frame.setPage(add);
        } catch (ClassNotFoundException ex) {
            System.exit(0);
        } catch (SQLException ex) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnAddEmpAct

    private void btnSearchAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAct
        String param = inputSearch.getText().toLowerCase();
        
        loadTableEmp(param);
    }//GEN-LAST:event_btnSearchAct


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnAddEmp;
    private resources.views.component.button.FlatButton btnSearch;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel labelListEmp;
    private javax.swing.JPanel panelBtn;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelCardHeader;
    private resources.views.component.PanelNotification panelNotification;
    private javax.swing.JScrollPane scrollTableEmp;
    private resources.views.page.karyawan.table.TableKaryawan tableEmp;
    // End of variables declaration//GEN-END:variables
}
