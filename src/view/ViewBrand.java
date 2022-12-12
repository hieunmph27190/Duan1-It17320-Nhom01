/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Role;
import domain.Sole;
import domain.Brand;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.BrandService;
import service.impl.BrandServiceImpl;

/**
 *
 * @author admin
 */
public class ViewBrand extends javax.swing.JDialog {

    private Brand brandSelected;
    private List<Brand> list;
    private BrandService brandService;
    private DefaultTableModel defaultTableModel;
    private java.awt.Frame parent;

    public ViewBrand(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        brandService = new BrandServiceImpl();

        loadTable(brandService.findByTypeNotEqual(0));
    }

    private void loadTable(List<Brand> getList) {
        list = getList;
        defaultTableModel = (DefaultTableModel) tblBrand.getModel();
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnIdentifiers(new String[]{"Id", "Code", "Name"});
        for (Brand trademark : getList) {
            defaultTableModel.addRow(new Object[]{
                trademark.getId(), trademark.getCode(), trademark.getName()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrand = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
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
        jLabel1.setText("Brand");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 301, -1));

        tblBrand.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrandMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrand);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 492, 153));

        jLabel2.setText("Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 37, -1));

        jLabel3.setText("Code");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 122, 37, -1));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, -1));

        lblid.setText("-");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 61, 221, 24));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 119, 221, -1));
        getContentPane().add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 173, 221, -1));

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
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 436, 75, -1));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 242, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/search-icon-24.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 106, -1));

        jLabel5.setText("FindName");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 60, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Brand trademark = getFormData();
        if (trademark == null) {
            return;
        } else {
            try {

                brandService.insert(trademark);
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                loadTable(brandService.findByTypeNotEqual(0));
                clearForm();
//                QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
//                qlsp.loadBrand();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxBrand.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxBrand.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int row = tblBrand.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chon dong can sua");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon sua khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Brand trademark = getFormData();

        trademark.setId(UUID.fromString(lblid.getText()));
        try {
            brandService.update(trademark);
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
            loadTable(brandService.findByTypeNotEqual(0));
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ViewBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxBrand.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxBrand.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tblBrand.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chon dong can xoa");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon xoa khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            brandService.setType(UUID.fromString(lblid.getText()), 0);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            loadTable(brandService.findByTypeNotEqual(0));
            clearForm();

        } catch (Exception ex) {
            Logger.getLogger(ViewBrand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxBrand.getSelectedItem();
            qlsp.loadBrand();
            qlsp.cbxBrand.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrandMouseClicked
        // TODO add your handling code here:
        int row = tblBrand.getSelectedRow();
        if (row >= 0) {
            brandSelected = list.get(row);
            lblid.setText(tblBrand.getValueAt(row, 0).toString());
            txtCode.setText(tblBrand.getValueAt(row, 1).toString());
            txtBrand.setText(tblBrand.getValueAt(row, 2).toString());
        }

    }//GEN-LAST:event_tblBrandMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            Object obj = qlsp.cbxBrand.getSelectedItem();

            qlsp.cbxBrand.setSelectedItem(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        List<Brand> list = brandService.findByNameLike("%" + txtTimKiem.getText() + "%");
        loadTable(list);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            QuanLiSanPham qlsp = (QuanLiSanPham) this.parent;
            if (brandSelected != null) {
                qlsp.cbxBrand.setSelectedItem(brandSelected);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void clearForm() {
        brandSelected = null;
        lblid.setText("");
        txtCode.setText("");
        txtBrand.setText("");
    }

    private Brand getFormData() {
        if (txtCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Code Null");
            return null;
        }
        if (txtBrand.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tradamrkname Null");
            return null;
        }

        Brand trademark = new Brand();
        if (brandSelected != null) {
            trademark.setType(brandSelected.getType());
        }
        trademark.setCode(txtCode.getText());
        trademark.setName(txtBrand.getText());
        return trademark;
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
            java.util.logging.Logger.getLogger(ViewBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewBrand dialog = new ViewBrand(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblBrand;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
