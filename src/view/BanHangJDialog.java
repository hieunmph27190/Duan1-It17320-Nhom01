/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import domain.Bill;
import domain.BillDetail;
import domain.Customer;
import domain.ProductDetail;import java.sql.Timestamp;
;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.BillDetailService;
import service.BillService;
import service.ProductDetailService;
import service.impl.BillDetailServiceImpl;
import service.impl.BillServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ProductDetailServiceImpl;
import utils.AuthUtil;


public class BanHangJDialog extends javax.swing.JFrame {
    private Bill billSelected;
    private List<Bill> hdcs = new ArrayList<Bill>();
    private ProductDetail productDetailSelected;
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails =new ArrayList<>();
    private List<BillDetail> billDEtailGHs = new ArrayList<>();
    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl() {};
    
    public BanHangJDialog() {
  
        initComponents();
        init();
        hdcs = billService.findByTypeEqual(1);
        loadTableHDC(hdcs);
        this.productDetailService = new ProductDetailServiceImpl();
        setLocationRelativeTo(null);
        productDetails = productDetailService.findByTypeNotEqual(0);
        loadTable(productDetails);;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDC = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttienkhachhang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        textName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bán Hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        tblHDC.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHDC);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hoa Don Cho", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hoa Don Da Huy", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 350, 130));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("San pham")));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSP);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 390, 220));
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, -1));

        jButton8.setText("Tim Kiem");
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel5.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 60, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 380));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa ??n"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ten Khach Hang: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel1.add(txtsoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 316, -1));

        jLabel6.setText("Sdt Khach Hang: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, -1, -1));

        jLabel7.setText("So Luong: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel1.add(textSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 56, 316, -1));

        jLabel8.setText("Tong Tien: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 284, 316, 20));

        jLabel10.setText("Tien Khach Dua: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));

        jLabel11.setText("Tien Thua: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txttienkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttienkhachhangActionPerformed(evt);
            }
        });
        jPanel1.add(txttienkhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 320, -1));

        jLabel12.setText("Giam Gia: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 57, 20));

        jButton3.setText("Luu Hoa Don");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 110, -1));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 55, 80, -1));

        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, -1));

        textName.setText("jLabel13");
        jPanel1.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 310, 20));

        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 320, 20));

        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 320, 20));

        jLabel15.setText("Mahd: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 100, 40, -1));

        jLabel16.setText("jLabel16");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 96, 310, 20));

        jButton4.setText("Xuat FDF");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 110, -1));

        jButton1.setText("Tao Hoa Don");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 530, 390));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gi? hàng"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblGH);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 490, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 530, 160));

        jButton2.setText("Luu Hoa Don");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tblGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGHMouseClicked

    }//GEN-LAST:event_tblGHMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (tblSP.getSelectedRow() >= 0) {
            if (!billDetailService.containsProductDetail(billSelected,productDetailSelected)) { 
                BillDetail billDetail = new BillDetail();
                billDetail.setBill(billSelected);
                billDetail.setProductDetail(productDetails.get(tblSP.getSelectedRow()));
                billDetail.setPrice(productDetails.get(tblSP.getSelectedRow()).getPrice());
                billDetail.setQuantity(1);
                try {
                    billDetailService.insert(billDetail);
                    productDetailService.changeAmount(billDetail.getProductDetail().getId(),0-billDetail.getQuantity());
                    billDEtailGHs = billDetailService.findByBill(billSelected);
                    loadTableGH(billDEtailGHs);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lou");
                }
                
            }
            
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String sdt = textSDT.getText().trim();
        Customer customer = new CustomerServiceImpl().findBySDT(sdt);
        if (customer == null) {
            JOptionPane.showMessageDialog(this, "So dien thoai khong ton tai");
        } else {
            textName.setText(customer.getFirstName()+" "+customer.getBufferName()+" "+customer.getName());
            
            try {
                billSelected.setCustomer(customer);
                billService.update(billSelected);
                hdcs = billService.findByTypeEqual(1);
                loadTableHDC(hdcs);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttienkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttienkhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttienkhachhangActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
       productDetailSelected = productDetails.get(tblSP.getSelectedRow());
    }//GEN-LAST:event_tblSPMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (AuthUtil.getEmployee()!=null) {
            try {
                Bill bill = new Bill();
                bill.setEmployee(AuthUtil.getEmployee());
                bill.setCreateDate(new Date());
                billService.insert(bill);
                hdcs = billService.findByTypeEqual(1);
                loadTableHDC(hdcs);
//                billSelected=bill;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "L?i");
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
   new ThemNhanhKhachHangview(this, true).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblHDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCMouseClicked
        int i = tblHDC.getSelectedRow();
        if (i>=0) {
          billSelected = hdcs.get(i);
          billDEtailGHs = billDetailService.findByBill(billSelected);
          loadTableGH(billDEtailGHs);
        }
    }//GEN-LAST:event_tblHDCMouseClicked

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
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHangJDialog().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHDC;
    private javax.swing.JTable tblSP;
    private javax.swing.JLabel textName;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttienkhachhang;
    // End of variables declaration//GEN-END:variables

    private void loadTable(List<ProductDetail> productDetails) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblSP.getModel();
        defaultTableModel.setRowCount(0);
        for (ProductDetail productDetail : productDetails) {
            defaultTableModel.addRow(productDetail.toRow());
        }
    }
    private void loadTableHDC(List<Bill> hdcs) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHDC.getModel();
        defaultTableModel.setRowCount(0);
        for (Bill bill : hdcs) {
            defaultTableModel.addRow(
             new Object[]{
                 bill.getId(),bill.getCreateDate(),bill.getEmployee().getFullName(),bill.getCustomer()==null?null:bill.getCustomer().getFullName()
             }
        );
        }
    }
    
    public void  selecttedcustomor(Customer cs) {
              textName.setText(cs.getFullName());
              textSDT.setText(cs.getPhoneNumber());
          
    }

    private void loadTableGH(List<BillDetail> billDetails) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblGH.getModel();
        defaultTableModel.setRowCount(0);

        for (BillDetail billDetail : billDetails) {
            ProductDetail productDetail = billDetail.getProductDetail();
            JSpinner spinner = new JSpinner();
            spinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
            JButton button = new JButton("Xóa");
            System.out.println("view.BanHangJDialog.loadTableGH()");
            defaultTableModel.addRow(
                    new Object[]{
                        productDetail.getId(),
                        productDetail.getProduct() == null ? null : productDetail.getProduct().getProductName(),
                        productDetail.getPrice(),
                        billDetail.getQuantity(),
                        billDetail.getPrice(),
                        button

                    }
            );
        }
    }

    private void init() {
        tblSP.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Tên", "Lo?i2", "Màu", "Size", "Hãng5", "D?", "S? l??ng", "Giá", "B?o hành (tháng)", "Mô t?"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tblGH.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID",
                    "Tên", "Gia", "So luong", "Thanh tien", ""
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        
         tblHDC.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã HDC", "Tgian tao", "Nhan vien", "Khach hang"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }
}
