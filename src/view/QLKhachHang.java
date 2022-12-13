/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.DateChooserx;
import domain.Customer;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import utils.ImageUtil;

/**
 *
 * @author Administrator
 */
public class QLKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form khachhang
     */
    private CustomerService custormer;
    DefaultTableModel model = new DefaultTableModel();
    private List<Customer> listmodel = new ArrayList<>();
    private CustomerServiceImpl custoermpl = new CustomerServiceImpl();
    private DateChooserx datechooer;
    private Customer cusmoerselect;
    private String duongDanAnh = "";
    private byte[] pertionImage;

    public QLKhachHang() {
        initComponents();

        table.setModel(model);
        String hearch[] = {"id", "FullName", "Gender", "Address", "Email", "PhoneNumber", "Date"};
        model.setColumnIdentifiers(hearch);
        listmodel = custoermpl.getKH();
        custormer = new CustomerServiceImpl();
        doddate(custormer.getKH());
        datechooer = new DateChooserx();
        datechooer.setTextRefernce(jTextField1);
        setSize(1060, 610);
        setLocationRelativeTo(null);

    }

    public void doddate(List<Customer> listshow) {
        model.setRowCount(0);
        for (Customer a : listshow) {
            model.addRow(a.toaddrow());
        }
    }

    public void clear() {
        txtaddress.setText("");
        txtbuffername.setText("");
        txtfirtname.setText("");
        lblanh.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtid.setText("");
        txtlastname.setText("");
        jTextField1.setText("");
    }

    public Customer getform() {

        if (txtaddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dia Chi Null");
            return null;
        }

        if (txtbuffername.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ho Null");
            return null;
        }

        if (txtfirtname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten Dem Null");
            return null;
        }

        if (txtlastname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name Null");
            return null;
        }

        if (txtemail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email Null");
            return null;
        }

        if (txtphone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "So Dien Thoai Null");
            return null;
        }

        if (male.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gioi Tinh Null");
            return null;
        }

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Customer cus = new Customer();
        if (cusmoerselect != null) {
            cus.setType(cusmoerselect.getType());
        }
        cus.setFirstName(txtfirtname.getText());
        cus.setBufferName(txtbuffername.getText());
        cus.setName(txtlastname.getText());
        cus.setAddress(txtaddress.getText());
        try {
            cus.setDateOfBirth(date.parse(jTextField1.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(QLKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            cus.setDateOfBirth(null);
        }
        cus.setEmail(txtemail.getText());
        cus.setPhoneNumber(txtphone.getText());
        cus.setGender(male.isSelected());

        if (pertionImage != null) {
            try {
                Blob avata = new SerialBlob(pertionImage);
                cus.setImage(avata);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cus;
    }

    public void click(int index) {
        Customer cuss = listmodel.get(index);
        cusmoerselect = cuss;
        txtfirtname.setText(cuss.getFirstName());
        txtbuffername.setText(cuss.getBufferName());
        txtemail.setText(cuss.getEmail());
        txtid.setText(cuss.getId() + "");
        txtphone.setText(cuss.getPhoneNumber());
        txtlastname.setText(cuss.getName());
        txtaddress.setText(cuss.getAddress());
        jTextField1.setText(cuss.getDateOfBirth() + "");
        
         long avataLenght = 0;
        
        try {
            if(cuss.getImage() !=null) {
             avataLenght = cuss.getImage().length();
            }
        } catch (SQLException ex) {
            avataLenght = 0;
        }

        if (avataLenght == 0) {
            pertionImage = null;
            lblanh.setIcon(null);
        } else {

            ImageIcon icon;
            try {
                icon = new ImageIcon(cuss.getImage().getBytes(1, (int) cuss.getImage().length()));
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
            lblanh.setIcon(new ImageIcon(image));
        }
        
    }

    // Date datee = (Date) table.getValueAt(row, 8);
//            datechooer.setSelectedDate(datee);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        ADD = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtfirtname = new javax.swing.JTextField();
        txtbuffername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtlastname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        txtid = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 145));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Quan Ly Khach Hang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 238, -1));

        jLabel3.setText("Id: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel4.setText("Ho: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        male.setSelected(true);
        male.setText("Nam");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, -1));

        female.setText("Nu");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, -1, -1));

        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/new-icon-16.png"))); // NOI18N
        ADD.setText("Add");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        getContentPane().add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 90, -1));

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Button-Close-icon-16.png"))); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 90, -1));

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        getContentPane().add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 90, -1));

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

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
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 340, 950, 230));
        getContentPane().add(txtfirtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 240, -1));
        getContentPane().add(txtbuffername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));

        jLabel5.setText("Ten Dem: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel10.setText("So Dien Thoai: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 84, -1));

        jLabel6.setText("Ten: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));
        getContentPane().add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 240, -1));

        jLabel7.setText("Gioi Tinh: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, 20));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 220, -1));

        jLabel9.setText("Email: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 37, -1));
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 220, -1));

        jLabel11.setText("Ngay Sinh: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 80, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 240, -1));

        jLabel12.setText("Dia Chi: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 58, -1));

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 240, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 240, 20));

        lblanh.setText("Anh");
        getContentPane().add(lblanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 120, 130));

        jButton1.setText("Chon Anh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        jButton2.setText("XoaAvata");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 90, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:
        Customer cuss = getform();
        if (cuss == null) {
            return;

        } else {
            try {
                if (cuss.getAddress().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Dia Chi Null");
                    return;
                }

                if (cuss.getBufferName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ho Null");
                    return;
                }

                if (cuss.getFirstName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ten Dem Null");
                    return;
                }

                if (cuss.getName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name Null");
                    return;
                }

                if (cuss.getEmail().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Email Null");
                    return;
                }

                if (cuss.getPhoneNumber().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "So Dien Thoai Null");
                    return;
                }

                if (cuss.getGender().equals("")) {
                    JOptionPane.showMessageDialog(this, "Gioi Tinh Null");
                    return;
                }

                custormer.insert(cuss);
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                listmodel = custormer.getKH();
                doddate(listmodel);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_ADDActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
        int row = table.getSelectedRow();
        if(row < 0) {
            return;
        }
        
        click(row);

    }//GEN-LAST:event_tableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
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
        Customer cus = getform();

        cus.setId(UUID.fromString(txtid.getText()));
        try {

            custormer.update(cus);
            JOptionPane.showMessageDialog(this, "Sua thanh công");
            listmodel = custormer.getKH();
            doddate(listmodel);
            //   clearForm();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
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
            custormer.setType(UUID.fromString(txtid.getText()), 0);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
            doddate(custormer.getKH());

        } catch (Exception ex) {
          ex.printStackTrace();
        }

    }//GEN-LAST:event_DeleteActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_ClearActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

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
                lblanh.setIcon(imageIcon);
            } else {
                JOptionPane.showMessageDialog(this, "File không Ton Tai");
            }
        } else {
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pertionImage = null;
        lblanh.setIcon(null);

    }//GEN-LAST:event_jButton2ActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKhachHang().setVisible(true);
            }
        });
    }

    private ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(130, 140, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JRadioButton male;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbuffername;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirtname;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
