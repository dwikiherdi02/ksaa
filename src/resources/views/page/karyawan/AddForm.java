/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package resources.views.page.karyawan;

// Controller
import app.controllers.KaryawanController;
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
    
    private KaryawanController empCtrl;
    
    // karyawan pages
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
        
        panelCardUser.setVisible(false);
        
        this.empCtrl = new KaryawanController();
        
        scrollAddress.setVerticalScrollBar(new ScrollBarFlat());
        inputAddress.setLineWrap(true);
        
        inputId.setVisible(false);
        
        Object sessKaryawanId = (Object) this.frame.session.getItem("karyawanId");
        
        int karyawanId = 0;
        
        if(sessKaryawanId != null) {
           karyawanId = (int) sessKaryawanId;
        } else {
           karyawanId = 0;
        }
        
        System.out.println(karyawanId);
        
        setData(karyawanId);
        
        inputIsUser.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    panelCardUser.setVisible(true);
                } else {//checkbox has been deselected
                    panelCardUser.setVisible(false);
                };
            }
        });
    }
    
    private void setData(int karyawanId) throws ClassNotFoundException, SQLException {
        Map<String, Object> map = this.empCtrl.getDataKaryawanById(karyawanId);
        
        if(map != null) {
//            System.out.println(map.get("id"));
//            System.out.println(map.get("emp_id"));
//            System.out.println(map.get("jabatan_id"));
//            System.out.println(map.get("name"));
//            System.out.println(map.get("email"));
//            System.out.println(map.get("address"));
//            System.out.println(map.get("is_pengguna"));
//            System.out.println(map.get("username"));
//            System.out.println("------------------------------------------");
            
            inputId.setText(String.valueOf(karyawanId));
            inputEmpId.setText((String) map.get("emp_id"));
            setDataPosition((int) map.get("jabatan_id"));
            inputEmpName.setText((String) map.get("name"));
            inputEmail.setText((String) map.get("email"));
            inputAddress.setText((String) map.get("address"));
            inputUsername.setText((String) map.get("username"));
            
            if((int) map.get("is_pengguna") != 0) {
                inputIsUser.setSelected(true);
                panelCardUser.setVisible(true);
                // inputUserpass.setVisible(false);
            } else {
                inputIsUser.setSelected(false);
                panelCardUser.setVisible(false);
                // inputUserpass.setVisible(true);
            }
        } else {
            inputId.setText(String.valueOf(karyawanId));
            inputEmpId.setText("");
            setDataPosition(0);
            inputEmpName.setText("");
            inputEmail.setText("");
            inputAddress.setText("");
        }
    }
    
    private void setDataPosition(int jabatanId) throws ClassNotFoundException, SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        List<Map<String, Object>> data = this.empCtrl.listJabatan();
        
        int selected = -1;
        int key = -1;
        
        if(data != null) {
            for (Map<String, Object> map : data) {
                key++;
                
                int id = (int) map.get("id");
                
                model.addElement(new ComboItems((int) map.get("id"), (String) map.get("name")));
                
                if(id == jabatanId) {
                    selected = key;
                }
            }
        } else {
            model.addElement(new ComboItems("", ""));
        }
        
        inputOptPosition.setModel(model);
        if(selected >= 0) {
            inputOptPosition.setSelectedIndex(selected);
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

        panelButton = new javax.swing.JPanel();
        btnSave = new resources.views.component.button.FlatButton();
        btnBack = new resources.views.component.button.FlatButton();
        panelCard = new javax.swing.JPanel();
        inputId = new javax.swing.JTextField();
        labelEmpId = new javax.swing.JLabel();
        inputEmpId = new javax.swing.JTextField();
        labekPosition = new javax.swing.JLabel();
        labelEmpName = new javax.swing.JLabel();
        inputEmpName = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        labelAddress = new javax.swing.JLabel();
        scrollAddress = new javax.swing.JScrollPane();
        inputAddress = new javax.swing.JTextArea();
        labelAsUser = new javax.swing.JLabel();
        inputIsUser = new javax.swing.JCheckBox();
        panelCardUser = new javax.swing.JPanel();
        labelTitleUsersCard = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        labelUserpass = new javax.swing.JLabel();
        inputUserpass = new javax.swing.JPasswordField();
        inputOptPosition = new resources.views.component.form.combobox.ComboBoxSuggestion();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        inputEmpId.setBackground(new java.awt.Color(255, 255, 255));
        inputEmpId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputEmpId.setForeground(new java.awt.Color(51, 51, 51));
        inputEmpId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputEmpId.setOpaque(true);

        labekPosition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labekPosition.setForeground(new java.awt.Color(0, 0, 0));
        labekPosition.setText("Jabatan");

        labelEmpName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmpName.setForeground(new java.awt.Color(0, 0, 0));
        labelEmpName.setText("Nama Karyawan");

        inputEmpName.setBackground(new java.awt.Color(255, 255, 255));
        inputEmpName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputEmpName.setForeground(new java.awt.Color(51, 51, 51));
        inputEmpName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputEmpName.setOpaque(true);

        labelEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(0, 0, 0));
        labelEmail.setText("Email");

        inputEmail.setBackground(new java.awt.Color(255, 255, 255));
        inputEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputEmail.setForeground(new java.awt.Color(51, 51, 51));
        inputEmail.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputEmail.setOpaque(true);

        labelAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAddress.setForeground(new java.awt.Color(0, 0, 0));
        labelAddress.setText("Alamat");

        scrollAddress.setBorder(null);
        scrollAddress.setHorizontalScrollBar(null);

        inputAddress.setBackground(new java.awt.Color(255, 255, 255));
        inputAddress.setColumns(20);
        inputAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inputAddress.setForeground(new java.awt.Color(51, 51, 51));
        inputAddress.setRows(5);
        inputAddress.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollAddress.setViewportView(inputAddress);

        labelAsUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAsUser.setForeground(new java.awt.Color(0, 0, 0));
        labelAsUser.setText("Jadikan Pengguna Login");

        inputIsUser.setForeground(new java.awt.Color(204, 204, 204));

        panelCardUser.setBackground(new java.awt.Color(255, 255, 255));
        panelCardUser.setForeground(new java.awt.Color(255, 255, 255));
        panelCardUser.setOpaque(false);

        labelTitleUsersCard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelTitleUsersCard.setForeground(new java.awt.Color(85, 85, 85));
        labelTitleUsersCard.setText("Data Pengguna");
        labelTitleUsersCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1)));

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

        javax.swing.GroupLayout panelCardUserLayout = new javax.swing.GroupLayout(panelCardUser);
        panelCardUser.setLayout(panelCardUserLayout);
        panelCardUserLayout.setHorizontalGroup(
            panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardUserLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardUserLayout.createSequentialGroup()
                        .addComponent(labelTitleUsersCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardUserLayout.createSequentialGroup()
                        .addGroup(panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCardUserLayout.createSequentialGroup()
                                .addComponent(labelUserpass, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUserpass))
                            .addGroup(panelCardUserLayout.createSequentialGroup()
                                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                        .addGap(469, 469, 469))))
        );
        panelCardUserLayout.setVerticalGroup(
            panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitleUsersCard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelCardUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUserpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputUserpass, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        inputOptPosition.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptPosition.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addComponent(labelAsUser, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputIsUser)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputEmail))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputEmpName))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labekPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputOptPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addComponent(panelCardUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labekPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputIsUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAsUser, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(panelCardUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAct
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnBackAct

    private void btnSaveAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAct
        int id = Integer.valueOf(inputId.getText());
        Object jabatanId = ((ComboItems) inputOptPosition.getSelectedItem()).getKey();
        String empId = inputEmpId.getText();
        String name = inputEmpName.getText();
        String email = inputEmail.getText();
        String address = inputAddress.getText();
        int isPengguna = inputIsUser.isSelected() ? 1 : 0;
        String username = inputUsername.getText();
        String password = inputUserpass.getText();
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("id", id);
        map.put("jabatanId", jabatanId);
        map.put("empId", empId);
        map.put("name", name);
        map.put("email", email);
        map.put("address", address);
        map.put("isPengguna", isPengguna);
        map.put("username", username);
        map.put("password", password);
        
        boolean res;
        
        try {
            res = this.empCtrl.process(map);
        } catch (ClassNotFoundException ex) {
            res = false;
        } catch (SQLException ex) {
            res = false;
        }
        
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
    private javax.swing.JTextArea inputAddress;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputEmpId;
    private javax.swing.JTextField inputEmpName;
    private javax.swing.JTextField inputId;
    private javax.swing.JCheckBox inputIsUser;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptPosition;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JPasswordField inputUserpass;
    private javax.swing.JLabel labekPosition;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelAsUser;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmpId;
    private javax.swing.JLabel labelEmpName;
    private javax.swing.JLabel labelTitleUsersCard;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel labelUserpass;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelCardUser;
    private javax.swing.JScrollPane scrollAddress;
    // End of variables declaration//GEN-END:variables
}
