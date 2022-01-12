package GUI;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdminGui extends JFrame {

    AdminController admin = new AdminController();

    LoginAdminGui() {
        init();
    }

    public void init(){
        
        setBounds(100, 100, 637, 351);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        JTextField FieldNIP = new JTextField();
         JPasswordField  FieldPassword = new JPasswordField();

        JLabel lblNIP = new JLabel("NIP");
        lblNIP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNIP.setBounds(10, 89, 91, 43);
        getContentPane().add(lblNIP);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPassword.setBounds(10, 148, 120, 57);
        getContentPane().add(lblPassword);

        JLabel lblAdmin = new JLabel("Login Admin");
        lblAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAdmin.setBounds(10, 10, 130, 54);
        getContentPane().add(lblAdmin);
        
        FieldNIP.setBounds(131, 98, 243, 29);
        getContentPane().add(FieldNIP);
        FieldNIP.setColumns(10);
        
        FieldPassword.setColumns(10);
        FieldPassword.setBounds(131, 164, 243, 29);
        getContentPane().add(FieldPassword);

        JButton btnLoginAdmin = new JButton("LOGIN");
        btnLoginAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnLoginAdmin.setBounds(180, 232, 150, 43);
        getContentPane().add(btnLoginAdmin);

        btnLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NIP = FieldNIP.getText();
                String Password = FieldPassword.getText();

                int cek = admin.login(NIP, Password);
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
}
