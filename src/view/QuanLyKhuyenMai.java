/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import domain.ProductDetail;
import domain.Promotion;
import domain.Promotion_Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.ProductDetailService;
import service.PromotionService;
import service.Promotion_ProductService;
import service.impl.ProductDetailServiceImpl;
import service.impl.PromotionServiceImpl;
import service.impl.Promotion_ProductServiceImpl;

/**
 *
 * @author Administrator
 */
public class QuanLyKhuyenMai extends javax.swing.JFrame {

    private Promotion_ProductService ppService = new Promotion_ProductServiceImpl();
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails = new ArrayList<>();
    private PromotionService promotionService;
    private List<Promotion> promotions = new ArrayList<>();
    private DateChooser dateChooser = new DateChooser();
    private Promotion promotionSelected;
    String[] columnsTblSP = new String[]{
        "Ten", "Loai", "Mau", "Size", "hang", "D?", "So luonng", "Gia", "Mo ta", ""};

    public QuanLyKhuyenMai() {
        initComponents();
        setLocationRelativeTo(null);
        init();
        this.productDetailService = new ProductDetailServiceImpl();
        this.promotionService = new PromotionServiceImpl();
        promotions = promotionService.findByTypeNotEqual(0);
        loadTableKM(promotions);;
    }

    private void loadTable(List<ProductDetail> productDetails) {

        DefaultTableModel defaultTableModel = (DefaultTableModel) Tblsp.getModel();
        defaultTableModel.setRowCount(0);
        for (ProductDetail p : productDetails) {
            defaultTableModel.addRow(
                    new Object[]{p.getProduct() == null ? null : p.getProduct().getProductName(), p.getCategory() == null ? null : p.getCategory().getCategoryName(), p.getColor(), p.getSize(), p.getBrand(), p.getSole(), p.getAmount(), p.getPrice(), p.getDescription(), containPdinPr(promotionSelected, p)}
            );
        }
    }

    private boolean containPdinPr(Promotion promotionSelected, ProductDetail p) {
        if (promotionSelected != null) {
            List<Promotion_Product> list = promotionSelected.getPromotionProducts();
            for (Promotion_Product pp : list) {

                if (pp.getProductDetail().getId().toString().equals(p.getId().toString())) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;

    }

    private void loadTableKM(List<Promotion> promotions) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblKhuyenMai.getModel();
        defaultTableModel.setRowCount(0);
        for (Promotion promotion : promotions) {
            defaultTableModel.addRow(promotion.toRow());
        }
    }

    private void init() {
        //Headers for JTable
        DefaultTableModel model = new DefaultTableModel(columnsTblSP, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        Tblsp = new JTable(model) {
            @Override
            public Class<?> getColumnClass(int column) {
                int max = getColumnCount();
                if (column == max - 1) {
                    return Boolean.class;
                } else {
                    return Object.class;
                }
            }

        };
        Tblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tblsp);

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Ma", "Ten", "Loai", "Gia tri min", "Gia tri KM", "Trang Thai"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        dateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        dateChooser.setTextField(textNgayHieuLuc);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textNgayHieuLuc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textNote = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbxLoaiKhuyenMai = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        spinerGiaToiThieu = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinerMucGiamGia = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblsp = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Quan Li Khuyen Mai ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Code Khuyen Mai: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, -1));

        textID.setEditable(false);
        jPanel2.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 58, 270, 20));

