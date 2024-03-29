package resources.views.page.laporan.pembayaran;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import resources.views.component.ScrollBarFlat;
import resources.views.page.laporan.pembayaran.table.ModelTable;
import system.library.ComboItems;

/**
 *
 * @author Dwiki
 */
public class MainForm extends javax.swing.JPanel {
    
    private resources.views.layout.Main frame;
    
    private int pengajuanId;
   
    public MainForm(resources.views.layout.Main frm) {
        
        this.frame = frm;
        
        init();
    }
    
    public MainForm() {
        init();
    }
    
    private void init() {
        initComponents();
        
        scrollTable.setVerticalScrollBar(new ScrollBarFlat());
        scrollTable.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTable.getViewport().setBackground(Color.WHITE);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scrollTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        setInputOptPengajuan(0);
        
        loadTable(0);
    }
    
    private void setInputOptPengajuan(int idSelected) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
            app.controllers.LaporanController reportCtrl = new app.controllers.LaporanController();
            
            List<Map<String, Object>> data = reportCtrl.listPengajuan();

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
    
    private void loadTable(int pengajuanId) {
        table.clearRows();
        
        if(pengajuanId > 0) {
            
            try {
                app.controllers.LaporanController rprtCtrl = new app.controllers.LaporanController();

                List<Map<String, Object>> list = rprtCtrl.listTablePembayaran(pengajuanId);
                
                int no = 1;
                
                for (Map<String, Object> map : list) {
                    
                    table.addRow(
                        new ModelTable(
                            String.valueOf(no),
                            String.format("%,d", map.get("nominal")),
                            (String) map.get("date"),
                            (String) map.get("notes")
                        ).toRowTable() 
                    );
                    
                    no++;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
     }
    
    private void loadGenerateExport(Map<String, Object> map) {
        if((int) map.get("id_pengajuan") > 0) {
            
            try {
                app.controllers.LaporanController rprtCtrl = new app.controllers.LaporanController();

                List<Map<String, Object>> list = rprtCtrl.listTablePembayaran((int) map.get("id_pengajuan"));
                
                map.put("data_laporan", list);
            } catch (Exception e) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                
                map.put("data_laporan", list);
                
                System.err.println(e.getMessage());
            }
            
            try {
                system.library.ExportToPDF exportPDF = new system.library.ExportToPDF();
                exportPDF.generate(map, 1);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("err: ID pengajuan belum dipilih");
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

        panelCardFilter = new javax.swing.JPanel();
        panelCardFilterHeader = new javax.swing.JPanel();
        labelTableTitle1 = new javax.swing.JLabel();
        labelNoPengajuan = new javax.swing.JLabel();
        inputOptNoPengajuan = new resources.views.component.form.combobox.ComboBoxSuggestion();
        btnSave = new resources.views.component.button.FlatButton();
        panelLine = new javax.swing.JPanel();
        labelNasabah = new javax.swing.JLabel();
        inputNasabah = new javax.swing.JTextField();
        labelBarang = new javax.swing.JLabel();
        inputBarang = new javax.swing.JTextField();
        labelSisa = new javax.swing.JLabel();
        inputSisa = new javax.swing.JTextField();
        labelLamaAngsuran = new javax.swing.JLabel();
        inputLamaAngsuran = new javax.swing.JTextField();
        labelHargaJual = new javax.swing.JLabel();
        inputHargaJual = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();
        inputStatus = new javax.swing.JTextField();
        panelCard = new javax.swing.JPanel();
        panelCardHeader = new javax.swing.JPanel();
        labelTableTitle = new javax.swing.JLabel();
        btnExport = new resources.views.component.button.FlatButton();
        scrollTable = new javax.swing.JScrollPane();
        table = new resources.views.page.laporan.pembayaran.table.TablePage();

        setBackground(new java.awt.Color(238, 238, 238));
        setForeground(new java.awt.Color(238, 238, 238));

        panelCardFilter.setBackground(new java.awt.Color(255, 255, 255));
        panelCardFilter.setForeground(new java.awt.Color(255, 255, 255));

        panelCardFilterHeader.setOpaque(false);

        labelTableTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTableTitle1.setForeground(new java.awt.Color(51, 51, 51));
        labelTableTitle1.setText("Pencarian");

        javax.swing.GroupLayout panelCardFilterHeaderLayout = new javax.swing.GroupLayout(panelCardFilterHeader);
        panelCardFilterHeader.setLayout(panelCardFilterHeaderLayout);
        panelCardFilterHeaderLayout.setHorizontalGroup(
            panelCardFilterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardFilterHeaderLayout.createSequentialGroup()
                .addComponent(labelTableTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 834, Short.MAX_VALUE))
        );
        panelCardFilterHeaderLayout.setVerticalGroup(
            panelCardFilterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardFilterHeaderLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelTableTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnSave.setBackground(new java.awt.Color(0, 123, 255));
        btnSave.setText("Cari");
        btnSave.setBorderColor(new java.awt.Color(0, 123, 255));
        btnSave.setColor(new java.awt.Color(0, 123, 255));
        btnSave.setColorClick(new java.awt.Color(0, 123, 255));
        btnSave.setColorOver(new java.awt.Color(0, 123, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setRadius(10);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        panelLine.setBackground(new java.awt.Color(238, 238, 238));
        panelLine.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(238, 238, 238)));
        panelLine.setForeground(new java.awt.Color(238, 238, 238));
        panelLine.setOpaque(false);

        javax.swing.GroupLayout panelLineLayout = new javax.swing.GroupLayout(panelLine);
        panelLine.setLayout(panelLineLayout);
        panelLineLayout.setHorizontalGroup(
            panelLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
        );
        panelLineLayout.setVerticalGroup(
            panelLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        labelNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNasabah.setForeground(new java.awt.Color(0, 0, 0));
        labelNasabah.setText("Nama Nasabah");

        inputNasabah.setBackground(new java.awt.Color(238, 238, 238));
        inputNasabah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputNasabah.setForeground(new java.awt.Color(51, 51, 51));
        inputNasabah.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputNasabah.setEnabled(false);
        inputNasabah.setOpaque(true);

        labelBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBarang.setForeground(new java.awt.Color(0, 0, 0));
        labelBarang.setText("Nama Barang");

        inputBarang.setBackground(new java.awt.Color(238, 238, 238));
        inputBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputBarang.setForeground(new java.awt.Color(51, 51, 51));
        inputBarang.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputBarang.setEnabled(false);
        inputBarang.setOpaque(true);

        labelSisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSisa.setForeground(new java.awt.Color(0, 0, 0));
        labelSisa.setText("Sisa Cicilan");

        inputSisa.setBackground(new java.awt.Color(238, 238, 238));
        inputSisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputSisa.setForeground(new java.awt.Color(51, 51, 51));
        inputSisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputSisa.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputSisa.setEnabled(false);
        inputSisa.setOpaque(true);

        labelLamaAngsuran.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelLamaAngsuran.setForeground(new java.awt.Color(0, 0, 0));
        labelLamaAngsuran.setText("Lama Angsuran");

        inputLamaAngsuran.setBackground(new java.awt.Color(238, 238, 238));
        inputLamaAngsuran.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputLamaAngsuran.setForeground(new java.awt.Color(51, 51, 51));
        inputLamaAngsuran.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputLamaAngsuran.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputLamaAngsuran.setEnabled(false);
        inputLamaAngsuran.setOpaque(true);

        labelHargaJual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHargaJual.setForeground(new java.awt.Color(0, 0, 0));
        labelHargaJual.setText("Harga Jual");

        inputHargaJual.setBackground(new java.awt.Color(238, 238, 238));
        inputHargaJual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputHargaJual.setForeground(new java.awt.Color(51, 51, 51));
        inputHargaJual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputHargaJual.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputHargaJual.setEnabled(false);
        inputHargaJual.setOpaque(true);

        labelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 0));
        labelStatus.setText("Status Pembiayaan");

        inputStatus.setBackground(new java.awt.Color(238, 238, 238));
        inputStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputStatus.setForeground(new java.awt.Color(51, 51, 51));
        inputStatus.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(17, 17, 17)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        inputStatus.setEnabled(false);
        inputStatus.setOpaque(true);

        javax.swing.GroupLayout panelCardFilterLayout = new javax.swing.GroupLayout(panelCardFilter);
        panelCardFilter.setLayout(panelCardFilterLayout);
        panelCardFilterLayout.setHorizontalGroup(
            panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardFilterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardFilterLayout.createSequentialGroup()
                        .addComponent(labelSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardFilterLayout.createSequentialGroup()
                        .addComponent(labelBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardFilterLayout.createSequentialGroup()
                        .addComponent(labelNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCardFilterLayout.createSequentialGroup()
                        .addComponent(labelNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputOptNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCardFilterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelCardFilterLayout.setVerticalGroup(
            panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardFilterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelCardFilterHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputOptNoPengajuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelLamaAngsuran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCardFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelCard.setBackground(new java.awt.Color(255, 255, 255));
        panelCard.setForeground(new java.awt.Color(255, 255, 255));

        panelCardHeader.setOpaque(false);

        labelTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTableTitle.setForeground(new java.awt.Color(51, 51, 51));
        labelTableTitle.setText("Daftar Pembayaran");

        btnExport.setText("Export");
        btnExport.setRadius(10);
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCardHeaderLayout = new javax.swing.GroupLayout(panelCardHeader);
        panelCardHeader.setLayout(panelCardHeaderLayout);
        panelCardHeaderLayout.setHorizontalGroup(
            panelCardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(labelTableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelCardHeaderLayout.setVerticalGroup(
            panelCardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardHeaderLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(labelTableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCardFilter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelCardFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputOptNoPengajuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOptNoPengajuanActionPerformed
        Object pengajuanId =  ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getKey();
        
        System.out.println("onchange: " + pengajuanId);
        
        if((int) pengajuanId > 0) {
            try {
                app.controllers.LaporanController reportCtrl = new app.controllers.LaporanController();

                Map<String, Object> data = reportCtrl.getDetailPengajuan((int) pengajuanId);

                inputNasabah.setText((String) data.get("nasabah"));
                inputBarang.setText((String) data.get("nama_barang"));
                inputSisa.setText(String.format("%,d", data.get("sisa")));
                inputLamaAngsuran.setText(String.format("%,d", data.get("total_angsuran")));
                inputHargaJual.setText(String.format("%,d", data.get("total")));
                inputStatus.setText((String) data.get("status_pembiayan"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
                inputNasabah.setText("");
                inputBarang.setText("");
                inputSisa.setText("");
                inputLamaAngsuran.setText("");
                inputHargaJual.setText("");
                inputStatus.setText("");
            }
        } else {
            inputNasabah.setText("");
            inputBarang.setText("");
            inputSisa.setText("");
            inputLamaAngsuran.setText("");
            inputHargaJual.setText("");
            inputStatus.setText("");
        }
    }//GEN-LAST:event_inputOptNoPengajuanActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Object pengajuanId =  ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getKey();
        
        loadTable((int) pengajuanId);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        Object pengajuanId =  ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getKey();
        Object pengajuanVal =  ((ComboItems) inputOptNoPengajuan.getSelectedItem()).getValue();
        
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id_pengajuan", (int) pengajuanId);
        map.put("no_pengajuan", (String) pengajuanVal);
        map.put("nama_nasabah", inputNasabah.getText());
        map.put("nama_barang", inputBarang.getText());
        map.put("sisa_cicilan", inputSisa.getText());
        map.put("lama_angsuran", inputLamaAngsuran.getText());
        map.put("harga_jual", inputHargaJual.getText());
        map.put("status_pembiayaan", inputStatus.getText());
        
        loadGenerateExport(map);
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnExport;
    private resources.views.component.button.FlatButton btnSave;
    private javax.swing.JTextField inputBarang;
    private javax.swing.JTextField inputHargaJual;
    private javax.swing.JTextField inputLamaAngsuran;
    private javax.swing.JTextField inputNasabah;
    private resources.views.component.form.combobox.ComboBoxSuggestion inputOptNoPengajuan;
    private javax.swing.JTextField inputSisa;
    private javax.swing.JTextField inputStatus;
    private javax.swing.JLabel labelBarang;
    private javax.swing.JLabel labelHargaJual;
    private javax.swing.JLabel labelLamaAngsuran;
    private javax.swing.JLabel labelNasabah;
    private javax.swing.JLabel labelNoPengajuan;
    private javax.swing.JLabel labelSisa;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTableTitle;
    private javax.swing.JLabel labelTableTitle1;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelCardFilter;
    private javax.swing.JPanel panelCardFilterHeader;
    private javax.swing.JPanel panelCardHeader;
    private javax.swing.JPanel panelLine;
    private javax.swing.JScrollPane scrollTable;
    private resources.views.page.laporan.pembayaran.table.TablePage table;
    // End of variables declaration//GEN-END:variables
}
