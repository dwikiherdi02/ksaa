package resources.views.page.pengajuan.table;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Dwiki
 */
public class Action extends javax.swing.JPanel {

    /**
     * Creates new form Action
     */
    public Action(ModelAction data) {
        initComponents();
        
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        
        btnEdit.setContentAreaFilled(false);
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.getEvent().update(data.getDataTable());
            }
            
        });
        
        btnDelete.setContentAreaFilled(false);
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.getEvent().delete(data.getDataTable());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new resources.views.component.button.FlatButton();
        btnDelete = new resources.views.component.button.FlatButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        btnEdit.setBackground(new java.awt.Color(255, 102, 0));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/pencil.png"))); // NOI18N
        btnEdit.setBorderColor(new java.awt.Color(255, 102, 0));
        btnEdit.setColor(new java.awt.Color(255, 102, 0));
        btnEdit.setColorClick(new java.awt.Color(255, 102, 0));
        btnEdit.setColorOver(new java.awt.Color(255, 102, 0));

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/assets/icons/trash.png"))); // NOI18N
        btnDelete.setBorderColor(new java.awt.Color(204, 0, 0));
        btnDelete.setColor(new java.awt.Color(204, 0, 0));
        btnDelete.setColorClick(new java.awt.Color(204, 0, 0));
        btnDelete.setColorOver(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private resources.views.component.button.FlatButton btnDelete;
    private resources.views.component.button.FlatButton btnEdit;
    // End of variables declaration//GEN-END:variables
}
