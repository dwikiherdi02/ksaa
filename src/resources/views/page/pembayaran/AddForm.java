/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package resources.views.page.pembayaran;

// Controller
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// SQL
import java.sql.SQLException;
import java.text.ParseException;

// Library
import system.library.ComboItems;

// Other Packages
import javax.swing.DefaultComboBoxModel;
import resources.views.component.ScrollBarFlat;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Dwiki
 */
public class AddForm extends javax.swing.JPanel {
    
    private resources.views.layout.Main frame;
    
    private int id;
    
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
        
        Object sessId = (Object) this.frame.session.getItem("id");
        
        if(sessId != null) {
           this.id = (int) sessId;
        } else {
           this.id = 0;
        }
        
        setData(this.id);
        
    }
    
    private void setFormatData() {
        
        inputId.setVisible(false);
        
        scrollNotes.setVerticalScrollBar(new ScrollBarFlat());
        inputNotes.setLineWrap(true);
        
        inputCicilan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
    }
    
    private void setInputOptPengajuan(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.PembayaranController payCtrl = new app.controllers.PembayaranController();
            
            List<Map<String, Object>> data = payCtrl.listPengajuan();

            int selected = 0;
            int key = 0;
            
            model.addElement(new ComboItems(0, "-- Pilih Pengajuan --"));
            
            if(data != null) {
                for (Map<String, Object> map : data) {
                    key++;

                    int id = (int) map.get("id");

                    model.addElement(new ComboItems((int) map.get("id"), (String) map.get("name")));
                    
                    if(id == idSelected) {
                        selected = key;
                    }
                }
            }

            inputOptNoPengajuan.setModel(model);
            
            if(selected >= 0) {
                inputOptNoPengajuan.setSelectedIndex(selected);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setData(int id) {
        System.out.println("ID Edit: " + id);
        
        setFormatData();
        
        inputId.setText(String.valueOf(id));
        
        app.controllers.PembayaranController payCtrl = new app.controllers.PembayaranController();
                
        Map<String, Object> map = payCtrl.getData(id);
        
        if(map != null) {
            if(id != 0) {
                inputOptNoPengajuan.setEnabled(false);
                
                setInputOptPengajuan((int) map.get("pengajuan_id"));
                inputNamaNasabah.setText((String) map.get("nasabah"));
                inputCicilan.setText(String.valueOf(map.get("nominal")));
                if(
                    map.get("date") != null
                    && String.valueOf((String) map.get("date")).length() > 0
                    && !String.valueOf((String) map.get("date")).equals("0000-00-00")
                ) {
                    SimpleDateFormat sdf = new SimpleDateFormat(inputTanggalBayar.getDateFormatString());
                    Date date;
                    try {
                        date = sdf.parse((String) map.get("date"));
                    } catch (ParseException ex) {
                        date = new Date();
                    }
                    inputTanggalBayar.setDate(date);
                } else {
                    inputTanggalBayar.setDate(null);
                }
                inputCaraBayar.setText((String) map.get("cara_bayar"));
                inputNotes.setText((String) map.get("notes"));
            } else {
                setInputOptPengajuan(0);
                inputNamaNasabah.setText("");
                inputCicilan.setText("");
                inputTanggalBayar.setDate(null);
                inputCaraBayar.setText("");
                inputNotes.setText("");
            }
        } else {
            setInputOptPengajuan(0);
            inputNamaNasabah.setText("");
            inputCicilan.setText("");
            inputTanggalBayar.setDate(null);
            inputCaraBayar.setText("");
            inputNotes.setText("");
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
        labelNoPengajuan = new javax.swing.JLabel();
        inputOptNoPengajuan = new resources.views.component.form.combobox.ComboBoxSuggestion();
        labelNamaNasabah = new javax.swing.JLabel();
        inputNamaNasabah = new javax.swing.JTextField();
        labelCicilan = new javax.swing.JLabel();
        inputCicilan = new javax.swing.JTextField();
        labelTanggalBayar = new javax.swing.JLabel();
        inputTanggalBayar = new com.toedter.calendar.JDateChooser();
        labelCaraBayar = new javax.swing.JLabel();
        inputCaraBayar = new javax.swing.JTextField();
        labelCaraBayar1 = new javax.swing.JLabel();
        scrollNotes = new javax.swing.JScrollPane();
        inputNotes = new javax.swing.JTextArea();

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

        labelNoPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNoPengajuan.setForeground(new java.awt.Color(0, 0, 0));
        labelNoPengajuan.setText("Nomor Pengajuan");

        inputOptNoPengajuan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptNoPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputOptNoPengajuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOptNoPengajuanActionPerformed(evt);
            }
        });

        labelNamaNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaNasabah.setForeground(new java.awt.Color(0, 0, 0));
        labelNamaNasabah.setText("Nominal Cicilan");

        inputNamaNasabah.setBackground(new java.awt.Color(238, 238, 238));
        inputNamaNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNamaNasabah.setForeground(new java.awt.Color(51, 51, 51));
        inputNamaNasabah.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputNamaNasabah.setEnabled(false);
        inputNamaNasabah.setOpaque(true);

        labelCicilan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCicilan.setForeground(new java.awt.Color(0, 0, 0));
        labelCicilan.setText("Nama Nasabah");

        inputCicilan.setBackground(new java.awt.Color(255, 255, 255));
        inputCicilan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputCicilan.setForeground(new java.awt.Color(51, 51, 51));
        inputCicilan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputCicilan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputCicilan.setOpaque(true);

        labelTanggalBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTanggalBayar.setForeground(new java.awt.Color(0, 0, 0));
        labelTanggalBayar.setText("Tanggal Bayar");

        inputTanggalBayar.setBackground(new java.awt.Color(255, 255, 255));
        inputTanggalBayar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), null));
        inputTanggalBayar.setForeground(new java.awt.Color(255, 255, 255));
        inputTanggalBayar.setDateFormatString("yyyy-MM-dd");
        inputTanggalBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelCaraBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCaraBayar.setForeground(new java.awt.Color(0, 0, 0));
        labelCaraBayar.setText("Cara Bayar");

        inputCaraBayar.setBackground(new java.awt.Color(255, 255, 255));
        inputCaraBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputCaraBayar.setForeground(new java.awt.Color(51, 51, 51));
        inputCaraBayar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputCaraBayar.setOpaque(true);

        labelCaraBayar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCaraBayar1.setForeground(new java.awt.Color(0, 0, 0));
        labelCaraBayar1.setText("Catatan");

        scrollNotes.setBorder(null);
        scrollNotes.setHorizontalScrollBar(null);

        inputNotes.setBackground(new java.awt.Color(255, 255, 255));
        inputNotes.setColumns(20);
        inputNotes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNotes.setForeground(new java.awt.Color(51, 51, 51));
        inputNotes.setRows(5);
        inputNotes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollNotes.setViewportView(inputNotes);

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addComponent(labelNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputOptNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                .addComponent(labelTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelCaraBayar1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelCaraBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputCaraBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 439, Short.MAX_VALUE))))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCaraBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCaraBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelCaraBayar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        int id = inputId.getText().isEmpty() ? 0 : Integer.valueOf(inputId.getText());
        Object pengajuanId = ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getKey();
        int nominal = inputCicilan.getText().isEmpty() 
                    ? 0
                    : Integer.valueOf(inputCicilan.getText());
        String date;
        if(inputTanggalBayar.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(inputTanggalBayar.getDateFormatString());
            date = sdf.format(inputTanggalBayar.getDate());
        } else {
            date = "";
        }
        String caraBayar = inputCaraBayar.getText();
        String notes = inputNotes.getText();
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("id", id);
        map.put("pengajuan_id", pengajuanId);
        map.put("nominal", nominal);
        map.put("date", date);
        map.put("cara_bayar", caraBayar);
        map.put("notes", notes);
        
        app.controllers.PembayaranController payCtrl = new app.controllers.PembayaranController();
        
        boolean res = payCtrl.process(map);
        
        if(res == true) {
            this.frame.session.setFlashItem("successNotif", "Nasabah Berhasil Disimpan.");
        } else {
            this.frame.session.setFlashItem("errorNotif", "Gagal Disimpan.");
        }
        
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnSaveAct

    private void inputOptNoPengajuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptNoPengajuanActionPerformed
        Object pengajuanId =  ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getKey();
        
        try {
            app.controllers.PembayaranController payCtrl = new app.controllers.PembayaranController();
            
            Object nasabah = payCtrl.getNasabahName((int) pengajuanId);
            
            if(nasabah != null) {
                inputNamaNasabah.setText(String.valueOf(nasabah));
            } else {
                inputNamaNasabah.setText("");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            inputNamaNasabah.setText("");
        }
        
        System.out.println("onchange: " + pengajuanId);
    }//GEN-LAST:event_inputOptNoPengajuanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnBack;
    private resources.views.component.button.FlatButton btnSave;
    private javax.swing.JTextField inputCaraBayar;
    private javax.swing.JTextField inputCicilan;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNamaNasabah;
    private javax.swing.JTextArea inputNotes;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptNoPengajuan;
    private com.toedter.calendar.JDateChooser inputTanggalBayar;
    private javax.swing.JLabel labelCaraBayar;
    private javax.swing.JLabel labelCaraBayar1;
    private javax.swing.JLabel labelCicilan;
    private javax.swing.JLabel labelNamaNasabah;
    private javax.swing.JLabel labelNoPengajuan;
    private javax.swing.JLabel labelTanggalBayar;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    private javax.swing.JScrollPane scrollNotes;
    // End of variables declaration//GEN-END:variables
}
