package resources.views.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import resources.event.EventMenuSelected;
import system.library.Navigation;

public class PanelNavbar extends javax.swing.JPanel {

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        navList.addEventMenuSelected(event);
    }
    
    public String getPageName() {
        return navList.getPageName();
    }

    public void setPageName(String pageName) {
        navList.setPageName(pageName);
    }
    
    public PanelNavbar() {
        initComponents();
        setOpaque(false);
        scrollPaneNav.getViewport().setOpaque(false);
        scrollPaneNav.setVerticalScrollBar(new ScrollBarFlat());
        scrollPaneNav.setBackground(new Color(242, 242, 242, 80));
        navList.setOpaque(false);
//        init();
    }
    
    public void setMenuList(String position) {
        menuList(position);
    }
    
    private void menuList(String pst) {
        String position = null;
        switch (pst) {
            case "LDR":
                position = "leader";
                break;
            case "TRS":
                position = "treasurer";
                break;
            default:
                position = "all";
        }
        
        navList.addItem(new Navigation("app", "Dashboard", "Dashboard", Navigation.MenuType.MENU));
        
        if (position != "leader") {
            navList.addItem(new Navigation("", "Master", " ", Navigation.MenuType.TITLE));
            if (position != "treasurer") {
                navList.addItem(new Navigation("app", "Master Pengguna", "Master Pengguna", Navigation.MenuType.MENU));
                navList.addItem(new Navigation("app", "Master Investor", "Master Investor", Navigation.MenuType.MENU));
                navList.addItem(new Navigation("app", "Master Nasabah", "Master Nasabah", Navigation.MenuType.MENU));
                navList.addItem(new Navigation("app", "Master Karyawan", "Master Karyawan", Navigation.MenuType.MENU));
                navList.addItem(new Navigation("app", "Master Jabatan", "Master Jabatan", Navigation.MenuType.MENU));
            }
            navList.addItem(new Navigation("app", "Master Pengajuan", "Master Pengajuan", Navigation.MenuType.MENU));
            navList.addItem(new Navigation("app", "Master Pembayaran", "Master Pembayaran", Navigation.MenuType.MENU));
        }
        
        navList.addItem(new Navigation("", "Laporan", " ", Navigation.MenuType.TITLE));

        navList.addItem(new Navigation("app", "Pembayaran", "Laporan Pembayaran", Navigation.MenuType.MENU));
        navList.addItem(new Navigation("app", "Pengajuan Lunas", "Laporan Pengajuan Lunas", Navigation.MenuType.MENU));
        navList.addItem(new Navigation("app", "Pengajuan Menunggak", "Laporan Pengajuan Menunggak", Navigation.MenuType.MENU));
        
        navList.addItem(new Navigation(" ", "Pengaturan", " ", Navigation.MenuType.TITLE));

        navList.addItem(new Navigation("exit", "Keluar", " ", Navigation.MenuType.MENU));
    }
    
    private void init() {
        setMenuList("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneNav = new javax.swing.JScrollPane();
        navList = new resources.views.component.navigation.NavList<>();

        setMaximumSize(new java.awt.Dimension(250, 670));
        setMinimumSize(new java.awt.Dimension(250, 670));
        setPreferredSize(new java.awt.Dimension(250, 670));

        scrollPaneNav.setBorder(null);
        scrollPaneNav.setViewportBorder(javax.swing.BorderFactory.createCompoundBorder());

        scrollPaneNav.setViewportView(navList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneNav, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrollPaneNav, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        GradientPaint grd = new GradientPaint(
                0, 
                0, 
                Color.decode("#abd04e"), 
                0, 
                getHeight(), 
                Color.decode("#48703a")
        );
        g2.setPaint(grd);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintChildren(g);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.navigation.NavList<String> navList;
    private javax.swing.JScrollPane scrollPaneNav;
    // End of variables declaration//GEN-END:variables

}
