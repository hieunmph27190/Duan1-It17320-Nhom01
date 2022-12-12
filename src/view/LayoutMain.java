package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import swing.ChucNangItem;
import swing.ImageAvatar;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class LayoutMain extends JFrame {

    private JPanel contentPane;
    private ImageAvatar avatar;
    private List<ChucNangItem> mapChucNang;
    private JPanel panelChucNang;
    private JPanel panelContent;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LayoutMain frame = new LayoutMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public LayoutMain() {
        setResizable(false);
        initComponents();
        cardLayout = (CardLayout) panelContent.getLayout();
        mapChucNang = new ArrayList<ChucNangItem>();

        mapChucNang.add(new ChucNangItem("Trang Chu",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")),
                new JPanel()));
        mapChucNang.add(new ChucNangItem(" Nhan vien",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new QuanLyNhanVien().getContentPane()));
        mapChucNang.add(new ChucNangItem(" San pham",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new QuanLiSanPham().getContentPane()));
        mapChucNang.add(new ChucNangItem(" Khach Hang",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new QLKhachHang().getContentPane()));
        //new JPanel()));
        mapChucNang.add(new ChucNangItem(" Ban Hang",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new BanHang().getContentPane()));
        //new JPanel()));
        mapChucNang.add(new ChucNangItem(" Hoa Don",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new QuanLiHoaDon().getContentPane()));
        //	new JPanel()));

        mapChucNang.add(new ChucNangItem(" Khuyen Mai",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")), (JPanel) new QuanLyKhuyenMai().getContentPane()));
              //  new JPanel()));

        mapChucNang.add(new ChucNangItem(" Doi Tra",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")),
                new JPanel()));
        mapChucNang.add(new ChucNangItem(" Thong Ke",
                new ImageIcon(
                        LayoutMain.class.getResource("/resources/icon/Actions-document-edit-icon-16.png")),(JPanel) new QuanLiThongKe().getContentPane()));
             //   new JPanel()));

        initChucNang();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1295, 680);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("New menu");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
        mnNewMenu.add(mntmNewMenuItem);

        JMenu mnNewMenu_1 = new JMenu("New menu");
        menuBar.add(mnNewMenu_1);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelMenu = new JPanel();
        panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelMenu.setBounds(0, 0, 200, 620);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);

        JPanel panelThongTinUser = new JPanel();
        panelThongTinUser
                .setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.ORANGE, Color.GREEN, Color.CYAN));
        panelThongTinUser.setBounds(0, 0, 200, 120);
        panelMenu.add(panelThongTinUser);
        panelThongTinUser.setLayout(null);

        avatar = new ImageAvatar();
        avatar.setImage(new ImageIcon(
                LayoutMain.class.getResource("/resources/image/pngtree-casual-shoes-png-image_2394294.jpg")));
        avatar.setBounds(5, 5, 85, 85);
        panelThongTinUser.add(avatar);

        JLabel lblName = new JLabel("Giao Dien Ban Giay");
        lblName.setForeground(new Color(255, 153, 0));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(10, 95, 180, 20);
        panelThongTinUser.add(lblName);

        JLabel lblRole = new JLabel("Nhan Vien");
        lblRole.setForeground(Color.ORANGE);
        lblRole.setHorizontalAlignment(SwingConstants.CENTER);
        lblRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRole.setBounds(100, 11, 90, 20);
        panelThongTinUser.add(lblRole);

        panelChucNang = new JPanel();
        panelChucNang.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelChucNang.setBounds(0, 125, 200, 490);
        panelMenu.add(panelChucNang);
        GridBagLayout gbl_panelChucNang = new GridBagLayout();
        gbl_panelChucNang.columnWidths = new int[]{188};
        gbl_panelChucNang.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 40, 0};
        gbl_panelChucNang.columnWeights = new double[]{0.0};
        gbl_panelChucNang.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        panelChucNang.setLayout(gbl_panelChucNang);

        panelContent = new JPanel();
        panelContent.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelContent.setBounds(210, 5, 1060, 610);
        contentPane.add(panelContent);
        panelContent.setLayout(new CardLayout(0, 0));
        setLocationRelativeTo(null);

    }

    private void clearSelectedChucNang() {
        for (ChucNangItem entry : mapChucNang) {
            entry.getButtonCN().setBackground(new Color(240, 240, 240));
        }
    }

    private void initChucNang() {
        int i = 0;
        for (ChucNangItem val : mapChucNang) {
            JButton btnNewButton_1 = new JButton(val.getLabel());
            btnNewButton_1.setBackground(new Color(240, 240, 240));
            btnNewButton_1.setHorizontalTextPosition(SwingConstants.RIGHT);
            btnNewButton_1.setIcon(val.getIcon());
            btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnNewButton_1.setFocusPainted(false);
            GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
            gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
            gbc_btnNewButton_1.insets = new Insets(5, 0, 0, 0);
            gbc_btnNewButton_1.gridx = 0;
            gbc_btnNewButton_1.gridy = i;
            panelChucNang.add(btnNewButton_1, gbc_btnNewButton_1);
            panelContent.add(val.getPanelContent(), val.getLabel());
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearSelectedChucNang();
                    cardLayout.show(panelContent, val.getLabel());
                    btnNewButton_1.setBackground(new Color(192, 192, 192));
                }
            });
            val.setButtonCN(btnNewButton_1);
            i++;
        }
    }
}
