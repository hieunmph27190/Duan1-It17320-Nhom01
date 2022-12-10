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
public class QuenMatKhau extends javax.swing.JFrame {

    private Timer timerReSendEmail;
    private Timer timerCode;

    private String code;

    private Employee employee = null;
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public QuenMatKhau() {
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
        txtEmail = new javax.swing.JTextField();
        txtVerification = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnChangeThePassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSendCode = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText(" Change the password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Please enter your registered account and email for the account");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Username:");

        btnChangeThePassword.setBackground(new java.awt.Color(255, 204, 0));
        btnChangeThePassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChangeThePassword.setText("Change the password");
        btnChangeThePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeThePasswordActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Email:");

        btnSendCode.setBackground(new java.awt.Color(255, 204, 0));
        btnSendCode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSendCode.setText("SEND CODE");
        btnSendCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCodeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Verification:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("New password:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("Confirm password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChangeThePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtVerification, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendCode)
                        .addGap(5, 5, 5))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSendCode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChangeThePassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnChangeThePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeThePasswordActionPerformed

        String newPass = txtNewPassword.getText().trim();
        String confirmPass = txtConfirmPassword.getText().trim();

        if (newPass.equals(confirmPass)) {
            String code = txtVerification.getText().trim();
            if (code.equals(this.code)) {
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
                    JOptionPane.showMessageDialog(this, "Chua nhap Username ");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ma xac nhan khong chinh xac");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Confirm Password khong hop le");
        }


    }//GEN-LAST:event_btnChangeThePasswordActionPerformed

    private void btnSendCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCodeActionPerformed

        String username = txtUserName.getText().trim();
        try {
            employee = employeeService.findByUserName(username);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Username khong ton tai ");
        }
        String email = txtEmail.getText().trim();
        if (email.equals(employee.getEmail())) {
            int codeInt = (int) Math.ceil(Math.random() * 1000000);
            String codeString = String.valueOf(codeInt);
            for (int i = codeString.length(); i < 6; i++) {
                codeString = "0" + codeString;
            }
            code = codeString;
            String content = "Ma xac nhan lay lai mat khau\n Code: " + code + "\n Vui long khong cung cap ma cho nguoi khac";

            txtUserName.setEditable(false);
            txtEmail.setEditable(false);

            if (timerReSendEmail != null) {
                if (timerReSendEmail.isRunning()) {
                    JOptionPane.showMessageDialog(this, "Vui long cho 30s ");
                } else {
                    try {
                        SendEmailUtil.Send(SendEmailUtil.USERNAMEDEFAULT, SendEmailUtil.PASSWORDDEFAULT, email, "Xac nhan Email", content);

                        timerReSendEmail.start();
                        JOptionPane.showMessageDialog(this, "Da gui ma toi " + email);
                    } catch (RuntimeException ex) {
                        JOptionPane.showMessageDialog(this, "Loi gui Email ");
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(this, "Loi gui Email ");
                    }
                }
            } else {
                timerReSendEmail = new Timer(30000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                timerReSendEmail.setRepeats(false);
                try {
                    SendEmailUtil.Send(SendEmailUtil.USERNAMEDEFAULT, SendEmailUtil.PASSWORDDEFAULT, email, "Xac nhan Email", content);

                    timerReSendEmail.start();
                    JOptionPane.showMessageDialog(this, "Da gui ma toi " + email);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, "Loi gui Email ");
                } catch (MessagingException ex) {
                    JOptionPane.showMessageDialog(this, "Loi gui Email ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "UserName hoac Email khong hop le");
        }


    }//GEN-LAST:event_btnSendCodeActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeThePassword;
    private javax.swing.JButton btnSendCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNewPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtVerification;
    // End of variables declaration//GEN-END:variables
}
