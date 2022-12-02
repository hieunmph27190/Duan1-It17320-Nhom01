/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Brand;
import domain.Category;
import domain.Color;
import domain.Image;
import domain.Product;
import domain.ProductDetail;
import domain.Size;
import domain.Sole;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.BrandService;
import service.CategoryService;
import service.ColorService;
import service.ProductDetailService;
import service.SizeService;
import service.SoleService;
import service.impl.BrandServiceImpl;
import service.impl.CategoryServiceImpl;
import service.impl.ColorServiceImpl;
import service.impl.ProductDetailServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.SizeServiceImpl;
import service.impl.SoleServiceImpl;

/**
 *
 * @author Administrator
 */
public class QuanLiSanPham extends javax.swing.JFrame {

    private CategoryService categoryService = new CategoryServiceImpl();
    private List<Category> categorys;
    private ColorService colorService = new ColorServiceImpl();
    private List<Color> colors;
    private SizeService sizeService = new SizeServiceImpl();
    private List<Size> sizes;
    private BrandService brandService = new BrandServiceImpl();
    private List<Brand> brands;
    private SoleService soleService = new SoleServiceImpl();
    private List<Sole> soles;
    private ProductDetail productDetailSelected;
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails;
    private List<Image>images;
    private int indexImg;

    public QuanLiSanPham() {
        initComponents();
        productDetailService = new ProductDetailServiceImpl();
        loadBrand();
        loadCategory();
        loadColor();
        loadSize();
        loadSole();
        productDetails = productDetailService.findByTypeNotEqual(0);
        loadTable(productDetails);
        setLocationRelativeTo(null);
    }

    public void loadCategory() {
        categorys = categoryService.findByTypeNotEqual(0);
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxCategory.getModel();
        comboBoxModel.removeAllElements();
        for (Category category : categorys) {
            comboBoxModel.addElement(category);
        }
    }

    public void loadColor() {
        colors = colorService.findByTypeNotEqual(0);
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxColor.getModel();
        comboBoxModel.removeAllElements();
        for (Color color : colors) {
            comboBoxModel.addElement(color);
        }
    }

    public void loadSize() {
        sizes = sizeService.findByTypeNotEqual(0);
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxSize.getModel();
        comboBoxModel.removeAllElements();
        for (Size size : sizes) {
            comboBoxModel.addElement(size);
        }
    }

    public void loadBrand() {
        brands = brandService.findByTypeNotEqual(0);
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxBrand.getModel();
        comboBoxModel.removeAllElements();
        for (Brand brand : brands) {
            comboBoxModel.addElement(brand);
        }
    }