        jLabel2.setText("Ten Khuyen Mai: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        jPanel2.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 98, 270, 20));

        jLabel3.setText("Ngay hieu luc");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 84, 20));

        textNgayHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNgayHieuLucActionPerformed(evt);
            }
        });
        jPanel2.add(textNgayHieuLuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 270, -1));

        jLabel11.setText("Muc Giam Gia: ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 180, 100, 20));

        jLabel7.setText("N?i dung");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, 20));

        textNote.setColumns(20);
        textNote.setRows(5);
        jScrollPane3.setViewportView(textNote);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 270, 60));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 67, -1));

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 71, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        cbxLoaiKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo san pham", "Hoa don chua san pham", "Tat ca hoa don", "Tat ca" }));
        cbxLoaiKhuyenMai.setToolTipText("");
        jPanel2.add(cbxLoaiKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 270, 30));

        jLabel8.setText("Khuyen mai theo");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        spinerGiaToiThieu.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 10000.0d));
        jPanel2.add(spinerGiaToiThieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 260, -1));

        jLabel12.setText("Gia Toi Thieu: ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 20));

        jLabel13.setText("%");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 20, 20));

        spinerMucGiamGia.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        jPanel2.add(spinerMucGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 240, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 410, 490));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhuyenMai);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 510, 180));

        jLabel10.setText("Danh Sach Khuyen Mai");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 530, 230));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tblsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, "", null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tblsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tblsp);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 510, 240));

        jLabel9.setText("San Pham");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 530, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Promotion promotion = getFormDate();
        if (promotion == null) {
            JOptionPane.showMessageDialog(this, "Du lieu khong hop le");
        } else {
            try {
                promotionService.insert(promotion);
                promotions = promotionService.findByTypeNotEqual(0);
                loadTableKM(promotions);
                JOptionPane.showMessageDialog(this, "Them th�nh c�ng");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        if (tblKhuyenMai.getSelectedRow() >= 0) {
            promotionSelected = promotions.get(tblKhuyenMai.getSelectedRow());
            fillForm(promotions.get(tblKhuyenMai.getSelectedRow()));
            productDetails = productDetailService.findByTypeNotEqual(0);
            loadTable(productDetails);
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Promotion promotion = getFormDate();
        if (promotion == null) {
            JOptionPane.showMessageDialog(this, "Du lieu khong hop le");
        } else {
            try {
                if (textID.getText().length() < 5) {
                    JOptionPane.showMessageDialog(this, "Phai chon san pham muon sua");
                    return;
                }
                promotionService.update(promotion);
                promotions = promotionService.findByTypeNotEqual(0);
                loadTableKM(promotions);
                new Promotion_ProductServiceImpl().deletePromotionNull();
                JOptionPane.showMessageDialog(this, "Sua thanh cong");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Loi");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {
            if (textID.getText().length() < 5) {
                JOptionPane.showMessageDialog(this, "Phai chon san pham muon xoa");
                return;
            }
            promotionService.remove(UUID.fromString(textID.getText().trim()));
            promotions = promotionService.findByTypeNotEqual(0);
            loadTableKM(promotions);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Loi");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void TblspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblspMouseClicked
        int i = Tblsp.getSelectedRow();
        if (i >= 0) {
            Boolean b = (Boolean) Tblsp.getValueAt(i, Tblsp.getColumnCount() - 1);
            ProductDetail p = productDetails.get(i);
            List<Promotion_Product> list = promotionSelected.getPromotionProducts();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (b) {
                Promotion_Product pp = ppService.findByProductAndPromotion(p, promotionSelected);
                if (pp == null) {
                    Promotion_Product ppAdd = new Promotion_Product();
                    ppAdd.setProductDetail(p);
                    ppAdd.setPromotion(promotionSelected);
                    promotionSelected.addPromotionProduct(ppAdd);
                }
            } else {
                Promotion_Product pp = ppService.findByProductAndPromotion(p, promotionSelected);
                if (pp != null) {
                    promotionSelected.removePromotionProduct(pp);
                }
            }
        }
    }//GEN-LAST:event_TblspMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        promotions = promotionService.findByTypeNotEqual(0);
        loadTableKM(promotions);
        promotionSelected = null;
        loadTable(new ArrayList<>());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void textNgayHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNgayHieuLucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNgayHieuLucActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tblsp;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxLoaiKhuyenMai;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spinerGiaToiThieu;
    private javax.swing.JSpinner spinerMucGiamGia;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textNgayHieuLuc;
    private javax.swing.JTextArea textNote;
    // End of variables declaration//GEN-END:variables

    private Promotion getFormDate() {
        Promotion promotion = promotionSelected;
        if (promotion == null) {
            promotion = new Promotion();
        }
        promotion.setPromotionName(textName.getText().trim());
        promotion.setCreateDate(new Date());
        try {
            DateBetween between = dateChooser.getSelectedDateBetween();
            promotion.setStartDate(between.getFromDate());
            promotion.setEndDate(between.getToDate());
        } catch (Exception e) {
            return null;
        }

        Double km = (Double) spinerMucGiamGia.getValue();
        promotion.setDiscount(km);
        BigDecimal bigDecimal = new BigDecimal((Double) spinerGiaToiThieu.getValue());
        promotion.setMinimumPrice(bigDecimal);
        String note = textNote.getText();
        promotion.setDescription(note);
        promotion.setType(cbxLoaiKhuyenMai.getSelectedIndex() + 1);
        return promotion;
    }

    private void fillForm(Promotion p) {
        promotionSelected = p;
        textID.setText(p.getId().toString());
        textName.setText(p.getPromotionName());
        Date startDate = p.getStartDate();
        Date endDate = p.getEndDate();
        DateBetween dateBetween = new DateBetween(startDate, endDate);
        dateChooser.setSelectedDateBetween(dateBetween);
        spinerMucGiamGia.setValue(p.getDiscount());
        spinerGiaToiThieu.setValue(p.getMinimumPrice().doubleValue());
        textNote.setText(p.getDescription());
    }

    private void clearForm() {
        promotionSelected = null;
        textID.setText("");
        textName.setText("");
        dateChooser.toDay();
        spinerMucGiamGia.setValue(0D);
        spinerGiaToiThieu.setValue(0D);
        textNote.setText("");
        cbxLoaiKhuyenMai.setSelectedIndex(0);
    }
}
