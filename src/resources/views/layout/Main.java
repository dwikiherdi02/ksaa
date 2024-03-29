package resources.views.layout;

// Pakcages
import java.awt.Color;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import resources.event.EventMenuSelected;
import resources.views.component.ScrollBarFlat;
import resources.views.page.*;
import system.library.Helper;
import system.library.json.Menu;

/**
 *
 * @author Dwiki
 */
public class Main extends javax.swing.JFrame {

    public system.library.Session session;
    
    public Main(Map<String, Object> auth) {
        this.session = new system.library.Session();
        this.session.setItem("user", auth);
        this.session.setItem("user.id", (int) auth.get("id"));
        this.session.setItem("user.name", (String) auth.get("name"));
        this.session.setItem("user.position_name", (String) auth.get("position_name"));
        this.session.setItem("user.position_code", (String) auth.get("position_code"));
        this.session.setItem("user.username", (String) auth.get("username"));
        this.session.setItem("user.password", (String) auth.get("password"));
        this.session.setItem("user.is_active", (int) auth.get("is_active"));
        
        initAll();
    }
    
    public Main() {
        this.session = new system.library.Session();
        
        initAll();
    }
    
    private void initAll() {
        
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setIconLogo();
        panelMoving.iniMoving(Main.this);
        scrollContent.setVerticalScrollBar(new ScrollBarFlat());
        
        panelNavbar.menuList((String) this.session.getItem("user.position_code"));
        pages();
        
        String authUser = (String) this.session.getItem("user.name") 
                + " ("+ this.session.getItem("user.position_name") +")";
        labelUsername.setText(authUser);
    }
    
