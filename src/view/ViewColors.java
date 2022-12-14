/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Color;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ColorService;
import service.impl.ColorServiceImpl;

/**
 *
 * @author admin
 */
public class ViewColors extends javax.swing.JDialog {

    private Color colorSelected;
    private List<Color> list;
    private ColorService colorService;
    private DefaultTableModel defaultTableModel;
    private java.awt.Frame parent;

    public ViewColors(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        colorService = new ColorServiceImpl();

        loadTable(colorService.findByTypeNotEqual(0));
       setSize(580,530);
    }

    private void loadTable(List<Color> getList) {
        list = getList;
        defaultTableModel = (DefaultTableModel) tblColor.getModel();
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnIdentifiers(new String[]{"Id", "Code", "Name"});
        for (Color color : getList) {
            defaultTableModel.addRow(new Object[]{
                color.getId(), color.getCode(), color.getColorName()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblColor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 169, 98, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Color");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 20, 301, -1));

        tblColor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblColor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 492, 153));

        jLabel2.setText("Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 37, -1));

        jLabel3.setText("Code");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 122, 37, -1));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 176, 94, -1));

        lblid.setText("-");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 61, 221, 24));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 119, 221, -1));
        getContentPane().add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 173, 221, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 58, 98, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 115, 98, -1));

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 75, -1));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 242, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/search-icon-24.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 105, -1));

        jLabel5.setText("FindName");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 71, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Color color = getFormData();
        if (color == null) {
            return;
        } else {
            try {

                colorService.insert(color);
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                loadTable(colorService.findByTypeNotEqual(0));
                clearForm();
//                QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
//                qlsp.loadColor();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxColor.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxColor.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        }
        
           try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxColor.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxColor.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

           
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        int row = tblColor.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chon dong can sua");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban Co Muon Sua Khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Color color = getFormData();

        color.setId(UUID.fromString(lblid.getText()));
        try {
            colorService.update(color);
            JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
            loadTable(colorService.findByTypeNotEqual(0));
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ViewColors.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {

            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxColor.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxColor.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblColor.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chon Dong Can Xoa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban Co Muon Xoa Khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            colorService.setType(UUID.fromString(lblid.getText()), 0);
            JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
            loadTable(colorService.findByTypeNotEqual(0));
            clearForm();

        } catch (Exception ex) {
            Logger.getLogger(ViewColors.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {

            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxColor.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxColor.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseClicked
        // TODO add your handling code here:
        int row = tblColor.getSelectedRow();
        if (row >= 0) {
            colorSelected = list.get(row);
            lblid.setText(tblColor.getValueAt(row, 0).toString());
            txtCode.setText(tblColor.getValueAt(row, 1).toString());
            txtColor.setText(tblColor.getValueAt(row, 2).toString());
        }

    }//GEN-LAST:event_tblColorMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxColor.getSelectedItem();

            qlsp.cbxColor.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<Color> list = colorService.findByNameLike("%" + txtTimKiem.getText() + "%");
        loadTable(list);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

         try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            if (colorSelected != null) {
                qlsp.cbxColor.setSelectedItem(colorSelected);
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
        
    }//GEN-LAST:event_btnOkActionPerformed

    private void clearForm() {
        colorSelected = null;
        lblid.setText("");
        txtCode.setText("");
        txtColor.setText("");
    }

    private Color getFormData() {
        if (txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Code Null");
            return null;
        }
        if (txtColor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "color Null");
            return null;
        }

        Color color = new Color();
        if (colorSelected != null) {
            color.setType(colorSelected.getType());
        }
        color.setCode(txtCode.getText());
        color.setColorName(txtColor.getText());
        return color;
    }

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
            java.util.logging.Logger.getLogger(ViewColors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewColors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewColors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewColors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewColors dialog = new ViewColors(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTable tblColor;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
