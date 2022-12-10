/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Bill;
import domain.BillDetail;
import domain.Customer;
import domain.ProductDetail;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import service.BillDetailService;
import service.BillService;
import service.ProductDetailService;
import service.impl.BillDetailServiceImpl;
import service.impl.BillServiceImpl;
import service.impl.ProductDetailServiceImpl;

/**
 *
 * @author Administrator
 */
public class QuanLiHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form QuanLiHoaDon
     */
    private BigDecimal tongTien;
    private Bill billSelected;
    private List<Bill> hdcs = new ArrayList<Bill>();
    private ProductDetail productDetailSelected;
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails = new ArrayList<>();
    private List<BillDetail> billDEtailGHs = new ArrayList<>();
    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl() {
    };

    public QuanLiHoaDon() {
        initComponents();
        setLocationRelativeTo(null);

        init();
        loadTableHDC(hdcs);
        loadTableHDDH(hdcs);
        hdcs = billService.findAll();
        loadTableHDC(hdcs);

        this.productDetailService = new ProductDetailServiceImpl();
        setLocationRelativeTo(null);
        productDetails = productDetailService.findByTypeNotEqual(0);
    }

    private void loadTableHDC(List<Bill> hdcs) {
        String[] type = new String[]{"Da Huy", "Dang Cho", "Da Thanh Toan"};
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHDC.getModel();
        defaultTableModel.setRowCount(0);
        for (Bill bill : hdcs) {
            defaultTableModel.addRow(
                    new Object[]{
                        bill.getId(), bill.getCreateDate(), bill.getEmployee().getFullName(), bill.getCustomer() == null ? null : bill.getCustomer().getFullName(), type[bill.getType()]
                    }
            );
        }
    }

    private void init() {
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
                    "Ma HDC", "Tgian tao", "Nhan vien", "Khach hang", "Type"
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

    private void loadTableGH(List<BillDetail> billDetails) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblGH.getModel();
        defaultTableModel.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        for (BillDetail billDetail : billDetails) {
            ProductDetail productDetail = billDetail.getProductDetail();
            JSpinner spinner = new JSpinner();
            spinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
            JButton button = new JButton("Xóa");

            defaultTableModel.addRow(
                    new Object[]{
                        productDetail.getId(),
                        productDetail.getProduct() == null ? null : productDetail.getProduct().getProductName(),
                        decimalFormat.format(billDetail.getPrice()),
                        billDetail.getQuantity(),
                        decimalFormat.format((billDetail.getPrice().doubleValue() * billDetail.getQuantity())),
                        button

                    }
            );
        }
    }

    private void loadTableHDDH(List<Bill> hddhs) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHDC.getModel();
        defaultTableModel.setRowCount(0);
        for (Bill bill : hddhs) {
            defaultTableModel.addRow(
                    new Object[]{
                        bill.getId(), bill.getCreateDate(), bill.getEmployee().getFullName(), bill.getCustomer() == null ? null : bill.getCustomer().getFullName()
                    }
            );
        }
    }
    // loc
//        private void loadTable(List<ProductDetail> productDetails) {
//        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHDC.getModel();
//        defaultTableModel.setRowCount(0);
//        for (ProductDetail productDetail : productDetails) {
//            defaultTableModel.addRow(productDetail.toRow());
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDC = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtlocnhanvien = new javax.swing.JTextField();
        txtlockhachhang = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quan Ly Hoa Don");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 209, -1));

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
        jScrollPane1.setViewportView(tblHDC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 970, 140));

        jLabel2.setText("Hoa Don");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

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
        jScrollPane2.setViewportView(tblGH);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 970, 190));

        jLabel3.setText("Hoa Don Chi Tiet ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel4.setText("Trang Thai: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tat Ca", "Da Huy", "Hoa Don Cho", "Da Thanh Toan" }));
        cbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbActionPerformed(evt);
            }
        });
        getContentPane().add(cbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 220, 30));

        jLabel5.setText("Bo Loc: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel6.setText("Tim Kiem : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 170, -1));

        jButton1.setText("SEACH");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));
        getContentPane().add(txtlocnhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 110, -1));
        getContentPane().add(txtlockhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 120, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 120, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 110, -1));

        jButton3.setText("SEACH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 80, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblHDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCMouseClicked

        int i = tblHDC.getSelectedRow();
        if (i >= 0) {
            billSelected = hdcs.get(i);
            billDEtailGHs = billDetailService.findByBill(billSelected);
            loadTableGH(billDEtailGHs);
//            hdcs = billService.findByTypeNotEqual(1);
//        //    billDEtailGHs = billDetailService.findByBill(billSelected);
//            loadTableHDDH(hdcs);
        }
    }//GEN-LAST:event_tblHDCMouseClicked

    private void cbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbActionPerformed
        // TODO add your handling code here:
        int cbbtt = cbb.getSelectedIndex();
        if (cbbtt > 0) {
            hdcs = billService.findByTypeEqual(cbbtt - 1);
            loadTableHDC(hdcs);
        } else {
            hdcs = billService.findAll();
            loadTableHDC(hdcs);
        }

    }//GEN-LAST:event_cbbActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        hdcs = billService.seachlochdc(txtlockhachhang.getText(), txtlocnhanvien.getText());
//            loadTable(hdcs);
        loadTableHDC(hdcs);

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHDC;
    private javax.swing.JTextField txtlockhachhang;
    private javax.swing.JTextField txtlocnhanvien;
    // End of variables declaration//GEN-END:variables
}
