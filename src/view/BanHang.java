/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.text.pdf.BaseFont;
import domain.Bill;
import domain.BillDetail;
import domain.Customer;
import domain.Image;
import domain.ProductDetail;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import utils.ImageUtil;

;

public class BanHang extends javax.swing.JFrame {

    private BigDecimal tongTien;
    private Bill billSelected;
    private List<Bill> hdcs = new ArrayList<Bill>();
    private ProductDetail productDetailSelected;
    private ProductDetailService productDetailService;
    private List<ProductDetail> productDetails = new ArrayList<>();
    private List<BillDetail> billDEtailGHs = new ArrayList<>();
    private BillService billService = new BillServiceImpl();
    private BillDetailService billDetailService = new BillDetailServiceImpl();
    private int indexImg;
    private List<Image> images = new ArrayList<>();
    private JLabel jLabel13;
    private JLabel jLabel14;

    public BanHang() {
        tongTien = new BigDecimal(0);
        initComponents();
        init();
        hdcs = billService.findByTypeEqual(1);
        loadTableHDC(hdcs);
        this.productDetailService = new ProductDetailServiceImpl();
        setLocationRelativeTo(null);
        productDetails = productDetailService.findByTypeNotEqual(0);
        loadTable(productDetails);;
    }

    private void showImage(Image image) {
        long avataLenght = 0;

        try {
            if (image.getImage() != null) {
                avataLenght = image.getImage().length();
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
    
    
     public static final String pathUnicode = "font\\unicode.ttf";

    public void exportBill() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(new Date());
            String path = "hoa_don" + date + ".pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            float col = 280f;
            float columWidth[] = {col, col};

            PdfFont font = PdfFontFactory.createFont(pathUnicode, BaseFont.IDENTITY_H);

            Table table = new Table(columWidth);
            table.setBackgroundColor(new DeviceRgb(63, 169, 260)).setFontColor(Color.WHITE);
            table.setFont(font);

            table.addCell(new Cell().add("Bill Gteem Store").setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setFontSize(30f)
                    .setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Ma hoa don:" + textHoaDon.getText()).setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));

            float colWidth[] = {80, 250, 200, 200};
            Table customerInforTable = new Table(colWidth);
            customerInforTable.setFont(font);
            customerInforTable.addCell(new Cell(0, 4)
                    .add("Thong tin khach hang").setBold().setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Ho ten:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add(textName.getText()).setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("So dien thoai:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add(textSDT.getText()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("Id Hoa Don:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add(textHoaDon.getText()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            float itemColWidth[] = {15, 110, 110, 110, 110, 110};
            Table itemTable = new Table(itemColWidth);
            itemTable.setFont(font);
            itemTable.addCell(new Cell().add("STT").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Ten san pham").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Thong tin SP").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("So luong").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Gia ban").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Thanh tien").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(Color.WHITE));

            itemTable.addCell(new Cell().add("Vans classic"));
            itemTable.addCell(new Cell().add("Vans Màu tr?ng Size 40"));
            itemTable.addCell(new Cell().add("2"));
            itemTable.addCell(new Cell().add("250,000 Vn?"));
            itemTable.addCell(new Cell().add("500,000 Vn?"));

            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Tong Tien").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add(textTongTien.getText()).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));

            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInforTable);
            document.add(new Paragraph("\n"));
            document.add(itemTable);
            document.close();
            System.out.println("Export successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        txt_search_productname = new javax.swing.JTextField();
        txt_search_category = new javax.swing.JTextField();
        txt_search_color = new javax.swing.JTextField();
        txt_search_size = new javax.swing.JTextField();
        txt_search_brand = new javax.swing.JTextField();
        txt_search_sole = new javax.swing.JTextField();
        txt_search_quantity = new javax.swing.JTextField();
        txt_search_price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textTienTra = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        sprinerTienDua = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        textHoaDon = new javax.swing.JLabel();
        textTongTien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        lblIndexAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        qr = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Ban Hang");
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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 384, 120));

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

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 480, 230));

        jTextField3.setText("jTextField3");
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, -1));
        jPanel5.add(txt_search_productname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, -1));
        jPanel5.add(txt_search_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 60, -1));
        jPanel5.add(txt_search_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, -1));
        jPanel5.add(txt_search_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, -1));
        jPanel5.add(txt_search_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 60, -1));
        jPanel5.add(txt_search_sole, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 60, -1));
        jPanel5.add(txt_search_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 60, -1));
        jPanel5.add(txt_search_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 70, -1));

        jLabel2.setText("Ten");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setText("Loai");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel4.setText("Mau");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel9.setText("Size");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel13.setText("Hang");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel14.setText("De");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel16.setText("So Luong");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel17.setText("Gia");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 500, 370));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa Don"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Ten KH");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 50, 25));

        textSoLuong.setEditable(false);
        textSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoLuongActionPerformed(evt);
            }
        });
        jPanel1.add(textSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, 30));

        jLabel6.setText("SDT KH");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        jLabel7.setText("So Luong: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));
        jPanel1.add(textSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, -1));

        jLabel8.setText("Tong Tien: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, 30));

        jLabel10.setText("Tien Dua: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, 30));

        jLabel11.setText("Tien Thua: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jButton3.setText("Luu Hoa Don");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 120, 30));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/search-icon-24.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 48, 25, 25));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 25, 25));

        jLabel15.setText("Ma HD: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 50, 20));

        jButton1.setText("Thanh Toan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 100, 30));

        textTienTra.setEditable(false);
        textTienTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTienTraActionPerformed(evt);
            }
        });
        jPanel1.add(textTienTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 170, 20));

        textName.setEditable(false);
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });
        jPanel1.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 140, 25));

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
        jPanel1.add(sprinerTienDua, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 130, 30));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Question-Help-icon-16.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 30, 30));
        jPanel1.add(textHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 350, 20));

        textTongTien.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        textTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(textTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 540, 230));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gio Hang"));
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 540, 160));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton14.setText("<");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 40, 50));

        lblAnh.setBackground(new java.awt.Color(255, 0, 0));
        lblAnh.setForeground(new java.awt.Color(255, 51, 102));
        jPanel4.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 100, 130));

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton13.setText(">");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 40, 50));

        lblIndexAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIndexAnh.setText("0/0");
        jPanel4.add(lblIndexAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 100, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 250, 170));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 155, 60, 30));

        qr.setText("QR");
        qr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qrActionPerformed(evt);
            }
        });
        getContentPane().add(qr, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 60, 50));

        jButton4.setText("Bo Loc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tblGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGHMouseClicked

    }//GEN-LAST:event_tblGHMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (billSelected == null) {
            JOptionPane.showMessageDialog(this, "Chua chon hoa don");
            return;
        }
        if (tblSP.getSelectedRow() >= 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
            if (!billDetailService.containsProductDetail(billSelected, productDetailSelected)) {
                BillDetail billDetail = new BillDetail();
                billDetail.setBill(billSelected);
                billDetail.setProductDetail(productDetails.get(tblSP.getSelectedRow()));
                billDetail.setPrice(new BigDecimal(productDetails.get(tblSP.getSelectedRow()).getPrice().doubleValue() * (1 - (productDetailService.getKM(productDetails.get(tblSP.getSelectedRow()).getId()).doubleValue() / 100))));
                billDetail.setQuantity(1);
                try {
                    productDetailService.changeAmount(billDetail.getProductDetail().getId(), 0 - billDetail.getQuantity());
                    billDetailService.insert(billDetail);
                    billDEtailGHs = billDetailService.findByBill(billSelected);
                    loadTableGH(billDEtailGHs);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    loadTable(productDetails);
                    productDetails = productDetailService.findByTypeNotEqual(0);
                    textTongTien.setText(decimalFormat.format(billService.getSumMoney(billSelected) == null ? null : billService.getSumMoney(billSelected)));
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
        images = productDetailSelected.getImages();
        indexImg = 1;
        if (images.size() > 0) {
            showImage(images.get(indexImg - 1));
        } else {
            lblAnh.setIcon(null);
            lblIndexAnh.setText("0/0");
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new ThemNhanhKhachHangview(this, true).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void textTienTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTienTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTienTraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (billSelected.getBillDetails().size() == 0) {
            JOptionPane.showMessageDialog(this, "Hoa don chua co san pham");
            return;
        }
        try {

            billService.setType(billSelected.getId(), 2);
            JOptionPane.showMessageDialog(this, "Thanh Toan thanh cong");
                    int row = tblGH.getSelectedRow();
        if (row == 0) {

        } else {
            if(JOptionPane.showConfirmDialog(this, "Ban Co Muon In Anh Hoa Don ?")==JOptionPane.OK_OPTION) {
            exportBill();
            clearForm();
            }
        }
  
            hdcs = billService.findByTypeEqual(1);
            loadTableHDC(hdcs);
            billDEtailGHs = new ArrayList<>();
            loadTableGH(billDEtailGHs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void sprinerTienDuaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sprinerTienDuaPropertyChange

    }//GEN-LAST:event_sprinerTienDuaPropertyChange

    private void sprinerTienDuaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sprinerTienDuaStateChanged
        Double tienDua = (Double) sprinerTienDua.getValue();
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        textTienTra.setText(decimalFormat.format(new BigDecimal(tienDua - tongTien.doubleValue())));
    }//GEN-LAST:event_sprinerTienDuaStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int i = tblGH.getSelectedRow();
        if (i >= 0) {
            try {
                Integer slChange = billDEtailGHs.get(i).getQuantity();
                productDetailService.changeAmount(billDEtailGHs.get(i).getProductDetail().getId(), slChange);
                billDetailService.remove(billDEtailGHs.get(i).getId());
                billDEtailGHs = billDetailService.findByBill(billSelected);
                loadTableGH(billDEtailGHs);

                productDetails = productDetailService.findByTypeNotEqual(0);
                loadTable(productDetails);
                DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
                tongTien = billService.getSumMoney(billSelected) == null ? new BigDecimal(0) : billService.getSumMoney(billSelected);
                textTongTien.setText(tongTien == null ? null : decimalFormat.format(tongTien));
                textSoLuong.setText(billService.getQuantity(billSelected) == null ? null : billService.getQuantity(billSelected).toString());
                Double tienDua = (Double) sprinerTienDua.getValue();
                textTienTra.setText(decimalFormat.format(String.valueOf(tienDua - tongTien.doubleValue())));
            } catch (Exception ex) {
                //  JOptionPane.showMessageDialog(this, "Loi");
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

    private void qrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qrActionPerformed
        try {
            ViewQuetQR qR = new ViewQuetQR(this);
            qR.setLocationRelativeTo(this);
            qR.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Khong tim thay camera");
        }
    }//GEN-LAST:event_qrActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void textSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoLuongActionPerformed

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
    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (indexImg > 1) {
            indexImg -= 1;
            showImage(images.get(indexImg - 1));
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (indexImg <= images.size() - 1) {
            indexImg += 1;
            showImage(images.get(indexImg - 1));
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        productDetails = productDetailService.searchProductDetail(txt_search_productname.getText(), txt_search_category.getText(), txt_search_color.getText(), txt_search_size.getText(), txt_search_brand.getText(), txt_search_sole.getText(), txt_search_quantity.getText(), txt_search_price.getText());
        loadTable(productDetails);

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblIndexAnh;
    private javax.swing.JButton qr;
    private javax.swing.JSpinner sprinerTienDua;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHDC;
    private javax.swing.JTable tblSP;
    private javax.swing.JLabel textHoaDon;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textSDT;
    private javax.swing.JTextField textSoLuong;
    private javax.swing.JTextField textTienTra;
    private javax.swing.JLabel textTongTien;
    private javax.swing.JTextField txt_search_brand;
    private javax.swing.JTextField txt_search_category;
    private javax.swing.JTextField txt_search_color;
    private javax.swing.JTextField txt_search_price;
    private javax.swing.JTextField txt_search_productname;
    private javax.swing.JTextField txt_search_quantity;
    private javax.swing.JTextField txt_search_size;
    private javax.swing.JTextField txt_search_sole;
    // End of variables declaration//GEN-END:variables

    private void loadTable(List<ProductDetail> productDetails) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblSP.getModel();
        defaultTableModel.setRowCount(0);
        for (ProductDetail pd : productDetails) {

            defaultTableModel.addRow(new Object[]{pd.getProduct() == null ? null : pd.getProduct().getProductName(), pd.getCategory(), pd.getColor(), pd.getSize(), pd.getBrand(), pd.getSole(), pd.getAmount(), decimalFormat.format(pd.getPrice()), productDetailService.getKM(pd.getId()) + " %"});

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
            JButton button = new JButton("XÃ³a");

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
                    "Ten", "Loai", "Mau", "Size", "Hang", "De", "So luong", "Gia", "KM"
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
                    "Ten", "Gia", "So luong", "Thanh tien"
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
                    "Ma HDC", "Tgian tao", "Nhan vien", "Khach hang"
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
        sprinerTienDua.setValue(0D);
    }

    public void addProdToGH(ProductDetail productDetailSelected) {
        this.productDetailSelected = productDetailSelected;
        if (!billDetailService.containsProductDetail(billSelected, this.productDetailSelected)) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBill(billSelected);
            billDetail.setProductDetail(productDetailSelected);
            billDetail.setPrice(productDetailSelected.getPrice());
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
}
