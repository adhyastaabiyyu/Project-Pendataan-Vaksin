package GUI;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdminGui extends JFrame {

    MenuAdminGui(int id){
        init(id);
    }


    public void init(int id){
        setBounds(100, 100, 532, 534);
        AdminController admin = new AdminController();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLogout.setBounds(10, 10, 94, 32);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGui().setVisible(true);
                dispose();
            }
        });
        getContentPane().add(btnLogout);

        JButton btnDataData = new JButton("ADD DATA");
        btnDataData.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnDataData.setBackground(Color.green);
        btnDataData.setBounds(44, 143, 166, 74);
        getContentPane().add(btnDataData);

        btnDataData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisPendGui(id).setVisible(true);
            }
        });

        JButton btnUbahPassword = new JButton("UBAH PASSWORD");
        btnUbahPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnUbahPassword.setBackground(Color.green);
        btnUbahPassword.setBounds(44, 305, 166, 66);

        btnUbahPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String password = JOptionPane.showInputDialog("Masukan Password Baru");
                    if(password.length() > 0){
                        admin.updatePassword(password,id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        getContentPane().add(btnUbahPassword);

        JButton btnData= new JButton("DATA");
        btnData.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnData.setBackground(Color.green);
        btnData.setBounds(299, 143, 151, 74);
        getContentPane().add(btnData);
        
        btnData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DataPendGui(id).setVisible(true);
                dispose();
            }
        });

        JButton btnUbahNoTelp = new JButton("UBAH NO TELP");
        btnUbahNoTelp.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnUbahNoTelp.setBackground(Color.green);
        btnUbahNoTelp.setBounds(299, 305, 151, 66);

        btnUbahNoTelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String noTelp = JOptionPane.showInputDialog("Masukan NoTelp Baru");
                    if(noTelp.length() > 0){
                        admin.updateNoTelp(noTelp,id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });

        getContentPane().add(btnUbahNoTelp);

        setVisible(true);
    }

}
