/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package resources.views.page.jabatan;

// Controller
import resources.views.page.investor.*;
import resources.views.page.pengguna.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// SQL
import java.sql.SQLException;

// Library
import system.library.ComboItems;

// Other Packages
import javax.swing.DefaultComboBoxModel;
import resources.views.component.ScrollBarFlat;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Dwiki
 */
public class AddForm extends javax.swing.JPanel {
    
    private resources.views.layout.Main frame;
    
    // pages
    private MainForm main;
    
    public AddForm(resources.views.layout.Main frm) throws ClassNotFoundException, SQLException {
        
        this.frame = frm;
        
        init();
    }
     
    public AddForm() throws ClassNotFoundException, SQLException {
        
        init();
    }
     
    private void init() throws ClassNotFoundException, SQLException {
        initComponents();
        
        inputId.setVisible(false);
        
        Object sessId = (Object) this.frame.session.getItem("id");
        
        int id = 0;
        
        if(sessId != null) {
           id = (int) sessId;
        } else {
           id = 0;
        }
        
        setData(id);
        
    }
    
    private void setData(int id) throws ClassNotFoundException, SQLException {
        System.out.println("ID Edit: " + id);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButton = new javax.swing.JPanel();
        btnSave = new resources.views.component.button.FlatButton();
        btnBack = new resources.views.component.button.FlatButton();
        panelCard = new javax.swing.JPanel();
        inputId = new javax.swing.JTextField();
        labelEmpId = new javax.swing.JLabel();
        inputEmpId = new javax.swing.JTextField();
        labelEmpName = new javax.swing.JLabel();
        inputEmpName = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        labelUserpass = new javax.swing.JLabel();
        inputUserpass = new javax.swing.JPasswordField();
        labelAsUser = new javax.swing.JLabel();
        inputIsUser = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(238, 238, 238));
        setForeground(new java.awt.Color(238, 238, 238));

        panelButton.setBackground(new java.awt.Color(238, 238, 238));
        panelButton.setForeground(new java.awt.Color(238, 238, 238));

        btnSave.setText("Simpan");
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setRadius(10);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAct(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/left-arrow.png"))); // NOI18N
        btnBack.setBorderColor(new java.awt.Color(255, 255, 255));
        btnBack.setColor(new java.awt.Color(255, 255, 255));
        btnBack.setColorClick(new java.awt.Color(255, 255, 255));
        btnBack.setColorOver(new java.awt.Color(255, 255, 255));
        btnBack.setRadius(10);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackAct(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap(861, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelCard.setBackground(new java.awt.Color(255, 255, 255));
        panelCard.setForeground(new java.awt.Color(255, 255, 255));

        inputId.setBackground(new java.awt.Color(255, 255, 255));
        inputId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputId.setForeground(new java.awt.Color(51, 51, 51));
        inputId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputId.setEnabled(false);
        inputId.setOpaque(true);

        labelEmpId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmpId.setForeground(new java.awt.Color(0, 0, 0));
        labelEmpId.setText("ID Karyawan");

        inputEmpId.setBackground(new java.awt.Color(238, 238, 238));
        inputEmpId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputEmpId.setForeground(new java.awt.Color(51, 51, 51));
        inputEmpId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputEmpId.setEnabled(false);
        inputEmpId.setOpaque(true);

        labelEmpName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmpName.setForeground(new java.awt.Color(0, 0, 0));
        labelEmpName.setText("Nama Karyawan");

        inputEmpName.setBackground(new java.awt.Color(238, 238, 238));
        inputEmpName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputEmpName.setForeground(new java.awt.Color(51, 51, 51));
        inputEmpName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputEmpName.setEnabled(false);
        inputEmpName.setOpaque(true);

        labelUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(0, 0, 0));
        labelUsername.setText("Nama Pengguna");

        inputUsername.setBackground(new java.awt.Color(255, 255, 255));
        inputUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputUsername.setForeground(new java.awt.Color(51, 51, 51));
        inputUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputUsername.setOpaque(true);

        labelUserpass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUserpass.setForeground(new java.awt.Color(0, 0, 0));
        labelUserpass.setText("Kata Sandi");

        inputUserpass.setBackground(new java.awt.Color(255, 255, 255));
        inputUserpass.setForeground(new java.awt.Color(51, 51, 51));
        inputUserpass.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputUserpass.setOpaque(true);

        labelAsUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAsUser.setForeground(new java.awt.Color(0, 0, 0));
        labelAsUser.setText("Status Aktif");

        inputIsUser.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addComponent(labelEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputEmpName))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                .addComponent(labelAsUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputIsUser))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                .addComponent(labelUserpass, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUserpass))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputUsername)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUserpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputUserpass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputIsUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAsUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAct
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnBackAct

    private void btnSaveAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAct
        
        boolean res = false;
        
        if(res == true) {
            this.frame.session.setFlashItem("successNotif", "Karyawan Berhasil Disimpan.");
        } else {
            this.frame.session.setFlashItem("errorNotif", "Gagal Disimpan.");
        }
        
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnSaveAct


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnBack;
    private resources.views.component.button.FlatButton btnSave;
    private javax.swing.JTextField inputEmpId;
    private javax.swing.JTextField inputEmpName;
    private javax.swing.JTextField inputId;
    private javax.swing.JCheckBox inputIsUser;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JPasswordField inputUserpass;
    private javax.swing.JLabel labelAsUser;
    private javax.swing.JLabel labelEmpId;
    private javax.swing.JLabel labelEmpName;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel labelUserpass;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    // End of variables declaration//GEN-END:variables
}
