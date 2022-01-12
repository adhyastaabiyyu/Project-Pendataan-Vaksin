package GUI;

import Controller.PendudukController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisPendGui extends JFrame {

    PendudukController Penduduk = new PendudukController();

    RegisPendGui(int id){
        init(id);
    }

    public void init(int id){
        setBounds(100, 100, 526, 597);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JTextField fieldNIK = new JTextField();
        JTextField fieldNama = new JTextField();
        JTextField fieldAlamat = new JTextField();
        JTextField fieldNoTelp = new JTextField();
        JTextField fieldDosis = new JTextField();
        JTextField fieldJns_Vaksin = new JTextField();
        
        JButton btnKembali = new JButton("Kembali");
        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnKembali.setBounds(10, 10, 110, 34);
        getContentPane().add(btnKembali);
        
         btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdminGui(id).setVisible(true);
                dispose();
            }
        });

        JLabel lblNama = new JLabel("Nama");
        lblNama.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNama.setBounds(10, 142, 107, 50);
        getContentPane().add(lblNama);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblAlamat.setBounds(10, 204, 107, 50);
        getContentPane().add(lblAlamat);

        JLabel lblNotelp = new JLabel("NoTelp");
        lblNotelp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNotelp.setBounds(10, 272, 107, 50);
        getContentPane().add(lblNotelp);

        JLabel lblDosis = new JLabel("Dosis");
        lblDosis.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblDosis.setBounds(10, 342, 107, 50);
        getContentPane().add(lblDosis);

        JLabel lblJenisVaksin = new JLabel("Jenis Vaksin");
        lblJenisVaksin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblJenisVaksin.setBounds(10, 409, 107, 50);
        getContentPane().add(lblJenisVaksin);

        JLabel lblNik = new JLabel("NIK");
        lblNik.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNik.setBounds(10, 81, 107, 50);
        getContentPane().add(lblNik);

        fieldNIK.setColumns(10);
        fieldNIK.setBounds(184, 93, 286, 31);
        getContentPane().add(fieldNIK);

        fieldNama.setColumns(10);
        fieldNama.setBounds(184, 154, 286, 31);
        getContentPane().add(fieldNama);

        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(184, 216, 286, 31);
        getContentPane().add(fieldAlamat);

        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(184, 284, 286, 31);
        getContentPane().add(fieldNoTelp);

        fieldDosis.setColumns(10);
        fieldDosis.setBounds(184, 354, 286, 31);
        getContentPane().add(fieldDosis);

        fieldJns_Vaksin.setColumns(10);
        fieldJns_Vaksin.setBounds(184, 421, 286, 31);
        getContentPane().add(fieldJns_Vaksin);

        JLabel lblPen = new JLabel("REGISTRASI PENDUDUK");
        lblPen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPen.setBounds(212, 27, 242, 42);
        getContentPane().add(lblPen);

        JButton btnRegPend = new JButton("REGISTRASI");
        btnRegPend.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRegPend.setBackground(Color.green);
        btnRegPend.setBounds(254, 491, 173, 42);
        getContentPane().add(btnRegPend);

        btnRegPend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NIK = fieldNIK.getText();
                String Nama = fieldNama.getText();
                String Alamat = fieldAlamat.getText();
                String NoTelp = fieldNoTelp.getText();
                String Dosis = fieldDosis.getText();
                String Jns_Vaksin = fieldJns_Vaksin.getText();

                Penduduk.insertData(NIK,Nama,Alamat,NoTelp,Dosis,Jns_Vaksin);
                JOptionPane.showMessageDialog(null, "Berhasil Ditambah");
                new MenuAdminGui(id).setVisible(true);
                dispose();
            }
        });
    }
}
