/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Role;
import domain.Sole;
import domain.Size;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.SizeService;
import service.impl.SizeServiceImpl;

/**
 *
 * @author admin
 */
public class ViewSize extends javax.swing.JDialog {

    private Size sizeSelected;
    private List<Size> list;
    private SizeService sizeService;
    private DefaultTableModel defaultTableModel;
    private java.awt.Frame parent;

    public ViewSize(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        sizeService = new SizeServiceImpl();

        loadTable(sizeService.findByTypeNotEqual(0));
    }

    private void loadTable(List<Size> getList) {
        list = getList;
        defaultTableModel = (DefaultTableModel) tblSize.getModel();
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnIdentifiers(new String[]{"Id", "Code", "Size"});
        for (Size size : getList) {
            defaultTableModel.addRow(new Object[]{
                size.getId(), size.getCode(), size.getSize()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
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
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 169, 97, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Size");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 20, 301, -1));

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSize);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 281, 500, 153));

        jLabel2.setText("Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 37, -1));

        jLabel3.setText("Code");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 122, 37, -1));

        jLabel4.setText("Size");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 65, -1));

        lblid.setText("-");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 61, 221, 24));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 119, 221, -1));
        getContentPane().add(txtSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 173, 221, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 58, 97, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 115, -1, -1));

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 75, -1));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 221, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/search-icon-24.png"))); // NOI18N
        jButton2.setText("Tim kiem");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        jLabel5.setText("FindName");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 63, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Size size = getFormData();
        if (size == null) {
            return;
        } else {
            try {

                sizeService.insert(size);
                JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                loadTable(sizeService.findByTypeNotEqual(0));
                clearForm();
//                QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
//                qlsp.loadSize();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxSize.getSelectedItem();
            qlsp.loadSize();
            qlsp.cbxSize.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int row = tblSize.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chon Dong Can Sua");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban Co Muon Sua Khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Size size = getFormData();

        size.setId(UUID.fromString(lblid.getText()));
        try {
            sizeService.update(size);
            JOptionPane.showMessageDialog(this, "Sua Thanh Cong");
            loadTable(sizeService.findByTypeNotEqual(0));
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ViewSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxSize.getSelectedItem();
            qlsp.loadSize();
            qlsp.cbxSize.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblSize.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "CHon Dong Can Sua");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bna Co Muon Sua Khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            sizeService.setType(UUID.fromString(lblid.getText()), 0);
            JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
            loadTable(sizeService.findByTypeNotEqual(0));
            clearForm();

        } catch (Exception ex) {
            Logger.getLogger(ViewSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxSize.getSelectedItem();
            qlsp.loadSize();
            qlsp.cbxSize.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
        int row = tblSize.getSelectedRow();
        if (row >= 0) {
            sizeSelected = list.get(row);
            lblid.setText(tblSize.getValueAt(row, 0).toString());
            txtCode.setText(tblSize.getValueAt(row, 1).toString());
            txtSize.setText(tblSize.getValueAt(row, 2).toString());
        }

    }//GEN-LAST:event_tblSizeMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxSize.getSelectedItem();

            qlsp.cbxSize.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<Size> list = sizeService.findByNameLike((txtTimKiem.getText()));
        loadTable(list);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            if (sizeSelected != null) {
                qlsp.cbxSize.setSelectedItem(sizeSelected);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void clearForm() {
        sizeSelected = null;
        lblid.setText("");
        txtCode.setText("");
        txtSize.setText("");
    }

    private Size getFormData() {
        if (txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Code Null");
            return null;
        }
        if (txtSize.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Size Null");
            return null;
        }

        Size size = new Size();
        if (sizeSelected != null) {
            size.setType(sizeSelected.getType());
        }
        size.setCode(txtCode.getText());
        size.setSize(Integer.parseInt(txtSize.getText()));
        return size;
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
            java.util.logging.Logger.getLogger(ViewSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewSize dialog = new ViewSize(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
