/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import domain.Bill;
import domain.BillDetail;
import domain.Customer;
import domain.ProductDetail;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import service.BillDetailService;
import service.BillService;
import service.ProductDetailService;
import service.impl.BillDetailServiceImpl;
import service.impl.BillServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ProductDetailServiceImpl;
import utils.AuthUtil;
;

public class BanHangJDialog extends javax.swing.JFrame {

    private BigDecimal tongTien;
    private Bill billSelected;
    private List<Bill> hdcs = new ArrayList<Bill>();
    private List<Bill> hddhs = new ArrayList<Bill>();
    private ProductDetail productDetailSelected;
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails = new ArrayList<>();
    private List<BillDetail> billDEtailGHs = new ArrayList<>();
    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl() {
    };

    public BanHangJDialog() {
        tongTien = new BigDecimal(0);
        initComponents();
        init();
        hdcs = billService.findByTypeEqual(1);
        hddhs = billService.findByTypeEqual(0);
        loadTableHDC(hdcs);
        loadTableHDDH(hddhs);
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
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHDH = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textHoaDon = new javax.swing.JTextField();
        textTienTra = new javax.swing.JTextField();
        textTongTien = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textGiamGia = new javax.swing.JTextField();
        sprinerTienDua = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Bán Hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 384, 130));

        jButton7.setText("Huy HD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 80, 30));

        jButton2.setText("Tao HD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 80, 30));

        jTabbedPane1.addTab("Hoa Don Cho", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHDH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDHMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHDH);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 378, 130));

        jButton4.setText("Xoa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 80, 30));

        jButton11.setText("Tao HD");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 80, 30));

        jTabbedPane1.addTab("Hoa Don Da Huy", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 500, 150));

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

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 460, 270));
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, -1));

        jButton8.setText("Tim Kiem");
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel5.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 60, 25));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, 350));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa ??n"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ten Khach Hang: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        textSoLuong.setEditable(false);
        textSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 310, -1));

        jLabel6.setText("Sdt Khach Hang: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setText("So Luong: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel1.add(textSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 310, -1));

        jLabel8.setText("Tong Tien: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel10.setText("Tien Dua: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, -1));

        jLabel11.setText("Tien Thua: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel12.setText("Giam Gia: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 57, 20));

        jButton3.setText("Luu Hoa Don");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 110, 50));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 70, -1));

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 50, -1));

        jLabel15.setText("Ma HD: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));

        jButton1.setText("Thanh Toan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 110, 50));

        textHoaDon.setEditable(false);
        textHoaDon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 380, -1));

        textTienTra.setEditable(false);
        textTienTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTienTraActionPerformed(evt);
            }
        });
        jPanel1.add(textTienTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 150, -1));

        textTongTien.setEditable(false);
        textTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTongTien.setForeground(new java.awt.Color(255, 153, 51));
        textTongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(textTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 400, -1));

        textName.setEditable(false);
        jPanel1.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 310, -1));

        textGiamGia.setEditable(false);
        jPanel1.add(textGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 400, -1));

        sprinerTienDua.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10000.0d));
        sprinerTienDua.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sprinerTienDuaStateChanged(evt);
            }
        });
        sprinerTienDua.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sprinerTienDuaPropertyChange(evt);
            }
        });
        jPanel1.add(sprinerTienDua, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jButton5.setText("!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 168, 30, 30));

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

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 130));

        jButton9.setText("X");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 50, -1));

        jButton10.setText("U");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 530, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tblGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGHMouseClicked

    }//GEN-LAST:event_tblGHMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (tblSP.getSelectedRow() >= 0) {
            if (!billDetailService.containsProductDetail(billSelected, productDetailSelected)) {
                BillDetail billDetail = new BillDetail();
                billDetail.setBill(billSelected);
                billDetail.setProductDetail(productDetails.get(tblSP.getSelectedRow()));
                billDetail.setPrice(productDetails.get(tblSP.getSelectedRow()).getPrice());
                billDetail.setQuantity(1);
                try {
                    productDetailService.changeAmount(billDetail.getProductDetail().getId(), 0 - billDetail.getQuantity());
                    billDetailService.insert(billDetail);
                    billDEtailGHs = billDetailService.findByBill(billSelected);
                    loadTableGH(billDEtailGHs);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    textTongTien.setText(billService.getSumMoney(billSelected) == null ? null : billService.getSumMoney(billSelected).toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(this, "San pham da co trong gio hang");
            }

        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String sdt = textSDT.getText().trim();
        Customer customer = new CustomerServiceImpl().findBySDT(sdt);
        if (customer == null) {
            JOptionPane.showMessageDialog(this, "So dien thoai khong ton tai");
        } else {
            textName.setText(customer.getFirstName() + " " + customer.getBufferName() + " " + customer.getName());

            try {
                billSelected.setCustomer(customer);
                billService.update(billSelected);
                hdcs = billService.findByTypeEqual(1);
                loadTableHDC(hdcs);
                focusRowTableHDC(billSelected);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        productDetailSelected = productDetails.get(tblSP.getSelectedRow());
    }//GEN-LAST:event_tblSPMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (AuthUtil.getEmployee() != null) {
            try {
                Bill bill = new Bill();
                bill.setEmployee(AuthUtil.getEmployee());
                bill.setCreateDate(new Date());
                billService.insert(bill);
                hdcs = billService.findByTypeEqual(1);
                loadTableHDC(hdcs);
                billSelected = bill;
                focusRowTableHDC(billSelected);
                clearForm();
                textHoaDon.setText(billSelected.getId().toString());
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
        new ThemNhanhKhachHangview(this, true).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblHDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCMouseClicked
        int i = tblHDC.getSelectedRow();
        if (i >= 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
            clearForm();
            billSelected = hdcs.get(i);
            textHoaDon.setText(billSelected.getId().toString());
            billDEtailGHs = billDetailService.findByBill(billSelected);
            loadTableGH(billDEtailGHs);
            tongTien = billService.getSumMoney(billSelected) == null ? new BigDecimal(0) : billService.getSumMoney(billSelected);
            textTongTien.setText(tongTien == null ? null : decimalFormat.format(tongTien));
            textSoLuong.setText(billService.getQuantity(billSelected) == null ? null : billService.getQuantity(billSelected).toString());
            Customer customer = billSelected.getCustomer();
            if (customer != null) {
                textName.setText(customer.getFullName());
                textSDT.setText(customer.getPhoneNumber());

            } else {
                textName.setText("");
                textSDT.setText("");
            }
        }
    }//GEN-LAST:event_tblHDCMouseClicked

    private void textTienTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTienTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTienTraActionPerformed

    private void tblHDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHDHMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            billService.setType(billSelected.getId(), 2);
            JOptionPane.showMessageDialog(this, "Thanh Toan thanh cong");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sprinerTienDuaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sprinerTienDuaPropertyChange

    }//GEN-LAST:event_sprinerTienDuaPropertyChange

    private void sprinerTienDuaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprinerTienDuaStateChanged
        Double tienDua = (Double) sprinerTienDua.getValue();
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        textTienTra.setText(decimalFormat.format(new BigDecimal(tienDua - tongTien.doubleValue())));
    }//GEN-LAST:event_sprinerTienDuaStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        List<BillDetail> billDetails = billDetailService.findByBill(billSelected);
        for (BillDetail billDetail : billDetails) {
            ProductDetail productDetail = billDetail.getProductDetail();

            Integer slChange = billDetail.getQuantity() - 0;
            try {
                productDetailService.changeAmount(productDetail.getId(), slChange);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        try {
            billService.setType(billSelected.getId(), 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        hdcs = billService.findByTypeEqual(1);
        loadTableHDC(hdcs);
        productDetails = productDetailService.findByTypeNotEqual(0);
        loadTable(productDetails);
        loadTableGH(new ArrayList<>());
        hddhs = billService.findByTypeEqual(0);
        loadTableHDDH(hddhs);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int i = tblGH.getSelectedRow();
        if (i >= 0) {
            try {
                billDetailService.remove(billDEtailGHs.get(i).getId());
                billDEtailGHs = billDetailService.findByBill(billSelected);
                loadTableGH(billDEtailGHs);
                DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
                tongTien = billService.getSumMoney(billSelected) == null ? new BigDecimal(0) : billService.getSumMoney(billSelected);
                textTongTien.setText(tongTien == null ? null : decimalFormat.format(tongTien));
                textSoLuong.setText(billService.getQuantity(billSelected) == null ? null : billService.getQuantity(billSelected).toString());
                Double tienDua = (Double) sprinerTienDua.getValue();
                textTienTra.setText(decimalFormat.format(String.valueOf(tienDua - tongTien.doubleValue())));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int i = tblGH.getSelectedRow();;
        if (i >= 0) {
            String slStr = JOptionPane.showInputDialog(this, "Nhap so luong");
            Integer sl = null;
            try {
                sl = Integer.parseInt(slStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Nhap sai");
            }
            if (sl != null) {
                if (sl >= 0) {
                    try {
                        BillDetail billDetail = billDEtailGHs.get(i);
                        Integer slChange = billDetail.getQuantity() - sl;
                        productDetailService.changeAmount(billDetail.getProductDetail().getId(), slChange);
                        billDetail.setQuantity(sl);
                        billDetailService.update(billDetail);
                        billDEtailGHs = billDetailService.findByBill(billSelected);
                        loadTableGH(billDEtailGHs);
                        productDetails = productDetailService.findByTypeNotEqual(0);
                        loadTable(productDetails);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "So luong phai la so nguyen duong");
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui long chon san pham can sua");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            billService.remove(hddhs.get(tblHDH.getSelectedRow()).getId());
            hddhs = billService.findByTypeEqual(0);
            loadTableHDDH(hddhs);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Loi");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner sprinerTienDua;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHDC;
    private javax.swing.JTable tblHDH;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField textGiamGia;
    private javax.swing.JTextField textHoaDon;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField textSoLuong;
    private javax.swing.JTextField textTienTra;
    private javax.swing.JTextField textTongTien;
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
                        bill.getId(), bill.getCreateDate(), bill.getEmployee().getFullName(), bill.getCustomer() == null ? null : bill.getCustomer().getFullName()
                    }
            );
        }
    }

    private void loadTableHDDH(List<Bill> hddhs) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHDH.getModel();
        defaultTableModel.setRowCount(0);
        for (Bill bill : hddhs) {
            defaultTableModel.addRow(
                    new Object[]{
                        bill.getId(), bill.getCreateDate(), bill.getEmployee().getFullName(), bill.getCustomer() == null ? null : bill.getCustomer().getFullName()
                    }
            );
        }
    }

    public void selecttedcustomor(Customer cus) {
        try {
            billSelected.setCustomer(cus);
            billService.update(billSelected);
            hdcs = billService.findByTypeEqual(1);
            loadTableHDC(hdcs);
            textName.setText(cus.getFirstName() + " " + cus.getBufferName() + " " + cus.getName());
            textSDT.setText(cus.getPhoneNumber());
            focusRowTableHDC(billSelected);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Loi");
        }

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

    private void focusRowTableHDC(Bill billSelected) {
        int i = hdcs.indexOf(billSelected);
        if (i != -1) {
            tblHDC.setRowSelectionInterval(i, i);
        }
    }

    private void clearForm() {
        textHoaDon.setText("");
        textName.setText("");
        textSoLuong.setText("");
        textSDT.setText("");
        textTongTien.setText("");
        textTienTra.setText("");
        textGiamGia.setText("");
        sprinerTienDua.setValue(0D);
    }
}
