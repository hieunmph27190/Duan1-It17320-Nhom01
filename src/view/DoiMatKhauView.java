/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;
import utils.SendEmailUtil;

/**
 *
 * @author haanh
 */
public class DoiMatKhauView extends javax.swing.JFrame {

    private Timer timerReSendEmail;
    private Timer timerCode;

    private String code;

    private Employee employee = null;
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public DoiMatKhauView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnChangeThePassword = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 270, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 270, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doi mat khau");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 180, 30));
        getContentPane().add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 270, -1));
        getContentPane().add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 270, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Username:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 20));

        btnChangeThePassword.setBackground(new java.awt.Color(255, 204, 0));
        btnChangeThePassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChangeThePassword.setText("Change the password");
        btnChangeThePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeThePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnChangeThePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 183, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("New password:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Confirm password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeThePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeThePasswordActionPerformed
        String passWord = txtPassword.getText().trim();
        String userName = txtUserName.getText().trim();
        String newPass = txtNewPassword.getText().trim();
        String confirmPass = txtConfirmPassword.getText().trim();
        try {
            employee = employeeService.findByUserNamePassWord(userName, passWord);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thong tin tai khoan mat khau khong chinh xac");
            return;
        }
        if (newPass.equals(confirmPass)) {
            if (employee != null) {
                try {
                    employeeService.changePassword(employee.getId(), newPass);
                    Dangnhap dn = new Dangnhap();
                    dn.setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Loi ");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Thong tin tai khoan mat khau khong chinh xac");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Confirm Password khong hop le");
        }


    }//GEN-LAST:event_btnChangeThePasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeThePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtNewPassword;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
