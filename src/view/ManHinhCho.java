package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.JpaUtil;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ManHinhCho extends JFrame {
    
    private JPanel contentPane;
    private JProgressBar phamtram;
    private JLabel lbl;
    private JLabel lblPhanTram;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManHinhCho frame = new ManHinhCho();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManHinhCho() {
        setLocationRelativeTo(null);
        initComponents();
        start();
    }
    
    public void start() {        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean isStartConnect = false;
                Thread connect = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JpaUtil.getEntityManager();
                    }
                });
                int i = 1;
                while (true) {
                    try {
                        i++;
                        lblPhanTram.setText(i + " %");
                        phamtram.setValue(i);
                        if (i >= 20 && i < 30) {
                            lbl.setText("Vui long cho ...");
                        } else if (i < 80) {
                            lbl.setText("Dang ket noi voi co so du lieu ...");
                            if (!isStartConnect) {
                                connect.start();
                                isStartConnect = true;
                            } else {
                                if (connect.isAlive()) {
                                    Thread.sleep(20);
                                } else {
                                    i += 4;
                                }
                            }
                        } else if (i < 100) {
                            lbl.setText("Hoan tat ...");
                        } else {
                            new Dangnhap().setVisible(true);
                            ManHinhCho.this.dispose();
                            break;
                        }
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        });
        t.start();
    }
    
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 596, 459);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel jLabel1 = new JLabel();
        jLabel1.setIcon(new ImageIcon(
                ManHinhCho.class.getResource("/resources/image/pngtree-casual-shoes-png-image_2394294.jpg")));
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        jLabel1.setBounds(10, 45, 562, 290);
        contentPane.add(jLabel1);
        
        phamtram = new JProgressBar();
        phamtram.setForeground(new Color(255, 200, 0));
        phamtram.setBounds(10, 379, 562, 29);
        contentPane.add(phamtram);
        
        lbl = new JLabel();
        lbl.setText("Xin ch??? ....");
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setBounds(20, 353, 284, 20);
        contentPane.add(lbl);
        
        lblPhanTram = new JLabel("");
        lblPhanTram.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPhanTram.setBounds(500, 350, 59, 29);
        contentPane.add(lblPhanTram);
    }
}
