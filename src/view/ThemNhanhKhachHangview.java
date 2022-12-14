/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.DateChooserx;
import domain.Customer;
import domain.Employee;
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
import utils.JpaUtil;

/**
 *
 * @author Administrator
 */
public class ThemNhanhKhachHangview extends javax.swing.JDialog {

    /**
     * Creates new form ThemNhanhKhachHangview
     */
    private CustomerService custormer;
    DefaultTableModel model = new DefaultTableModel();
    private List<Customer> listmodel = new ArrayList<>();
    private CustomerServiceImpl custoermpl = new CustomerServiceImpl();
    private DateChooserx datechooer;
    private Customer cusmoerselect;
    private String duongDanAnh = "";
    private byte[] pertionImage;
    private java.awt.Frame parent;

    public ThemNhanhKhachHangview(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;

        String hearch[] = {"id", "FullName", "Gender", "Address", "Email", "PhoneNumber", "Date"};
        model.setColumnIdentifiers(hearch);
        listmodel = custoermpl.getKH();
        custormer = new CustomerServiceImpl();
        doddate(custormer.getKH());
        datechooer = new DateChooserx();
        datechooer.setTextRefernce(jTextField1);
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
            if (cuss.getImage() != null) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        ADD = new javax.swing.JButton();
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
        txtid = new javax.swing.JLabel();
        lblanh = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Khach Hang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 140, -1));

        jLabel3.setText("Id: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 20));

        jLabel4.setText("Ho: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 70, 20));

        male.setSelected(true);
        male.setText("Nam");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        female.setText("Nu");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, -1));

        ADD.setText("OK");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });
        getContentPane().add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 80, 30));
        getContentPane().add(txtfirtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, -1));
        getContentPane().add(txtbuffername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 247, -1));

        jLabel5.setText("Ten Dem: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel10.setText("So Dien Thoai: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 84, 20));

        jLabel6.setText("Ten: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 60, 20));
        getContentPane().add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 247, -1));

        jLabel7.setText("Gioi Tinh: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 70, 20));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 230, -1));

        jLabel9.setText("Email: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 80, 20));
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 230, -1));

        jLabel11.setText("Ngay Sinh: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 247, -1));

        jLabel12.setText("Dia Chi: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 58, 20));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 250, 20));

        lblanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 120, 160));

        jButton1.setText("Chon Anh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 100, 30));

        jButton2.setText("Xoa Anh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 100, 30));

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 226, 250, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed

        Customer cuss = getform();
        if (cuss == null) {
            return;

        } else {
            try {
                
                
                if (cuss.getName().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Name Null");
                    return;
                }

                if (!cuss.getEmail().matches(".+@[a-z]+\\.[a-z]+")) {
                    JOptionPane.showMessageDialog(this, "Email Khong Hop Le");
                    return;
                }
                if (!cuss.getPhoneNumber().matches("0[0-9]{9}")) {
                    JOptionPane.showMessageDialog(this, "So Dien Thoai Khong Hop Le");
                    return;
                }

                custormer.insert(cuss);
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                JpaUtil.getEntityManager();
                listmodel = custormer.getKH();
                doddate(listmodel);
                try {
                    BanHang bhdiag = (BanHang) this.parent;
                    bhdiag.selecttedcustomor(cuss);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
                JOptionPane.showMessageDialog(this, "File không t?n t?i");
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
            java.util.logging.Logger.getLogger(ThemNhanhKhachHangview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhKhachHangview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhKhachHangview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhanhKhachHangview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNhanhKhachHangview dialog = new ThemNhanhKhachHangview(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ADD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtbuffername;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirtname;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
