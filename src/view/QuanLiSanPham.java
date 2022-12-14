/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import domain.Brand;
import domain.Category;
import domain.Color;
import domain.Image;
import domain.Product;
import domain.ProductDetail;
import domain.Size;
import domain.Sole;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
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
import utils.Constant;
import utils.ImageUtil;
import utils.QrCodeUtil;

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
    private List<Image> images = new ArrayList<>();
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
        soles = soleService.findByTypeNotEqual(0);
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cbxSole.getModel();
        comboBoxModel.removeAllElements();
        System.out.println(soles.size());
        for (Sole sole : soles) {
            comboBoxModel.addElement(sole);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        textID = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
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
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textNote = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinAmount = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnCategory = new javax.swing.JButton();
        btnColor = new javax.swing.JButton();
        btnSize = new javax.swing.JButton();
        btnBrand = new javax.swing.JButton();
        btnSole = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_search_productname = new javax.swing.JTextField();
        txt_search_category = new javax.swing.JTextField();
        txt_search_color = new javax.swing.JTextField();
        txt_search_size = new javax.swing.JTextField();
        txt_search_brand = new javax.swing.JTextField();
        txt_search_sole = new javax.swing.JTextField();
        txt_search_quantity = new javax.swing.JTextField();
        txt_search_price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        btnAddAvata = new javax.swing.JButton();
        btnAddAvata2 = new javax.swing.JButton();
        btnAddAvata1 = new javax.swing.JButton();
        lblIndexAnh = new javax.swing.JLabel();
        textPrice = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        textName = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

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
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 100, -1));
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 280, 16));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 90, -1));

        cbxSole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxSole, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 221, -1));

        jLabel3.setText("Color  ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 54, -1));

        jLabel8.setText("Sole: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 40, -1));

        cbxBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 221, -1));

        jLabel7.setText("Category: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 72, -1));

        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cbxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 220, -1));

        jLabel6.setText("Brand");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 43, -1));

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 220, -1));

        jLabel4.setText("Size: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 46, -1));

        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 220, -1));

        jLabel13.setText("So luong");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 80, 20));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, -1));

        jLabel11.setText("Gia");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 70, 20));

        textNote.setColumns(20);
        textNote.setRows(5);
        jScrollPane2.setViewportView(textNote);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 198, 90));

        jLabel2.setText("Id: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 30, -1));

        jLabel9.setText("ProductName: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 90, 20));

        spinAmount.setModel(new javax.swing.SpinnerNumberModel(0L, 0L, null, 1L));
        getContentPane().add(spinAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 197, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Quan Ly San Pham ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 13, 219, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên", "Loai", "Mau", "Size", "Hang", "De", "So Luong", "Gia", "Mo Ta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 960, 190));

        jLabel14.setText("Decription: ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 80, 20));

        btnCategory.setText("+");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        btnColor.setText("+");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });
        getContentPane().add(btnColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        btnSize.setText("+");
        btnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeActionPerformed(evt);
            }
        });
        getContentPane().add(btnSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, -1, -1));

        btnBrand.setText("+");
        btnBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrandActionPerformed(evt);
            }
        });
        getContentPane().add(btnBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        btnSole.setText("+");
        btnSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleActionPerformed(evt);
            }
        });
        getContentPane().add(btnSole, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txt_search_productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_productnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_search_productname);
        jPanel1.add(txt_search_category);
        jPanel1.add(txt_search_color);
        jPanel1.add(txt_search_size);
        jPanel1.add(txt_search_brand);
        jPanel1.add(txt_search_sole);
        jPanel1.add(txt_search_quantity);
        jPanel1.add(txt_search_price);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 850, -1));

        jButton1.setText("SEACH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 365, -1, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton14.setText("<");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 50));

        lblAnh.setBackground(new java.awt.Color(255, 0, 0));
        lblAnh.setForeground(new java.awt.Color(255, 51, 102));
        jPanel2.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, 130));

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton12.setText(">");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 40, 50));

        btnAddAvata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnAddAvata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvataActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddAvata, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 40, -1));

        btnAddAvata2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnAddAvata2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvata2ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddAvata2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 40, -1));

        btnAddAvata1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        btnAddAvata1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvata1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddAvata1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, -1));

        lblIndexAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIndexAnh.setText("0/0");
        jPanel2.add(lblIndexAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 250, 200));

        textPrice.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 100000.0d));
        getContentPane().add(textPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 197, -1));

        textName.setColumns(20);
        textName.setRows(5);
        jScrollPane3.setViewportView(textName);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 190, 50));

        jButton2.setText("Tao QRCode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, -1, -1));

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
                meseage = "Ban Co Muon Them San Pham Moi :" + productDetail.getProduct().getProductName();
            } else {
                meseage = "Ban Co Muon Them Lua Chon Cho San Pham: (" + productDetail.getProduct().getProductName() + ")";
            }
            if (JOptionPane.showConfirmDialog(this, meseage, "Xac Nhan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                try {
                    productDetail.setCreateDate(new Date());
                    productDetail.setId(null);
                    productDetailService.insert(productDetail);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Them That Bai");
                }
            }
        }
        //
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
        showImage(null);
        indexImg = 0;
        lblIndexAnh.setText("0/0");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        ProductDetail productDetail = getFormData();
        if (productDetail == null) {

        } else {

            if (productDetailSelected == null) {
                   JOptionPane.showMessageDialog(this, "Can chon san pham cap nhat");
            } else {
                if (JOptionPane.showConfirmDialog(this, "Xac Nhan Cap Nhat", "Xac Nhan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                    try {
                        productDetail.setId(productDetailSelected.getId());
                        productDetailService.update(productDetail);
                        productDetails = productDetailService.findByTypeNotEqual(0);
                        loadTable(productDetails);
                        JOptionPane.showMessageDialog(this, "Cap Nhat Thanh Cong");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Cap Nhat That Bai");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (productDetailSelected != null) {
            if (JOptionPane.showConfirmDialog(this, "Xac Nhan Xoa", "Xac Nhan", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                try {
                    productDetailService.setType(productDetailSelected.getId(), 0);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Xoa That Bai");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chua chon san pham");
        }
        clearForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddAvata1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvata1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return "Images file (.jpg)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

        });
        if (fileChooser.showDialog(this, "Chon file") == fileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file.exists()) {
                Image img = new Image();
                img.setProductDetail(productDetailSelected);
                ImageIcon icon = new ImageIcon(file.getPath());
                java.awt.Image image = ImageUtil.resize(icon.getImage(), 100, 130);
                ImageIcon imageIcon = new ImageIcon(image);
                try {
                    byte[] imageByte = ImageUtil.toByteArray(icon.getImage(), "jpg");
                    img.setImage(new SerialBlob(imageByte));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();;
                }
                images.add(img);
                lblAnh.setIcon(imageIcon);
                indexImg = images.size();
                lblIndexAnh.setText(indexImg + "/" + images.size());
                showImage(img);
            } else {
                JOptionPane.showMessageDialog(this, "File khong ton tai");
            }
        } else {
            return;
        }


    }//GEN-LAST:event_btnAddAvata1ActionPerformed

    private void btnAddAvata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvata2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return "Images file (.jpg)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

        });
        if (fileChooser.showDialog(this, "Ch?n file") == fileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file.exists()) {
                Image img = images.get(indexImg - 1);
                ImageIcon icon = new ImageIcon(file.getPath());
                java.awt.Image image = ImageUtil.resize(icon.getImage(), 100, 130);
                ImageIcon imageIcon = new ImageIcon(image);
                try {
                    byte[] imageByte = ImageUtil.toByteArray(icon.getImage(), "jpg");
                    img.setImage(new SerialBlob(imageByte));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();;
                }
                images.set(indexImg - 1, img);
                lblAnh.setIcon(imageIcon);
                lblIndexAnh.setText(indexImg + "/" + images.size());

            } else {
                JOptionPane.showMessageDialog(this, "File khong ton tai");
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btnAddAvata2ActionPerformed

    private void btnAddAvataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvataActionPerformed
        images.remove(indexImg - 1);
        indexImg -= 1;
        showImage(images.get(indexImg - 1));
        lblIndexAnh.setText(indexImg + "/" + images.size());

    }//GEN-LAST:event_btnAddAvataActionPerformed

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoryActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        productDetails = productDetailService.searchProductDetail(txt_search_productname.getText(), txt_search_category.getText(), txt_search_color.getText(), txt_search_size.getText(), txt_search_brand.getText(), txt_search_sole.getText(), txt_search_quantity.getText(), txt_search_price.getText());
        loadTable(productDetails);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_search_productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_productnameActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (indexImg <= images.size() - 1) {
            indexImg += 1;
            showImage(images.get(indexImg - 1));
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (indexImg > 1) {
            indexImg -= 1;
            showImage(images.get(indexImg - 1));
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (textID.getText().trim().length() < 5) {
            JOptionPane.showMessageDialog(this, "Hay chon san pham muon tao QRCode");
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return "Images file (.jpg)";
            }

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

        });
        if (fileChooser.showDialog(this, "Chon file") == fileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getPath();
            if (filePath.contains(".")) {
						String duoi = filePath.substring(filePath.indexOf("."));
						if (!(duoi.equals(".jpg") )) {
							JOptionPane.showInternalMessageDialog(this, "File phai co duoi .jpg ",
									"L?i", JOptionPane.ERROR_MESSAGE);
							return;
						}
					} else {
						filePath += ".jpg";
					}
            if (!file.exists()) {
                try {
                    String charset = "UTF-8";
                    
                    Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                            = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
                    
                    hashMap.put(EncodeHintType.ERROR_CORRECTION,
                            ErrorCorrectionLevel.L);
                    QrCodeUtil.createQR(textID.getText().trim(), filePath, charset, hashMap, 600, 600);
                    JOptionPane.showMessageDialog(this, "Da tao QRCode : "+file.getPath());
                } catch (WriterException|IOException ex) {
                    ex.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Loi tao QRCode");
                } 
            } else {
                JOptionPane.showMessageDialog(this, "File da ton tai");
            }
        } else {
            return;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblIndexAnh;
    private javax.swing.JSpinner spinAmount;
    private javax.swing.JTable table;
    private javax.swing.JLabel textID;
    private javax.swing.JTextArea textName;
    private javax.swing.JTextArea textNote;
    private javax.swing.JSpinner textPrice;
    private javax.swing.JTextField txt_search_brand;
    private javax.swing.JTextField txt_search_category;
    private javax.swing.JTextField txt_search_color;
    private javax.swing.JTextField txt_search_price;
    private javax.swing.JTextField txt_search_productname;
    private javax.swing.JTextField txt_search_quantity;
    private javax.swing.JTextField txt_search_size;
    private javax.swing.JTextField txt_search_sole;
    // End of variables declaration//GEN-END:variables

    private ProductDetail getFormData() {

        if (textName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name Null");
            return null;
        }
        ProductDetail productDetail = null;
        productDetail = new ProductDetail();

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
        Double price = (Double) textPrice.getValue();
        BigDecimal priceBigDecimal = new BigDecimal(price);
        productDetail.setPrice(priceBigDecimal);
        Long amount = (Long) spinAmount.getValue();
        productDetail.setAmount(amount);
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
        if (productDetailSelected != null) {
            productDetail.setType(productDetailSelected.getType());
        }
        return productDetail;
    }

    private void loadTable(List<ProductDetail> productDetails) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        for (ProductDetail productDetail : productDetails) {
            defaultTableModel.addRow(productDetail.toRow());
        }

    }

    private void showImage(Image image) {
        long avataLenght = 0;

        try {
            if (image != null) {
                if (image.getImage() != null) {
                    avataLenght = image.getImage().length();
                } else {

                }
            }
        } catch (SQLException ex) {
            avataLenght = 0;
        }
        byte[] byteImage = null;
        if (avataLenght == 0) {
            byteImage = null;
            lblAnh.setIcon(null);
        } else {
            ImageIcon icon;
            try {
                icon = new ImageIcon(image.getImage().getBytes(1, (int) image.getImage().length()));
            } catch (SQLException ex) {
                ex.printStackTrace();
                icon = null;
            }
            java.awt.Image imagex = ImageUtil.resize(icon.getImage(), 120, 150);
            try {
                byteImage = ImageUtil.toByteArray(icon.getImage(), "jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            lblAnh.setIcon(new ImageIcon(imagex));
            lblIndexAnh.setText(indexImg + "/" + images.size());
        }
    }

    private void fillForm() {
        int i = table.getSelectedRow();
        if (i >= 0) {
            ProductDetail pd = productDetails.get(i);
            images = pd.getImages();
            textID.setText(pd.getId().toString());
            cbxBrand.setSelectedItem(pd.getBrand());
            cbxCategory.setSelectedItem(pd.getCategory());
            cbxColor.setSelectedItem(pd.getColor());
            cbxSize.setSelectedItem(pd.getSize());
            cbxSole.setSelectedItem(pd.getSole());
            textName.setText(pd.getProduct().getProductName());
            textPrice.setValue(pd.getPrice().doubleValue());
            spinAmount.setValue(pd.getAmount().longValue());
            textNote.setText(pd.getDescription());
            productDetailSelected = pd;
            images = productDetailSelected.getImages();
            indexImg = 1;
            if (images.size() > 0) {
                showImage(images.get(indexImg - 1));
            } else {
                lblAnh.setIcon(null);
                lblIndexAnh.setText("0/0");
            }

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
        textPrice.setValue(0);
        spinAmount.setValue(0);
        textNote.setText("");
        productDetailSelected = null;

    }
}
