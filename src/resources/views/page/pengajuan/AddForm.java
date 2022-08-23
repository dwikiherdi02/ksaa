/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package resources.views.page.pengajuan;

// Controller
import java.awt.Color;
import resources.views.page.investor.*;
import resources.views.page.pengguna.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// SQL
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    
    private int id;
    
    // pages
    private MainForm main;
    
    public AddForm(resources.views.layout.Main frm) {
        
        try {
            this.frame = frm;
            
            init();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     
    public AddForm() {
        
        try {
            init();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     
    private void init() {
        
        try {
            
            initComponents();
        
            Object sessId = (Object) this.frame.session.getItem("id");

            if(sessId != null) {
               this.id = (int) sessId;
            } else {
               this.id = 0;
            }

            setData(this.id);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setFormatData() {
        inputId.setVisible(false);
        
        scrollNotes.setVerticalScrollBar(new ScrollBarFlat());
        inputNotes.setLineWrap(true);
        
        inputModal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputLaba.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputTotal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputCicilan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputDp.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputLamaAngsuran.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
    }
    
    private void setInputOptNasabah(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.PengajuanController sbmsCtrl = new app.controllers.PengajuanController();
            
            List<Map<String, Object>> data = sbmsCtrl.listNasabah();

            int selected = 0;
            int key = 0;
            
            model.addElement(new ComboItems(0, "-- Pilih Nasabah --"));
            
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

            inputOptNasabah.setModel(model);
            
            if(selected >= 0) {
                inputOptNasabah.setSelectedIndex(selected);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setInputOptTipePengajuan(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.PengajuanController sbmsCtrl = new app.controllers.PengajuanController();
            
            List<Map<String, Object>> data = sbmsCtrl.listTipePengajuan();

            int selected = 0;
            int key = 0;
            
            model.addElement(new ComboItems(0, "-- Pilih Tipe Pengajuan --"));
            
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

            inputOptTipePengajuan.setModel(model);
            
            System.out.println("Tipe Pengajuan selected: " + selected);
            System.out.println("---------------------------------------");
            if(selected >= 0) {
                inputOptTipePengajuan.setSelectedIndex(selected);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setInputOptTipeBarang(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.PengajuanController sbmsCtrl = new app.controllers.PengajuanController();
            
            List<Map<String, Object>> data = sbmsCtrl.listTipeBarang();

            int selected = 0;
            int key = 0;
            
            model.addElement(new ComboItems(0, "-- Pilih Tipe Barang --"));
            
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

            inputOptTipeBarang.setModel(model);
            if(selected >= 0) {
                inputOptTipeBarang.setSelectedIndex(selected);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setInputOptStatusPengajuan(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.PengajuanController sbmsCtrl = new app.controllers.PengajuanController();
            
            List<Map<String, Object>> data = sbmsCtrl.ListStatusPengajuan();

            int selected = -1;
            int key = -1;
            
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

            inputOptStPengajuan.setModel(model);
            if(selected >= 0) {
                inputOptStPengajuan.setSelectedIndex(selected);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void setData(int id) {
        System.out.println("ID Edit: " + id);
        
        setFormatData();
        
        inputId.setText(String.valueOf(id));
        
        if(id != 0) {
            System.out.println("VIEW " + id);
            app.controllers.PengajuanController sbsmCtrl = new app.controllers.PengajuanController();
                
            Map<String, Object> map = sbsmCtrl.getData(id);
            
            if(map != null) {
                setInputOptNasabah((int) map.get("nasabah_id"));
                setInputOptTipePengajuan((int) map.get("tipe_pengajuan_id"));
                setInputOptTipeBarang((int) map.get("tipe_barang_id"));
                setInputOptStatusPengajuan((int) map.get("status_pengajuan_id"));

                inputNoPengajuan.setText((String) map.get("no_pengajuan"));
                inputNamaBarang.setText((String) map.get("nama_barang"));
                inputModal.setText(String.valueOf((int) map.get("modal")));
                inputLaba.setText(String.valueOf((int) map.get("est_laba")));
                inputTotal.setText(String.valueOf((int) map.get("total")));
                inputCicilan.setText(String.valueOf((int) map.get("cicilan")));
                inputDp.setText(String.valueOf((int) map.get("dp")));
                inputLamaAngsuran.setText(String.valueOf((int) map.get("total_angsuran")));
                inputNotes.setText((String) map.get("notes"));
            } else {
                setInputOptNasabah(0);
                setInputOptTipePengajuan(0);
                setInputOptTipeBarang(0);
                setInputOptStatusPengajuan(0);

                inputNoPengajuan.setText("");
                inputNamaBarang.setText("");
                inputModal.setText("");
                inputLaba.setText("");
                inputTotal.setText("");
                inputCicilan.setText("");
                inputDp.setText("");
                inputLamaAngsuran.setText("");
                inputNotes.setText("");
            }
        } else {
            setInputOptNasabah(0);
            setInputOptTipePengajuan(0);
            setInputOptTipeBarang(0);
            setInputOptStatusPengajuan(0);
            
            inputNoPengajuan.setText("");
            inputNamaBarang.setText("");
            inputModal.setText("");
            inputLaba.setText("");
            inputTotal.setText("");
            inputCicilan.setText("");
            inputDp.setText("");
            inputLamaAngsuran.setText("");
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
        inputNoPengajuan = new javax.swing.JTextField();
        labelNasabah = new javax.swing.JLabel();
        inputOptNasabah = new resources.views.component.form.combobox.ComboBoxSuggestion();
        labelTipePengajuan = new javax.swing.JLabel();
        inputOptTipePengajuan = new resources.views.component.form.combobox.ComboBoxSuggestion();
        labelTipeBarang = new javax.swing.JLabel();
        inputOptTipeBarang = new resources.views.component.form.combobox.ComboBoxSuggestion();
        labelNamaBarang = new javax.swing.JLabel();
        inputNamaBarang = new javax.swing.JTextField();
        labelModal = new javax.swing.JLabel();
        inputModal = new javax.swing.JTextField();
        labelLaba = new javax.swing.JLabel();
        inputLaba = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        inputTotal = new javax.swing.JTextField();
        labelCicilan = new javax.swing.JLabel();
        inputCicilan = new javax.swing.JTextField();
        labelDp = new javax.swing.JLabel();
        inputDp = new javax.swing.JTextField();
        labelLamaAngsuran = new javax.swing.JLabel();
        inputLamaAngsuran = new javax.swing.JTextField();
        labelBulan = new javax.swing.JLabel();
        labelLamaAngsuran1 = new javax.swing.JLabel();
        scrollNotes = new javax.swing.JScrollPane();
        inputNotes = new javax.swing.JTextArea();
        labelStPengajuan = new javax.swing.JLabel();
        inputOptStPengajuan = new resources.views.component.form.combobox.ComboBoxSuggestion();

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
        inputId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId.setForeground(new java.awt.Color(51, 51, 51));
        inputId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputId.setEnabled(false);
        inputId.setOpaque(true);

        labelNoPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNoPengajuan.setForeground(new java.awt.Color(0, 0, 0));
        labelNoPengajuan.setText("Nomor Pengajuan");

        inputNoPengajuan.setBackground(new java.awt.Color(255, 255, 255));
        inputNoPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNoPengajuan.setForeground(new java.awt.Color(51, 51, 51));
        inputNoPengajuan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputNoPengajuan.setOpaque(true);

        labelNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNasabah.setForeground(new java.awt.Color(0, 0, 0));
        labelNasabah.setText("Nama Nasabah");

        inputOptNasabah.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelTipePengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTipePengajuan.setForeground(new java.awt.Color(0, 0, 0));
        labelTipePengajuan.setText("Tipe Pengajuan");

        inputOptTipePengajuan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptTipePengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelTipeBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTipeBarang.setForeground(new java.awt.Color(0, 0, 0));
        labelTipeBarang.setText("Tipe Barang");

        inputOptTipeBarang.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptTipeBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelNamaBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNamaBarang.setForeground(new java.awt.Color(0, 0, 0));
        labelNamaBarang.setText("Nama Barang");

        inputNamaBarang.setBackground(new java.awt.Color(255, 255, 255));
        inputNamaBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNamaBarang.setForeground(new java.awt.Color(51, 51, 51));
        inputNamaBarang.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputNamaBarang.setOpaque(true);

        labelModal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelModal.setForeground(new java.awt.Color(0, 0, 0));
        labelModal.setText("Modal (Rp)");

        inputModal.setBackground(new java.awt.Color(255, 255, 255));
        inputModal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputModal.setForeground(new java.awt.Color(51, 51, 51));
        inputModal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputModal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputModal.setOpaque(true);
        inputModal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputModalKeyReleased(evt);
            }
        });

        labelLaba.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLaba.setForeground(new java.awt.Color(0, 0, 0));
        labelLaba.setText("Keuntungan (Rp)");

        inputLaba.setBackground(new java.awt.Color(255, 255, 255));
        inputLaba.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputLaba.setForeground(new java.awt.Color(51, 51, 51));
        inputLaba.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputLaba.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputLaba.setOpaque(true);
        inputLaba.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputLabaKeyReleased(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(0, 0, 0));
        labelTotal.setText("Total (Rp)");

        inputTotal.setBackground(new java.awt.Color(238, 238, 238));
        inputTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputTotal.setForeground(new java.awt.Color(51, 51, 51));
        inputTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputTotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputTotal.setEnabled(false);
        inputTotal.setOpaque(true);

        labelCicilan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCicilan.setForeground(new java.awt.Color(0, 0, 0));
        labelCicilan.setText("Cicilan (Rp)");

        inputCicilan.setBackground(new java.awt.Color(255, 255, 255));
        inputCicilan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputCicilan.setForeground(new java.awt.Color(51, 51, 51));
        inputCicilan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputCicilan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputCicilan.setOpaque(true);
        inputCicilan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputCicilanKeyReleased(evt);
            }
        });

        labelDp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDp.setForeground(new java.awt.Color(0, 0, 0));
        labelDp.setText("Uang Muka (Rp)");

        inputDp.setBackground(new java.awt.Color(238, 238, 238));
        inputDp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputDp.setForeground(new java.awt.Color(51, 51, 51));
        inputDp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputDp.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputDp.setEnabled(false);
        inputDp.setOpaque(true);

        labelLamaAngsuran.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLamaAngsuran.setForeground(new java.awt.Color(0, 0, 0));
        labelLamaAngsuran.setText("Lama Angsuran");

        inputLamaAngsuran.setBackground(new java.awt.Color(255, 255, 255));
        inputLamaAngsuran.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputLamaAngsuran.setForeground(new java.awt.Color(51, 51, 51));
        inputLamaAngsuran.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputLamaAngsuran.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputLamaAngsuran.setOpaque(true);
        inputLamaAngsuran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputLamaAngsuranKeyReleased(evt);
            }
        });

        labelBulan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBulan.setForeground(new java.awt.Color(0, 0, 0));
        labelBulan.setText("Bulan");

        labelLamaAngsuran1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLamaAngsuran1.setForeground(new java.awt.Color(0, 0, 0));
        labelLamaAngsuran1.setText("Catatan");

        scrollNotes.setBorder(null);
        scrollNotes.setHorizontalScrollBar(null);

        inputNotes.setBackground(new java.awt.Color(255, 255, 255));
        inputNotes.setColumns(20);
        inputNotes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNotes.setForeground(new java.awt.Color(51, 51, 51));
        inputNotes.setRows(5);
        inputNotes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollNotes.setViewportView(inputNotes);

        labelStPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelStPengajuan.setForeground(new java.awt.Color(0, 0, 0));
        labelStPengajuan.setText("Status Pengajuan");

        inputOptStPengajuan.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputOptStPengajuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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
                        .addComponent(inputNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCardLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(labelNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputOptNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                                .addComponent(labelTipeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputOptTipeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCardLayout.createSequentialGroup()
                                                .addComponent(labelTipePengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputOptTipePengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelCardLayout.createSequentialGroup()
                                        .addComponent(labelModal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputModal))
                                    .addGroup(panelCardLayout.createSequentialGroup()
                                        .addComponent(labelLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(121, 121, 121)))
                        .addComponent(inputNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelBulan))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelDp, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputDp, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelStPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputOptStPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelLamaAngsuran1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(scrollNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCardLayout.createSequentialGroup()
                                .addComponent(labelCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipePengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptTipePengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTipeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputOptTipeBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputModal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLaba, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelLamaAngsuran1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptStPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAct
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnBackAct

    private void btnSaveAct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAct
        
        int id = inputId.getText().isEmpty() ? 0 : Integer.valueOf(inputId.getText());
        String noPengajuan = inputNoPengajuan.getText();
        Object nasabahId =  ((ComboItems) inputOptNasabah.getSelectedItem()).getKey();
        Object tipePengajuanId = ((ComboItems) inputOptTipePengajuan.getSelectedItem()).getKey();
        Object tipeBarangId = ((ComboItems) inputOptTipeBarang.getSelectedItem()).getKey();
        String namaBarang = inputNamaBarang.getText();
        int modal = Integer.valueOf(inputModal.getText());
        int estLaba = Integer.valueOf(inputLaba.getText());
        int total = Integer.valueOf(inputTotal.getText());
        int cicilan = Integer.valueOf(inputCicilan.getText());
        int totalAngsuran = Integer.valueOf(inputLamaAngsuran.getText());
        int dp = Integer.valueOf(inputDp.getText());
        String notes = inputNotes.getText();
        Object statusPengajuanId = ((ComboItems) inputOptStPengajuan.getSelectedItem()).getKey();
        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        LocalDate now = LocalDate.now();
//        LocalDate plus2Month = LocalDate.now().plusMonths(totalAngsuran);
//        
//        System.out.println(sdf.format(now));
//        System.out.println(sdf.format(plus2Month));
        
        String dpDate = "";
        String estEnd = "";
        if((int) statusPengajuanId == 2) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate plus2Month = LocalDate.now().plusMonths(totalAngsuran);
            
            dpDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
            estEnd = plus2Month.format(DateTimeFormatter.ISO_LOCAL_DATE);
        } else {
            dpDate = "";
            estEnd = "";
        }

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id", id);
        map.put("no_pengajuan", noPengajuan);
        map.put("nasabah_id", nasabahId);
        map.put("tipe_pengajuan_id", tipePengajuanId);
        map.put("tipe_barang_id", tipeBarangId);
        map.put("nama_barang", namaBarang);
        map.put("modal", modal);
        map.put("est_laba", estLaba);
        map.put("total", total);
        map.put("cicilan", cicilan);
        map.put("total_angsuran", totalAngsuran);
        map.put("dp", dp);
        map.put("notes", notes);
        map.put("status_pengajuan_id", statusPengajuanId);
        map.put("dp_date", dpDate);
        map.put("est_end", estEnd);

//        System.out.println("------------------------------------------");
//        System.out.println("id " + id);
//        System.out.println("noPengajuan " + noPengajuan);
//        System.out.println("nasabahId " + nasabahId);
//        System.out.println("tipePengajuanId " + tipePengajuanId);
//        System.out.println("tipeBarangId " + tipeBarangId);
//        System.out.println("namaBarang " + namaBarang);
//        System.out.println("modal " + modal);
//        System.out.println("estLaba " + estLaba);
//        System.out.println("total " + total);
//        System.out.println("cicilan " + cicilan);
//        System.out.println("totalAngsuran " + totalAngsuran);
//        System.out.println("dp " + dp);
//        System.out.println("notes " + notes);
//        System.out.println("statusPengajuanId " + statusPengajuanId);
//        System.out.println("dpDate " + dpDate);
//        System.out.println("estEnd " + estEnd);
//        System.out.println("------------------------------------------");
        
        app.controllers.PengajuanController sbmsCtrl = new app.controllers.PengajuanController();

        boolean res = sbmsCtrl.process(map);
        
        if(res == true) {
            this.frame.session.setFlashItem("successNotif", "Karyawan Berhasil Disimpan.");
        } else {
            this.frame.session.setFlashItem("errorNotif", "Gagal Disimpan.");
        }
        
        main = new MainForm(this.frame);
        
        this.frame.setPage(main);
    }//GEN-LAST:event_btnSaveAct

    private void inputModalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputModalKeyReleased
        calculateTotal();
        calculateDp();
    }//GEN-LAST:event_inputModalKeyReleased

    private void inputLabaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputLabaKeyReleased
        calculateTotal();
        calculateDp();
    }//GEN-LAST:event_inputLabaKeyReleased

    private void inputCicilanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputCicilanKeyReleased
        calculateDp();
    }//GEN-LAST:event_inputCicilanKeyReleased

    private void inputLamaAngsuranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputLamaAngsuranKeyReleased
        calculateDp();
    }//GEN-LAST:event_inputLamaAngsuranKeyReleased

    private void calculateTotal() {
        int modal = inputModal.getText().isEmpty() ? 0 : Integer.valueOf(inputModal.getText());
        int laba  = inputLaba.getText().isEmpty() ? 0 : Integer.valueOf(inputLaba.getText());
        int total = modal + laba;

        inputTotal.setText(String.valueOf(total));
    }
    
    private void calculateDp() {
        int total, cicilan, angsuran, dp;
    
        total = inputTotal.getText().isEmpty() ? 0 : Integer.valueOf(inputTotal.getText());
        cicilan = inputCicilan.getText().isEmpty() ? 0 : Integer.valueOf(inputCicilan.getText());
        angsuran = inputLamaAngsuran.getText().isEmpty() ? 0 : Integer.valueOf(inputLamaAngsuran.getText());

        if(total != 0 && cicilan != 0 && angsuran != 0) {
            System.out.println("dp = "+ total + " - (" + cicilan + " * " + angsuran + ")");
            dp = total - (cicilan * angsuran);

            inputDp.setText(String.valueOf(dp));
        } else {
            inputDp.setText("");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnBack;
    private resources.views.component.button.FlatButton btnSave;
    private javax.swing.JTextField inputCicilan;
    private javax.swing.JTextField inputDp;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputLaba;
    private javax.swing.JTextField inputLamaAngsuran;
    private javax.swing.JTextField inputModal;
    private javax.swing.JTextField inputNamaBarang;
    private javax.swing.JTextField inputNoPengajuan;
    private javax.swing.JTextArea inputNotes;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptNasabah;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptStPengajuan;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptTipeBarang;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptTipePengajuan;
    private javax.swing.JTextField inputTotal;
    private javax.swing.JLabel labelBulan;
    private javax.swing.JLabel labelCicilan;
    private javax.swing.JLabel labelDp;
    private javax.swing.JLabel labelLaba;
    private javax.swing.JLabel labelLamaAngsuran;
    private javax.swing.JLabel labelLamaAngsuran1;
    private javax.swing.JLabel labelModal;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelNasabah;
    private javax.swing.JLabel labelNoPengajuan;
    private javax.swing.JLabel labelStPengajuan;
    private javax.swing.JLabel labelTipeBarang;
    private javax.swing.JLabel labelTipePengajuan;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    private javax.swing.JScrollPane scrollNotes;
    // End of variables declaration//GEN-END:variables
}
