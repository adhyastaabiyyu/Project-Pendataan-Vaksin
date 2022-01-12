package GUI;

import Controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisAdminGui extends JFrame {
    
    AdminController admin = new AdminController();

    RegisAdminGui(){
        init();
    }

    public void init(){
        setBounds(100, 100, 617, 642);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        JTextField fieldNip = new JTextField();
        JTextField fieldNama = new JTextField();
        JTextField fieldAlamat = new JTextField();
        JTextField fieldPassword = new JTextField();
        JTextField fieldNoTelp = new JTextField();

        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnKembali.setBounds(10, 22, 106, 25);
        getContentPane().add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginGui().setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel = new JLabel("REGISTRASI");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(261, 69, 131, 32);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("NIP");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 169, 73, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("NAMA");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(10, 234, 73, 25);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("ALAMAT");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(10, 298, 106, 25);
        getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(10, 363, 106, 25);
        getContentPane().add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("NO TELP");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1_1.setBounds(10, 433, 106, 25);
        getContentPane().add(lblNewLabel_1_1_1_1_1);

        JButton btnRegAdmin = new JButton("REGISTRASI");
        btnRegAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnRegAdmin.setBounds(261, 515, 131, 39);
        getContentPane().add(btnRegAdmin);
        
        btnRegAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nip = fieldNip.getText();
                String Nama = fieldNama.getText();
                String Alamat = fieldAlamat.getText();
                String Password = fieldPassword.getText();
                String NoTelp = fieldNoTelp.getText();

                admin.insertData(Nip,Nama,Alamat,Password,NoTelp);
                JOptionPane.showMessageDialog(null, "Berhasil Ditambah");
                new LoginGui().setVisible(true);
                dispose();
            }
        });

        fieldNip.setBounds(231, 162, 199, 32);
        getContentPane().add(fieldNip);
        fieldNip.setColumns(10);
        
        fieldNama.setColumns(10);
        fieldNama.setBounds(231, 227, 199, 32);
        getContentPane().add(fieldNama);
        
        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(231, 291, 199, 32);
        getContentPane().add(fieldAlamat);
        
        fieldPassword.setColumns(10);
        fieldPassword.setBounds(231, 356, 199, 32);
        getContentPane().add(fieldPassword);
        
        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(231, 426, 199, 32);
        getContentPane().add(fieldNoTelp);
    }
}