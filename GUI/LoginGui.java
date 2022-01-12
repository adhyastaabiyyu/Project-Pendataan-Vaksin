package GUI;

import Controller.AdminController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginGui extends JFrame {
    public LoginGui(){
        init();
    }
    public void init(){

        AdminController admin = new AdminController();
        String pathicon = "./src/Gambar/Admin png.png";
        
        JTextField fieldNip = new JTextField();
        JPasswordField fieldPass = new JPasswordField();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel bingkaigambar = new JLabel();
        bingkaigambar.setBounds(80,70,150,150);
        add(bingkaigambar);

        BufferedImage bufferedImage = null;
        Image gambarresize;


        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        gambarresize = bufferedImage.getScaledInstance(150, 150,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));

        JLabel lblNewLabel = new JLabel("NIP");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel.setBounds(35, 250, 40, 25);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel_1.setBounds(35, 290, 80, 25);
        getContentPane().add(lblNewLabel_1);
        
        fieldNip.setBounds(130, 250, 130, 25);
        getContentPane().add(fieldNip);
        fieldNip.setColumns(10);

        fieldPass.setColumns(10);
        fieldPass.setBounds(130, 290, 130, 25);
        getContentPane().add(fieldPass);

        JButton btnAddAdmin = new JButton("REGISTRASI ADMIN");
        btnAddAdmin.setBackground(new Color(240, 240, 240));
        btnAddAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnAddAdmin.setBounds(70, 400, 180, 25);
        getContentPane().add(btnAddAdmin);

        btnAddAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisAdminGui().setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel_2 = new JLabel("LOGIN ADMIN");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 10, 109, 13);
        getContentPane().add(lblNewLabel_2);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLogin.setBounds(110, 350, 100, 25);
        getContentPane().add(btnLogin);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nip = fieldNip.getText();
                String Password = fieldPass.getText();

                int cek = admin.login(nip, Password);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    new MenuAdminGui(cek).setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
}


    public static void main(String[] args) {
        LoginGui init = new LoginGui();
    }

}
