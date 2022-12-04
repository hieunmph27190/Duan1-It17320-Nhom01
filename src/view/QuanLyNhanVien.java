/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.DateChooserx;
import domain.Employee;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.filechooser.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import service.impl.RoleServiceImpl;
import javax.swing.JFileChooser;
import utils.ImageUtil;

/**
 *
 * @author Administrator
 */
public class QuanLyNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNhanVienn
     */
    private byte[] pertionImage;
    private EmployeeService empoyeesvier;
    private List<Employee> listmodel = new ArrayList<>();
    private EmployeeServiceImpl empolmpl = new EmployeeServiceImpl();
    private DefaultTableModel model = new DefaultTableModel();
    private DateChooserx datechooer;
    private Employee employeeSelected;

    public QuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        table.setModel(model);
        String herach[] = {"Id", "FullName", "GioiTinh", "Sdt"};
        model.setColumnIdentifiers(herach);
        empoyeesvier = new EmployeeServiceImpl();
        listmodel = empolmpl.findAll();
        dodate(listmodel);
        datechooer = new DateChooserx();
        datechooer.setTextRefernce(txtdate);
        setSize(1060, 610);
    }

    public void dodate(List<Employee> listshow) {
        model.setRowCount(0);
        for (Employee a : listshow) {
            model.addRow(a.toaddrow());
        }
    }

    public void click(int index) {
        Employee em = listmodel.get(index);
        txtsdt.setText(em.getPhoneNumber());
        txtbuffname.setText(em.getBufferName());
        txtfistname.setText(em.getFirstName());
        txtlastname.setText(em.getName());
        txtpassworld.setText(em.getPassword());
        txtusename.setText(em.getUsername());
        txtid.setText(em.getId() + "");
        txtemail.setText(em.getEmail());
        datechooer.setSelectedDate(em.getDateOfBirth());
        txtaddres.setText(em.getAddress());
        if (em.getGender()) {
            rdbtnMale.setSelected(true);
        } else {
            rdbtnFemale.setSelected(true);
        }

        long avataLenght = 0;

        try {
            if (em.getImage() != null) {
                avataLenght = em.getImage().length();
            }
        } catch (SQLException ex) {
            avataLenght = 0;
        }

        if (avataLenght == 0) {
            pertionImage = null;
            lblAvata.setIcon(null);
        } else {

            ImageIcon icon;
            try {
                icon = new ImageIcon(em.getImage().getBytes(1, (int) em.getImage().length()));
            } catch (SQLException ex) {
                ex.printStackTrace();
                icon = null;
            }
            Image image = ImageUtil.resize(icon.getImage(), 120, 150);
            try {
                pertionImage = ImageUtil.toByteArray(icon.getImage(), "jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            lblAvata.setIcon(new ImageIcon(image));
        }
    }

    public Employee getform() {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Employee empoly = null;
        if (employeeSelected == null) {
            empoly = new Employee();
        } else {
            empoly = employeeSelected;
        }

        empoly.setAddress(txtaddres.getText());
        empoly.setFirstName(txtfistname.getText());
        empoly.setBufferName(txtbuffname.getText());
        empoly.setName(txtlastname.getText());
        empoly.setUsername(txtusename.getText());
        empoly.setPassword(txtpassworld.getText());
        empoly.setPhoneNumber(txtsdt.getText());
        empoly.setGender(rdbtnMale.isSelected());
        empoly.setEmail(txtemail.getText());

        try {
            empoly.setDateOfBirth(date.parse(txtdate.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
            empoly.setDateOfBirth(null);
        }

        RoleServiceImpl roleServiceImpl = new RoleServiceImpl();
        roleServiceImpl.findAll().get(0).getId();
        empoly.setRole(roleServiceImpl.findAll().get(0));
        if (pertionImage != null) {
            try {
                Blob avata = new SerialBlob(pertionImage);
                empoly.setImage(avata);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return empoly;

    }

//        public Customer getform() {
//        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//        Customer cus = new Customer();
//        cus.setType(cusmoerselect.getType());
//        cus.setFirstName(txtfirtname.getText());
//        cus.setBufferName(txtbuffername.getText());
//        cus.setName(txtlastname.getText());
//        cus.setAddress(txtaddress.getText());
//        try {
//            cus.setDateOfBirth(date.parse(jTextField1.getText()));
//        } catch (ParseException ex) {
//            Logger.getLogger(khachhang.class.getName()).log(Level.SEVERE, null, ex);
//            cus.setDateOfBirth(null);
//        }
//        cus.setEmail(txtemail.getText());
//        cus.setPhoneNumber(txtphone.getText());
//        cus.setGender(male.isSelected());
//        //   cus.setImage(txtimg.getp);
//        return cus;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfistname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtbuffname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtlastname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdbtnMale = new javax.swing.JRadioButton();
        rdbtnFemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtusename = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpassworld = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        lblAvata = new javax.swing.JLabel();
        btnXoaAvata = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtaddres = new javax.swing.JTextField();
        txtid = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnChonAvata = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Id: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 20, -1));

        jLabel3.setText("Ho: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel3.add(txtfistname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 188, -1));

        jLabel4.setText("Ten Dem: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel3.add(txtbuffname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 188, -1));

        jLabel5.setText("Ten: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel3.add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 188, -1));

        jLabel6.setText("Gioi Tinh: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 11));

        buttonGroup1.add(rdbtnMale);
        rdbtnMale.setSelected(true);
        rdbtnMale.setText("Nam");
        jPanel3.add(rdbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, 20));

        buttonGroup1.add(rdbtnFemale);
        rdbtnFemale.setText("Nu");
        jPanel3.add(rdbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 20));

        jLabel7.setText("TK");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 30, -1));
        jPanel3.add(txtusename, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 240, 200, -1));

        jLabel8.setText("MK");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 30, -1));
        jPanel3.add(txtpassworld, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 280, 200, -1));

        jLabel9.setText("Sdt: ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 37, -1));
        jPanel3.add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 188, -1));

        lblAvata.setForeground(new java.awt.Color(255, 255, 102));
        lblAvata.setText("jLabel12");
        jPanel3.add(lblAvata, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 120, 150));

        btnXoaAvata.setText("Xóa");
        btnXoaAvata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAvataActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoaAvata, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 60, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 99, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/button_exit.png"))); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 99, 29));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 95, 29));

        jLabel13.setText("Ngay Sinh: ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 60, -1));
        jPanel3.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 186, -1));

        jLabel14.setText("Email: ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 43, -1));
        jPanel3.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 186, -1));

        jLabel15.setText("Dia Chi: ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));
        jPanel3.add(txtaddres, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 230, 180, -1));
        jPanel3.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 188, 22));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 95, 30));

        btnChonAvata.setText("Ch?n");
        btnChonAvata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAvataActionPerformed(evt);
            }
        });
        jPanel3.add(btnChonAvata, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 540, 430));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Danh Sach Nhân Viên");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tim Kiem"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/button_search.png"))); // NOI18N
        jButton1.setText("Search");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField9)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jButton7.setBackground(new java.awt.Color(153, 255, 102));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/button_last.png"))); // NOI18N

        jButton8.setBackground(new java.awt.Color(153, 255, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/first_button.png"))); // NOI18N

        jButton9.setBackground(new java.awt.Color(153, 255, 102));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/button_next.png"))); // NOI18N

        jButton10.setBackground(new java.awt.Color(153, 255, 102));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/button_next.png"))); // NOI18N

        jButton13.setText("Nhan Vien Da Xoa");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 51, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(166, 166, 166))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(jButton13)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(184, 184, 184))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton10)
                            .addComponent(jButton9)
                            .addComponent(jButton7))
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)))
                .addGap(369, 369, 369))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 0, 780, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thông Tin Nhân Viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chon dong can xoa");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Ban co muon xoa không");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            empoyeesvier.remove(UUID.fromString(txtid.getText()));
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            listmodel = empoyeesvier.findAll();
            dodate(listmodel);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "chon dong can sua");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Ban có muon sua khong");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Employee empoly = getform();

        empoly.setId(UUID.fromString(txtid.getText()));
        try {
            if (empoly.getAddress().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Dia Chi Null");
                return;
            }
            if (empoly.getBufferName().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ho Null");
                return;
            }
            if (empoly.getFirstName().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ten Dem Null");
                return;
            }
            if (empoly.getName().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name Null");
                return;
            }
            if (empoly.getPhoneNumber().isEmpty()) {
                JOptionPane.showMessageDialog(this, "So Dien Thoai Null");
                return;
            }
            if (empoly.getEmail().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email Null");
                return;
            }
            if (empoly.getUsername().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ten Dang Nhap Null");
                return;
            }
            if (empoly.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mat Khau Null");
                return;
            }
            empoyeesvier.update(empoly);
            JOptionPane.showMessageDialog(this, "Sua thanh công");
            listmodel = empoyeesvier.findAll();
            dodate(listmodel);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnXoaAvataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAvataActionPerformed
        pertionImage = null;
        lblAvata.setIcon(null);
    }//GEN-LAST:event_btnXoaAvataActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        Employee empoly = getform();
        if (empoly == null) {
            return;
        } else {
            try {
                if (empoly.getAddress().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Dia Chi Null");
                    return;
                }
                if (empoly.getBufferName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ho Null");
                    return;
                }
                if (empoly.getFirstName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ten Dem Null");
                    return;
                }
                if (empoly.getName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name Null");
                    return;
                }
                if (empoly.getPhoneNumber().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "So Dien Thoai Null");
                    return;
                }
                if (empoly.getEmail().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Email Null");
                    return;
                }
                if (empoly.getUsername().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ten Dang Nhap Null");
                    return;
                }
                if (empoly.getPassword().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Mat Khau Null");
                    return;
                }

                empoly.setId(null);
                empoyeesvier.insert(empoly);
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                listmodel = empoyeesvier.findAll();
                dodate(listmodel);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnChonAvataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAvataActionPerformed

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
                ImageIcon icon = new ImageIcon(file.getPath());
                Image image = ImageUtil.resize(icon.getImage(), 120, 150);
                ImageIcon imageIcon = new ImageIcon(image);
                try {
                    pertionImage = ImageUtil.toByteArray(icon.getImage(), "jpg");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                lblAvata.setIcon(imageIcon);
            } else {
                JOptionPane.showMessageDialog(this, "File không t?n t?i");
            }
        } else {
            return;
        }


    }//GEN-LAST:event_btnChonAvataActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row >= 0) {
            click(row);
        }
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChonAvata;
    private javax.swing.JButton btnXoaAvata;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblAvata;
    private javax.swing.JRadioButton rdbtnFemale;
    private javax.swing.JRadioButton rdbtnMale;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtaddres;
    private javax.swing.JTextField txtbuffname;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfistname;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtpassworld;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtusename;
    // End of variables declaration//GEN-END:variables
}
