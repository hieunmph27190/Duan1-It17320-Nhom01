package application;

import domain.Role;
import java.awt.EventQueue;
import java.util.List;
import repository.RoleRepository;
import utils.JpaUtil;
import view.ManHinhCho;

public class Main {
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
}
