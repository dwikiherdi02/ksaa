/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package resources.views.page.investor;

// Controller
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
       
        inputNik.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputPhone.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputChildren.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputJobLength.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputIncome.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
             }
        });
        
        inputId.setText(String.valueOf(id));
        
        if(id != 0) {
            try {
                app.controllers.InvestorController invCtrl = new app.controllers.InvestorController();
                
                Map<String, Object> map = invCtrl.getData(id);
                
                if(map != null) {
                    System.out.println("EDIT");
                    
                    inputName.setText((String) map.get("name"));
                    inputNik.setText((String) map.get("nik"));
                    inputBirthPlace.setText((String) map.get("birth_place"));
                    if(
                        map.get("birth_date") != null
                        && String.valueOf((String) map.get("birth_date")).length() > 0
                        && !String.valueOf((String) map.get("birth_date")).equals("0000-00-00")
                    ) {
                        SimpleDateFormat sdf = new SimpleDateFormat(inputBirthDate.getDateFormatString());
                        Date date;
                        try {
                            date = sdf.parse((String) map.get("birth_date"));
                        } catch (ParseException ex) {
                            date = new Date();
                        }
                        inputBirthDate.setDate(date);
                    }
                    inputAddress.setText((String) map.get("address"));
                    inputChildren.setText(String.valueOf((int) map.get("children")));
                    inputJob.setText((String) map.get("job"));
                    inputJobLength.setText(String.valueOf((int) map.get("job_length")));
                    inputCompanyName.setText((String) map.get("company_name"));
                    inputIncome.setText(String.valueOf((int) map.get("income")));
                    inputPhone.setText((String) map.get("phone"));
                } else {
                    System.out.println("ADD");
                    inputName.setText("");
                    inputNik.setText("");
                    inputBirthPlace.setText("");
                    inputAddress.setText("");
                    inputChildren.setText("");
                    inputJob.setText("");
                    inputJobLength.setText("");
                    inputCompanyName.setText("");
                    inputIncome.setText("");
                    inputPhone.setText("");
                }
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("ADD NEW");
            inputName.setText("");
            inputNik.setText("");
            inputBirthPlace.setText("");
            inputAddress.setText("");
            inputChildren.setText("");
            inputJob.setText("");
            inputJobLength.setText("");
            inputCompanyName.setText("");
            inputIncome.setText("");
            inputPhone.setText("");
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
        labelName = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        labelNik = new javax.swing.JLabel();
        inputNik = new javax.swing.JTextField();
        labelBirthPlace = new javax.swing.JLabel();
        inputBirthPlace = new javax.swing.JTextField();
        labelBirthDate = new javax.swing.JLabel();
        inputBirthDate = new com.toedter.calendar.JDateChooser();
        labelAddress = new javax.swing.JLabel();
        scrollAddress = new javax.swing.JScrollPane();
        inputAddress = new javax.swing.JTextArea();
        labelPhone = new javax.swing.JLabel();
        inputPhone = new javax.swing.JTextField();
        labelChildren = new javax.swing.JLabel();
        inputChildren = new javax.swing.JTextField();
        labelCompanyName = new javax.swing.JLabel();
        inputCompanyName = new javax.swing.JTextField();
        labelJob = new javax.swing.JLabel();
        inputJob = new javax.swing.JTextField();
        labelJobLength = new javax.swing.JLabel();
        inputJobLength = new javax.swing.JTextField();
        labelIncome = new javax.swing.JLabel();
        inputIncome = new javax.swing.JTextField();

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

        labelName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelName.setText("Nama Investor");

        inputName.setBackground(new java.awt.Color(255, 255, 255));
        inputName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputName.setForeground(new java.awt.Color(51, 51, 51));
        inputName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelNik.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNik.setText("NIK");

        inputNik.setBackground(new java.awt.Color(255, 255, 255));
        inputNik.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNik.setForeground(new java.awt.Color(51, 51, 51));
        inputNik.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelBirthPlace.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBirthPlace.setText("Tempat Lahir");

        inputBirthPlace.setBackground(new java.awt.Color(255, 255, 255));
        inputBirthPlace.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputBirthPlace.setForeground(new java.awt.Color(51, 51, 51));
        inputBirthPlace.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelBirthDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBirthDate.setText("Tanggal Lahir");

        inputBirthDate.setBackground(new java.awt.Color(255, 255, 255));
        inputBirthDate.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), null));
        inputBirthDate.setForeground(new java.awt.Color(255, 255, 255));
        inputBirthDate.setDateFormatString("yyyy-MM-dd");
        inputBirthDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAddress.setText("Alamat");

        scrollAddress.setBorder(null);
        scrollAddress.setHorizontalScrollBar(null);

        inputAddress.setBackground(new java.awt.Color(255, 255, 255));
        inputAddress.setColumns(20);
        inputAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputAddress.setForeground(new java.awt.Color(51, 51, 51));
        inputAddress.setRows(5);
        inputAddress.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        scrollAddress.setViewportView(inputAddress);

        labelPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPhone.setText("No HP");

        inputPhone.setBackground(new java.awt.Color(255, 255, 255));
        inputPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputPhone.setForeground(new java.awt.Color(51, 51, 51));
        inputPhone.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelChildren.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelChildren.setText("Jumlah Anak");

        inputChildren.setBackground(new java.awt.Color(255, 255, 255));
        inputChildren.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputChildren.setForeground(new java.awt.Color(51, 51, 51));
        inputChildren.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputChildren.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCompanyName.setText("Nama Perusahaan");

        inputCompanyName.setBackground(new java.awt.Color(255, 255, 255));
        inputCompanyName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputCompanyName.setForeground(new java.awt.Color(51, 51, 51));
        inputCompanyName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelJob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelJob.setText("Pekerjaan");

        inputJob.setBackground(new java.awt.Color(255, 255, 255));
        inputJob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputJob.setForeground(new java.awt.Color(51, 51, 51));
        inputJob.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelJobLength.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelJobLength.setText("Lama Bekerja (Bulan)");

        inputJobLength.setBackground(new java.awt.Color(255, 255, 255));
        inputJobLength.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputJobLength.setForeground(new java.awt.Color(51, 51, 51));
        inputJobLength.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputJobLength.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        labelIncome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelIncome.setText("Pendapatan (Rp)");

        inputIncome.setBackground(new java.awt.Color(255, 255, 255));
        inputIncome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputIncome.setForeground(new java.awt.Color(51, 51, 51));
        inputIncome.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputIncome.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        javax.swing.GroupLayout panelCardLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(panelCardLayout);
        panelCardLayout.setHorizontalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelCardLayout.createSequentialGroup()
                                            .addComponent(labelCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(inputCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelJob, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelCardLayout.createSequentialGroup()
                                            .addComponent(labelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelCardLayout.createSequentialGroup()
                                            .addComponent(labelChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(inputChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(6, 6, 6)
                                    .addComponent(inputJob, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelJobLength, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputJobLength, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(labelBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panelCardLayout.createSequentialGroup()
                                    .addComponent(labelNik, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inputNik, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCardLayout.setVerticalGroup(
            panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardLayout.createSequentialGroup()
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNik)
                            .addComponent(labelNik, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputBirthPlace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(inputBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelJob, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputJob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelJobLength, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputJobLength, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
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
        
        int id = Integer.valueOf(inputId.getText());
        String name = inputName.getText();
        String nik = inputNik.getText();
        String birthPlace = inputBirthPlace.getText();
        String birthDate;
        if(inputBirthDate.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(inputBirthDate.getDateFormatString());
            birthDate = sdf.format(inputBirthDate.getDate());
        } else {
            birthDate = "";
        }
        String address = inputAddress.getText();
        int children = inputChildren.getText().isEmpty() ? 0 : Integer.valueOf(inputChildren.getText());
        String job = inputJob.getText();
        int jobLength = inputJobLength.getText().isEmpty() ? 0 : Integer.valueOf(inputJobLength.getText());
        String companyName = inputCompanyName.getText();
        int income = inputIncome.getText().isEmpty() ? 0 : Integer.valueOf(inputIncome.getText());
        String phone = inputPhone.getText();
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("id", id);
        map.put("name", name);
        map.put("nik", nik);
        map.put("birth_place", birthPlace);
        map.put("birth_date", birthDate);
        map.put("address", address);
        map.put("children", children);
        map.put("job", job);
        map.put("job_length", jobLength);
        map.put("company_name", companyName);
        map.put("income", income);
        map.put("phone", phone);
        
//        System.out.println("id: " + id);
//        System.out.println("name: " + name);
//        System.out.println("nik: " + nik);
//        System.out.println("birthPlace: " + birthPlace);
//        System.out.println("birthDate: " + birthDate);
//        System.out.println("address: " + address);
//        System.out.println("children: " + children);
//        System.out.println("job: " + job);
//        System.out.println("jobLength: " + jobLength);
//        System.out.println("companyName: " + companyName);
//        System.out.println("income: " + income);
//        System.out.println("phone: " + phone);
        
        app.controllers.InvestorController invCtrl = new app.controllers.InvestorController();
        
        boolean res = invCtrl.process(map);
        
        if(res == true) {
            this.frame.session.setFlashItem("successNotif", "Nasabah Berhasil Disimpan.");
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
    private com.toedter.calendar.JDateChooser inputBirthDate;
    private javax.swing.JTextField inputBirthPlace;
    private javax.swing.JTextField inputChildren;
    private javax.swing.JTextField inputCompanyName;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputIncome;
    private javax.swing.JTextField inputJob;
    private javax.swing.JTextField inputJobLength;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputNik;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelBirthDate;
    private javax.swing.JLabel labelBirthPlace;
    private javax.swing.JLabel labelChildren;
    private javax.swing.JLabel labelCompanyName;
    private javax.swing.JLabel labelIncome;
    private javax.swing.JLabel labelJob;
    private javax.swing.JLabel labelJobLength;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNik;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    private javax.swing.JScrollPane scrollAddress;
    // End of variables declaration//GEN-END:variables
}