    public void loadSole() {
        soles = soleService.findAll();
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxSole.getModel();
        comboBoxModel.removeAllElements();
        System.out.println(soles.size());
        for (Sole sole : soles) {
            comboBoxModel.addElement(sole);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        textID = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        cbxSole = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxBrand = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxSize = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxColor = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        spinBH = new javax.swing.JSpinner();
        textPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textNote = new javax.swing.JTextArea();
        textName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinAmount = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnCategory = new javax.swing.JButton();
        btnColor = new javax.swing.JButton();
        btnSize = new javax.swing.JButton();
        btnBrand = new javax.swing.JButton();
        btnSole = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        btnAddAvata = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnAddAvata1 = new javax.swing.JButton();
        btnAddAvata2 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 75, -1));
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 98, 210, 16));

        jButton7.setText("San Pham Da Xoa");
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 141, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 192, 20));

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 359, -1, -1));

        jButton1.setText("SEACH");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, 20));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 359, 71, -1));

        cbxSole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxSole, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 221, -1));

        jLabel3.setText("Color  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 172, 54, -1));

        jLabel8.setText("Sole: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 40, -1));

        cbxBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 221, -1));

        jLabel7.setText("Category: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 134, 72, -1));

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 131, 216, -1));

        jLabel6.setText("Brand");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 43, -1));

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 210, 220, -1));

        jLabel4.setText("Size: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 213, 46, -1));

        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 169, 220, -1));

        jLabel13.setText("S? l??ng");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 57, 20));

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 359, -1, -1));

        spinBH.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        getContentPane().add(spinBH, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 197, -1));
        getContentPane().add(textPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 198, -1));

        jLabel11.setText("Gi�");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 57, -1));

        textNote.setColumns(20);
        textNote.setRows(5);
        jScrollPane2.setViewportView(textNote);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 198, 70));
        getContentPane().add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 198, -1));

        jLabel5.setText("B?o h�nh (th�ng)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 98, 20));

        jLabel2.setText("Id: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 98, 30, -1));

        jLabel9.setText("ProductName: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 80, -1));

        spinAmount.setModel(new javax.swing.SpinnerNumberModel(0L, 0L, null, 1L));
        getContentPane().add(spinAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 197, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quan Ly San Pham ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 13, 219, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "T�n", "Lo?i2", "M�u", "Size", "H�ng5", "D?", "S? l??ng", "Gi�", "B?o h�nh (th�ng)", "M� t?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 790, 253));

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setForeground(new java.awt.Color(255, 51, 102));
        jLabel15.setText("?nh");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 110, 140));

        jLabel14.setText("Decription: ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, -1, -1));

        btnCategory.setText("+");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 130, -1, -1));

        btnColor.setText("+");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });
        getContentPane().add(btnColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 168, -1, -1));

        btnSize.setText("+");
        btnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeActionPerformed(evt);
            }
        });
        getContentPane().add(btnSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 209, -1, -1));

        btnBrand.setText("+");
        btnBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrandActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        btnSole.setText("+");
        btnSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleActionPerformed(evt);
            }
        });
        getContentPane().add(btnSole, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T�n", "Ng�y sinh" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 80, 20));

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton12.setText(">");
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 40, 50));

        btnAddAvata.setText("X�a");
        btnAddAvata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvataActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAvata, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 70, -1));

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton14.setText("<");
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 40, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("H�nh");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, 70));

        btnAddAvata1.setText("Th�m");
        btnAddAvata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvata1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAvata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 70, -1));

        btnAddAvata2.setText("S?a");
        btnAddAvata2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvata2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAvata2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 70, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        new ViewCategories(this, true).setVisible(true);
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProductDetail productDetail = getFormData();
        if (productDetail == null) {

        } else {
            String meseage = "";
            if (productDetail.getProduct().getId() == null) {
                meseage = "B?n c� ch?c ch?n mu?n th�m m?t s?n ph?m v?i t�n :" + productDetail.getProduct().getProductName();
            } else {
                meseage = "B?n c� ch?c ch?n mu?n th�m l?a ch?n ch� s?n ph?m (" + productDetail.getProduct().getProductName() + ")";
            }
            if (JOptionPane.showConfirmDialog(this, meseage, "X�c nh?n", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                try {
             
                    productDetail.setId(null);
                    productDetailService.insert(productDetail);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    JOptionPane.showMessageDialog(this, "Th�m th�nh c�ng");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Th�m th?t b?i");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        new ViewColors(this, true).setVisible(true);
    }//GEN-LAST:event_btnColorActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        fillForm();
    }//GEN-LAST:event_tableMouseClicked

    private void btnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeActionPerformed
        new ViewSize(this, true).setVisible(true);
    }//GEN-LAST:event_btnSizeActionPerformed

    private void btnBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrandActionPerformed
        new ViewBrand(this, true).setVisible(true);
    }//GEN-LAST:event_btnBrandActionPerformed

    private void btnSoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoleActionPerformed
        new ViewSole(this, true).setVisible(true);
    }//GEN-LAST:event_btnSoleActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        ProductDetail productDetail = getFormData();
        if (productDetail == null) {

        } else {
            if (JOptionPane.showConfirmDialog(this, "X�c nh?n c?p nh?t", "X�c nh?n", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                try {
                    productDetailService.update(productDetail);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    JOptionPane.showMessageDialog(this, "C?p nh?t th�nh c�ng");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "C?p nh?t th?t b?i");
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        ProductDetail productDetail = getFormData();
        if (productDetail != null) {
            if (JOptionPane.showConfirmDialog(this, "X�c nh?n x�a", "X�c nh?n", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                try {
                    productDetailService.setType(productDetail.getId(),0);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    JOptionPane.showMessageDialog(this, "C?p nh?t th�nh c�ng");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "C?p nh?t th?t b?i");
                }
            }
        } else {

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddAvata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvata1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAvata1ActionPerformed

    private void btnAddAvata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvata2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAvata2ActionPerformed

    private void btnAddAvataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAvataActionPerformed

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAvata;
    private javax.swing.JButton btnAddAvata1;
    private javax.swing.JButton btnAddAvata2;
    private javax.swing.JButton btnBrand;
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnColor;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSize;
    private javax.swing.JButton btnSole;
    private javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox<String> cbxBrand;
    public javax.swing.JComboBox<String> cbxCategory;
    public javax.swing.JComboBox<String> cbxColor;
    public javax.swing.JComboBox<String> cbxSize;
    public javax.swing.JComboBox<String> cbxSole;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JSpinner spinAmount;
    private javax.swing.JSpinner spinBH;
    private javax.swing.JTable table;
    private javax.swing.JLabel textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextArea textNote;
    private javax.swing.JTextField textPrice;
    // End of variables declaration//GEN-END:variables

    private ProductDetail getFormData() {
        
        if(textName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name Null");
            return null;
        }
        
        if(textNote.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Note Null");
            return null;
        }
        
        if(textPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price Null");
            return null;
        }
        
        ProductDetail productDetail = productDetailSelected;
        if (productDetail == null) {
            productDetail = new ProductDetail();
        }
        String productName = textName.getText().trim();
        Product product = null;
        product = new ProductServiceImpl().FindByNameEqual(productName);
        if (product == null) {
            product = new Product();
            product.setProductName(productName);
        }
        productDetail.setProduct(product);
        String price = textPrice.getText();
        BigDecimal priceBigDecimal = new BigDecimal(price);
        productDetail.setPrice(priceBigDecimal);
        Long amount = (Long) spinAmount.getValue();
        productDetail.setAmount(amount);
        Integer thangBH = (Integer) spinBH.getValue();
        productDetail.setWarrantyTime(thangBH);
        String description = textNote.getText();
        productDetail.setDescription(description);
        Color color = (Color) cbxColor.getSelectedItem();
        productDetail.setColor(color);
        Brand brand = (Brand) cbxBrand.getSelectedItem();
        productDetail.setBrand(brand);
        Category category = (Category) cbxCategory.getSelectedItem();
        productDetail.setCategory(category);
        Size size = (Size) cbxSize.getSelectedItem();
        productDetail.setSize(size);
        Sole sole = (Sole) cbxSole.getSelectedItem();
        productDetail.setSole(sole);
        return productDetail;
    }

    private void loadTable(List<ProductDetail> productDetails) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        for (ProductDetail productDetail : productDetails) {
            defaultTableModel.addRow(productDetail.toRow());
        }

    }

    private void fillForm() {
        int i = table.getSelectedRow();
        if (i >= 0) {
            ProductDetail pd = productDetails.get(i);
            textID.setText(pd.getId().toString());
            cbxBrand.setSelectedItem(pd.getBrand());
            cbxCategory.setSelectedItem(pd.getCategory());
            cbxColor.setSelectedItem(pd.getColor());
            cbxSize.setSelectedItem(pd.getSize());
            cbxSole.setSelectedItem(pd.getSole());
            textName.setText(pd.getProduct().getProductName());
            textPrice.setText(pd.getPrice().toString());
            spinAmount.setValue(pd.getAmount());
            spinBH.setValue(pd.getWarrantyTime());
            textNote.setText(pd.getDescription());
            productDetailSelected = pd;
        }
    }

    private void clearForm() {
        textID.setText("");
        if (cbxBrand.getItemCount() > 0) {
            cbxBrand.setSelectedIndex(0);
        }
        if (cbxCategory.getItemCount() > 0) {
            cbxCategory.setSelectedIndex(0);
        }
        if (cbxColor.getItemCount() > 0) {
            cbxColor.setSelectedIndex(0);
        }
        if (cbxSize.getItemCount() > 0) {
            cbxSize.setSelectedIndex(0);
        }
        if (cbxSole.getItemCount() > 0) {
            cbxSole.setSelectedIndex(0);
        }
        textName.setText("");
        textPrice.setText("");
        spinAmount.setValue(0);
        spinBH.setValue(0);
        textNote.setText("");
        productDetailSelected = null;

    }
}