    private void pages() {
        
        String position = (String) this.session.getItem("user.position_code");
        
        panelNavbar.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                labelPageName.setText(panelNavbar.getPageName());
                
                try {
                    system.library.json.structure.Menu menu = Menu.data();

                    if (menu.getData() != null) {
                        int i = 0;
                        for (system.library.json.structure.MenuList list : menu.getData()) {
                            if (
                                    list.getType().equals("menu") &&
                                    !list.getClazz().equals("") &&
                                    (
                                        list.getPermission().length == 0 ||
                                        Helper.inArray(position, list.getPermission())
                                    )

                            ) { 
                                if (index == i) {
                                    if (!list.getClazz().equals("exit")) {
                                        Class<?> clazz = Class.forName(list.getClazz());
                                        
                                        Constructor<?> constructor = clazz.getConstructor(resources.views.layout.Main.class);
                                        
                                        Object instance = constructor.newInstance(Main.this);
                                        
                                        setPage((JComponent) instance);
                                    } else {
                                        Main.this.session.clearAll();

                                        Main.this.dispose();

                                        //Main.this.setVisible(false);
                                        new Login().setVisible(true);
                                    }
                                }
                                
                                i++;
                            } else if (
                                list.getType().equals("title") &&
                                (
                                    list.getPermission().length == 0 ||
                                    Helper.inArray(position, list.getPermission())
                                )
                            ) { 
                                i++;
                            }
                        }
                        
                        // setPage(new resources.views.page.UnderConstructionForm());
                    }
                } catch (Exception e) {
                    System.err.println("Main Menu.data Err: " + e.getMessage());
                }
            }
        });
        
        labelPageName.setText("Dashboard");
        setPage(new resources.views.page.dasbor.MainForm() ); 
    }
    
    public void setPage(JComponent com) {
        panelContent.removeAll();
        panelContent.add(com);
        panelContent.repaint();
        panelContent.revalidate();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderFrame = new resources.views.component.PanelBorder();
        panelBorderHeader = new resources.views.component.PanelBorder();
        panelMoving = new resources.views.component.PanelMoving();
        labelAppLogo = new javax.swing.JLabel();
        labelAppTitle = new javax.swing.JLabel();
        btnClose = new resources.views.component.button.FlatButton();
        flatButton1 = new resources.views.component.button.FlatButton();
        panelNavbar = new resources.views.component.PanelNavbar();
        panelBorderContentHeader = new resources.views.component.PanelBorder();
        labelPageName = new javax.swing.JLabel();
        labelIconUser = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        scrollContent = new javax.swing.JScrollPane();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);

        panelBorderFrame.setBackground(new java.awt.Color(238, 238, 238));
        panelBorderFrame.setForeground(new java.awt.Color(238, 238, 238));
        panelBorderFrame.setMaximumSize(new java.awt.Dimension(1280, 720));
        panelBorderFrame.setMinimumSize(new java.awt.Dimension(1280, 720));
        panelBorderFrame.setPreferredSize(new java.awt.Dimension(1280, 720));

        panelBorderHeader.setMaximumSize(new java.awt.Dimension(1024, 50));
        panelBorderHeader.setMinimumSize(new java.awt.Dimension(1024, 50));

        labelAppLogo.setBackground(new java.awt.Color(0, 0, 0));
        labelAppLogo.setForeground(new java.awt.Color(0, 0, 0));
        labelAppLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAppLogo.setMaximumSize(new java.awt.Dimension(50, 50));
        labelAppLogo.setMinimumSize(new java.awt.Dimension(50, 50));
        labelAppLogo.setPreferredSize(new java.awt.Dimension(50, 50));

        labelAppTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelAppTitle.setForeground(new java.awt.Color(72, 112, 58));
        labelAppTitle.setText("KOPERASI SYARIAH");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addComponent(labelAppLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelAppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAppLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelAppTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/close.png"))); // NOI18N
        btnClose.setBorderColor(new java.awt.Color(255, 255, 255));
        btnClose.setColor(new java.awt.Color(255, 255, 255));
        btnClose.setColorClick(new java.awt.Color(255, 51, 51));
        btnClose.setColorOver(new java.awt.Color(255, 51, 51));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseApp(evt);
            }
        });

        flatButton1.setBackground(new java.awt.Color(255, 255, 255));
        flatButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/minus.png"))); // NOI18N
        flatButton1.setBorderColor(new java.awt.Color(255, 255, 255));
        flatButton1.setColor(new java.awt.Color(255, 255, 255));
        flatButton1.setColorClick(new java.awt.Color(221, 221, 221));
        flatButton1.setColorOver(new java.awt.Color(221, 221, 221));
        flatButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniApp(evt);
            }
        });

        javax.swing.GroupLayout panelBorderHeaderLayout = new javax.swing.GroupLayout(panelBorderHeader);
        panelBorderHeader.setLayout(panelBorderHeaderLayout);
        panelBorderHeaderLayout.setHorizontalGroup(
            panelBorderHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderHeaderLayout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(flatButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorderHeaderLayout.setVerticalGroup(
            panelBorderHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(flatButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMoving, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBorderContentHeader.setBackground(new java.awt.Color(238, 238, 238));
        panelBorderContentHeader.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(221, 221, 221)), null));
        panelBorderContentHeader.setForeground(new java.awt.Color(238, 238, 238));
        panelBorderContentHeader.setMaximumSize(new java.awt.Dimension(588, 60));
        panelBorderContentHeader.setMinimumSize(new java.awt.Dimension(588, 60));

        labelPageName.setBackground(new java.awt.Color(0, 0, 0));
        labelPageName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelPageName.setForeground(new java.awt.Color(85, 85, 85));
        labelPageName.setText("Dashboard");

        labelIconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/user.png"))); // NOI18N

        labelUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsername.setForeground(new java.awt.Color(85, 85, 85));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsername.setText("Administrator");

        javax.swing.GroupLayout panelBorderContentHeaderLayout = new javax.swing.GroupLayout(panelBorderContentHeader);
        panelBorderContentHeader.setLayout(panelBorderContentHeaderLayout);
        panelBorderContentHeaderLayout.setHorizontalGroup(
            panelBorderContentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderContentHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelPageName, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelIconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelBorderContentHeaderLayout.setVerticalGroup(
            panelBorderContentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderContentHeaderLayout.createSequentialGroup()
                .addGroup(panelBorderContentHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPageName, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(labelIconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        scrollContent.setBorder(null);
        scrollContent.setHorizontalScrollBar(null);
        scrollContent.setOpaque(false);

        panelContent.setOpaque(false);
        panelContent.setLayout(new java.awt.BorderLayout());
        scrollContent.setViewportView(panelContent);

        javax.swing.GroupLayout panelBorderFrameLayout = new javax.swing.GroupLayout(panelBorderFrame);
        panelBorderFrame.setLayout(panelBorderFrameLayout);
        panelBorderFrameLayout.setHorizontalGroup(
            panelBorderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorderFrameLayout.createSequentialGroup()
                .addComponent(panelNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorderContentHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorderFrameLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(scrollContent)
                        .addContainerGap())))
        );
        panelBorderFrameLayout.setVerticalGroup(
            panelBorderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderFrameLayout.createSequentialGroup()
                .addComponent(panelBorderHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorderFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderFrameLayout.createSequentialGroup()
                        .addComponent(panelNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorderFrameLayout.createSequentialGroup()
                        .addComponent(panelBorderContentHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollContent)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMiniApp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniApp
        this.setExtendedState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMiniApp

    private void btnCloseApp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseApp
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCloseApp

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    private void setIconLogo() {
        ImageIcon icon  = new ImageIcon(getClass().getResource("/resources/assets/images/logo.png"));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelAppLogo.getWidth() - 20, labelAppLogo.getHeight() - 10, Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        labelAppLogo.setIcon(scaleIcon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnClose;
    private resources.views.component.button.FlatButton flatButton1;
    private javax.swing.JLabel labelAppLogo;
    private javax.swing.JLabel labelAppTitle;
    private javax.swing.JLabel labelIconUser;
    private javax.swing.JLabel labelPageName;
    private javax.swing.JLabel labelUsername;
    private resources.views.component.PanelBorder panelBorderContentHeader;
    private resources.views.component.PanelBorder panelBorderFrame;
    private resources.views.component.PanelBorder panelBorderHeader;
    private javax.swing.JPanel panelContent;
    private resources.views.component.PanelMoving panelMoving;
    private resources.views.component.PanelNavbar panelNavbar;
    private javax.swing.JScrollPane scrollContent;
    // End of variables declaration//GEN-END:variables
}
