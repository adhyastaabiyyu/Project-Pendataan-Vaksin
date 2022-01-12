package GUI;

import Controller.PendudukController;
import Entity.PendudukEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataPeroranganGui extends JFrame {
    String Nik,Nama,alamat,noTelp,dosis,jenisVaksin;
    int id;

    DataPeroranganGui(String nik, int id){
        init(nik);
    }

    public void init(String nik){

        PendudukController pendudukController = new PendudukController();



        for(PendudukEntity pendudukEntity : pendudukController.getDataPenduduk()){
            this.id = pendudukEntity.getId();
            this.Nik = pendudukEntity.getNik();
            this.Nama= pendudukEntity.getNama();
            this.alamat = pendudukEntity.getAlamat();
            this.noTelp = pendudukEntity.getNoTelp();
            this.dosis = pendudukEntity.getdosis();
            this.jenisVaksin = pendudukEntity.getjenisvaksin();
        }

        JTextField fieldNik = new JTextField();
        JTextField fieldNama = new JTextField();
        JTextField fieldAlamat = new JTextField();
        JTextField fieldNoTelp = new JTextField();
        JTextField fieldDosis = new JTextField();
        JTextField fieldJns_Vaksin = new JTextField();

        setBounds(100, 100, 707, 599);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnKembali = new JButton("Kembali");
        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnKembali.setBounds(10, 10, 110, 34);
        getContentPane().add(btnKembali);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DataPendGui(id).setVisible(true);
                dispose();
            }
        });

        JLabel lblNewLabel = new JLabel("NIK");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 107, 110, 39);
        getContentPane().add(lblNewLabel);

        fieldNik.setBounds(158, 115, 251, 27);
        fieldNik.setColumns(10);
        fieldNik.setText(this.Nik);
        fieldNik.setEditable(false);
        getContentPane().add(fieldNik);


        JLabel lblNewLabel_1 = new JLabel("NAMA");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 186, 83, 13);
        getContentPane().add(lblNewLabel_1);

        fieldNama.setColumns(10);
        fieldNama.setBounds(158, 172, 251, 27);
        fieldNama.setText(this.Nama);
        fieldNama.setEditable(false);
        getContentPane().add(fieldNama);

        JLabel lblNewLabel_2 = new JLabel("ALAMAT");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(10, 243, 110, 24);
        getContentPane().add(lblNewLabel_2);

        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(158, 240, 251, 27);
        fieldAlamat.setText(this.alamat);
        fieldAlamat.setEditable(false);
        getContentPane().add(fieldAlamat);

        JLabel lblNewLabel_3 = new JLabel("NO TELP");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(10, 306, 110, 27);
        getContentPane().add(lblNewLabel_3);

        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(158, 306, 251, 27);
        fieldNoTelp.setText(this.noTelp);
        fieldNoTelp.setEditable(false);
        getContentPane().add(fieldNoTelp);

        JLabel lblNewLabel_4 = new JLabel("DOSIS");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(10, 379, 110, 19);
        getContentPane().add(lblNewLabel_4);

        fieldDosis.setColumns(10);
        fieldDosis.setBounds(158, 371, 251, 27);
        fieldDosis.setText(this.dosis);
        fieldDosis.setEditable(false);
        getContentPane().add(fieldDosis);

        JLabel lblNewLabel_5 = new JLabel("JENIS VAKSIN");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(10, 435, 132, 27);
        getContentPane().add(lblNewLabel_5);

        fieldJns_Vaksin.setColumns(10);
        fieldJns_Vaksin.setBounds(158, 435, 251, 27);
        fieldJns_Vaksin.setText(this.jenisVaksin);
        fieldJns_Vaksin.setEditable(false);
        getContentPane().add(fieldJns_Vaksin);

        JButton btnUbahDosis = new JButton("Ubah");
        btnUbahDosis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnUbahDosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String dosis = JOptionPane.showInputDialog("Masukan Dosis Baru");
                    if(dosis.length() > 0){
                        pendudukController.updateDosis(dosis,id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                        fieldDosis.setText(dosis);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        btnUbahDosis.setBounds(470, 371, 103, 29);
        getContentPane().add(btnUbahDosis);

        JButton btnUbahNoTelp = new JButton("Ubah");
        btnUbahNoTelp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnUbahNoTelp.setBounds(470, 311, 103, 29);
        getContentPane().add(btnUbahNoTelp);

        btnUbahNoTelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String noTelp = JOptionPane.showInputDialog("Masukan NoTelp Baru");
                    if(noTelp.length() > 0){
                        pendudukController.updatenoTelp(noTelp, id);
                        JOptionPane.showMessageDialog(null,"Berhasil dirubah");
                        fieldNoTelp.setText(noTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
    }
}
